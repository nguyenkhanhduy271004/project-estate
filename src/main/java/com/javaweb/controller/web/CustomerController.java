package com.javaweb.controller.web;

import com.javaweb.model.request.CustomerRequest;
import com.javaweb.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController(value = "customerController")
@RequestMapping(value = "/customer")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @PostMapping
  public void addCustomer(@RequestBody CustomerRequest customerRequest) {
    customerService.save(customerRequest);
  }
}
