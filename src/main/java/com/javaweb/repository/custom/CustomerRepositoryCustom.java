package com.javaweb.repository.custom;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.request.CustomerRequest;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestParam;

public interface CustomerRepositoryCustom {

  List<CustomerEntity> findAll(CustomerRequest customerRequest, int page, int size);

  public Long count(CustomerRequest customerRequest);
}
