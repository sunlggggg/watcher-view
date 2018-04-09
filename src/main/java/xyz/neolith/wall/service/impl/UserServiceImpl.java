package xyz.neolith.wall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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


    @Transactional
    @Override
    public int register(User user) {
        if (userMapper.findUserByEmail(user.getEmail()) != null) {
            return userMapper.insert(user.getName(), user.getPassword(), user.getEmail());
        } else {
            return 0;
        }
    }

    @Override
    public boolean login(User user) {
        return userMapper.findUserByEmailAndPassword(user.getEmail(), user.getPassword()) != null;
    }
}
