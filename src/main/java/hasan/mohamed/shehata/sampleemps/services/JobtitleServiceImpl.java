package hasan.mohamed.shehata.sampleemps.services;

import hasan.mohamed.shehata.sampleemps.exceptions.ResourceNotFoundException;
import hasan.mohamed.shehata.sampleemps.models.Email;
import hasan.mohamed.shehata.sampleemps.models.Employee;
import hasan.mohamed.shehata.sampleemps.models.Jobtitle;
import hasan.mohamed.shehata.sampleemps.repositories.EmployeeRepository;
import hasan.mohamed.shehata.sampleemps.repositories.JobtitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "jobtitleService")
public class JobtitleServiceImpl implements JobtitleService {
    @Autowired
    private JobtitleRepository jobtitleRepository;

    @Override
    public List<Jobtitle> getAll() {
        List<Jobtitle> jobtitles = new ArrayList<>();
        jobtitleRepository.findAll().iterator().forEachRemaining(jobtitles::add);
        return jobtitles;
    }

    @Override
    public Jobtitle getById(long jobtitleid) throws ResourceNotFoundException {
        Jobtitle jobtitle = jobtitleRepository
                .findById(jobtitleid)
                .orElseThrow(() -> new ResourceNotFoundException("The job title with id = " + jobtitleid + " is not " +
                        "exist!"));
        return jobtitle;
    }

    @Transactional
    @Override
    public Jobtitle save(Jobtitle jobtitle) {
        if(jobtitle != null){
            Jobtitle newJobtitle = new Jobtitle();
            newJobtitle.setTitle(jobtitle.getTitle());
            return jobtitleRepository.save(newJobtitle);
        }
        return null;
    }

    @Override
    public Jobtitle update(long jobtitleid, Jobtitle jobtitle) {
        return null;
    }

    @Override
    public void delete(long jobtitleid) {

    }

    @Override
    public Jobtitle getByTitle(String title) {
        return jobtitleRepository.findByTitleEqualsIgnoreCase(title);
    }
}
