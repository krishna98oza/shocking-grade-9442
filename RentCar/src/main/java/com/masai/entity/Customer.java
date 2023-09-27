package com.masai.entity;

import java.sql.Date;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
//import jakarta.validation.constraints.AssertTrue;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@PrimaryKeyJoinColumn(name="customerId")
public class Customer extends Abstractuser {

	
	private boolean journey_status;
	
}
