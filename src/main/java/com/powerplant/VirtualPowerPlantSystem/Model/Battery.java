package com.powerplant.VirtualPowerPlantSystem.Model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Batterys")
@Data
public class Battery
{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long Id;
 private String Name;
 private int postcode;
 private int wattCapacity;


}
