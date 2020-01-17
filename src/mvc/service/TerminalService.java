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

    String goodrate(String companyName, String area, String stime, String etime);

    String online(String companyName, String stime, String etime, String area);

    String notonline(String vehicle, String companyName, String area, String stime, String etime, Integer currentPage, Integer pageSize);

    String workorderinquiry(String vehicle,String area, String stime, String etime);

    Integer workorderaudit(String vehicle, String remarks, String type);

    String hostfailurehistory(String lPNumber, String area, String time, String faultType, Integer currentPage, Integer pageSize);

    String upload(MultipartFile file);

    String videoshift(String vehicle, Integer currentPage, Integer pageSize);

    Integer videoaudit(String id, String vehicle, String mdt_no, String times, String road_e1, String road_e2, String road_e3, String road_e4);

    Integer getTrueAudit(String vehicle, String fields, String type);

    String occasionaldropoffvehicleinquiry(String vehicle, String area, String count, String stime,String etime, Integer currentPage, Integer pageSize);

    String occasionaldropoffvehiclestatistics(String vehicle, String area, String count);

    String administratorPhoneManagement();

    Integer addAdministratorPhoneManagement(String company, String manager, String phone, String remarks);

    Integer updateAdministratorPhoneManagement(String id, String company, String manager, String phone, String remarks);

    Integer deleteAdministratorPhoneManagement(String id);

    String noOperatingData(String vehicle, String companyName, String area, String stime, String etime);

    String unSignInAndSignOff(String vehicle, String companyName, String area, String stime, String etime);

    String sendMessage(String postData);

    String AbnormalDataAlarm(String vehicle, String driver, String type, String area, String time, Integer currentPage, Integer pageSize);

    String getAnnualTaxiOwnershipAnalysis(String companyName);
}
