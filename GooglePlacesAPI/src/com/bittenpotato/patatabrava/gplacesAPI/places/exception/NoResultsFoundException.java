package com.bittenpotato.patatabrava.gplacesAPI.places.exception;

import com.bittenpotato.patatabrava.gplacesAPI.places.Statuses;


public class NoResultsFoundException extends GooglePlacesException {
    public NoResultsFoundException(String errorMessage) {
        super(Statuses.STATUS_ZERO_RESULTS, errorMessage);
    }

    public NoResultsFoundException() {
        this(null);
    }
}
