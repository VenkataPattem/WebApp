package com.hello.welcomepage;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hello.dto.UserSignUpDTO;
import com.hello.entity.UserSignUp;
import com.hello.repository.UserSignUpRepository;

@RestController
public class welcomepage {
	
	@Autowired
	UserSignUpRepository userSignUpRepository;
	
	@GetMapping("/hello")
	public String helloMessage() {
		return "Welcome to my world, my first website";
	}
	
	@PostMapping("/signup")
	public String signup(@RequestBody UserSignUpDTO signUpDTO) {
		UserSignUp save = null;
		if(signUpDTO != null) {
			UserSignUp userSignUp = new UserSignUp();
			//userSignUp.setUserId(signUpDTO.getUserId());
			userSignUp.setUserName(signUpDTO.getUserName());
			userSignUp.setFirstName(signUpDTO.getFirstName());
			userSignUp.setLastName(signUpDTO.getLastName());
			userSignUp.setEmail(signUpDTO.getEmail());
			userSignUp.setPhone(signUpDTO.getPhone());
			save = userSignUpRepository.save(userSignUp);
		}
		if(save != null)
			return "Success";
		else
			return "Failed";
	}
	
	@PutMapping("/updateuser")
	public String updateUser(@RequestBody UserSignUpDTO signUpDTO) {
		return "";
	}
	
	@GetMapping("/{id}")
	public UserSignUpDTO getUserById(@PathVariable Integer id) {
		UserSignUpDTO dto = new UserSignUpDTO();
		Optional<UserSignUp> entity = userSignUpRepository.findById(id);
		if(entity.isPresent()) {
			UserSignUp object = entity.get();
			dto.setUserId(object.getUserId());
			dto.setEmail(object.getEmail());
			dto.setFirstName(object.getFirstName());
			dto.setLastName(object.getLastName());
			dto.setPhone(object.getPhone());
			dto.setUserName(object.getUserName());
		}
		return dto;
	}
}
