package au.com.domain.demo.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import au.com.domain.demo.domain.Issue;
import au.com.domain.demo.service.IssueService;



@RestController
@RequestMapping(value = {"issue","/"})
//@Transactional


public class IssueController {

    
    private IssueService issueService;
    
    @Autowired
    public void setIssueService(IssueService issueService) {
		this.issueService = issueService;
	}
    
  @RequestMapping(value= {"/","index"})
    
    
    public ModelAndView index() {
       // model.addAttribute("issues", issueService.findAll());
    	System.out.println("ISSUES:::::::::"+issueService.findAll());
    	ModelAndView model = new ModelAndView("index");
        model.addObject("issues", issueService.findAll());
        return model;
    }
    
    @RequestMapping(value = "create")
    public ModelAndView create(Issue issue){
    	ModelAndView model = new ModelAndView("create");
    	
		model.addObject("create");
        
        return model;
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ModelAndView save(Issue issue){
    	ModelAndView model = new ModelAndView("index");
    	model.addObject(issueService.save(issue));
    	model.addObject("issues", issueService.findAll());
    	return model;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Long id){
    	ModelAndView model = new ModelAndView("edit");
    	
    	model.addObject(issueService.findById(id));
    	model.addObject("edit");
        return model;
    }


    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ModelAndView update(Issue issue){
       // issueService.save(issue);
    	ModelAndView model = new ModelAndView("index");
    	model.addObject(issueService.save(issue));
    	model.addObject("issues", issueService.findAll());

        return model;
    }

    @RequestMapping(value = { "/delete{id}" }, method = RequestMethod.POST)
    public ModelAndView deleteIssue(@PathVariable Long id) {
    	ModelAndView model = new ModelAndView("delete");
    	model.addObject(id);//addObject(issueService.deleteById(id));
        return model;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") Long id){
    	ModelAndView model = new ModelAndView("index");
    	
    	issueService.deleteById(id);
    	model.addObject(issueService);
    	model.addObject("issues", issueService.findAll());
    	
        return model;
    }
    @RequestMapping(value = "/test")
    public String test(){
        return " hello world";
    }


}