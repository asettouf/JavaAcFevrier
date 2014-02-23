package org.asal.jac.controlleur;

import org.asal.jac.dao.AlbumDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AlbumControlleur {

	@Autowired
	private AlbumDao alDao;
	
	public AlbumControlleur() {
		// TODO Auto-generated constructor stub
	}

}
