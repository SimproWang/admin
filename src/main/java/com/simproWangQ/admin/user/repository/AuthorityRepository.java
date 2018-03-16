package com.simproWangQ.admin.user.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.simproWangQ.admin.user.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}