package xyz.neolith.wall.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.neolith.wall.domain.Record;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author sunlggggg
 * @date 2018/3/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RecordMapperTest {
    @Autowired
    private RecordMapper recordMapper;
    @Test
    public void save() {
        recordMapper.save(new Date(),"今日头条","ok，放心啦",0L);
    }

    @Test
    public void update() {
        Record record = new Record();
        record.setId(21L);
        record.setTitle("ni you");
        record.setRecordInfo("xi huan de ren le ma");
        recordMapper.update(record);
    }
}