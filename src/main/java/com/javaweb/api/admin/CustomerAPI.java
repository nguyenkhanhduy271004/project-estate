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
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController(value = "customerAPIOfAdmin")
@RequestMapping("/api/customer")
@Validated
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
  public ResponseEntity<String> addOrUpdateCustomer(
      @Valid @RequestBody CustomerRequest customerRequest) {
    customerService.save(customerRequest);
    return ResponseEntity.status(HttpStatus.CREATED).body("Customer saved successfully.");
  }

  @GetMapping("/{id}/staffs")
  public ResponseEntity<ResponseDTO> loadStaffs(@PathVariable Long id) {
    ResponseDTO result = customerService.listStaffs(id);
    return ResponseEntity.ok(result);
  }

  @PostMapping(value = "/assignment")
  public ResponseEntity<String> assignmentCustomerForStaffs(
      @RequestBody AssignmentCustomerRequest assignmentCustomerRequest) {
    CustomerEntity customer = customerService.findCustomerById(
        assignmentCustomerRequest.getCustomerId());
    List<UserEntity> staffs = assignmentCustomerRequest.getStaffs().stream()
        .map(userService::findById)
        .collect(Collectors.toList());
    customer.setUserEntityList(staffs);
    customerService.save(customer);
    return ResponseEntity.ok("Customer assigned to staffs successfully.");
  }

  @PostMapping(value = "/transaction")
  public ResponseEntity<String> createTransaction(
      @RequestBody TransactionRequest transactionRequest) {
    if (transactionRequest.getId() != null) {
      TransactionEntity transaction = transactionService.findById(transactionRequest.getId());
      transaction.setNote(transactionRequest.getNote());
      transactionService.save(transaction);
      return ResponseEntity.ok("Transaction updated successfully.");
    } else {
      TransactionEntity transactionEntity = transactionEntityConverter.toTransactionEntity(
          transactionRequest);
      transactionService.save(transactionEntity);
      return ResponseEntity.status(HttpStatus.CREATED).body("Transaction created successfully.");
    }
  }

  @PutMapping()
  public ResponseEntity<String> updateCustomer(@RequestBody CustomerRequest customerRequest) {
    CustomerEntity customer = customerService.findCustomerById(customerRequest.getId());
    customer.setStatus(customerRequest.getStatus());
    customerService.save(customer);
    return ResponseEntity.ok("Customer updated successfully.");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
    customerService.deleteCustomerById(id);
    return ResponseEntity.ok("Customer deleted successfully.");
  }

  @DeleteMapping("/delete-{ids}")
  public ResponseEntity<String> deleteCustomers(@PathVariable List<Long> ids) {
    customerService.delete(ids);
    return ResponseEntity.ok("Customers deleted successfully.");
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException(Exception ex) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Error: " + ex.getMessage());
  }
}
