package com.IGallinari.LastGame.service.API_to_DB;

import com.IGallinari.LastGame.service.API_to_DB.HandleJSON.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Service class for redirecting JSON data to the appropriate handler based on the endpoint.
 * It parses the JSON string, extracts the endpoint information, and delegates the handling
 * to the relevant handler through the HandlerManager.
 */
@Service
@Slf4j
public class RedirectJSON {

    @Autowired
    HandlerManager handlerManager;

    private final ObjectMapper objectMapper = new ObjectMapper();
    /**
     * Manages the JSON response by parsing it and redirecting to the appropriate handler.
     * If errors are present in the JSON node, it logs them instead of processing further.
     *
     * @param jsonString The JSON string to be managed.
     * @throws JsonProcessingException if there is an error in processing the JSON string.
     */
    public void manageJSON(String jsonString) throws JsonProcessingException {
        JsonNode jsonNode = objectMapper.readTree(jsonString);
        String endpoint = jsonNode.get("get").asText();
        if(jsonNode.get("errors").isEmpty()) {
            Handler handler=handlerManager.getHandler(endpoint);
            handler.handle(jsonNode);
        }else{
            System.out.println(jsonNode.get("errors"));
        }

    }
}
