package pl.andrzejgolian.farfaraway.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

//    private static final String DEFAULT_ROLE = "ROLE_ADMIN";
    private CustomerRepository customerRepository;
//    private CustomerRoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

//    @Autowired
//    public void setRoleRepository(CustomerRoleRepository roleRepository) {
//        this.roleRepository = roleRepository;
//    }

    public CustomerService() {}

//    public void addWithDefaultRole(Customer customer){
//        CustomerRole defaultRole = roleRepository.findByRole(DEFAULT_ROLE);
//        customer.getRoles().add(defaultRole);
//        String passwordHash = passwordEncoder.encode(customer.getPassword());
//        customer.setPassword(passwordHash);
//        customerRepository.save(customer);
//    }

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

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Customer customer = customerRepository.findByEmail(email)
//                .orElseThrow(() -> new IllegalArgumentException("Niewłaściwe nazwisko"));
//
//        return new org.springframework.security.core.userdetails.User(customer.getEmail(), customer.getPassword(),
//                Collections.emptyList());
//    }
}
