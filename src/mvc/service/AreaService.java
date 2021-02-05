package mvc.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: xianlehuang
 * @Description:
 * @date: 2019/03/19
 */
public interface AreaService {
    String findarea();

    Integer addarea(String name, String describe, String coordinates, String size);

    Integer updatearea(String id, String name, String describe, String coordinates, String size);

    Integer deletearea(String id);

    String returnCompany(String company, String area);

    Integer addreturncompany(String company, String area, String time);

    Integer updatereturncompany(String id, String company, String area, String time);

    Integer deletereturncompany(String id);

    String returnvehicleinquiry(String vehicle, String companyName, String area, String count, String stime, String etime);

    String reportstatistics(String companyName, String fulfill, String stime, String etime);

    String returnvehicleontime(String vehicle, String companyName, String area, String count, String stime, String etime);

    String vehicletransfer(String vehicle, String companyName, String area, String stime, String etime, String type, String status);

    Integer transferaudit(String id, String jobNum, String reason, String issh);

    String licensechange(String odlVehicle, String newVehicle, String area, String stime, String etime, String type);

    Integer changeaudit(String id, String jobNum, String reason, String issh);

    String vehicleparking(String vehicle, String area, String stime, String etime, String type);

    Integer parkingaudit(String id, String jobNum, String reason, String issh);

    String dataAccess(String vehicle, String companyName, String area, String stime, String etime, String type);

    Integer dataAccessAudit(String id, String jobNum, String reason, String issh);

    String vehicletransferoroutstatistics(String vehicle, String companyName, String area, String stime, String etime, String status, String type);

    String licensechangestatistics(String odlVehicle, String newVehicle, String area, String stime, String etime, String type);

    String stopstatistics(String vehicle, String companyName, String area, String stime, String etime);

    String loveApproval(String vehicle, String companyName, String area, String stime, String etime, String type, String phone, String address);

    Integer loveApprovalAudit(String id, String jobNum, String reason, String issh);

    String getThisTableField(String field);

    String getDecommissioningAssistanceApproval(String vehicle, String companyName, String assist, String stime, String etime, String type);

    Integer decommissioningAssistanceAudit(String id, String jobNum, String reason, String issh);

    String auditManage(HttpServletRequest request);
}
