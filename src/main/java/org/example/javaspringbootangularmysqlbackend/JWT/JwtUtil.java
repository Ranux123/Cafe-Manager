package org.example.javaspringbootangularmysqlbackend.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.function.Function;

@Service
public class JwtUtil
{
    private String secret = "ranux@123";

    public String extractUsername( String token )
    {
        return extractClaims( token, Claims::getSubject );
    }

    public Date extractExpirationDate( String token )
    {
        return extractClaims( token, Claims::getExpiration );
    }

    public <T> T extractClaims( String token, Function<Claims,T> claimsResolver )
    {
        final Claims claims = extractAllClaims( token );
        return claimsResolver.apply( claims );
    }

    public Claims extractAllClaims( String token )
    {
        return Jwts.parser().setSigningKey( secret ).parseClaimsJws( token ).getBody();
    }

    private Boolean isTokenExpired( String token )
    {
        if( extractExpirationDate( token ).before( new Date() ) )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean methodValidateToken ( String token, UserDetails userDetails )
    {
        final String username = extractUsername( token );
        if ( username.equals( userDetails.getUsername()) && !isTokenExpired( token ))
        {
            return true;
        } else
        {
            return false;
        }
    }

    //Continue from the 15 min mark
}
