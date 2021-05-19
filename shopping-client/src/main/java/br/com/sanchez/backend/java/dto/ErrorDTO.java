package br.com.sanchez.backend.java.dto;

import java.util.Date;

public class ErrorDTO {

    private int status;
    private String message;
    private Date timestamp;

    public ErrorDTO() {
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(final int status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(final Date timestamp) {
        this.timestamp = timestamp;
    }

}