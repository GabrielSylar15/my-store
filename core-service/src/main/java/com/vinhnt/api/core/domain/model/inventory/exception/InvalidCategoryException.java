package com.vinhnt.api.core.domain.model.inventory.exception;

import com.vinhnt.common.exception.BadRequestException;

public class InvalidCategoryException extends BadRequestException {
    public InvalidCategoryException(String message) {
        super(message);
    }
}
