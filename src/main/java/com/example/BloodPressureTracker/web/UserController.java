package com.example.BloodPressureTracker.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.BloodPressureTracker.model.SignupForm;
import com.example.BloodPressureTracker.model.User;
import com.example.BloodPressureTracker.model.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository repository;

	// Signup
	@RequestMapping(value = "signup")
	public String addUser(Model model) {
		model.addAttribute("signupform", new SignupForm());
		return "signup";
	}

	// Create new user
	@RequestMapping(value = "saveuser", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("signupform") SignupForm signupForm, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			if (signupForm.getPassword().equals(signupForm.getPasswordCheck())) {
				String pswd = signupForm.getPassword();
				BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
				String hashPswd = bc.encode(pswd);

				User newUser = new User();
				newUser.setPasswordHash(hashPswd);
				newUser.setUsername(signupForm.getUsername());
				newUser.setRole("USER");
				// Check if user already exists
				if (repository.findByUsername(signupForm.getUsername()) == null) {
					repository.save(newUser);
				} else {
					bindingResult.rejectValue("username", "err.username", "Username already exists");
					return "signup";
				}
			} else {
				bindingResult.rejectValue("passwordCheck", "err.passCheck", "Passwords do not match");
				return "signup";
			}
		} else {
			return "signup";
		}
		return "redirect:/login";
	}

}
