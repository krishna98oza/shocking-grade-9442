package com.masai.entity;

import java.time.LocalDate;

import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.SecondaryTable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
//import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
//import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TripBooking {
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   private Integer TripBookingId;
	   @NonNull
	   private Integer CustomerId; 
	   
	   @ManyToOne(cascade=CascadeType.ALL)
	   @JoinColumn(name="driver_id",referencedColumnName = "driverID")
	   private Driver driver;
 
	   @NotNull(message = "{From Location notNull}")
	   private String From_location;
	   
	   @NotNull(message = "{To Loccation notNull}")
	   private String To_location;
	   
	   
	    @FutureOrPresent(message = "{futOrPres}")
	    @NotNull(message = "{data not null}")
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
       private LocalDate Fromdate_time;
	    
	    
	    @FutureOrPresent(message = "{futOrPres}")
	    @NotNull(message = "{data not null}")
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
       private LocalDate Todate_time;
	   
       private Integer km;
       private Integer  Totalamount;
       private Boolean Payment;
   
}
