package mvc.service;

/**
 * @author: xianlehuang
 * @Description:
 * @date: 2019/03/07
 */
public interface CaptureDataService {
    String capturedata(String vehicle, String companyName, String area, String depot, String timePeriod, String stime, String etime, String type, Integer currentPage, Integer pageSize);

    String stationtraffic(String depot, String stime, String etime, String type);

    String dailytraffic(String depot, String stime, String etime, String type);

    String segmentedtraffic(String depot, String time, String type);
}
