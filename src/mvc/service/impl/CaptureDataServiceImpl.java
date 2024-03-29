package mvc.service.impl;

import mvc.service.CaptureDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import util.JacksonUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: xianlehuang
 * @Description:
 * @date: 2019/03/07
 */

@Service("captureDataService")
public class CaptureDataServiceImpl implements CaptureDataService {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    private Map<String, Object> map;

    private JacksonUtil jacksonUtil = JacksonUtil.buildNormalBinder();

    @Override
    public String capturedata(String vehicle, String companyName, String area, String depot, String timePeriod, String stime, String etime, String type, Integer currentPage, Integer pageSize) {
        String tj="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(timePeriod.equals("0")){
            if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0&&!stime.equals("开始时间")){
                tj += " and a.DBTIME >=to_date('"+stime+"','yyyy-MM-dd hh24:mi:ss')";
            }
            if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0&&!etime.equals("结束时间")){
                tj += " and a.DBTIME <to_date('"+etime+"','yyyy-MM-dd hh24:mi:ss')";
            }
        }else if(timePeriod.equals("1")){
            if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0&&!stime.equals("开始时间")){
                tj += " and a.DBTIME >=to_date('"+stime+" 00:00:00','yyyy-MM-dd hh24:mi:ss')";
            }
            if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0&&!etime.equals("结束时间")){
                tj += " and a.DBTIME <to_date('"+etime+" 23:59:59','yyyy-MM-dd hh24:mi:ss')";
            }
        }else{
            String[] time = timePeriod.split("~");
            if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0&&!stime.equals("开始时间")){
                tj += " and a.DBTIME >=to_date('"+stime+" "+time[0]+"','yyyy-MM-dd hh24:mi:ss')";
            }
            if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0&&!etime.equals("结束时间")){
                Calendar calendar = Calendar.getInstance();
                try {
                    calendar.setTime(sdf.parse(etime));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                calendar.add(Calendar.DATE, +1);
                Date date = calendar.getTime();
                tj += " and a.DBTIME <to_date('"+sdf.format(date)+" "+time[1]+"','yyyy-MM-dd hh24:mi:ss')";
                tj += " and (to_char(a.DBTIME,'hh24:mi:ss') >='"+time[0]+"'";
                tj += " or to_char(a.DBTIME,'hh24:mi:ss') <='"+time[1]+"')";
            }
        }
        if(vehicle!=null&&!vehicle.isEmpty()&&!vehicle.equals("null")&&vehicle.length()>0&&!vehicle.equals("车牌号码")){
            tj += " and a.VEHICLE_NO like '%"+vehicle+"%'";
        }
        if(area!=null&&!area.isEmpty()&&!area.equals("null")&&area.length()>0){
            if(area.equals("主城区")){
                tj += " and (b.AREA_NAME like '%上城%' or b.AREA_NAME like '%下城%' "
                        + "or b.AREA_NAME like '%江干%' or b.AREA_NAME like '%拱墅%' "
                        + "or b.AREA_NAME like '%下沙%' "
                        + "or b.AREA_NAME like '%西湖%' or b.AREA_NAME like '%滨江%')";
            } else {
                tj += " and b.AREA_NAME like '%"+area+"%'";
            }
        }
        if(depot!=null&&!depot.isEmpty()&&!depot.equals("null")&&depot.length()>0&&!depot.equals("场站")){
            String address="";
            for(int i=0;i<depot.split(",").length;i++){
                address += "'" + depot.split(",")[i] + "',";
            }
            address = address.substring(0, (address.length() - 1));
            tj += " and REPLACE(a.ADDRESS,CHR(13),'') in ("+address+")";
        }
        if(companyName!=null&&!companyName.isEmpty()&&!companyName.equals("null")&&companyName.length()>0&&!companyName.equals("公司")){
            if(companyName.equals("公司为空")){
                tj += " and b.COMPANY_NAME is null";
            }else if(companyName.equals("公司不为空")){
                tj += " and b.COMPANY_NAME is not null";
            }else{
                tj += " and b.COMPANY_NAME = '"+companyName+"'";
            }
        }
        String checked="";
        if(type.equals("0")){
            checked=" GROUP BY DBTIME,VEHICLE_NO,COMPANY_NAME,ADDRESS,AREA_NAME ";
        }else {
            checked=" GROUP BY to_char(DBTIME,'yyyy-MM-dd hh24'),trunc(to_char(DBTIME, 'mi')/"+type+"),VEHICLE_NO,COMPANY_NAME,ADDRESS,AREA_NAME ";
        }
        String sql = "select (select count(*) from (select a.VEHICLE_NO, a.ADDRESS, b.COMPANY_NAME,to_char(max(a.DBTIME),'yyyy-MM-dd hh24:mi:ss') DBTIME,b.AREA_NAME from  tb_vehicle_hk  a"
                + " left join (select * from tb_global_vehicle where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') b on a.VEHICLE_NO=b.plate_number";
        sql += " where a.ADDRESS <> ' '";
        sql += tj;
        sql += checked;
        sql += ") m ) as COUNT,tt.* from (select t.*,rownum rn from (select a.VEHICLE_NO, a.ADDRESS, b.COMPANY_NAME,to_char(max(a.DBTIME),'yyyy-MM-dd hh24:mi:ss') DBTIME,b.AREA_NAME from  tb_vehicle_hk  a"
                + " left join (select * from tb_global_vehicle where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') b on a.VEHICLE_NO=b.plate_number";
        sql += " where a.ADDRESS <> ' '";
        sql += tj;
        sql += checked;
        sql +=" order by DBTIME desc";
        sql += " )t where rownum <= "+(currentPage*pageSize);
        sql += " ) tt where tt.rn >"+((currentPage-1)*pageSize);
        List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
        map = new HashMap ();
        int count = 0;
        if( list!=null && list.size() >0){
            count = Integer.parseInt(String.valueOf(list.get(0).get("COUNT")));
        }
        map.put("count", count);
        map.put("datas",list);
        return jacksonUtil.toJson(map);
    }

    @Override
    public String stationtraffic(String depot, String stime, String etime, String type) {
        String tj="";
        if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0&&!stime.equals("开始时间")){
            tj += " and a.DBTIME >=to_date('"+stime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0&&!etime.equals("结束时间")){
            tj += " and a.DBTIME <to_date('"+etime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        if(depot!=null&&!depot.isEmpty()&&!depot.equals("null")&&depot.length()>0&&!depot.equals("场站")){
            String address="";
            for(int i=0;i<depot.split(",").length;i++){
                address += "'" + depot.split(",")[i] + "',";
            }
            address = address.substring(0, (address.length() - 1));
            tj += " and REPLACE(a.ADDRESS,CHR(13),'') in ("+address+")";
        }
        String checked="";
        if(type.equals("0")){
            checked=" GROUP BY DBTIME,VEHICLE_NO,ADDRESS ";
        }else {
            checked=" GROUP BY to_char(DBTIME,'yyyy-MM-dd hh24'),trunc(to_char(DBTIME, 'mi')/"+type+"),VEHICLE_NO,ADDRESS ";
        }
        String sql = "select a.ADDRESS,count(a.VEHICLE_NO) count from "
                + " (select VEHICLE_NO,ADDRESS,max(DBTIME) from  tb_vehicle_hk a where ADDRESS <> ' '";
        sql += tj;
        sql += checked;
        sql +=") a group by a.ADDRESS order by a.ADDRESS";
        List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
        return jacksonUtil.toJson(list);
    }

    @Override
    public String dailytraffic(String depot, String stime, String etime, String type) {
        String tj="";
        if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0&&!stime.equals("开始时间")){
            tj += " and a.DBTIME >=to_date('"+stime+"','yyyy-MM-dd')";
        }
        if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0&&!etime.equals("结束时间")){
            tj += " and a.DBTIME <=to_date('"+etime+"','yyyy-MM-dd')";
        }
        if(depot!=null&&!depot.isEmpty()&&!depot.equals("null")&&depot.length()>0&&!depot.equals("场站")){
            String address="";
            for(int i=0;i<depot.split(",").length;i++){
                address += "'" + depot.split(",")[i] + "',";
            }
            address = address.substring(0, (address.length() - 1));
            tj += " and REPLACE(a.ADDRESS,CHR(13),'') in ("+address+")";
        }
        String checked="";
        if(type.equals("0")){
            checked=" GROUP BY DBTIME,VEHICLE_NO,ADDRESS ";
        }else {
            checked=" GROUP BY to_char(DBTIME,'yyyy-MM-dd hh24'),trunc(to_char(DBTIME, 'mi')/"+type+"),VEHICLE_NO,ADDRESS ";
        }
        String sql = "select to_char(DBTIME,'yyyy-MM-dd') TIME,count(a.VEHICLE_NO) COUNT from  "
                + " (select VEHICLE_NO,ADDRESS,max(DBTIME) DBTIME from  tb_vehicle_hk a where ADDRESS <> ' '";
        sql += tj;
        sql += checked;
        sql +=" ) a group by to_char(DBTIME,'yyyy-MM-dd') order by to_char(DBTIME,'yyyy-MM-dd') desc";
        List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
        return jacksonUtil.toJson(list);
    }

    @Override
    public String segmentedtraffic(String depot, String time, String type) {
        String tj="";
        int c=0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
        String date = null;
        if(time!=null&&!time.isEmpty()&&!time.equals("null")&&time.length()>0&&!time.equals("开始时间")){
            tj += " and to_char(DBTIME,'yyyy-MM-dd') ='"+time+"'";
        }
        if(depot!=null&&!depot.isEmpty()&&!depot.equals("null")&&depot.length()>0&&!depot.equals("场站")){
            String address="";
            for(int i=0;i<depot.split(",").length;i++){
                address += "'" + depot.split(",")[i] + "',";
            }
            address = address.substring(0, (address.length() - 1));
            tj += " and REPLACE(ADDRESS,CHR(13),'') in ("+address+")";
        }
        String checked="";
        if(type.equals("0")){
            checked=" GROUP BY DBTIME,VEHICLE_NO,ADDRESS ";
        }else {
            checked=" GROUP BY to_char(DBTIME,'yyyy-MM-dd hh24'),trunc(to_char(DBTIME, 'mi')/"+type+"),VEHICLE_NO,ADDRESS ";
        }
        String sql = "select a.ADDRESS";
        for(int i=0;i<12;i++){
            sql +=",m"+i+".c"+i+"";
        }
        sql +=  " from (select distinct ADDRESS from tb_vehicle_hk@db69 where ADDRESS <> '0'  ";
        sql += tj;
        sql +=  ") a";

        for(int i=0;i<12;i++){
            sql += " left join (select ADDRESS,count(VEHICLE_NO) as c"+i+" from"
                    + " (select VEHICLE_NO,ADDRESS,max(DBTIME) DBTIME from  tb_vehicle_hk@db69  where ADDRESS <> ' ' and trunc(to_char(DBTIME,'hh24')/2)='"+i+"'";
            sql += tj;
            sql += checked;
            sql += ") a";
            sql +=" group by ADDRESS) m"+i+" on m"+i+".ADDRESS=a.ADDRESS";
        }
        sql +=" order by ADDRESS";
        List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
        list=getCount(list);
        return jacksonUtil.toJson(list);
    }

    private List<Map<String, Object>> getCount(List<Map<String, Object>> list) {
        if( list!=null && list.size() >0){
            int C0 = 0,C1=0,C2=0,C3=0,C4=0,C5=0,C6=0,C7=0,C8=0,C9=0,C10=0,C11=0;
            for(int i=0;i<list.size();i++){
                if(list.get(i).get("C0")!=null){
                    C0 +=Integer.parseInt(String.valueOf(list.get(i).get("C0")));
                }else{
                    list.get(i).put("C0", 0);
                }
                if(list.get(i).get("C1")!=null){
                    C1 +=Integer.parseInt(String.valueOf(list.get(i).get("C1")));
                }else{
                    list.get(i).put("C1", 0);
                }
                if(list.get(i).get("C2")!=null){
                    C2 +=Integer.parseInt(String.valueOf(list.get(i).get("C2")));
                }else{
                    list.get(i).put("C2", 0);
                }
                if(list.get(i).get("C3")!=null){
                    C3 +=Integer.parseInt(String.valueOf(list.get(i).get("C3")));
                }else{
                    list.get(i).put("C3", 0);
                }
                if(list.get(i).get("C4")!=null){
                    C4 +=Integer.parseInt(String.valueOf(list.get(i).get("C4")));
                }else{
                    list.get(i).put("C4", 0);
                }
                if(list.get(i).get("C5")!=null){
                    C5 +=Integer.parseInt(String.valueOf(list.get(i).get("C5")));
                }else{
                    list.get(i).put("C5", 0);
                }
                if(list.get(i).get("C6")!=null){
                    C6 +=Integer.parseInt(String.valueOf(list.get(i).get("C6")));
                }else{
                    list.get(i).put("C6", 0);
                }
                if(list.get(i).get("C7")!=null){
                    C7 +=Integer.parseInt(String.valueOf(list.get(i).get("C7")));
                }else{
                    list.get(i).put("C7", 0);
                }
                if(list.get(i).get("C8")!=null){
                    C8 +=Integer.parseInt(String.valueOf(list.get(i).get("C8")));
                }else{
                    list.get(i).put("C8", 0);
                }
                if(list.get(i).get("C9")!=null){
                    C9 +=Integer.parseInt(String.valueOf(list.get(i).get("C9")));
                }else{
                    list.get(i).put("C9", 0);
                }
                if(list.get(i).get("C10")!=null){
                    C10 +=Integer.parseInt(String.valueOf(list.get(i).get("C10")));
                }else{
                    list.get(i).put("C10", 0);
                }
                if(list.get(i).get("C11")!=null){
                    C11 +=Integer.parseInt(String.valueOf(list.get(i).get("C11")));
                }else{
                    list.get(i).put("C11", 0);
                }
            }
            Map<String, Object> map1 = new LinkedHashMap<String, Object>();
            map1.put("ADDRESS", "总量");
            map1.put("C0", C0);
            map1.put("C1", C1);
            map1.put("C2", C2);
            map1.put("C3", C3);
            map1.put("C4", C4);
            map1.put("C5", C5);
            map1.put("C6", C6);
            map1.put("C7", C7);
            map1.put("C8", C8);
            map1.put("C9", C9);
            map1.put("C10", C10);
            map1.put("C11", C11);
            list.add(list.size(), map1);
        }
        return list;
    }
}
