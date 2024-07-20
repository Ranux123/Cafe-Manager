package org.example.javaspringbootangularmysqlbackend.restImpl;

import org.example.javaspringbootangularmysqlbackend.constants.CafeConstants;
import org.example.javaspringbootangularmysqlbackend.rest.UserRest;
import org.example.javaspringbootangularmysqlbackend.service.UserService;
import org.example.javaspringbootangularmysqlbackend.utils.CafeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author ranuthd
 * @since 20 Jul 2024
 */

@RestController
public class UserRestImpl implements UserRest
{
    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<String> signup( Map<String,String> requestMap )
    {
        try
        {
            return userService.signUp(requestMap);
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
        return CafeUtils.getResponseEntity( CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR );
    }
}