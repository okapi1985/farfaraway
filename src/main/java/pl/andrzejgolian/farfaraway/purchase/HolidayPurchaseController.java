package pl.andrzejgolian.farfaraway.purchase;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/purchase")
public class HolidayPurchaseController {

    private final HolidayPurchaseService holidayPurchaseService;

    public HolidayPurchaseController(HolidayPurchaseService holidayPurchaseService) {
        this.holidayPurchaseService = holidayPurchaseService;
    }

    @GetMapping("/purchaseList")
    public String listHolidayPurchases(Model model){
        List<HolidayPurchase> holidayPurchaseList = holidayPurchaseService.getHolidayPurchases();
        model.addAttribute("purchases",holidayPurchaseList);

        return "/purchase/purchase-list";
    }

    @GetMapping("/showPurchaseForm")
    public String showHolidayPurchaseForm(Model model){
        HolidayPurchase holidayPurchase = new HolidayPurchase();
        model.addAttribute("purchase",holidayPurchase);

        return "/purchase/purchase-form";
    }

    @PostMapping("/createPurchase")
    public String createHolidayPurchase(@ModelAttribute HolidayPurchase holidayPurchase, BindingResult bindingResult){

        holidayPurchaseService.createHolidayPurchase(holidayPurchase);

        return "redirect:/purchase/purchaseList";
    }

    @GetMapping("/updatePurchaseForm")
    public String showHolidayPurchaseFormForUpdate(@RequestParam("purchaseId") long holidayPurchaseId,
                                         Model model) throws RuntimeException {
        HolidayPurchase holidayPurchase = holidayPurchaseService.getHolidayPurchase(holidayPurchaseId);
        model.addAttribute("purchase", holidayPurchase);

        return "/purchase/purchase-form";
    }

    @GetMapping("/purchaseDelete")
    public String deleteHolidayPurchase(@RequestParam("purchaseId") long holidayPurchaseId){
        holidayPurchaseService.delete(holidayPurchaseId);

        return "redirect:/purchase/purchaseList";
    }
}
