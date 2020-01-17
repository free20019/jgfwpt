package mvc.controller;

import mvc.service.PaymentServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import util.DownloadAct;
import util.JacksonUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author: xianlehuang
 * @Description:
 * @date: 2019/02/27
 */

@Controller
@RequestMapping("/pay")
public class PaymentServiceController {
    @Autowired
    private PaymentServiceService paymentserviceService;
    private DownloadAct downloadAct = new DownloadAct();
    private JacksonUtil jacksonUtil = JacksonUtil.buildNormalBinder();

    //支付明细查询
    @RequestMapping("/detailsinquiry")
    @ResponseBody
    public String detailsinquiry(String orderTitle,String stime,String etime,Integer currentPage,Integer pageSize){
        return paymentserviceService.detailsinquiry(orderTitle,stime,etime,currentPage,pageSize);
    }

    //支付明细导出
    @RequestMapping("/detailsinquirydc")
    @ResponseBody
    public String detailsinquirydc(HttpServletRequest request, HttpServletResponse response, String orderTitle, String stime, String etime) throws IOException {
        String a[] = {"订单标题","交易创建时间","交易付款时间","卖家支付账号","买家支付账号","商品单价","购买数量","交易金额"};//导出列明
        String b[] = {"SUBJECT","GMT_CREATE","GMT_PAYMENT","SELLER_EMAIL","BUYER_EMAIL","PRICE","QUANTITY","TOTAL_FEE"};//导出map中的key
        String gzb = "支付明细";//导出sheet名和导出的文件名
        Integer currentPage =1,pageSize=10000000;
        String msg = paymentserviceService.detailsinquiry(orderTitle,stime,etime, currentPage, pageSize);
        List<Map<String, Object>> list = downloadAct.str2list(msg);
        downloadAct.download(request,response,a,b,gzb,list);
        return null;
    }

    //支付账单统计查询
    @RequestMapping("/billsstatistics")
    @ResponseBody
    public String billsstatistics(String alipayAccount,String stime,String etime){
        return paymentserviceService.billsstatistics(alipayAccount,stime,etime);
    }

    //支付账单统计导出
    @RequestMapping("/billsstatisticsdc")
    @ResponseBody
    public String billsstatisticsdc(HttpServletRequest request, HttpServletResponse response, String alipayAccount, String stime, String etime) throws IOException {
        String a[] = {"姓名","支付宝账号","交易次数","交易总金额"};//导出列明
        String b[] = {"SUBJECT","SELLER_EMAIL","JYCS","JYZJE"};//导出map中的key
        String gzb = "支付账单统计";//导出sheet名和导出的文件名
        String msg = paymentserviceService.billsstatistics(alipayAccount,stime,etime);
        List<Map<String, Object>> list = downloadAct.strlist(msg);
        downloadAct.download(request,response,a,b,gzb,list);
        return null;
    }

}
