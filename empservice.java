package com.example.springproject;

import java.util.List;

public interface empservice {
    String creatEmployee(Employee employee);
    List<Employee> readEmployee();
    boolean deletEmployee(Long id);
    String updateEmployee(Long id , Employee emp);
    Employee read(Long id);
}
