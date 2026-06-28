package demo.ap.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Recorddemo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
	private Long id;
	
	private String subjectname;
	private String maintopicname;
	private String subtopicname;
	
	@Column(columnDefinition = "TEXT")
	private String theory;
	public String getSubjectname() {
		return subjectname;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public String getMaintopicname() {
		return maintopicname;
	}
	public void setMaintopicname(String maintopicname) {
		this.maintopicname = maintopicname;
	}
	public String getSubtopicname() {
		return subtopicname;
	}
	public void setSubtopicname(String subtopicname) {
		this.subtopicname = subtopicname;
	}
	public String getTheory() {
		return theory;
	}
	public void setTheory(String theory) {
		this.theory = theory;
	}
	
	

}
