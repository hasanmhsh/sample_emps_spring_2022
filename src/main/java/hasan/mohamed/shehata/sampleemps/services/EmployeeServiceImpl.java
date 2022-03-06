package hasan.mohamed.shehata.sampleemps.services;

import hasan.mohamed.shehata.sampleemps.exceptions.ResourceNotFoundException;
import hasan.mohamed.shehata.sampleemps.models.Email;
import hasan.mohamed.shehata.sampleemps.models.Employee;
import hasan.mohamed.shehata.sampleemps.models.Jobtitle;
import hasan.mohamed.shehata.sampleemps.repositories.EmailRepository;
import hasan.mohamed.shehata.sampleemps.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Transactional
@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private JobtitleService jobtitleService;
    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository
                .findAll()
                .iterator()
                .forEachRemaining(employees::add);
        return employees;
    }

    @Override
    public Employee getById(long employeeid) throws ResourceNotFoundException {
        Employee employee = employeeRepository
                .findById(employeeid)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Employee with id = " + employeeid + " is not exist!"));
        return employee;
    }

    @Transactional
    @Override
    public Employee save(Employee employee) throws ResourceNotFoundException {
        Employee newEmployee = null;
        if (employee.getEmployeeid() == 0) {
            // New employee to create
            newEmployee = new Employee();
        } else {
            // Replace existing employee
            newEmployee = employeeRepository
                    .findById(employee.getEmployeeid())
                    .orElseThrow(() -> new ResourceNotFoundException("Employee with id = " + employee.getEmployeeid() + " is not " +
                            "exist!"));
        }
        newEmployee
                .getEmails()
                .clear();
        if (employee.getEmails() != null) {
            for (Email email : employee.getEmails()) {
                Email newEmail = new Email();
                newEmail.setEmail(email.getEmail());
                newEmail.setEmployee(newEmployee);
                newEmployee
                        .getEmails()
                        .add(newEmail);
            }
        }

        newEmployee
                .getJobtitles()
                .clear();
        if (employee.getJobtitles() != null) {
            for (Jobtitle jobtitle : employee.getJobtitles()) {
                Jobtitle fetchecdJobtitle = jobtitleService.getById(jobtitle.getJobtitleid());
                newEmployee
                        .getJobtitles()
                        .add(fetchecdJobtitle);
            }
        }
        newEmployee.setName(employee.getName());
        newEmployee.setSalary(employee.getSalary());
        return employeeRepository.save(newEmployee);
    }

    @Transactional
    @Override
    public Employee update(long employeeid, Employee employee) throws ResourceNotFoundException {
        Employee fetchedEmployee = getById(employeeid);
        if(employee.getName() != null){
            fetchedEmployee.setName(employee.getName());
        }

        if(employee.getEmails() != null && employee.getEmails().size() > 0){
            fetchedEmployee.getEmails().clear();
            for(Email email: employee.getEmails()){
                Email newEmail = new Email(email.getEmail(), fetchedEmployee);
                fetchedEmployee.getEmails().add(newEmail);
            }
        }

        if(employee.getJobtitles() != null && employee.getJobtitles().size() > 0){
            fetchedEmployee.getJobtitles().clear();
            for(Jobtitle jobtitle : employee.getJobtitles()){
                Jobtitle fetchedJobTitle = jobtitleService.getById(jobtitle.getJobtitleid());
                fetchedEmployee.getJobtitles().add(fetchedJobTitle);
            }
        }




        return employeeRepository.save(fetchedEmployee);
    }

    @Transactional
    @Override
    public void delete(long employeeid) throws ResourceNotFoundException {
        Employee fetchedEmployee = getById(employeeid);
//        employeeRepository.delete(fetchedEmployee);
        employeeRepository.deleteById(employeeid);
    }

    @Override
    public List<Employee> getByNameLike(String part) {
        return employeeRepository.findAllByNameContainingIgnoreCase(part);
    }

    @Override
    public List<Employee> getEmployeesByEmailContaining(String part) {
        HashMap<Long,Employee> employees = new HashMap<>();
        List<Email> emails = emailService.getByNameContaining(part);
        for(Email email : emails){
            employees.put(email.getEmployee().getEmployeeid(),email.getEmployee());
        }
        return new ArrayList<>(employees.values());
    }
}
