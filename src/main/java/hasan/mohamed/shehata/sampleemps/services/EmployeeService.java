package hasan.mohamed.shehata.sampleemps.services;

import hasan.mohamed.shehata.sampleemps.models.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAll();
    public Employee getById(long employeeid);
    public Employee save(Employee employee);
    public Employee update(long employeeid, Employee employee);
    public void delete(long employeeid);

    public List<Employee> getByNameLike(String part);
    public List<Employee> getEmployeesByEmailContaining(String part);
}
