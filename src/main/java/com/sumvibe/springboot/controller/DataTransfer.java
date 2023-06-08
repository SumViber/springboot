package com.sumvibe.springboot.controller;


import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class DataTransfer {
    // 标准字节数
    private final static int size = 20;
    // 交易总包数
    private final static int totalTransNum = 20;

    public static void main(String[] args) {
        StringBuilder sbu = new StringBuilder();
        for (int i = 0; i < 52; i++) {
            sbu.append("<tr><td>java"+i+"</td></tr>");
        }
        String str = sbu.toString();
        int strLength = str.getBytes().length;
        System.out.println("字符串总长度为：" + strLength);
        // 计算字节分组
        //int totalNum = strLength / size + 1;

        String string = StringUtils.substringBetween(str, "<tr>", "</tr>");
        String[] split = str.split("</tr>");
        LinkedList<String> list = new LinkedList<>();
        for (String s : split) {
            //System.out.println(s+"</tr>");
            list.add(s);
        }
        System.out.println(list.size());
        int totalNum = 10;
        System.out.println("字节可分组数为：" + totalNum);
        // 总交易笔数
        int totalTransNum = list.size();
        int totalCount = 0;
        // 取整数
        int perNum = (totalTransNum / totalNum) >= 1 ? (totalTransNum / totalNum) : (totalTransNum / totalNum) + 1;
        // 总包数计算
        if (totalTransNum / totalNum < 1) {
            totalCount = 1;
        } else {
            totalCount = totalTransNum % perNum == 0 ? totalTransNum / perNum : totalTransNum / perNum + 1;
        }

        //nextCount = lastNum == 0 ? totalCount : totalCount - 1;
        //System.out.println("nextCount: " + nextCount);
        System.out.println("totalCount:" + totalCount);
        System.out.println("每包笔数：" + perNum);
        //System.out.println("最后一包笔数：" + lastNum);
        int tempSize = 0;
        // 0 - 012  3   1-345 6    2-678  9 3-9
        HashMap<Object, Object> linkedMap = new LinkedHashMap<>();
        for (int i = 0; i < totalCount;i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i*perNum; j < ((i+1)*perNum > list.size()?list.size():(i+1)*perNum); j++) {
                sb.append(list.get(j));
            }
            linkedMap.put("str" + i, sb.toString());
        }
        //System.out.println(linkedMap);
        Iterator<Map.Entry<Object, Object>> iterator = linkedMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Object, Object> next = iterator.next();
            System.out.println("map key: "+next.getKey()+", map value:"+next.getValue());
        }
    }
}
