package io.tacsio.rfc7807;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public record GreetingController() {

    @GetMapping("/greeting/{name}")
    ResponseEntity<?> greet(@PathVariable String name) throws IllegalAccessException {
        if (!StringUtils.hasText(name) || !Character.isUpperCase(name.charAt(0))) {
            throw new IllegalArgumentException("Must start with capital letter");
        }

        var response = "Hello, " + name;
        return ResponseEntity.ok(response);
    }
}
