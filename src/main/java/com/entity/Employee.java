package com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="t_employee")
public class Employee {
	
	@Id
	@Column(name="employee_id")
	private Integer id;
	
	@Column(name="employee_name")
	private String name;
	
	@Column(name="employee_departmentId")
	private Integer departmentId;
	
	@Column(name="employee_gender")
	private String gender;
	
	@Column(name="employee_tel")
	private String tel;
	
	@Column(name="employee_address")
	private String address;
	
	@Column(name="book_name")
	private String age;
	
	@DateTimeFormat(pattern="yyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date createTime;
	
	@DateTimeFormat(pattern="yyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", departmentId=" + departmentId + ", gender=" + gender
				+ ", tel=" + tel + ", address=" + address + ", age=" + age + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getDepartmentId()=" + getDepartmentId() + ", getGender()=" + getGender() + ", getTel()=" + getTel()
				+ ", getAddress()=" + getAddress() + ", getAge()=" + getAge() + ", getCreateTime()=" + getCreateTime()
				+ ", getUpdateTime()=" + getUpdateTime() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
