package com.javaweb.exception;

import com.javaweb.model.response.ErrorResponse;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Object> handleValidException(MethodArgumentNotValidException exception) {
    Map<String, String> errors = new HashMap<>();
    ErrorResponse errorResponse = new ErrorResponse();
    errors.put("message", "Có vấn đề khi validate dữ liệu");
    exception.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    errorResponse.setMessage("Có vấn đề khi validate dữ liệu");
    errorResponse.setErrors(errors);
    return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
  }
}
