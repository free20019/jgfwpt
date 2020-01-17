package mvc.service.impl;

import mvc.service.EnterpriseLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import util.JacksonUtil;

/**
 * Created by xiaxing
 * At 2019/2/15 17:06
 */
@Service
public class EnterpriseLetterServiceImpl implements EnterpriseLetterService {
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    private JacksonUtil jacksonUtil = JacksonUtil.buildNormalBinder();

    @Override
    public String getReportingStopInformation() {
        String sql = "select * from 暂时没表";

        return jacksonUtil.toJson(jdbcTemplate.queryForList(sql));
    }

    @Override
    public String getStopVehicleStatistics() {
        return null;
    }
}
