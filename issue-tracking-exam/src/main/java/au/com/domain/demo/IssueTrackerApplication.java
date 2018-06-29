package au.com.domain.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan(basePackageClasses = IssueTrackerApplication.class)
public class IssueTrackerApplication {

    public static void main(final String[] args) {
        SpringApplication.run(IssueTrackerApplication.class, args);
    }
}
