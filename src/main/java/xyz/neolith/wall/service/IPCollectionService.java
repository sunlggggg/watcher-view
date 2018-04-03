package xyz.neolith.wall.service;

import xyz.neolith.wall.domain.IPCollection;

import java.util.List;

/**
 * @author sunlggggg
 * @date 2018/4/3
 */
public interface IPCollectionService {

    List<IPCollection> list(Integer pageNum, Integer itemNum );

}
