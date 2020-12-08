package org.meridian.enrolleetracker.service;

import org.meridian.enrolleetracker.model.Dependent;
import org.meridian.enrolleetracker.repository.DependentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DependentServiceImpl implements DependentService{
	@Autowired
	DependentRepository dependentRepository;
	
	@Override
	public Dependent save(Dependent dependent) {
		dependentRepository.save(dependent);
		return dependent;
	}
	
	@Override
	public Dependent findById(Long id) {
		if(dependentRepository.findById(id).isPresent()) {
			return dependentRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		Dependent dependent = findById(id);
		dependentRepository.delete(dependent);
	}
}
