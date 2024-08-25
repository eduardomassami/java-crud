package br.com.eduardo.jpa_tutorial.entrypoint;

import br.com.eduardo.jpa_tutorial.dataprovider.mysql.data.Employee;
import br.com.eduardo.jpa_tutorial.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JPAController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/test/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getTest(@PathVariable("id") Integer id) {
        var employee = employeeService.findById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Employee>> getAll() {
        var employees = employeeService.findAll();
        if (employees == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employees);
    }

    @PostMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        var employeeSaved = employeeService.save(employee);
        if (employeeSaved == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employeeSaved);
    }

    @PutMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        var employeeSaved = employeeService.update(employee);
        if (employeeSaved == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employeeSaved);
    }

    @DeleteMapping(value = "/test/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> delete(@PathVariable("id") Integer id) {
        employeeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> deleteAll() {
        employeeService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
