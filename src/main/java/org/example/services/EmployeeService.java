package org.example.services;

import org.example.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    Employee getEmployee(Long id);

    List<Employee> getAllEmployees();

    void deleteEmployeeById(Long id);

    void deleteAllEmployees();

    Page<Employee> getAllEmployeesByPage(int page, int size);

}
