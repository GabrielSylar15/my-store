package com.vinhnt.api.core.domain.model.inventory;

import com.vinhnt.api.core.domain.model.ValidationNotificationHandler;

import java.util.ArrayList;
import java.util.List;

public class ValidationNotificationHandlerImpl implements ValidationNotificationHandler {
    List<String> messages = new ArrayList<>();

    @Override
    public void handleError(String message) {
        this.messages.add(message);
    }

    public List<String> messages() {
        return messages;
    }

    public String concatenatedMessage() {
        return String.join("\n", messages);
    }
}
