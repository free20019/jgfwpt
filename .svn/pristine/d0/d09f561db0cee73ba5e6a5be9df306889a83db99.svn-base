package mvc.service.impl;

import mvc.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import util.JacksonUtil;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by donghuibin on 2019-02-15
 * At 13:27
 */
@Service("commonService")
public class CommonServiceImpl implements CommonService {
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	private JacksonUtil jacksonUtil = JacksonUtil.buildNormalBinder();

	@Override
	public String getVehicle() {
//		String sql = "select distinct vehi_no vehicle_no from TB_VEHICLE where vehi_no <>' ' order by vehi_no";
		String sql = "select distinct PLATE_NUMBER vehicle_no from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%' order by PLATE_NUMBER";
		return jacksonUtil.toJson(jdbcTemplate.queryForList(sql));
	}

    @Override
    public String getCompany() {
//		String sql = "select distinct comp_name from TB_COMPANY where comp_name <>' '";
		String sql = "select distinct company_name comp_name from tb_global_vehicle where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%' AND company_name <>' ' order by company_name";
		return jacksonUtil.toJson(jdbcTemplate.queryForList(sql));
    }

	@Override
	public String getNumber() {
//		String sql = "select distinct user_id,real_name,user_name from tb_user_wx u,tb_user_power p where u.note=p.id and p.power_info like '%电话回访%'";
		String sql = "select distinct user_id,real_name,user_name from tb_user where trim(translate(user_name,'0123456789',' ')) is NULL order by user_name";
		return jacksonUtil.toJson(jdbcTemplate.queryForList(sql));
	}

	@Override
	public String getStation() {
		String sql = "select distinct REPLACE(ADDRESS,CHR(13),'')  ADDRESS from tb_vehicle_hk@db69 where ADDRESS <>' ' order by REPLACE(ADDRESS,CHR(13),'')";
		return jacksonUtil.toJson(jdbcTemplate.queryForList(sql));
	}

	@Override
	public String getCaptureCompany() {
		String sql = "select distinct company_name from tb_global_vehicle where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%' AND company_name <>' ' order by company_name";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		Map<String, Object> map1=new HashMap<String, Object>();
		Map<String, Object> map2=new HashMap<String, Object>();
		map1.put("COMPANY_NAME","公司为空");
		map2.put("COMPANY_NAME","公司不为空");
		list.add(0,map1);
		list.add(1,map2);
		return jacksonUtil.toJson(list);
	}

	@Override
	public String getArea() {
		String sql = "select distinct ID,AREA_NAME from TB_UPDOWNAREA where AREA_NAME <>' ' order by AREA_NAME";
		return jacksonUtil.toJson(jdbcTemplate.queryForList(sql));
	}

	@Override
	public void getFile(HttpServletRequest request, HttpServletResponse response, String key) {
	    if("".equals(key)){
	        return ;
        }
		try {
//			if(in == null){
//				String path = "E:/hk/hk_pic/"+key;
				String path = key;
				File pf = new File(path);
				FileInputStream fin = new FileInputStream(pf);
				ServletOutputStream fout =  response.getOutputStream();
				byte bts [] = new byte[fin.available()];
                int length = 0;
				if (fin != null) {
					while ((length = fin.read(bts)) != -1) {
						fout.write(bts, 0, length);
					}
				}
				fin.close();
				fout.close();

//				URL url = new URL("http://192.168.0.102:9000/"+key);
//				InputStream ism=url.openStream();
//				ServletOutputStream fout =  response.getOutputStream();
//				byte bts [] = new byte[ism.available()];
//				ism.read(bts);
//				fout.write(bts);
//				ism.close();
//				fout.close();
//			}else {
//				ServletOutputStream fout =  response.getOutputStream();
//				byte[] content = new byte[1024];
//				int length = 0;
//				if (in != null) {
//					while ((length = in.read(content)) != -1) {
//						fout.write(content, 0, length);
//					}
//				}
//				in.close();
//				fout.close();
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void downLoad(HttpServletRequest request,  HttpServletResponse response, String key) throws Exception {
		boolean isOnLine =true;
		File f = new File(key);
		if (!f.exists()) {
			response.sendError(404, "File not found!");
			return;
		}
		BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
		byte[] buf = new byte[1024];
		int len = 0;

		response.reset(); // 非常重要
		if (isOnLine) { // 在线打开方式
			URL u = new URL("file:///" + key);
			response.setContentType(u.openConnection().getContentType());
			response.setHeader("Content-Disposition", "inline; filename=" + f.getName());
			// 文件名应该编码成UTF-8
		} else { // 纯下载方式
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment; filename=" + f.getName());
		}
		OutputStream out = response.getOutputStream();
		while ((len = br.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		br.close();
		out.close();
	}

	@Override
	public String getAllCompany() {
		String sql = "select distinct comp_name from TB_COMPANY@db69 order by comp_name";
		return jacksonUtil.toJson(jdbcTemplate.queryForList(sql));
	}

	@Override
	public String getKeyArea() {
		String sql = "select distinct area_name, area_id from tb_key_area@db69 ORDER BY NLSSORT(area_name,'NLS_SORT = SCHINESE_PINYIN_M')";
		return jacksonUtil.toJson(jdbcTemplate.queryForList(sql));
	}

	@Override
	public String getIllegalTypeOrPoint(String field, String table) {
		String sql = "select distinct "+field+" from "+table+" where "+field+" is not null ORDER BY NLSSORT("+field+",'NLS_SORT = SCHINESE_PINYIN_M')";
		return jacksonUtil.toJson(jdbcTemplate.queryForList(sql));
	}
}
