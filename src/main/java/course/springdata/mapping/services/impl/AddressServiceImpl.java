package course.springdata.mapping.services.impl;

import course.springdata.mapping.entity.Address;
import course.springdata.mapping.services.AddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AddressServiceImpl implements AddressService {
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
        return null;
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
