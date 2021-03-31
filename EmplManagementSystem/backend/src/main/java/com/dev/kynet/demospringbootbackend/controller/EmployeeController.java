package com.dev.kynet.demospringbootbackend.controller;

import com.dev.kynet.demospringbootbackend.exception.ResourceNotFoundException;
import com.dev.kynet.demospringbootbackend.model.Employee;
import com.dev.kynet.demospringbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/")
public class EmployeeController {


    @Autowired
    private EmployeeRepository employeeRepository;

    //get all employees

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    //save a employee
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    //get employee by ID
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeByID(@PathVariable long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(" Employee not exist with ID : " + id));
        return ResponseEntity.ok(employee);
    }


    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee updateEmp) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(" Employee not exist with ID : " + id));
        employee.setFname(updateEmp.getFname());
        employee.setLname(updateEmp.getLname());
        employee.setEmail(updateEmp.getEmail());
        Employee finalUpdatedEntity = employeeRepository.save(employee);
        return ResponseEntity.ok(finalUpdatedEntity);
    }

    //Delete employee
    @DeleteMapping("/employees/{id}")
    public  ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable long id){

            Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(" Employee not exist with ID : " + id));
            employeeRepository.delete(employee);
            Map<String,Boolean> response = new HashMap<>();
            response.put("deleted",Boolean.TRUE);
            return  ResponseEntity.ok(response);
    }









}
