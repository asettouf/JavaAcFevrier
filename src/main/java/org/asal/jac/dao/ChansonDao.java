package org.asal.jac.dao;

import java.util.Collection;

import org.asal.jac.domain.Chanson;

public interface ChansonDao {
	
	public Collection<Chanson> findAllChanson();
	
	public Chanson findAlbum(Integer id);
	
	public void createAlbum(Chanson ch);

}
