package kansai.k756880.nextbus;

/**
 * DepartureData
 *
 * 運行情報のデータクラス
 *
 * @author 関谷侑希
 */
public class DepartureData {
    /** 時系列順のID */
    long id;
    /** 目的地 */
    private String destination;
    /** 出発時間 */
    private String departureTime;
    /** 出発までの残り時間 */
    private String remainingTime;
    /** 遅延情報 */
    private String delay;
    /** 現在位置情報 */
    private String whereIs;

    // getterとsetter
    public long getId() { return id; }
    public void setId(long id) {
        this.id = id;
    }
    public String getDelay() {
        return delay;
    }
    public void setDelay(String delay) {
        this.delay = delay;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    public String getRemainingTime() {
        return remainingTime;
    }
    public void setRemainingTime(String remainingTime) {
        this.remainingTime = remainingTime;
    }
    public String getWhereIs() {
        return whereIs;
    }
    public void setWhereIs(String whereIs) {
        this.whereIs = whereIs;
    }
}
