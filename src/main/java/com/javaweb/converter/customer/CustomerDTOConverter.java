package com.javaweb.converter.customer;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.dto.CustomerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerDTOConverter {

  @Autowired
  private ModelMapper modelMapper;

  public CustomerDTO toCustomerDTO(CustomerEntity customer) {
    CustomerDTO customerDTO = new CustomerDTO();
    customerDTO.setId(customer.getId());
    customerDTO.setName(customer.getFullName());
    customerDTO.setCustomerPhone(customer.getPhone());
    customerDTO.setEmail(customer.getEmail());
    customerDTO.setDemand(customer.getDemand());
    customerDTO.setCreatedBy(customer.getCreatedBy());
    customerDTO.setCreatedDate(customer.getCreatedDate());
    customerDTO.setStatus(customer.getStatus());
    return customerDTO;
  }
}
