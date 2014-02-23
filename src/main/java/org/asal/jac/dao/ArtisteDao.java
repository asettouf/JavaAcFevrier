package org.asal.jac.dao;

import java.util.Collection;

import org.asal.jac.domain.Artiste;

public interface ArtisteDao {
	
	public Collection<Artiste> findAllArtiste();

	public Artiste findArtiste(Integer id);

	public void createArtiste(Artiste art);


}
