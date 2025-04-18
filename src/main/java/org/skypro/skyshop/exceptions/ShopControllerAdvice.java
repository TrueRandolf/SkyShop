package org.skypro.skyshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice

public class ShopControllerAdvice {
    @ExceptionHandler

    public ResponseEntity<ShopError> noSuchProductHandler(NoSuchProductException e) {
        return new ResponseEntity<>(new ShopError(HttpStatus.NOT_FOUND.toString(),"Несуществующий id"), HttpStatus.NOT_FOUND);
    }
}