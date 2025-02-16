package com.vinhnt.api.core.domain.model.inventory.exception;

import com.vinhnt.common.exception.BadRequestException;

public class InvalidProductException extends BadRequestException {
    public InvalidProductException(String message) {
        super(message);
    }
}
