package org.task2.mapper;

import org.springframework.stereotype.Component;
import org.task2.dto.EmployeeDtoRq;
import org.task2.entity.Employee;

@Component
public class EmployeeMapper {
    public Employee convertEmployeeRq(EmployeeDtoRq employeeDtoRq) {
        return new Employee(employeeDtoRq.getName(), employeeDtoRq.getAge(), employeeDtoRq.getSalary());
    }
}
