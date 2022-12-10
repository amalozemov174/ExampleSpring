package org.task2.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.task2.dao.EmployeeDao;
import org.task2.dto.EmployeeDtoRq;
import org.task2.mapper.EmployeeMapper;

@RestController
@Slf4j
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class Controller {
    private EmployeeMapper employeeMapper;
    private EmployeeDao employeeDao;

    //@RequestMapping
    @PostMapping(path = "/createEmployee")
    public String createEmployee(@RequestBody EmployeeDtoRq employeeDtoRq) {
        log.info(employeeDtoRq.toString());
        return "Создан пользователь с id: " + employeeDao.addEmployee(employeeMapper.convertEmployeeRq(employeeDtoRq));
    }

    @GetMapping(path = "/employee/{id}")
    public String getCarId(@PathVariable Integer id) {
        log.info("Информация о пользователе " + employeeDao.getEmployee(id));
        if (employeeDao.getEmployee(id) == null) {
            return "Пользователя с id: " + id + " не найден";
        }
        return "Пользователь с id: " + id + " " + employeeDao.getEmployee(id).toString();
    }

    @DeleteMapping(path = "/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        if (employeeDao.getEmployee(id) == null) {
            return "Пользователя с id: " + id + " не найден";
        }
        employeeDao.deleteEmployee(id);
        return "Пользователь с id: " + id + " удален";
    }

    @PutMapping(path = "updateEmployee/{id}")
    public String updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDtoRq employeeDtoRq) {
        if (employeeDao.getEmployee(id) == null) {
            return "Пользователя с id: " + id + " не найден";
        }
        employeeDao.updateEmployee(id, employeeMapper.convertEmployeeRq(employeeDtoRq));
        return "Пользователь с id: " + id + " " + employeeDao.getEmployee(id).toString() + "обновлен";
    }



}
