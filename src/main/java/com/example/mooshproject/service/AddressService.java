package com.example.mooshproject.service;

import com.example.mooshproject.entity.Address;
import com.example.mooshproject.repository.AddressRepository;
import com.example.mooshproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {
    private AddressRepository addressRepository;
    private UserRepository userRepository;

    public void showAddress(){
        var address = addressRepository.findById(1L);
        System.out.println(address.get().getStreet());
    }
}
