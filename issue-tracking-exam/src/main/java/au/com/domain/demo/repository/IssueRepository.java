package au.com.domain.demo.repository;

import au.com.domain.demo.domain.Issue;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IssueRepository extends CrudRepository<Issue,Long> {
	//List<Issue> findByName(String title);
}