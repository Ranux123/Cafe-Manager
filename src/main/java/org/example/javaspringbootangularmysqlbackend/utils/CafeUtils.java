package org.example.javaspringbootangularmysqlbackend.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author ranuthd
 * @since 20 Jul 2024
 */
public class CafeUtils
{
    private CafeUtils ()
    {

    }

    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus)
    {
        return new ResponseEntity<String>( " {\"message\" :\""+responseMessage+"\"}", httpStatus );
    }
}
