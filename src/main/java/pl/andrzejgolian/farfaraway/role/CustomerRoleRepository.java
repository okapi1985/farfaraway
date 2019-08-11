package pl.andrzejgolian.farfaraway.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRoleRepository extends JpaRepository<CustomerRole,Long> {
    CustomerRole findByRole(String role);
}
