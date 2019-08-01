package mvc.controller;

import mvc.service.PowerSchedulingService;
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
 * Created by donghuibin on 2019-03-04
 * At 09:53
 */
@Controller
@RequestMapping("powerScheduling")
public class PowerSchedulingController {

	@Autowired
	private PowerSchedulingService powerSchedulingService;
	private JacksonUtil jacksonUtil = JacksonUtil.buildNormalBinder();

	/**
	 * 运力调度查询
	 * @param username
	 * @param disptype
	 * @param stime
	 * @param etime
	 * @return
	 */
	@RequestMapping(value = "query")
	@ResponseBody
	public String query(String username,String disptype,String stime,String etime){
		String result = powerSchedulingService.query(username,disptype,stime,etime);
//		try{
//			throw new Exception("有中文乱码吗");
//		}catch (Exception e){
//			e.printStackTrace();
//		}
		return result;
	}

	/**
	 * 运力调度查询导出
	 * @param request
	 * @param response
	 * @param username
	 * @param disptype
	 * @param stime
	 * @param etime
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("query_export")
	@ResponseBody
	public String query_export(HttpServletRequest request, HttpServletResponse response, String username,String disptype,String stime,String etime) throws IOException {
		String a[] = {"用户名称","下发类型","下发时间","下发车辆数量","车牌号码","下发内容"};//导出列明
		String b[] = {"USERNAME","DISPTYPE","SENDTIME","NUMS","CARS","CONTENT"};//导出map中的key
		String gzb = "运力调度查询";//导出sheet名和导出的文件名
		String msg = powerSchedulingService.query(username,disptype,stime,etime);
		List<Map<String, Object>> list = DownloadAct.strlist(msg);
		new DownloadAct().download(request,response,a,b,gzb,list);
		return null;
	}

	/**
	 * 运力调度统计
	 * @param username
	 * @param disptype
	 * @param stime
	 * @param etime
	 * @return
	 */
	@RequestMapping(value = "count")
	@ResponseBody
	public String count(String username,String disptype,String stime,String etime){
		String result = powerSchedulingService.count(username,disptype,stime,etime);
		return result;
	}

	/**
	 * 运力调度统计导出
	 * @param request
	 * @param response
	 * @param username
	 * @param disptype
	 * @param stime
	 * @param etime
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("count_export")
	@ResponseBody
	public String count_export(HttpServletRequest request, HttpServletResponse response, String username,String disptype,String stime,String etime) throws IOException {
		String a[] = {"用户名称","下发类型","下发车辆数量","下发条数"};//导出列明
		String b[] = {"USERNAME","DISPTYPE","NUMS","TS"};//导出map中的key
		String gzb = "运力调度统计";//导出sheet名和导出的文件名
		String msg = powerSchedulingService.count(username,disptype,stime,etime);
		List<Map<String, Object>> list = DownloadAct.strlist(msg);
		new DownloadAct().download(request,response,a,b,gzb,list);
		return null;
	}

}
