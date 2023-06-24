package com.app.backend.config;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.app.backend.exception.AppException;
import com.app.backend.ulti.BusinessErrorCode;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

import java.security.Key;

/**
 * https://github.com/jwtk/jjwt#overview jwt lib source
 */
@Component
public class JwtProvider {
    @Value("${jwt.secret}")
    private String SECRET_KEY;

    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    /**
     * generate jwt token
     * setId : setUsername to jwt
     * setIssuedAt: set created time
     * setExpiration: set expire of jwt, 3 minute from create time
     * 
     * @param username username
     * @return jwt
     */
    public String doGenerateJwt(String username) {

        Instant issuaAt = Instant.now().truncatedTo(ChronoUnit.SECONDS);
        Instant expiration = issuaAt.plus(3, ChronoUnit.MINUTES);

        Claims claims = Jwts.claims();
        claims.setId("king");
        claims.setExpiration(Date.from(expiration));
        claims.setIssuedAt(Date.from(issuaAt));
        claims.setSubject(username);

        return Jwts.builder().setClaims(claims)
                .signWith(key).compact();

    }

    public Jws<Claims> checkJwt(String jwt) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException
                | IllegalArgumentException ex) {
            throw new AppException(BusinessErrorCode.IVALID_TOKEN);
        }
    }

    public Boolean isTokenExpire(String jwt) {
        Jws<Claims> claims = checkJwt(jwt);
        return claims.getBody().getExpiration().before(new Date());
    }

}
