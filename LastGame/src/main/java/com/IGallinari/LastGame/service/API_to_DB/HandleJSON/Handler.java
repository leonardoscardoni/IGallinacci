package com.IGallinari.LastGame.service.API_to_DB.HandleJSON;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

public interface Handler {
    void handle(JsonNode jsonNode);

    default Integer asInteger(JsonNode node) {
        if (node != null && !node.isNull()) {
            return node.asInt();
        } else {
            return null;
        }
    }

    default Float asFloat(JsonNode node) {
        if (node != null && !node.isNull()) {
            return node.floatValue();
        } else {
            return null;
        }
    }

    default LocalDate asLocalDate(JsonNode node) {
        if (node != null && !node.isNull()) {
            return LocalDate.parse(node.asText());
        } else {
            return null;
        }
    }
}
