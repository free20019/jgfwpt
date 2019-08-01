package mvc.service;

public interface ServicePlatformUsageService {
    //安装情况统计
    String getInstallationStatistics(String companyName);
    //安装情况月度分析图表
    String getMonthInstallAnalysis(String stime,String etime);
    //维修管理查询
    String getMaintenanceManageInquiry(String realName, String userName, String stime, String etime);
    //维修管理统计
    String getMaintenanceManageStatistics(String realName, String userName, String stime, String etime);
    //获取企业名称
    String getCompanyName();
    //企业分中心查询
    String GetEnterpriseSubCenterQuery(String realName, String userName, String stime, String etime);
    //企业分中心统计
    String getEnterpriseSubCenterStatistics(String realName, String userName, String stime, String etime);
    //查询车牌号
    String getVehiNo();
    //终端未安装查询
    String getTerminalInstalled(String plateNumber,String stime,String etime,String region);
    //手持分中心查询
    String getHandheldMonitoringQuery(String userName, String stime, String etime);
    //手持分中心统计
    String GetHandheldMonitoringStatistics(String userName, String stime, String etime);
}
