package pl.andrzejgolian.farfaraway.holidayCart;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import pl.andrzejgolian.farfaraway.holiday.Holiday;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.LinkedList;
import java.util.List;

@Component
@Scope(scopeName= WebApplicationContext.SCOPE_SESSION, proxyMode= ScopedProxyMode.TARGET_CLASS)
public class HolidayCart {

    private List<Holiday> holidays;

    public HolidayCart() {
        holidays = new LinkedList<>();
    }

    public List<Holiday> getPurchasedHoliday() {
        return holidays;
    }

    public void addHoliday(Holiday holiday) {
        this.holidays.add(holiday);
    }

    @PostConstruct
    public void create() {
        System.out.println(this + " created");
    }

    @PreDestroy
    public void destroy() {
        System.out.println(this + " destroyed");
    }
}
