package com.Employee.employee.Entity;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class Employee {

    private int id;
    private String name;
    private Address address;
}
