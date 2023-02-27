package com.impact.pms.model;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MasterDataResponse {
	
	//private Iterable<DiagnosisMaster> diganosisMaster;
	private List<DiagnosisMaster> diganosisMaster;
	private List<ProcedureMaster> procedureMaster;
	private List<MedicationMaster> medicationMaster;
	
}
