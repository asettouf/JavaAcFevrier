package org.asal.jac.controlleur;

import java.util.Collection;

import org.asal.jac.domain.Album;
import org.asal.jac.domain.Chanson;
import org.asal.jac.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AlbumControlleur {

	@Autowired
	private AlbumService aServ;
	
	public AlbumControlleur() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/album",method = RequestMethod.GET)
	public String returnAllAlbum(ModelMap map){
		Collection<Album> aList=aServ.findAllAlbum();
		map.addAttribute("aList",aList);
		
		return "album";
	}
	
	@RequestMapping(value="/addAlbum", method=RequestMethod.GET)
	public String returnChanson(Model mod){
		mod.addAttribute("album", new Album());
		return "createAlbum";
	}
	
	
	@RequestMapping(value="/addAlbum", method=RequestMethod.POST)
	public String returnAlbum(@ModelAttribute("album")Album a){
		aServ.createAlbum(a);
		return "createAlbum";
	}

}
