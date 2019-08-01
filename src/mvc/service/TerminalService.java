package mvc.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author: xianlehuang
 * @Description:
 * @date: 2019/02/18
 */
public interface TerminalService {
    String getVehicle();

    String getHostfailure(String lPNumber, String faultType, String area);

    Integer audit(String vehicle, String fields,String type);

    String terminalerror();

    String goodrate(String companyName, String stime, String etime);

    String online(String companyName, String stime, String etime);

    String notonline(String vehicle, String companyName, String area, String stime, String etime, Integer currentPage, Integer pageSize);

    String workorderinquiry(String vehicle,String area, String stime, String etime);

    Integer workorderaudit(String vehicle,String remarks);

    String hostfailurehistory(String lPNumber, String area, String time, String faultType, Integer currentPage, Integer pageSize);

    String upload(MultipartFile file);

    String videoshift(String vehicle, Integer currentPage, Integer pageSize);

    Integer videoaudit(String id, String vehicle, String mdt_no, String times, String road_e1, String road_e2, String road_e3, String road_e4);

    String occasionaldropoffvehicleinquiry(String vehicle, String area, String count, String stime,String etime, Integer currentPage, Integer pageSize);

    String occasionaldropoffvehiclestatistics(String vehicle, String area, String count);
}
