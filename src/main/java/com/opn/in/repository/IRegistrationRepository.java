package com.opn.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.opn.in.entity.Registration;

@Repository
public interface IRegistrationRepository extends JpaRepository<Registration,Long>{

}
