package org.task2.dao;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.task2.entity.Employee;

import java.util.HashMap;
import java.util.Map;

@Data
@Component
public class EmployeeDao {
    private int id;

    private Map<Integer, Employee> employees = new HashMap<>();

    public Integer addEmployee(Employee employee) {
        int id = generateId();
        employees.put(id, employee);
        return id;
    }

    private int generateId() {
        return ++id;
    }

    public Employee getEmployee(int id) {
        if (!employees.containsKey(id)) {
            return null;
        }
        return employees.get(id);
    }

    public void deleteEmployee(int id) {
        employees.remove(id);
    }


    public void updateEmployee(Integer id, Employee employee) {
        if (employee.getName() != null) {
            getEmployee(id).setName(employee.getName());
        }
    }
}
