package com.masai.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor

@PrimaryKeyJoinColumn(name="adminId")
public class Admin extends Abstractuser {

}
