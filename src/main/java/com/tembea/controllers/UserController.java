package com.tembea.controllers;

import com.tembea.controllers.response.CustomApiResponse;
import com.tembea.dtos.request.UserRequestDto;
import com.tembea.i18n.MessageKey;
import com.tembea.i18n.MessageService;
import com.tembea.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Users", description = "User management endpoints")
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;
  private final MessageService messageService;

  @Operation(summary = "Get all users", description = "Returns a paginated list of users")
  @ApiResponse(responseCode = "200", description = "Users retrieved successfully")
  @GetMapping
  public CustomApiResponse findAll(Pageable pageable) {
    return CustomApiResponse.ok(userService.findAll(null, pageable));
  }

  @Operation(summary = "Get user by UUID")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "User found"),
      @ApiResponse(responseCode = "404", description = "User not found")
  })
  @GetMapping("/{uuid}")
  public CustomApiResponse findByUuid(
      @Parameter(description = "User UUID") @PathVariable String uuid) {
    return CustomApiResponse.ok(userService.findByUuid(uuid));
  }

  @Operation(summary = "Create a new user")
  @ApiResponses({
      @ApiResponse(responseCode = "201", description = "User created successfully"),
      @ApiResponse(responseCode = "400", description = "Invalid request body")
  })
  @PostMapping
  public CustomApiResponse create(@Valid @RequestBody UserRequestDto dto) {
    return CustomApiResponse.created(messageService.get(MessageKey.USER_CREATED), userService.create(dto));
  }

  @Operation(summary = "Update an existing user")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "User updated successfully"),
      @ApiResponse(responseCode = "400", description = "Invalid request body"),
      @ApiResponse(responseCode = "404", description = "User not found")
  })
  @PutMapping("/{uuid}")
  public CustomApiResponse update(
      @Parameter(description = "User UUID") @PathVariable String uuid,
      @Valid @RequestBody UserRequestDto dto) {
    return CustomApiResponse.ok(messageService.get(MessageKey.USER_UPDATED), userService.update(uuid, dto));
  }

  @Operation(summary = "Delete a user")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "User deleted successfully"),
      @ApiResponse(responseCode = "404", description = "User not found")
  })
  @DeleteMapping("/{uuid}")
  public CustomApiResponse delete(
      @Parameter(description = "User UUID") @PathVariable String uuid) {
    userService.delete(uuid);
    return CustomApiResponse.noContent(messageService.get(MessageKey.USER_DELETED));
  }
}
