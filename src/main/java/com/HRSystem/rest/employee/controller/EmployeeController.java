package com.HRSystem.rest.employee.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HRSystem.rest.model.EmployeeMapVO;
import com.api.employee.beans.Emp;
import com.api.employee.service.EmpService;

@RestController
@RequestMapping("/HRSystemRest")
public class EmployeeController {
	
@Autowired 
EmpService	service;
	


	@RequestMapping("/")
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<String>("I am pinging the rest service", HttpStatus.OK);
	}
	
	 /*
     * this method is returning POJO. This is good enough to test the service in browser /Postman. But for proper 
     * REST API consumption by RestClient user ResponseEntity return type that is JSON and can be handleded by Rest Template. We can also set
     * status code and headers in that.
     */

   /* @GetMapping(path = "/employees")
	public HashMap<Integer, Emp> getEmployees() {		
		return service.getEmployees();		
	}
    */
    
    @GetMapping(path = "/employees")
   	public ResponseEntity < EmployeeMapVO> getEmployees() {
       	HttpHeaders responseHeaders = new HttpHeaders();
    	    responseHeaders.set("TYPE", "REST");
        	HashMap<Integer, Emp> map =  service.getEmployees();
        	EmployeeMapVO vo = new EmployeeMapVO(map);
        	return new ResponseEntity < EmployeeMapVO>(vo, responseHeaders, HttpStatus.OK);
   	}
   	
	
    
   @GetMapping(path = "/employees/{id}")
   public ResponseEntity < Emp > getEmployeeById(@PathVariable int id) {  
	   Emp employee = service.getEmployeeById(id);
	   return new ResponseEntity < Emp >(employee, HttpStatus.OK);
	}
   
   @PostMapping(path = "/saveEmployee")
   public ResponseEntity<String> saveEmployee(@RequestBody Emp emp) {		
	   service.saveEmployee(emp);
	   return new ResponseEntity<String>("**SAVED**", HttpStatus.CREATED);
	}
   
 @PostMapping(path = "/editEmployee")  
 public ResponseEntity<String> editEmployee(@RequestBody Emp empUI) {		 
	 service.editEmployee(empUI);
	 return new ResponseEntity<String>("**EDITED*", HttpStatus.CREATED);
}
 
 @DeleteMapping(value = "/delEmployee/{id}")
 public ResponseEntity<String> deleteEmployee(@PathVariable int id) {	  
	 service.deleteEmployee(service.getEmployeeById(id));	  
	 return new ResponseEntity<String>("**DELETED**", HttpStatus.OK);
	 
}
 
 
 public void printAllEmployees() {
	 service.printAllEmployees();	
}
	

}
