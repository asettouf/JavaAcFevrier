package org.asal.jac.controlleur;

import java.util.Collection;

import org.asal.jac.domain.Album;
import org.asal.jac.domain.Artiste;
import org.asal.jac.service.ArtisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArtisteControlleur {

	@Autowired
	private ArtisteService aServ;
	
	public ArtisteControlleur() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value="/artiste",method = RequestMethod.GET)
	public String returnAllArtiste(ModelMap map){
		Collection<Artiste> aList=aServ.findAllArtiste();
		map.addAttribute("aList",aList);
		return "artiste";
	}
	
	@RequestMapping(value="/addArtiste",method=RequestMethod.GET)
	public String  returnArtiste(Model mod){
		mod.addAttribute("artiste",new Artiste());
		return "createArtiste";
	}

	@RequestMapping(value="/addArtiste", method=RequestMethod.POST)
	public String returnArtiste(@ModelAttribute("artiste")Artiste a){
		aServ.createArtiste(a);
		return "createArtiste";
	}
}
