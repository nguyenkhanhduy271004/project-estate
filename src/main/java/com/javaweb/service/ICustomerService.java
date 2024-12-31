package com.javaweb.service;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.CustomerRequest;
import com.javaweb.model.response.ResponseDTO;
import java.util.List;


public interface ICustomerService {

  void save(CustomerRequest customerRequest);

  void save(CustomerEntity customerEntity);

  List<CustomerDTO> findAll(CustomerRequest customerRequest, int page, int size);

  CustomerEntity findCustomerById(Long id);

  ResponseDTO listStaffs(Long customerId);

  void deleteCustomerById(Long id);

  void delete(List<Long> ids);

  public Long countCustomers(CustomerRequest customerRequest);


}
