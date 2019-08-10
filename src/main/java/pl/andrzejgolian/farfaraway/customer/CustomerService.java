package pl.andrzejgolian.farfaraway.customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {

        return customerRepository.findAll();
    }

    public void createCustomer(Customer customer) {

        customerRepository.save(customer);
    }

    public Customer getCustomer(long customerId) throws RuntimeException {

        return customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono klienta"));
    }

    public void delete(long customerId) {

        customerRepository.deleteById(customerId);
    }
}
