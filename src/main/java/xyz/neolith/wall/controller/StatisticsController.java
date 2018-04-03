package xyz.neolith.wall.controller;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.neolith.wall.constants.StatisticsType;
import xyz.neolith.wall.domain.StatisticsResult;
import xyz.neolith.wall.service.StatisticsResultService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunlggggg
 * @date 2018/1/13
 */

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsResultService statisticsResultService;
    private static Gson gson = new Gson();

    /**
     * 返回5分钟内的前10的源ip
     *
     * @return {state:[],clvalues:{}}
     */
    @RequestMapping(value = "/list/{type}", method = RequestMethod.GET)
    public String getListByType(@PathVariable String type) {
        List<StatisticsResult> alStatisticResultByType = statisticsResultService.list(StatisticsType.valueOf(type), 10);
        //根据
        ArrayList alStatus = new ArrayList();
        ArrayList alIp = new ArrayList();
        ArrayList alCount = new ArrayList();

        for (StatisticsResult statisticsResult : alStatisticResultByType) {
            if (statisticsResult.getCount() > 40) {
                alStatus.add(4);
            } else if (statisticsResult.getCount() > 30 ) {
                alStatus.add(3);
            } else if (statisticsResult.getCount() > 20 ) {
                alStatus.add(2);
            } else if (statisticsResult.getCount() > 10 ) {
                alStatus.add(1);
            } else {
                alStatus.add(0);
            }
            alIp.add(statisticsResult.getStatisticsValue());
            alCount.add(statisticsResult.getCount());
        }
        for (int i = alStatus.size(); i <= 10; i++) {
            alStatus.add(0);
            alIp.add("---.---.---");
            alCount.add(0);
        }

        Map ans = new HashMap<>();
        ans.put("status", alStatus);
        ans.put("ip", alIp);
        ans.put("count", alCount);
        return gson.toJson(ans);
    }


}
