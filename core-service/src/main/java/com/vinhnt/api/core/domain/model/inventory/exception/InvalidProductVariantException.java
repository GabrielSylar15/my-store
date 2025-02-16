package com.vinhnt.api.core.domain.model.inventory.exception;

import com.vinhnt.common.exception.BadRequestException;

public class InvalidProductVariantException extends BadRequestException {
    public InvalidProductVariantException(String message) {
        super(message);
    }
}