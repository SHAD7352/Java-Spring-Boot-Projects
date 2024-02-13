package com.dillutech.service;

import java.util.List;

import com.dillutech.entity.Employee;

public interface EmpService {

    public Employee saveEmployee(Employee emp);

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(int id);

    public boolean deleteEmpById(int id);

}
