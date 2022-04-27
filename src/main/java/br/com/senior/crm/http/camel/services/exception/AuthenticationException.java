package br.com.senior.crm.http.camel.services.exception;

public class AuthenticationException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public AuthenticationException(String message)
    {
        super(message);
    }

    public AuthenticationException(Throwable cause)
    {
        super(cause);
    }
}
