package mvc.controller;

import mvc.service.EnterpriseLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xiaxing
 * At 2019/2/15 17:01
 */
//企业函件管理
@Controller
@RequestMapping("/enterpriseLetter")
public class EnterpriseLetterController {

    @Autowired
    private EnterpriseLetterService enterpriseLetterService;

    //报停管理
    @RequestMapping("/getReportingStopInformation")
    @ResponseBody
    public String getReportingStopInformation(){
        return enterpriseLetterService.getReportingStopInformation();
    }

    //报停车辆统计
    @RequestMapping("/getStopVehicleStatistics")
    @ResponseBody
    public String getStopVehicleStatistics(){
        return enterpriseLetterService.getStopVehicleStatistics();
    }

}
