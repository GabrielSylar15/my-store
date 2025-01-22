package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.ValidationNotificationHandler;
import com.vinhnt.api.core.domain.model.Validator;

public class ProductValidator extends Validator {
    public ProductValidator(ValidationNotificationHandler validationNotificationHandler) {
        super(validationNotificationHandler);
    }

    @Override
    public void validate() {

    }
}
