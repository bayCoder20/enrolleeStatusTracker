package org.meridian.enrolleetracker.service;

import org.meridian.enrolleetracker.model.Dependent;

public interface DependentService {
	
	Dependent save(Dependent dependent);
	
	Dependent findById(Long id);
	
	void delete(Long id);
}
