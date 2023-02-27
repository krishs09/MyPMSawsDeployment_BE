package com.impact.pms.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Data
@NoArgsConstructor
@Entity
@Table(name="Patient_Demographic_Details")
public class DemographicDetails  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="demographic_id")
	private Long demographicId;
	@Column(name="patientId")
	private Long patientId;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="dateOFBirth")
	private LocalDate dateOFBirth;
	@Column(name="age")
	private int age;
	@Column(name="gender")
	private String gender;
	@Column(name="race")
	private String race;
	@Column(name="ethinicity")
	private String ethinicity;
	@Column(name="languagesKnown")
	private String languagesKnown;
	@Column(name="email")
	private String email;
	@Column(name="homeAddress")
	private String homeAddress;
	@Column(name="contact")
	private Long contact;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="emergency_contact_id",referencedColumnName = "emgId")
	 @JsonIgnore
	private EmergencyContactInfo emergencyContact;
	
//	@Column(nullable = false, columnDefinition = "int default 0") 
	 private Boolean anyAllergy;

	  @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	  @JoinColumn(name = "pat_demographicId", referencedColumnName = "demographic_id") 
	  @JsonIgnore
	  private List<Allergy> allergy;
		 
		/*
		 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy =
		 * "demographicDetail") private Set<Allergy> allergy = new HashSet<>();
		 */
}
