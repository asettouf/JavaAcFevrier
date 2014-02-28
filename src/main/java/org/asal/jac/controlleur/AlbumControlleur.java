package org.asal.jac.controlleur;

import org.asal.jac.domain.Album;
import org.asal.jac.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AlbumControlleur {

	@Autowired
	private AlbumService aServ;
	
	public AlbumControlleur() {
		// TODO Auto-generated constructor stub
	}
	

	
	@RequestMapping(value="/album",method = RequestMethod.GET)
	public String returnAlbum(@RequestParam(value="id") int id, Model mod){
		mod.addAttribute("album",aServ.findAlbum(id));
		return "album";
	}
	
	@RequestMapping(value="/addAlbum", method=RequestMethod.GET)
	public String addAlbum(Model mod){
		mod.addAttribute("album", new Album());
		return "createAlbum";
	}
	
	@RequestMapping(value="/delAlbum", method=RequestMethod.GET)
	public String delAlbum(Model mod){
		mod.addAttribute("album", new Album());
		return "delAlbum";
	}
	
	@RequestMapping(value="/upAlbum", method=RequestMethod.GET)
	public String upAlbum(Model mod){
		mod.addAttribute("album", new Album());
		return "upAlbum";
	}
	
	
	@RequestMapping(value="/addAlbum", method=RequestMethod.POST)
	public String addAlbum(@ModelAttribute("album")Album a){
		aServ.createAlbum(a);
		return "createAlbum";
	}

	@RequestMapping(value="/delAlbum", method=RequestMethod.POST)
	public String delAlbum(@ModelAttribute("album")Album a){
		aServ.delAlbum(a);
		return "delAlbum";
	}
	
	@RequestMapping(value="/upAlbum", method=RequestMethod.POST)
	public String upAlbum(@ModelAttribute("album")Album a){
		aServ.upAlbum(a);
		return "upAlbum";
	}
}
