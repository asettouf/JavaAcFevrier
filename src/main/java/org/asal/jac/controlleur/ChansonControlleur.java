package org.asal.jac.controlleur;

import org.asal.jac.domain.Chanson;
import org.asal.jac.service.ChansonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChansonControlleur {
	
	@Autowired
	ChansonService cService;

	public ChansonControlleur() {
		// TODO Auto-generated constructor stub
	}
	

	
	@RequestMapping(value="/chanson",method = RequestMethod.GET)
	public String returnArtiste(@RequestParam(value="id") int id, Model mod){
		mod.addAttribute("chanson",cService.findChanson(id));
		return "chanson";
	}
	
	@RequestMapping(value="/addChanson", method=RequestMethod.GET)
	public String returnChanson(Model mod){
		mod.addAttribute("chanson", new Chanson());
		return "createChanson";
	}
	
	@RequestMapping(value="/delChanson", method=RequestMethod.GET)
	public String delChanson(Model mod){
		mod.addAttribute("chanson", new Chanson());
		return "delChanson";
	}
	
	@RequestMapping(value="/upChanson", method=RequestMethod.GET)
	public String upChanson(Model mod){
		mod.addAttribute("chanson", new Chanson());
		return "upChanson";
	}
	@RequestMapping(value="/addChanson", method=RequestMethod.POST)
	public String addChanson(@ModelAttribute("chanson")Chanson ch){
		cService.createChanson(ch);
		return "createChanson";
	}
	
	@RequestMapping(value="/delChanson", method=RequestMethod.POST)
		public String delChanson(@ModelAttribute("chanson")Chanson ch){
		cService.deleteChanson(ch);
		return "delChanson";
	}
	
	@RequestMapping(value="/upChanson", method=RequestMethod.POST)
	public String upChanson(@ModelAttribute("chanson")Chanson ch){
		cService.updateChanson(ch);
		System.out.println(ch.getId());
		return "upChanson";
	}

}
