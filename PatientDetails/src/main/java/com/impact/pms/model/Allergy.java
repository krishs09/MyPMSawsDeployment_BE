package com.impact.pms.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="Allergies")
public class Allergy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long allergyId;
	private Long patientId;
	private String allergyType;
	private String allergyName;
	private String description;
	private String allergyClinicalInfo;
	private int isFatal;
	private Long demographicId;
	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "demographic_id") private DemographicDetails
	 * demographicDetail;
	 */
	
}
