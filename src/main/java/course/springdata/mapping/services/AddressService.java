package course.springdata.mapping.services;

import course.springdata.mapping.entity.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAllAdresses();

    Address getAddressById(Long id);

    Address addAddress(Address address);
    Address updateAddress(Address address);
    Address deleteAddress(Long id);

    long getAddressCount();

}
