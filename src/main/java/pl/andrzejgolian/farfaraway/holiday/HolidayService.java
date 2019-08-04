package pl.andrzejgolian.farfaraway.holiday;

import org.springframework.stereotype.Service;

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

    public Holiday getHoliday(long holidayId) throws ItemNotFoundException{
        return holidayRepository.findById(holidayId)
                .orElseThrow(() -> new ItemNotFoundException(holidayId));
    }

    public void delete(long holidayId){
        holidayRepository.deleteById(holidayId);
    }
}
