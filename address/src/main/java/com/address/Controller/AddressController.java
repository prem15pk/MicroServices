package com.address.Controller;

import com.address.Entity.Address;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @GetMapping("/getAddress")
    public Address getController(){
        Address address = Address.builder()
                .city("Dindigul").state("TamilNadu").build();

        return address;

    }
}
