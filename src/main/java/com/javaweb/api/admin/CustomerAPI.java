package com.javaweb.api.admin;

import com.javaweb.converter.transaction.TransactionEntityConverter;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.TransactionEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.request.AssignmentCustomerRequest;
import com.javaweb.model.request.CustomerRequest;
import com.javaweb.model.request.TransactionRequest;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.service.ICustomerService;
import com.javaweb.service.ITransactionService;
import com.javaweb.service.IUserService;
import com.javaweb.service.impl.CustomerService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "customerAPIOfAdmin")
@RequestMapping("/api/customer")
public class CustomerAPI {

  @Autowired
  private ICustomerService customerService;
  @Autowired
  private ITransactionService transactionService;
  @Autowired
  private TransactionEntityConverter transactionEntityConverter;
  @Autowired
  private IUserService userService;

  @PostMapping
  public void addOrUpdateCustomer(@RequestBody CustomerRequest customerRequest) {
    customerService.save(customerRequest);
  }

  @GetMapping("/{id}/staffs")
  public ResponseDTO loadStaffs(@PathVariable Long id) {
    ResponseDTO result = customerService.listStaffs(id);
    return result;
  }

  @PostMapping(value = "/assignment")
  public void assignmentCustomerForStaffs(
      @RequestBody AssignmentCustomerRequest assignmentCustomerRequest) {
    CustomerEntity customer = customerService.findCustomerById(
        assignmentCustomerRequest.getCustomerId());
    List<UserEntity> staffs = new ArrayList<>();
    for (Long staffId : assignmentCustomerRequest.getStaffs()) {
      UserEntity userEntity = userService.findById(staffId);
      staffs.add(userEntity);
    }
    customer.setUserEntityList(staffs);
    customerService.save(customer);
  }


  @PostMapping(value = "/transaction")
  public void createTransaction(@RequestBody TransactionRequest transactionRequest) {
    if (transactionRequest.getId() != null) {
      TransactionEntity transaction = transactionService.findById(transactionRequest.getId());
      transaction.setNote(transactionRequest.getNote());
      transactionService.save(transaction);
    } else {
      TransactionEntity transactionEntity = transactionEntityConverter.toTransactionEntity(
          transactionRequest);
      transactionService.save(transactionEntity);
    }
  }

  @PutMapping()
  public void updateCustomer(@RequestBody CustomerRequest customerRequest) {
    CustomerEntity customer = customerService.findCustomerById(customerRequest.getId());
    customer.setStatus(customerRequest.getStatus());
    customerService.save(customer);
  }


  @DeleteMapping("/{id}")
  public void deleteCustomer(@PathVariable Long id) {
    customerService.deleteCustomerById(id);
  }

  @DeleteMapping("/delete-{ids}")
  public void deleteCustomers(@PathVariable List<Long> ids) {
    customerService.delete(ids);
  }
}
