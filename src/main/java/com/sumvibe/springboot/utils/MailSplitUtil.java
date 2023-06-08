package com.sumvibe.springboot.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
/**
 * @date: 2022/11/20 18:16:51
 * @author: xuxufu
 * @description: 邮件分割工具类
 */
@Slf4j
public class MailSplitUtil {
    // 邮件分割标准字节
    private final static int size = 1213;

    public static Map<String, Object> dataConvert(String transInfoStr) {

        // 计算交易总字节数
        int strLength = transInfoStr.getBytes().length;
        log.info("交易的字节总长度 strLength："+strLength);
        log.info("邮件分割标准字节长度 size："+size);
        // 计算字节分组
        int totalNum = strLength / size + 1;
        log.info("根据字节计算分组总数 totalNum："+totalNum);

        // 根据标签分割交易
        String[] strArray = transInfoStr.split("</tr>");
        LinkedList<String> list = new LinkedList<>();
        for (String s : strArray) {
            list.add(s+"</tr>");
        }
        // 总交易笔数
        int totalTransNum = list.size();
        log.info("总交易笔数 totalTransNum："+totalTransNum);
        // 交易总包数
        int totalCount = 0;
        // 取整数
        int perNum = (totalTransNum / totalNum) >= 1 ? (totalTransNum / totalNum) : (totalTransNum / totalNum) + 1;
        log.info("每包交易笔数 perNum: "+perNum);
        // 总包数计算
        if (totalTransNum / totalNum < 1) {
            totalCount = 1;
        } else {
            totalCount = totalTransNum % perNum == 0 ? totalTransNum / perNum : totalTransNum / perNum + 1;
        }
        log.info("交易总包数 totalCount: " +totalCount);
        // 交易分包组合
        LinkedHashMap<String, String> linkedMap = new LinkedHashMap<>();
        for (int i = 0; i < totalCount; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i * perNum; j < ((i + 1) * perNum > list.size() ? list.size() : (i + 1) * perNum); j++) {
                sb.append(list.get(j));
            }
            linkedMap.put("transInfoStr" + i, sb.toString());
            log.info("transInfoStr"+i+":  "+linkedMap.get("transInfoStr"+i).getBytes().length);
        }
        // 组合最终结果
        Map<String, Object> map = new HashMap<>();
        map.put("transInfo", linkedMap);
        map.put("totalCount", totalCount);
        //System.out.println(linkedMap.size());
        return map;
    }

    public static Map<String, Object> dataConvert1(String transInfoStr) {

        // 计算交易总字节数
        int strLength = transInfoStr.getBytes().length;
        log.info("交易的字节总长度 strLength："+strLength);
        log.info("邮件分割标准字节长度 size："+size);
        // 计算字节分组
        int totalNum = strLength % size > 0 ? strLength/size + 1 : strLength/size;
        log.info("根据字节计算分组总数 totalNum："+totalNum);

        // 根据标签分割交易
        String[] strArray = transInfoStr.split("</tr>");
        LinkedList<String> list = new LinkedList<>();
        for (String s : strArray) {
            list.add(s+"</tr>");
        }
        // 总交易笔数
        int totalTransNum = list.size();
        log.info("总交易笔数 totalTransNum："+totalTransNum);

        // 交易分包组合
        LinkedHashMap<String, String> linkedMap = new LinkedHashMap<>();
        int a = 0;
        for (int i = 0; i < totalNum; i++) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sbTem = new StringBuilder();
            for (int j = a; j < list.size(); j++) {
                sbTem.append(list.get(j));
                if (sbTem.toString().getBytes().length <= size) {
                    sb.append(list.get(j));
                } else {
                    a =j;
                    break;
                }
            }
            linkedMap.put("transInfoStr" + i, sb.toString());
            log.info("transInfoStr"+i+":  "+linkedMap.get("transInfoStr"+i).getBytes().length);
        }
        // 组合最终结果
        Map<String, Object> map = new HashMap<>();
        map.put("transInfo", linkedMap);
        map.put("totalCount", totalNum);
        //System.out.println(linkedMap.size());
        return map;
    }
}
