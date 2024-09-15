package org.example.javaspringbootangularmysqlbackend.JWT;

import lombok.extern.slf4j.Slf4j;
import org.example.javaspringbootangularmysqlbackend.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Slf4j
@Service
public class CustomerUserDetailService implements UserDetailsService
{
    @Autowired
    UserDao userDao;

    private org.example.javaspringbootangularmysqlbackend.POJO.User userDetail;

    @Override
    public UserDetails loadUserByUsername( String username ) throws  UsernameNotFoundException
    {
        log.info( "Inside loadUserByUsername {}", username );
        userDetail = userDao.findByEmailId( username );
        if( !Objects.isNull( userDetail ) )
        {
            return new User( userDetail.getEmail(), userDetail.getPassword(), new ArrayList<>() );
        }
        else
        {
            throw new UsernameNotFoundException( "User not Found" );
        }
    }

    public org.example.javaspringbootangularmysqlbackend.POJO.User getUserDetail()
    {
        return userDetail;
    }
}
