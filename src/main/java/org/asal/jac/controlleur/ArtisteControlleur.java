package org.asal.jac.controlleur;

import java.util.Collection;

import org.asal.jac.domain.Artiste;
import org.asal.jac.service.ArtisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArtisteControlleur {

	@Autowired
	private ArtisteService aServ;
	
	public ArtisteControlleur() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value="/all",method = RequestMethod.GET)
	public String returnAllArtiste(ModelMap map){
		Collection<Artiste> aList=aServ.findAllArtiste();
		map.addAttribute("aList",aList);
		return "all";
	}
	
	@RequestMapping(value="/artiste",method = RequestMethod.GET)
	public String returnArtiste(@RequestParam(value="id") int id, Model mod){
		mod.addAttribute("artiste",aServ.findArtiste(id));
		return "artiste";
	}
	
	
	
	
	@RequestMapping(value="/delArtiste", method=RequestMethod.GET)
	public String delArtiste(Model mod){
		mod.addAttribute("artiste", new Artiste());
		return "delArtiste";
	}
	
	@RequestMapping(value="/upArtiste", method=RequestMethod.GET)
	public String upArtiste(Model mod){
		mod.addAttribute("artiste", new Artiste());
		return "upArtiste";
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
	
	@RequestMapping(value="/delArtiste", method=RequestMethod.POST)
	public String delArtiste(@ModelAttribute("artiste")Artiste a){
		aServ.delArtiste(a);;
		return "delArtiste";
	}
	
	@RequestMapping(value="/upArtiste", method=RequestMethod.POST)
	public String upArtiste(@ModelAttribute("artiste")Artiste a){
		aServ.upArtiste(a);
		return "upArtiste";
	}
}
