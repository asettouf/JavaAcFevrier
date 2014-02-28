package org.asal.jac.dao;

import java.util.Collection;

import org.asal.jac.domain.Album;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
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
		if (alb.getArt()!=null){
			sessionFactory.getCurrentSession().save(alb.getArt());
		}
		sessionFactory.getCurrentSession().save(alb);
		
	}
	
	public void updateAlbum(Album alb){
		this.sessionFactory.getCurrentSession().merge(alb);
	}

}
