package org.asal.jac.dao;

import java.util.Collection;

import org.asal.jac.domain.Album;

public interface AlbumDao {
	
	public Collection<Album> findAllAlbum();
	
	public Album findAlbum(Integer id);
	
	public void createAlbum(Album alb);

}
