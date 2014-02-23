package org.asal.jac.dao;

import java.util.Collection;

import org.asal.jac.domain.Chanson;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ChansonDaoImpl implements ChansonDao {

	
	private SessionFactory sessionFactory;
	

	
	public ChansonDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public void setSessionFactory(SessionFactory s){
		//Configuration cfg= new Configuration();
		this.sessionFactory=s;
	}
	
	@Override
	public Collection<Chanson> findAllChanson() {
		// TODO Auto-generated method stub
		
		return sessionFactory.getCurrentSession().createQuery("from Chanson").list();
	}

	@Override
	public Chanson findAlbum(Integer id) {
		// TODO Auto-generated method stub
		return (Chanson) this.sessionFactory.getCurrentSession().get(Chanson.class, id);
	}

	@Override
	public void createAlbum(Chanson ch) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(ch);
	}

}
