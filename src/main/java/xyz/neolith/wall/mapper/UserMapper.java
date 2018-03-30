package xyz.neolith.wall.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xyz.neolith.wall.domain.User;

@Mapper
public interface UserMapper {

	@Select("SELECT * FROM USER WHERE PHONE = #{phone}")
	User findUserByPhone(@Param("phone") String phone);

	@Insert("INSERT INTO USER(NAME, PASSWORD, PHONE) VALUES(#{name}, #{password}, #{phone})")
	int insert(@Param("name") String name, @Param("password") String password, @Param("phone") String phone);

}
