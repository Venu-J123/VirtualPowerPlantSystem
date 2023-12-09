package com.powerplant.VirtualPowerPlantSystem.Service;

import com.powerplant.VirtualPowerPlantSystem.Model.Battery;
import com.powerplant.VirtualPowerPlantSystem.Model.BatteryResponse;
import com.powerplant.VirtualPowerPlantSystem.Repositary.BatteryRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BatteryService {

    @Autowired
    private BatteryRepositary batteryRepositary;

    public void saveBatteries(List<Battery> batteries)
    {

            batteryRepositary.saveAll(batteries);


    }


 public BatteryResponse getBatteriesInPostcodeRange(String startRange,String endRange){
        List<Battery> batteries=batteryRepositary.findByPostcodeBetweenOrderByPostcode(Integer.parseInt(startRange),Integer.parseInt(endRange));
           System.out.println(batteries);
        int totalWattCapacity=0;
        //finding total wattCapacity Of batteries
        for(Battery battery:batteries)
        {
            totalWattCapacity+=battery.getWattCapacity();
        }
        // avarageWattcapacity of each battery
        double avarageWattCapacity=batteries.isEmpty()?0.0:(totalWattCapacity/batteries.size());

        //Sorting List based On Name
       List<String>batteryNames=batteries.stream().map(Battery::getName).sorted().collect(Collectors.toList());

    return new BatteryResponse(batteryNames,totalWattCapacity,avarageWattCapacity);
 }


}
