package xyz.neolith.wall;

/**
 * 只是初始化一次
 * @author sunlggggg
 * @date 2018/4/10
 */
public class UserInfo {

    public static String username;

    private UserInfo() {
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        UserInfo.username = username;
    }

    public static void main(String[] args) {
        System.out.println(UserInfo.username);
    }
}
