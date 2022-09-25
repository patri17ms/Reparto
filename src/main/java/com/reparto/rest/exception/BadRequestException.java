package com.reparto.rest.exception;

import org.springframework.http.HttpStatus;
/**
 * 
 * BadRequestException exception Htttp status = 400
 *
 */
public class BadRequestException extends RepartoException{
	
	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = -2734711944366241206L;

	/**
	 * Class constructor
	 * 
	 * @param The {@link String} with the error message
	 */
    public BadRequestException(final String reason) {
        super(HttpStatus.BAD_REQUEST, reason);
    }

}
