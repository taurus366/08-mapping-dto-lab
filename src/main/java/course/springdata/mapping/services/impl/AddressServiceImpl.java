package course.springdata.mapping.services.impl;

import course.springdata.mapping.dao.AdressRepository;
import course.springdata.mapping.entity.Address;
import course.springdata.mapping.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AdressRepository adressRepository;


    @Override
    public List<Address> getAllAdresses() {
        return null;
    }

    @Override
    public Address getAddressById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public Address addAddress(Address address) {
        return adressRepository.save(address);
    }

    @Override
    @Transactional
    public Address updateAddress(Address address) {
        return null;
    }

    @Override
    @Transactional
    public Address deleteAddress(Long id) {
        return null;
    }

    @Override
    public long getAddressCount() {
        return 0;
    }


}
