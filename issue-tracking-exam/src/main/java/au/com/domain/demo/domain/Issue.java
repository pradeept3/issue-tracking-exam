package au.com.domain.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Issue {

	@Override
	public String toString() {
		return "Issue [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", reporter=" + reporter + ", assignee=" + assignee + ", created=" + created + ", completed="
				+ completed + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "status")
	private String status;

	@Column(name = "reporter", nullable = false )
	private Long reporter;



	@Column(name = "assignee", nullable = false)
	private Long assignee;

	//private transient String confirmPassword;
	@Column(name = "created", nullable = false)
	private java.sql.Date created;

	@Column(name = "completed", nullable = false)
	private java.sql.Date completed;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public Long getReporter() {
		return reporter;
	}

	public void setReporter(Long reporter) {
		this.reporter = reporter;
	}

	public Long getAssignee() {
		return assignee;
	}

	public void setAssignee(Long assignee) {
		this.assignee = assignee;
	}

	public java.sql.Date getCreated() {
		return created;
	}

	public void setCreated(java.sql.Date created) {
		this.created = created;
	}

	public java.sql.Date getCompleted() {
		return completed;
	}

	public void setCompleted(java.sql.Date completed) {
		this.completed = completed;
	}
	
}