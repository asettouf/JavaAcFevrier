package org.asal.jac.controlleur;

import java.util.Collection;

import org.asal.jac.domain.Chanson;
import org.asal.jac.service.ChansonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChansonControlleur {
	
	@Autowired
	ChansonService cService;

	public ChansonControlleur() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/chanson",method = RequestMethod.GET)
	public String returnChanson(ModelMap map){
		Collection<Chanson> cList=cService.findAllChanson();
		map.addAttribute("cList",cList);
		return "chanson";
	}

}