package com.javaweb.converter.customer;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.request.CustomerRequest;
import org.springframework.stereotype.Component;

@Component
public class CustomerEntityConverter {

  public CustomerEntity customerEntityConverter(CustomerRequest customerRequest) {
    CustomerEntity customerEntity = new CustomerEntity();
    if (customerRequest.getId() != null) {
      customerEntity.setId(customerRequest.getId());
    }
    customerEntity.setFullName(customerRequest.getFullName());
    customerEntity.setEmail(customerRequest.getEmail());
    customerEntity.setPhone(customerRequest.getPhone());
    customerEntity.setNote(customerRequest.getNote());
    customerEntity.setCompanyName(customerRequest.getCompanyName());
    customerEntity.setStatus(customerRequest.getStatus());
    customerEntity.setIsActive(1L);
    return customerEntity;
  }

}
