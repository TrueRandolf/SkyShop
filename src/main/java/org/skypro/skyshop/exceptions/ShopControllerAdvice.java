package org.skypro.skyshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice

public class ShopControllerAdvice {
    @ExceptionHandler

    public ResponseEntity<ShopError> noSuchProductHandler(NoSuchProductException e) {
        return new ResponseEntity<>(new ShopError(HttpStatus.NOT_FOUND.toString(),"Продукт с Id={"+e.getMessage()+"} не найден"), HttpStatus.NOT_FOUND);
    }
}