package ua.tania.service;

import org.springframework.cache.annotation.Cacheable;
import ua.tania.entity.Customer;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Tania Nebesna on 18.03.2019
 */
public interface CustomerService {
    List<Customer> findAll();

    Customer findById(BigDecimal id);

    void insert(Customer customer);

    void update(Customer customer);

    void delete(BigDecimal id);

    List<Customer> findAllByCreditLimitLessThan(BigDecimal creditLimit);

    List<Customer> findAllByCompany(String company);

}
