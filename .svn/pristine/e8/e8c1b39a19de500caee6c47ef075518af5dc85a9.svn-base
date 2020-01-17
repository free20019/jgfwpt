package mvc.controller;

import mvc.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import util.DownloadAct;
import util.JacksonUtil;

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
    public String reportstatistics(String companyName, String fulfill){
        return areaService.reportstatistics(companyName, fulfill);
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

}
