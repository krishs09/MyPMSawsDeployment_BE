package com.impact.pms.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="diagnosis_master")
public class DiagnosisMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="diagnosis_id")
	private Long diagnosisId ;
	@Column(name="diagnosis_category")
	   private String diagnosisCategory;
	@Column(name="diagnosis_code")
	   private String diagnosisCode;
	@Column(name="diagnosis_description")
	   private String diagnosisDescription ;
	@Column(name="created_at")
	   private LocalDateTime createdAt ;
}
