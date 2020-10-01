package jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 工具类
 * @author: HuRan
 * @create: 2020-10-01 15:54
 */
public class JwtUtils {

    private static String SIGN = "111111";

    /**
     * 生成token
     *
     * @param params
     * @return
     */
    public static String getToken(Map<String, String> params) {
        Calendar instance = Calendar.getInstance();
        final JWTCreator.Builder builder = JWT.create();
        params.forEach((k, v) -> {
            builder.withClaim(k, v);
        });
        final String token = builder.withExpiresAt(instance.getTime()).sign(Algorithm.HMAC256(SIGN));
        return token;
    }

    public static void verify(String token) {
        JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
    }
    public static DecodedJWT getTokenInfo(String token) {
        return JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
    }
}