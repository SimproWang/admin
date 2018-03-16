package com.simproWangQ.admin.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.simproWangQ.admin.user.entity.User;
import com.simproWangQ.admin.user.repository.UserRepository;
import com.simproWangQ.admin.user.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService  {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return userRepository.findByUsername(username);
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(passwordEncoder.encode(user.getPassword())); 
		return userRepository.save(user);
	}

	@Override
	public void removeUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.getOne(id);
	}

	@Override
	public List<User> listUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}
