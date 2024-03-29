package mvc.service.impl;

import mvc.service.TransportationDataAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import util.JacksonUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaxing
 * At 2019/3/11 14:57
 */
@Service
public class TransportationDataAccessImpl implements TransportationDataAccessService {
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    private JacksonUtil jacksonUtil = JacksonUtil.buildNormalBinder();

    //车辆信息
    @Override
    public String getVehicleInformation(String vehiNo, String companyName, String region, String currentPage, String pageSize) {
        String tj = "";
        if (vehiNo != null && !vehiNo.isEmpty() && !vehiNo.equals("null") && vehiNo.length() > 0) {
            tj += " and b.PLATE_NUMBER = '" + vehiNo + "'";
        }
        if (companyName != null && !companyName.isEmpty() && !companyName.equals("null") && companyName.length() > 0) {
            tj += " and b.COMPANY_NAME = '" + companyName + "'";
        }
        if (region != null && !region.isEmpty() && !region.equals("null") && region.length() > 0) {
            tj += " and b.AREA_NAME = '" + "杭州市" + region + "'";
        }

        String sql = "select (select count(*) COUNT from (select * from (select * from tb_global_vehicle where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') b where 1=1 ";
        sql += tj;
        sql += ")) as count, tt.* from (select t.*, m.*,rownum as rn from (select"
                + " b.*,to_char(LICENSE_ISSUE_DATE,'yyyy-mm-dd hh24:mi:ss') HFRQ,to_char(LICENSE_VALID_PERIOD_END,'yyyy-mm-dd hh24:mi:ss') YXRQ,to_char(ANNUAL_REVIEW_VALID_PERIOD_S,'yyyy-mm-dd hh24:mi:ss') NSYXQQ,to_char(LICENSE_VALID_PERIOD_FROM,'yyyy-mm-dd hh24:mi:ss') CCFZSJ,to_char(LICENSE_VALID_PERIOD_FROM,'yyyy-mm-dd hh24:mi:ss') YXKSSJ,to_char(LICENSE_VALID_PERIOD_END,'yyyy-mm-dd hh24:mi:ss') YXJSSJ from (select * from tb_global_vehicle where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') b where 1=1";
        sql += tj;
        sql += " ) t left join (select HOLDER,HOLDER_PHONE,HOLDER_ID,VEHICLE_PLATE_NUMBER from TB_TAXI_MANAGE_RIGHT_OUT) m on m.VEHICLE_PLATE_NUMBER=t.PLATE_NUMBER  where rownum <= " + (Integer.valueOf(currentPage) * Integer.valueOf(pageSize)) + ") tt where tt.rn > " + ((Integer.valueOf(currentPage) - 1) * Integer.valueOf(pageSize));
        sql += " order by PLATE_NUMBER";

        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        int count = 0;
        if (list != null && list.size() > 0) {
            count = Integer.parseInt(String.valueOf(list.get(0).get("COUNT")));
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("BUSINESS_SCOPE_NAME") != null) {
                String scope = list.get(i).get("BUSINESS_SCOPE_NAME").toString();
                if (scope.equals("网络预约出租汽车客运。") || scope.equals("客运：网络预约出租汽车客运。")) {
                    scope = "";
                }
                list.get(i).put("BUSINESS_SCOPE_NAME", scope);
            }
        }
        Map map = new HashMap();
        map.put("count", count);
        map.put("datas", list);
        return jacksonUtil.toJson(map);
    }

    //驾驶员信息
    @Override
    public String getDriverInformation(String vehiNo, String name, String idNumber, String areaName, String currentPage, String pageSize) {
        String tj = "";
        if (idNumber != null && !idNumber.isEmpty() && !idNumber.equals("null") && idNumber.length() > 0) {
            tj += " and b.ID_NUMBER = '" + idNumber + "'";
        }
        if (vehiNo != null && !vehiNo.isEmpty() && !vehiNo.equals("null") && vehiNo.length() > 0) {
            tj += " and ( b.PLATE_NUMBER = '" + vehiNo + "' or REPLACE(b.PLATE_NUMBER,'.','')  = '" + vehiNo + "' ) ";
        }
        if (name != null && !name.isEmpty() && !name.equals("null") && name.length() > 0) {
            tj += " and b.NAME = '" + name + "'";
        }
        if (areaName != null && !areaName.isEmpty() && !areaName.equals("null") && areaName.length() > 0 && !areaName.equals("全部区域")) {
            tj += " and b.AREA_NAME = '" + "杭州市" + areaName + "'";
        }

        String sql = "select (select count(*) COUNT from (select  id_number from (select "
                + " b.* from (select distinct gpc.*,to_char(gpc.VALID_PERIOD_END,'yyyy-mm-dd hh24:mi:ss') from" +
//                " tb_global_vehicle gv," +
                " TB_GLOBAL_PERSON_CERTIFICATE gpc" +
//                " where REPLACE(gpc.plate_number,'.','')=gv.plate_number and gv.industry=090 and gv.business_scope_code = 1400  AND gv.STATUS_NAME='营运' AND gpc.plate_number LIKE '浙A%'" +
                ") b where 1=1 and id_number is not null and (id,id_number) in (select max(id),id_number from"
                + " (select gpc.* from" +
//                " tb_global_vehicle gv," +
                " TB_GLOBAL_PERSON_CERTIFICATE gpc" +
//                " where REPLACE(gpc.plate_number,'.','')=gv.plate_number and gv.industry=090 and gv.business_scope_code = 1400  AND gv.STATUS_NAME='营运' AND gpc.plate_number LIKE '浙A%'" +
                ") group by id_number) ";
        sql += tj;
        sql += " ) t";
        sql += ")) as count, tt.* from (select t.*,ti.ASSESS_SCORE,ti.ASSESS_YEAR, rownum as rn from (select"
                + " b.* from (select distinct gpc.*,to_char ( gpc.VALID_PERIOD_END, 'yyyy-mm-dd hh24:mi:ss' ) ZGZYXQZ,to_char ( gpc.VALID_PERIOD_START, 'yyyy-mm-dd hh24:mi:ss' ) ZGZYXQQ,to_char ( gpc.SERVER_DATE_BEGIN, 'yyyy-mm-dd hh24:mi:ss' ) SGYXQQ,to_char ( gpc.SERVER_DATE_END, 'yyyy-mm-dd hh24:mi:ss' ) SGYXQZ from" +
//                " tb_global_vehicle gv," +
                " TB_GLOBAL_PERSON_CERTIFICATE gpc" +
//                " where REPLACE(gpc.plate_number,'.','')=gv.plate_number and gv.industry=090 and gv.business_scope_code = 1400  AND gv.STATUS_NAME='营运' AND gpc.plate_number LIKE '浙A%'" +
                ") b where 1=1 and id_number is not null and (id,id_number) in (select max(id),id_number from"
                + " (select gpc.* from" +
//                " tb_global_vehicle gv," +
                " TB_GLOBAL_PERSON_CERTIFICATE gpc" +
//                " where REPLACE(gpc.plate_number,'.','')=gv.plate_number and gv.industry=090 and gv.business_scope_code = 1400  AND gv.STATUS_NAME='营运' AND gpc.plate_number LIKE '浙A%'" +
                ") group by id_number) ";
        sql += tj;
        sql += " ) t left join (select distinct ti.ASSESS_SCORE,ti.ASSESS_YEAR,ti.id_number from TB_TAXI_INTEGRITY_INFO_OUT ti "
                + "where (ti.id_number,ti.ASSESS_YEAR,ASSESS_SCORE) in (select id_number,max(ti.ASSESS_YEAR),max(ti.ASSESS_SCORE) from TB_TAXI_INTEGRITY_INFO_OUT ti  group by id_number)) ti  "
                + "on ti.id_number=t.id_number "
                + "where rownum <= " + (Integer.valueOf(currentPage) * Integer.valueOf(pageSize)) + ") tt where tt.rn > " + ((Integer.valueOf(currentPage) - 1) * Integer.valueOf(pageSize));
        sql += " order by PLATE_NUMBER";

        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        int count = 0;
        if (list != null && list.size() > 0) {
            count = Integer.parseInt(String.valueOf(list.get(0).get("COUNT")));
            for (int i = 0; i < list.size(); i++) {
                list.get(i).put("PLATE_NUMBER", String.valueOf(list.get(i).get("PLATE_NUMBER")).replace(".", ""));
            }
        }
        Map map = new HashMap();
        map.put("count", count);
        map.put("datas", list);
        return jacksonUtil.toJson(map);
    }

    //公司信息
    @Override
    public String getCompanyInformation(String companyName, String type, String region, String minNum, String maxNum) {
        String sql = "select NAME,VEHICLE_SUM,replace(AREA_NAME,'杭州市','') AREA_NAME,ECONOMIC_NAME,RESPONSIBLE_PERSON,LICENSE_NUMBER,RESPONSIBLE_PERSON_PHONE,to_char(LICENSE_VALID_PERIOD_FROM,'yyyy-mm-dd hh24:mi:ss') LICENSE_VALID_PERIOD_FROM,to_char(LICENSE_VALID_PERIOD_END,'yyyy-mm-dd hh24:mi:ss') LICENSE_VALID_PERIOD_END,to_char(LICENSE_ISSUING_DATE,'yyyy-mm-dd hh24:mi:ss') LICENSE_ISSUING_DATE,BUSINESS_SCOPE_NAME,BUSINESS_STATUS_NAME from TB_GLOBAL_COMPANY where 1 = 1 ";
        if (companyName != null && !companyName.isEmpty() && companyName.length() > 0 && !companyName.equals("")) {
            sql += "and NAME = '" + companyName + "'";
        }
        if (type != null && !type.isEmpty() && type.length() > 0 && !type.equals("")) {
            sql += "and ECONOMIC_NAME = '" + type + "'";
        }
        if (region != null && !region.isEmpty() && region.length() > 0 && !region.equals("")) {
            sql += "and AREA_NAME = '" + "杭州市" + region + "'";
        }
        if (minNum != null && !minNum.isEmpty() && minNum.length() > 0 && !minNum.equals("")) {
            sql += "and VEHICLE_SUM >=" + minNum;
        }
        if (maxNum != null && !maxNum.isEmpty() && maxNum.length() > 0 && !maxNum.equals("")) {
            sql += "and VEHICLE_SUM <=" + maxNum;
        }

        System.out.println(sql);

        return jacksonUtil.toJson(jdbcTemplate.queryForList(sql));
    }

    //交班信息
    @Override
    public String getHandoverInfo(String vehicle, String currentPage, String pageSize) {
        String sqlCount = "select count(*) count from VEHICLE_HANDOVER@db69 where 1 = 1";
        String str = "select * from ( select A.*,ROWNUM RN from (";
        String sql = "select replace(AUTO_NUM,'.','') AUTO_NUM,COM_NAME,LICENSE_NUMBER,HANDOVER_TIME,HANDOVERDIR,HANDOVERADDR from VEHICLE_HANDOVER@db69 where 1 = 1 ";
        if (vehicle != null && !vehicle.isEmpty() && vehicle.length() > 0 && !vehicle.equals("")) {
            vehicle = vehicle.substring(0, 2) + "." + vehicle.substring(2, 7);

            System.out.println(vehicle);

            sql += " and AUTO_NUM = '" + vehicle + "'";
            sqlCount += " and AUTO_NUM = '" + vehicle + "'";
        }
        str += sql;
        str += ") A where ROWNUM <= " + (Integer.valueOf(currentPage) * Integer.valueOf(pageSize)) + " ) where RN >= " + ((Integer.valueOf(currentPage) - 1) * Integer.valueOf(pageSize));
        List<Map<String, Object>> list = jdbcTemplate.queryForList(str);
        List<Map<String, Object>> countList = jdbcTemplate.queryForList(sqlCount);

        int count = Integer.parseInt(String.valueOf(countList.get(0).get("COUNT")));
        Map map = new HashMap();
        map.put("count", count);
        map.put("datas", list);
        return jacksonUtil.toJson(map);
    }

    //服务质量平台
    @Override
    public String getServiceQualityPlatform(String companyName, String grade, String year) {
        String sql = "select * from SERVICEEVALUATION where 1 = 1 ";
        if (companyName != null && !companyName.isEmpty() && companyName.length() > 0 && !companyName.equals("")) {
            sql += " and YHMC = '" + companyName + "'";
        }
        if (grade != null && !grade.isEmpty() && grade.length() > 0 && !grade.equals("")) {
            sql += " and XYDJ = '" + grade + "'";
        }
        if (year != null && !year.isEmpty() && year.length() > 0 && !year.equals("")) {
            year = Integer.parseInt(year.substring(0, 4)) + 1 + "";
            sql += " and SJ = " + year + "";
        }
        return jacksonUtil.toJson(jdbcTemplate.queryForList(sql));
    }


}
