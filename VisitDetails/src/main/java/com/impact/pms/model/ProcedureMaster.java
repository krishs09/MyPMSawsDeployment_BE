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
@Table(name="procedure_master")
public class ProcedureMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="procedure_id")
	private Long procedureId ;
	@Column(name="procedure_code")
    private String procedureCode ;
	@Column(name="procedure_description")
    private String procedureDescription ;
	@Column(name="created_at")
    private LocalDateTime createdAt ;
}
