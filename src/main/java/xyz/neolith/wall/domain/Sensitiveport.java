package xyz.neolith.wall.domain;


/**
 * @author sunlggggg
 * @date 2017/1/13
 */
public class Sensitiveport {

    private Integer port;
    private String desc;

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sensitiveport that = (Sensitiveport) o;

        if (port != null ? !port.equals(that.port) : that.port != null) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = port != null ? port.hashCode() : 0;
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Sensitiveport{" +
                "port=" + port +
                ", desc='" + desc + '\'' +
                '}';
    }
}
