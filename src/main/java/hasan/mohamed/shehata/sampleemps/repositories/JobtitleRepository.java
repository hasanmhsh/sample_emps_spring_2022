package hasan.mohamed.shehata.sampleemps.repositories;

import hasan.mohamed.shehata.sampleemps.models.Jobtitle;
import org.springframework.data.repository.CrudRepository;

public interface JobtitleRepository extends CrudRepository<Jobtitle, Long> {
    public Jobtitle findByTitleEqualsIgnoreCase(String title);
}
