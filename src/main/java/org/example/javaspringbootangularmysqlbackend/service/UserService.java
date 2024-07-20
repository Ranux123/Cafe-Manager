package org.example.javaspringbootangularmysqlbackend.service;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

import java.util.Map;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author ranuthd
 * @since 20 Jul 2024
 */
public interface UserService
{
    ResponseEntity<String> signUp( Map<String, String> requestMap);

}
