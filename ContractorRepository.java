package hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//import MyJAProject.seg_rehab.Contractor;

	
public interface ContractorRepository extends CrudRepository<Contractor, Long> {

	// Collection<Contractor> findByBlah(String filterText);
	List<Contractor> findBycCompanyName(String cCompanyName);

	// Collection<Contractor> findBycontractorId(String filterText); //************
	   
	}


