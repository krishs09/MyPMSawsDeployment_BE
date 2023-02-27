package com.impact.pms.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="EmergencyContact")
public class EmergencyContactInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long emgId;
	private Long patientId;
	private String firstName;
	private String lastName;
	private String relationship;
	private String email;
	private String address;
	private Long contact;
	private int accessNeeded;
	@OneToOne(mappedBy = "emergencyContact")
	private DemographicDetails demographicDetail;
	
}
