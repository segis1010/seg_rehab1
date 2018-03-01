package hello;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the contractors_specialities database table.
 * 
 */
@Entity
@Table(name="contractors_specialities")
@NamedQuery(name="ContractorsSpeciality.findAll", query="SELECT c FROM ContractorsSpeciality c")
public class ContractorsSpeciality implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="contractor_speciality_id")
	private int contractorSpecialityId;

	/*
	 * //bi-directional many-to-one association to Contractor
	 */
	@ManyToOne
	@JoinColumn(name="cs_contractor")
	private Contractor contractor;

	/*
	 * //bi-directional many-to-one association to Speciality
	 */
	@ManyToOne
	@JoinColumn(name="cs_speciality")
	private Speciality speciality;

	public ContractorsSpeciality() {
	}

	public int getContractorSpecialityId() {
		return this.contractorSpecialityId;
	}

	public void setContractorSpecialityId(int contractorSpecialityId) {
		this.contractorSpecialityId = contractorSpecialityId;
	}

	public Contractor getContractor() {
		return this.contractor;
	}

	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}

	public Speciality getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

}