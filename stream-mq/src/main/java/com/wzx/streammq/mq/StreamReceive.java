package com.wzx.streammq.mq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wzx.streammq.dto.CardVouchers;
import com.wzx.streammq.dto.CunstomerEcifBatch;
import com.wzx.streammq.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 接收方
 */
@Slf4j
@EnableBinding(ArtisanSink.class)   //注解 绑定刚才的接口
@Component
public class StreamReceive {

    // @StreamListener 绑定对象的名称(监听通道名称)
    @StreamListener(ArtisanSink.INPUT)
    @SendTo(ArtisanSink.OUTPUT)
    public String processStreamMsg(String msg){
        JSONObject jsonObj = JSONObject.parseObject(msg);
        String orderDTOList = jsonObj.getString("orderDTOList");
        List<OrderDTO> orderDTOList1 = JSONObject.parseArray(orderDTOList, OrderDTO.class);
        orderDTOList1.forEach(orderDTO -> {
            System.out.println("我是sout输出:"+orderDTO);
            log.info("我是遍历结果:{}",orderDTO.getOrderId());
        });
        log.info("orderDTOList1:{}",orderDTOList1);
        return "StreamReceive.processStreamMsg：消息已消费";
    }

    @StreamListener(ArtisanSink.ECIFINPUT)
    @SendTo(ArtisanSink.ECIFOUTPUT)
    public String ecifMsgReceive(String msg){
        log.info("接受到的参数：{}",msg);
        Map<String,String> resultMap = new HashMap<>();
        Integer ecifBatchSuccessNum = 0;
        Integer ecifBatchErrorNum = 0;
        JSONObject jsonObject = JSONObject.parseObject(msg);
        String sendDate = jsonObject.getString("sendDate");
        String seqNo = jsonObject.getString("seqNo");
        String serviceCode = jsonObject.getString("serviceCode");
        String cardVouchersList = jsonObject.getString("cardVouchersList");
        if (iniresultMap(resultMap, sendDate, "400001", "发送时间不能为空")) {return resultMap.toString();}
        if (iniresultMap(resultMap, seqNo, "400002", "唯一序号不能为空")) {return resultMap.toString();}
        if (iniresultMap(resultMap, serviceCode, "400003", "接口号不能为空")){return resultMap.toString();}
        if (iniresultMap(resultMap, cardVouchersList, "400004", "接受数据为空")){return resultMap.toString();}
        List<CardVouchers> cardVoucherss = JSONObject.parseArray(cardVouchersList, CardVouchers.class);
        log.info("json转换后的list:{}",cardVoucherss);
        for(CardVouchers cardVouchers : cardVoucherss){
            try{
                log.info("添加一条数据成功:{}",cardVouchers);
                ecifBatchSuccessNum += 1;
            }catch (Exception e){
                log.info("添加一条数据失败:{}",cardVouchers);
                ecifBatchErrorNum += 1;
            }
        }
        //添加批量对象
        CunstomerEcifBatch cunstomerEcifBatch = new CunstomerEcifBatch();
        Integer ecifBatchCount = ecifBatchSuccessNum + ecifBatchErrorNum;
        cunstomerEcifBatch.setEcifBatchId(UUID.randomUUID().toString());
        cunstomerEcifBatch.setEcifBatchSuccessNum(ecifBatchSuccessNum);
        cunstomerEcifBatch.setEcifBatchErrorNum(ecifBatchErrorNum);
        cunstomerEcifBatch.setEcifBatchCount(ecifBatchCount);
        cunstomerEcifBatch.setSendDate(sendDate);
        cunstomerEcifBatch.setSeqNo(seqNo);
        cunstomerEcifBatch.setServiceCode(serviceCode);
        log.info("添加批量对象成功:{}",cunstomerEcifBatch);
        resultMap.put("code","200000");
        resultMap.put("flag","success");
        resultMap.put("msg",cunstomerEcifBatch.toString());
        return resultMap.toString();
    }

    /**
     * 判断空操作    空返回true & 错误信息    不为空 返回false
     * @param resultMap
     * @param parms
     * @param code
     * @param msg
     * @return
     */
    private boolean iniresultMap(Map<String, String> resultMap, String parms, String code, String msg) {
        if (Strings.isBlank(parms)) {
            resultMap.put("code", code);
            resultMap.put("flag", "error");
            resultMap.put("msg", msg);
            return true;
        }
        return false;
    }

}
