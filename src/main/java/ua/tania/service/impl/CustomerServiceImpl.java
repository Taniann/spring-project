package ua.tania.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ua.tania.entity.Customer;
import ua.tania.exception.DeleteException;
import ua.tania.repository.CustomerRepository;
import ua.tania.service.CustomerService;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Created by Tania Nebesna on 18.03.2019
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    private static final Logger LOG = LogManager.getLogger(CustomerServiceImpl.class);

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();

    }

    @Override
    public Customer findById(BigDecimal id) {
        return Optional.ofNullable(customerRepository.findById(id)).get().orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void insert(Customer customer) {
        LOG.debug("insertCustomer, customer={}", customer);
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);

    }

    @Override
    public void delete(BigDecimal id) {
        LOG.debug("deleteCostomer, id={}", id);
        try {
            customerRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            LOG.warn("Cannot deleteCustomer with id{}, because it doesn't present", id);
            throw new DeleteException("Cannot delete Customer by Id=" + id + ", because it doesn't present");
        }
        LOG.debug("deleteCustomer completed");    }

    @Override
    public List<Customer> findAllByCreditLimitLessThan(BigDecimal creditLimit) {
        return customerRepository.findAllByCreditLimitLessThan(creditLimit);
    }

    @Override
    public List<Customer> findAllByCompany(String company) {
        return customerRepository.findAllByCompany(company);
    }

}
