package org.asal.jac.dao;

import java.util.Collection;

import org.asal.jac.domain.Album;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumDaoImpl implements AlbumDao {

	private SessionFactory sessionFactory;

	public AlbumDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public void setSessionFactory(SessionFactory s){
		//Configuration cfg= new Configuration();
		this.sessionFactory=s;
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
		sessionFactory.getCurrentSession().save(alb);
		
	}

}
