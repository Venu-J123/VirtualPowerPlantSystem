package com.powerplant.VirtualPowerPlantSystem.Controller;

import com.powerplant.VirtualPowerPlantSystem.Model.Battery;
import com.powerplant.VirtualPowerPlantSystem.Model.BatteryResponse;
import com.powerplant.VirtualPowerPlantSystem.Service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/batteries")
public class BatteryController {

    @Autowired
    private BatteryService batteryService;

    @PostMapping("/save")
    public ResponseEntity<String> getListOfBatteries(@RequestBody List<Battery>batteries)
    {

           batteryService.saveBatteries(batteries);
           return ResponseEntity.ok("Succsfully Saved Batteries");

    }


    @GetMapping("/getByPostcodeRange")
    public ResponseEntity<?> getPostcodeRange(@RequestParam String startRange,@RequestParam String endRange)
    {
        Integer start=Integer.parseInt(startRange);
        Integer end=Integer.parseInt(endRange);

        try {
            if(start<end) {
                     System.out.println(startRange+" "+endRange);
                BatteryResponse batteryResponse = batteryService.getBatteriesInPostcodeRange(startRange, endRange);

                return ResponseEntity.ok(batteryResponse);
            }
        }catch(IllegalArgumentException e)
        {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    return   ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Postcode Range : startRange should be lesser than endRange");
    }
}
