package mvc.controller;

import mvc.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import util.DownloadAct;
import util.JacksonUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author: xianlehuang
 * @Description:
 * @date: 2019/03/19
 */

@Controller
@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaService areaService;
    private DownloadAct downloadAct = new DownloadAct();
    private JacksonUtil jacksonUtil = JacksonUtil.buildNormalBinder();

    //区域查询
    @RequestMapping("/findarea")
    @ResponseBody
    public String findarea(){
        return areaService.findarea();
    }

    //区域添加
    @RequestMapping("/addarea")
    @ResponseBody
    public Integer addarea(String name,String describe,String coordinates,String size){
        return areaService.addarea(name,describe,coordinates,size);
    }

    //区域添加
    @RequestMapping("/updatearea")
    @ResponseBody
    public Integer updatearea(String id,String name,String describe,String coordinates,String size){
        return areaService.updatearea(id,name,describe,coordinates,size);
    }

    //区域删除
    @RequestMapping("/deletearea")
    @ResponseBody
    public Integer deletearea(String id){
        return areaService.deletearea(id);
    }

    //回场公司查询
    @RequestMapping("/returncompany")
    @ResponseBody
    public String returnCompany(String company,String area){
        return areaService.returnCompany(company,area);
    }

    //回场公司添加
    @RequestMapping("/addreturncompany")
    @ResponseBody
    public Integer addreturncompany(String company,String area,String time){
        return areaService.addreturncompany(company,area,time);
    }

    //回场公司修改
    @RequestMapping("/updatereturncompany")
    @ResponseBody
    public Integer updatereturncompany(String id,String company,String area,String time){
        return areaService.updatereturncompany(id,company,area,time);
    }

    //回场公司删除
    @RequestMapping("/deletereturncompany")
    @ResponseBody
    public Integer deletereturncompany(String id){
        return areaService.deletereturncompany(id);
    }

    //回场车俩查询
    @RequestMapping("/returnvehicleinquiry")
    @ResponseBody
    public String returnvehicleinquiry(String vehicle, String companyName, String area, String count, String stime, String etime){
        return areaService.returnvehicleinquiry(vehicle, companyName, area, count, stime, etime);
    }

    //回场报表统计
    @RequestMapping("/reportstatistics")
    @ResponseBody
    public String reportstatistics(String companyName, String fulfill, String stime, String etime){
        return areaService.reportstatistics(companyName, fulfill, stime, etime);
    }

    //回场报表统计导出
    @RequestMapping("/reportstatisticsdc")
    @ResponseBody
    public String reportstatisticsdc(HttpServletRequest request, HttpServletResponse response, String companyName, String fulfill, String stime, String etime) throws IOException {
        String a[] = {"公司名称","车辆总数","正常回场车辆数","异常车辆数","回场完成率"};//导出列明
        String b[] = {"COMPANY_NAME","CLZS","ZCCL","YCCL","HCCGL"};//导出map中的key
        String gzb = "回场报表统计";//导出sheet名和导出的文件名
        String msg = areaService.reportstatistics(companyName, fulfill, stime, etime);
        List<Map<String, Object>> list = DownloadAct.strlist(msg);
        downloadAct.download(request,response,a,b,gzb,list);
        return null;
    }

    //未按时回场车辆查询
    @RequestMapping("/returnvehicleontime")
    @ResponseBody
    public String returnvehicleontime(String vehicle, String companyName, String area, String count, String stime, String etime){
        return areaService.returnvehicleontime(vehicle, companyName, area, count, stime, etime);
    }

    //车辆转入、转出查询
    @RequestMapping("/vehicletransfer")
    @ResponseBody
    public String vehicletransfer(String vehicle, String companyName, String area, String stime, String etime, String type, String status){
        return areaService.vehicletransfer(vehicle, companyName, area, stime, etime, type, status);
    }

    //车辆转入、转出审批
    @RequestMapping("/transferaudit")
    @ResponseBody
    public Integer transferaudit(String id,String jobNum,String reason, String issh){
        return areaService.transferaudit(id,jobNum,reason,issh);
    }

    //车牌号变更查询
    @RequestMapping("/licensechange")
    @ResponseBody
    public String licensechange(String odlVehicle, String newVehicle, String area, String stime, String etime, String type){
        return areaService.licensechange(odlVehicle, newVehicle, area, stime, etime, type);
    }

    //车牌号变更审批
    @RequestMapping("/changeaudit")
    @ResponseBody
    public Integer changeaudit(String id,String jobNum,String reason, String issh){
        return areaService.changeaudit(id,jobNum,reason,issh);
    }

    //车辆报停查询
    @RequestMapping("/vehicleparking")
    @ResponseBody
    public String vehicleparking(String vehicle, String area, String stime, String etime, String type){
        return areaService.vehicleparking(vehicle, area, stime, etime, type);
    }

    //车辆报停审批
    @RequestMapping("/parkingaudit")
    @ResponseBody
    public Integer parkingaudit(String id,String jobNum,String reason, String issh){
        return areaService.parkingaudit(id,jobNum,reason,issh);
    }

    //车辆转入、转出查询
    @RequestMapping("/dataAccess")
    @ResponseBody
    public String dataAccess(String vehicle, String companyName, String area, String stime, String etime, String type){
        return areaService.dataAccess(vehicle, companyName, area, stime, etime, type);
    }

    //车辆转入、转出审批
    @RequestMapping("/dataAccessAudit")
    @ResponseBody
    public Integer dataAccessAudit(String id,String jobNum,String reason, String issh){
        return areaService.dataAccessAudit(id,jobNum,reason,issh);
    }

    //车辆转入、转出统计
    @RequestMapping("/vehicletransferoroutstatistics")
    @ResponseBody
    public String vehicletransferoroutstatistics(String vehicle, String companyName, String area, String stime, String etime, String status, String type){
        return areaService.vehicletransferoroutstatistics(vehicle, companyName, area, stime, etime, status, type);
    }

    //车牌号变更统计
    @RequestMapping("/licensechangestatistics")
    @ResponseBody
    public String licensechangestatistics(String odlVehicle, String newVehicle, String area, String stime, String etime, String type){
        return areaService.licensechangestatistics(odlVehicle, newVehicle, area, stime, etime, type);
    }

    //车辆报停统计
    @RequestMapping("/stopstatistics")
    @ResponseBody
    public String stopstatistics(String vehicle, String companyName, String area, String stime, String etime){
        return areaService.stopstatistics(vehicle, companyName, area, stime, etime);
    }

    //爱心业务用车记录查询
    @RequestMapping("/loveApproval")
    @ResponseBody
    public String loveApproval(String vehicle, String companyName, String area, String stime, String etime, String type, String phone, String address){
        return areaService.loveApproval(vehicle, companyName, area, stime, etime, type, phone, address);
    }

    //爱心业务用车记录导出
    @RequestMapping("/loveApprovalExcel")
    @ResponseBody
    public String loveApprovalExcel(HttpServletRequest request, HttpServletResponse response, String vehicle, String companyName, String area, String stime, String etime, String type, String phone, String address) throws IOException {
        String a[] = {"生成时间","录入人员","客户姓名","手机号码","驾驶员姓名","车费金额","调度区域","详细地址","目的地址","用车时间","所派车辆","区域","司机联系方式","SIM卡","所属公司","用车模式","特殊人群","陪同情况","用车需求","附加信息","所在区域","审核时间","审核人员","审核原因","审核状态"};//导出列明
        String b[] = {"DB_TIME","COMMIT_PERSON","CUST_NAME","CUST_TEL","JSYXM","CF","DDQY","ADDRESS","DEST_ADDRESS","DISP_TIME","VEHI_NO1","AREA_NAME","SJDH1","SIM_NUM1","COMP_NAME1","YCMS","TSRQ","PTQK","YCXQ","NOTE","SZQY","AUDIT_DATE","REAL_NAME","AUDIT_REASON","AUDIT_STATUS"};//导出map中的key
        String gzb = "爱心业务用车记录";//导出sheet名和导出的文件名
        String msg = areaService.loveApproval(vehicle, companyName, area, stime, etime, type, phone, address);
        List<Map<String, Object>> list = DownloadAct.strlist(msg);
        downloadAct.download(request,response,a,b,gzb,list);
        return null;
    }

    //爱心业务用车记录审批
    @RequestMapping("/loveApprovalAudit")
    @ResponseBody
    public Integer loveApprovalAudit(String id,String jobNum,String reason, String issh){
        return areaService.loveApprovalAudit(id,jobNum,reason,issh);
    }

    //停运协查审批下拉栏
    @RequestMapping("/getThisTableField")
    @ResponseBody
    public String getThisTableField(String field){
        return areaService.getThisTableField(field);
    }

    //停运协查审批查询
    @RequestMapping("/getDecommissioningAssistanceApproval")
    @ResponseBody
    public String getDecommissioningAssistanceApproval(String vehicle, String companyName, String assist, String stime, String etime, String type){
        return areaService.getDecommissioningAssistanceApproval(vehicle, companyName, assist, stime, etime, type);
    }

    //停运协查审批
    @RequestMapping("/decommissioningAssistanceAudit")
    @ResponseBody
    public Integer decommissioningAssistanceAudit(String id,String jobNum,String reason, String issh){
        return areaService.decommissioningAssistanceAudit(id,jobNum,reason,issh);
    }

    //审批管理
    @RequestMapping("/auditManage")
    @ResponseBody
    public String auditManage(HttpServletRequest request){
        return areaService.auditManage(request);
    }
}
