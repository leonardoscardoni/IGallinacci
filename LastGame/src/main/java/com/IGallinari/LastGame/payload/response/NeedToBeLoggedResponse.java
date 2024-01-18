package com.IGallinari.LastGame.payload.response;

import lombok.Data;

@Data
public class NeedToBeLoggedResponse {
    private final boolean logged=false;
    private final String message="Need to be logged";
}
