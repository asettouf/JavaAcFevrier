package org.asal.jac.service;

import java.util.Collection;

import org.asal.jac.dao.ArtisteDao;
import org.asal.jac.domain.Artiste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ArtisteService {

	@Autowired
	private ArtisteDao aDao;
	
	public ArtisteService() {
		// TODO Auto-generated constructor stub
	}
	
	public Collection<Artiste> findAllArtiste(){
		return aDao.findAllArtiste();
	}

	public void createArtiste(Artiste art){
		aDao.createArtiste(art);
	}
	
	public Artiste findArtiste(int id){
		return aDao.findArtiste(id);
	}
}
