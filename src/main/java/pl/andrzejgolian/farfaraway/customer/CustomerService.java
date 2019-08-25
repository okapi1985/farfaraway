package pl.andrzejgolian.farfaraway.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerService() {}

    public List<Customer> getCustomers() {

        return customerRepository.findAll();
    }

    public void create(Customer customer) {
        customer.setEmail(customer.getEmail());
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerRepository.save(customer);
    }

    @Transactional
    public void delete(long customerId) {

        customerRepository.deleteById(customerId);
    }

    public Customer findById(Long id) {

        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie znaleziono użytkownika"));
    }

    public Customer updateCustomer(Customer customer) {
        Customer customerToUpdate = findById(customer.getId());

        customerToUpdate.setFirstName(customer.getFirstName());
        customerToUpdate.setLastName(customer.getLastName());
        customerToUpdate.setDob(customer.getDob());
        customerToUpdate.setEmail(customer.getEmail());
        customerToUpdate.setPassword(customer.getPassword());

        return customerRepository.save(customerToUpdate);
    }
}
