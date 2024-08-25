package br.com.eduardo.jpa_tutorial.service;

import br.com.eduardo.jpa_tutorial.dataprovider.mysql.EmployeeInterface;
import br.com.eduardo.jpa_tutorial.dataprovider.mysql.data.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeInterface employeeInterface;

    public Employee findById(Integer id) {
        var employee = employeeInterface.findById(id).orElse(null);
        return employee;
    }

    public Iterable<Employee> findAll() {
        var employee = employeeInterface.findAll();
        return employee;
    }

    public Employee save(Employee employee) {
        return employeeInterface.save(employee);
    }

    public Employee update(Employee employee) {
        return employeeInterface.save(employee);
    }

    public void delete(Integer id) {
        employeeInterface.deleteById(id);
    }

    public void deleteAll() {
        employeeInterface.deleteAll();
    }
}
