package xyz.neolith.wall.associationanalysis;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunlggggg
 * @date 2018/4/6
 */
@Service("recordReader")
public interface IRecordReader {
    /**
     * 根据分析对象不同，实现方式不同
     * @return 返回所有项目集
     */
    List<List<String>> read();
}
