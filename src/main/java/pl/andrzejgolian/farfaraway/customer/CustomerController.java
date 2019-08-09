package pl.andrzejgolian.farfaraway.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.andrzejgolian.farfaraway.holiday.ItemNotFoundException;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customerList")
    public String listCustomer(Model model){
        List<Customer> customerList = customerService.getCustomers();
        model.addAttribute("customers",customerList);

        return "/customer/customer-list";
    }

    @GetMapping("/showCustomerForm")
    public String showCustomerForm(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer",customer);

        return "/customer/customer-form";
    }

    @PostMapping("/createCustomer")
    public String createCustomer(@ModelAttribute Customer customer, BindingResult bindingResult){

        customerService.createCustomer(customer);

        return "redirect:/customer/customerList";
    }

    @GetMapping("/updateCustomerForm")
    public String showCustomerFormForUpdate(@RequestParam("customerId") long customerId,
                                         Model model) throws ItemNotFoundException {
        Customer customer = customerService.getCustomer(customerId);
        model.addAttribute("customer", customer);

        return "/customer/customer-form";
    }

    @GetMapping("/customerDelete")
    public String deleteCustomer(@RequestParam("customerId") long customerId){
        customerService.delete(customerId);

        return "redirect:/customer/customerList";
    }
}
