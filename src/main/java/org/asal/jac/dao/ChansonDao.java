package org.asal.jac.dao;

import java.util.Collection;

import org.asal.jac.domain.Chanson;

public interface ChansonDao {
	
	public Collection<Chanson> findAllChanson();
	
	public void updateChanson(Chanson ch);
	
	public void deleteChanson(Chanson ch);

	void createChanson(Chanson ch);

	public Chanson findChanson(Integer id);

}
