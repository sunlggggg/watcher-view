package xyz.neolith.wall.domain;

import java.util.Date;


/**
 * @author sunlggggg
 * @date 2018/3/25
 */
public class AccessFlowResult {

    public AccessFlowResult() {}

    public AccessFlowResult(Date timestamp, int count) {
        this.count = count;
        this.timestamp = timestamp;
    }

    private Long id;

    private Integer count;

    private Date timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }



}
