package hasan.mohamed.shehata.sampleemps.services;

import hasan.mohamed.shehata.sampleemps.models.Email;
import hasan.mohamed.shehata.sampleemps.models.Employee;
import hasan.mohamed.shehata.sampleemps.models.Jobtitle;
import hasan.mohamed.shehata.sampleemps.repositories.EmailRepository;
import hasan.mohamed.shehata.sampleemps.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "emailService")
public class EmailServiceImpl implements EmailService{
    @Autowired
    private EmailRepository emailRepository;


    @Override
    public List<Email> getAll() {
        return null;
    }

    @Override
    public Email getById(long emailid) {
        return null;
    }

    @Override
    public Email save(Email email) {
        return null;
    }

    @Override
    public Email update(long emailid, Email email) {
        return null;
    }

    @Override
    public void delete(long emailid) {

    }

    @Override
    public List<Email> getByNameContaining(String part) {
        List<Email> emails = emailRepository.findAllByEmailContainingIgnoreCase(part);
        return emails;
    }

}
