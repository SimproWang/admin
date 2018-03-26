package com.simproWangQ.admin.user.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.simproWangQ.admin.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long>
{

	/**
     * 根据用户名查用户
     * @param username
     * @return
     */
    User findByUsername(String username);
	
}