package com.example.PetPlanner.service;

import com.example.PetPlanner.dto.Cord;
import com.example.PetPlanner.dto.CordinateDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetTaxiService {
    public void start(CordinateDTO cordinates) {
        final String URL = "https://api.openrouteservice.org/v2/directions/driving-car?api_key=5b3ce3597851110001cf624847230978143c41d597c2dedd48e5737b&start="+cordinates.getStartLocation().get(0).toString()+","+cordinates.getStartLocation().get(1).toString()+"&end="+cordinates.getEndLocation().get(0).toString()+","+cordinates.getEndLocation().get(1).toString();
        System.out.println(URL);
        RestTemplate rest = new RestTemplate();
        String response = rest.getForObject(URL,String.class);
        List<Cord> cords = getCordinates(response);
        System.out.println(cords.size());
    }

    private List<Cord> getCordinates(String response){
        String tmp = response.split("coordinates")[1].split("type")[0];
        String tmp1 = tmp.substring(2,tmp.length()-3);
        String[] tmps = tmp1.split("]");
        List<Cord> cords = new ArrayList<>();
        for(var cord : tmps){
            String s = cord.substring(2);
            cords.add(Cord.builder().lon(Double.parseDouble(s.split(",")[0])).lat(Double.parseDouble(s.split(",")[1])).build());
        }
        return cords;
    }


}
