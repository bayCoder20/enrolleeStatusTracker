package org.meridian.enrolleetracker.service;

import java.util.List;

import org.meridian.enrolleetracker.model.Enrollee;


public interface EnrolleeService {
	List<Enrollee> findAll();
	
	Enrollee save(Enrollee enrollee);
	
	Enrollee findById(Long id);
	
	void delete(Long id);
}
