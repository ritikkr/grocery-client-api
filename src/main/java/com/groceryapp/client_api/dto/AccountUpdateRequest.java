package com.groceryapp.client_api.dto;

import com.groceryapp.client_api.model.Address;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountUpdateRequest {
    Long userId;
    String firstName;
    String lastName;
    String phoneNumber;
    Address address;
    String password;

}
