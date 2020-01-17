package mvc.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author: xianlehuang
 * @Description:重点区域
 * @date: 2019/9/27 - 15:05
 */
public interface KeyAreaService {

    String findarea();

    Integer addarea(String name, String describe, String coordinates, String size, String warning);

    Integer updatearea(String id, String name, String describe, String coordinates, String size, String warning);

    Integer deletearea(String id);

    String getKeyAreasVehicleQuantityMonthlyReport(String area, String time);

    String getKeyAreasVehicleQuantityHalfAYearReport(String area, String time, String type);

    List<Map<String, Object>> getAreaMonitor();

    List<Map<String, Object>> getVehicleMonitor();

    String qyjk();

    String getDoubtfulDeck(String vehicle, String companyName, String area, String point, String stime, String etime, Integer currentPage, Integer pageSize);

    String getSuspectedBlackCar(String vehicle, String area, String type, String point, String stime, String etime, Integer currentPage, Integer pageSize);

    String getAbnormalOperationValuatorAnalysis(String vehicle, String area, String stime, String etime, Integer currentPage, Integer pageSize);

    String getAbnormalOperatingMileageAnalysis(String time, Integer low, Integer high, String area);

    String getAbnormalOperatingMileageAnalysisDetails(String time, Integer low, Integer high, String area);

    String getSingleOperationAnomalyAnalysis(String time, Integer low, Integer high, String area);

    String getSingleOperationAnomalyAnalysisDetails(String time, Integer low, Integer high, String area);

    String getPushingViolationDataOfKeyVehicleOperation(String lPNumber, String illegalType, String area, String stime, String etime, Integer currentPage, Integer pageSize);

    Integer audit(String check_id, String vehicle, String illegal_type, String illegal_id, String result);

    String getDataExceptionOrder(String vehicle, String area, String stime, String etime);

    Integer getWorkOrderAudit(String id,String remarks, String check_id);

    String findKeyFollowVehicle();

    String upload(MultipartFile file);

    Integer addOrDeleteKeyFollowVehicleOne(String vehicle, String type, String whether);

    Integer deleteKeyFollowVehicle();

    List<Map<String, Object>> findFocusMonitor();

    List<Map<String, Object>> findFaultMonitor();

    String getAbnormalDataAlarmRectificationReport(String vehicle, String area, Integer currentPage, Integer pageSize);

    String getWeeklyDataQualityReport(String stime, String etime, String area);

    String getMonthlyDataQualityReport(String time, String area);

    String getSemiAnnualDataQualityReport(String time, String type, String area);

    String getAnnualDataQualityReport(String time, String area);

    String findAbnormalDisposalProcess(HttpServletRequest request);

    Integer addAbnormalDisposalProcess(HttpServletRequest request);

    Integer updateAbnormalDisposalProcess(HttpServletRequest request);

    Integer deleteAbnormalDisposalProcess(String id);

    Integer auditAbnormalDisposalProcess(String id, String status);
}
