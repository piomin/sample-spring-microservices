package pl.piomin.microservices.customer.api;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.piomin.microservices.customer.data.CustomerRepository;
import pl.piomin.microservices.customer.intercomm.AccountClient;
import pl.piomin.microservices.customer.model.Account;
import pl.piomin.microservices.customer.model.Customer;

@RestController
public class Api {
	
	@Autowired
	private AccountClient accountClient;
	
	@Autowired
	CustomerRepository repository;
	
	protected Logger logger = Logger.getLogger(Api.class.getName());
	
	@RequestMapping("/customers/pesel/{pesel}")
	public Customer findByPesel(@PathVariable("pesel") String pesel) {
		logger.info(String.format("Customer.findByPesel(%s)", pesel));
		return repository.findByPesel(pesel);
	}
	
	@RequestMapping("/customers")
	public List<Customer> findAll() {
		logger.info("Customer.findAll()");
		return repository.findAll();
	}
	
	@RequestMapping("/customers/{id}")
	public Customer findById(@PathVariable("id") String id) {
		logger.info(String.format("Customer.findById(%s)", id));
		Customer customer = repository.findById(id);
		List<Account> accounts =  accountClient.getAccounts(id);
		customer.setAccounts(accounts);
		return customer;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/customers")
	public Customer add(@RequestBody Customer customer) {
		logger.info(String.format("Customer.add(%s)", customer));
		return repository.save(customer);
	}
	
}
