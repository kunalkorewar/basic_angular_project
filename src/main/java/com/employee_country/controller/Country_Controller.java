package com.employee_country.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee_country.entities.Country;
import com.employee_country.service.Employee_Country_Service;

@RestController
public class Country_Controller {

	@Autowired
	private Employee_Country_Service service;

	List<Country> countries;

//1
	@GetMapping("getAllCountry")
	public ResponseEntity<List<Country>> allCountry() {

		countries = service.countryList();

		if (!countries.isEmpty()) {

			return new ResponseEntity<List<Country>>(countries, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<Country>>(HttpStatus.NO_CONTENT);
		}
	}

	/*
	 * @PostMapping("addCountry") public ResponseEntity<ArrayList<Country>>
	 * addCountry(@RequestBody Country[] country) {
	 * 
	 * System.out.println(Arrays.toString(country));
	 * 
	 * ArrayList<Country> list = service.addCountry(country);
	 * 
	 * if (!list.isEmpty()) { return new ResponseEntity<ArrayList<Country>>(list,
	 * HttpStatus.OK); } else { return new
	 * ResponseEntity<ArrayList<Country>>(HttpStatus.INTERNAL_SERVER_ERROR); } }
	 */
//2
	@PostMapping("addCountry")
	public ResponseEntity<String> addCountry(@RequestBody Country country) {

		String string = service.addCountry(country);

		if (string.equals("Country Added Successfully..")) {
			return new ResponseEntity<String>(string, HttpStatus.OK);
		} else {

			return new ResponseEntity<String>(string, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//3
	@PutMapping("updateCountry")
	public ResponseEntity<String> updateCountry(@RequestBody Country country) {

		String string = service.updateCountry(country);

		if (string.equals("CountryId : " + country.getCid() + " Updated Successfully..")) {
			
			//if id update then return with string and 200 ok status
			
			return new ResponseEntity<String>(string, HttpStatus.OK);
		
		} else if (string.equals("Something Went Wrong..")) {
			
			//if exception come due to tx.commit() or session.update()
			//then it will return with string and 500 status
			
			return new ResponseEntity<String>(string, HttpStatus.INTERNAL_SERVER_ERROR);
		
		} else {
			
			//if id is not present then return only 204 no_contant
			//we cant return string with 204 no_contant
			//here we send but still it will not show on console of postman..
			
			return new ResponseEntity<String>(string, HttpStatus.NO_CONTENT);

		}
	}

//4
	@DeleteMapping("deleteCountryById/{cid}")
	public ResponseEntity<String> deleteCountryById(@PathVariable Integer cid) {

		String string = service.deleteCountryById(cid);

		if (string.equals("CountryId : " + cid + " Deleted Successfully..")) {
			
			return new ResponseEntity<String>(string, HttpStatus.OK);
		
		} else if (string.equals("Something Went Wrong..")) {
			
			return new ResponseEntity<String>(string, HttpStatus.INTERNAL_SERVER_ERROR);
		
		} else {
			
			return new ResponseEntity<String>(string, HttpStatus.NO_CONTENT);

		}
	}

//5
	@GetMapping("getCountryById/{cid}")
	public ResponseEntity<Country> getCountryById(@PathVariable Integer cid) {

		Country country = service.getCountryById(cid);

		if (country != null) {
			
			return new ResponseEntity<Country>(country, HttpStatus.OK);
		
		} else {
			
			return new ResponseEntity<Country>(country, HttpStatus.NO_CONTENT);
		
		}
	}
}
