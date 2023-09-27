package com.masai.entity;



import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public abstract class Abstractuser implements Serializable {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@EqualsAndHashCode.Include
	private Integer userId;
	
	@Size(min = 3, max = 255, message = "{nameRange}")
	@NotNull(message = "{notNull}")
	private String Username;
	
	@Size(min = 4, max = 20, message = "{PasswordRange}")
	@NotNull(message = "{notNull}")
	private String Password;
	


	@Size(min = 10, message = "{MobileRange}")
	private String Mobile;


	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private Address address;
	
	@Email
	@NotNull(message = "{notNull}")
	private String Email;

}
