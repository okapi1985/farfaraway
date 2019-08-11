package pl.andrzejgolian.farfaraway.customer;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class CustomerService implements UserDetailsService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {

        return customerRepository.findAll();
    }

    public void createCustomer(Customer customer) {
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

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Niewłaściwe nazwisko"));

        return new org.springframework.security.core.userdetails.User(customer.getEmail(), customer.getPassword(),
                Collections.emptyList());
    }
}
