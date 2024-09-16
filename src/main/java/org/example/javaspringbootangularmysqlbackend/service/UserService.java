package org.example.javaspringbootangularmysqlbackend.service;

import org.springframework.http.ResponseEntity;





import java.util.Map;

/**
 * <b>UserService Interface</b>
 * This interface defines the contract for user-related operations.
 * It includes methods for user signup and other user management functionalities.
 *
 * @author ranuthd
 * @since 20 Jul 2024
 */

public interface UserService
{
    ResponseEntity<String> signUp( Map<String, String> requestMap);

    ResponseEntity<String> login( Map<String,String> requestMap );
}