package dev.revaturemax.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public String generateToken(UserDetails userDetails){
        Map<String, String> claimsMap = new HashMap<>();
        claimsMap.put("username", String.valueOf(userDetails.getUsername()));
        return Jwts.builder()
                .setClaims(claimsMap)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(key).compact();
    }

    private Claims extractAllClaimsFromToken(String token){
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    public <T> T extractClaimFromToken(String token, Function<Claims, T> claimsResolver){
        Claims claims = extractAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    public String extractUsernameFromToken(String token){
        return extractClaimFromToken(token, Claims::getSubject);
    }

    public Date extractExpirationFromToken(String token) {
        return extractClaimFromToken(token, Claims::getExpiration);
    }

    private boolean isExpiredToken(String token){
        return extractClaimFromToken(token, Claims::getExpiration).before(new Date());
    }

    public boolean validateToken(String token, UserDetails userDetails){
        String username = extractUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isExpiredToken(token));
    }
}
