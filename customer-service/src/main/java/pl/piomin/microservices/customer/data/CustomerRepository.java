package pl.piomin.microservices.customer.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import pl.piomin.microservices.customer.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	public Customer findByPesel(String pesel);
	public Customer findById(String id);
	
}
