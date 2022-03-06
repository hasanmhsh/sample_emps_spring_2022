package hasan.mohamed.shehata.sampleemps.services;

import hasan.mohamed.shehata.sampleemps.models.Email;

import java.util.List;

public interface EmailService {
    public List<Email> getAll();
    public Email getById(long emailid);
    public Email save(Email email);
    public Email update(long emailid, Email email);
    public void delete(long emailid);

    public List<Email> getByNameContaining(String part);
}
