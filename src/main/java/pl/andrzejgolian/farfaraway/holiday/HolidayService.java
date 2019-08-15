package pl.andrzejgolian.farfaraway.holiday;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HolidayService {

    private HolidayRepository holidayRepository;

    public HolidayService(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    public List<Holiday> getHolidays() {
        return holidayRepository.findAll();
    }

    public void create(Holiday holiday){
        holidayRepository.save(holiday);
    }

    @Transactional
    public void delete(long holidayId){
        holidayRepository.deleteById(holidayId);
    }

    public Holiday findById(Long id) {

        return holidayRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie znaleziono wycieczki"));
    }

    public Holiday updateHoliday(Holiday holiday){
        Holiday holidayToUpdate = findById(holiday.getId());

        holidayToUpdate.setAdultPrice(holiday.getAdultPrice());
        holidayToUpdate.setChildPrice(holiday.getChildPrice());
        holidayToUpdate.setPromoted(holiday.getPromoted());
        holidayToUpdate.setFlightDate(holiday.getFlightDate());
        holidayToUpdate.setReturnDate(holiday.getReturnDate());
        holidayToUpdate.setDaysAmount(holiday.getDaysAmount());
        holidayToUpdate.setBoard(holiday.getBoard());
        holidayToUpdate.setAdultAmount(holiday.getAdultAmount());
        holidayToUpdate.setChildAmount(holiday.getChildAmount());
        holidayToUpdate.setAddress(holiday.getAddress());
        holidayToUpdate.setPlace(holiday.getPlace());

        return holidayRepository.save(holidayToUpdate);
    }

    public List<Holiday> search(String phrase) {

        return holidayRepository.search(phrase);
    }
}
