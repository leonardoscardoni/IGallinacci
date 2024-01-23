package com.IGallinari.LastGame.service.API_to_DB.HandleJSON;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Interface for handling JSON nodes.
 * Provides the functionality to process JSON data and convert it into various data types.
 */

public interface Handler {

    /**
     * Handles a given JsonNode.
     *
     * @param jsonNode The JSON node to be handled.
     */
    void handle(JsonNode jsonNode);

    /**
     * Converts a JsonNode to an Integer.
     *
     * @param node The JsonNode to convert.
     * @return The converted Integer value or null if conversion is not possible.
     */

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
    /**
     * Converts a JsonNode to a Float.
     *
     * @param node The JsonNode to convert.
     * @return The converted Float value or null if conversion is not possible.
     */
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
    /**
     * Converts a JsonNode to a LocalDate.
     *
     * @param node The JsonNode to convert.
     * @return The converted LocalDate value or null if conversion is not possible.
     */
    default LocalDate asLocalDate(JsonNode node) {
        if (node != null && !node.isNull()) {
            return LocalDate.parse(node.asText());
        } else {
            return null;
        }
    }
    /**
     * Converts a JsonNode to a String.
     *
     * @param node The JsonNode to convert.
     * @return The converted String value or null if conversion is not possible.
     */
    default String asString(JsonNode node) {
        if (node != null && !node.isNull()) {
                return node.textValue();
        } else {
            return null;
        }
    }
    /**
     * Converts a JsonNode array to a comma-separated String.
     *
     * @param node The JsonNode array to convert.
     * @return A comma-separated String representation of the array or null if conversion is not possible.
     */
    default String asArray(JsonNode node) {
        if (node != null && node.isArray()) {
            StringBuilder result = new StringBuilder();
            for (JsonNode element : node) {
                String value = asString(element);
                if (value != null) {
                    if (result.length() > 0) {
                        result.append(", ");
                    }
                    result.append(value);
                }
            }
            return result.toString();
        } else {
            return null;
        }
    }
}
