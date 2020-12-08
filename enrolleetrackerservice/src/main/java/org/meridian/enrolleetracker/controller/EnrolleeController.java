package org.meridian.enrolleetracker.controller;

import java.util.List;

import org.meridian.enrolleetracker.model.Enrollee;
import org.meridian.enrolleetracker.service.EnrolleeService;
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
public class EnrolleeController {
	
	@Autowired
	EnrolleeService enrolleeService;
	
	@GetMapping("/enrollees")
	public ResponseEntity<List<Enrollee>> get(){
		List<Enrollee> enrollees = enrolleeService.findAll();
		return new ResponseEntity<List<Enrollee>>(enrollees, HttpStatus.OK);		
	}
	
	@PostMapping("/enrollees")
	public ResponseEntity<Enrollee> save(@RequestBody Enrollee enrollee) {
		Enrollee enrolleeOne = enrolleeService.save(enrollee);
		return new ResponseEntity<Enrollee>(enrolleeOne, HttpStatus.OK);
	}
	
	@GetMapping("/enrollees/{id}")
	public ResponseEntity<Enrollee> get(@PathVariable("id") Long id) {
		Enrollee enrollee = enrolleeService.findById(id);
		return new ResponseEntity<Enrollee>(enrollee, HttpStatus.OK);
	}
	
	@DeleteMapping("/enrollees/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		enrolleeService.delete(id);
		return new ResponseEntity<String>("Enrollee was deleted successfully", HttpStatus.OK);
	}
}
