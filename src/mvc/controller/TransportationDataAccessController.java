package mvc.controller;

import mvc.service.TransportationDataAccessService;
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
 * At 2019/3/11 14:50
 */
//运政数据接入
@Controller
@RequestMapping("/transportationDataAccess")
public class TransportationDataAccessController {

    @Autowired
    private TransportationDataAccessService transportationDataAccessService;
    private DownloadAct downloadAct = new DownloadAct();

    //车辆信息
    @RequestMapping("/getVehicleInformation")
    @ResponseBody
    public String getVehicleInformation(HttpServletRequest request) throws UnsupportedEncodingException {
        String vehiNo = request.getParameter("vehiNo");
        String companyName = request.getParameter("companyName");
        String region = request.getParameter("region");
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        return transportationDataAccessService.getVehicleInformation(vehiNo,companyName,region,currentPage,pageSize);
    }

    //导出运政车辆信息
    @RequestMapping("/getVehicleInformationExcel")
    @ResponseBody
    public String getVehicleInformationExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String currentPage = "1";
        String pageSize = "100000";
        String vehiNo = request.getParameter("vehiNo");
        String companyName = request.getParameter("companyName");
        String region = request.getParameter("region");
        String a[] = {"车牌号码","车辆类型","车辆品牌","公司名称","经营许可证","道路运输证","核发日期","有效日期","经营范围","状态","车身颜色","行政区划","证照是否过期","燃料类型","排放标准"};//导出列明
        String b[] = {"PLATE_NUMBER","VEHICLE_TYPE_NAME","BRAND","COMPANY_NAME","COMPANY_LICENSE_NUMBER","LICENSE_NUMBER","HFRQ","YXRQ","BUSINESS_SCOPE_NAME","STATUS_NAME","COLOR","AREA_NAME","IS_EXPIRED","FUEL_NAME","EMISSION_STANDARD_NAME"};//导出map中的key
        String gzb = "运政车辆信息";//导出sheet名和导出的文件名
        String msg = transportationDataAccessService.getVehicleInformation(vehiNo,companyName,region,currentPage,pageSize);
        List<Map<String, Object>> list = DownloadAct.str2list(msg);
        downloadAct.download(request,response,a,b,gzb,list);
        return null;

    }

    //驾驶员信息
    @RequestMapping("/getDriverInformation")
    @ResponseBody
    public String getDriverInformation(HttpServletRequest request) throws UnsupportedEncodingException {
        String vehiNo = request.getParameter("vehiNo");
        String name = request.getParameter("name");
        String idNumber = request.getParameter("idNumber");
        String areaName = request.getParameter("areaName");
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        return transportationDataAccessService.getDriverInformation(vehiNo,name,idNumber,areaName,currentPage,pageSize);
    }

    //导出驾驶员信息
    @RequestMapping("/getDriverInformationExcel")
    @ResponseBody
    public String getDriverInformationExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String currentPage = "1";
        String pageSize = "100000";
        String vehiNo = request.getParameter("vehiNo");
        String name = request.getParameter("name");
        String idNumber = request.getParameter("idNumber");
        String areaName = request.getParameter("areaName");
        String a[] = {"身份证号","姓名","公司名称","营运许可证号","服务证号","车牌号码","资格证有效期止","分值","证照状态"};//导出列明
        String b[] = {"CERTIFICATE_NUMBER","NAME","COMPANY_NAME","COMPANY_LICENSE_NUMBER","SERVER_CARD_NUM","PLATE_NUMBER","ZGZYXQZ","ASSESS_SCORE","STATUS_NAME"};//导出map中的key
        String gzb = "运政驾驶员信息";//导出sheet名和导出的文件名
        String msg = transportationDataAccessService.getDriverInformation(vehiNo,name,idNumber,areaName,currentPage,pageSize);
        List<Map<String, Object>> list = DownloadAct.str2list(msg);
        downloadAct.download(request,response,a,b,gzb,list);
        return null;
    }

    //公司信息
    @RequestMapping("/getCompanyInformation")
    @ResponseBody
    public String getCompanyInformation(HttpServletRequest request) throws UnsupportedEncodingException {
        String companyName = request.getParameter("companyName");
        String type = request.getParameter("type");
        String region = request.getParameter("region");
        String minNum = request.getParameter("minNum");
        String maxNum = request.getParameter("maxNum");
        return transportationDataAccessService.getCompanyInformation(companyName,type,region,minNum,maxNum);
    }

    //导出公司信息
    @RequestMapping("/getCompanyInformationExcel")
    @ResponseBody
    public String getCompanyInformationExcel(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String companyName = request.getParameter("companyName");
        String type = request.getParameter("type");
        String region = request.getParameter("region");
        String minNum = request.getParameter("minNum");
        String maxNum = request.getParameter("maxNum");

        String a[] = {"公司名称","规模","区域","性质","负责人","经营许可证号","联系方式","许可证起","许可证止","发放日期","经营范围","经营状态"};
        String b[] = {"NAME","VEHICLE_SUM","AREA_NAME","ECONOMIC_NAME","RESPONSIBLE_PERSON","LICENSE_NUMBER","RESPONSIBLE_PERSON_PHONE","LICENSE_VALID_PERIOD_FROM","LICENSE_VALID_PERIOD_END","LICENSE_ISSUING_DATE","BUSINESS_SCOPE_NAME","BUSINESS_STATUS_NAME"};
        String gzb = "运政公司信息";
        String msg = transportationDataAccessService.getCompanyInformation(companyName,type,region,minNum,maxNum);
        List<Map<String, Object>> list = DownloadAct.strlist(msg);
        downloadAct.download(request,response,a,b,gzb,list);
        return null;
    }

    //交班信息
    @RequestMapping("/getHandoverInfo")
    @ResponseBody
    public String getHandoverInfo(HttpServletRequest request) throws UnsupportedEncodingException {
        String vehicle = request.getParameter("vehicle");
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        return transportationDataAccessService.getHandoverInfo(vehicle,currentPage,pageSize);
    }

    //导出交班信息
    @RequestMapping("/getHandoverInfoExcel")
    @ResponseBody
    public String getHandoverInfoExcel(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String currentPage = "1";
        String pageSize = "100000";
        String vehicle = request.getParameter("vehicle");
        String a[] = {"车牌号码","公司名称","服务资格证号","交班时间","方向","地点"};
        String b[] = {"AUTO_NUM","COM_NAME","LICENSE_NUMBER","HANDOVER_TIME","HANDOVERDIR","HANDOVERADDR"};
        String gzb = "运政交班信息";
        String msg = transportationDataAccessService.getHandoverInfo(vehicle,currentPage,pageSize);
        List<Map<String, Object>> list = DownloadAct.str2list(msg);
        downloadAct.download(request,response,a,b,gzb,list);
        return null;
    }

    //服务质量平台
    @RequestMapping("/getServiceQualityPlatform")
    @ResponseBody
    public String getServiceQualityPlatform(HttpServletRequest request) throws UnsupportedEncodingException {
        String companyName = request.getParameter("companyName");
        String grade = request.getParameter("grade");
        String year = request.getParameter("year");
        return transportationDataAccessService.getServiceQualityPlatform(companyName,grade,year);
    }

    //导出服务质量平台
    @RequestMapping("/getServiceQualityPlatformExcel")
    @ResponseBody
    public String getServiceQualityPlatformExcel(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String companyName = request.getParameter("companyName");
        String grade = request.getParameter("grade");
        String year = request.getParameter("year");
        String a[] = {"公司名称","年度","信誉等级"};
        String b[] = {"YHMC","SJ","XYDJ"};
        String gzb = "运政服务质量平台";
        String msg = transportationDataAccessService.getServiceQualityPlatform(companyName,grade,year);
        List<Map<String, Object>> list = DownloadAct.strlist(msg);
        downloadAct.download(request,response,a,b,gzb,list);
        return null;
    }

}
