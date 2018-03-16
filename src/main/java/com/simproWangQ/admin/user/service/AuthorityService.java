package com.simproWangQ.admin.user.service;

import com.simproWangQ.admin.user.entity.Authority;

public interface AuthorityService {
	
	/**
	 * 根据id获取权限
	 * @param id
	 * @return
	 */
	Authority getAuthorityById(Long id);
	
}
