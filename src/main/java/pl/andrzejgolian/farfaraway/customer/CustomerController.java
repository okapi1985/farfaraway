package pl.andrzejgolian.farfaraway.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/customerList")
    public String listCustomer(Model model){
        List<Customer> customerList = customerService.getCustomers();
        model.addAttribute("customers",customerList);

        return "/customer/customer-list";
    }

    //robi to samo co metoda register
    @GetMapping("/showCustomerForm")
    public String showCustomerForm(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer",customer);

        return "/customer/customer-form";
    }

    //robi to samo co metoda addUser
    @PostMapping("/createCustomer")
    public String createCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult bindingResult){
        System.out.println(bindingResult);
        if(customer.getId() != null) {
            customerService.updateCustomer(customer);
        } else {
            customerService.create(customer);
//            if (bindingResult.hasErrors())
//                return "/customer/customer-form";
//            else {
//                customerService.addWithDefaultRole(customer);
//                return "redirect:/main/registration";
//            }
        }

        return "redirect:/main/registration";
    }

    @GetMapping("/updateCustomerForm/{customerId}")
    public String showCustomerFormForUpdate(@PathVariable Long customerId,
                                         Model model) throws RuntimeException {
        Customer cus = customerService.findById(customerId);
        model.addAttribute("customer", cus);

        return "/customer/customer-form";
    }

    @GetMapping("/{customerId}/customerDelete")
    public String deleteCustomer(@PathVariable("customerId") Long customerId){
        customerService.delete(customerId);

        return "redirect:/customer/customerList";
    }

    @GetMapping("/{id}")
    String displayAddress(@PathVariable Long id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);

        return "/customer/customer-details";
    }
}
