package xyz.neolith.wall.associationanalysis;

import org.springframework.beans.factory.annotation.Autowired;
import xyz.neolith.wall.domain.Fwlog;
import xyz.neolith.wall.mapper.FwlogMapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author sunlggggg
 * @date 2018/4/6
 */
public class RecordReaderImpl implements IRecordReader {
    private final static int TIME_INTERVAL = 1000;//1000毫秒

    @Autowired
    private FwlogMapper fwlogMapper ;

    /**
     * 根据分析对象不同，实现方式不同
     *
     * @return 返回所有项目集
     */
    @Override
    public List<List<String>> read() {
        //日志集合 时间的大小
        List<List<String>> record = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date st = null, et = null;
        try {
            //日志开始时间
            st = df.parse("2018-03-27 14:32:45");
            //日志结束时间
            et = df.parse("2018-03-27 14:33:55");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        while (st.getTime() < et.getTime()) {
            record.add(fwlogMapper.findByTime(st,et));
            st = new Date(st.getTime() + TIME_INTERVAL);
        }

        return record;
    }
}
