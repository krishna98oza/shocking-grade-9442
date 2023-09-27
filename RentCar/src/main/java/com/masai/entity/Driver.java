package com.masai.entity;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@PrimaryKeyJoinColumn(name="driverId")
public class Driver extends Abstractuser {


@Min(value=1, message="id should be more than 1")
private Integer licenseNo;
@Min(value=1, message="id should be more than 1")
private Double rating;
private Boolean available;

@OneToOne(cascade= CascadeType.ALL)
@JoinColumn(name="cabId")
private Cab cab;


@OneToMany(cascade = CascadeType.ALL,mappedBy = "driver",orphanRemoval = true)
@JsonIgnore
private List<TripBooking> tripBooking;

}
