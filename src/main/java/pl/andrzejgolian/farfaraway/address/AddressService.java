package pl.andrzejgolian.farfaraway.address;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public void delete(Long addressId) {
        addressRepository.deleteById(addressId);
    }

    public Address findById(Long id) {

        return addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie znaleziono adresu"));
    }

    public Address updateAddress(Address address) {
        Address addressToUpdate = findById(address.getId());

        addressToUpdate.setContinent(address.getContinent());
        addressToUpdate.setCountry(address.getCountry());
        addressToUpdate.setCity(address.getCity());
        addressToUpdate.setAirport(address.getAirport());

        return addressRepository.save(addressToUpdate);
    }
}
