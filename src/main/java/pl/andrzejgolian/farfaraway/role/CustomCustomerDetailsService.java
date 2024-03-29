package pl.andrzejgolian.farfaraway.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pl.andrzejgolian.farfaraway.customer.Customer;
import pl.andrzejgolian.farfaraway.customer.CustomerRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class CustomCustomerDetailsService implements UserDetailsService {

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(username);
        if (customer==null)
            throw new UsernameNotFoundException("Nie znaleziono klienta");

        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + customer.getRole());
        return new org.springframework.security.core.userdetails.User
                (customer.getEmail(),customer.getPassword(), Collections.singletonList(authority));
    }
}
