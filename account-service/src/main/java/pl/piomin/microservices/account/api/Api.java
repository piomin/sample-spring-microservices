package pl.piomin.microservices.account.api;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.piomin.microservices.account.data.AccountRepository;
import pl.piomin.microservices.account.model.Account;

@RestController
public class Api {

	@Autowired
	AccountRepository repository;

	protected Logger logger = Logger.getLogger(Api.class.getName());

	@RequestMapping("/accounts/{number}")
	public Account findByNumber(@PathVariable("number") String number) {
		logger.info(String.format("Account.findByNumber(%s)", number));
		return repository.findByNumber(number);
	}

	@RequestMapping("/accounts/customer/{customer}")
	public List<Account> findByCustomer(@PathVariable("customer") String customerId) {
		logger.info(String.format("Account.findByCustomer(%s)", customerId));
		return repository.findByCustomerId(customerId);
	}

	@RequestMapping("/accounts")
	public List<Account> findAll() {
		logger.info("Account.findAll()");
		return repository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/accounts")
	public Account add(@RequestBody Account account) {
		logger.info(String.format("Account.add(%s)", account));
		return repository.save(account);
	}

}
