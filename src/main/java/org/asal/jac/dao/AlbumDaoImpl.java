package org.asal.jac.dao;

import java.util.Collection;

import org.asal.jac.domain.Album;
import org.asal.jac.domain.Artiste;
import org.asal.jac.domain.Chanson;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class AlbumDaoImpl implements AlbumDao {

	private static SessionFactory sessionFactory;

	public AlbumDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public void setSessionFactory(SessionFactory s){
		//Configuration cfg= new Configuration();
		this.sessionFactory=s;
	}
	
	public static Album findAlbumByName(String name){
		Query q=sessionFactory.getCurrentSession().createQuery("from Album A Where A.nom=:name");
		q.setString("name",name);
		return (Album) q.uniqueResult();
	}
	
	@Override
	public Collection<Album> findAllAlbum() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Album").list();
	}

	@Override
	public Album findAlbum(Integer id) {
		// TODO Auto-generated method stub
		return (Album) this.sessionFactory.getCurrentSession().get(Album.class, id);
	}

	@Override
	public void createAlbum(Album alb) {
		// TODO Auto-generated method stub
		if (alb.getArt()!=null){
			if (ArtisteDaoImpl.findArtisteByName(alb.getArt().getNom())==null){
				sessionFactory.getCurrentSession().save(alb.getArt());
				
			}
			else{
				Artiste tmp=(Artiste) ArtisteDaoImpl.findArtisteByName(alb.getArt().getNom());
			//	alb.setARTISTEID(tmp.getId());
				alb.setArt(tmp);
			}
			
			sessionFactory.getCurrentSession().save(alb);
				
		}
		
		
	}
	


	@Override
	public void delAlbum(Album alb) {
		Album a=(Album) sessionFactory.getCurrentSession().get(Album.class, findAlbumByName(alb.getNom()).getId());
		if (a!=null){
			sessionFactory.getCurrentSession().delete(a);
		}
		else{
			System.out.println("Album not found");
		}
		
	}

	@Override
	public void upAlbum(Album alb) {
		Album a=(Album) sessionFactory.getCurrentSession().get(Album.class,alb.getId());
		if (a!=null){
			if (alb.getNom()!=a.getNom())
				a.setNom(alb.getNom());
			if (alb.getCodeAlbum()!=a.getCodeAlbum())
				a.setCodeAlbum(alb.getCodeAlbum());
			sessionFactory.getCurrentSession().merge(a);
		}
		
		else
			System.out.println("Album not found");
		}


}
