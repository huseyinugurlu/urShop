package com.shop.urshop.security.token;

import com.shop.urshop.entity.User;
import com.shop.urshop.security.SecurityUser;
import java.time.Instant;
import java.util.Map;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenService implements TokenService {

  private static final String CLAIMS_USER = "user";
  private final JwtProperties jwtProperties;
  private final JwtEncoder jwtEncoder;
  private final JwsHeader jwsHeader;

  public JwtTokenService(
      final JwtProperties jwtProperties,
      final JwtEncoder jwtEncoder) {
    this.jwtProperties = jwtProperties;
    this.jwtEncoder = jwtEncoder;
    jwsHeader = JwsHeader.with(jwtProperties::getAlgorithm).build();
  }

  @Override
  public String createToken(final SecurityUser securityUser) {
    final var claims = createClaims(securityUser);
    return jwtEncoder.encode(JwtEncoderParameters.from(jwsHeader, claims)).getTokenValue();
  }

  private JwtClaimsSet createClaims(final SecurityUser securityUser) {
    final var now = Instant.now();
    final var expiresAt = now.plus(jwtProperties.getExpiration());
    return JwtClaimsSet.builder()
        .issuer(jwtProperties.getIssuer())
        .issuedAt(now)
        .expiresAt(expiresAt)
        .subject(securityUser.toString())//?????????????????
        .claim(CLAIMS_USER, securityUser)
        .build();
  }

  @Override
  public User getUser(final Object source) {
    final var claims = ((Jwt) source).getClaims();
    final var userClaims = (Map<String, Object>) claims.get(CLAIMS_USER);

    if (userClaims != null) {
      User user = new User();
      user.setId( Integer.parseInt(userClaims.get("id").toString()));
      user.setName((String) userClaims.get("name"));
      user.setEmail((String) userClaims.get("email"));
      user.setPassword((String) userClaims.get("password"));
      user.setCreationDate((String) userClaims.get("creationDate"));
      user.setAuthority((String) userClaims.get("authority"));
      return user;
    }

    return null;
  }

}
