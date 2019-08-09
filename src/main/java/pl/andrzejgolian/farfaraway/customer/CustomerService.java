package pl.andrzejgolian.farfaraway.customer;

import org.springframework.stereotype.Service;
import pl.andrzejgolian.farfaraway.holiday.ItemNotFoundException;

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

    public Customer getCustomer(long customerId) throws ItemNotFoundException {

        return customerRepository.findById(customerId)
                .orElseThrow(() -> new ItemNotFoundException(customerId));
    }

    public void delete(long customerId) {

        customerRepository.deleteById(customerId);
    }
}
