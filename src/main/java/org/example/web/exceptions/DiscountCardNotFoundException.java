package org.example.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DiscountCardNotFoundException extends RuntimeException {
    public DiscountCardNotFoundException(String message) {
        super(message);
    }
}
