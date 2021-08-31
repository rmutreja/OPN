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
*PlanterEntity: The Planter program implements an application such that the 
*data of the customer is sent to the database.
*
*/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Planter {
	
	/*
	 *This is a local variable:defines the PlanterId for Planter
	 *
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//    @Size(min=1,max=10,message="Please Provide a valid PlanterId")
	private Integer planterId;
	
	/*
     *This is a local variable:defines the Planter Height for Planter
     *
     */
    @NotNull
    @Column
    //@NotEmpty(message="Planter Height cant be null")
	private float planterheight;
	
    /*
     *This is a local variable:defines the Planter Capacity for Planter
     *
     */
    @NotNull
    //@NotEmpty(message="Planter Capacity cant be null")
	@Column
	private int planterCapacity;
	
    /*
     *This is a local variable:defines the Planter Drainage holes for Planter
     *
     */
    @NotNull
    //@NotEmpty(message="Planter Drainage cant be null")
	@Column
	private int drinageHoles;
	
    /*
     *This is a local variable:defines the Planter Color for Planter
     *
     */
    @NotNull
    //@NotEmpty(message="Planter Color cant be null")
	@Column
	private int planterColor;
	
    /*
     *This is a local variable:defines the Planter Shape for Planter
     *
     */
    @Column
    @NotEmpty(message="Please provide Planter Shape")
	private String planterShape;
	
    /*
     *This is a local variable:defines the Planter Stock for Planter
     *
     */
    @NotNull
    //@NotEmpty(message="Planter Stock cant be null")
	@Column
	private int planterStock;
	
    /*
     *This is a local variable:defines the Planter Cost for Planter
     *
     */
    @NotNull
    //@NotEmpty(message="Planter Cost cant be null")
	@Column
	private int planterCost;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PLANT")
	private Plant plant;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SEED")
	private Seed seed;
	
}