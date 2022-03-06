package hasan.mohamed.shehata.sampleemps.repositories;

import hasan.mohamed.shehata.sampleemps.models.Email;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmailRepository extends CrudRepository<Email, Long> {
    public List<Email> findAllByEmailContainingIgnoreCase(String part);
}
