package pl.andrzejgolian.farfaraway.purchase;

import org.springframework.stereotype.Service;
import pl.andrzejgolian.farfaraway.holiday.ItemNotFoundException;

import java.util.List;

@Service
public class HolidayPurchaseService {
    
    private HolidayPurchaseRepository holidayPurchaseRepository;

    public HolidayPurchaseService(HolidayPurchaseRepository holidayPurchaseRepository) {
        this.holidayPurchaseRepository = holidayPurchaseRepository;
    }

    public void createHolidayPurchase(HolidayPurchase holidayPurchase) {

        holidayPurchaseRepository.save(holidayPurchase);
    }

    public List<HolidayPurchase> getHolidayPurchases() {

        return holidayPurchaseRepository.findAll();
    }

    public HolidayPurchase getHolidayPurchase(long holidayPurchaseId) throws ItemNotFoundException {

        return holidayPurchaseRepository.findById(holidayPurchaseId)
                .orElseThrow(() -> new ItemNotFoundException(holidayPurchaseId));
    }

    public void delete(long holidayPurchaseId) {

        holidayPurchaseRepository.deleteById(holidayPurchaseId);
    }
}
