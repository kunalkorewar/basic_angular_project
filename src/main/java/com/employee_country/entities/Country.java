package com.employee_country.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country",catalog ="ojtangular" )
public class Country implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer cid;
	private String cname;

	public Country() {
		super();
	}

	public Country(String cname) {
		super();
		this.cname = cname;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid",unique = true,nullable = false)
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	@Column(name = "cname",nullable = false,length = 45)
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Country [cid=" + cid + ", cname=" + cname + "]";
	}

}
