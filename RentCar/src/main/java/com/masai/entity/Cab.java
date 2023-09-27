package com.masai.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

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

public class Cab {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer cabId;
private String carType;
private Integer ratePerKm;

@OneToOne(cascade=CascadeType.ALL,mappedBy="cab",orphanRemoval = true)
@JsonIgnore

private Driver driver;
}
