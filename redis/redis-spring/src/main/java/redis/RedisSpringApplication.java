package redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("redis.dao")
@SpringBootApplication
public class RedisSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisSpringApplication.class, args);
    }

}
