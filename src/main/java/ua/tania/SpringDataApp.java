package ua.tania;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.tania.service.CustomerService;

import java.math.BigDecimal;


/**
 * Created by Tania Nebesna on 18.03.2019
 */
public class SpringDataApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("ua.tania.config");

        CustomerService customerService = context.getBean(CustomerService.class);
        customerService.findAll().forEach(System.out::println);
        customerService.findAllByCreditLimitLessThan(BigDecimal.valueOf(500)).forEach(System.out::println);
        customerService.findAllByCompany("Апельсин").forEach(System.out::println);
        System.out.println("---------------------CACHING------------------------");
        customerService.findAllByCompany("Апельсин").forEach(System.out::println);
    }

}
