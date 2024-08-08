package com.example.springproject;

import java.util.*;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
@Service
public class emplyimplement implements empservice {
    @Autowired
    private emprepository emplyy;
    // @Override
    // public String creatEmployee(Employee employee){
    //     empentity empent=new empentity();
    //     BeanUtils.copyProperties(employee, empent);
    //     emplyy.save(empent);
    //     return "saved successfully";
    // }
    @Override
    public String creatEmployee(Employee employee) {
    // Check if the provided userid already exists
    if (emplyy.existsByUserid(employee.getUserid())) {
        return "User ID already exists";
    }

    empentity empent = new empentity();
    BeanUtils.copyProperties(employee, empent);
    emplyy.save(empent);
    return "saved successfully";
}
    @Override
    public List<Employee> readEmployee(){
        List<empentity> empentlist=emplyy.findAll();
        List<Employee> emp = new ArrayList<>();
        for(empentity em:empentlist)
        {
           Employee e = new Employee();
            e.setName(em.getName());
            e.setEmail(em.getEmail());
            e.setUserid(em.getUserid());
            e.setPhoneno(em.getPhoneno());
            emp.add(e);
        }
        return emp;
    }
    @Override
    public boolean deletEmployee(Long id){
       empentity empdelete = emplyy.findById(id).get();
       emplyy.delete(empdelete);
        return true;
    }
    @Override
    public String updateEmployee(Long id,Employee emp){
        empentity empupdate = emplyy.findById(id).get();
        empupdate.setName(emp.getName());
        empupdate.setEmail(emp.getEmail());
        empupdate.setPhoneno(emp.getPhoneno());
        emplyy.save(empupdate);
        return "update successfully";
    }
    @Override
    public Employee read(Long id){
        empentity empread =emplyy.findById(id).get();
        Employee e = new Employee();
        BeanUtils.copyProperties(empread, e);
        return e;
    }
}
