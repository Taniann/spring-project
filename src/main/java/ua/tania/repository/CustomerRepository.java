package ua.tania.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.tania.entity.Customer;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Tania Nebesna on 18.03.2019
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, BigDecimal> {
    List<Customer> findAllByCreditLimitLessThan(BigDecimal creditLimit);

    @Cacheable("customerCashed")
    List<Customer> findAllByCompany(String company);
}
