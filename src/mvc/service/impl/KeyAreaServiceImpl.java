package mvc.service.impl;

import cache.DataItem;
import cache.GisData;
import mvc.service.KeyAreaService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import util.ExcelUtil;
import util.JacksonUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author: xianlehuang
 * @Description:重点区域
 * @date: 2019/9/27 - 15:06
 */
@Service
public class KeyAreaServiceImpl implements KeyAreaService {
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    private Map<String, Object> map;

    private JacksonUtil jacksonUtil = JacksonUtil.buildNormalBinder();

    private ExcelUtil excelUtil = new ExcelUtil();

    @Override
    public String findarea() {
        String sql="select t.*, t.ALARMNUM ALARM from TB_KEY_AREA@db69 t ORDER BY NLSSORT(t.area_name,'NLS_SORT = SCHINESE_PINYIN_M')";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        if(list!=null){
            for (int i = 0; i < list.size(); i++) {
                list.get(i).put("ALARMNUM",String.valueOf(list.get(i).get("ALARMNUM")).split(";").length>=getybjnum()+1?String.valueOf(list.get(i).get("ALARMNUM")).split(";")[getybjnum()]:"0");
            }
        }
        return jacksonUtil.toJson(list);
    }

    //不同的时间段选择不同的报警数
    public int getybjnum(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String t = sdf.format(new Date());
        int a = timenum(t);
        if(a==timenum("23:58")||a==timenum("23:59")||a==timenum("00:02")||a==timenum("00:01")){
            return 0;
        }else if(a>=timenum("00:03")&&a<=timenum("00:57")){
            return 1;
        }else if(a>=timenum("00:58")&&a<=timenum("01:02")){
            return 2;
        }else if(a>=timenum("01:03")&&a<=timenum("01:57")){
            return 3;
        }else if(a>=timenum("01:58")&&a<=timenum("02:02")){
            return 4;
        }else if(a>=timenum("02:03")&&a<=timenum("02:57")){
            return 5;
        }else if(a>=timenum("02:58")&&a<=timenum("03:02")){
            return 6;
        }else if(a>=timenum("03:03")&&a<=timenum("03:57")){
            return 7;
        }else if(a>=timenum("03:58")&&a<=timenum("04:02")){
            return 8;
        }else if(a>=timenum("04:03")&&a<=timenum("04:57")){
            return 9;
        }else if(a>=timenum("04:58")&&a<=timenum("05:02")){
            return 10;
        }else if(a>=timenum("05:03")&&a<=timenum("05:57")){
            return 11;
        }else if(a>=timenum("05:58")&&a<=timenum("06:02")){
            return 12;
        }else if(a>=timenum("06:03")&&a<=timenum("06:57")){
            return 13;
        }else if(a>=timenum("06:58")&&a<=timenum("07:02")){
            return 14;
        }else if(a>=timenum("07:03")&&a<=timenum("07:57")){
            return 15;
        }else if(a>=timenum("07:58")&&a<=timenum("08:02")){
            return 16;
        }else if(a>=timenum("08:03")&&a<=timenum("08:57")){
            return 17;
        }else if(a>=timenum("08:58")&&a<=timenum("09:02")){
            return 18;
        }else if(a>=timenum("09:03")&&a<=timenum("09:57")){
            return 19;
        }else if(a>=timenum("09:58")&&a<=timenum("10:02")){
            return 20;
        }else if(a>=timenum("10:03")&&a<=timenum("10:57")){
            return 21;
        }else if(a>=timenum("10:58")&&a<=timenum("11:02")){
            return 22;
        }else if(a>=timenum("11:03")&&a<=timenum("11:57")){
            return 23;
        }else if(a>=timenum("11:58")&&a<=timenum("12:02")){
            return 24;
        }else if(a>=timenum("12:03")&&a<=timenum("12:57")){
            return 25;
        }else if(a>=timenum("12:58")&&a<=timenum("13:02")){
            return 26;
        }else if(a>=timenum("13:03")&&a<=timenum("13:57")){
            return 27;
        }else if(a>=timenum("13:58")&&a<=timenum("14:02")){
            return 28;
        }else if(a>=timenum("14:03")&&a<=timenum("14:57")){
            return 29;
        }else if(a>=timenum("14:58")&&a<=timenum("15:02")){
            return 30;
        }else if(a>=timenum("15:03")&&a<=timenum("15:57")){
            return 31;
        }else if(a>=timenum("15:58")&&a<=timenum("16:02")){
            return 32;
        }else if(a>=timenum("16:03")&&a<=timenum("16:57")){
            return 33;
        }else if(a>=timenum("16:58")&&a<=timenum("17:02")){
            return 34;
        }else if(a>=timenum("17:03")&&a<=timenum("17:57")){
            return 35;
        }else if(a>=timenum("17:58")&&a<=timenum("18:02")){
            return 36;
        }else if(a>=timenum("18:03")&&a<=timenum("18:57")){
            return 37;
        }else if(a>=timenum("18:58")&&a<=timenum("19:02")){
            return 38;
        }else if(a>=timenum("19:03")&&a<=timenum("19:57")){
            return 39;
        }else if(a>=timenum("19:58")&&a<=timenum("20:02")){
            return 40;
        }else if(a>=timenum("20:03")&&a<=timenum("20:57")){
            return 41;
        }else if(a>=timenum("20:58")&&a<=timenum("21:02")){
            return 42;
        }else if(a>=timenum("21:03")&&a<=timenum("21:57")){
            return 43;
        }else if(a>=timenum("21:58")&&a<=timenum("22:02")){
            return 44;
        }else if(a>=timenum("22:03")&&a<=timenum("22:57")){
            return 45;
        }else if(a>=timenum("22:58")&&a<=timenum("23:02")){
            return 46;
        }else if(a>=timenum("23:03")&&a<=timenum("23:57")){
            return 47;
        }else{
            return 0;
        }
    }

    //时分转为分钟数
    public int timenum(String arg){
        return Integer.parseInt(arg.split(":")[0])*60+Integer.parseInt(arg.split(":")[1]);
    }

    @Override
    public Integer addarea(String name, String describe, String coordinates, String size, String warning) {
        String cx="select * from TB_KEY_AREA@db69 where area_name='"+name+"'";
        List<Map<String, Object>> list=jdbcTemplate.queryForList(cx);
        int count=0;
        if(list.size()>0){
            count=-1;
            return count;
        }else{
            String sql="insert into TB_KEY_AREA@db69 (area_name,area_describe,area_coordinates,area_size,alarmnum)" +
                    "values ('"+name+"','"+describe+"','"+coordinates+"','"+size+"','"+warning+"')";
            count=jdbcTemplate.update(sql);
            return count;
        }
    }

    @Override
    public Integer updatearea(String id, String name, String describe, String coordinates, String size, String warning) {
        String cx="select * from TB_KEY_AREA@db69 where area_name='"+name+"' and area_id !='"+id+"'";
        List<Map<String, Object>> list=jdbcTemplate.queryForList(cx);
        int count=0;
        if(list.size()>0){
            count=-1;
            return count;
        }else{
            String sql="update TB_KEY_AREA@db69 set area_name='"+name+"',area_describe='"+describe+"'," +
                    "area_coordinates='"+coordinates+"',area_size='"+size+"' ,ALARMNUM='"+warning+"' where area_id='"+id+"'";
            count=jdbcTemplate.update(sql);
            return count;
        }
    }

    @Override
    public Integer deletearea(String id) {
        int count=0;
        String sql="delete from TB_KEY_AREA@db69 where area_id='"+id+"'";
        count=jdbcTemplate.update(sql);
        return count;
    }

    //重点区域车辆数量月报表
    @Override
    public String getKeyAreasVehicleQuantityMonthlyReport(String area, String time) {
        //查询每一天,每个区域车辆数量总数
        List<Map<String, Object>> areasList = findDays(time, area);

        //查询本月份的每一天车辆数量总数
        List<Map<String, Object>> monthList = findMonth(time, area, "总计");

        //查询上月份的每一天车辆数量总数
        List<Map<String, Object>> lastMonthList = findMonth(getTime(time, "上月"), area, "上月");

        //查询上一年的本月份的每一天车辆数量总数
        List<Map<String, Object>> lastYearMonthList = findMonth(getTime(time, "上年本月"), area, "上年本月");

        //合并
        List<Map<String, Object>> list = new ArrayList(monthList);
        list.addAll(lastMonthList);
        list.addAll(lastYearMonthList);
        //全部（导出使用）
        List<Map<String, Object>> allList = new ArrayList(areasList);
        allList.addAll(list);

        map = new HashMap();
        map.put("area",areasList);
        map.put("total",list);
        map.put("all",allList);
        return jacksonUtil.toJson(map);
    }

    //查询每一天,每个区域车辆数量
    private List<Map<String, Object>> findDays(String time, String area) {
        String tj = "";
        if(area!=null&&!area.isEmpty()&&!area.equals("null")&&area.length()>0&&!area.equals("")){
            String address="";
            for(int i=0;i<area.split(",").length;i++){
                address += "'" + area.split(",")[i] + "',";
            }
            address = address.substring(0, (address.length() - 1));
            tj += " and a.area_id in ("+address+")";
        }
        //计算一个月最大的天数
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, Integer.parseInt(time.split("-")[0])); //年
        c.set(Calendar.MONTH, Integer.parseInt(time.split("-")[1])-1); //月-1
        Integer maxDate = c.getActualMaximum(Calendar.DATE);

        String sql = "select ";
        for(int i=1;i<=maxDate;i++){
            sql += " d"+(i)+".d"+(i)+",";
        }
        sql += "a.area_id, a.area_name from (select a.area_name, a.area_id from tb_key_area@db69 a where 1=1";
        sql +=tj;
        sql += " ) a";
        for(int i=1;i<=maxDate;i++){
            int m = i;
            sql += " left join (select a.area_id,sum(area_num) d"+m+" from  tb_key_area_num@db69 a" +
                    " where to_char(a.DB_TIME,'yyyy-MM-fmdd')='"+time+"-"+m+"'";
            sql +=tj;
            sql +=" group by a.area_id ) d"+m+" on a.area_id=d"+m+".area_id";
        }
        sql +=" order by nlssort(a.area_name,'NLS_SORT=SCHINESE_PINYIN_M')";
        List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
        return list;
    }

    //查询指定月份的每一天车辆数量总数
    private List<Map<String, Object>> findMonth(String month, String area, String type) {
        String tj = "";
        if(area!=null&&!area.isEmpty()&&!area.equals("null")&&area.length()>0&&!area.equals("")){
            String address="";
            for(int i=0;i<area.split(",").length;i++){
                address += "'" + area.split(",")[i] + "',";
            }
            address = address.substring(0, (address.length() - 1));
            tj += " and a.area_id in ("+address+")";
        }
        //计算一个月最大的天数
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, Integer.parseInt(month.split("-")[0])); //年
        c.set(Calendar.MONTH, Integer.parseInt(month.split("-")[1])-1); //月-1
        Integer maxDate = c.getActualMaximum(Calendar.DATE);

        String sql = "select ";
        for(int i=1;i<=maxDate;i++){
            sql += " d"+(i)+".d"+(i)+",";
        }
        sql += " a.area_name from (select '"+type+"' area_name from dual a where 1=1";
        sql += " ) a";
        for(int i=1;i<=maxDate;i++){
            int m = i;
            sql += " left join (select sum(area_num) d"+m+" from  tb_key_area_num@db69 a" +
                    " where to_char(a.DB_TIME,'yyyy-MM-fmdd')='"+month+"-"+m+"'";
            sql +=tj;
            sql +=" ) d"+m+" on 1=1";
        }
        sql +=" order by nlssort(a.area_name,'NLS_SORT=SCHINESE_PINYIN_M')";
        List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
        return list;
    }

    //获取时间
    private String getTime(String time, String type){
        DateFormat sdf =  new SimpleDateFormat("yyyy-MM");
        Date date = null;
        try{
            date = sdf.parse(time);
        }catch(Exception e){
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        String wantDate = "";
        if(type.equals("上月")){
            c.add(Calendar.MONTH, -1);
            wantDate = sdf.format(c.getTime());
        }else if(type.equals("上年本月")){
            c.add(Calendar.YEAR, -1);
            wantDate = sdf.format(c.getTime());
        }
        return wantDate;
    }

    @Override
    public String getKeyAreasVehicleQuantityHalfAYearReport(String area, String time, String type) {

        //查询每个月,每个区域车辆数量总数
        List<Map<String, Object>> areasList = findHalfAYearAreas(time, area, type);

        //查询每个月车辆数量总数
        List<Map<String, Object>> monthList = findHalfAYearMonth(time, area, "总计", type);

        //查询上一年的本月份车辆数量总数
        List<Map<String, Object>> lastYearMonthList = findHalfAYearMonth(String.valueOf(Integer.parseInt(time)-1), area, "上年本月", type);

        //合并
        List<Map<String, Object>> list = new ArrayList(monthList);
        list.addAll(lastYearMonthList);
        //全部（导出使用）
        List<Map<String, Object>> allList = new ArrayList(areasList);
        allList.addAll(list);

        map = new HashMap();
        map.put("area",areasList);
        map.put("total",list);
        map.put("all",allList);
        return jacksonUtil.toJson(map);
    }

    //查询每个月,每个区域车辆数量总数
    private List<Map<String, Object>> findHalfAYearAreas(String time, String area, String type) {
        String tj = "";
        if(area!=null&&!area.isEmpty()&&!area.equals("null")&&area.length()>0&&!area.equals("")){
            String address="";
            for(int i=0;i<area.split(",").length;i++){
                address += "'" + area.split(",")[i] + "',";
            }
            address = address.substring(0, (address.length() - 1));
            tj += " and a.area_id in ("+address+")";
        }
        //计算上半年、下半年或一整年月份
        Integer math = 0;
        String a[] = null;
        if(type.equals("1")||type.equals("2")){
            math = 6;
            a = new String[math];
            if(type.equals("1")){
                for (int i = 1; i < 7; i++) {
                    a[i-1]=time+"-0"+i;
                }
            }else if(type.equals("2")){
                for (int i = 7; i < 13; i++) {
                    if(i<10){
                        a[i-7]=time+"-0"+i;
                    }else{
                        a[i-7]=time+"-"+i;
                    }
                }
            }
        }else if(type.equals("0")){
            math = 12;
            a = new String[math];
            for (int i = 1; i < 13; i++) {
                if(i<10){
                    a[i-1]=time+"-0"+i;
                }else{
                    a[i-1]=time+"-"+i;
                }
            }
        }
        String sql = "select ";
        for(int i=1;i<=a.length;i++){
            sql += " d"+(i)+".d"+(i)+",";
        }
        sql += "a.area_id, a.area_name from (select a.area_name, a.area_id from tb_key_area@db69 a where 1=1";
        sql +=tj;
        sql += " ) a";
        for(int i=1;i<=a.length;i++){
            int m = i;
            sql += " left join (select a.area_id,sum(area_num) d"+m+" from  tb_key_area_num@db69 a" +
                    " where to_char(a.DB_TIME,'yyyy-MM')='"+a[i-1]+"'";
            sql +=tj;
            sql +=" group by a.area_id ) d"+m+" on a.area_id=d"+m+".area_id";
        }
        sql +=" order by nlssort(a.area_name,'NLS_SORT=SCHINESE_PINYIN_M')";
        List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
        return list;
    }

    //查询指定月份车辆数量总数
    private List<Map<String, Object>> findHalfAYearMonth(String time, String area, String selectType, String type) {
        String tj = "";
        if(area!=null&&!area.isEmpty()&&!area.equals("null")&&area.length()>0&&!area.equals("")){
            String address="";
            for(int i=0;i<area.split(",").length;i++){
                address += "'" + area.split(",")[i] + "',";
            }
            address = address.substring(0, (address.length() - 1));
            tj += " and a.area_id in ("+address+")";
        }
        //计算上半年、下半年或一整年月份
        Integer math = 0;
        String a[] = null;
        if(type.equals("1")||type.equals("2")){
            math = 6;
            a = new String[math];
            if(type.equals("1")){
                for (int i = 1; i < 7; i++) {
                    a[i-1]=time+"-0"+i;
                }
            }else if(type.equals("2")){
                for (int i = 7; i < 13; i++) {
                    if(i<10){
                        a[i-7]=time+"-0"+i;
                    }else{
                        a[i-7]=time+"-"+i;
                    }
                }
            }
        }else if(type.equals("0")){
            math = 12;
            a = new String[math];
            for (int i = 1; i < 13; i++) {
                if(i<10){
                    a[i-1]=time+"-0"+i;
                }else{
                    a[i-1]=time+"-"+i;
                }
            }
        }

        String sql = "select ";
        for(int i=1;i<=a.length;i++){
            sql += " d"+(i)+".d"+(i)+",";
        }
        sql += " a.area_name from (select '"+selectType+"' area_name from dual a where 1=1";
        sql += " ) a";
        for(int i=1;i<=a.length;i++){
            int m = i;
            sql += " left join (select sum(area_num) d"+m+" from  tb_key_area_num@db69 a" +
                    " where to_char(a.DB_TIME,'yyyy-MM')='"+a[i-1]+"'";
            sql +=tj;
            sql +=" ) d"+m+" on 1=1";
        }
        sql +=" order by nlssort(a.area_name,'NLS_SORT=SCHINESE_PINYIN_M')";
        List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
        return list;
    }

    @Override
    public List<Map<String, Object>> getAreaMonitor() {
        String sql = "select * from TB_KEY_AREA@db69 t ORDER BY CASE when area_name='北京市' then 1 else  2 end";
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        if(list!=null){
            for (int i = 0; i < list.size(); i++) {
                list.get(i).put("ALARMNUM",String.valueOf(list.get(i).get("ALARMNUM")).split(";").length>=getybjnum()+1?String.valueOf(list.get(i).get("ALARMNUM")).split(";")[getybjnum()]:"0");
            }
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> getVehicleMonitor() {
        String sql = "select * from VW_VEHICLE@db69 t left join tb_mdt_status@db69 s  on t.mdt_no=s.mdt_no";
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        if(list!=null){
            for (int i = 0; i < list.size(); i++) {
                list.get(i).put("STIME",list.get(i).get("STIME")==null?"":String.valueOf(list.get(i).get("STIME")).substring(0,19));
            }
        }
        return list;
    }

    @Override
    public String qyjk() {
        DataItem data = (DataItem) GisData.map.get("data");
        if(null != data){
            Map map = new HashMap();
            map.put("vehilist", data.getVehilist());
            map.put("arealist",  data.getArealist());
            map.put("faultlist",  data.getFaultlist());
            map.put("focuslist",  data.getFocuslist());
            map.put("num",  data.getNum());
            //System.out.println(vehilist.size());
            return jacksonUtil.toJson(map);
        }
        return "{}";
    }

    @Override
    public String getDoubtfulDeck(String vehicle, String companyName, String area, String point, String stime, String etime, Integer currentPage, Integer pageSize) {
        String tj="";
        if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0&&!stime.equals("开始时间")){
            tj += " and b.HK_TIME >=to_date('"+stime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0&&!etime.equals("结束时间")){
            tj += " and b.HK_TIME <=to_date('"+etime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        if(vehicle!=null&&!vehicle.isEmpty()&&!vehicle.equals("null")&&vehicle.length()>0&&!vehicle.equals("车牌号码")){
            tj += " and b.VEHICLE_NO= '"+vehicle+"'";
        }
        if(companyName!=null&&!companyName.isEmpty()&&!companyName.equals("null")&&companyName.length()>0&&!companyName.equals("类型")){
            tj += " and g.company_name = '"+companyName+"'";
        }
        if(point!=null&&!point.isEmpty()&&!point.equals("null")&&point.length()>0&&!point.equals("采集点")){
            tj += " and b.HK_ADDRESS = '"+point+"'";
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
        String sql = "select (select count(1) from (SELECT DISTINCT	b.*, g.company_name,g.area_name	FROM tb_taxi_tpc@db69 b" +
                " left join (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on b.VEHICLE_NO=g.plate_number"+
                " WHERE	1=1";
        sql += tj;
        sql += ")a ) as COUNT,tt.* from (select t.*,rownum as rn from (SELECT DISTINCT b.*, g.company_name,g.area_name FROM tb_taxi_tpc@db69 b" +
                " left join (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on b.VEHICLE_NO=g.plate_number"+
                " WHERE	1=1";
        sql += tj;
        sql +=" order by b.HK_TIME desc ) t where rownum <= "+(currentPage*pageSize);
        sql +=")tt where tt.rn >"+((currentPage-1)*pageSize);

        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        map = new HashMap ();
        int count=0;
        if(list.size()>0){
            for (int i = 0; i < list.size(); i++) {
                list.get(i).put("HK_TIME",list.get(i).get("HK_TIME")==null?"":String.valueOf(list.get(i).get("HK_TIME")).substring(0,19));
                list.get(i).put("SPEED_TIME",list.get(i).get("SPEED_TIME")==null?"":String.valueOf(list.get(i).get("SPEED_TIME")).substring(0,19));
                list.get(i).put("GPS_ADDRESS",list.get(i).get("GPS_POINT")==null||list.get(i).get("GPS_POINT").toString().indexOf(",")==-1?"":getOtherUrl(list.get(i).get("GPS_POINT").toString().split(",")[1]+","+list.get(i).get("GPS_POINT").toString().split(",")[0]));

            }
            count = Integer.parseInt(String.valueOf(list.get(0).get("COUNT")));
        }
        map.put("count", count);
        map.put("datas",list);
        return jacksonUtil.toJson(map);
    }

    public String getOtherUrl(String point){
        String res = "";
        String locationUrl = "http://192.168.0.105/gzpc/common/getRealAddress?point=" + point;
        try {
            URL url = new URL(locationUrl);
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                res += line;
            }
            in.close();
        } catch (Exception e) {
            System.out.println("error in wapaction,and e is " + e.getMessage());
        }
        return res;
    }

    //经纬度转为地址
    public static String getAdd(String formattedAmapPoints) {
        String res = "";
//		String locationUrl = "https://restapi.amap.com/v3/geocode/regeo?output=json&location="+formattedAmapPoints+"&key=d0face2397384365119fbf558c48c10a&radius=1000&batch=true";
        String locationUrl = "http://api.map.baidu.com/geocoder/v2/?ak=ELYtYXEH1WmDrK1wDsEWRNkGviRL0ZEo&callback=renderReverse&location=" + formattedAmapPoints + "&output=json&pois=1";
        try {
            URL url = new URL(locationUrl);
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                res += line + "\n";
            }
            in.close();
        } catch (Exception e) {
            System.out.println("error in wapaction,and e is " + e.getMessage());
        }
        if(res.length()>31){
            System.out.println(res.substring(29,res.length()-2));
            if(!"".equals(res)){
                Map<String, Object> map = parseJSON2Map(res.substring(29, res.length() - 2));
                String address = (String) parseJSON2Map(map.get("result").toString()).get("formatted_address");
                return address;
            }
        }
        return res;

    }

    //json to map
    public static Map<String, Object> parseJSON2Map(String jsonStr){
        Map<String, Object> map = new HashMap<String, Object>();
        net.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(jsonStr);
        for(Object k : json.keySet()){
            Object v = json.get(k);
            if(v instanceof JSONArray){
                List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
                Iterator<net.sf.json.JSONObject> it = ((JSONArray)v).iterator();
                while(it.hasNext()){
                    net.sf.json.JSONObject json2 = it.next();
                    list.add(parseJSON2Map(json2.toString()));
                }
                map.put(k.toString(), list);
            } else {
                map.put(k.toString(), v);
            }
        }
        return map;
    }

    @Override
    public String getSuspectedBlackCar(String vehicle, String area, String type, String point, String stime, String etime, Integer currentPage, Integer pageSize) {
        String tj="";
        if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0&&!stime.equals("开始时间")){
            tj += " and b.ERROR_TIME >=to_date('"+stime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0&&!etime.equals("结束时间")){
            tj += " and b.ERROR_TIME <=to_date('"+etime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        if(vehicle!=null&&!vehicle.isEmpty()&&!vehicle.equals("null")&&vehicle.length()>0&&!vehicle.equals("车牌号码")){
            tj += " and b.VEHICLE_NO= '"+vehicle+"'";
        }
        if(type!=null&&!type.isEmpty()&&!type.equals("null")&&type.length()>0&&!type.equals("类型")){
            tj += " and b.ERROR_TYPE = '"+type+"'";
        }
        if(point!=null&&!point.isEmpty()&&!point.equals("null")&&point.length()>0&&!point.equals("采集点")){
            tj += " and b.ERROR_ADDRESS = '"+point+"'";
        }
        if(area!=null&&!area.isEmpty()&&!area.equals("null")&&area.length()>0){
            if(area.equals("主城区")){
                tj += " and (v.AREA_NAME like '%上城%' or v.AREA_NAME like '%下城%' "
                        + "or v.AREA_NAME like '%江干%' or v.AREA_NAME like '%拱墅%' "
                        + "or v.AREA_NAME like '%下沙%' "
                        + "or v.AREA_NAME like '%西湖%' or v.AREA_NAME like '%滨江%')";
            } else {
                tj += " and v.AREA_NAME like '%"+area+"%'";
            }
        }
        String sql = "select (select count(1) from (SELECT DISTINCT	b.*	FROM TB_BLACK_TAXI b" +
                " LEFT JOIN  tb_global_vehicle@db69 v ON b.VEHICLE_NO = v.plate_number" +
                " WHERE	b.VEHICLE_NO LIKE '浙AT%' AND v.plate_number IS NULL";
        sql += tj;
        sql += ")a ) as COUNT,tt.* from (select t.*,rownum as rn from (SELECT DISTINCT b.*,v.area_name FROM TB_BLACK_TAXI b" +
                " LEFT JOIN  tb_global_vehicle@db69 v ON b.VEHICLE_NO = v.plate_number" +
                " WHERE	b.VEHICLE_NO LIKE '浙AT%' AND v.plate_number IS NULL";
        sql += tj;
        sql +=" order by b.ERROR_TIME desc ) t where rownum <= "+(currentPage*pageSize);
        sql +=")tt where tt.rn >"+((currentPage-1)*pageSize);

        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        map = new HashMap ();
        int count=0;
        if(list.size()>0){
            for (int i = 0; i < list.size(); i++) {
                list.get(i).put("ERROR_TIME",list.get(i).get("ERROR_TIME")==null?"":String.valueOf(list.get(i).get("ERROR_TIME")).substring(0,19));
            }
            count = Integer.parseInt(String.valueOf(list.get(0).get("COUNT")));
        }
        map.put("count", count);
        map.put("datas",list);
        return jacksonUtil.toJson(map);
    }

    @Override
    public String getAbnormalOperationValuatorAnalysis(String vehicle, String area, String stime, String etime, Integer currentPage, Integer pageSize) {
        String tj="";
        java.text.DecimalFormat df=new java.text.DecimalFormat("#0.00");
        if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0&&!stime.equals("开始时间")){
            tj += " and b.s_time >=to_date('"+stime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0&&!etime.equals("结束时间")){
            tj += " and b.s_time <=to_date('"+etime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        if(vehicle!=null&&!vehicle.isEmpty()&&!vehicle.equals("null")&&vehicle.length()>0&&!vehicle.equals("车牌号码")){
            tj += " and '浙'||b.vhic= '"+vehicle+"'";
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
        String sql = "select (select count(1) from TB_TAXI_PRIVIDE@db69 b" +
                " left join  (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on '浙'||b.vhic=g.plate_number " +
                " WHERE	1=1";
        sql += tj;
        sql += ") as COUNT,tt.* from (select t.*,rownum as rn from (SELECT b.*,g.area_name,g.company_name from TB_TAXI_PRIVIDE@db69 b" +
                " left join  (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on '浙'||b.vhic=g.plate_number " +
                " WHERE 1=1";
        sql += tj;
        sql +=" order by b.s_time desc ) t where rownum <= "+(currentPage*pageSize);
        sql +=")tt where tt.rn >"+((currentPage-1)*pageSize);

        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        map = new HashMap ();
        int count=0;
        if(list.size()>0){
            for (int i = 0; i < list.size(); i++) {
                list.get(i).put("S_TIME",list.get(i).get("S_TIME")==null?"":String.valueOf(list.get(i).get("S_TIME")).substring(0,19));
                list.get(i).put("E_TIME",list.get(i).get("E_TIME")==null?"":String.valueOf(list.get(i).get("E_TIME")).substring(0,19));
                list.get(i).put("VHIC",list.get(i).get("VHIC")==null?"":"浙"+String.valueOf(list.get(i).get("VHIC")));
                //计价器里程
                double jjq = list.get(i).get("J_MILE")==null?0.00:Double.parseDouble(list.get(i).get("J_MILE").toString());
                //程序计算里程(GPS里程)
                double gps = list.get(i).get("S_MILE")==null?0.00:Double.parseDouble(list.get(i).get("S_MILE").toString());
                list.get(i).put("J_MILE",df.format(jjq));
                list.get(i).put("S_MILE",df.format(gps));
                //速度最优里程(最短时间里程)
                list.get(i).put("RDONE",df.format(jjq/gps));
                list.get(i).put("id",i+1);
            }
            count = Integer.parseInt(String.valueOf(list.get(0).get("COUNT")));
        }
        map.put("count", count);
        map.put("datas",list);
        return jacksonUtil.toJson(map);
    }

    @Override
    public String getAbnormalOperatingMileageAnalysis(String time, Integer low, Integer high, String area) {
        String tj1="";
        String tj2="";
        String date = time.replaceAll("-", "").substring(0,6);
        if(time!=null&&!time.isEmpty()&&!time.equals("null")&&time.length()>0){
            tj1 += " and to_char(t.jsyysj, 'yyyy-MM-dd') ='"+time+"'";
        }
        if(low!=null&&low>0&&high!=null&&high>0){
            tj2= " case when v.s >= 0 and v.s < "+low+" then '0-"+low+"' "
                    + " when v.s >= "+low+" and v.s < "+high+" then '"+low+"-"+high+"' "
                    + " else '"+high+"以上' end";
        }
        if(area!=null&&!area.isEmpty()&&!area.equals("null")&&area.length()>0){
            if(area.equals("主城区")){
                tj1 += " and (g.AREA_NAME like '%上城%' or g.AREA_NAME like '%下城%' "
                        + "or g.AREA_NAME like '%江干%' or g.AREA_NAME like '%拱墅%' "
                        + "or g.AREA_NAME like '%下沙%' "
                        + "or g.AREA_NAME like '%西湖%' or g.AREA_NAME like '%滨江%')";
            } else {
                tj1 += " and g.AREA_NAME like '%"+area+"%'";
            }
        }
        String sql = "select ";
        sql += tj2;
        sql+=" as ti,count(v.cphm) as count, v.time from (select sum(t.szlc) as s, t.cphm, to_char(t.jsyysj, 'yyyy-MM-dd') time from JJQ_TJ_"+date+"_DAY@jjq89 t" +
                " left join  (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on '浙'||t.cphm=g.plate_number " +
                " where 1=1";
        sql += tj1;
        sql += " group by t.cphm , to_char(t.jsyysj, 'yyyy-MM-dd')) v group by v.time,";
        sql += tj2;
        sql +=" order by ti";
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        return jacksonUtil.toJson(list);
    }

    @Override
    public String getAbnormalOperatingMileageAnalysisDetails(String time, Integer low, Integer high, String area) {
        String date = time.replaceAll("-", "").substring(0,6);
        String tj1= "";
        String tj2= "";
        if(time!=null&&!time.isEmpty()&&!time.equals("null")&&time.length()>0){
            tj1 += " and to_char(t.jsyysj, 'yyyy-MM-dd') ='"+time+"'";
        }
        if(low!=null&&low>0){
            tj2 += " and a.s >= "+low;
        }
        if(high!=null&&high>=0){
            tj2 += " and a.s < "+high;
        }
        if(area!=null&&!area.isEmpty()&&!area.equals("null")&&area.length()>0){
            if(area.equals("主城区")){
                tj1 += " and (g.AREA_NAME like '%上城%' or g.AREA_NAME like '%下城%' "
                        + "or g.AREA_NAME like '%江干%' or g.AREA_NAME like '%拱墅%' "
                        + "or g.AREA_NAME like '%下沙%' "
                        + "or g.AREA_NAME like '%西湖%' or g.AREA_NAME like '%滨江%')";
            } else {
                tj1 += " and g.AREA_NAME like '%"+area+"%'";
            }
        }
        String sql = "select * from (select sum(t.szlc) as S,'浙'||t.CPHM CPHM,t.DAY,t.ZGS,t.FGS,g.area_name from JJQ_TJ_"+date+"_DAY@jjq89  t" +
                " left join  (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on '浙'||t.cphm=g.plate_number " +
                " where 1=1";
        sql+=tj1;
        sql +=" group by t.cphm,t.day,t.zgs,t.fgs,g.area_name) a where 1=1 ";
        sql +=tj2;
        sql +=" order by a.S";
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        return jacksonUtil.toJson(list);
    }

    @Override
    public String getSingleOperationAnomalyAnalysis(String time, Integer low, Integer high, String area) {
        String tj1="";
        String tj2="";
        String date = time.replaceAll("-", "").substring(0,6);
        if(time!=null&&!time.isEmpty()&&!time.equals("null")&&time.length()>0){
            tj1 += " and to_char(t.jsyysj, 'yyyy-MM-dd') ='"+time+"'";
        }
        if(low!=null&&low>0&&high!=null&&high>0){
            tj2= " case when v.c >= 0 and v.c < "+low+" then '0-"+low+"' "
                    + " when v.c >= "+low+" and v.c < "+high+" then '"+low+"-"+high+"' "
                    + " else '"+high+"以上' end";
        }
        if(area!=null&&!area.isEmpty()&&!area.equals("null")&&area.length()>0){
            if(area.equals("主城区")){
                tj1 += " and (g.AREA_NAME like '%上城%' or g.AREA_NAME like '%下城%' "
                        + "or g.AREA_NAME like '%江干%' or g.AREA_NAME like '%拱墅%' "
                        + "or g.AREA_NAME like '%下沙%' "
                        + "or g.AREA_NAME like '%西湖%' or g.AREA_NAME like '%滨江%')";
            } else {
                tj1 += " and g.AREA_NAME like '%"+area+"%'";
            }
        }
        String sql = "select ";
        sql += tj2;
        sql+=" as ti,count(v.cphm) as count,time from (select count(t.cphm) c,t.cphm, to_char(t.jsyysj, 'yyyy-MM-dd') time from JJQ_TJ_"+date+"_DAY@jjq89  t" +
                " left join  (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on '浙'||t.cphm=g.plate_number " +
                " where 1=1";
        sql += tj1;
        sql += " group by t.cphm, to_char(t.jsyysj, 'yyyy-MM-dd') ) v group by time,";
        sql += tj2;
        sql +=" order by ti";
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        return jacksonUtil.toJson(list);
    }

    @Override
    public String getSingleOperationAnomalyAnalysisDetails(String time, Integer low, Integer high, String area) {
        String tj1="";
        String tj2="";
        String date = time.replaceAll("-", "").substring(0,6);
        if(time!=null&&!time.isEmpty()&&!time.equals("null")&&time.length()>0){
            tj1 += " and to_char(t.jsyysj, 'yyyy-MM-dd') ='"+time+"'";
        }
        if(low!=null&&low>0){
            tj2 += " and v.c >= "+low;
        }
        if(high!=null&&high>=0){
            tj2 += " and v.c < "+high;
        }
        if(area!=null&&!area.isEmpty()&&!area.equals("null")&&area.length()>0){
            if(area.equals("主城区")){
                tj1 += " and (g.AREA_NAME like '%上城%' or g.AREA_NAME like '%下城%' "
                        + "or g.AREA_NAME like '%江干%' or g.AREA_NAME like '%拱墅%' "
                        + "or g.AREA_NAME like '%下沙%' "
                        + "or g.AREA_NAME like '%西湖%' or g.AREA_NAME like '%滨江%')";
            } else {
                tj1 += " and g.AREA_NAME like '%"+area+"%'";
            }
        }
        String sql = "select * from (select count(t.cphm) as C, '浙'||t.CPHM CPHM,t.DAY,t.ZGS,t.FGS,g.area_name from JJQ_TJ_"+date+"_DAY@jjq89  t"+
                " left join  (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on '浙'||t.cphm=g.plate_number" +
                " where 1=1";
        sql+=tj1;
        sql+=" group by t.cphm ,t.day,t.zgs,t.fgs,g.area_name) v where 1=1 ";
        sql+=tj2;
        sql +=" order by v.c";
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        return jacksonUtil.toJson(list);
    }

    @Override
    public String getPushingViolationDataOfKeyVehicleOperation(String lPNumber, String illegalType, String area, String stime, String etime, Integer currentPage, Integer pageSize) {
        String tj="";
        List<Map<String, Object>> list = null;
        if(lPNumber!=null&&!lPNumber.isEmpty()&&!lPNumber.equals("null")&&lPNumber.length()>0){
            tj += " and al.vehicle_no='"+lPNumber+"'";
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
        if(illegalType!=null&&!illegalType.isEmpty()&&!illegalType.equals("null")&&illegalType.length()>0){
            if("1".equals(illegalType)){
                //出租汽车绕道
                list=findOne(lPNumber, illegalType, area, stime, etime, currentPage, pageSize);
            }else if("2".equals(illegalType)){
                //计价器异常
                list=findTwo(lPNumber, illegalType, area, stime, etime, currentPage, pageSize);
            }else if("3".equals(illegalType)){
                //营运时间异常
                list= findThree(lPNumber, illegalType, area, stime, etime, currentPage, pageSize);
            }else if("4".equals(illegalType)){
                //模子车
                list=findFour(lPNumber, illegalType, area, stime, etime, currentPage, pageSize);
            }else if("5".equals(illegalType)){
                //疑似黑车
                list=findFive(lPNumber, illegalType, area, stime, etime, currentPage, pageSize);
            }else if("6".equals(illegalType)){
                //疑似套牌车
                list=findSix(lPNumber, illegalType, area, stime, etime, currentPage, pageSize);
            }
        }
        map = new HashMap ();
        int count=0;
        if(list!=null&&list.size()>0){
            count = Integer.parseInt(String.valueOf(list.get(0).get("COUNT")));
        }
        map.put("count", count);
        map.put("datas",list);
        return jacksonUtil.toJson(map);
    }

    //出租汽车绕道
    private List<Map<String, Object>> findOne(String lPNumber, String illegalType, String area, String stime, String etime, Integer currentPage, Integer pageSize) {
        String tj="";
        if(lPNumber!=null&&!lPNumber.isEmpty()&&!lPNumber.equals("null")&&lPNumber.length()>0){
            tj += " and '浙'||al.vhic='"+lPNumber+"'";
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
        if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0&&!stime.equals("开始时间")){
            tj += " and al.s_time >=to_date('"+stime+" 00:00:00','yyyy-MM-dd hh24:mi:ss')";
        }
        if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0&&!etime.equals("结束时间")){
            tj += " and al.s_time <=to_date('"+etime+" 23:59:59','yyyy-MM-dd hh24:mi:ss')";
        }
        String sql = "select (select count(1) from (select distinct to_char(al.s_time,'yyyy-MM-dd hh24:mi:ss') id,'浙'||al.vhic vehicle_no,to_char(al.s_time,'yyyy-MM-dd hh24:mi:ss') time" +
                " ,'出租汽车绕道' as illegal_type,1 ILLEGAL_id,c.IS_CHECK,sh.order_result,g.company_name,g.area_name" +
                " from TB_TAXI_PRIVIDE@db69 al" +
                " left join TB_TAXI_ILLEGAL_CHECK@db69 c on to_char(al.s_time,'yyyy-MM-dd hh24:mi:ss')=c.CHECK_TABLE_ID and '浙'||al.vhic=c.vehicle_no  and c.IS_CHECK !=2 and CHECK_TABLE="+illegalType+
                " left join TB_TAXI_ILLEGAL_EXAMINE@db69 sh on '浙'||al.vhic=sh.vehicle_no  and sh.order_result=0 and sh.AUDIT_TYPE="+illegalType+
                " left join  (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on '浙'||al.vhic=g.plate_number " +
                " where 1=1";
        sql +=tj;
        sql += ")a ) as COUNT,tt.* from (select t.*,rownum as rn from (select distinct to_char(al.s_time,'yyyy-MM-dd hh24:mi:ss') id,'浙'||al.vhic vehicle_no,to_char(al.s_time,'yyyy-MM-dd hh24:mi:ss') time" +
                " ,'出租汽车绕道' as illegal_type,1 ILLEGAL_id,c.IS_CHECK,sh.order_result,g.company_name,g.area_name" +
                " from TB_TAXI_PRIVIDE@db69 al" +
                " left join TB_TAXI_ILLEGAL_CHECK@db69 c on to_char(al.s_time,'yyyy-MM-dd hh24:mi:ss')=c.CHECK_TABLE_ID and '浙'||al.vhic=c.vehicle_no  and c.IS_CHECK !=2 and CHECK_TABLE="+illegalType+
                " left join TB_TAXI_ILLEGAL_EXAMINE@db69 sh on '浙'||al.vhic=sh.vehicle_no  and sh.order_result=0 and sh.AUDIT_TYPE="+illegalType+
                " left join  (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on '浙'||al.vhic=g.plate_number " +
                " where 1=1";
        sql += tj;
        sql +="order by time desc, vehicle_no) t where rownum <= "+(currentPage*pageSize);
        sql +=")tt where tt.rn >"+((currentPage-1)*pageSize);
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        return list;
    }

    //计价器异常
    private List<Map<String, Object>> findTwo(String lPNumber, String illegalType, String area, String stime, String etime, Integer currentPage, Integer pageSize) {
        String tj="";
        if(lPNumber!=null&&!lPNumber.isEmpty()&&!lPNumber.equals("null")&&lPNumber.length()>0){
            tj += " and '浙'||al.vhic='"+lPNumber+"'";
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
        if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0&&!stime.equals("开始时间")){
            tj += " and al.s_time >=to_date('"+stime+" 00:00:00','yyyy-MM-dd hh24:mi:ss')";
        }
        if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0&&!etime.equals("结束时间")){
            tj += " and al.s_time <=to_date('"+etime+" 23:59:59','yyyy-MM-dd hh24:mi:ss')";
        }
        String sql = "select (select count(1) from (select distinct to_char(al.s_time,'yyyy-MM-dd hh24:mi:ss') id,'浙'||al.vhic vehicle_no,to_char(al.s_time,'yyyy-MM-dd hh24:mi:ss') time" +
                " ,'计价器异常' as illegal_type,2 ILLEGAL_id,c.IS_CHECK,sh.order_result,g.company_name,g.area_name" +
                " from TB_TAXI_PRIVIDE@db69 al" +
                " left join TB_TAXI_ILLEGAL_CHECK@db69 c on to_char(al.s_time,'yyyy-MM-dd hh24:mi:ss')=c.CHECK_TABLE_ID and '浙'||al.vhic=c.vehicle_no  and c.IS_CHECK !=2 and CHECK_TABLE="+illegalType+
                " left join TB_TAXI_ILLEGAL_EXAMINE@db69 sh on '浙'||al.vhic=sh.vehicle_no  and sh.order_result=0 and sh.AUDIT_TYPE="+illegalType+
                " left join  (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on '浙'||al.vhic=g.plate_number " +
                " where 1=1";
        sql +=tj;
        sql += ")a ) as COUNT,tt.* from (select t.*,rownum as rn from (select distinct to_char(al.s_time,'yyyy-MM-dd hh24:mi:ss') id,'浙'||al.vhic vehicle_no,to_char(al.s_time,'yyyy-MM-dd hh24:mi:ss') time" +
                " ,'计价器异常' as illegal_type,2 ILLEGAL_id,c.IS_CHECK,sh.order_result,g.company_name,g.area_name" +
                " from TB_TAXI_PRIVIDE@db69 al" +
                " left join TB_TAXI_ILLEGAL_CHECK@db69 c on to_char(al.s_time,'yyyy-MM-dd hh24:mi:ss')=c.CHECK_TABLE_ID and '浙'||al.vhic=c.vehicle_no  and c.IS_CHECK !=2 and CHECK_TABLE="+illegalType+
                " left join TB_TAXI_ILLEGAL_EXAMINE@db69 sh on '浙'||al.vhic=sh.vehicle_no  and sh.order_result=0 and sh.AUDIT_TYPE="+illegalType+
                " left join  (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on '浙'||al.vhic=g.plate_number " +
                " where 1=1";
        sql += tj;
        sql +="order by time desc, vehicle_no) t where rownum <= "+(currentPage*pageSize);
        sql +=")tt where tt.rn >"+((currentPage-1)*pageSize);
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        return list;
    }

    //营运时间异常
    private List<Map<String, Object>> findThree(String lPNumber, String illegalType, String area, String stime, String etime, Integer currentPage, Integer pageSize) {
        String tj="";
        if(lPNumber!=null&&!lPNumber.isEmpty()&&!lPNumber.equals("null")&&lPNumber.length()>0){
            tj += " and '浙'||al.vhic='"+lPNumber+"'";
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
        if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0&&!stime.equals("开始时间")){
            tj += " and al.jjq_time >=to_date('"+stime+" 00:00:00','yyyy-MM-dd hh24:mi:ss')";
        }
        if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0&&!etime.equals("结束时间")){
            tj += " and al.jjq_time <=to_date('"+etime+" 23:59:59','yyyy-MM-dd hh24:mi:ss')";
        }
        String sql = "select (select count(1) from (select distinct to_char(al.jjq_time,'yyyy-MM-dd hh24:mi:ss') id,'浙'||al.vhic vehicle_no,to_char(al.jjq_time,'yyyy-MM-dd hh24:mi:ss') time" +
                " ,'营运时间异常' as illegal_type,3 ILLEGAL_id,c.IS_CHECK,sh.order_result,g.company_name,g.area_name" +
                " from tb_jgpt_jjq_alarm@db69 al" +
                " left join TB_TAXI_ILLEGAL_CHECK@db69 c on al.jjq_time=c.CHECK_TABLE_ID and '浙'||al.vhic=c.vehicle_no  and c.IS_CHECK !=2 and CHECK_TABLE="+illegalType+
                " left join TB_TAXI_ILLEGAL_EXAMINE@db69 sh on '浙'||al.vhic=sh.vehicle_no  and sh.order_result=0 and sh.AUDIT_TYPE="+illegalType+
                " left join  (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on '浙'||al.vhic=g.plate_number " +
                " where 1=1";
        sql +=tj;
        sql += ")a ) as COUNT,tt.* from (select t.*,rownum as rn from (select distinct to_char(al.jjq_time,'yyyy-MM-dd hh24:mi:ss') id,'浙'||al.vhic vehicle_no,to_char(al.jjq_time,'yyyy-MM-dd hh24:mi:ss') time" +
                " ,'营运时间异常' as illegal_type,3 ILLEGAL_id,c.IS_CHECK,sh.order_result,g.company_name,g.area_name" +
                " from tb_jgpt_jjq_alarm@db69 al" +
                " left join TB_TAXI_ILLEGAL_CHECK@db69 c on al.jjq_time=c.CHECK_TABLE_ID and '浙'||al.vhic=c.vehicle_no  and c.IS_CHECK !=2 and CHECK_TABLE="+illegalType+
                " left join TB_TAXI_ILLEGAL_EXAMINE@db69 sh on '浙'||al.vhic=sh.vehicle_no  and sh.order_result=0 and sh.AUDIT_TYPE="+illegalType+
                " left join  (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on '浙'||al.vhic=g.plate_number " +
                " where 1=1";
        sql += tj;
        sql +="order by time desc, vehicle_no) t where rownum <= "+(currentPage*pageSize);
        sql +=")tt where tt.rn >"+((currentPage-1)*pageSize);
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        return list;
    }

    //模子车
    private List<Map<String, Object>> findFour(String lPNumber, String illegalType, String area, String stime, String etime, Integer currentPage, Integer pageSize) {
        String tj="";
        if(lPNumber!=null&&!lPNumber.isEmpty()&&!lPNumber.equals("null")&&lPNumber.length()>0){
            tj += " and '浙'||al.vhic='"+lPNumber+"'";
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
        if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0&&!stime.equals("开始时间")){
            tj += " and al.s_time >=to_date('"+stime+" 00:00:00','yyyy-MM-dd hh24:mi:ss')";
        }
        if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0&&!etime.equals("结束时间")){
            tj += " and al.s_time <=to_date('"+etime+" 23:59:59','yyyy-MM-dd hh24:mi:ss')";
        }
        String sql = "select (select count(1) from (select distinct to_char(al.s_time,'yyyy-MM-dd hh24:mi:ss') id,'浙'||al.vhic vehicle_no,to_char(al.s_time,'yyyy-MM-dd hh24:mi:ss') time" +
                " ,'模子车' as illegal_type,4 ILLEGAL_id,c.IS_CHECK,sh.order_result,g.company_name,g.area_name" +
                " from TB_TAXI_PRIVIDE@db69 al" +
                " left join TB_TAXI_ILLEGAL_CHECK@db69 c on al.s_time=c.CHECK_TABLE_ID and '浙'||al.vhic=c.vehicle_no  and c.IS_CHECK !=2 and CHECK_TABLE="+illegalType+
                " left join TB_TAXI_ILLEGAL_EXAMINE@db69 sh on '浙'||al.vhic=sh.vehicle_no  and sh.order_result=0 and sh.AUDIT_TYPE="+illegalType+
                " left join  (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on '浙'||al.vhic=g.plate_number " +
                " where 1=1";
        sql +=tj;
        sql += ")a ) as COUNT,tt.* from (select t.*,rownum as rn from (select distinct to_char(al.s_time,'yyyy-MM-dd hh24:mi:ss') id,'浙'||al.vhic vehicle_no,to_char(al.s_time,'yyyy-MM-dd hh24:mi:ss') time" +
                " ,'模子车' as illegal_type,4 ILLEGAL_id,c.IS_CHECK,sh.order_result,g.company_name,g.area_name" +
                " from TB_TAXI_PRIVIDE@db69 al" +
                " left join TB_TAXI_ILLEGAL_CHECK@db69 c on al.s_time=c.CHECK_TABLE_ID and '浙'||al.vhic=c.vehicle_no  and c.IS_CHECK !=2 and CHECK_TABLE="+illegalType+
                " left join TB_TAXI_ILLEGAL_EXAMINE@db69 sh on '浙'||al.vhic=sh.vehicle_no  and sh.order_result=0 and sh.AUDIT_TYPE="+illegalType+
                " left join  (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on '浙'||al.vhic=g.plate_number " +
                " where 1=1";
        sql += tj;
        sql +="order by time desc, vehicle_no) t where rownum <= "+(currentPage*pageSize);
        sql +=")tt where tt.rn >"+((currentPage-1)*pageSize);
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        return null;
    }

    //疑似黑车
    private List<Map<String, Object>> findFive(String lPNumber, String illegalType, String area, String stime, String etime, Integer currentPage, Integer pageSize) {
        String tj="";
        if(lPNumber!=null&&!lPNumber.isEmpty()&&!lPNumber.equals("null")&&lPNumber.length()>0){
            tj += " and al.VEHICLE_NO='"+lPNumber+"'";
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
        if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0&&!stime.equals("开始时间")){
            tj += " and al.ERROR_TIME >=to_date('"+stime+" 00:00:00','yyyy-MM-dd hh24:mi:ss')";
        }
        if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0&&!etime.equals("结束时间")){
            tj += " and al.ERROR_TIME <=to_date('"+etime+" 23:59:59','yyyy-MM-dd hh24:mi:ss')";
        }
        String sql = "select (select count(1) from (select distinct to_char(al.ERROR_TIME,'yyyy-MM-dd hh24:mi:ss') id,al.vehicle_no vehicle_no,to_char(al.ERROR_TIME,'yyyy-MM-dd hh24:mi:ss') time" +
                " ,'疑似黑车' as illegal_type,5 ILLEGAL_id,c.IS_CHECK,sh.order_result,g.company_name,g.area_name" +
                " from TB_BLACK_TAXI al" +
                " left join TB_TAXI_ILLEGAL_CHECK@db69 c on to_char(al.ERROR_TIME,'yyyy-MM-dd hh24:mi:ss')=c.CHECK_TABLE_ID and al.vehicle_no=c.vehicle_no  and c.IS_CHECK !=2 and CHECK_TABLE="+illegalType+
                " left join TB_TAXI_ILLEGAL_EXAMINE@db69 sh on al.vehicle_no=sh.vehicle_no  and sh.order_result=0 and sh.AUDIT_TYPE="+illegalType+
                " left join  (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on al.vehicle_no=g.plate_number " +
                " where 1=1";
        sql +=tj;
        sql += ")a ) as COUNT,tt.* from (select t.*,rownum as rn from (select distinct to_char(al.ERROR_TIME,'yyyy-MM-dd hh24:mi:ss') id,al.vehicle_no,to_char(al.ERROR_TIME,'yyyy-MM-dd hh24:mi:ss') time" +
                " ,'疑似黑车' as illegal_type,5 ILLEGAL_id,c.IS_CHECK,sh.order_result,g.company_name,g.area_name" +
                " from TB_BLACK_TAXI al" +
                " left join TB_TAXI_ILLEGAL_CHECK@db69 c on to_char(al.ERROR_TIME,'yyyy-MM-dd hh24:mi:ss')=c.CHECK_TABLE_ID and al.vehicle_no=c.vehicle_no  and c.IS_CHECK !=2 and CHECK_TABLE="+illegalType+
                " left join TB_TAXI_ILLEGAL_EXAMINE@db69 sh on al.vehicle_no=sh.vehicle_no  and sh.order_result=0 and sh.AUDIT_TYPE="+illegalType+
                " left join  (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on al.vehicle_no=g.plate_number " +
                " where 1=1";
        sql += tj;
        sql +="order by time desc, vehicle_no) t where rownum <= "+(currentPage*pageSize);
        sql +=")tt where tt.rn >"+((currentPage-1)*pageSize);
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        return list;
    }

    //疑似套牌车
    private List<Map<String, Object>> findSix(String lPNumber, String illegalType, String area, String stime, String etime, Integer currentPage, Integer pageSize) {
        String tj="";
        if(lPNumber!=null&&!lPNumber.isEmpty()&&!lPNumber.equals("null")&&lPNumber.length()>0){
            tj += " and al.VEHICLE_NO='"+lPNumber+"'";
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
        if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0&&!stime.equals("开始时间")){
            tj += " and al.HK_TIME >=to_date('"+stime+" 00:00:00','yyyy-MM-dd hh24:mi:ss')";
        }
        if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0&&!etime.equals("结束时间")){
            tj += " and al.HK_TIME <=to_date('"+etime+" 23:59:59','yyyy-MM-dd hh24:mi:ss')";
        }
        String sql = "select (select count(1) from (select distinct to_char(al.HK_TIME,'yyyy-MM-dd hh24:mi:ss') id,al.vehicle_no vehicle_no,to_char(al.HK_TIME,'yyyy-MM-dd hh24:mi:ss') time" +
                " ,'疑似套牌车' as illegal_type,6 ILLEGAL_id,c.IS_CHECK,sh.order_result,g.company_name,g.area_name" +
                " from tb_taxi_tpc@db69 al" +
                " left join TB_TAXI_ILLEGAL_CHECK@db69 c on to_char(al.HK_TIME,'yyyy-MM-dd hh24:mi:ss')=c.CHECK_TABLE_ID and al.vehicle_no=c.vehicle_no  and c.IS_CHECK !=2 and CHECK_TABLE="+illegalType+
                " left join TB_TAXI_ILLEGAL_EXAMINE@db69 sh on al.vehicle_no=sh.vehicle_no  and sh.order_result=0 and sh.AUDIT_TYPE="+illegalType+
                " left join  (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on al.vehicle_no=g.plate_number " +
                " where 1=1";
        sql +=tj;
        sql += ")a ) as COUNT,tt.* from (select t.*,rownum as rn from (select distinct to_char(al.HK_TIME,'yyyy-MM-dd hh24:mi:ss') id,al.vehicle_no,to_char(al.HK_TIME,'yyyy-MM-dd hh24:mi:ss') time" +
                " ,'疑似套牌车' as illegal_type,6 ILLEGAL_id,c.IS_CHECK,sh.order_result,g.company_name,g.area_name" +
                " from tb_taxi_tpc@db69 al" +
                " left join TB_TAXI_ILLEGAL_CHECK@db69 c on to_char(al.HK_TIME,'yyyy-MM-dd hh24:mi:ss')=c.CHECK_TABLE_ID and al.vehicle_no=c.vehicle_no and c.IS_CHECK !=2 and CHECK_TABLE="+illegalType+
                " left join TB_TAXI_ILLEGAL_EXAMINE@db69 sh on al.vehicle_no=sh.vehicle_no  and sh.order_result=0 and sh.AUDIT_TYPE="+illegalType+
                " left join  (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on al.vehicle_no=g.plate_number " +
                " where 1=1";
        sql += tj;
        sql +="order by time desc, vehicle_no) t where rownum <= "+(currentPage*pageSize);
        sql +=")tt where tt.rn >"+((currentPage-1)*pageSize);
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        return list;
    }

    @Override
    public Integer audit(String check_id, String vehicle, String illegal_type, String illegal_id, String result) {
        if(check_id==null&&check_id.isEmpty()&&check_id.equals("null")&&check_id.length()==0){
            return 0;
        }
        if(vehicle==null&&vehicle.isEmpty()&&vehicle.equals("null")&&vehicle.length()==0){
            return 0;
        }
        String sql="";
        int count=0;
        if(jdbcTemplate.queryForObject("select count(1) from TB_TAXI_ILLEGAL_CHECK@db69 where VEHICLE_NO='"+vehicle+"' and CHECK_TABLE_ID='"+check_id+"' and IS_CHECK !=2",Integer.class)>0){
            return count;
        }
        if(result.equals("0")){
            sql +="insert into TB_TAXI_ILLEGAL_CHECK@db69 (VEHICLE_NO, CHECK_TABLE, CHECK_TABLE_ID ,IS_CHECK)" +
                    " values('"+vehicle+"','"+illegal_id+"','"+check_id+"','"+result+"')";
        }else if(result.equals("1")){
            sql +="insert into TB_TAXI_ILLEGAL_CHECK@db69 (VEHICLE_NO, CHECK_TABLE, CHECK_TABLE_ID ,IS_CHECK)" +
                    " values('"+vehicle+"','"+illegal_id+"','"+check_id+"','"+result+"')";
            String insert="insert into TB_TAXI_ILLEGAL_EXAMINE@db69 (vehicle_no,illegal_type,illegal_time,order_result,AUDIT_TYPE)" +
                    " values('"+vehicle+"','"+illegal_type+"',sysdate,'0','"+illegal_id+"')";
            jdbcTemplate.update(insert);
        }
        count=jdbcTemplate.update(sql);
        return count;
    }

    @Override
    public String getDataExceptionOrder(String vehicle, String area, String stime, String etime) {
        String tj="";
        if(vehicle!=null&&!vehicle.isEmpty()&&!vehicle.equals("null")&&vehicle.length()>0){
            tj +=" and al.vehicle_no='"+vehicle+"'";
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
            tj +=" and al.illegal_time >=to_date('"+stime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0){
            tj +=" and al.illegal_time <=to_date('"+etime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        String sql = "select distinct al.*,to_char(al.illegal_time,'yyyy-MM-dd hh24:mi:ss') time,to_char(al.ONCE_TIME,'yyyy-MM-dd hh24:mi:ss') ONCE" +
                " ,to_char(al.TWICE_TIME,'yyyy-MM-dd hh24:mi:ss') TWICE,to_char(al.THIRD_TIME,'yyyy-MM-dd hh24:mi:ss') THIRD,to_char(al.WD_FEEDBACK_TIME,'yyyy-MM-dd hh24:mi:ss') fgsj" +
                " ,to_char(al.REPAIR_TIME,'yyyy-MM-dd hh24:mi:ss') wxsj, c.CHECK_ID, g.AREA_NAME, g.company_name from TB_TAXI_ILLEGAL_EXAMINE@db69 al" +
                " left join TB_TAXI_ILLEGAL_CHECK@db69 c on al.vehicle_no=c.vehicle_no and al.AUDIT_TYPE=c.CHECK_TABLE and c.IS_CHECK !=2"+
                " left join  (select plate_number, area_name, company_name from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on al.vehicle_no=g.plate_number " +
                " where 1=1";
        sql +=tj;
        sql +=" order by al.illegal_time desc";
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        return jacksonUtil.toJson(list);
    }

    @Override
    public Integer getWorkOrderAudit(String id, String remarks, String check_id) {
        String sql="update TB_TAXI_ILLEGAL_EXAMINE@db69 set order_result='1',description='"+remarks+"' where id='"+id+"' and order_result='0'";
        int count=jdbcTemplate.update(sql);
        if(count>0){
            String update="update TB_TAXI_ILLEGAL_CHECK@db69 s set IS_CHECK=2 where IS_CHECK != 2 and s.check_id='"+check_id+"'";
            jdbcTemplate.update(update);
        }
        return count;
    }

    @Override
    public String findKeyFollowVehicle() {
        String sql = "select distinct VEHICLE, TYPE from TB_ZDGZCL_TAXI@db69 order by vehicle";
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        return jacksonUtil.toJson(list);
    }

    @Override
    public String upload(MultipartFile file) {
        String msg="导入失败";
        if (file.isEmpty()) {
            msg="无文件";
            return msg;
        }
        String fileName = file.getName();
        // 原文件名即上传的文件名
        String origFileName = file.getOriginalFilename();
        String suffix = origFileName.substring(origFileName.lastIndexOf(".") + 1);
//        if(!(suffix.equals("xlsx")||suffix.equals("xls"))){
//            msg="文件格式应该为xlsx或xls";
//            return msg;
//        }
        if(!(suffix.equals("xlsx"))){
            msg="文件格式应该为xlsx";
            return msg;
        }
        String path ="e://erxi//" + origFileName;
        File ff = new File(path);
        // 检测是否存在目录
        if (!ff.getParentFile().exists()) {
            ff.getParentFile().mkdirs();// 新建文件夹
        }
        if(ff.exists()){
            ff.delete();
        }
        try {
            file.transferTo(ff);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<List<Object>> list = null;
        try {
            list = excelUtil.readExcel(ff);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (list == null) {
            msg="读取内容为空";
            return msg;
        } else {
            int count = insert(list);
            if(count>0){
                msg="导入成功";
                return msg;
            }else{
                msg="导入失败";
            }
        }
        return msg;
    }

    private int insert(List<List<Object>> list) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).size()==1){
                count += addOrDeleteKeyFollowVehicleOne(list.get(i).get(0).toString(),"0","1");
            }else if(list.get(i).size()>1){
                count += addOrDeleteKeyFollowVehicleOne(list.get(i).get(0).toString(),list.get(i).get(1).toString(),"1");
            }
        }
        return count;
    }

    @Override
    public Integer addOrDeleteKeyFollowVehicleOne(String vehicle, String type, String whether) {
        int count=0;
        String sql="";
        if("1".equals(whether)){
            if(type!=null&&!type.isEmpty()&&!type.equals("null")&&type.length()>0){
                sql +="insert into TB_ZDGZCL_TAXI@db69 (VEHICLE, TYPE) values('"+vehicle+"','"+type+"')";
            }else{
                sql +="insert into TB_ZDGZCL_TAXI@db69 (VEHICLE) values('"+vehicle+"')";
            }
        }else if("2".equals(whether)){
            sql +="delete from TB_ZDGZCL_TAXI@db69 where VEHICLE='"+vehicle+"'";
        }
        count=jdbcTemplate.update(sql);
        return count;
    }

    @Override
    public Integer deleteKeyFollowVehicle() {
        int count=0;
        String sql="delete from TB_ZDGZCL_TAXI@db69";
        count=jdbcTemplate.update(sql);
        return count;
    }

    @Override
    public List<Map<String, Object>> findFocusMonitor() {
        String sql = "select * from tb_zdgzcl_monitor@db69 where GET_TIME >= sysdate-1/24/60*5 order by VEHICLE_NO";
//        String sql = "select * from tb_zdgzcl_monitor@db69 order by VEHICLE_NO";
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).put("GET_TIME",list.get(i).get("GET_TIME")==null?"":String.valueOf(list.get(i).get("GET_TIME")).substring(0,19));
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> findFaultMonitor() {
        String sql = "select * from tb_gzfx_monitor@db69 where GET_TIME >= sysdate-1/24/60*5 order by VEHICLE_NO";
//        String sql = "select * from tb_gzfx_monitor@db69 order by VEHICLE_NO";
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).put("GET_TIME",list.get(i).get("GET_TIME")==null?"":String.valueOf(list.get(i).get("GET_TIME")).substring(0,19));
        }
        return list;
    }

    @Override
    public String getAbnormalDataAlarmRectificationReport(String vehicle, String area, Integer currentPage, Integer pageSize) {
        String tj="";
        if(vehicle!=null&&!vehicle.isEmpty()&&!vehicle.equals("null")&&vehicle.length()>0){
            tj +=" and a.VHIC='"+vehicle+"'";
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
        String sql = "select (select count(1) from TB_JGPT_STATIS@db69 a" +
                " left join (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on a.VHIC=g.plate_number"+
                " where 1=1";
        sql +=tj;
        sql +=") as COUNT,tt.* from (select t.*,rownum as rn from (select a.*,g.area_name from TB_JGPT_STATIS@db69 a" +
                " left join (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on a.VHIC=g.plate_number"+
                " where 1=1";
        sql +=tj;
        sql +=" order by a.DB_TIME, a.VHIC desc) t where rownum <= "+(currentPage*pageSize);
        sql +=")tt where tt.rn >"+((currentPage-1)*pageSize);
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        map = new HashMap ();
        int count=0;
        if(list.size()>0){
            for (int i = 0; i < list.size(); i++) {
                list.get(i).put("DB_TIME",list.get(i).get("DB_TIME")==null?"":String.valueOf(list.get(i).get("DB_TIME")).substring(0,10));
                list.get(i).put("CX_PERCENT",list.get(i).get("CX_PERCENT")==null?"":100-Double.parseDouble(list.get(i).get("CX_PERCENT").toString().replace("%",""))+"%");
                list.get(i).put("ZQ_PERCENT",list.get(i).get("ZQ_PERCENT")==null?"":100-Double.parseDouble(list.get(i).get("ZQ_PERCENT").toString().replace("%",""))+"%");
            }
            count = Integer.parseInt(String.valueOf(list.get(0).get("COUNT")));
        }
        map.put("count", count);
        map.put("datas",list);
        return jacksonUtil.toJson(map);
    }

    @Override
    public String getWeeklyDataQualityReport(String stime, String etime, String area) {
        String tj="";
        String tj1="";
        if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0&&!stime.equals("开始时间")){
            tj += " and a.DB_TIME >=to_date('"+stime+"','yyyy-MM-dd')";
        }
        if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0&&!etime.equals("结束时间")){
            tj += " and a.DB_TIME <=to_date('"+etime+"','yyyy-MM-dd')";
        }
        if(area!=null&&!area.isEmpty()&&!area.equals("null")&&area.length()>0){
            if(area.equals("主城区")){
                tj1 += " and (g.AREA_NAME like '%上城%' or g.AREA_NAME like '%下城%' "
                        + "or g.AREA_NAME like '%江干%' or g.AREA_NAME like '%拱墅%' "
                        + "or g.AREA_NAME like '%下沙%' "
                        + "or g.AREA_NAME like '%西湖%' or g.AREA_NAME like '%滨江%')";
            } else {
                tj1 += " and g.AREA_NAME like '%"+area+"%'";
            }
        }
        String sql = "select * from (select ROUND(sum(ACT_POINTS) / sum(TOTAL_POINTS),4)*100||'%' WZ_PERCENT," +
                " ROUND(1-sum(LOST_TIME)/sum(RUN_TIME+LOST_TIME),4)*100||'%' CX_PERCENT," +
                " ROUND(1-sum(NOT_ACCU_POINTS)/sum(ACCU_POINTS+NOT_ACCU_POINTS),4)*100||'%' ZQ_PERCENT," +
                " to_char(DB_TIME,'yyyy-MM-dd') day from "+
                " (select a.* from TB_JGPT_STATIS@db69 a" +
                " left join (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on a.VHIC=g.plate_number where 1=1";
        sql +=tj1;
        sql +=") a where 1=1 and a.TOTAL_POINTS not like '%~%'";
        sql +=tj;
        sql +=" group by to_char(DB_TIME,'yyyy-MM-dd') order by day)" +
                " union all" +
                " select ROUND(sum(ACT_POINTS) / sum(TOTAL_POINTS),4)*100||'%' WZ_PERCENT," +
                " ROUND(1-sum(LOST_TIME)/sum(RUN_TIME+LOST_TIME),4)*100||'%' CX_PERCENT," +
                " ROUND(1-sum(NOT_ACCU_POINTS)/sum(ACCU_POINTS+NOT_ACCU_POINTS),4)*100||'%' ZQ_PERCENT," +
                " '总计' day from" +
                " (select a.* from TB_JGPT_STATIS@db69 a" +
                " left join (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on a.VHIC=g.plate_number where 1=1";
        sql +=tj1;
        sql +=") a where 1=1 and a.TOTAL_POINTS not like '%~%'";
        sql +=tj;
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        if(list.size()==1){
            list.clear();
        }
        return jacksonUtil.toJson(list);
    }

    @Override
    public String getMonthlyDataQualityReport(String time, String area) {
        String tj="";
        String tj1="";
        if(time!=null&&!time.isEmpty()&&!time.equals("null")&&time.length()>0&&!time.equals("开始时间")){
            tj += " and to_char(a.DB_TIME,'yyyy-MM') ='"+time+"'";
        }
        if(area!=null&&!area.isEmpty()&&!area.equals("null")&&area.length()>0){
            if(area.equals("主城区")){
                tj1 += " and (g.AREA_NAME like '%上城%' or g.AREA_NAME like '%下城%' "
                        + "or g.AREA_NAME like '%江干%' or g.AREA_NAME like '%拱墅%' "
                        + "or g.AREA_NAME like '%下沙%' "
                        + "or g.AREA_NAME like '%西湖%' or g.AREA_NAME like '%滨江%')";
            } else {
                tj1 += " and g.AREA_NAME like '%"+area+"%'";
            }
        }
        String sql = "select * from (select ROUND(sum(ACT_POINTS) / sum(TOTAL_POINTS),4)*100||'%' WZ_PERCENT," +
                " ROUND(1-sum(LOST_TIME)/sum(RUN_TIME+LOST_TIME),4)*100||'%' CX_PERCENT," +
                " ROUND(1-sum(NOT_ACCU_POINTS)/sum(ACCU_POINTS+NOT_ACCU_POINTS),4)*100||'%' ZQ_PERCENT," +
                " to_char(DB_TIME,'yyyy-MM-dd') day  from " +
                " (select a.* from TB_JGPT_STATIS@db69 a" +
                " left join (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on a.VHIC=g.plate_number where 1=1";
        sql +=tj1;
        sql +=" )a where 1=1  and a.TOTAL_POINTS not like '%~%'";
        sql +=tj;
        sql +=" group by to_char(DB_TIME,'yyyy-MM-dd') order by day)" +
                " union all" +
                " select ROUND(sum(ACT_POINTS) / sum(TOTAL_POINTS),4)*100||'%' WZ_PERCENT," +
                " ROUND(1-sum(LOST_TIME)/sum(RUN_TIME+LOST_TIME),4)*100||'%' CX_PERCENT," +
                " ROUND(1-sum(NOT_ACCU_POINTS)/sum(ACCU_POINTS+NOT_ACCU_POINTS),4)*100||'%' ZQ_PERCENT," +
                " '总计' day from" +
                " (select a.* from TB_JGPT_STATIS@db69 a" +
                " left join (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on a.VHIC=g.plate_number where 1=1";
        sql +=tj1;
        sql +=" )a where 1=1 and a.TOTAL_POINTS not like '%~%'";
        sql +=tj;
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        if(list.size()==1){
            list.clear();
        }
        return jacksonUtil.toJson(list);
    }

    @Override
    public String getSemiAnnualDataQualityReport(String time, String type, String area) {
        String tj="";
        String tj1="";
        if(time!=null&&!time.isEmpty()&&!time.equals("null")&&time.length()>0&&!time.equals("开始时间")){
            String stime="", etime="";
            if(type.equals("1")){
                stime=time+"-0"+1;
                etime=time+"-0"+6;
            }else if(type.equals("2")){
                stime=time+"-0"+7;
                etime=time+"-"+12;
            }
            tj += " and to_char(a.DB_TIME,'yyyy-MM') >='"+stime+"' and to_char(a.DB_TIME,'yyyy-MM') <='"+etime+"'";
        }
        if(area!=null&&!area.isEmpty()&&!area.equals("null")&&area.length()>0){
            if(area.equals("主城区")){
                tj1 += " and (g.AREA_NAME like '%上城%' or g.AREA_NAME like '%下城%' "
                        + "or g.AREA_NAME like '%江干%' or g.AREA_NAME like '%拱墅%' "
                        + "or g.AREA_NAME like '%下沙%' "
                        + "or g.AREA_NAME like '%西湖%' or g.AREA_NAME like '%滨江%')";
            } else {
                tj1 += " and g.AREA_NAME like '%"+area+"%'";
            }
        }
        String sql = "select * from (select ROUND(sum(ACT_POINTS) / sum(TOTAL_POINTS),4)*100||'%' WZ_PERCENT," +
                " ROUND(1-sum(LOST_TIME)/sum(RUN_TIME+LOST_TIME),4)*100||'%' CX_PERCENT," +
                " ROUND(1-sum(NOT_ACCU_POINTS)/sum(ACCU_POINTS+NOT_ACCU_POINTS),4)*100||'%' ZQ_PERCENT," +
                " to_char(DB_TIME,'yyyy-MM') day from" +
                " (select a.* from TB_JGPT_STATIS@db69 a" +
                " left join (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on a.VHIC=g.plate_number where 1=1";
        sql +=tj1;
        sql +=")a where 1=1 and a.TOTAL_POINTS not like '%~%'";
        sql +=tj;
        sql +=" group by to_char(DB_TIME,'yyyy-MM') order by day)" +
                " union all" +
                " select ROUND(sum(ACT_POINTS) / sum(TOTAL_POINTS),4)*100||'%' WZ_PERCENT," +
                " ROUND(1-sum(LOST_TIME)/sum(RUN_TIME+LOST_TIME),4)*100||'%' CX_PERCENT," +
                " ROUND(1-sum(NOT_ACCU_POINTS)/sum(ACCU_POINTS+NOT_ACCU_POINTS),4)*100||'%' ZQ_PERCENT," +
                " '总计' day from" +
                " (select a.* from TB_JGPT_STATIS@db69 a" +
                " left join (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on a.VHIC=g.plate_number where 1=1";
        sql +=tj1;
        sql +=")a where 1=1 and a.TOTAL_POINTS not like '%~%'";
        sql +=tj;
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        if(list.size()==1){
            list.clear();
        }
        return jacksonUtil.toJson(list);
    }

    @Override
    public String getAnnualDataQualityReport(String time, String area) {
        String tj="";
        String tj1="";
        if(time!=null&&!time.isEmpty()&&!time.equals("null")&&time.length()>0&&!time.equals("开始时间")){
            tj += " and to_char(a.DB_TIME,'yyyy') ='"+time+"'";
        }
        if(area!=null&&!area.isEmpty()&&!area.equals("null")&&area.length()>0){
            if(area.equals("主城区")){
                tj1 += " and (g.AREA_NAME like '%上城%' or g.AREA_NAME like '%下城%' "
                        + "or g.AREA_NAME like '%江干%' or g.AREA_NAME like '%拱墅%' "
                        + "or g.AREA_NAME like '%下沙%' "
                        + "or g.AREA_NAME like '%西湖%' or g.AREA_NAME like '%滨江%')";
            } else {
                tj1 += " and g.AREA_NAME like '%"+area+"%'";
            }
        }
        String sql = "select * from (select ROUND(sum(ACT_POINTS) / sum(TOTAL_POINTS),4)*100||'%' WZ_PERCENT," +
                " ROUND(1-sum(LOST_TIME)/sum(RUN_TIME+LOST_TIME),4)*100||'%' CX_PERCENT," +
                " ROUND(1-sum(NOT_ACCU_POINTS)/sum(ACCU_POINTS+NOT_ACCU_POINTS),4)*100||'%' ZQ_PERCENT," +
                " to_char(DB_TIME,'yyyy-MM') day from " +
                " (select a.* from TB_JGPT_STATIS@db69 a" +
                " left join (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on a.VHIC=g.plate_number where 1=1";
        sql +=tj1;
        sql +=")a where 1=1 and a.TOTAL_POINTS not like '%~%'";
        sql +=tj;
        sql +=" group by to_char(DB_TIME,'yyyy-MM') order by day)" +
                " union all" +
                " select ROUND(sum(ACT_POINTS) / sum(TOTAL_POINTS),4)*100||'%' WZ_PERCENT," +
                " ROUND(1-sum(LOST_TIME)/sum(RUN_TIME+LOST_TIME),4)*100||'%' CX_PERCENT," +
                " ROUND(1-sum(NOT_ACCU_POINTS)/sum(ACCU_POINTS+NOT_ACCU_POINTS),4)*100||'%' ZQ_PERCENT," +
                " '总计' day from" +
                " (select a.* from TB_JGPT_STATIS@db69 a" +
                " left join (select * from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on a.VHIC=g.plate_number where 1=1";
        sql +=tj1;
        sql +=")a where 1=1 and a.TOTAL_POINTS not like '%~%'";
        sql +=tj;
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        if(list.size()==1){
            list.clear();
        }
        return jacksonUtil.toJson(list);
    }

    @Override
    public String findAbnormalDisposalProcess(HttpServletRequest request) {
        String sjzt = request.getParameter("sjzt")==null?"":request.getParameter("sjzt");
        String tj="";
        if(sjzt!=null&&!sjzt.isEmpty()&&!sjzt.equals("null")&&sjzt.length()>0&&!sjzt.equals("主题")){
            tj +=" and sjzt like '%"+sjzt+"%'";
        }
        String sql = "select * from TB_YJZH_YJSJ where 1=1 ";
        sql += tj;
        sql +=" order by TIME desc ";
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        if(list!=null){
            for (int i = 0; i < list.size(); i++) {
                list.get(i).put("TIME",list.get(i).get("TIME")==null?"":String.valueOf(list.get(i).get("TIME")).substring(0,10));
                list.get(i).put("SH","0".equals(String.valueOf(list.get(i).get("SH")))?"未核实":("1".equals(String.valueOf(list.get(i).get("SH")))?"已核实":""));
            }
        }
        return jacksonUtil.toJson(list);
    }

    @Override
    public Integer addAbnormalDisposalProcess(HttpServletRequest request) {
        String sjbh = request.getParameter("sjbh")==null?"":request.getParameter("sjbh");
        String sjzt = request.getParameter("sjzt")==null?"":request.getParameter("sjzt");
        String fsdz = request.getParameter("fsdz")==null?"":request.getParameter("fsdz");
        String jwdxx = request.getParameter("jwdxx")==null?"":request.getParameter("jwdxx");
        String bjr = request.getParameter("bjr")==null?"":request.getParameter("bjr");
        String bjdh = request.getParameter("bjdh")==null?"":request.getParameter("bjdh");
        String jjr = request.getParameter("jjr")==null?"":request.getParameter("jjr");
        String sjjl = request.getParameter("sjjl")==null?"":request.getParameter("sjjl");
        String bjnr = request.getParameter("bjnr")==null?"":request.getParameter("bjnr");
        String bjfs = request.getParameter("bjfs")==null?"":request.getParameter("bjfs");
        String sjjb = request.getParameter("sjjb")==null?"":request.getParameter("sjjb");
        Integer count= 0;
        String px="",py="";
        if(jwdxx!=null&&jwdxx.length()>0&&!jwdxx.equals("null")){
            String[] arr=jwdxx.split(",");
            px=arr[0];
            py=arr.length>1?arr[1]:"";
        }
        String sql = "insert into TB_YJZH_YJSJ (SJBH,SJZT,TIME,ADDRESS,SJNR,"
                + "BJR,DJDH,JJR,BJFS,SJJL,PX,PY,SJJB) values ("
                + "'"+sjbh+"','"+sjzt+"',sysdate,'"+fsdz+"','"+bjnr.trim()+"','"+bjr+
                "','"+bjdh+"','"+jjr+"','"+bjfs+"','"+sjjl.trim()+"','"+px+"','"+py+"','"+sjjb+"')";
        count = jdbcTemplate.update(sql);
        return count;
    }

    @Override
    public Integer updateAbnormalDisposalProcess(HttpServletRequest request) {
        String sjbh = request.getParameter("sjbh")==null?"":request.getParameter("sjbh");
        String sjzt = request.getParameter("sjzt")==null?"":request.getParameter("sjzt");
        String fsdz = request.getParameter("fsdz")==null?"":request.getParameter("fsdz");
        String jwdxx = request.getParameter("jwdxx")==null?"":request.getParameter("jwdxx");
        String bjr = request.getParameter("bjr")==null?"":request.getParameter("bjr");
        String bjdh = request.getParameter("bjdh")==null?"":request.getParameter("bjdh");
        String jjr = request.getParameter("jjr")==null?"":request.getParameter("jjr");
        String sjjl = request.getParameter("sjjl")==null?"":request.getParameter("sjjl");
        String bjnr = request.getParameter("bjnr")==null?"":request.getParameter("bjnr");
        String bjfs = request.getParameter("bjfs")==null?"":request.getParameter("bjfs");
        String sjjb = request.getParameter("sjjb")==null?"":request.getParameter("sjjb");
        String id = request.getParameter("id")==null?"":request.getParameter("id");
        Integer count= 0;
        String px="",py="";
        if(jwdxx!=null&&jwdxx.length()>0&&!jwdxx.equals("null")){
            String[] arr=jwdxx.split(",");
            px=arr[0];
            py=arr.length>1?arr[1]:"";
        }
        String sql = "update TB_YJZH_YJSJ set SJBH = '"+sjbh+"',"
                + "SJZT='"+sjzt+"',TIME=sysdate,ADDRESS='"+fsdz+"'"
                + ",SJNR='"+bjnr+"',"
                + "BJR='"+bjr+"',DJDH='"+bjdh+"',JJR='"+jjr+"',"
                + "BJFS='"+bjfs+"',SJJL='"+sjjl+"',PX='"+px+"',PY='"+py+"',SJJB='"+sjjb+"' "
                + " ,sh='0' where id = '"+id+"'";
        count = jdbcTemplate.update(sql);
        return count;
    }

    @Override
    public Integer deleteAbnormalDisposalProcess(String id) {
        Integer count= 0;
        String sql = "delete from TB_YJZH_YJSJ where id = '"+id+"'";
        count = jdbcTemplate.update(sql);
        return count;
    }

    @Override
    public Integer auditAbnormalDisposalProcess(String id, String status) {
        Integer count= 0;
        String sql = "update TB_YJZH_YJSJ set sh='1' where id = '"+id+"'";
        count = jdbcTemplate.update(sql);
        return count;
    }
}