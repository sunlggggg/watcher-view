package xyz.neolith.wall.service;

import org.springframework.stereotype.Service;
import xyz.neolith.wall.domain.User;

/**
 * @author sunlggggg
 * @date 2018/3/26
 */

public interface UserService {
    int save(User user);
}
