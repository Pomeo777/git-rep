package ua.roman.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="disease")
public class Disease {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name ="name")
	private String name;
	@Column(name="context")
	private String context;
	
	public Disease(int id, String name, String context) {
	
		this.id = id;
		this.name = name;
		this.context = context;
	}

	public Disease(){
		
	}
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getContext() {
		return context;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContext(String context) {
		this.context = context;
	}
	
	
	
	
}