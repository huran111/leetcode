package redis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import redis.entity.User;
import redis.service.IUserService;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author hr
 * @since 2020-10-11 22:21:23
 */
@Api(tags = "user")
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private IUserService userService;
    @Resource
    private RedisTemplate redisTemplate;
    @ApiOperation(value = "test", notes = "")
    @GetMapping(value = "/test")
    public User test(){
        final User user = this.userService.queryById("6b75651c9ffa7be93539552a031f81c5");
        System.out.println(user);
        this.redisTemplate.opsForValue().set("user",user);
        return user;
    }

}