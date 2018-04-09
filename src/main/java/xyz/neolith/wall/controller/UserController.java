package xyz.neolith.wall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.neolith.wall.domain.User;
import xyz.neolith.wall.service.UserService;
import xyz.neolith.wall.utils.JwtUtils;

import java.util.*;

/**
 * @author sunlggggg
 * @date 2018/3/26
 */
@RestController
@RequestMapping(value = "/user")     // 通过这里配置使下面的映射都在/users下
public class UserController {

    @Autowired
    private UserService userService;

    // 创建线程安全的Map
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    // 处理"/users/"的GET请求，用来获取用户列表
    // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }

    // 处理"/users/"的POST请求，用来创建User
    // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        if (userService.register(user) > 0) {
            return "success";
        } else {
            return "fail";
        }

    }

    // 处理"/users/"的POST请求，用来创建User
    // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@RequestBody User user) {
        if (userService.login(user)) {
            String jwt = JwtUtils.generateToken(user.getEmail());
            return new HashMap<String, String>() {{
                put("token", jwt);
            }};
        } else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

    }

    // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
    // url中的id可通过@PathVariable绑定到函数的参数中
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    // 处理"/users/{id}"的PUT请求，用来更新User信息
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        User u = users.get(id);
        u.setName(user.getName());
        users.put(id, u);
        return "success";
    }

    // 处理"/users/{id}"的DELETE请求，用来删除User
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }
}