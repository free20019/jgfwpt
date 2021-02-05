package mvc.controller;

import mvc.service.CommonService;
import mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by donghuibin on 2019-02-15
 * At 11:42
 */

@Controller
@RequestMapping("/common")
public class CommonController {

	@Autowired
	private UserService userService;

	@Autowired
	private CommonService commonService;

	@RequestMapping("/test")
	@ResponseBody
	public String test(String a){
		System.out.println(a);
		return a;
//		return userService.getUserById("1L");
	}

	@RequestMapping("/vehicle")
	@ResponseBody
	public String getVehicle(){
		return commonService.getVehicle();
	}

	@RequestMapping("/company")
	@ResponseBody
	public String getCompany(){
		return commonService.getCompany();
	}

	@RequestMapping("/number")
	@ResponseBody
	public String getNumber(){
		return commonService.getNumber();
	}

	@RequestMapping("/station")
	@ResponseBody
	public String getStation(){
		return commonService.getStation();
	}

	@RequestMapping("/capturecompany")
	@ResponseBody
	public String getCaptureCompany(){
		return commonService.getCaptureCompany();
	}

	@RequestMapping("/area")
	@ResponseBody
	public String getArea(){
		return commonService.getArea();
	}

	@RequestMapping(value = "/pic")
	public void pic(HttpServletRequest request, HttpServletResponse response,
					@RequestParam("key") String key) {
		commonService.getFile(request, response, key);
	}

	@RequestMapping(value = "/download")
	public void download(HttpServletRequest request, HttpServletResponse response,
					@RequestParam("key") String key) throws Exception {
		commonService.downLoad(request, response, key);
	}

	@RequestMapping("/allcompany")
	@ResponseBody
	public String getAllCompany(){
		return commonService.getAllCompany();
	}

	@RequestMapping("/keyarea")
	@ResponseBody
	public String getKeyArea(){
		return commonService.getKeyArea();
	}

	@RequestMapping("/getIllegalTypeOrPoint")
	@ResponseBody
	public String getIllegalTypeOrPoint(@RequestParam("field") String field, @RequestParam("table") String table){
		return commonService.getIllegalTypeOrPoint(field, table);
	}
}
