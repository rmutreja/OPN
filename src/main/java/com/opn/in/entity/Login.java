package com.opn.in.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * LoginEntity The customer program implements an application such that the
 * customer can login.
 */	
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Login {

		/*
		 * This a local variable: {@link #loginId} defines the unique Id for customer
		 */
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private String loginId;
		
		/* 
		 * This a local variable: {@link #password} defines the unique Id for customer
		 */
		@Column(name = "password", nullable = false)
		@Size(min = 8, max = 20, message = "Please enter within range of 8 - 20")
		private String password;
		
		/*
		 * This a local variable: {@link #role} defines the role for customer
		 */
		@Column(name = "role", nullable = false)
		@Size(min = 5, max = 8, message = "Please enter Admin or Customer as a role")
		private String role;

}
