package com.excelr.project.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.excelr.project.entity.User;
import com.excelr.project.exception.ResourceNotFoundException;
import com.excelr.project.repository.UserRepository;

@Service
public class UserService {
@Autowired
UserRepository userRepository;

public User createUser(User user) {

    if (user.getEmail() == null || user.getEmail().isBlank()) {
        throw new IllegalArgumentException("Email is required");
    }

    if (userRepository.findByEmail(user.getEmail()).isPresent()) {
        throw new ResourceNotFoundException("Email already exists");
    }

    if (user.getRole() == null || user.getRole().isBlank()) {
        user.setRole("USER");
    }

    return userRepository.save(user);
}

public @Nullable List<User> showAllUser() {
	
	return userRepository.findAll();
}

public User showUserById(int id) {

    if (userRepository.existsById(id)) {
        return userRepository.findById(id).orElse(null);
    } else {
        throw new ResourceNotFoundException("User Not Found");
    }
}


public User showUserByEmail(String email) {

    return userRepository.findByEmail(email)
            .orElseThrow(() ->
                    new ResourceNotFoundException("User not found with email: " + email));
}

public User updateUser(int id, User newdata) {
    if (newdata.getEmail() == null || newdata.getEmail().isBlank()) {
        throw new IllegalArgumentException("Email is required");
    }
	if(userRepository.existsById(id)) {
		User dbuser = showUserById(id);
		dbuser.setAge(newdata.getAge());
		dbuser.setEmail(newdata.getEmail());
		dbuser.setPassword(newdata.getPassword());
		dbuser.setUser_name(newdata.getUser_name());
		return userRepository.save(dbuser);
	}
	else {
        throw new ResourceNotFoundException("User Not Found");
    }
}

public @Nullable String deleteUser(int id) {

    if (userRepository.existsById(id)) {
    	userRepository.deleteById(id);
        return "user deleted.";
    } else {
        throw new ResourceNotFoundException("User Not Found");
    }
}

}
