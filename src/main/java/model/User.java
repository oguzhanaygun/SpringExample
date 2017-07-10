package model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class User {

	@Id
	@Column(name = "email" ,nullable = false)
	private String email;

	@Column(name = "password")
	private String pass;

	@Column(name = "name")
	private String name;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "enabled", columnDefinition = "boolean default true",nullable=false)
	private boolean enabled;
	
	@Column(name="role",columnDefinition="varchar(255) DEFAULT 'USER'",nullable=false)
	private String role="USER";

	@DateTimeFormat(pattern = "dd/mm/yyyy")
	@Column(name = "birthday", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	@Column(name = "sex")
	private boolean sex;
	@ManyToMany
	@JoinTable(name = "Bills", joinColumns = { @JoinColumn(name = "email") }, inverseJoinColumns = { @JoinColumn(name = "productId") })
	private Set<Product> products;
	
	@OneToMany(mappedBy="comment")
	private Set<Comment> comments;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}


	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	

}
