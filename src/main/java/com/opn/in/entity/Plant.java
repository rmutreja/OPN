package com.opn.in.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
*PlantEntity: The Plant program implements an application such that the 
*data of the customer is sent to the database.
*/
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
@Table(name = "PLANT")
public class Plant {
	
	/*
	 *This is a local variable:defines the PlanteId for Planter
	 *
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer plantId;
	
	/*
     *This is a local variable:defines the Plant Height for Plant
     *
     */
	@NotNull
    //@NotEmpty(message= "please provide plant height")
	@Column(name="PLANT_HEIGHT")
	private Integer plantHeight;
        
	/*
    *This is a local variable:defines the Plant spread for Plant
    *
    */
	@Column(name="PLANT_SPREAD")
    @NotEmpty(message= "please provide plant spread")
	@Size(min=2,max=20, message= "Please provide a valid plant spread")
	private String plantSpread;
      
	/*
    *This is a local variable:defines the common name of the plant
    *
    */
	@Column(name="COMMON_NAME")
    @NotEmpty(message= "please provide common name")
	@Size(min=2,max=20, message= "Please provide a valid common Name")
	private String commonName;
       
	/*
    *This is a local variable:defines the bloom time of the plant
    *
    */
	@Column(name="BLOOM_TIME")
    @NotEmpty(message= "please provide  bloom time")
	@Size(min=2,max=20, message= "Please provide a valid bloom time")
	private String bloomTime;
       
	/*
    *This is a local variable:defines the medicinal or culinary use of the plant
    *
    */
	@Column(name="MEDICINAL_OR_CULINARY_USE")
    @NotEmpty(message= "please provide  medicinal or culinary use")
	@Size(min=2,max=20, message= "Please provide a valid medical and culinary use")
	private String medicinalOrCulinaryUse;
       
	/*
    *This is a local variable:defines the difficulty level of the plant
    *
    */
	@Column(name="DIFFICULTY_LEVEL")
    @NotEmpty(message= "please provide difficulty level")
	@Size(min=2,max=20, message= "Please provide a valid difficulty level")
	private String difficultyLevel;
       
	/*
    *This is a local variable:defines the temperature of the plant
    *
    */
	@Column(name="TEMPERATURE")
    @NotEmpty(message= "please provide  temperature")
	@Size(min=2,max=20, message= "Please provide a valid temperature")
	private String temperature;
	
    /*
    *This is a local variable:defines the type of the plant
    *
    */
	//@Column(name="TYPE_OF_PLANT")
    @NotEmpty(message= "please provide  bloom time")
	@Size(min=2,max=20, message= "Please provide a valid bloom time")
	private String typeOfPlant;
	
    /*
    *This is a local variable:defines the description of the plant
    *
    */
	@Column(name="PLANT_DESCRIPTION")
    @NotEmpty(message= "please provide plant description")
	@Size(min=2,max=20, message= "Please provide a valid plant description")
	private String plantDescription;
	
    /*
    *This is a local variable:defines the stock of the plant
    *
    */
	@NotNull
	//@NotEmpty(message= "please provide plant stock")
	@Column(name="PLANTS_STOCK")
	private Integer plantsStock;
	
    /*
    *This is a local variable:defines the cost of the plant
    *
    */
	@NotNull
	//@NotEmpty(message= "please provide plant cost")
	@Column(name="PLANT_COST")
	private double plantCost;
	
	@OneToOne(mappedBy = "plant",cascade = CascadeType.ALL)
	@JoinColumn(name = "PLANTER")
	private Planter planter;
	
}