package org.task2.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDtoRq {

    private String name;
    private int age;
    private int salary;

}
