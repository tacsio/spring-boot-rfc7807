package io.tacsio.rfc7807;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URI;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler
    public ProblemDetail onException(IllegalArgumentException argumentException) {
        var error = "Invalid arguments. " + argumentException.getMessage();
        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, error);
        problemDetail.setType(URI.create("parameters"));

        return problemDetail;
    }
}
