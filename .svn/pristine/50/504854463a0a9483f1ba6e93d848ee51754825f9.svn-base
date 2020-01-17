package mvc.controller;

import com.alibaba.fastjson.JSON;
import mvc.service.KeyAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import util.DownloadAct;
import util.JacksonUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @author: xianlehuang
 * @Description:重点区域
 * @date: 2019/9/27 - 15:04
 */
@Controller
@RequestMapping("/keyArea")
public class KeyAreaController {

    @Autowired
    private KeyAreaService keyAreaService;
    private DownloadAct downloadAct = new DownloadAct();
    private JacksonUtil jacksonUtil = JacksonUtil.buildNormalBinder();

    //区域查询
    @RequestMapping("/findarea")
    @ResponseBody
    public String findarea(){
        return keyAreaService.findarea();
    }

    //区域添加
    @RequestMapping("/addarea")
    @ResponseBody
    public Integer addarea(String name,String describe,String coordinates,String size,String warning){
        return keyAreaService.addarea(name,describe,coordinates,size,warning);
    }

    //区域添加
    @RequestMapping("/updatearea")
    @ResponseBody
    public Integer updatearea(String id,String name,String describe,String coordinates,String size,String warning){
        return keyAreaService.updatearea(id,name,describe,coordinates,size, warning);
    }

    //区域删除
    @RequestMapping("/deletearea")
    @ResponseBody
    public Integer deletearea(String id){
        return keyAreaService.deletearea(id);
    }

    //重点区域车辆数量月报表查询
    @RequestMapping("/getKeyAreasVehicleQuantityMonthlyReport")
    @ResponseBody
    public String getKeyAreasVehicleQuantityMonthlyReport(String area, String time){
        return keyAreaService.getKeyAreasVehicleQuantityMonthlyReport(area, time);
    }

    //重点区域车辆数量月报表导出
    @RequestMapping("/getKeyAreasVehicleQuantityMonthlyReportExcel")
    @ResponseBody
    public String getKeyAreasVehicleQuantityMonthlyReportExcel(HttpServletRequest request, HttpServletResponse response, String area, String time) throws IOException {

        String gzb = "重点区域车辆数量月报表";//导出sheet名和导出的文件名
        //计算一个月最大的天数
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, Integer.parseInt(time.split("-")[0])); //年
        c.set(Calendar.MONTH, Integer.parseInt(time.split("-")[1])-1); //月-1
        Integer maxDate = c.getActualMaximum(Calendar.DATE);
        String a[] = new String[maxDate+1];//导出列明
        String b[] = new String[maxDate+1];//导出map中的key
        a[0]="区域";
        b[0]="AREA_NAME";
        for(int i=1;i<=maxDate;i++){
            if (i<10){
                a[i]=time+"-0"+i;
            }else{
                a[i]=time+"-"+i;
            }
            b[i]="D"+i;
        }
        String msg = keyAreaService.getKeyAreasVehicleQuantityMonthlyReport( area, time);
        List<Map<String, Object>> list = DownloadAct.strlist(String.valueOf(JSON.parseObject(msg, Map.class).get("all")));
        downloadAct.download(request,response,a,b,gzb,list);
        return null;
    }

    //重点区域车辆数量半年报表查询
    @RequestMapping("/getKeyAreasVehicleQuantityHalfAYearReport")
    @ResponseBody
    public String getKeyAreasVehicleQuantityHalfAYearReport(String area, String time, String type){
        return keyAreaService.getKeyAreasVehicleQuantityHalfAYearReport(area, time, type);
    }

    //重点区域车辆数量半年报表导出
    @RequestMapping("/getKeyAreasVehicleQuantityHalfAYearReportExcel")
    @ResponseBody
    public String getKeyAreasVehicleQuantityHalfAYearReportExcel(HttpServletRequest request, HttpServletResponse response, String area, String time, String type) throws IOException {

        String gzb = "重点区域车辆数量半年报表";//导出sheet名和导出的文件名
        Integer math = 6;
        if(type.equals("1")||type.equals("2")){
            math = 6;
            gzb = "重点区域车辆数量半年报表";
        }else if(type.equals("0")){
            math = 12;
            gzb = "重点区域车辆数量年报表";
        }
        String a[] = new String[math+1];//导出列明
        String b[] = new String[math+1];//导出map中的key
        a[0]="区域";
        b[0]="AREA_NAME";
        if(type.equals("1")){
            for (int i = 1; i < 7; i++) {
                a[i]=time+"-0"+i;
                b[i]="D"+i;
            }
        }else if(type.equals("2")){
            for (int i = 7; i < 13; i++) {
                b[i-6]="D"+(i-6);
                if(i<10){
                    a[i-6]=time+"-0"+i;
                }else{
                    a[i-6]=time+"-"+i;
                }
            }
        }else if(type.equals("0")){
            for (int i = 1; i < 13; i++) {
                b[i]="D"+i;
                if(i<10){
                    a[i]=time+"-0"+i;
                }else{
                    a[i]=time+"-"+i;
                }
            }
        }
        String msg = keyAreaService.getKeyAreasVehicleQuantityHalfAYearReport(area, time, type);
        List<Map<String, Object>> list = DownloadAct.strlist(String.valueOf(JSON.parseObject(msg, Map.class).get("all")));
        downloadAct.download(request,response,a,b,gzb,list);
        return null;
    }

    //区域监控
    @RequestMapping("/getAreaMonitor")
    @ResponseBody
    public String getAreaMonitor(){
        String msg = keyAreaService.qyjk();
        return msg;
    }

    //疑似套牌查询
    @RequestMapping("/getDoubtfulDeck")
    @ResponseBody
    public String getDoubtfulDeck(String vehicle,String companyName,String area,String point, String stime,String etime, Integer currentPage,Integer pageSize){
        return keyAreaService.getDoubtfulDeck(vehicle, companyName, area, point, stime, etime, currentPage, pageSize);
    }

    //疑似套牌导出
    @RequestMapping("/getDoubtfulDeckExcel")
    @ResponseBody
    public String getDoubtfulDeckExcel(HttpServletRequest request,HttpServletResponse response,String vehicle, String companyName,String area,String point, String stime,String etime) throws IOException {
        String a[] = {"车牌号","所属公司","区域","抓拍时间","抓拍地点","抓拍经纬度","定位时间","定位地点","定位经纬度"};//导出列明
        String b[] = {"VEHICLE_NO","COMPANY_NAME","AREA_NAME","HK_TIME","HK_ADDRESS","ZX_POINT","SPEED_TIME","GPS_ADDRESS","GPS_POINT"};//导出map中的key
        String gzb = "疑似套牌";//导出sheet名和导出的文件名
        Integer currentPage =1,pageSize=10000000;
        String msg = keyAreaService.getDoubtfulDeck(vehicle, companyName, area, point, stime, etime, currentPage, pageSize);
        List<Map<String, Object>> list = DownloadAct.str2list(msg);
        downloadAct.download(request,response,a,b,gzb,list);
        return null;
    }

    //疑似黑车查询
    @RequestMapping("/getSuspectedBlackCar")
    @ResponseBody
    public String getSuspectedBlackCar(String vehicle,String area,String type,String point, String stime,String etime, Integer currentPage,Integer pageSize){
        return keyAreaService.getSuspectedBlackCar(vehicle, area, type, point, stime, etime, currentPage, pageSize);
    }

    //疑似黑车导出
    @RequestMapping("/getSuspectedBlackCarExcel")
    @ResponseBody
    public String getSuspectedBlackCarExcel(HttpServletRequest request,HttpServletResponse response,String vehicle,String area, String type,String point, String stime,String etime) throws IOException {
        String a[] = {"车牌号","区域","采集地点","异常类型","采集时间"};//导出列明
        String b[] = {"VEHICLE_NO","AREA_NAME","ERROR_ADDRESS","ERROR_TYPE","ERROR_TIME"};//导出map中的key
        String gzb = "疑似黑车";//导出sheet名和导出的文件名
        Integer currentPage =1,pageSize=10000000;
        String msg = keyAreaService.getSuspectedBlackCar(vehicle, area, type, point, stime, etime, currentPage, pageSize);
        List<Map<String, Object>> list = DownloadAct.str2list(msg);
        downloadAct.download(request,response,a,b,gzb,list);
        return null;
    }

    //计价器异常营运分析查询
    @RequestMapping("/getAbnormalOperationValuatorAnalysis")
    @ResponseBody
    public String getAbnormalOperationValuatorAnalysis(String vehicle,String area,String type,String point, String stime,String etime, Integer currentPage,Integer pageSize){
        return keyAreaService.getAbnormalOperationValuatorAnalysis(vehicle, area, stime, etime, currentPage, pageSize);
    }

    //计价器异常营运分析导出
    @RequestMapping("/getAbnormalOperationValuatorAnalysisExcel")
    @ResponseBody
    public String getAbnormalOperationValuatorAnalysisExcel(HttpServletRequest request,HttpServletResponse response,String vehicle,String area, String type,String point, String stime,String etime) throws IOException {
        String a[] = {"车牌号","所属公司","区域","开始时间","结束时间","计价器里程","GPS里程","计价器里程/GPS里程"};//导出列明
        String b[] = {"VHIC","COMPANY_NAME","AREA_NAME","S_TIME","E_TIME","J_MILE","S_MILE","RDONE"};//导出map中的key
        String gzb = "计价器异常营运分析";//导出sheet名和导出的文件名
        Integer currentPage =1,pageSize=10000000;
        String msg = keyAreaService.getAbnormalOperationValuatorAnalysis(vehicle, area, stime, etime, currentPage, pageSize);
        List<Map<String, Object>> list = DownloadAct.str2list(msg);
        downloadAct.download(request,response,a,b,gzb,list);
        return null;
    }

    //营运里程异常分析查询
    @RequestMapping("/getAbnormalOperatingMileageAnalysis")
    @ResponseBody
    public String getAbnormalOperatingMileageAnalysis(String time, Integer low,Integer high, String area){
        return keyAreaService.getAbnormalOperatingMileageAnalysis(time, low, high, area);
    }

    //营运里程异常分析详情查询
    @RequestMapping("/getAbnormalOperatingMileageAnalysisDetails")
    @ResponseBody
    public String getAbnormalOperatingMileageAnalysisDetails(String time, Integer low,Integer high, String area){
        return keyAreaService.getAbnormalOperatingMileageAnalysisDetails(time, low, high,area);
    }

    //营运里程异常分析导出
    @RequestMapping("/getAbnormalOperatingMileageAnalysisDetailsExcel")
    @ResponseBody
    public String getAbnormalOperatingMileageAnalysisDetailsExcel(HttpServletRequest request,HttpServletResponse response,String time, Integer low,Integer high, String area) throws IOException {
        String a[] = { "车牌","区域", "里程", "日期","总公司", "分公司"};// 导出列明
        String b[] = { "CPHM", "AREA_NAME", "S", "DAY","ZGS", "FGS"};// 导出map中的key
        String gzb = "营运里程异常分析";// 导出sheet名和导出的文件名
        if(high!=null&&high>=0){
            gzb +="("+low+"-"+high+")";
        }else{
            gzb +="("+low+"以上)";
        }
        String msg = keyAreaService.getAbnormalOperatingMileageAnalysisDetails(time, low, high, area);
        List<Map<String, Object>> list = DownloadAct.strlist(msg);
        downloadAct.download(request,response,a,b,gzb,list);
        return null;
    }

    //营运单次异常分析查询
    @RequestMapping("/getSingleOperationAnomalyAnalysis")
    @ResponseBody
    public String getSingleOperationAnomalyAnalysis(String time, Integer low,Integer high, String area){
        return keyAreaService.getSingleOperationAnomalyAnalysis(time, low, high,area);
    }

    //营运单次异常分析详情查询
    @RequestMapping("/getSingleOperationAnomalyAnalysisDetails")
    @ResponseBody
    public String getSingleOperationAnomalyAnalysisDetails(String time, Integer low,Integer high, String area){
        return keyAreaService.getSingleOperationAnomalyAnalysisDetails(time, low, high,area);
    }

    //营运单次异常分析导出
    @RequestMapping("/getSingleOperationAnomalyAnalysisDetailsExcel")
    @ResponseBody
    public String getSingleOperationAnomalyAnalysisDetailsExcel(HttpServletRequest request,HttpServletResponse response,String time, Integer low,Integer high, String area) throws IOException {
        String a[] = { "车牌","区域", "单次", "日期","总公司", "分公司"};// 导出列明
        String b[] = { "CPHM", "AREA_NAME", "C", "DAY","ZGS", "FGS"};// 导出map中的key
        String gzb = "营运单次异常分析";// 导出sheet名和导出的文件名
        if(high!=null&&high>=0){
            gzb +="("+low+"-"+high+")";
        }else{
            gzb +="("+low+"以上)";
        }
        String msg = keyAreaService.getSingleOperationAnomalyAnalysisDetails(time, low, high, area);
        List<Map<String, Object>> list = DownloadAct.strlist(msg);
        downloadAct.download(request,response,a,b,gzb,list);
        return null;
    }

    //重点车辆营运违章数据推送
    @RequestMapping("/getPushingViolationDataOfKeyVehicleOperation")
    @ResponseBody
    public String getPushingViolationDataOfKeyVehicleOperation(String lPNumber, String illegalType,String area, String stime,String etime, Integer currentPage,Integer pageSize){
        return keyAreaService.getPushingViolationDataOfKeyVehicleOperation(lPNumber, illegalType, area, stime, etime, currentPage, pageSize);
    }

    //重点车辆营运违章数据推送导出
    @RequestMapping("/getPushingViolationDataOfKeyVehicleOperationExcel")
    @ResponseBody
    public String getPushingViolationDataOfKeyVehicleOperationExcel(HttpServletRequest request,HttpServletResponse response,String lPNumber, String illegalType,String area, String stime,String etime) throws IOException {
        String a[] = {"车牌号码","公司","区域","违章类型","时间"};//导出列明
        String b[] = {"VEHICLE_NO","COMPANY_NAME","AREA_NAME","ILLEGAL_TYPE","TIME"};//导出map中的key
        String gzb = "重点车辆营运违章数据推送";//导出sheet名和导出的文件名
        Integer currentPage =1,pageSize=10000000;
        String msg = keyAreaService.getPushingViolationDataOfKeyVehicleOperation(lPNumber, illegalType, area, stime, etime, currentPage, pageSize);
        List<Map<String, Object>> list = DownloadAct.str2list(msg);
        downloadAct.download(request,response,a,b,gzb,list);
        return null;
    }
    //重点车辆营运违章数据推送审核
    @RequestMapping("/audit")
    @ResponseBody
    public Integer audit(String check_id, String vehicle, String illegal_type, String illegal_id, String result){
        return keyAreaService.audit(check_id, vehicle, illegal_type, illegal_id, result);
    }

    //数据异常工单查询
    @RequestMapping("/getDataExceptionOrder")
    @ResponseBody
    public String getDataExceptionOrder(String vehicle,String area,String stime,String etime){
        return keyAreaService.getDataExceptionOrder(vehicle,area,stime,etime);
    }
    //数据异常工单导出
    @RequestMapping("/getDataExceptionOrderExcel")
    @ResponseBody
    public String getDataExceptionOrderExcel(HttpServletRequest request,HttpServletResponse response,String vehicle,String area,String companyName,String stime,String etime) throws IOException {
//        String a[] = {"公司名称","车牌号码","区域","故障类型","故障时间","第一次催告时间","第二次催告时间","第三次催告时间","反馈时间","是否维修","维修时间","维修结果","备注"};//导出列明
//        String b[] = {"COMP_NAME","VEHICLE_NO","AREA_NAME","FAULT_TYPE","TIME","ONCE","TWICE","THIRD","FGSJ","IS_REPAIR","WXSJ","REPAIR_RESULT","DESCRIPTION"};//导出map中的key
        String a[] = {"公司名称","车牌号码","区域","违章类型","违章时间","第一次催告时间","第二次催告时间","第三次催告时间","反馈时间","备注"};//导出列明
        String b[] = {"COMPANY_NAME","VEHICLE_NO","AREA_NAME","ILLEGAL_TYPE","TIME","ONCE","TWICE","THIRD","FGSJ","DESCRIPTION"};//导出map中的key
        String gzb = "数据异常工单";//导出sheet名和导出的文件名
        String msg = keyAreaService.getDataExceptionOrder(vehicle,area,stime,etime);
        List<Map<String, Object>> list = DownloadAct.strlist(msg);
        downloadAct.download(request,response,a,b,gzb,list);
        return null;
    }
    //数据异常工单审核
    @RequestMapping("/getWorkOrderAudit")
    @ResponseBody
    public Integer getWorkOrderAudit(String id,String remarks, String check_id){
        return keyAreaService.getWorkOrderAudit(id,remarks,check_id);
    }

    //重点车辆营运违章稽查查询
    @RequestMapping("/findKeyFollowVehicle")
    @ResponseBody
    public String findKeyFollowVehicle(){
        return keyAreaService.findKeyFollowVehicle();
    }

    //导入重点车辆营运违章稽查
    @PostMapping("/upload")
    @ResponseBody
    public String upload(
            @RequestParam("file") MultipartFile file){
        String msg=keyAreaService.upload(file);
        return msg;
    }

    //重点车辆营运违章稽查添加获取移除
    @RequestMapping("/addOrDeleteKeyFollowVehicleOne")
    @ResponseBody
    public Integer addOrDeleteKeyFollowVehicleOne(String vehicle,String type, String whether){
        return keyAreaService.addOrDeleteKeyFollowVehicleOne(vehicle, type, whether);
    }

    //重点车辆营运违章稽查 全部清除
    @RequestMapping("/deleteKeyFollowVehicle")
    @ResponseBody
    public Integer deleteKeyFollowVehicle(){
        return keyAreaService.deleteKeyFollowVehicle();
    }

    //异常数据报警整改报表查询
    @RequestMapping("/getAbnormalDataAlarmRectificationReport")
    @ResponseBody
    public String getAbnormalDataAlarmRectificationReport(String vehicle, String area, Integer currentPage,Integer pageSize){
        return keyAreaService.getAbnormalDataAlarmRectificationReport(vehicle, area, currentPage, pageSize);
    }

    //异常数据报警整改报表导出
    @RequestMapping("/getAbnormalDataAlarmRectificationReportExcel")
    @ResponseBody
    public String getAbnormalDataAlarmRectificationReportExcel(HttpServletRequest request,HttpServletResponse response, String area, String vehicle) throws IOException {
        String a[] = {"车牌号码","区域","回传间隔","应传点位个数","实际上传点位个数","完整性百分比","数据缺失次数","数据缺失时长","营运时长","连续性百分比","精确点位数","非精确点位数","正确性百分比","入库时间"};//导出列明
        String b[] = {"VHIC","AREA_NAME","UP_INTER","TOTAL_POINTS","ACT_POINTS","WZ_PERCENT","LOST_TIMES","LOST_TIME","RUN_TIME","CX_PERCENT","ACCU_POINTS","NOT_ACCU_POINTS","ZQ_PERCENT","DB_TIME"};//导出map中的key
        String gzb = "异常数据报警整改报表";//导出sheet名和导出的文件名
        Integer currentPage =1,pageSize=10000000;
        String msg = keyAreaService.getAbnormalDataAlarmRectificationReport(vehicle, area, currentPage, pageSize);
        List<Map<String, Object>> list = DownloadAct.str2list(msg);
        downloadAct.download(request,response,a,b,gzb,list);
        return null;
    }

    //数据质量周报查询
    @RequestMapping("/getWeeklyDataQualityReport")
    @ResponseBody
    public String getWeeklyDataQualityReport(String stime,String etime,String area){
        return keyAreaService.getWeeklyDataQualityReport(stime, etime,area);
    }

    //数据质量周报导出
    @RequestMapping("/getWeeklyDataQualityReportExcel")
    @ResponseBody
    public String getWeeklyDataQualityReportExcel(HttpServletRequest request,HttpServletResponse response,String stime,String etime,String area) throws IOException {
        String a[] = {"时间/总计","完整性百分比","连续性百分比","正确性百分比"};//导出列明
        String b[] = {"DAY","WZ_PERCENT","CX_PERCENT","ZQ_PERCENT"};//导出map中的key
        String gzb = "数据质量周报";//导出sheet名和导出的文件名
        String msg = keyAreaService.getWeeklyDataQualityReport(stime, etime, area);
        List<Map<String, Object>> list = DownloadAct.strlist(msg);
        downloadAct.download(request,response,a,b,gzb,list);
        return null;
    }

    //数据质量月报查询
    @RequestMapping("/getMonthlyDataQualityReport")
    @ResponseBody
    public String getMonthlyDataQualityReport(String time,String area){
        return keyAreaService.getMonthlyDataQualityReport(time, area);
    }

    //数据质量月报导出
    @RequestMapping("/getMonthlyDataQualityReportExcel")
    @ResponseBody
    public String getMonthlyDataQualityReportExcel(HttpServletRequest request,HttpServletResponse response,String time,String area) throws IOException {
        String a[] = {"时间/总计","完整性百分比","连续性百分比","正确性百分比"};//导出列明
        String b[] = {"DAY","WZ_PERCENT","CX_PERCENT","ZQ_PERCENT"};//导出map中的key
        String gzb = "数据质量月报";//导出sheet名和导出的文件名
        String msg = keyAreaService.getMonthlyDataQualityReport(time, area);
        List<Map<String, Object>> list = DownloadAct.strlist(msg);
        downloadAct.download(request,response,a,b,gzb,list);
        return null;
    }

    //数据质量半年报查询
    @RequestMapping("/getSemiAnnualDataQualityReport")
    @ResponseBody
    public String getSemiAnnualDataQualityReport(String time, String type,String area){
        return keyAreaService.getSemiAnnualDataQualityReport(time, type, area);
    }

    //数据质量半年报导出
    @RequestMapping("/getSemiAnnualDataQualityReportExcel")
    @ResponseBody
    public String getSemiAnnualDataQualityReportExcel(HttpServletRequest request,HttpServletResponse response,String time, String type,String area) throws IOException {
        String a[] = {"时间/总计","完整性百分比","连续性百分比","正确性百分比"};//导出列明
        String b[] = {"DAY","WZ_PERCENT","CX_PERCENT","ZQ_PERCENT"};//导出map中的key
        String gzb = "数据质量半年报";//导出sheet名和导出的文件名
        String msg = keyAreaService.getSemiAnnualDataQualityReport(time, type, area);
        List<Map<String, Object>> list = DownloadAct.strlist(msg);
        downloadAct.download(request,response,a,b,gzb,list);
        return null;
    }

    //数据质量年报查询
    @RequestMapping("/getAnnualDataQualityReport")
    @ResponseBody
    public String getAnnualDataQualityReport(String time,String area){
        return keyAreaService.getAnnualDataQualityReport(time, area);
    }

    //数据质量年报导出
    @RequestMapping("/getAnnualDataQualityReportExcel")
    @ResponseBody
    public String getAnnualDataQualityReportExcel(HttpServletRequest request,HttpServletResponse response,String time,String area) throws IOException {
        String a[] = {"时间/总计","完整性百分比","连续性百分比","正确性百分比"};//导出列明
        String b[] = {"DAY","WZ_PERCENT","CX_PERCENT","ZQ_PERCENT"};//导出map中的key
        String gzb = "数据质量年报";//导出sheet名和导出的文件名
        String msg = keyAreaService.getAnnualDataQualityReport(time, area);
        List<Map<String, Object>> list = DownloadAct.strlist(msg);
        downloadAct.download(request,response,a,b,gzb,list);
        return null;
    }

    //异常处置过程添加处理查询
    @RequestMapping("/findAbnormalDisposalProcess")
    @ResponseBody
    public String findAbnormalDisposalProcess(HttpServletRequest request){
        return keyAreaService.findAbnormalDisposalProcess(request);
    }

    //异常处置过程添加处理添加
    @RequestMapping("/addAbnormalDisposalProcess")
    @ResponseBody
    public Integer addAbnormalDisposalProcess(HttpServletRequest request){
        return keyAreaService.addAbnormalDisposalProcess(request);
    }

    //异常处置过程添加处理添加
    @RequestMapping("/updateAbnormalDisposalProcess")
    @ResponseBody
    public Integer updateAbnormalDisposalProcess(HttpServletRequest request){
        return keyAreaService.updateAbnormalDisposalProcess(request);
    }

    //异常处置过程添加处理删除
    @RequestMapping("/deleteAbnormalDisposalProcess")
    @ResponseBody
    public Integer deleteAbnormalDisposalProcess(String id){
        return keyAreaService.deleteAbnormalDisposalProcess(id);
    }

    //异常处置过程添加处理删除
    @RequestMapping("/auditAbnormalDisposalProcess")
    @ResponseBody
    public Integer auditAbnormalDisposalProcess(String id, String status){
        return keyAreaService.auditAbnormalDisposalProcess(id, status);
    }
}
