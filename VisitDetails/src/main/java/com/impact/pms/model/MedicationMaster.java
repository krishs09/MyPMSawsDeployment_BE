package com.impact.pms.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="medication_master")
public class MedicationMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="medication_id")
	private Long medicationId;
	@Column(name="drug_id")
    private Long drugId; 
	@Column(name="drug_name")
    private String drugName; 
	@Column(name="drug_generic_name")
    private String drugGenericName;
	@Column(name="drug_brand")
    private String drugBrand; 
	@Column(name="drug_form")
    private String drugForm;
	@Column(name="drug_strength")
    private String drugStrength; 
	@Column(name="created_at")
    private LocalDateTime createdAt; 
}
