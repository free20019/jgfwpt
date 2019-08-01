package mvc.service;

/**
 * Created by xiaxing
 * At 2019/2/18 9:35
 */
public interface IndustryOperationService {
    //单车营运情况
    String getCyclingOperation(String vehiNo,String stime,String etime,String currentPage,String pageSize,String region);
    //行业营运情况分析
    String getIndustryOperations(String vehiNo,String companyName,String stime,String etime);
    //行业平均运行情况分析
    String getIndustryOperation(String stime,String etime,String companyName);
    //运力需求热点分析
    String getTransportationCapacityHotspot();
    //企业车辆营运情况分析
    String getVehicleOperation(String companyName,String stime,String etime);
    //驾驶员收入情况分析
    String getIncomeAnalysis(String cardNumber,String stime,String etime);
    //车辆运行排行
    String getVehicleRunningRanking(String companyName,String cardNumber,String stime,String etime,String region,String currentPage,String pageSize);
    //投诉查询
    String getComplaintsStatistics(String typeComplaint,String stime,String etime,String currentPage,String pageSize);
    //OD营运数据分析
    String getODOperationDataAnalysis(String SJD,String stime,String etime,String QD,String currentPage,String pageSize);
    //OD流向统计
    String getODFlowStatistics(String SJD,String stime,String etime,String QD);
    //OD流向图
    String getODFlowDiagram(String SJD,String stime,String etime,String QD,String currentPage,String pageSize);
    //夜间停放位置分析
    String getParkingPlaceAtNight(String time,String currentPage,String pageSize);
    //驾驶员违法统计
    String getDriverIllegalStatistics(String vehicle,String partyName,String stime,String etime,String currentPage,String pageSize,String region);
    //导出OD营运数据分析
    String getODOperationDataAnalysisExcel(String sjd, String stime, String etime, String qd, String currentPage, String pageSize);
    //运行中不在线车辆
    String getVehiclesOperationNotOnline(String vehicle, String area, String sTime, String eTime, String type, String currentPage, String pageSize);
    //运行中不在线车辆统计
    String getVehiclesOperationNotOnlineStatistics(String vehicle, String area, String sTime, String eTime, String type);
    //司机签到签退查询
    String getDriverSignAndSignOffQuery(String vehicle, String area, String icVehicle, String certificate, String sTime, String eTime);
    //运力需求热点
    String getcapacitydemandhotspot(String stime, String etime);
    //运力需求热点(司机分布)
    String getcapacitydemandhotspotdriver(String stime, String etime);
}
