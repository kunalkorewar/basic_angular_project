package com.employee_country.auditablebase;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/*@MappedSuperclass
@EntityListeners(value = { AuditingEntityListener.class })
*/
public class AudiTableBase {

	//@CreatedBy
	/*@Column(name = "createdby", nullable = false, length = 45, updatable = false)
	private String createdby;

	@CreatedDate
	@Column(name = "createddtm", nullable = false, length = 45, updatable = false)
	private Date createddtm;

	@LastModifiedBy
	@Column(name = "updatedby", nullable = false, length = 45)
	private String updatedby;

	@LastModifiedDate
	@Column(name = "updateddtm", nullable = false, length = 45)
	private Date updateddtm;
*/
}
