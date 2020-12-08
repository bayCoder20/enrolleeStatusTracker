package org.meridian.enrolleetracker.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@Table(name = "tbl_enrollee")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Enrollee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="enrollee_id")
	private Long id;
	
	@OneToMany(targetEntity=Dependent.class, cascade = CascadeType.ALL)
	@JoinColumn(name="enrollee_fk", referencedColumnName = "enrollee_id")
	private List<Dependent> dependents = new ArrayList<>();
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_initial")
	private String middleInitial;
	
	@Column(name="birth_date")
	private String birthDate;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="sex")
	private String sex;
	
	@Column(name="active_status")
	private Boolean activeStatus;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)	
	@Column(name="created_date", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
	private Date createdDate;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)	
	@Column(name="last_update_date", nullable = false, insertable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
	private Date lastUpdateDate;
}
