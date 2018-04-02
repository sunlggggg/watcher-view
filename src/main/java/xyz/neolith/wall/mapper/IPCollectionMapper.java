package xyz.neolith.wall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xyz.neolith.wall.domain.IPCollection;

import java.util.List;

/**
 * @author sunlggggg
 * @date 2018/3/31
 */
@Mapper
public interface IPCollectionMapper {
    @Select("select * from ipcollection ORDER BY startTime DESC LIMIT 0,#{size};")
    List<IPCollection> list(Integer size);
}
