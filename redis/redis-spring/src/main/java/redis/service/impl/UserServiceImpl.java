package redis.service.impl;


import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import redis.dao.UserMapper;
import redis.entity.User;
import redis.service.IUserService;

/**
 * (User)表服务实现类
 *
 * @author hr
 * @since 2020-10-11 22:21:23
 */
@Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
@Service("userService")
public class UserServiceImpl  implements IUserService {
    @Resource
    private UserMapper userMapper;


    @Override
    public User queryById(String id) {
      return   this.userMapper.queryById(id);
    }
}