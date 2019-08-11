package pl.andrzejgolian.farfaraway.address;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String createAddress(@ModelAttribute("address") Address address, BindingResult bindingResult, Model model){
        System.out.println(bindingResult);
        if (address.getId() != null) {
            addressService.updateAddress(address);
        } else {
            addressService.createAddress(address);
        }

        return "redirect:/address/addressList";
    }

    @GetMapping("/updateAddressForm/{addressId}")
    public String showAddressFormForUpdate(@PathVariable Long addressId,
                                           Model model) throws RuntimeException {
        Address ad = addressService.findById(addressId);
        model.addAttribute("address", ad);

        return "/address/address-form";
    }

    @GetMapping("/{addressId}/deleteAddress")
    public String deleteAddress(@PathVariable("addressId") Long addressId){
        addressService.delete(addressId);

        return "redirect:/address/addressList";
    }

    @GetMapping("/{id}")
    String displayAddress(@PathVariable Long id, Model model) {
        Address address = addressService.findById(id);
        model.addAttribute("address", address);

        return "/address/address-details";
    }
}
