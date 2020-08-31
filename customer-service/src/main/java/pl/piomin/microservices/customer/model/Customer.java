package pl.piomin.microservices.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private Integer id;
    private String pesel;
    private String name;
    private CustomerType type;
    private List<Account> accounts;

}
