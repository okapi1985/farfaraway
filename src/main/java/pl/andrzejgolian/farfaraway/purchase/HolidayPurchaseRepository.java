package pl.andrzejgolian.farfaraway.purchase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayPurchaseRepository extends JpaRepository<HolidayPurchase,Long> {
}
