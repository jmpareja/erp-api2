package com.jmpsolutions.erpapi2.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Error handler for FieldNotFoundException.
 * 
 * @author jmpareja
 * @since 2021/02/28
 */
@ControllerAdvice
public class FieldNotFoundAdvice {
  @ResponseBody
  @ExceptionHandler(FieldNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String fieldNotFoundHandler(FieldNotFoundException ex) {
    return ex.getMessage();
  }
}