package org.asal.jac.dao;

import java.util.Collection;

import org.asal.jac.domain.Artiste;
import org.asal.jac.domain.Chanson;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtisteDaoImpl implements ArtisteDao {

	private SessionFactory sessionFactory;
	
	public ArtisteDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory s){
		//Configuration cfg= new Configuration();
		this.sessionFactory=s;
	}

	@Override
	public Collection<Artiste> findAllArtiste() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Artiste").list();
	}

	@Override
	public Artiste findAlbum(Integer id) {
		// TODO Auto-generated method stub
		return (Artiste) this.sessionFactory.getCurrentSession().get(Artiste.class, id);
	}

	@Override
	public void createAlbum(Artiste art) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(art);
		
	}

}
