package com.employee_country.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "employee", catalog = "ojtangular")
@EntityListeners(value = { AuditingEntityListener.class })
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;//
	private String name;
	private String phoneno;
	private String departmentit;
	private String status;
	private Date createddtm;//
	private String createdby;
	private Date updateddtm;//
	private String updatedby;
	private Country country;//

	public Employee() {
		super();
	}

	public Employee(String name, String phoneno, String departmentit, String status, Date createddtm, String createdby,
			Date updateddtm, String updatedby, Country country) {
		super();
		this.name = name;
		this.phoneno = phoneno;
		this.departmentit = departmentit;
		this.status = status;
		this.createddtm = createddtm;
		this.createdby = createdby;
		this.updateddtm = updateddtm;
		this.updatedby = updatedby;
		this.country = country;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "phoneno", nullable = false, length = 45)
	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	@Column(name = "departmentit", nullable = false, length = 45)
	public String getDepartmentit() {
		return departmentit;
	}

	public void setDepartmentit(String departmentit) {
		this.departmentit = departmentit;
	}

	@Column(name = "status", nullable = false, length = 45)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "createddtm", nullable = false, length = 45, updatable = false)
	public Date getCreateddtm() {
		return createddtm;
	}

	public void setCreateddtm(Date createddtm) {
		this.createddtm = createddtm;
	}

	@CreatedBy
	@Column(name = "createdby", nullable = false, length = 45, updatable = false)
	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	@Column(name = "updateddtm", nullable = false, length = 45)
	public Date getUpdateddtm() {
		return updateddtm;
	}

	public void setUpdateddtm(Date updateddtm) {
		this.updateddtm = updateddtm;
	}

	@LastModifiedBy
	@Column(name = "updatedby", nullable = false, length = 45)
	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

//data loading on spot means eager
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cid", nullable = false)
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phoneno=" + phoneno + ", departmentit=" + departmentit
				+ ", status=" + status + ", createddtm=" + createddtm + ", createdby=" + createdby + ", updateddtm="
				+ updateddtm + ", updatedby=" + updatedby + ", country=" + country + "]";
	}

}
