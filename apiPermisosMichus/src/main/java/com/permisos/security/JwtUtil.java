package com.permisos.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    private static final String SECRET_KEY = "3fb261c9eab9df3b7343b039f75ac8f448136cbf2facebf756ff9f0108af0223daee7db655efa4c19b7734a238486cb0d6a840094e6d65d26a3d13e0666aeb5d9473453aa1160e0bfc5995a14cf4b1801943a9faf2dedde4aa4fa68c170cfd2264cd6cf79471ee047ca043018191eaa2e88123be95a02fed8da2d295afba007369a79166768d4c75739e1fd4dafd37d04d58cd1ef621bacf7e26155441ad8f2c82df7dd1349a2505d077b4723c7b5f8c5831909557df37c1f323fcd63e2001791ed26bdc9cb8b536c76711a987ec256d02947ead1ab62d22cbb9e5d62fa33db5f460f371a2d4108bdd63dc50084a9631f0ea3f09fca5eba21159805a67ad817d977cb3105c532705eddda48dfb5e215908ead79d69447b3655ca1c39768fb0f298128c65649870c8c17b345e5abdc812decb687874f8fd3df73ebdc8dfe871d8f3167bf64b123186e4a17be9594bcd85304ca13fda016db8f53ab1002e7bd390d3d575a0d14d47279d706f2a1ca434c428177316914cc3fc0ba8aef2d025805fab41c4b7f77097013634b2c616477f3ee0dfc7069967f41758a7c047faa03695664dfeb6bc2894a49b405b1af312326b734ea253426f2c778a28d537ebc86c2bfc46bf140caf402865c183fe02e176181c05dfe9d4dadf55b74aa306a823b38cda6db6cf65abfdf5a9b520d2e21997de5917f36c03ad1b35055ecd9574e3887b";
    private static final long EXPIRATION_TIME = 86400000 ; //  24 horas en milisegundos
    public String generateToken(String username, String role) {
        return Jwts.builder()
                .subject(username)
                .claim("role", role)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY)))
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY)))
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String token) {
        try {
            extractClaims(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}
