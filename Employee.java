package com.example.springproject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Long id;
    private Long userid;
    private String name;
    private String phoneno;
    private String email;
   
}
