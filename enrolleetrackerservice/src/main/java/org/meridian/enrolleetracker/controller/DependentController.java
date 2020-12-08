package org.meridian.enrolleetracker.controller;

import org.meridian.enrolleetracker.model.Dependent;
import org.meridian.enrolleetracker.service.DependentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enrolleetracker")
public class DependentController {
	
	@Autowired
	DependentService dependentService;
	
	@PostMapping("/dependents")
	public ResponseEntity<Dependent> save(@RequestBody Dependent dependent) {
		Dependent dependentOne = dependentService.save(dependent);
		return new ResponseEntity<Dependent>(dependentOne, HttpStatus.OK);
	}
	
	@GetMapping("/dependents/{id}")
	public ResponseEntity<Dependent> get(@PathVariable("id") Long id) {
		Dependent dependent = dependentService.findById(id);
		return new ResponseEntity<Dependent>(dependent, HttpStatus.OK);
	}
	
	@DeleteMapping("/dependents/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		dependentService.delete(id);
		return new ResponseEntity<String>("Dependent was deleted successfully", HttpStatus.OK);
	}
}
