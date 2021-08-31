package com.opn.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opn.in.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String>
{
	
}
