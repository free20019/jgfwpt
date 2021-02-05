package mvc.service.impl;

import mvc.service.IndustryOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import util.JacksonUtil;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by xiaxing
 * At 2019/2/18 9:36
 */
@Service
public class IndustryOperationServiceImpl implements IndustryOperationService {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    private JacksonUtil jacksonUtil = JacksonUtil.buildNormalBinder();

    //单车营运情况
    @Override
    public String getCyclingOperation(String vehiNo,String stime,String etime,String currentPage,String pageSize,String region) {
        if(stime == null||stime == ""){
            stime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        }
        String str = stime.substring(0,4) + stime.substring(5,7);

        String strsql = "select * from ( select A.*,ROWNUM RN from (";

        String countSql = "select count(*) count from jjq.JJQ"+str+"_1@db89.twkj a,jjq.JJQ_COMPANY@db89.twkj b where flag = '1000000000'";

        String sql = "select '浙' || CPHM_NEW CPHM_NEW,YINGYUN,to_char(SHANGCHE,'yyyy-mm-dd hh24:mi:ss') SHANGCHE,to_char(XIACHE,'yyyy-mm-dd hh24:mi:ss') XIACHE,round(to_number(XIACHE-SHANGCHE)*24*60) YYSJ,to_number(JICHENG)/10 JICHENG,to_number(KONGSHI)/10 KONGSHI,round(to_number(DENGHOU)/60,2) DENGHOU,JIAOYITYPE,to_number(JINE)/100 JINE from jjq.JJQ"+str+"_1@db89.twkj a,jjq.JJQ_COMPANY@db89.twkj b where a.flag = '1000000000'";

        if(region != null&&!region.isEmpty()&&!region.equals("null")&&region.length()>0){
            String qyid="";
            if(region.equals("主城区")){
                qyid = "11";
            }else if(region.equals("余杭区")){
                qyid = "87";
            }else if(region.equals("萧山区")){
                qyid = "88";
            }else if(region.equals("临安区")){
                qyid = "90";
            }else if(region.equals("富阳区")){
                qyid = "89";
            }else if(region.equals("淳安区")){
                qyid = "12";
            }else if(region.equals("建德市")){
                qyid = "21";
            }
            sql += " and b.QYID = '"+qyid+"'";
            countSql += " and b.QYID = '"+qyid+"'";
        }

        if(vehiNo != null&&!vehiNo.isEmpty()&&!vehiNo.equals("null")&&vehiNo.length()>0){
            vehiNo = vehiNo.substring(1);
            sql += "and a.CPHM_NEW = '"+vehiNo+"' ";
            countSql += "and a.CPHM_NEW = '"+vehiNo+"' ";
        }
        if(stime != null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0){
            sql += " and a.SHANGCHE >= to_date('" + stime + "','yyyy-mm-dd hh24:mi:ss')";
            countSql += " and a.SHANGCHE >= to_date('" + stime + "','yyyy-mm-dd hh24:mi:ss')";
        }
        if(etime != null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0){
            sql += " and a.XIACHE <= to_date('" + etime + "','yyyy-mm-dd hh24:mi:ss')";
            countSql += " and a.XIACHE <= to_date('" + etime + "','yyyy-mm-dd hh24:mi:ss')";
        }
        sql += "and '浙'||a.CPHM_NEW = b.CPHM";
        countSql += "and '浙'||a.CPHM_NEW = b.CPHM";

        strsql += sql;
        strsql += ") A where ROWNUM <= "+(Integer.valueOf(currentPage)*Integer.valueOf(pageSize))+" ) where RN >= "+((Integer.valueOf(currentPage)-1)*Integer.valueOf(pageSize));

        System.out.println(strsql);

        List<Map<String, Object>> list = jdbcTemplate.queryForList(strsql);
        List<Map<String, Object>> countList = jdbcTemplate.queryForList(countSql);

        int count = Integer.parseInt(String.valueOf(countList.get(0).get("COUNT")));
        Map  map = new HashMap ();
        map.put("count", count);
        map.put("datas",list);
        return jacksonUtil.toJson(map);
    }

    //行业营运情况分析
    @Override
    public String getIndustryOperations(String vehiNo,String companyName,String stime,String etime) {
        if(stime == null||stime == ""){
            stime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        }
        String str = stime.substring(0,4)+stime.substring(5,7);
        String otherSql = "";
        String ZGS = "";
        String sql = "select substr(day,0,4) || '-' || substr(day,5,2) || '-' || substr(day,7,2) day,count(DISTINCT(CPHM)) CPHM,sum(tjcs) tjcs,sum(jine) jine,sum(SZLC) SZLC,sum(KSLC) KSLC,replace(lpad(round(sum(YSSC)/60,2),4),' ','0') YSSC,replace(lpad(round(sum(DHSJ)/60,2),4),' ','0') DHSJ from jjq.JJQ_TJ_"+str+"_DAY@db89.twkj where type = 5 ";
        if(stime != null){
            sql += " and ksyysj >= to_date('" + stime+"','yyyy-mm-dd hh24:mi:ss')";
        }
        if(etime != null){
            sql += " and jsyysj <= to_date('" + etime+"','yyyy-mm-dd hh24:mi:ss')";
        }
        if(vehiNo != null&&!vehiNo.isEmpty()&&vehiNo.length()>0&&!vehiNo.equals("")){
            otherSql = "";
            vehiNo = vehiNo.substring(1);
            sql += "and CPHM_NEW = '"+vehiNo+"'";
            otherSql += "select DISTINCT(ZGS) from jjq.JJQ_TJ_"+str+"_DAY@db89.twkj where type = 5 and CPHM_NEW = '"+vehiNo+"'";
            ZGS = jdbcTemplate.queryForObject(otherSql,String.class);
        }
        if(companyName != null&&!companyName.isEmpty()&&companyName.length()>0&&!companyName.equals("")){
            otherSql = "";
            otherSql += "select DISTINCT(ZGS) from jjq.JJQ_TJ_"+str+"_DAY@db89.twkj where type = 5 and ZGS = '"+companyName+"'";
            sql += "and ZGS = '"+companyName+"'";
            ZGS = jdbcTemplate.queryForObject(otherSql,String.class);
        }
        sql += " GROUP BY day order by day asc";

        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);

        Map<String,Object> map = new HashMap<String,Object>();
        for(int i=0;i<list.size();i++){
            String DAY = String.valueOf(list.get(i).get("DAY"));
            String CPHM = String.valueOf(list.get(i).get("CPHM"));
            String TJCS = String.valueOf(list.get(i).get("TJCS"));
            String JINE = String.valueOf(list.get(i).get("JINE"));
            String SZLC = String.valueOf(list.get(i).get("SZLC"));
            String KSLC = String.valueOf(list.get(i).get("KSLC"));
            String YSSC = String.valueOf(list.get(i).get("YSSC"));
            String DHSJ = String.valueOf(list.get(i).get("DHSJ"));
            map.put("DAY",DAY);
            map.put("CPHM",CPHM);
            map.put("TJCS",TJCS);
            map.put("JINE",JINE);
            map.put("SZLC",SZLC);
            map.put("KSLC",KSLC);
            map.put("YSSC",YSSC);
            map.put("DHSJ",DHSJ);
        }
        map.put("ZGS",ZGS);
        List<Map<String,Object>> list1 = new ArrayList<Map<String,Object>>();
        list1.add(map);
        return jacksonUtil.toJson(list1);
    }

    //行业平均运行情况分析
    @Override
    public String getIndustryOperation(String stime,String etime,String companyName) {
        if(stime == null||stime == ""){
            stime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        }
        String str = stime.substring(0,4)+stime.substring(5,7);
        String sql = "select count(DISTINCT(cphm)) count from jjq.JJQ_TJ_"+str+"_DAY@db89.twkj where type = 5";
        //查询车辆总数
        int s = Integer.parseInt(jdbcTemplate.queryForList(sql).get(0).get("count").toString());
        String sql1 = "select substr(day,0,4) || '-' || substr(day,5,2) || '-' || substr(day,7,2) day,round(sum(jine)/"+s+",2) jine,round(sum(szlc)/"+s+",2) szlc,round(sum(kslc)/"+s+",2) kslc,round(sum(yssc)/"+s+",2) yssc,round(sum(dhsj)/"+s+",2) dhsj from jjq.JJQ_TJ_"+str+"_DAY@db89.twkj where type = 5 ";
        if(stime != null){
            sql1 += " and ksyysj > to_date('" + stime+"','yyyy-mm-dd hh24:mi:ss')";
        }
        if(etime != null){
            sql1 += " and jsyysj < to_date('" + etime+"','yyyy-mm-dd hh24:mi:ss')";
        }
        if(companyName != null&&companyName.length()>0&&!"".equals(companyName)&&!companyName.isEmpty()){
            sql1 += " and ZGS = '" +companyName+"'";
        }
        sql1 += " GROUP BY day order by day asc";
        return jacksonUtil.toJson(jdbcTemplate.queryForList(sql1));
    }

    //运力需求热点分析
    @Override
    public String getTransportationCapacityHotspot() {
        return null;
    }

    //企业车辆营运情况分析
    @Override
    public String getVehicleOperation(String companyName,String stime,String etime) {
        if(stime == null||stime == ""){
            stime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        }
        String str = stime.substring(0,4)+stime.substring(5,7);
        //公司名称,营运车辆数,营运次数,营运金额,总里程,载客里程,空驶里程,实载率,营运时长,等候时长
        String sql = "select ZGS,count(DISTINCT(CPHM)) vehiNumber,sum(TJCS) TJCS,sum(JINE) JINE,sum(ZLC) ZLC,sum(SZLC) SZLC,sum(KSLC) KSLC,round(sum(SZLC)/sum(ZLC)*100,2) || '%' RATE ,sum(YSSC) YSSC ,sum(DHSJ) DHSJ from jjq.JJQ_TJ_"+str+"_DAY@db89.twkj where type = 5 ";
        if(companyName != null&&!companyName.isEmpty()&&!companyName.equals("null")&&companyName.length()>0){
            sql += "and ZGS = '"+companyName+"'";
        }
        if(stime != null){
            sql += " and ksyysj > to_date('" + stime+"','yyyy-mm-dd hh24:mi:ss')";
        }
        if(etime != null){
            sql += " and jsyysj < to_date('" + etime+"','yyyy-mm-dd hh24:mi:ss')";
        }
        sql += "GROUP BY ZGS";

        System.out.println(sql);

        return jacksonUtil.toJson(jdbcTemplate.queryForList(sql));
    }

    //驾驶员收入情况分析
    @Override
    public String getIncomeAnalysis(String cardNumber,String stime,String etime) {
        if(stime == null||stime == ""){
            stime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        }
        String str = stime.substring(0,4)+stime.substring(5,7);
        String sql = "select tb.name,tt.* from (select YINGYUN,count(YINGYUN) YYCS,sum(JINE)/100 JINE,sum(JICHENG)+sum(KONGSHI) ZLC,sum(JICHENG) JICHENG,sum(KONGSHI) KONGSHI, case when sum(JICHENG)+sum(KONGSHI) = '0' then '0%' else round(sum(JICHENG)/(sum(JICHENG)+sum(KONGSHI))*100,2) || '%' end rate,round(sum((XIACHE-SHANGCHE)*24*60),2) ZKSJ,round(sum(DENGHOU)/60,2) DHSJ from jjq.JJQ"+str+"_1@db89.twkj where FLAG = '1000000000' ";
        if(cardNumber != null&&!cardNumber.isEmpty()&&cardNumber.length()>0&&!cardNumber.equals("")){
            sql += "and YINGYUN = '"+cardNumber+"'";
        }
        if(stime != null){
            sql += "and SHANGCHE > to_date('"+stime+"','yyyy-mm-dd hh24:mi:ss')";
        }
        if(etime != null){
            sql += "and XIACHE < to_date('"+etime+"','yyyy-mm-dd hh24:mi:ss')";
        }
        sql += " GROUP BY YINGYUN) tt LEFT JOIN TB_GLOBAL_PERSON_CERTIFICATE@db69 tb ON tt.YINGYUN = substr(tb.SERIAL_NUMBER,-6)";

        System.out.println(sql);

        return jacksonUtil.toJson(jdbcTemplate.queryForList(sql));
    }
    //车辆运行排行
    @Override
    public String getVehicleRunningRanking(String companyName,String cardNumber,String stime,String etime,String region,String currentPage,String pageSize) {
        if(stime == null||stime == ""){
            stime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        }
        String str = stime.substring(0,4)+stime.substring(5,7);

        String strsql = "select * from ( select A.*,ROWNUM RN from (";

        String countsql = "select count(*) count from (";

        String finalSql = "select * from (";

        String sql = "select v.BA_NAME,v.VEHI_SIM,t.* from (select case when substr(CPHM_NEW,1,1) = 'A' then '浙'||CPHM_NEW else '浙A'||CPHM_NEW end cp,sum(TJCS) TJCS,sum(JINE) JINE,sum(ZLC) ZLC,sum(SZLC) SZLC,sum(KSLC) KSLC,case when sum(ZLC) = '0' then '0%' else round(sum(SZLC)/sum(ZLC)*100,2) || '%' end rate,sum(YSSC) YSSC,sum(DHSJ) DHSJ from jjq.JJQ_TJ_"+str+"_DAY@db89.twkj a,jjq.JJQ_COMPANY@db89.twkj b where TYPE = 5 ";

        if(region != null&&!region.isEmpty()&&!region.equals("null")&&region.length()>0){
            String qyid="";
            if(region.equals("主城区")){
                qyid = "11";
            }else if(region.equals("余杭区")){
                qyid = "87";
            }else if(region.equals("萧山区")){
                qyid = "88";
            }else if(region.equals("临安区")){
                qyid = "90";
            }else if(region.equals("富阳区")){
                qyid = "89";
            }else if(region.equals("淳安区")){
                qyid = "12";
            }else if(region.equals("建德市")){
                qyid = "21";
            }
            sql += " and b.QYID = '"+qyid+"'";
        }

        if(stime != null){
            sql += "and a.ksyysj > to_date('" + stime+"','yyyy-mm-dd hh24:mi:ss')";
        }
        if(etime != null){
            sql += "and a.jsyysj < to_date('" + etime+"','yyyy-mm-dd hh24:mi:ss')";
        }
        sql += "and '浙'||a.CPHM = b.CPHM";

        sql += " GROUP BY CPHM_NEW) t,VW_VEHICLE v where t.cp=v.VEHI_NO ";
        if(companyName != null&&!companyName.isEmpty()&&companyName.length()>0&&!companyName.equals("")){
            sql += "and v.BA_NAME = '"+companyName+"'";
        }
        if(cardNumber != null&&!cardNumber.isEmpty()&&cardNumber.length()>0&&!cardNumber.equals("")){
            sql += "and t.cp = '"+cardNumber+"'";
        }

        finalSql += sql + ")abc order by abc.TJCS desc";


        countsql += finalSql+")";

        strsql += finalSql;
        strsql += ") A where ROWNUM <= "+(Integer.valueOf(currentPage)*Integer.valueOf(pageSize))+" ) where RN >= "+((Integer.valueOf(currentPage)-1)*Integer.valueOf(pageSize));

        System.out.println(strsql);

        List<Map<String, Object>> list = jdbcTemplate.queryForList(strsql);
        List<Map<String, Object>> countList = jdbcTemplate.queryForList(countsql);

        int count = Integer.parseInt(String.valueOf(countList.get(0).get("COUNT")));
        Map  map = new HashMap ();
        map.put("count", count);
        map.put("datas",list);
        return jacksonUtil.toJson(map);
    }

    //驾驶员违法统计
    @Override
    public String getDriverIllegalStatistics(String vehicle,String partyName,String stime,String etime,String currentPage,String pageSize,String region) {
        if(stime == null||stime.trim() == ""){
            stime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        }
        String strSql = "select * from ( select A.*,ROWNUM RN from (";

        String countSql = "select count(*) count from (";

        String sql = "select * from (select tt.*,replace(AUTO_NUM,'.') AUTO_NUM1,replace(INTEGRAL,'-','') INTEGRAL1,to_char(PARTY_BIRTHDAY,'yyyy-mm-dd hh24:mi:ss') PARTY_BIRTHDAY1,to_char(UPD_DATE,'yyyy-mm-dd hh24:mi:ss') UPD_DATE1,to_char(ILLEGAL_TIME,'yyyy-mm-dd hh24:mi:ss') ILLEGAL_TIME1,to_char(LEGAL_TIME,'yyyy-mm-dd hh24:mi:ss') LEGAL_TIME1 from TB_TAXI_ILLEGAL_INFO_OUT tt where 1 = 1 ";
        if(vehicle != null&&!vehicle.isEmpty()&&vehicle.length()>0&&!vehicle.equals("")){
            vehicle = vehicle.substring(0,2) + "." +vehicle.substring(2);
            sql += "and AUTO_NUM = '"+vehicle+"'";
        }
        if(partyName != null&&!partyName.isEmpty()&&partyName.length()>0&&!partyName.equals("")){
            sql += "and PARTY_NAME = '"+partyName+"'";
        }
        if(stime != null&&!stime.isEmpty()&&stime.length()>0&&!stime.equals("")){
            sql += "and LEGAL_TIME >= to_date('"+stime+"','yyyy-mm-dd hh24:mi:ss')";
        }
        if(etime != null&&!etime.isEmpty()&&etime.length()>0&&!etime.equals("")){
            sql += "and LEGAL_TIME <= to_date('"+etime+"','yyyy-mm-dd hh24:mi:ss')";
        }
        sql += ") a,(select PLATE_NUMBER,AREA_NAME from TB_GLOBAL_VEHICLE where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE'浙A%'";
        if(region!=null&&!region.isEmpty()&&region.length()>0&&!region.equals("")){
            if(region.equals("主城区")){
                sql += " and (AREA_NAME like '%上城%' or AREA_NAME like '%下城%' "
                        + "or AREA_NAME like '%江干%' or AREA_NAME like '%拱墅%' "
                        + "or AREA_NAME like '%下沙%' "
                        + "or AREA_NAME like '%西湖%' or AREA_NAME like '%滨江%')";
            } else {
                sql += " and AREA_NAME like '%"+region+"%'";
            }
        }
        sql += ") b where a.AUTO_NUM1 = b.PLATE_NUMBER";
        countSql += sql +")";
        strSql += sql + ") A where ROWNUM <="+(Integer.valueOf(currentPage)*Integer.valueOf(pageSize))+") where RN >= "+((Integer.valueOf(currentPage)-1)*Integer.valueOf(pageSize));
        List<Map<String, Object>> list = jdbcTemplate.queryForList(strSql);

        List<Map<String, Object>> countList = jdbcTemplate.queryForList(countSql);

        int count = Integer.parseInt(String.valueOf(countList.get(0).get("COUNT")));
        Map  map = new HashMap ();
        map.put("count", count);
        map.put("datas",list);
        return jacksonUtil.toJson(map);
    }

    //导出OD营运数据分析
    @Override
    public String getODOperationDataAnalysisExcel(String SJD, String stime, String etime, String QD, String currentPage, String pageSize) {
        String qyid = "3288";
        if(QD.equals("火车东站")){
            qyid = "3288";
        }else if(QD.equals("萧山机场")){
            qyid = "3289";
        } else{
            qyid = "3290";
        }
        if(stime == null||stime.trim() == ""){
            stime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        }
        String table = stime.substring(0, 4) + stime.substring(5, 7);
        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
        if(SJD.equals("全天")){
            String sql1 = "select * from (select t.*,rownum rn from jjq.JJQ"+table+"_1@DB89.TWKJ t where cbid in (select cbid from"
                    + " TB_ORDER_DETAIL t where dep_time >= to_date('"+stime+"','yyyy-mm-dd hh24:mi:ss')"
                    + " and dep_time <= to_date('"+etime+"','yyyy-mm-dd hh24:mi:ss') and dep_id = '"+qyid+"')"
                    + " and flag = '1000000000' and rownum <="+(Integer.valueOf(currentPage)*Integer.valueOf(pageSize))+") where rn >"+((Integer.valueOf(currentPage)-1)*Integer.valueOf(pageSize));

            list = jdbcTemplate.queryForList(sql1);

            for (int i = 0; i < list.size(); i++) {
                list.get(i).put("JICHENG", Double.parseDouble(list.get(i).get("JICHENG").toString())/10);
                list.get(i).put("DENGHOU", (Integer.parseInt(list.get(i).get("DENGHOU").toString().substring(0, 2))*3600+Integer.parseInt(list.get(i).get("DENGHOU").toString().substring(2, 4))*60+Integer.parseInt(list.get(i).get("DENGHOU").toString().substring(4, 6)))/60);
                list.get(i).put("JINE", Integer.parseInt(list.get(i).get("JINE").toString())/100);
                list.get(i).put("KONGSHI", Double.parseDouble(list.get(i).get("KONGSHI").toString())/10);
                list.get(i).put("SCSJ", list.get(i).get("SHANGCHE").toString());
                list.get(i).put("XCSJ", list.get(i).get("XIACHE").toString());
            }
        }else{
            String sql1 = "select * from (select t.*,rownum rn from jjq.JJQ"+table+"_1@DB89.TWKJ t where cbid in (select cbid from"
                    + " TB_ORDER_DETAIL t where flag = '1' and dep_time >= to_date('"+stime+"','yyyy-mm-dd hh24:mi:ss')"
                    + " and dep_time <= to_date('"+etime+"','yyyy-mm-dd hh24:mi:ss') and dep_id = '"+qyid+"')"
                    + " and flag = '1000000000' and rownum <="+(Integer.valueOf(currentPage)*Integer.valueOf(pageSize))+") where rn >"+((Integer.valueOf(currentPage)-1)*Integer.valueOf(pageSize));

            list = jdbcTemplate.queryForList(sql1);

            for (int i = 0; i < list.size(); i++) {
                list.get(i).put("JICHENG", Double.parseDouble(list.get(i).get("JICHENG").toString())/10);
                list.get(i).put("DENGHOU", (Integer.parseInt(list.get(i).get("DENGHOU").toString().substring(0, 2))*3600+Integer.parseInt(list.get(i).get("DENGHOU").toString().substring(2, 4))*60+Integer.parseInt(list.get(i).get("DENGHOU").toString().substring(4, 6)))/60);
                list.get(i).put("JINE", Integer.parseInt(list.get(i).get("JINE").toString())/100);
                list.get(i).put("KONGSHI", Double.parseDouble(list.get(i).get("KONGSHI").toString())/10);
                list.get(i).put("SCSJ", list.get(i).get("SHANGCHE").toString());
                list.get(i).put("XCSJ", list.get(i).get("XIACHE").toString());
            }
        }
        return jacksonUtil.toJson(list);
    }

    @Override
    public String getVehiclesOperationNotOnline(String vehicle, String area, String sTime, String eTime, String type, String currentPage, String pageSize) {

//        String sql = "SELECT * FROM (SELECT A.*, ROWNUM RN  FROM (SELECT VEHICLE_NO,TO_CHAR(CATCH_TIME,'yyyy-mm-dd hh24:mi:ss') CATCH_TIME,TO_CHAR(LATEST_TIME,'yyyy-mm-dd hh24:mi:ss') LATEST_TIME,ADDRESS FROM tb_hk_not_online@db69 where 1 = 1";
//        String countSql = "select count(*) from (SELECT * FROM tb_hk_not_online@db69 where 1 = 1";
//        if(vehicle!=null&&!"".equals(vehicle)){
//            sql += " and VEHICLE_NO = '"+vehicle+"'";
//            countSql += " and VEHICLE_NO = '"+vehicle+"'";
//        }
//        if(sTime!=null&&!"".equals(sTime)){
//            sql += " and CATCH_TIME >= TO_DATE('"+sTime+"','yyyy-mm-dd hh24:mi:ss')";
//            countSql += " and CATCH_TIME >= TO_DATE('"+sTime+"','yyyy-mm-dd hh24:mi:ss')";
//        }
//        if(eTime!=null&&!"".equals(eTime)){
//            sql += " and CATCH_TIME <= TO_DATE('"+eTime+"','yyyy-mm-dd hh24:mi:ss')";
//            countSql += " and CATCH_TIME <= TO_DATE('"+eTime+"','yyyy-mm-dd hh24:mi:ss')";
//        }
//        countSql += ")";
//        sql += ") A  WHERE ROWNUM <= "+(Integer.valueOf(currentPage)*Integer.valueOf(pageSize))+" )  WHERE RN >= "+((Integer.valueOf(currentPage)-1)*Integer.valueOf(pageSize));
//
//        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
//        Integer count = jdbcTemplate.queryForObject(countSql, Integer.class);
//        Map<String,Object> map = new HashMap<>();
//        map.put("datas",list);
//        map.put("count",count);
//        return jacksonUtil.toJson(map);
        String tj="";
        if(vehicle!=null&&!"".equals(vehicle)){
            tj += " and VEHICLE_NO = '"+vehicle+"'";
        }
        if(sTime!=null&&!"".equals(sTime)){
            tj += " and CATCH_TIME >= TO_DATE('"+sTime+"','yyyy-mm-dd hh24:mi:ss')";
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
        if(eTime!=null&&!"".equals(eTime)){
            tj += " and CATCH_TIME <= TO_DATE('"+eTime+"','yyyy-mm-dd hh24:mi:ss')";
        }

        String sql = "select (select count(*) from (select ";
        if(type.equals("true")){
            sql +=" distinct ";
        }
        sql +=  "to_char(ol.CATCH_TIME, 'yyyy-mm-dd'),ol.vehicle_no from tb_hk_not_online@db69 ol" +
                " left join  (select plate_number,area_name from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on ol.vehicle_no=g.plate_number " +
                "where 1=1";
        sql +=tj;
        sql += ")) COUNT, t.* from (select rownum as rn,VEHICLE_NO,TO_CHAR(CATCH_TIME,'yyyy-mm-dd hh24:mi:ss') CATCH_TIME,TO_CHAR(LATEST_TIME,'yyyy-mm-dd hh24:mi:ss') LATEST_TIME,ADDRESS,g.area_name from (select * from tb_hk_not_online@db69 order by CATCH_TIME desc) ol" +
                " left join  (select plate_number,area_name from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on ol.vehicle_no=g.plate_number " +
                "where 1=1";
        if(type.equals("true")){
            sql +=" and (ol.CATCH_TIME,ol.VEHICLE_NO) in (select max(y.CATCH_TIME),y.VEHICLE_NO from tb_hk_not_online@db69 y where ol.VEHICLE_NO=y.VEHICLE_NO group by y.VEHICLE_NO,to_char(y.CATCH_TIME,'yyyy-mm-dd'))";
        }
        sql +=tj;
        sql +=" and rownum <= "+(Integer.valueOf(currentPage)*Integer.valueOf(pageSize));
        sql +=" order by CATCH_TIME desc)t where t.rn >"+((Integer.valueOf(currentPage)-1)*Integer.valueOf(pageSize));
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        Map<String,Object> map = new HashMap<>();
        int count = 0;
        if( list!=null && list.size() >0){
            count = Integer.parseInt(String.valueOf(list.get(0).get("COUNT")));
        }
        map.put("count", count);
        map.put("datas",list);
        return jacksonUtil.toJson(map);

    }

    @Override
    public String getVehiclesOperationNotOnlineStatistics(String vehicle, String area, String sTime, String eTime, String type) {
        String tj1="";
        String tj2="";
        if(vehicle!=null&&!"".equals(vehicle)){
            tj1 += " and VEHICLE_NO = '"+vehicle+"'";
        }
        if(area!=null&&!area.isEmpty()&&!area.equals("null")&&area.length()>0){
            if(area.equals("主城区")){
                tj2 += " and (g.AREA_NAME like '%上城%' or g.AREA_NAME like '%下城%' "
                        + "or g.AREA_NAME like '%江干%' or g.AREA_NAME like '%拱墅%' "
                        + "or g.AREA_NAME like '%下沙%' "
                        + "or g.AREA_NAME like '%西湖%' or g.AREA_NAME like '%滨江%')";
            } else {
                tj2 += " and g.AREA_NAME like '%"+area+"%'";
            }
        }
        if(sTime!=null&&!"".equals(sTime)){
            tj1 += " and CATCH_TIME >= TO_DATE('"+sTime+"','yyyy-mm-dd hh24:mi:ss')";
        }
        if(eTime!=null&&!"".equals(eTime)){
            tj1 += " and CATCH_TIME <= TO_DATE('"+eTime+"','yyyy-mm-dd hh24:mi:ss')";
        }

        String sql = "select VEHICLE_NO,count(VEHICLE_NO) COUNT,g.area_name from (select";
        if(type.equals("true")){
            sql +=" distinct ";
        }
        sql +=" to_char(CATCH_TIME, 'yyyy-mm-dd') CATCH_TIME,vehicle_no from tb_hk_not_online@db69 where 1=1";
        sql +=tj1;
        sql +=") ol left join  (select plate_number,area_name from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on ol.vehicle_no=g.plate_number " +
                "where 1=1";
        sql +=tj2;
        sql +=" group by vehicle_no, g.area_name order by vehicle_no";
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        return jacksonUtil.toJson(list);
    }

    @Override
    public String getDriverSignAndSignOffQuery(String vehicle, String area, String icVehicle, String certificate, String sTime, String eTime) {
        String tj="";
        if(vehicle!=null&&!"".equals(vehicle)){
            tj += " and i.OPERATION_VEHICLENO = '"+vehicle+"'";
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
        if(icVehicle!=null&&!"".equals(icVehicle)){
            tj += " and i.IC_REGISTER_VEHICLENO like '%"+icVehicle+"%'";
        }
        if(certificate!=null&&!"".equals(certificate)){
            tj += " and i.CERTIFICATE like '%"+certificate+"%'";
        }
        if(sTime!=null&&!"".equals(sTime)){
            tj += " and i.LOGINTIME >= TO_DATE('"+sTime+"','yyyy-mm-dd hh24:mi:ss')";
        }
        if(eTime!=null&&!"".equals(eTime)){
            tj += " and i.LOGINTIME <= TO_DATE('"+eTime+"','yyyy-mm-dd hh24:mi:ss')";
        }

        String sql = "select i.*,TO_CHAR(LOGINTIME,'yyyy-mm-dd hh24:mi:ss') SIGN_TIME,TO_CHAR(LOGOUTTIME,'yyyy-mm-dd hh24:mi:ss') SIGN_OFF_TIME,g.area_name from tb_ic_operate@db69 i" +
                " left join  (select plate_number,area_name from tb_global_vehicle@db69 where industry=090 and business_scope_code = 1400  AND STATUS_NAME='营运' AND PLATE_NUMBER LIKE '浙A%') g on i.OPERATION_VEHICLENO=g.plate_number " +
                " where 1=1";
        sql +=tj;
        sql +=" order by i.LOGINTIME desc";
        List<Map<String, Object>>list=jdbcTemplate.queryForList(sql);
        return jacksonUtil.toJson(list).replace("\\u0000","");
    }

    //投诉查询

    @Override
    public String getComplaintsStatistics(String typeComplaint,String stime,String etime,String currentPage,String pageSize) {
        String strSql = "select * from (select A.*,ROWNUM RN from (";
        String countSql = "select count(*) count from (";
        String sql = "select CALL_NAME,BUSINESS_ITEMTYPE_NAME,CALLER_ID,replace(VEHICLE_PLATE_NUMBER,'.') VEHICLE_PLATE_NUMBER,BUSINESS_STATUS_NAME,to_char(ACCEPT_TIME,'yyyy-mm-dd hh24:mi:ss') ACCEPT_TIME,to_char(ARCHIVE_TIME,'yyyy-mm-dd hh24:mi:ss') ARCHIVE_TIME from global_complaint_12328@db69 where 1 = 1 ";
        if(typeComplaint != null&&!typeComplaint.isEmpty()&&typeComplaint.length()>0&&!typeComplaint.equals("")){
            sql += "and BUSINESS_ITEMTYPE_NAME like '%"+typeComplaint+"%'";
        }
        if(stime != null&&!stime.isEmpty()&&stime.length()>0&&!stime.equals("")){
            sql += "and ACCEPT_TIME >= to_date('"+stime+"','yyyy-mm-dd hh24:mi:ss')";
        }
        if(etime != null&&!etime.isEmpty()&&etime.length()>0&&!etime.equals("")){
            sql += "and ACCEPT_TIME <= to_date('"+etime+"','yyyy-mm-dd hh24:mi:ss')";
        }
        countSql += sql + ")";
        strSql += sql + ") A where ROWNUM <="+(Integer.valueOf(currentPage)*Integer.valueOf(pageSize))+") where RN >= "+((Integer.valueOf(currentPage)-1)*Integer.valueOf(pageSize));;
        List<Map<String, Object>> list = jdbcTemplate.queryForList(strSql);

        List<Map<String, Object>> countList = jdbcTemplate.queryForList(countSql);

        int count = Integer.parseInt(String.valueOf(countList.get(0).get("COUNT")));
        Map  map = new HashMap ();
        map.put("count", count);
        map.put("datas",list);
        return jacksonUtil.toJson(map);
    }
    //OD营运数据分析

    @Override
    public String getODOperationDataAnalysis(String SJD,String stime,String etime,String QD,String currentPage,String pageSize) {
        String qyid = "3288";
        if(QD.equals("火车东站")){
            qyid = "3288";
        }else if(QD.equals("萧山机场")){
            qyid = "3289";
        } else{
            qyid = "3290";
        }
        if(stime == null||stime.trim() == ""){
            stime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        }
        String table = stime.substring(0, 4) + stime.substring(5, 7);
        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
        List<Map<String, Object>> list1 = new ArrayList<Map<String,Object>>();
        List<Map<String, Object>> count = null;
        if(SJD.equals("全天")){
            String sql = "select tjcs,cphm,ROUND(yssc/tjcs,2) yssc,ROUND(dhsj/tjcs,2) dhsj,ROUND(jine/tjcs,2) jine,"
                    + "ROUND(szlc/tjcs,2) szlc from (select sum(tjcs) tjcs,count(distinct(cphm)) cphm,sum(yssc) yssc,sum(dhsj) dhsj"
                    + ",sum(jine) jine,sum(szlc) szlc"
                    + " from jjq.JJQ_TJ_"+table+"_DAY@db89.twkj where cphm in(select vhic from TB_ORDER_DETAIL"
                    + " where dep_id = '"+qyid+"' and dep_time >= to_date('"+stime+"','yyyy-mm-dd hh24:mi:ss')"
                    + " and dep_time <= to_date('"+etime+"','yyyy-mm-dd hh24:mi:ss')) and type = '5'"
                    + " and day >= '"+stime.replaceAll("-", "").substring(0,8)+"' and day <= '"+etime.replaceAll("-", "").substring(0,8)+"')";

            System.out.println(sql);

            list1 = jdbcTemplate.queryForList(sql);
            String sql1 = "select * from (select t.*,rownum rn from jjq.JJQ"+table+"_1@DB89.TWKJ t where cbid in (select cbid from"
                    + " TB_ORDER_DETAIL t where dep_time >= to_date('"+stime+"','yyyy-mm-dd hh24:mi:ss')"
                    + " and dep_time <= to_date('"+etime+"','yyyy-mm-dd hh24:mi:ss') and dep_id = '"+qyid+"')"
                    + " and flag = '1000000000' and rownum <="+(Integer.valueOf(currentPage)*Integer.valueOf(pageSize))+") where rn >"+((Integer.valueOf(currentPage)-1)*Integer.valueOf(pageSize));


            list = jdbcTemplate.queryForList(sql1);

            String countSql = "select count(*) count from (select t.* from jjq.JJQ"+table+"_1@DB89.TWKJ t where cbid in ( SELECT cbid FROM TB_ORDER_DETAIL t WHERE dep_time >= to_date('"+stime+"','yyyy-mm-dd hh24:mi:ss') AND dep_time <= to_date('"+etime+"','yyyy-mm-dd hh24:mi:ss') AND dep_id = "+qyid+") and flag = '1000000000' )";

            count = jdbcTemplate.queryForList(countSql);

            for (int i = 0; i < list.size(); i++) {
                list.get(i).put("JICHENG", Double.parseDouble(list.get(i).get("JICHENG").toString())/10);
                list.get(i).put("DENGHOU", (Integer.parseInt(list.get(i).get("DENGHOU").toString().substring(0, 2))*3600+Integer.parseInt(list.get(i).get("DENGHOU").toString().substring(2, 4))*60+Integer.parseInt(list.get(i).get("DENGHOU").toString().substring(4, 6)))/60);
                list.get(i).put("JINE", Integer.parseInt(list.get(i).get("JINE").toString())/100);
                list.get(i).put("KONGSHI", Double.parseDouble(list.get(i).get("KONGSHI").toString())/10);
                list.get(i).put("SCSJ", list.get(i).get("SHANGCHE").toString());
                list.get(i).put("XCSJ", list.get(i).get("XIACHE").toString());
            }
        }else{
            String sql = "select tjcs,cphm,ROUND(yssc/tjcs,2) yssc,ROUND(dhsj/tjcs,2) dhsj,ROUND(jine/tjcs,2) jine,"
                    + "ROUND(szlc/tjcs,2) szlc from (select count(1) tjcs,count(distinct(vhic)) cphm,sum(to_number(jine))/100 jine"
                    + ",sum((xiache-shangche)*24*60) yssc,sum(jicheng)/10 szlc,"
                    + "sum(substr(denghou,0,2)*60+substr(denghou,2,4)+substr(denghou,4,6)/60) dhsj"
                    + " from jjq.JJQ"+table+"_1@DB89.TWKJ t where cbid in (select cbid from TB_ORDER_DETAIL t where"
                    + " flag = '1' and dep_time >= to_date('"+stime+"','yyyy-mm-dd hh24:mi:ss') and"
                    + " dep_time <= to_date('"+etime+"','yyyy-mm-dd hh24:mi:ss') and dep_id = '"+qyid+"')"
                    + " and flag = '1000000000')";
            list1 = jdbcTemplate.queryForList(sql);
            String sql1 = "select * from (select t.*,rownum rn from jjq.JJQ"+table+"_1@DB89.TWKJ t where cbid in (select cbid from"
                    + " TB_ORDER_DETAIL t where flag = '1' and dep_time >= to_date('"+stime+"','yyyy-mm-dd hh24:mi:ss')"
                    + " and dep_time <= to_date('"+etime+"','yyyy-mm-dd hh24:mi:ss') and dep_id = '"+qyid+"')"
                    + " and flag = '1000000000' and rownum <="+(Integer.valueOf(currentPage)*Integer.valueOf(pageSize))+") where rn >"+((Integer.valueOf(currentPage)-1)*Integer.valueOf(pageSize));
            list = jdbcTemplate.queryForList(sql1);

            String countSql = "select count(*) count from (select t.* from jjq.JJQ"+table+"_1@DB89.TWKJ t where cbid in ( SELECT cbid FROM TB_ORDER_DETAIL t WHERE dep_time >= to_date('"+stime+"','yyyy-mm-dd hh24:mi:ss') AND dep_time <= to_date('"+etime+"','yyyy-mm-dd hh24:mi:ss') AND dep_id = "+qyid+") and flag = '1000000000' )";

            count = jdbcTemplate.queryForList(countSql);

            for (int i = 0; i < list.size(); i++) {
                list.get(i).put("JICHENG", Double.parseDouble(list.get(i).get("JICHENG").toString())/10);
                list.get(i).put("DENGHOU", (Integer.parseInt(list.get(i).get("DENGHOU").toString().substring(0, 2))*3600+Integer.parseInt(list.get(i).get("DENGHOU").toString().substring(2, 4))*60+Integer.parseInt(list.get(i).get("DENGHOU").toString().substring(4, 6)))/60);
                list.get(i).put("JINE", Integer.parseInt(list.get(i).get("JINE").toString())/100);
                list.get(i).put("KONGSHI", Double.parseDouble(list.get(i).get("KONGSHI").toString())/10);
                list.get(i).put("SCSJ", list.get(i).get("SHANGCHE").toString());
                list.get(i).put("XCSJ", list.get(i).get("XIACHE").toString());
            }
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mx", list);
        map.put("tj", list1);
        map.put("count", count.get(0).get("count"));
        return jacksonUtil.toJson(map);
    }
    //OD流向统计

    @Override
    public String getODFlowStatistics(String SJD,String stime,String etime,String QD) {
        String flag = "0";
        if(!SJD.equals("全天")){
            flag = "1";
        }
        String qyid = "3289";
        if(QD.equals("火车东站")){
            qyid = "3288";
        }else if(QD.equals("萧山机场")){
            qyid = "3289";
        } else{
            qyid = "3290";
        }
        String sql = "select area_name,sum(count_num) count_num,a.area_id from TB_ORDER_DETAIL_OD t,TB_ORDER_AREA_PLUS a"
                + " where t.dest_id = a.area_id and db_time >= to_date('"+stime+"','yyyy-mm-dd hh24:mi:ss') and"
                + " db_time <= to_date('"+etime+"','yyyy-mm-dd hh24:mi:ss') and flag = '"+flag+"'"
                + " and dep_id = '"+qyid+"' group by a.area_id,a.area_name order by count_num desc";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return jacksonUtil.toJson(list);
    }
    //OD流向图

    @Override
    public String getODFlowDiagram(String SJD,String stime,String etime,String QD,String currentPage,String pageSize) {
        String flag = "0";
        if(!SJD.equals("全天")){
            flag = "1";
        }
        String qyid = "3289";
        if(QD.equals("火车东站")){
            qyid = "3288";
        }else if(QD.equals("萧山机场")){
            qyid = "3289";
        } else{
            qyid = "3290";
        }

        String strSql = "select * from (select A.*,ROWNUM RN from (";

        String countSql = "select count(*) count from (";

        String sql = "select t1.*,a1.area_coordinates from (select area_name,sum(count_num) count_num"
                + ",A.AREA_ID from TB_ORDER_DETAIL_OD t,TB_ORDER_AREA_PLUS a where t.dest_id = a.area_id"
                + " and db_time >= to_date('"+stime+"','yyyy-mm-dd hh24:mi:ss') and"
                + " db_time <= to_date('"+etime+"','yyyy-mm-dd hh24:mi:ss') and flag = '"+flag+"'"
                + " and dep_id = '"+qyid+"' group by area_name,A.AREA_ID order by count_num desc) t1,"
                + "TB_ORDER_AREA_PLUS a1 where t1.AREA_ID = a1.area_id order by count_num desc";

        countSql += sql + ")";
        strSql += sql + ") A where ROWNUM <="+(Integer.valueOf(currentPage)*Integer.valueOf(pageSize))+") where RN>="+((Integer.valueOf(currentPage)-1)*Integer.valueOf(pageSize));

        List<Map<String, Object>> list = jdbcTemplate.queryForList(strSql);

        List<Map<String, Object>> countList = jdbcTemplate.queryForList(countSql);

        String qd = "select * from TB_ORDER_AREA_PLUS where area_id = '"+qyid+"'";
        List<Map<String, Object>> qdlist = jdbcTemplate.queryForList(qd);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("qd", qdlist);
        map.put("zd", list);
        map.put("count",countList.get(0).get("count"));
        return jacksonUtil.toJson(map);
    }
    //夜间停放位置分析
    @Override
    public String getParkingPlaceAtNight(String stime, String etime, Integer number, Integer currentPage, Integer pageSize) {
        String tj="";
        String tj2="";

        if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0&&!stime.equals("开始时间")){
            tj += " and a.DBTIME >=to_date('"+stime+"','yyyy-MM-dd')";
        }
        if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0&&!etime.equals("结束时间")){
            tj += " and a.DBTIME <=to_date('"+etime+"','yyyy-MM-dd')";
        }
        if(number!=null&&!number.equals("null")&&number>=0){
            tj2 += " and rownum <="+number;
        }
        String sql = "select (select count(*) count from (select distinct a.AREA_ID, a.AREA_NAME" +
                " from tb_taxi_park_hot@db69 a,TB_ORDER_AREA_PLUS b" +
                " where a.AREA_ID = b.AREA_ID";
        sql +=tj;
        sql +=tj2;
        sql += " )) as count,tt.* from (select t.*,rownum as rn from ( select a.*,b.AREA_COORDINATES from" +
                " (select a.AREA_ID,a.AREA_NAME,sum(a.AREA_COUNT) AREA_COUNT from tb_taxi_park_hot@db69 a where 1=1 ";
        sql +=tj;
        sql += " group by a.AREA_ID, a.AREA_NAME) a" +
                " left join TB_ORDER_AREA_PLUS b on a.AREA_ID = b.AREA_ID where b.AREA_ID is not null" +
                " order by a.area_count desc, a.AREA_NAME) t where rownum <= "+(currentPage*pageSize);
        sql +=tj2;
        sql +=")tt where tt.rn >"+((currentPage-1)*pageSize);
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        int count=0;
        if(list.size()>0){
            for (int i = 0; i < list.size(); i++) {
//                list.get(i).put("DB_TIME",list.get(i).get("DB_TIME")==null?"":String.valueOf(list.get(i).get("DB_TIME")).substring(0,10));
            }
            count = Integer.parseInt(String.valueOf(list.get(0).get("COUNT")));
        }
        Map map = new HashMap ();
        map.put("count", count);
        map.put("datas",list);
        return jacksonUtil.toJson(map);
    }

    @Override
    public String getHotSpotOfTaxiDemand(String stime, String etime, Integer number, Integer currentPage, Integer pageSize) {
        String tj="";
        String tj2="";

        if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0&&!stime.equals("开始时间")){
            tj += " and a.DBTIME >=to_date('"+stime+"','yyyy-MM-dd')";
        }
        if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0&&!etime.equals("结束时间")){
            tj += " and a.DBTIME <=to_date('"+etime+"','yyyy-MM-dd')";
        }
        if(number!=null&&!number.equals("null")&&number>=0){
            tj2 += " and rownum <="+number;
        }
        String sql = "select (select count(*) count from (select distinct a.AREA_ID, a.AREA_NAME" +
                " from tb_taxi_sta_hot@db69 a,TB_ORDER_AREA_PLUS b" +
                " where a.AREA_ID = b.AREA_ID";
        sql +=tj;
        sql +=tj2;
        sql += " )) as count,tt.* from (select t.*,rownum as rn from ( select a.*,b.AREA_COORDINATES from" +
                " (select a.AREA_ID,a.AREA_NAME,sum(a.AREA_COUNT) AREA_COUNT from tb_taxi_sta_hot@db69 a where 1=1 ";
        sql +=tj;
        sql += " group by a.AREA_ID, a.AREA_NAME) a" +
                " left join TB_ORDER_AREA_PLUS b on a.AREA_ID = b.AREA_ID where b.AREA_ID is not null" +
                " order by a.area_count desc, a.AREA_NAME) t where rownum <= "+(currentPage*pageSize);
        sql +=tj2;
        sql +=")tt where tt.rn >"+((currentPage-1)*pageSize);
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        int count=0;
        if(list.size()>0){
            for (int i = 0; i < list.size(); i++) {
//                list.get(i).put("DB_TIME",list.get(i).get("DB_TIME")==null?"":String.valueOf(list.get(i).get("DB_TIME")).substring(0,10));
            }
            count = Integer.parseInt(String.valueOf(list.get(0).get("COUNT")));
        }
        Map map = new HashMap ();
        map.put("count", count);
        map.put("datas",list);
        return jacksonUtil.toJson(map);
    }

    @Override
    public String getVehicleFlowPosition(String stime, String etime, Integer number, Integer currentPage, Integer pageSize) {
        String tj="";
        String tj2="";

        if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0&&!stime.equals("开始时间")){
            tj += " and a.DBTIME >=to_date('"+stime+"','yyyy-MM-dd')";
        }
        if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0&&!etime.equals("结束时间")){
            tj += " and a.DBTIME <=to_date('"+etime+"','yyyy-MM-dd')";
        }
        if(number!=null&&!number.equals("null")&&number>=0){
            tj2 += " and rownum <="+number;
        }
        String sql = "select (select count(*) count from (select * from (select distinct a.AREA_ID, a.AREA_NAME" +
                " from tb_taxi_end_hot@db69 a,TB_ORDER_AREA_PLUS b" +
                " where a.AREA_ID = b.AREA_ID(+)";
        sql +=tj;
        sql +=") where 1=1";
        sql +=tj2;
        sql += " )) as count,tt.* from (select t.*,rownum as rn from ( select a.*,b.AREA_COORDINATES from" +
                " (select a.AREA_ID,a.AREA_NAME,sum(a.AREA_COUNT) AREA_COUNT from tb_taxi_end_hot@db69 a where 1=1 ";
        sql +=tj;
        sql += " group by a.AREA_ID, a.AREA_NAME) a" +
                " left join TB_ORDER_AREA_PLUS b on a.AREA_ID = b.AREA_ID where b.AREA_ID is not null" +
                " order by a.area_count desc, a.AREA_NAME) t where rownum <= "+(currentPage*pageSize);
        sql +=tj2;
        sql +=")tt where tt.rn >"+((currentPage-1)*pageSize);
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        int count=0;
        if(list.size()>0){
            for (int i = 0; i < list.size(); i++) {
//                list.get(i).put("DB_TIME",list.get(i).get("DB_TIME")==null?"":String.valueOf(list.get(i).get("DB_TIME")).substring(0,10));
            }
            count = Integer.parseInt(String.valueOf(list.get(0).get("COUNT")));
        }
        Map map = new HashMap ();
        map.put("count", count);
        map.put("datas",list);
        return jacksonUtil.toJson(map);
    }

    @Override
    public String getcapacitydemandhotspot(String stime, String etime) {
        String tj="";
        if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0){
            tj +=" and a.dep_time >= to_date('"+stime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0){
            tj +=" and a.dep_time <= to_date('"+etime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        String sql="select * from Tb_Order_Match@db69 a where 1=1";
        sql +=tj;
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return jacksonUtil.toJson(list);
    }

    @Override
    public String getcapacitydemandhotspotdriver(String stime, String etime) {
        String tj="";
        if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0){
            tj +=" and a.dep_time >= to_date('"+stime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0){
            tj +=" and a.dep_time <= to_date('"+etime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        String sql="select to_char(a.dep_time,'hh24') dep_time,count(1) c from Tb_Order_Match@db69 a where 1=1";
        sql +=tj;
        sql +="group by to_char(a.dep_time,'hh24') order by to_char(a.dep_time,'hh24')";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return jacksonUtil.toJson(list);
    }
}
