package org.asal.jac.service;

import java.util.Collection;

import org.asal.jac.dao.ChansonDao;
import org.asal.jac.domain.Chanson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChansonService {

	@Autowired
	private ChansonDao cDao;
	
	public ChansonService() {
		// TODO Auto-generated constructor stub
	}

	public Collection<Chanson> findAllChanson(){
		return cDao.findAllChanson();
	}
	
	public Chanson findChanson(int num){
		return cDao.findChanson(num);
	}
	
	public void createChanson(Chanson c){
		cDao.createChanson(c);
	}
	
	public void deleteChanson(Chanson c){
		cDao.deleteChanson(c);
	}
	
	public void updateChanson(Chanson c){
		cDao.updateChanson(c);
	}
}
