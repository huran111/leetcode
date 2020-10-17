package redis.service;

import redis.entity.User;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author hr
 * @since 2020-10-11 22:21:23
 */
public interface IUserService  {


    User queryById(String s);
}