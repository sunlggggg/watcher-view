package xyz.neolith.wall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * @author sunlggggg
 * @date 2017/1/12
 */

@Mapper
public interface AccessFlowResultMapper {

    @Select("SELECT AccessFlowResult.count FROM AccessFlowResult ORDER BY id DESC LIMIT #{listLength} ")
    List<Integer> list(Integer listLength) ;

}
