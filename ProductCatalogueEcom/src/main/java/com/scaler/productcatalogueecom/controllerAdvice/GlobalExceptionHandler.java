package com.scaler.productcatalogueecom.controllerAdvice;

import com.scaler.productcatalogueecom.dto.ErrorResponses;
import com.scaler.productcatalogueecom.exceptions.CategoryNotFoundException;
import com.scaler.productcatalogueecom.exceptions.DuplicateProductException;
import com.scaler.productcatalogueecom.exceptions.InvalidProductDataException;
import com.scaler.productcatalogueecom.exceptions.ProductNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.View;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final View error;

    public GlobalExceptionHandler(View error) {
        this.error = error;
    }

    //Handle Validation Errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> handleValidationException(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();

        });
        return ResponseEntity.badRequest().body(errors);
    }

    // Handle product not found
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponses> HandleProductNotFoundException(
            ProductNotFoundException ex, WebRequest request) {
        ErrorResponses errorResponses = new ErrorResponses();
        errorResponses.setTimestamp(LocalDateTime.now());
        errorResponses.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponses.setMessage(ex.getMessage());
        errorResponses.setError("Product Not Found");
        errorResponses.setPath(((ServletWebRequest) request).getRequest().getRequestURI());

//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        return new ResponseEntity<>(errorResponses, HttpStatus.NOT_FOUND);
    }

    //Handle CategoryNotFound Exception
    @ExceptionHandler(CategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponses> HandleCategoryNotFoundException(
            CategoryNotFoundException ex, WebRequest request) {
        ErrorResponses errorResponses = new ErrorResponses();
        errorResponses.setTimestamp(LocalDateTime.now());
        errorResponses.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponses.setMessage(ex.getMessage());
        errorResponses.setError("Category Not Found");
        errorResponses.setPath(((ServletWebRequest) request).getRequest().getRequestURI());
        return new ResponseEntity<>(errorResponses, HttpStatus.NOT_FOUND);
    }

    //handle Duplicate Products
    @ExceptionHandler(DuplicateProductException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<String> handleDuplicateProduct(DuplicateProductException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    //Handle invalid product data
    @ExceptionHandler(InvalidProductDataException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<String> invalidProduct(InvalidProductDataException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }


    //handle Mongodb Duplicate Key errors




    //handle all other exception
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> HandleException(Exception ex) {
//        ErrorResponses errorResponses = new ErrorResponses();
        return  ResponseEntity.internalServerError().body("An Unexpected error Occured "
                +ex.getMessage());
    }

}
