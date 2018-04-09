package xyz.neolith.wall.service;

import xyz.neolith.wall.domain.User;

/**
 * @author sunlggggg
 * @date 2018/3/26
 */

public interface UserService {
    int register(User user);

    boolean login(User user);
}
