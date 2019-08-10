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

    @Transactional
    public Holiday updateHoliday(Holiday holiday){
        return holidayRepository.save(holiday);
    }
}
