package com.opn.in.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity              //the class is an entity and is mapped to a database table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Registration {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long patientId;
	
	@NotNull
	@Column(name="first_name")
	private String patientFirstName;
	
	@NotNull
	@Column(name="last_name")
	private String patientLastName;
	
	@NotNull
	@Column
	private String patientEmail;

	@NotNull
	@Column
	private String patientMobNo;
	
	@NotNull
	@Column
	private String patientPassward;
	
	
}