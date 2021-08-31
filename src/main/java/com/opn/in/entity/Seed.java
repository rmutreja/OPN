package com.opn.in.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
*SeedEntity The Seed program implements an application such that the 
*data of the Seed is sent to the database.
*/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Seed {
       
	/*
	 *This is a local variable:defines the SeedId for Seed
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Size(min=1,max=10,message="Please Provide a valid SeedId")
	private Integer seedid;
        
	/*
     *This is a local variable:defines the Common Name for Seed
     */
	@Column
	@NotEmpty(message="Please provide Common Name")
	private String commonName;
	
	/*
     *This is a local variable:defines the bloom time for Seed
     */
	@Column
	@NotEmpty(message="Please provide Bloom time")
	private String bloomTime;
	
    /*
     *This is a local variable:defines the Watering for Seed
     */
    @Column
    @NotEmpty(message="Please provide Watering for seed")
	private String watering;
	
    /*
     *This is a local variable:defines the difficulty level for Seed
     */
    @Column
    @NotEmpty(message="Please provide difficuilty level for seed")
	private String difficultyLevel;
	
    /*
     *This is a local variable:defines the temperature for Seed
     */
    @Column
    @NotEmpty(message="Please provide Temperature for seed")
	private String temperature;
	
    /*
     *This is a local variable:defines the type of seeds for Seed
     */
    @Column
    @NotEmpty(message="Please provide Type Of Seeds for seed")
	private String typeOfseeds;
	
    /*
     *This is a local variable:defines the Seeds Description for Seed
     *
     */
    @NotEmpty(message="Please provide Seeds Description for seed")
	@Column
	private String seedsDescription;
	
    /*
     *This is a local variable:defines the Seed Stock for Seed
     *
     */
    @Column
    @NotNull
    //@NotEmpty(message="Seed Stock cant be null")
	private Integer seedsStock;
	
    /*
     *This is a local variable:defines the Seed Cost for Seed
     */
    @Column
    @NotNull
    //@NotEmpty(message="Seed Cost cant be null")
	private double seedsCost;
	
    /*
     *This is a local variable:defines the Seeds per Packet for Seed
     *
     */
    @Column
    @NotNull
    //@NotEmpty(message="Seeds Per Packet cant be null")
	private Integer seedsPerPacket;
	
	@OneToOne(mappedBy = "seed",cascade = CascadeType.ALL)
	@JoinColumn(name = "PLANTER")
	private Planter planter;

	

}