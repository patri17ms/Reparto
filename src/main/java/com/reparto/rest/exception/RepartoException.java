package com.reparto.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RepartoException extends ResponseStatusException {

	/**
	 * Serial version.
	 */
    private static final long serialVersionUID = -4557785669713904378L;

    /**
	 * Class constructor
	 * 
	 * @param The {@link String} with the error message
	 */
    public RepartoException(final String reason) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, reason);
    }

    protected RepartoException(final HttpStatus status, final String reason) {
        super(status, reason);
    }

    @Override
    public String getMessage() {
        return getReason();
    }
}
