package au.com.domain.demo.service;



import au.com.domain.demo.dao.IssueDAO;
import au.com.domain.demo.domain.Issue;
import au.com.domain.demo.repository.IssueRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IssueService {

   @Autowired
   private IssueDAO issueDAO;

    @Autowired
    private IssueRepository issueRepository;

    public Object findAll(){
        return issueRepository.findAll();
    }

    public Issue findById(Long id){
        return issueRepository.findOne(id);
    }

    public Issue save(Issue issue){
        return issueRepository.save(issue);
    }
    
    public void deleteById(Long id) {
    	issueRepository.delete(id);
    }
   
}