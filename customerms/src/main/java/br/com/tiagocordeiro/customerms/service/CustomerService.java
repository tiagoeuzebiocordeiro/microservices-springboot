package br.com.tiagocordeiro.customerms.service;

import br.com.tiagocordeiro.customerms.domain.Customer;
import br.com.tiagocordeiro.customerms.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public Customer save(Customer obj) {
        return customerRepository.save(obj);
    }

    @Transactional(readOnly = true)
    public Optional<Customer> findByCpf(String cpf) {
        return customerRepository.findByCpf(cpf);
    }

}
