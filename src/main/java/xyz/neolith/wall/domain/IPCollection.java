package xyz.neolith.wall.domain;

import java.util.Date;

/**
 * @author sunlggggg
 * @date 2018/3/31
 */
public class IPCollection {
    private Long id;
    private String collection;
    private Date startTime;
    private Date endTime;

    public IPCollection() {
    }

    public Long getId() {
        return id;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
