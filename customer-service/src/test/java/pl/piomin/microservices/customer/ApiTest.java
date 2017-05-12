package pl.piomin.microservices.customer;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import pl.piomin.microservices.customer.model.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApiTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void exampleTest() throws InterruptedException {
		Random r = new Random();
		for (int i=0; i<1000; i++) {
			Customer c = this.restTemplate.getForObject("/customers/{id}", Customer.class, r.nextInt(3)+1);
			System.out.println("Customer: " + c);
			Thread.sleep(500);
		}
	}
	
}
