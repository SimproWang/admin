package com.simproWangQ.admin.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simproWangQ.admin.user.entity.Authority;
import com.simproWangQ.admin.user.repository.AuthorityRepository;
import com.simproWangQ.admin.user.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService  {

	@Autowired
	private AuthorityRepository authorityRepository;

	@Override
	public Authority getAuthorityById(Long id) {
		// TODO Auto-generated method stub
		return authorityRepository.getOne(id);
	}
	
	

}
