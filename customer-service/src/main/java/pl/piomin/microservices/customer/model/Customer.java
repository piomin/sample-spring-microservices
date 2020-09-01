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

    public Customer(int id, String pesel, String name, CustomerType type) {
        this.id = id;
        this.pesel = pesel;
        this.name = name;
        this.type = type;
    }
}
