package com.example.springproject;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class empcontroller {
    @Autowired
    empservice emply;
    // empservice emply = new emplyimplement();
    @GetMapping("employee")
    public List<Employee> readEmployees() {
        return emply.readEmployee();
    }
    @GetMapping("employee/{id}")
    public Employee readsingleemployee(@PathVariable Long id) {
        return emply.read(id);
    }
    
    @PostMapping("employee")
    public String creatEmployees(@RequestBody Employee entity) {
        
        return emply.creatEmployee(entity);
    }
    @DeleteMapping("employee/{userid}")
    public String deletEmployees(@PathVariable Long id){
        if( emply.deletEmployee(id)){
            return "successfully deleted";
        }
        return "id not found";
    }
    @PutMapping("employee/{userid}")
    public String updateEmployees(@PathVariable Long id, @RequestBody Employee employee) { 
        return emply.updateEmployee(id, employee);
    }
    
}
