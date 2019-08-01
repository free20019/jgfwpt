package mvc.service.impl;

import mvc.service.MaintenanceManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import util.JacksonUtil;

import java.util.*;
/**
 * @author: xianlehuang
 * @Description:
 * @date: 2019/02/22
 */
@Service("maintenancemanageService")
public class MaintenanceManageServiceImpl implements MaintenanceManageService {
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    private Map<String, Object> map;

    private JacksonUtil jacksonUtil = JacksonUtil.buildNormalBinder();


    @Override
    public String qualityreport(String companyName, String stime, String etime) {
        String tj1="";
        String tj2="";
        if(companyName!=null&&!companyName.isEmpty()&&!companyName.equals("null")&&companyName.length()>0){
            tj1 +=" and v.COMP_NAME='"+companyName+"'";
        }
        if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0){
            tj1 +=" and r.RR_TIME >=to_date('"+stime+"','yyyy-MM-dd hh24:mi:ss')";
            tj2 +=" and r.RR_TIME >=to_date('"+stime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0){
            tj1 +=" and r.RR_TIME <=to_date('"+etime+"','yyyy-MM-dd hh24:mi:ss')";
            tj2 +=" and r.RR_TIME <=to_date('"+etime+"','yyyy-MM-dd hh24:mi:ss')";
        }
//        String sql = " select COMP_NAME,count(VEHICLE_NO) wxcls,nvl(sum(my),0) my,nvl(sum(jbmy),0) jbmy,nvl(sum(bmy),0) bmy,CONCAT(ROUND(nvl(sum(my),0)*100/nvl(nullif((sum(my)+sum(jbmy)+sum(bmy)),0),1),2),'%') myzb" +
//                " from (select distinct v.COMP_NAME,r.VEHI_NO VEHICLE_NO,pj.* from tb_repair_record@db69 r" +
//                " left join (SELECT distinct VEHI_NO,VEHI_NUM,COMP_NAME,VEHI_SIM,HOME_TEL,NIGHT_TEL,OWN_NAME,MT_NAME,MDT_SUB_TYPE from VW_VEHICLE@db69) v on v.VEHI_NO=r.VEHI_NO " +
//                " left join (select r.VEHI_NO, count(case pj.hfjg when '满意' then 1 end) as my, count(case pj.hfjg when '基本满意' then 1 end) as jbmy, count(case pj.hfjg when '不满意' then 1 end) as bmy" +
//                " from TB_REPAIR_PHONE@db69 pj,tb_repair_record@db69 r  where r.rr_id = pj.rr_id";
//        sql +=tj2;
//        sql+= " group by r.VEHI_NO) pj on r.VEHI_NO = pj.VEHI_NO where v.COMP_NAME <> ' '";
//        sql += tj1;
//        sql +=") t group by t.COMP_NAME";
        String sql = " select COMP_NAME,count(VEHI_NO) wxcls,nvl(sum(my),0) my,nvl(sum(jbmy),0) jbmy,nvl(sum(bmy),0) bmy,CONCAT(ROUND(nvl(sum(my),0)*100/nvl(nullif((sum(my)+sum(jbmy)+sum(bmy)),0),1),2),'%') myzb" +
                " from (select distinct v.COMP_NAME,r.VEHI_NO,r.rr_id id,pj.* from tb_repair_record@db69 r" +
                " left join (SELECT distinct VEHI_NO,VEHI_NUM,COMP_NAME,VEHI_SIM,HOME_TEL,NIGHT_TEL,OWN_NAME,MT_NAME,MDT_SUB_TYPE from VW_VEHICLE@db69) v on v.VEHI_NO=r.VEHI_NO " +
                " left join (select pj.rr_id, count(case pj.hfjg when '满意' then 1 end) as my, count(case pj.hfjg when '基本满意' then 1 end) as jbmy, count(case pj.hfjg when '不满意' then 1 end) as bmy" +
                " from TB_REPAIR_PHONE@db69 pj  group by  pj.rr_id) pj on r.rr_id = pj.rr_id where v.COMP_NAME <> ' '" +
                " and r.rt_id is not null ";//和维修管理系统保持一致
        sql += tj1;
        sql +=") t group by t.COMP_NAME";
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        return jacksonUtil.toJson(list);
    }

    @Override
    public String qualityreportechart(String companyName, String stime, String etime) {
        String tj="";
        if(companyName!=null&&!companyName.isEmpty()&&!companyName.equals("null")&&companyName.length()>0){
            tj +=" and v.COMP_NAME='"+companyName+"'";
        }
        if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0){
            tj +=" and r.RR_TIME >=to_date('"+stime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0){
            tj +=" and r.RR_TIME <=to_date('"+etime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        String sql = "select to_char(r.RR_TIME, 'yyyy-MM-dd') time,count(r.vehi_no) wxcls, count(case pj.hfjg when '满意' then 1 end) as my," +
                " count(case pj.hfjg when '基本满意' then 1 end) as jbmy, count(case pj.hfjg when '不满意' then 1 end) as bmy" +
                " from TB_REPAIR_PHONE@db69 pj, tb_repair_record@db69 r,VW_VEHICLE@db69 v" +
                " where r.rr_id = pj.rr_id and r.vehi_no=v.vehi_no and v.COMP_NAME <> ' '"+
                " and r.rt_id is not null ";//和维修管理系统保持一致
        sql +=tj;
        sql+= " group by to_char(r.RR_TIME, 'yyyy-MM-dd') order by to_char(r.RR_TIME, 'yyyy-MM-dd')";
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        return jacksonUtil.toJson(list);
    }

    @Override
    public String recordinquiry(String vehicle, String companyName, String area, String stime, String etime, Integer currentPage, Integer pageSize) {
        String tj="";
        if(vehicle!=null&&!vehicle.isEmpty()&&!vehicle.equals("null")&&vehicle.length()>0){
            tj +=" and r.VEHI_NO='"+vehicle+"'";
        }
        if(companyName!=null&&!companyName.isEmpty()&&!companyName.equals("null")&&companyName.length()>0){
            tj +=" and v.COMP_NAME='"+companyName+"'";
        }
        if(area!=null&&!area.isEmpty()&&!area.equals("null")&&area.length()>0){
            if(area.equals("主城区")){
                tj += " and (g.AREA_NAME like '%上城%' or g.AREA_NAME like '%下城%' "
                        + "or g.AREA_NAME like '%江干%' or g.AREA_NAME like '%拱墅%' "
                        + "or g.AREA_NAME like '%下沙%' "
                        + "or g.AREA_NAME like '%西湖%' or g.AREA_NAME like '%滨江%')";
            } else {
                tj += " and g.AREA_NAME like '%"+area+"%'";
            }
        }
        if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0){
            tj +=" and r.RR_TIME >=to_date('"+stime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0){
            tj +=" and r.RR_TIME <=to_date('"+etime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        String sql = "select (select count(*) from tb_repair_record@db69 r" +
                " left join (SELECT distinct VEHI_NO VEHICLE_NO,VEHI_NUM,COMP_NAME,VEHI_SIM,HOME_TEL,NIGHT_TEL,OWN_NAME,MT_NAME,MDT_SUB_TYPE from VW_VEHICLE@db69) v on v.VEHICLE_NO=r.VEHI_NO" +
                " left join TB_REPAIR_MALFUNCTION rm on r.rm_id=rm.rm_id " +
                " left join tb_user@db69 us on r.user_id=us.user_id " +
                " left join (select pj.*,us.user_name from TB_REPAIR_PHONE@db69 pj,(select user_id,user_name from tb_user@db69 union all select user_id,user_name from tb_user_wx@db69) us where pj.hfr=us.user_id) pj on r.rr_id=pj.rr_id " +
                " left join TB_REPAIR_TYPE rt on r.rt_id=rt.rt_id " +
                " left join TB_REPAIR_ADDR ra on r.ra_id=ra.ra_id  " +
                " left join  (select plate_number,area_name from tb_global_vehicle where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on r.vehi_no=g.plate_number " +
                " where r.VEHI_NO <> ' '"+
                " and r.rt_id is not null ";//和维修管理系统保持一致
        ;
        sql += tj;
        sql += " ) count,tt.* from (select t.*,rownum as rn from(select v.*,r.*,rm.RM_MALFUNCTION GZLX, us.REAL_NAME,us.USER_NAME wxry,pj.hfjg,pj.hfr,pj.jfyy,pj.user_name ghao,rt.RT_TYPE,ra.RA_ADDR," +
                "to_char(r.RR_TIME,'yyyy-MM-dd hh24:mi:ss') STIME,to_char(r.RR_TIME_END,'yyyy-MM-dd hh24:mi:ss') ETIME,case when r.RR_TIME_END>SYSDATE then '正在维修' else '已维修' end wxjd,g.area_name" +
                " from tb_repair_record@db69 r" +
                " left join (SELECT distinct VEHI_NO VEHICLE_NO,VEHI_NUM,COMP_NAME,VEHI_SIM,HOME_TEL,NIGHT_TEL,OWN_NAME,MT_NAME,MDT_SUB_TYPE from VW_VEHICLE@db69) v on v.VEHICLE_NO=r.VEHI_NO" +
                " left join TB_REPAIR_MALFUNCTION rm on r.rm_id=rm.rm_id " +
                " left join tb_user@db69 us on r.user_id=us.user_id " +
                " left join (select pj.*,us.user_name from TB_REPAIR_PHONE@db69 pj,(select user_id,user_name from tb_user@db69 union all select user_id,user_name from tb_user_wx@db69) us where pj.hfr=us.user_id) pj on r.rr_id=pj.rr_id " +
                " left join TB_REPAIR_TYPE rt on r.rt_id=rt.rt_id " +
                " left join TB_REPAIR_ADDR ra on r.ra_id=ra.ra_id  " +
                " left join  (select plate_number,area_name from tb_global_vehicle where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on r.vehi_no=g.plate_number " +
                " where r.VEHI_NO <> ' '"+
                " and r.rt_id is not null ";//和维修管理系统保持一致
        sql += tj;
        sql += " order by r.RR_TIME desc) t where rownum <= "+(currentPage*pageSize);
        sql += ")tt where tt.rn >"+((currentPage-1)*pageSize);
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        map = new HashMap ();
        int count = 0;
        if( list!=null && list.size() >0){
            count = Integer.parseInt(String.valueOf(list.get(0).get("COUNT")));
        }
        map.put("count", count);
        map.put("datas",list);
        return jacksonUtil.toJson(map);    }

    @Override
    public Integer evaluate(String id, String jobNum, String satisfaction, String remarks) {
        String sql = " insert into TB_REPAIR_PHONE@db69 values ('"+UUID.randomUUID()+
                "','"+id+"','"+satisfaction+"','"+remarks+"','"+jobNum+"',sysdate,'')";
        int count = jdbcTemplate.update(sql);
        return count;
    }

    @Override
    public String recordstatistics(String vehicle, String companyName, String area, String stime, String etime) {
        String tj="";
        if(vehicle!=null&&!vehicle.isEmpty()&&!vehicle.equals("null")&&vehicle.length()>0){
            tj +=" and r.VEHI_NO='"+vehicle+"'";
        }

        if(companyName!=null&&!companyName.isEmpty()&&!companyName.equals("null")&&companyName.length()>0){
            tj +=" and v.COMP_NAME='"+companyName+"'";
        }

        if(area!=null&&!area.isEmpty()&&!area.equals("null")&&area.length()>0){
            if(area.equals("主城区")){
                tj += " and (g.AREA_NAME like '%上城%' or g.AREA_NAME like '%下城%' "
                        + "or g.AREA_NAME like '%江干%' or g.AREA_NAME like '%拱墅%' "
                        + "or g.AREA_NAME like '%下沙%' "
                        + "or g.AREA_NAME like '%西湖%' or g.AREA_NAME like '%滨江%')";
            } else {
                tj += " and g.AREA_NAME like '%"+area+"%'";
            }
        }

        if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0){
            tj +=" and r.RR_TIME >=to_date('"+stime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0){
            tj +=" and r.RR_TIME <=to_date('"+etime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        String sql = " select v.COMP_NAME, g.AREA_NAME, r.VEHI_NO,count(r.VEHI_NO) count from tb_repair_record@db69 r" +
                " left join (SELECT distinct VEHI_NO,VEHI_NUM,COMP_NAME,VEHI_SIM,HOME_TEL,NIGHT_TEL,OWN_NAME,MT_NAME,MDT_SUB_TYPE from VW_VEHICLE@db69) v on v.VEHI_NO=r.VEHI_NO"+
                " left join  (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on r.VEHI_NO=g.plate_number " +
                " where r.VEHI_NO <> ' ' and r.rt_id is not null ";//和维修管理系统保持一致
        sql += tj;
        sql +=" group by r.VEHI_NO, g.AREA_NAME ,v.COMP_NAME";
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        return jacksonUtil.toJson(list);
    }
}
