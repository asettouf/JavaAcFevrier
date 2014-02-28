package org.asal.jac.dao;

import java.util.Collection;

import org.asal.jac.domain.Chanson;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ChansonDaoImpl implements ChansonDao {

	
	private static SessionFactory sessionFactory;
	

	
	public ChansonDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public void setSessionFactory(SessionFactory s){
		//Configuration cfg= new Configuration();
		this.sessionFactory=s;
	}
	
	
	public static Chanson findChansonByName(String name){
		Query q=sessionFactory.getCurrentSession().createQuery("from Chanson C Where C.nom=:name");
		q.setString("name",name);
		return (Chanson) q.uniqueResult();
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
		if(ch.getAlbum()!=null){
			sessionFactory.getCurrentSession().save(ch.getAlbum());
		}
		sessionFactory.getCurrentSession().save(ch);
	}
	
	public void deleteChanson(Chanson ch){
		Chanson c=(Chanson) sessionFactory.getCurrentSession().get(Chanson.class,this.findChansonByName(ch.getNom()).getId());
		if (c!=null){
			System.out.println(c.getNom());
			sessionFactory.getCurrentSession().delete(c);
		}
		
		else{
			System.out.println("Song not found");
		}
		
	}
	
	public void updateChanson(Chanson ch){
		Chanson c=(Chanson) sessionFactory.getCurrentSession().get(Chanson.class,this.findChansonByName(ch.getNom()).getId());
		c.setNom(ch.getNom());
		c.setDuree(ch.getDuree());
		c.setCodeChanson(ch.getCodeChanson());
		this.sessionFactory.getCurrentSession().merge(c);
	}

}
