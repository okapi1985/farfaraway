package pl.andrzejgolian.farfaraway.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.andrzejgolian.farfaraway.customer.Customer;
import pl.andrzejgolian.farfaraway.customer.CustomerRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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
        org.springframework.security.core.userdetails.User userDetails =
                new org.springframework.security.core.userdetails.User(
                        customer.getEmail(),
                        customer.getPassword(),
                        convertAuthorities(customer.getRoles()));
        return userDetails;
    }

    private Set<GrantedAuthority> convertAuthorities(Set<CustomerRole> customerRoles) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (CustomerRole ur:customerRoles){
            authorities.add(new SimpleGrantedAuthority(ur.getRole()));
        }
        return authorities;
    }
}
