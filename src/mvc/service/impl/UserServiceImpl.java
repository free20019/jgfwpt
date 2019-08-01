package mvc.service.impl;

import mvc.mapper.TbUserMapper;
import mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import util.JacksonUtil;

/**
 * Created by donghuibin on 2019-02-15
 * At 13:27
 */
@Service
public class UserServiceImpl implements UserService {
//	@Resource
//	private UserDao userDao;
	
	@Autowired
	private TbUserMapper tbUserMapper;
	
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	private JacksonUtil jacksonUtil = JacksonUtil.buildNormalBinder();

	@Override
	public String getUserById(String userId) {
//		String sql = "select * from tb_mdt_state";
//		System.out.println(sql);
//		return jacksonUtil.toJson(jdbcTemplate.queryForList(sql));
		return jacksonUtil.toJson(tbUserMapper.selectByPrimaryKey(userId));
	}
}
