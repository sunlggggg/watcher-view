package xyz.neolith.wall.mapper;

import org.apache.ibatis.annotations.*;
import xyz.neolith.wall.domain.Record;

import java.util.Date;
import java.util.List;

/**
 * @author sunlggggg
 * @date 2018/3/29
 */
@Mapper
public interface RecordMapper {
    @Insert("INSERT INTO Record(createTime, title, recordInfo, userid) VALUES(#{createTime}, #{title}, #{recordInfo}, #{userid})")
    int save(@Param("createTime") Date Date, @Param("title") String title, @Param("recordInfo") String recordInfo, @Param("userid") Long userid );

    @Select("SELECT COUNT(*) FROM record;")
    int maxId();

    @Select("select * from record ORDER BY createTime DESC LIMIT #{fromId}, #{itemNum}; ")
    List<Record> list(@Param("fromId") Integer fromId ,@Param("itemNum") Integer itemNum);

    @Update("UPDATE record SET title = #{title} , recordinfo = #{recordInfo} WHERE id = #{id};")
    int update(Record record);
}
