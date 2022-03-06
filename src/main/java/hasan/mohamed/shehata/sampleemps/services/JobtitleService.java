package hasan.mohamed.shehata.sampleemps.services;


import hasan.mohamed.shehata.sampleemps.models.Jobtitle;

import java.util.List;

public interface JobtitleService {
    List<Jobtitle> getAll();
    Jobtitle getById(long jobtitleid);
    Jobtitle save(Jobtitle jobtitle);
    Jobtitle update(long jobtitleid, Jobtitle jobtitle);
    void delete(long jobtitleid);
    public Jobtitle getByTitle(String title);
}
