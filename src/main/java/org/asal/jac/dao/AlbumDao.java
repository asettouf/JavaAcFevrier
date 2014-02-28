package org.asal.jac.dao;

import java.util.Collection;

import org.asal.jac.domain.Album;
import org.asal.jac.domain.Artiste;

public interface AlbumDao {
	
	public Collection<Album> findAllAlbum();
	
	public Album findAlbum(Integer id);
	
	public void createAlbum(Album alb);
	
	public void delAlbum(Album alb);
	
	public void upAlbum(Album alb);

}
