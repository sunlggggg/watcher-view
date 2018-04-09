package xyz.neolith.wall.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xyz.neolith.wall.domain.User;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE EMAIL = #{email}")
    User findUserByEmail(@Param("email") String email);

    @Insert("INSERT INTO USER(NAME, PASSWORD, EMAIL) VALUES(#{name}, #{password}, #{email})")
    int insert(@Param("name") String name, @Param("password") String password, @Param("email") String email);

    @Select("SELECT * FROM USER WHERE EMAIL = #{email} and PASSWORD = #{password}")
    User findUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
