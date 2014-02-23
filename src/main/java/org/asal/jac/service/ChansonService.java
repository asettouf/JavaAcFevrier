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
		return cDao.findAlbum(num);
	}
	
	public void createChanson(Chanson c){
		cDao.createAlbum(c);
	}
}
