package br.com.eduardo.jpa_tutorial.dataprovider.mysql
        ;

import br.com.eduardo.jpa_tutorial.dataprovider.mysql.data.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeInterface extends CrudRepository<Employee, Integer> {
}
