package com.tembea.controllers.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tembea.controllers.exceptions.ValidationException;
import java.io.Serial;
import java.io.Serializable;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomApiResponse implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  private Object data;
  private Integer status;
  private String message;
  private Integer page;
  private Integer size;
  private Long total;
  private String[] errors;

  public static CustomApiResponse ok(Object data) {
    CustomApiResponse response = new CustomApiResponse();
    response.setStatus(HttpStatus.OK.value());
    response.setData(data);
    return response;
  }

  public static CustomApiResponse ok(String message, Object data) {
    CustomApiResponse response = new CustomApiResponse();
    response.setStatus(HttpStatus.OK.value());
    response.setData(data);
    response.setMessage(message);
    return response;
  }

  public static CustomApiResponse ok(String message, Object data, int page, int size,
      Long totalElements) {
    CustomApiResponse response = new CustomApiResponse();
    response.setStatus(HttpStatus.OK.value());
    response.setData(data);
    response.setMessage(message);
    response.setTotal(totalElements);
    response.setPage(page);
    response.setSize(size);
    return response;
  }

  public static CustomApiResponse ok(Page<?> page) {
    CustomApiResponse response = new CustomApiResponse();
    response.setStatus(HttpStatus.OK.value());
    response.setData(page.getContent());
    response.setPage(page.getNumber());
    response.setTotal(page.getTotalElements());
    response.setSize(page.getSize());
    return response;
  }

  public static CustomApiResponse ok(String message) {
    CustomApiResponse response = new CustomApiResponse();
    response.setStatus(HttpStatus.OK.value());
    response.setMessage(message);
    return response;
  }

  public static CustomApiResponse ok(Optional<?> data) {
    if (data.isPresent()) {
      CustomApiResponse response = new CustomApiResponse();
      response.setStatus(HttpStatus.OK.value());
      response.setData(data.get());
      return response;
    } else {
      throw new ValidationException("Resource not found");
    }
  }

  public static CustomApiResponse created(String message, Object data) {
    CustomApiResponse response = new CustomApiResponse();
    response.setStatus(HttpStatus.CREATED.value());
    response.setData(data);
    response.setMessage(message);
    return response;
  }

  public static CustomApiResponse accepted(String message, Object data) {
    CustomApiResponse response = new CustomApiResponse();
    response.setStatus(HttpStatus.ACCEPTED.value());
    response.setData(data);
    response.setMessage(message);
    return response;
  }

  public static CustomApiResponse badRequest(String message, Object data) {
    CustomApiResponse response = new CustomApiResponse();
    response.setStatus(HttpStatus.BAD_REQUEST.value());
    response.setData(data);
    response.setMessage(message);
    return response;
  }

  public static CustomApiResponse noContent(String message) {
    CustomApiResponse response = new CustomApiResponse();
    response.setStatus(HttpStatus.NO_CONTENT.value());
    response.setMessage(message);
    return response;
  }

  public static CustomApiResponse accessDenied(String message) {
    CustomApiResponse response = new CustomApiResponse();
    response.setStatus(HttpStatus.FORBIDDEN.value());
    response.setMessage(message);
    return response;
  }

  public static CustomApiResponse notFound(String message) {
    CustomApiResponse response = new CustomApiResponse();
    response.setStatus(HttpStatus.NOT_FOUND.value());
    response.setMessage(message);
    return response;
  }

  public static CustomApiResponse error(String message, String[] errors) {
    CustomApiResponse response = new CustomApiResponse();
    response.setStatus(HttpStatus.BAD_REQUEST.value());
    response.setMessage(message);
    response.setErrors(errors);
    return response;
  }

  public CustomApiResponse errors(String message) {
    this.message = message;
    return this;
  }
}
