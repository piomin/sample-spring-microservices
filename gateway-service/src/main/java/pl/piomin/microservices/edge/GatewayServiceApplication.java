package pl.piomin.microservices.edge;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class GatewayServiceApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(GatewayServiceApplication.class).web(true).run(args);
    }
}
