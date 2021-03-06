package com.example.sd2.controller;

import com.example.sd2.dtos.RestaurantDTO;
import com.example.sd2.entity.Restaurant;
import com.example.sd2.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.sd2.repository.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class RestaurantController {

	@Autowired
	private RestaurantService service;


	@GetMapping("/restaurants")
	public ResponseEntity<List<RestaurantDTO>> findAll(){



		List<RestaurantDTO> restaurants ;

		restaurants = service.findAll();

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Responded", "RestaurantController");
		return ResponseEntity.accepted().headers(httpHeaders).body(restaurants);
	}


	@PostMapping("/restaurant/add")
	public ResponseEntity addRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
		service.save(service.toRestaurant(restaurantDTO));
		return ResponseEntity.noContent().build();
	}

//	@PostMapping("/restaurants/add")
//	public ResponseEntity addRestaurant(@RequestBody RestaurantDTO restaurantDTO){
//		System.out.println(restaurantDTO.getName()+restaurantDTO.getId()+restaurantDTO.getAddress()+restaurantDTO.getDescription());
//		service.save(restaurantDTO);
//		return ResponseEntity.noContent().build();
//	}

}
