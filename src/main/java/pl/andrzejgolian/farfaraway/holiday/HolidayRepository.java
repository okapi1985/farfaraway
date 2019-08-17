package pl.andrzejgolian.farfaraway.holiday;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, Long> {

    //    @Query("SELECT a FROM Holiday h, IN(h.address) a WHERE h.id=:id_address")
    @Query("select h from Holiday h where h.address.city like %:phrase%")
    List<Holiday> searchByCity(@Param("phrase") String phrase);

    @Query("select h from Holiday h where h.address.country like %:phrase%")
    List<Holiday> searchByCountry(@Param("phrase") String phrase);
}
