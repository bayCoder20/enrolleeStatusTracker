package org.meridian.enrolleetracker.service;

import java.util.List;

import org.meridian.enrolleetracker.model.Enrollee;
import org.meridian.enrolleetracker.repository.EnrolleeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnrolleeServiceImpl implements EnrolleeService {
	
	@Autowired
	EnrolleeRepository enrolleeRepository;

	@Override
	public List<Enrollee> findAll() {
		return enrolleeRepository.findAll();
	}
	
	@Override
	public Enrollee save(Enrollee enrollee) {
		enrolleeRepository.save(enrollee);
		return enrollee;
	}

	@Override
	public Enrollee findById(Long id) {
		if(enrolleeRepository.findById(id).isPresent()) {
			return enrolleeRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		Enrollee enrollee = findById(id);
		enrolleeRepository.delete(enrollee);
	}

}
