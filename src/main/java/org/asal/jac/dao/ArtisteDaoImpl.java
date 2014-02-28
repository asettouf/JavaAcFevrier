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
public class ArtisteDaoImpl implements ArtisteDao {

	private static SessionFactory sessionFactory;
	
	public ArtisteDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory s){
		//Configuration cfg= new Configuration();
		this.sessionFactory=s;
	}
	
	public static Artiste findArtisteByName(String name){
		Query q=sessionFactory.getCurrentSession().createQuery("from Artiste A Where A.nom=:name");
		q.setString("name",name);
		return (Artiste) q.uniqueResult();
	}

	@Override
	public Collection<Artiste> findAllArtiste() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Artiste").list();
	}

	@Override
	public Artiste findArtiste(Integer id) {
		// TODO Auto-generated method stub
		return (Artiste) this.sessionFactory.getCurrentSession().get(Artiste.class, id);
	}

	@Override
	public void createArtiste(Artiste art) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(art);
		
	}

	@Override
	public void delArtiste(Artiste art) {
		// TODO Auto-generated method stub
		Artiste a=(Artiste) sessionFactory.getCurrentSession().get(Artiste.class,findArtisteByName(art.getNom()).getId());
		if (a!=null){
			sessionFactory.getCurrentSession().delete(a);
		}
		else{
			System.out.println("Artiste not found");
		}
	}

	@Override
	public void upArtiste(Artiste art) {
		// TODO Auto-generated method stub
		Artiste a=(Artiste) sessionFactory.getCurrentSession().get(Artiste.class,art.getId());
		if (a!=null){
			if (art.getNom()!=a.getNom())
				a.setNom(art.getNom());
			if (art.getCodeArtiste()!=a.getCodeArtiste())
				a.setCodeArtiste(art.getCodeArtiste());
			sessionFactory.getCurrentSession().merge(a);
		}
		
		else
			System.out.println("Artiste not found");
	}
		
}


