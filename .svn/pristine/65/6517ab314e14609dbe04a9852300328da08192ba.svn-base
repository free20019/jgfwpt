package mvc.controller;

import mvc.service.ServicePlatformUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import util.DownloadAct;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaxing
 * At 2019/2/18 8:28
 */
//服务平台使用情况分析
@Controller
@RequestMapping("/servicePlatformUsage")
public class ServicePlatformUsageController {

    @Autowired
    private ServicePlatformUsageService servicePlatformUsageService;
    private DownloadAct downloadAct = new DownloadAct();

    //手持分中心查询
    @RequestMapping("/getHandheldMonitoringQuery")
    @ResponseBody
    public String GetHandheldMonitoringQuery(HttpServletRequest request){
        String userName = request.getParameter("userName");
        String stime = request.getParameter("stime");
        String etime = request.getParameter("etime");
        return servicePlatformUsageService.getHandheldMonitoringQuery(userName,stime,etime);
    }

    //手持分中心统计
    @RequestMapping("/getHandheldMonitoringStatistics")
    @ResponseBody
    public String GetHandheldMonitoringStatistics(HttpServletRequest request){
        String userName = request.getParameter("userName");
        String stime = request.getParameter("stime");
        String etime = request.getParameter("etime");
        return servicePlatformUsageService.GetHandheldMonitoringStatistics(userName,stime,etime);
    }

    //维修管理查询
    @RequestMapping("/getMaintenanceManageInquiry")
    @ResponseBody
    public String GetMaintenanceManageInquiry(HttpServletRequest request) throws UnsupportedEncodingException {
        String realName = request.getParameter("realName");
        String userName = request.getParameter("userName");
        String stime = request.getParameter("stime");
        String etime = request.getParameter("etime");
        return servicePlatformUsageService.getMaintenanceManageInquiry(realName,userName,stime,etime);
    }
    //维修管理统计
    @RequestMapping("/getMaintenanceManageStatistics")
    @ResponseBody
    public String GetMaintenanceManageStatistics(HttpServletRequest request) throws UnsupportedEncodingException {
        String realName = request.getParameter("realName");
        String userName = request.getParameter("userName");
        String stime = request.getParameter("stime");
        String etime = request.getParameter("etime");
        return servicePlatformUsageService.getMaintenanceManageStatistics(realName,userName,stime,etime);
    }

    //获取企业名称105 ELECTRIC_TRICK_CAR 下 TB_USER
    @RequestMapping("/getCompanyName")
    @ResponseBody
    public String GetCompanyName(){
        return servicePlatformUsageService.getCompanyName();
    }

    //企业分中心查询
    @RequestMapping("/getEnterpriseSubCenterQuery")
    @ResponseBody
    public String GetEnterpriseSubCenterQuery(HttpServletRequest request) throws UnsupportedEncodingException {
        String realName = request.getParameter("realName");
        String userName = request.getParameter("userName");
        String stime = request.getParameter("stime");
        String etime = request.getParameter("etime");
        return servicePlatformUsageService.GetEnterpriseSubCenterQuery(realName,userName,stime,etime);
    }

    //企业分中心统计
    @RequestMapping("/getEnterpriseSubCenterStatistics")
    @ResponseBody
    public String GetEnterpriseSubCenterStatistics(HttpServletRequest request) throws UnsupportedEncodingException {
        String realName = request.getParameter("realName");
        String userName = request.getParameter("userName");
        String stime = request.getParameter("stime");
        String etime = request.getParameter("etime");
        return servicePlatformUsageService.getEnterpriseSubCenterStatistics(realName,userName,stime,etime);
    }

    //查询车牌号
    @RequestMapping("/getVehiNo")
    @ResponseBody
    public String getVehiNo(){
        return servicePlatformUsageService.getVehiNo();
    }

    //终端未安装查询
    @RequestMapping("/getTerminalInstalled")
    @ResponseBody
    public String getTerminalInstalled(HttpServletRequest request) throws UnsupportedEncodingException {
        String plateNumber = request.getParameter("plateNumber");
        String region = request.getParameter("region");
        String stime = request.getParameter("stime");
        String etime = request.getParameter("etime");
        return servicePlatformUsageService.getTerminalInstalled(plateNumber,stime,etime,region);
    }

    //终端未安装查询导出
    @RequestMapping("/getTerminalInstalledExcel")
    @ResponseBody
    public String getTerminalInstalledExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String plateNumber = request.getParameter("plateNumber");
        String region = request.getParameter("region");
        String stime = request.getParameter("stime");
        String etime = request.getParameter("etime");
        String a[] = {"业户名称","行政区划名称","经营范围名称","经营许可证号","证照是否过期","车牌号码","车牌颜色","车辆类型","厂牌","型号","更新时间","购车日期","车辆识别代码","燃料类型","道路运输证核发机关","道路运输证有效期起","道路运输证有效期止","年审有效期起","年审有效期止"};//导出列明
        String b[] = {"COMPANY_NAME","AREA_NAME","BUSINESS_SCOPE_NAME","COMPANY_LICENSE_NUMBER","IS_EXPIRED","PLATE_NUMBER","PLATE_COLOR","PLATE_TYPE","BRAND","MODEL","UPDATED_TIME","PURCHASE_DATE","VIN","FUEL_TYPE","LICENSE_ISSUING_AUTHORITY","LICENSE_VALID_PERIOD_FROM","LICENSE_VALID_PERIOD_END","ANNUAL_REVIEW_VALID_PERIOD_S","ANNUAL_REVIEW_VALID_PERIOD_END"};//导出map中的key
        String gzb = "终端未安装查询导出";//导出sheet名和导出的文件名
        String msg = servicePlatformUsageService.getTerminalInstalled(plateNumber,stime,etime,region);
        System.out.println(msg);
        List<Map<String, Object>> list = downloadAct.strlist(msg);
        downloadAct.download(request,response,a,b,gzb,list);
        return null;
    }

    //安装情况统计
    @RequestMapping("/getInstallationStatistics")
    @ResponseBody
    public String getInstallationStatistics(HttpServletRequest request) throws UnsupportedEncodingException {
        String companyName = request.getParameter("companyName");
        return servicePlatformUsageService.getInstallationStatistics(companyName);
    }

    //安装情况月度分析图表
    @RequestMapping("/getMonthInstallAnalysis")
    @ResponseBody
    public String getMonthInstallAnalysis(String stime,String etime){
        return servicePlatformUsageService.getMonthInstallAnalysis(stime,etime);
    }
}
