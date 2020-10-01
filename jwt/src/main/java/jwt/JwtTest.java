package jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-10-01 15:35
 */
public class JwtTest {
    public static void main(String[] args) {
       Map<String,Object> map= new HashMap<>();
        Calendar instance=Calendar.getInstance();
        instance.add(Calendar.SECOND,200);
        final String sign = JWT.create().withHeader(map)
                .withClaim("useranme", "huran")
                .withClaim("age", 18)
                .withExpiresAt(instance.getTime())//令牌过期时间
                .sign(Algorithm.HMAC256("123456"));
        System.out.println(sign);
    }
    @Test
    public void test(){
        final JWTVerifier build = JWT.require(Algorithm.HMAC256("123456")).build();
        final DecodedJWT verify = build.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyYW5tZSI6Imh1cmFuIiwiZXhwIjoxNjAxNTM4NjM3LCJhZ2UiOjE4fQ.HJ4ITbtWTa7kuNn-Oxv5Ve7sr4svOha8QGsIe_UXFA8");
        final Claim username = verify.getClaims().get("useranme");
        System.out.println(username.asString());
        final Claim age = verify.getClaims().get("age");
        System.out.println(age.asInt());
        final Date expiresAt = verify.getExpiresAt();
        System.out.println(expiresAt);

    }
}