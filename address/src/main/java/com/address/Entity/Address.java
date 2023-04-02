package com.address.Entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class Address {

    private String city;
    private String state;
}
