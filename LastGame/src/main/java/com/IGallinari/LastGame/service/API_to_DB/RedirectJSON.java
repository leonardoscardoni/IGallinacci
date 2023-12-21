package com.IGallinari.LastGame.service.API_to_DB;

import com.IGallinari.LastGame.service.API_to_DB.HandleJSON.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RedirectJSON {

    @Autowired
    HandlerManager handlerManager;

    private final ObjectMapper objectMapper = new ObjectMapper();

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
