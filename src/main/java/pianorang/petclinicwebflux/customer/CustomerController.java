package pianorang.petclinicwebflux.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Slf4j
@RestController
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    @GetMapping("/test")
    public String test(){
        return "Hello";
    }

    @GetMapping("/customer_find")
    public Flux<Customer> customerFind(){
        return repository.findAll().log();
    }

    @GetMapping("/customer_in")
    public Mono<Customer> customer(){
        // save a few customers
        return repository.saveAll(Arrays.asList(new Customer("Jack", "Bauer"),
                new Customer("Chloe", "O'Brian"),
                new Customer("Kim", "Bauer"),
                new Customer("David", "Palmer"),
                new Customer("Michelle", "Dessler")))
                .last();

//        // fetch all customers
//        log.info("Customers found with findAll():");
//        log.info("-------------------------------");
//        repository.findAll().doOnNext(customer -> {
//            log.info(customer.toString());
//        }).blockLast(Duration.ofSeconds(10));
//
//        log.info("");
//
//        // fetch an individual customer by ID
//        repository.findById(1L).doOnNext(customer -> {
//            log.info("Customer found with findById(1L):");
//            log.info("--------------------------------");
//            log.info(customer.toString());
//            log.info("");
//        }).block(Duration.ofSeconds(10));
//
//
//        // fetch customers by last name
//        log.info("Customer found with findByLastName('Bauer'):");
//        log.info("--------------------------------------------");
//        repository.findByLastName("Bauer").doOnNext(bauer -> {
//            log.info(bauer.toString());
//        }).blockLast(Duration.ofSeconds(10));;
//        log.info("");

    }
}
