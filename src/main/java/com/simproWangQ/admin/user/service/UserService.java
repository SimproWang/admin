package com.simproWangQ.admin.user.service;

import java.util.List;

import com.simproWangQ.admin.user.entity.User;

public interface UserService {
	
	/**
	 * 保存用户
	 * @param user
	 * @return
	 */
	User saveUser(User user);
	
	/**
	 * 删除用户
	 * @param user
	 */
	void removeUser(Long id);
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	User updateUser(User user);
	
	/**
	 * 根据id获取用户
	 * @param id
	 * @return
	 */
	User getUserById(Long id);
	
	/**
	 * 获取用户列表
	 * @return
	 */
	List<User> listUsers();
}
