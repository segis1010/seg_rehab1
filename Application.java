package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//import MyJAProject.seg_rehab.Contractor; //***********

@SpringBootApplication
// @EntityScan(basePackages = "MyJAProject.seg_rehab")
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(ContractorRepository repository) {
		return (args) -> {
			// save a couple of customers

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Contractor aContractor : repository.findAll()) {
				log.info(aContractor.toString());
			}
			log.info("");

			// fetch an individual customer by ID

			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			for (Contractor aContractor : repository.findAll()) {
				log.info(aContractor.toString());
			}
			log.info("");

		    log.info("");

			// log.info("");
		};
	}

}