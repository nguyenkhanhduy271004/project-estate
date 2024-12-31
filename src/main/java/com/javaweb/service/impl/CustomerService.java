package com.javaweb.service.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.customer.CustomerDTOConverter;
import com.javaweb.converter.customer.CustomerEntityConverter;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.CustomerRequest;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.ICustomerService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private CustomerEntityConverter customerEntityConverter;
  @Autowired
  private CustomerDTOConverter customerDTOConverter;

  @Override
  public void save(CustomerRequest customerRequest) {
    CustomerEntity customerEntity = customerEntityConverter.customerEntityConverter(
        customerRequest);
    customerEntity.setIsActive(1L);
    customerRepository.save(customerEntity);
  }

  @Override
  public void save(CustomerEntity customerEntity) {
    customerEntity.setIsActive(1L);
    customerRepository.save(customerEntity);
  }

  @Override
  public List<CustomerDTO> findAll(CustomerRequest customerRequest, int page,
      int size) {
    List<CustomerEntity> customerEntities = customerRepository.findAll(customerRequest, page, size);
    List<CustomerDTO> customerDTOS = new ArrayList<>();
    for (CustomerEntity customerEntity : customerEntities) {
      CustomerDTO customerDTO = customerDTOConverter.toCustomerDTO(customerEntity);
      customerDTOS.add(customerDTO);
    }
    return customerDTOS;
  }

  @Override
  public CustomerEntity findCustomerById(Long id) {
    return customerRepository.findById(id).get();
  }

  @Override
  public ResponseDTO listStaffs(Long customerId) {
    CustomerEntity customer = customerRepository.findById(customerId).get();
    List<UserEntity> staffs = userRepository.findByStatusAndRoles_Code(1, "STAFF");
    List<UserEntity> staffAsignment = customer.getUserEntityList();
    List<StaffResponseDTO> staffResponseDTOS = new ArrayList<>();
    for (UserEntity staff : staffs) {
      StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
      staffResponseDTO.setStaffId(staff.getId());
      staffResponseDTO.setFullName(staff.getFullName());
      if (staffAsignment.contains(staff)) {
        staffResponseDTO.setChecked("checked");
      } else {
        staffResponseDTO.setChecked("");
      }
      staffResponseDTOS.add(staffResponseDTO);
    }
    ResponseDTO responseDTO = new ResponseDTO();
    responseDTO.setData(staffResponseDTOS);
    responseDTO.setMessage("Success");
    return responseDTO;
  }

  @Override
  public void deleteCustomerById(Long id) {
    CustomerEntity customer = customerRepository.findById(id).get();
    customer.setIsActive(0L);
    customerRepository.save(customer);
  }

  @Override
  public void delete(List<Long> ids) {
    try {
      for (Long id : ids) {
        CustomerEntity customer = customerRepository.findById(id).get();
        customer.setIsActive(0L);
        customerRepository.save(customer);
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(e.getMessage());
    }
  }

  @Override
  public Long countCustomers(CustomerRequest customerRequest) {
    return customerRepository.count(customerRequest);
  }
}
