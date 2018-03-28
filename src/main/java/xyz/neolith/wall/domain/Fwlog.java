package xyz.neolith.wall.domain;

import java.util.Date;


/**
 * @author sunlggggg
 * @date 2017/1/12
 */
public class Fwlog {

    private Long id;

    private String internalIp;

    private Date timestamp;

    private Date anotherTimestamp;

    private String mathedStrategy;

    private String originalSrcIp;

    private String originalSrcPort;

    private String originalDestIp;

    private String originalDestPort;

    private String convertedSrcIp;

    private String convertedSrcPort;

    private String convertedDestIp;

    private String convertedDestPort;

    private Integer protocolNumber;

    private String safefymargin;

    private Integer aciton;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInternalIp() {
        return internalIp;
    }

    public void setInternalIp(String internalIp) {
        this.internalIp = internalIp;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getAnotherTimestamp() {
        return anotherTimestamp;
    }

    public void setAnotherTimestamp(Date anotherTimestamp) {
        this.anotherTimestamp = anotherTimestamp;
    }

    public String getMathedStrategy() {
        return mathedStrategy;
    }

    public void setMathedStrategy(String mathedStrategy) {
        this.mathedStrategy = mathedStrategy;
    }

    public String getOriginalSrcIp() {
        return originalSrcIp;
    }

    public void setOriginalSrcIp(String originalSrcIp) {
        this.originalSrcIp = originalSrcIp;
    }

    public String getOriginalSrcPort() {
        return originalSrcPort;
    }

    public void setOriginalSrcPort(String originalSrcPort) {
        this.originalSrcPort = originalSrcPort;
    }

    public String getOriginalDestIp() {
        return originalDestIp;
    }

    public void setOriginalDestIp(String originalDestIp) {
        this.originalDestIp = originalDestIp;
    }

    public String getOriginalDestPort() {
        return originalDestPort;
    }

    public void setOriginalDestPort(String originalDestPort) {
        this.originalDestPort = originalDestPort;
    }

    public String getConvertedSrcIp() {
        return convertedSrcIp;
    }

    public void setConvertedSrcIp(String convertedSrcIp) {
        this.convertedSrcIp = convertedSrcIp;
    }

    public String getConvertedSrcPort() {
        return convertedSrcPort;
    }

    public void setConvertedSrcPort(String convertedSrcPort) {
        this.convertedSrcPort = convertedSrcPort;
    }

    public String getConvertedDestIp() {
        return convertedDestIp;
    }

    public void setConvertedDestIp(String convertedDestIp) {
        this.convertedDestIp = convertedDestIp;
    }

    public String getConvertedDestPort() {
        return convertedDestPort;
    }

    public void setConvertedDestPort(String convertedDestPort) {
        this.convertedDestPort = convertedDestPort;
    }

    public Integer getProtocolNumber() {
        return protocolNumber;
    }

    public void setProtocolNumber(Integer protocolNumber) {
        this.protocolNumber = protocolNumber;
    }

    public String getSafefymargin() {
        return safefymargin;
    }

    public void setSafefymargin(String safefymargin) {
        this.safefymargin = safefymargin;
    }

    public Integer getAciton() {
        return aciton;
    }

    public void setAciton(Integer aciton) {
        this.aciton = aciton;
    }

//    @ManyToMany(fetch = EAGER)
//    @JoinTable(name = "relation",
//            joinColumns = {@JoinColumn(name = "eventId")},
//            inverseJoinColumns = {@JoinColumn(name = "fwlogId")})
//    public Set<Event> getEvents() {
//        return events;
//    }
//
//    public void setEvents(Set<Event> events) {
//        this.events = events;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fwlog fwlog = (Fwlog) o;

        if (id != null ? !id.equals(fwlog.id) : fwlog.id != null) return false;
        if (internalIp != null ? !internalIp.equals(fwlog.internalIp) : fwlog.internalIp != null) return false;
        if (timestamp != null ? !timestamp.equals(fwlog.timestamp) : fwlog.timestamp != null) return false;
        if (anotherTimestamp != null ? !anotherTimestamp.equals(fwlog.anotherTimestamp) : fwlog.anotherTimestamp != null)
            return false;
        if (mathedStrategy != null ? !mathedStrategy.equals(fwlog.mathedStrategy) : fwlog.mathedStrategy != null)
            return false;
        if (originalSrcIp != null ? !originalSrcIp.equals(fwlog.originalSrcIp) : fwlog.originalSrcIp != null) return false;
        if (originalSrcPort != null ? !originalSrcPort.equals(fwlog.originalSrcPort) : fwlog.originalSrcPort != null)
            return false;
        if (originalDestIp != null ? !originalDestIp.equals(fwlog.originalDestIp) : fwlog.originalDestIp != null)
            return false;
        if (originalDestPort != null ? !originalDestPort.equals(fwlog.originalDestPort) : fwlog.originalDestPort != null)
            return false;
        if (convertedSrcIp != null ? !convertedSrcIp.equals(fwlog.convertedSrcIp) : fwlog.convertedSrcIp != null)
            return false;
        if (convertedSrcPort != null ? !convertedSrcPort.equals(fwlog.convertedSrcPort) : fwlog.convertedSrcPort != null)
            return false;
        if (convertedDestIp != null ? !convertedDestIp.equals(fwlog.convertedDestIp) : fwlog.convertedDestIp != null)
            return false;
        if (convertedDestPort != null ? !convertedDestPort.equals(fwlog.convertedDestPort) : fwlog.convertedDestPort != null)
            return false;
        if (protocolNumber != null ? !protocolNumber.equals(fwlog.protocolNumber) : fwlog.protocolNumber != null)
            return false;
        if (safefymargin != null ? !safefymargin.equals(fwlog.safefymargin) : fwlog.safefymargin != null) return false;
        return aciton != null ? aciton.equals(fwlog.aciton) : fwlog.aciton == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (internalIp != null ? internalIp.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (anotherTimestamp != null ? anotherTimestamp.hashCode() : 0);
        result = 31 * result + (mathedStrategy != null ? mathedStrategy.hashCode() : 0);
        result = 31 * result + (originalSrcIp != null ? originalSrcIp.hashCode() : 0);
        result = 31 * result + (originalSrcPort != null ? originalSrcPort.hashCode() : 0);
        result = 31 * result + (originalDestIp != null ? originalDestIp.hashCode() : 0);
        result = 31 * result + (originalDestPort != null ? originalDestPort.hashCode() : 0);
        result = 31 * result + (convertedSrcIp != null ? convertedSrcIp.hashCode() : 0);
        result = 31 * result + (convertedSrcPort != null ? convertedSrcPort.hashCode() : 0);
        result = 31 * result + (convertedDestIp != null ? convertedDestIp.hashCode() : 0);
        result = 31 * result + (convertedDestPort != null ? convertedDestPort.hashCode() : 0);
        result = 31 * result + (protocolNumber != null ? protocolNumber.hashCode() : 0);
        result = 31 * result + (safefymargin != null ? safefymargin.hashCode() : 0);
        result = 31 * result + (aciton != null ? aciton.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Fwlog{" +
                "id=" + id +
//                ", internalIp='" + internalIp + '\'' +
                ", timestamp=" + timestamp +
//                ", anotherTimestamp=" + anotherTimestamp +
                ", mathedStrategy='" + mathedStrategy + '\'' +
                ", orignalSrcIp='" + originalSrcIp + '\'' +
                ", orignalSrcPort='" + originalSrcPort + '\'' +
                ", orignalDestIp='" + originalDestIp + '\'' +
                ", orignalDestPort='" + originalDestPort + '\'' +
//                ", convertedSrcIp='" + convertedSrcIp + '\'' +
//                ", convertedSrcPort='" + convertedSrcPort + '\'' +
//                ", convertedDestIp='" + convertedDestIp + '\'' +
//                ", convertedDestPort='" + convertedDestPort + '\'' +
                ", protocolNumber=" + protocolNumber +
                ", safefymargin='" + safefymargin + '\'' +
                ", aciton=" + aciton +
                '}';
    }
}
