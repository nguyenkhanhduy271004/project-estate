package com.javaweb.controller.admin;

import com.javaweb.converter.customer.CustomerEntityConverter;
import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.TransactionEntity;
import com.javaweb.enums.TransactionType;
import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.model.request.CustomerRequest;
import com.javaweb.service.ICustomerService;
import com.javaweb.service.ITransactionService;
import com.javaweb.service.IUserService;
import com.javaweb.service.impl.CustomerService;
import com.javaweb.service.impl.UserService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController(value = "customerControllerOfAdmin")
@RequestMapping(value = "/admin")
public class CustomerController {

  @Autowired
  private IUserService userService;

  @Autowired
  private ICustomerService customerService;

  @Autowired
  private ITransactionService transactionService;

  @GetMapping(value = "/customer-list")
  public ModelAndView customerList(@ModelAttribute CustomerRequest customerRequest,
      @RequestParam(value = "page", defaultValue = "1", required = false) int page,
      @RequestParam(value = "size", defaultValue = "10", required = false) int size,
      HttpServletRequest request) {
    ModelAndView mav = new ModelAndView("admin/customer/list");
    List<CustomerDTO> customerEntities = customerService.findAll(customerRequest, page, size);
    Long totalRecords = (long) customerEntities.size();
    int totalPages = (int) Math.ceil((double) totalRecords / size);

    mav.addObject("modalSearch", customerRequest);
    mav.addObject("staffs", userService.getStaffs());
    mav.addObject("customers", customerEntities);
    mav.addObject("currentPage", page);
    mav.addObject("pageSize", size);
    mav.addObject("totalPages", totalPages);
    return mav;
  }

  @GetMapping(value = "/customer-add")
  public ModelAndView addCustomer(@ModelAttribute("customerForm") CustomerRequest customerRequest,
      HttpServletRequest request) {
    ModelAndView mav = new ModelAndView("admin/customer/add");
    return mav;
  }

  @GetMapping(value = "/customer-edit-{id}")
  public ModelAndView customerList(@PathVariable Long id,
      @ModelAttribute CustomerEntity customerEntity) {
    ModelAndView mav = new ModelAndView("admin/customer/edit");
    customerEntity = customerService.findCustomerById(id);
    List<TransactionEntity> transactionEntities = transactionService.findAllByCustomerId(id);
    Map<String, String> transactionTypes = TransactionType.type();
    mav.addObject("transactionTypes", transactionTypes);
    mav.addObject("modalSearch", customerEntity);
    mav.addObject("customerId", id);
    mav.addObject("transactions", transactionEntities);
    return mav;
  }
}
