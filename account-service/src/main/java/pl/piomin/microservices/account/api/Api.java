package pl.piomin.microservices.account.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.piomin.microservices.account.exceptions.AccountNotFoundException;
import pl.piomin.microservices.account.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
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

    @RequestMapping(method = RequestMethod.GET, value = "/number/{number}")
    public Account findByNumber(@PathVariable("number") String number) throws AccountNotFoundException {
        log.info(String.format("Account.findByNumber(%s)", number));
        return accounts.stream()
                .filter(it -> it.getNumber().equals(number))
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException("number : " + number));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/customer/{customer}")
    public List<Account> findByCustomer(@PathVariable("customer") Integer customerId) {
        log.info(String.format("Account.findByCustomer(%s)", customerId));
        return accounts.stream()
                .filter(it -> it.getCustomerId().intValue() == customerId.intValue())
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<Account> findAll() {
        log.info("Account.findAll()");
        return accounts;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Account findById(@PathVariable Integer id) throws AccountNotFoundException {
        log.info("Account.findAll()");
        return accounts.stream()
                .filter(it -> it.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException("id : " + id));
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public Account createNewAccount(@RequestBody Account account) {
        log.info("Account.createNewAccount()");
        if (account.getId() != null) {
            return null;
        }
        int size = accounts.size();
        account.setId(size + 1);
        accounts.add(account);
        return account;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public boolean deleteAccount(@PathVariable Integer id) {
        log.info("Account.deleteAccount()");
        try {
            Account byId = findById(id);
            accounts.remove(byId);
        } catch (AccountNotFoundException e) {
            return false;
        }
        return true;
    }

}
