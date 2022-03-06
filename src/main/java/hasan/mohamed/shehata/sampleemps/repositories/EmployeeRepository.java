package hasan.mohamed.shehata.sampleemps.repositories;

import hasan.mohamed.shehata.sampleemps.models.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    public List<Employee> findAllByNameContainingIgnoreCase(String part);

//    @Query(value = "SELECT * FROM employees e INNER JOIN emails m WHERE m.employeeid = e.employeeid AND m.name LIKE " +
//            ":part GROUP BY e.employeeid;"
//            , nativeQuery = true)
//    public List<Employee> getEmployeeDistinct(String part);
}
