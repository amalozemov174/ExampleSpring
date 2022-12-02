package org.task2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class Employee {

    @NonNull
    private String name;
    @NonNull
    private int age;
    @NonNull
    private int salary;
}
