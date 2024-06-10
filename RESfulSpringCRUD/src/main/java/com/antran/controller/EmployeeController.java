package com.antran.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antran.entities.Employee;
import com.antran.exception.ResourceNotFoundException;
import com.antran.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {

  @Autowired
  private EmployeeRepository employeeRepository;

  // get all employee
  @GetMapping("/employees")
  public List<Employee> getAllEmployee() {
    System.out.println("-------------");
    return employeeRepository.findAll();
  }

  // create employee
  @PostMapping("/employees")
  public Employee createEmployee(@Valid @RequestBody Employee employee) {
    return employeeRepository.save(employee);
  }

  // get employee by id
  @GetMapping("/employees/{id}")
  public ResponseEntity<Employee> getEmployeeById(
      @PathVariable(value = "id") int employeeId)
      throws ResourceNotFoundException {
    Employee employee = employeeRepository.findById(employeeId)
        .orElseThrow(() -> new ResourceNotFoundException(
            "Employee not found forithis id ::" + employeeId));
    return ResponseEntity.ok().body(employee);
  }

  // update employee
  @PutMapping("/employees/{id}")
  public ResponseEntity<Employee> updateEmployee(
      @PathVariable(value = "id") int employeeId,
      @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
    Employee employee = employeeRepository.findById(employeeId)
        .orElseThrow(() -> new ResourceNotFoundException(
            "Employee not found ::" + employeeId));
    
    employee.setFirstName(employeeDetails.getFirstName());
    employee.setLastName(employeeDetails.getLastName());
    employee.setEmail(employeeDetails.getEmail());
    employeeRepository.save(employee);
    return ResponseEntity.ok().body(employee);
  }

  // delete employee by id
  @DeleteMapping("/employees/{id}")
  public ResponseEntity<?> deleteEmployee(
      @PathVariable(value = "id") int employeeId)
      throws ResourceNotFoundException {
    employeeRepository.findById(employeeId)
        .orElseThrow(() -> new ResourceNotFoundException(
            "Employyee not found ::" + employeeId));
    
    employeeRepository.deleteById(employeeId);
    return ResponseEntity.ok().build();
  }
}
