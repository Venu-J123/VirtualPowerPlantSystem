package com.powerplant.VirtualPowerPlantSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BatteryResponse {

    private List<String> batteryNames;
    private  int wattCapacity;
    private  double avarageWattCapacity;

}
