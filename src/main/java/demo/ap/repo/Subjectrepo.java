package demo.ap.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.ap.entity.Subject;


@Repository
public interface Subjectrepo extends JpaRepository<Subject,Long>{

}
