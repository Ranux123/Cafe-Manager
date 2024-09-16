package org.example.javaspringbootangularmysqlbackend.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * <b>UserRest Interface</b>
 * This interface defines the REST endpoints for user-related operations.
 * It includes methods for user signup.
 *
 * @author ranuthd
 * @since 20 Jul 2024
 */

@RequestMapping("/user")
public interface UserRest
{
    @PostMapping(path = "/signup")
    public ResponseEntity<String> signup( @RequestBody(required = true) Map<String, String> requestMap);

    @PostMapping(path = "/login")
    public ResponseEntity<String> login( @RequestBody(required = true) Map<String, String> requestMap);
}