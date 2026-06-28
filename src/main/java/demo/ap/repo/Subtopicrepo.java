package demo.ap.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.ap.entity.Subtopic;


@Repository
public interface Subtopicrepo extends JpaRepository<Subtopic,Long>{

}
