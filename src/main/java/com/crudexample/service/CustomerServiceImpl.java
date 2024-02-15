package com.crudexample.service;

import com.crudexample.entity.Customer;
import com.crudexample.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Customer newCustomer = customerRepository.save(customer);
        return newCustomer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> allCustomer =customerRepository.findAll();
        return allCustomer;

    }

    @Override
    public Customer getCustomerById(Long id) {
        Customer getCustomer = customerRepository.findById(id).orElseThrow(()-> new RuntimeException("Id bulunamadı"));
        return getCustomer;
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);
        if (existingCustomer.isPresent()){
            Customer updatedCustomer = existingCustomer.get();
            updatedCustomer.setFirstName(customer.getFirstName());
            updatedCustomer.setLastName(customer.getLastName());
            updatedCustomer.setEmail(customer.getEmail());
            updatedCustomer.setPhoneNumber(customer.getPhoneNumber());
            updatedCustomer.setGender(customer.getGender());
            customerRepository.save(updatedCustomer);

            return updatedCustomer;
        }
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);

    }
}
