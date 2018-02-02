package ua.roman.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.roman.model.Disease;
import ua.roman.repository.DisRepository;
import ua.roman.repository.DiseaseRepository;

@Service
public class DiseaseService {
	@Autowired
	private DisRepository repository;
	
	
	public List<Disease> findAll() {
		
		return (List<Disease>) repository.findAll();
	}

	
}
