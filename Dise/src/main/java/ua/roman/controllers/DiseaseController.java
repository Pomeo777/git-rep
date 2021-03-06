package ua.roman.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.roman.model.Disease;
import ua.roman.service.DiseaseService;

@RestController
@RequestMapping("/repository")
public class DiseaseController {
	@Autowired
	private DiseaseService service;
	
	@RequestMapping("/alldisease")
	public  List<Disease> allDisease(){
		
		//System.out.println("In method allDisease() " + diseaseServise.findAll().get(0).getName() );
		return service.findAll();
	}
}
