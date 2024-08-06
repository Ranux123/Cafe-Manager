package org.example.javaspringbootangularmysqlbackend.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
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

    private String generateToken (String subject, Map<String, Object> claims)
    {
        return Jwts.builder()
                       .setClaims(claims)
                       .setSubject(subject)
                       .setIssuedAt( new Date(System.currentTimeMillis()) )
                       .setExpiration( new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10) )
                       .signWith( SignatureAlgorithm.HS256, secret ).compact();

    }

    public Boolean methodValidateToken( String token, UserDetails userDetails )
    {
        final String username = extractUsername( token );
        if( username.equals( userDetails.getUsername() ) && !isTokenExpired( token ) )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //Continue from the 15 min mark
}
