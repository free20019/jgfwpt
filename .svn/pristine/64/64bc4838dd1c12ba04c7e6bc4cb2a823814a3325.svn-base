package mvc.service.impl;

import mvc.service.PaymentServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import util.JacksonUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: xianlehuang
 * @Description:
 * @date: 2019/02/27
 */

@Service("paymentserviceService")
public class PaymentServiceServiceImpl implements PaymentServiceService {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    private Map<String, Object> map;

    private JacksonUtil jacksonUtil = JacksonUtil.buildNormalBinder();

    @Override
    public String detailsinquiry(String orderTitle, String stime, String etime, Integer currentPage, Integer pageSize) {
        String tj="";
        if(orderTitle!=null&&!orderTitle.isEmpty()&&!orderTitle.equals("null")&&orderTitle.length()>0){
            tj += " and subject like '%"+orderTitle+"%'";
        }
        if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0){
            tj +=" and gmt_payment>=to_date('"+stime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0){
            tj +=" and gmt_payment<=to_date('"+etime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        String sql="select (select count(*) from ZHIFUBAO.TB_ORDER_RECODER@taxilink105 where 1=1";
        sql +=tj;
        sql +=") as COUNT,tt.* from (select t.*,rownum rn from (select SUBJECT,to_char(GMT_CREATE,'yyyy-MM-dd hh24:mi:ss') GMT_CREATE,to_char(GMT_PAYMENT,'yyyy-MM-dd hh24:mi:ss')  GMT_PAYMENT, SELLER_EMAIL, BUYER_EMAIL, PRICE,QUANTITY,TOTAL_FEE from ZHIFUBAO.TB_ORDER_RECODER@taxilink105 where 1=1";
        sql +=tj;
        sql +="order by GMT_CREATE desc";
        sql += " )t where rownum <= "+(currentPage*pageSize);
        sql += " ) tt where tt.rn >"+((currentPage-1)*pageSize);
        List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
        map = new HashMap();
        int count = 0;
        if( list!=null && list.size() >0){
            count = Integer.parseInt(String.valueOf(list.get(0).get("COUNT")));
        }
        map.put("count", count);
        map.put("datas",list);
        return jacksonUtil.toJson(map);
    }

    @Override
    public String billsstatistics(String alipayAccount, String stime, String etime) {
        String tj="";
        if(alipayAccount!=null&&!alipayAccount.isEmpty()&&!alipayAccount.equals("null")&&alipayAccount.length()>0){
            tj += " and subject like '%"+alipayAccount+"%'";
        }
        if(stime!=null&&!stime.isEmpty()&&!stime.equals("null")&&stime.length()>0){
            tj +=" and gmt_payment>=to_date('"+stime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        if(etime!=null&&!etime.isEmpty()&&!etime.equals("null")&&etime.length()>0){
            tj +=" and gmt_payment<=to_date('"+etime+"','yyyy-MM-dd hh24:mi:ss')";
        }
        String sql="select SUBJECT,SELLER_EMAIL,count(BUYER_EMAIL) jycs,sum(TOTAL_FEE) jyzje from ZHIFUBAO.TB_ORDER_RECODER@taxilink105 where SUBJECT <> ' '";
        sql +=tj;
        sql +=" group by SUBJECT,SELLER_EMAIL order by SUBJECT ";
        List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
        return jacksonUtil.toJson(list);
    }
}
