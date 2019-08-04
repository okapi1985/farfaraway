package pl.andrzejgolian.farfaraway.address;

import org.springframework.stereotype.Service;
import pl.andrzejgolian.farfaraway.holiday.ItemNotFoundException;

import java.util.List;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    public void createAddress(Address address) {
        addressRepository.save(address);
    }

    public Address getAddress(long addressId) throws ItemNotFoundException {
        return addressRepository.findById(addressId)
                .orElseThrow(() -> new ItemNotFoundException(addressId));
    }

    public void delete(long addressId) {
        addressRepository.deleteById(addressId);
    }
}
