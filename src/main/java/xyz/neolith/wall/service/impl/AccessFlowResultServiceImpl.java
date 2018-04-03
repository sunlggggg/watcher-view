package xyz.neolith.wall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.neolith.wall.mapper.AccessFlowResultMapper;
import xyz.neolith.wall.service.AccessFlowResultService;

import java.util.List;

/**
 * @author sunlggggg
 * @date 2018/3/26
 */
@Service("accessFlowResult")
public class AccessFlowResultServiceImpl implements AccessFlowResultService {
    @Autowired
    private AccessFlowResultMapper accessFlowResultMapper;
    @Override
    public List<Integer> list(int len) {
        return accessFlowResultMapper.list(len);
    }
}
