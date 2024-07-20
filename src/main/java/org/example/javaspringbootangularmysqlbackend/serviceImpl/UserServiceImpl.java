package org.example.javaspringbootangularmysqlbackend.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.example.javaspringbootangularmysqlbackend.POJO.User;
import org.example.javaspringbootangularmysqlbackend.constants.CafeConstants;
import org.example.javaspringbootangularmysqlbackend.dao.UserDao;
import org.example.javaspringbootangularmysqlbackend.service.UserService;
import org.example.javaspringbootangularmysqlbackend.utils.CafeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author ranuthd
 * @since 20 Jul 2024
 */

@Slf4j
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    UserDao userDao;

    @Override
    public ResponseEntity<String> signUp( Map<String,String> requestMap )
    {
        log.info("Inside signup {}", requestMap);
        try
        {
            if( validateSignUpMap( requestMap ) )
            {
                User user = userDao.findByEmailId( requestMap.get( "email" ) );
                if( Objects.isNull( user ) )
                {
                    userDao.save( getuserFromMap( requestMap ) );
                    return CafeUtils.getResponseEntity( "Successfully Registered!", HttpStatus.OK );
                }
                else
                {
                    return CafeUtils.getResponseEntity( "Email already exists", HttpStatus.BAD_REQUEST );
                }
            }
            else
            {
                return CafeUtils.getResponseEntity( CafeConstants.INVALID_DATA, HttpStatus.BAD_REQUEST );
            }
        } catch (Exception e)
        {
            e.printStackTrace();

        }
        return CafeUtils.getResponseEntity( CafeConstants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR );
    }

    private boolean validateSignUpMap( Map<String,String> requestMap )
    {
        if( requestMap.containsKey( "name" ) && requestMap.containsKey( "contactNumber" ) && requestMap.containsKey( "email" ) && requestMap.containsKey( "password" ) )
        {
            return CafeConstants.TRUE;
        } else
        {
            return CafeConstants.FALSE;
        }
    }

    private User getuserFromMap(Map<String, String> requestMap)
    {
        User user = new User();
        user.setName( requestMap.get("name"));
        user.setContactNumber( requestMap.get("contactNumber"));
        user.setEmail( requestMap.get("email") );
        user.setPassword( requestMap.get("password") );
        user.setStatus( String.valueOf( CafeConstants.FALSE ) );
        user.setRole( "user" );
        return user;
    }
}
