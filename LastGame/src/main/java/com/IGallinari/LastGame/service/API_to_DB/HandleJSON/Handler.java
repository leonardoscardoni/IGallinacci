package com.IGallinari.LastGame.service.API_to_DB.HandleJSON;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface Handler {
    void handle(JsonNode jsonNode);

    default Integer asInteger(JsonNode node) {
        if (node != null && !node.isNull()) {
            if (node.isNumber()) {
                return node.asInt();
            } else if (node.isTextual()) {
                try {
                    return Integer.parseInt(node.textValue());
                } catch (NumberFormatException e) {
                    return null;
                }
            }
        }
        return null;
    }


    default Float asFloat(JsonNode node) {
        if (node != null && !node.isNull()) {
            if (node.isNumber()) {
                return node.floatValue();
            } else if (node.isTextual()) {
                try {
                    return Float.parseFloat(node.textValue());
                } catch (NumberFormatException e) {
                    return null;
                }
            }
        }
        return null;
    }

    default LocalDate asLocalDate(JsonNode node) {
        if (node != null && !node.isNull()) {
            return LocalDate.parse(node.asText());
        } else {
            return null;
        }
    }

    default String asString(JsonNode node) {
        if (node != null && !node.isNull()) {
            if (node.isObject()) {
                List<String> values = new ArrayList<>();
                node.fields().forEachRemaining(entry -> values.add(entry.getValue().asText()));
                return String.join(", ", values);
            } else {
                return node.textValue();
            }
        } else {
            return null;
        }
    }
}
