package com.powerplant.VirtualPowerPlantSystem.Repositary;

import com.powerplant.VirtualPowerPlantSystem.Model.Battery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BatteryRepositary extends JpaRepository<Battery,Long> {

    //quary that fetches battery s in between range of postcode
    List<Battery> findByPostcodeBetweenOrderByPostcode(Integer startRange, Integer endRange);


}
