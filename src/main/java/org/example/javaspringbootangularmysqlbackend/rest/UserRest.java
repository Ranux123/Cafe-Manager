package org.example.javaspringbootangularmysqlbackend.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author ranuthd
 * @since 20 Jul 2024
 */

@RequestMapping("/user")
public interface UserRest
{
    @PostMapping(path = "/signup")
    public ResponseEntity<String> signup( @RequestBody(required = true) Map<String, String> requestMap);
}
