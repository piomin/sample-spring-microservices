package pl.piomin.microservices.account.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.piomin.microservices.account.exceptions.AccountNotFoundException;
import pl.piomin.microservices.account.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accounts")
@Slf4j
public class Api {

    private List<Account> accounts;

    public Api() {
        accounts = new ArrayList<>();
        accounts.add(new Account(1, 1, "111111"));
        accounts.add(new Account(2, 2, "222222"));
        accounts.add(new Account(3, 3, "333333"));
        accounts.add(new Account(4, 4, "444444"));
        accounts.add(new Account(5, 1, "555555"));
        accounts.add(new Account(6, 2, "666666"));
        accounts.add(new Account(7, 2, "777777"));
    }

    @RequestMapping("/{number}")
    public Account findByNumber(@PathVariable("number") String number) throws AccountNotFoundException {
        log.info(String.format("Account.findByNumber(%s)", number));
        return accounts.stream()
                .filter(it -> it.getNumber().equals(number))
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException(number));
    }

    @RequestMapping("/customer/{customer}")
    public List<Account> findByCustomer(@PathVariable("customer") Integer customerId) {
        log.info(String.format("Account.findByCustomer(%s)", customerId));
        return accounts.stream()
                .filter(it -> it.getCustomerId().intValue() == customerId.intValue())
                .collect(Collectors.toList());
    }

    @RequestMapping("")
    public List<Account> findAll() {
        log.info("Account.findAll()");
        return accounts;
    }

}
