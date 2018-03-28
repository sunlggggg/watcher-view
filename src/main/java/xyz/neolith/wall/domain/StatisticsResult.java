package xyz.neolith.wall.domain;

import xyz.neolith.wall.constants.StatisticsType;
import java.sql.Timestamp;


/**
 * @author sunlggggg
 * @date 2017/1/15
 */
public class StatisticsResult {

    private Timestamp startTime;
    private String statisticsValue;
    private int count;
    private Timestamp endTime;
    private Long id;
    private StatisticsType type;
    private Boolean isAbnormal;

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public String getStatisticsValue() {
        return statisticsValue;
    }

    public void setStatisticsValue(String statisticsValue) {
        this.statisticsValue = statisticsValue;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public StatisticsType getType() {
        return type;
    }

    public void setType(StatisticsType type) {
        this.type = type;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAbnormal() {
        return isAbnormal;
    }

    public void setAbnormal(Boolean abnormal) {
        isAbnormal = abnormal;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatisticsResult that = (StatisticsResult) o;

        if (count != that.count) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (statisticsValue != null ? !statisticsValue.equals(that.statisticsValue) : that.statisticsValue != null)
            return false;
        if (type != that.type) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return isAbnormal != null ? isAbnormal.equals(that.isAbnormal) : that.isAbnormal == null;
    }

    @Override
    public int hashCode() {
        int result = startTime != null ? startTime.hashCode() : 0;
        result = 31 * result + (statisticsValue != null ? statisticsValue.hashCode() : 0);
        result = 31 * result + count;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (isAbnormal != null ? isAbnormal.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StatisticsResult{" +
                "startTime=" + startTime +
                ", statisticsValue='" + statisticsValue + '\'' +
                ", count=" + count +
                ", type=" + type +
                ", endTime=" + endTime +
                ", id=" + id +
                ", isAbnormal=" + isAbnormal +
                '}';
    }
}
