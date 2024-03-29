package mvc.service.impl;

import mvc.service.PowerSchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import util.JacksonUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by donghuibin on 2019-03-04
 * At 09:55
 */

@Service
public class PowerSchedulingServiceImpl implements PowerSchedulingService {

	@Autowired
	protected JdbcTemplate jdbcTemplate;
	@Autowired
	protected JdbcTemplate jdbcTemplate2;

	private JacksonUtil jacksonUtil = JacksonUtil.buildNormalBinder();
	@Override
	public String query(String username, String disptype, String stime, String etime) {
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		String sql1="select distinct to_char(t.disp_time,'yyyy-mm-dd hh24:mi:ss') sendtime,to_char(t.vehi_count) nums,t.content,o.full_name username,'场站扬招' disptype,'' cars " +
				" from tb_operator o " +
				" left join tb_dispatch_station t on t.mobile=o.mobile " +
				" left join tb_user u on o.username = u.user_name" +
				" where t.disp_time>=to_date('"+stime+"','yyyy-mm-dd hh24:mi:ss') " +
				" and t.disp_time<=to_date('"+etime+"','yyyy-mm-dd hh24:mi:ss') " +
				" and o.full_name like '%"+username+"%' " +
				" and t.mobile is not null and u.user_name is not null ";
		String sql2="select distinct to_char(db_time,'yyyy-mm-dd hh24:mi:ss') sendtime,numbers nums,msg content,user_account username,'手持监控' disptype, target cars " +
				" from TB_ISSUED@TAXILINK105 i" +
				" left join tb_user u on i.user_account=u.user_name" +
				" where db_time>=to_date('"+stime+"','yyyy-mm-dd hh24:mi:ss') " +
				" and db_time<=to_date('"+etime+"','yyyy-mm-dd hh24:mi:ss') " +
				" and user_account like '%"+username+"%' and u.user_name is not null ";
		if("1".equals(disptype)){
			result=jdbcTemplate2.queryForList(sql1+"order by sendtime");
		}else if("2".equals(disptype)){
			result=jdbcTemplate2.queryForList(sql2+"order by sendtime");
		}else if("0".equals(disptype)){
			result=jdbcTemplate2.queryForList(sql1+" UNION "+sql2+"order by sendtime");
		}
		return jacksonUtil.toJson(result);
	}

	@Override
	public String count(String username, String disptype, String stime, String etime) {
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		String sql1="select sum(t.vehi_count) nums,count(*) ts,o.full_name username,'场站扬招' disptype " +
				" from tb_operator o " +
				" left join tb_dispatch_station t on t.mobile=o.mobile " +
				" left join tb_user u on o.username = u.user_name" +
				" where t.disp_time>=to_date('"+stime+"','yyyy-mm-dd hh24:mi:ss') " +
				" and t.disp_time<=to_date('"+etime+"','yyyy-mm-dd hh24:mi:ss') " +
				" and o.full_name like '%"+username+"%'" +
				" and t.mobile is not null and u.user_name is not null " +
				" group by o.full_name";
		String sql2="select sum(numbers) nums,count(*) ts,user_account username,'手持监控' disptype " +
				" from TB_ISSUED@TAXILINK105 i" +
				" left join tb_user u on i.user_account=u.user_name" +
				" where db_time>=to_date('"+stime+"','yyyy-mm-dd hh24:mi:ss') " +
				" and db_time<=to_date('"+etime+"','yyyy-mm-dd hh24:mi:ss') " +
				" and user_account like '%"+username+"%' " +
				" and u.user_name is not null " +
				" group by user_account";
		if("1".equals(disptype)){
			result=jdbcTemplate2.queryForList(sql1);
		}else if("2".equals(disptype)){
			result=jdbcTemplate2.queryForList(sql2);
		}else if("0".equals(disptype)){
			result=jdbcTemplate2.queryForList(sql1+" UNION "+sql2);
		}
		return jacksonUtil.toJson(result);
	}
}
