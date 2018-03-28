package xyz.neolith.wall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.neolith.wall.domain.User;
import xyz.neolith.wall.mapper.UserMapper;
import xyz.neolith.wall.service.UserService;

/**
 * @author sunlggggg
 * @date 2018/3/26
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public int save(User user) {
        return userMapper.insert(user.getName(),user.getPassword(),user.getPhone());
    }
}
