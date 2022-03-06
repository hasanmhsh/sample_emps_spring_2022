package hasan.mohamed.shehata.sampleemps;

import hasan.mohamed.shehata.sampleemps.models.Email;
import hasan.mohamed.shehata.sampleemps.models.Employee;
import hasan.mohamed.shehata.sampleemps.models.Jobtitle;
import hasan.mohamed.shehata.sampleemps.services.EmailService;
import hasan.mohamed.shehata.sampleemps.services.EmployeeService;
import hasan.mohamed.shehata.sampleemps.services.JobtitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Transactional
@Component
public class SeedData implements CommandLineRunner {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JobtitleService jobtitleService;

    @Override
    public void run(String... args) throws Exception {
        Jobtitle engineer = new Jobtitle("Engineer");
        engineer.setCreatedby("SYSTEM");
        engineer.setCreateddate(new Date(System.currentTimeMillis()));
        engineer.setLastmodifiedby("SYSTEM");
        engineer.setLastmodifieddate(new Date(System.currentTimeMillis()));

        Jobtitle developer = new Jobtitle("Developer");
        developer.setCreatedby("SYSTEM");
        developer.setCreateddate(new Date(System.currentTimeMillis()));
        developer.setLastmodifiedby("SYSTEM");
        developer.setLastmodifieddate(new Date(System.currentTimeMillis()));

        Jobtitle technician = new Jobtitle("Technician");
        technician.setCreatedby("SYSTEM");
        technician.setCreateddate(new Date(System.currentTimeMillis()));
        technician.setLastmodifiedby("SYSTEM");
        technician.setLastmodifieddate(new Date(System.currentTimeMillis()));

        jobtitleService.save(engineer);
        jobtitleService.save(developer);
        jobtitleService.save(technician);

        Employee emp1 = new Employee();
        emp1.setName("Ahmed");
        emp1.setSalary(5000.0D);
        emp1.getEmails().add(new Email("ahmed@one.com",emp1));
        emp1.getEmails().add(new Email("ahmed@one.local",emp1));
        engineer  = jobtitleService.getByTitle("engineer");
        developer  = jobtitleService.getByTitle("developer");
        emp1.getJobtitles().add(engineer);
        emp1.getJobtitles().add(developer);
        emp1.setCreatedby("SYSTEM");
        emp1.setCreateddate(new Date(System.currentTimeMillis()));
        emp1.setLastmodifiedby("SYSTEM");
        emp1.setLastmodifieddate(new Date(System.currentTimeMillis()));


        Employee emp2 = new Employee();
        emp2.setName("Mohamed");
        emp2.setSalary(6000.0D);
        emp2.getEmails().add(new Email("mohamed@two.com",emp2));
        emp2.getEmails().add(new Email("mohamed@two.local",emp2));
        technician  = jobtitleService.getByTitle("technician");
        developer  = jobtitleService.getByTitle("developer");
        emp2.getJobtitles().add(technician);
        emp2.getJobtitles().add(developer);
        emp2.setCreatedby("SYSTEM");
        emp2.setCreateddate(new Date(System.currentTimeMillis()));
        emp2.setLastmodifiedby("SYSTEM");
        emp2.setLastmodifieddate(new Date(System.currentTimeMillis()));


        Employee emp3 = new Employee();
        emp3.setName("Hasan");
        emp3.setSalary(7000.0D);
        emp3.getEmails().add(new Email("hasan@three.com",emp3));
        emp3.getEmails().add(new Email("hasan@three.local",emp3));
        developer  = jobtitleService.getByTitle("developer");
        emp3.getJobtitles().add(developer);
        emp3.setCreatedby("SYSTEM");
        emp3.setCreateddate(new Date(System.currentTimeMillis()));
        emp3.setLastmodifiedby("SYSTEM");
        emp3.setLastmodifieddate(new Date(System.currentTimeMillis()));


        Employee emp4 = new Employee();
        emp4.setName("Ali");
        emp4.setSalary(8000.0D);
        emp4.getEmails().add(new Email("ali@four.com",emp4));
        emp4.getEmails().add(new Email("ali@one.four",emp4));
        engineer  = jobtitleService.getByTitle("engineer");
        emp4.getJobtitles().add(engineer);
        emp4.setCreatedby("SYSTEM");
        emp4.setCreateddate(new Date(System.currentTimeMillis()));
        emp4.setLastmodifiedby("SYSTEM");
        emp4.setLastmodifieddate(new Date(System.currentTimeMillis()));


        Employee emp5 = new Employee();
        emp5.setName("Younis");
        emp5.setSalary(9000.0D);
        emp5.getEmails().add(new Email("younis@five.com",emp5));
        emp5.getEmails().add(new Email("younis@five.local",emp5));
        engineer  = jobtitleService.getByTitle("engineer");
        developer  = jobtitleService.getByTitle("developer");
        technician = jobtitleService.getByTitle("technician");
        emp5.getJobtitles().add(engineer);
        emp5.getJobtitles().add(developer);
        emp5.getJobtitles().add(technician);
        emp5.setCreatedby("SYSTEM");
        emp5.setCreateddate(new Date(System.currentTimeMillis()));
        emp5.setLastmodifiedby("SYSTEM");
        emp5.setLastmodifieddate(new Date(System.currentTimeMillis()));

        employeeService.save(emp1);
        employeeService.save(emp2);
        employeeService.save(emp3);
        employeeService.save(emp4);
        employeeService.save(emp5);
    }
}
