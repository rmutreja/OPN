package com.opn.in.repository;


import java.util.Optional;
import  org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import com.opn.in.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	public Optional<Customer> findByUserName(String userName);

}
