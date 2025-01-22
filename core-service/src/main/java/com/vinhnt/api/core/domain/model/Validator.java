package com.vinhnt.api.core.domain.model;

public abstract class Validator {
    protected ValidationNotificationHandler validationNotificationHandler;

    public Validator(ValidationNotificationHandler validationNotificationHandler) {
        this.validationNotificationHandler = validationNotificationHandler;
    }

    public abstract void validate();

    protected ValidationNotificationHandler validationNotificationHandler() {
        return validationNotificationHandler;
    }
}
