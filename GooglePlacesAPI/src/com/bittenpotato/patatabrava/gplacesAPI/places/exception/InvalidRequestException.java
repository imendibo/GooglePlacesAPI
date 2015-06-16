package com.bittenpotato.patatabrava.gplacesAPI.places.exception;

import com.bittenpotato.patatabrava.gplacesAPI.places.Statuses;

public class InvalidRequestException extends GooglePlacesException {
    public InvalidRequestException(String errorMessage) {
        super(Statuses.STATUS_INVALID_REQUEST, errorMessage);
    }

    public InvalidRequestException() {
        this(null);
    }
}
