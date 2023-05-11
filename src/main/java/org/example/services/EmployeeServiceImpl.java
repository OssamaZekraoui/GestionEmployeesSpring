package org.example.services;

import org.example.entities.Employee;
import org.example.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }

    @Override
    public Page<Employee> getAllEmployeesByPage(int page, int size) {
        return employeeRepository.findAll(PageRequest.of(page,size));
    }
}
