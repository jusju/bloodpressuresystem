package com.example.BloodPressureTracker.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.BloodPressureTracker.model.BloodPressure;
import com.example.BloodPressureTracker.model.BloodPressureRepository;
import com.example.BloodPressureTracker.model.User;

@Controller
public class BloodPressureController {
	@Autowired
	private BloodPressureRepository repository;
	
	// Show all blood pressure entries
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	// Show all blood pressure entries
	@RequestMapping(value={"/", "/bloodpressurelist"})
	public String bloodPressureList(Model model) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("JUKKA START");
		System.out.println(user);
		System.out.println("JUKKA END");
		model.addAttribute("bloodpressure", repository.findAll());
		return "bloodpressurelist";
	}
	
	// RESTfull service to get all blood pressure entries
	@RequestMapping(value="/bloodpressure/{id}", method=RequestMethod.GET)
	public @ResponseBody List<BloodPressure> bloodPressureListRest() {
		return (List<BloodPressure>) repository.findAll();
	}
	
	// Add new blood pressure entry
	@RequestMapping(value = "/add")
	public String addBloodPressure(Model model) {
		model.addAttribute("bloodpressure", new BloodPressure());
		return "addbloodpressure";
	}
	
	// Save blood pressure entry
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(BloodPressure bloodpressure) {
		repository.save(bloodpressure);
		return "redirect:bloodpressurelist";
	}
	
	// Delete entry
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBloodPressure(@PathVariable("id") Long bloodPressureId, Model model) {
		repository.deleteById(bloodPressureId);
		return "redirect:../bloodpressurelist";
	}
	
	// Edit entry
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String modify(@PathVariable("id") Long bloodPressureId, Model model) {
		model.addAttribute("bloodpressure", repository.findById(bloodPressureId));
		return "edit";
	}

}
