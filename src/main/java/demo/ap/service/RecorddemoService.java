package demo.ap.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.ap.entity.Recorddemo;
import demo.ap.repo.Recorddemorepo;
@Service
public class RecorddemoService {

    @Autowired
    private Recorddemorepo repo;

    public Map<String, Object> getNestedData() {

        List<Recorddemo> records = repo.findAll();

        Map<String, Object> result = new LinkedHashMap<>();

        for (Recorddemo r : records) {

            String subject = r.getSubjectname();
            String mainTopic = r.getMaintopicname();
            String subTopic = r.getSubtopicname();
            String theory = r.getTheory();

            Map<String, Object> subjectMap =
                (Map<String, Object>) result.computeIfAbsent(
                    subject,
                    k -> new LinkedHashMap<>()
                );

            Map<String, String> topicMap =
                (Map<String, String>) subjectMap.computeIfAbsent(
                    mainTopic,
                    k -> new LinkedHashMap<>()
                );

            topicMap.put(subTopic, theory);
        }

        return result;
    }
}