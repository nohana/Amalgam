package com.amalgam.os.exception;

/**
 * Thrown when a method is invoked from wrong thread.
 * Generally, this exception is thrown when calling blocking call on main thread, or causes ANR.
 * @author keishin.yokomaku
 *
 */
public class CalledFromWrongThreadException extends RuntimeException {
    private static final long serialVersionUID = 491900897762569060L;

    public CalledFromWrongThreadException() {
        super();
    }

    public CalledFromWrongThreadException(String detailMessage) {
        super(detailMessage);
    }

    public CalledFromWrongThreadException(Throwable throwable) {
        super(throwable);
    }

    public CalledFromWrongThreadException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}