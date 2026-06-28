package demo.ap.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.ap.entity.Maintopic;

@Repository
public interface Maintopicrepo extends JpaRepository<Maintopic,Long> {

}
