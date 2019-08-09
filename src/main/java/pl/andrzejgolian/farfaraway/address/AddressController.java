package pl.andrzejgolian.farfaraway.address;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.andrzejgolian.farfaraway.holiday.ItemNotFoundException;

import java.util.List;

@Controller
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/addressList")
    public String listAddresses(Model model){
        List<Address> addressList = addressService.getAddresses();
        model.addAttribute("addresses",addressList);

        return "/address/address-list";
    }

    @GetMapping("/showAddressForm")
    public String showAddressesForm(Model model){
        Address address = new Address();
        model.addAttribute("address",address);

        return "/address/address-form";
    }

    @PostMapping("/createAddress")
    public String createAddress(@ModelAttribute Address address, BindingResult bindingResult){

        addressService.createAddress(address);

        return "redirect:/address/addressList";
    }

    @GetMapping("/updateAddressForm")
    public String showAddressFormForUpdate(@RequestParam("addressId") long addressId,
                                           Model model) throws ItemNotFoundException {
        Address address = addressService.getAddress(addressId);
        model.addAttribute("address", address);

        return "/address/address-form";
    }

    @GetMapping("/{addressId}/deleteAddress")
    public String deleteAddress(@RequestParam("addressId") long addressId){
        addressService.delete(addressId);

        return "redirect:/address/addressList";
    }
}
