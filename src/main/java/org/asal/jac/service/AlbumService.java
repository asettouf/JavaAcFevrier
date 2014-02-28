package org.asal.jac.service;

import java.util.Collection;

import org.asal.jac.dao.AlbumDao;
import org.asal.jac.domain.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AlbumService {

	@Autowired
	private AlbumDao aDao;
	
	public AlbumService() {
		// TODO Auto-generated constructor stub
	}
	
	public Collection<Album> findAllAlbum() {
		// TODO Auto-generated method stub
		return aDao.findAllAlbum();
	}


	public Album findAlbum(Integer id) {
		// TODO Auto-generated method stub
		return (Album) aDao.findAlbum(id);
	}

	
	public void createAlbum(Album alb) {
		// TODO Auto-generated method stub
		aDao.createAlbum(alb);
		
	}
	
	public void delAlbum(Album alb){
		aDao.delAlbum(alb);
	}
	
	public void upAlbum(Album alb){
		aDao.upAlbum(alb);
	}

}
