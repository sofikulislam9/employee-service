package com.employee.service;

import com.employee.entiry.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {

        Employee e = getEmployeeById(id);
        e.setName(employee.getName());
        e.setEmail(employee.getEmail());
        e.setDepartment(employee.getDepartment());
        e.setSalary(employee.getSalary());

        return repository.save(e);
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
