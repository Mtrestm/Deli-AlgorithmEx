package huohuasiwei;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: 火花思维 面试题1
 * @author: Shaobo.Qian
 * @create: 2020-03-18 19:05
 **/

public class AccessRanking {

    //1.读取日志
    //2.需要的数据结构 Map<String,Set<String>> url$ips
    //3.转换数据结构 Map<String,Integer> url$ipSize
    //4.排序
     List<Map.Entry<String, Integer>> getUrlAndIps() {

        Map<String, Set<String>> url$ipMap = new HashMap<>();
        try {
            FileInputStream fileStream = new FileInputStream("/Users/Mtrestm/Desktop/access.log");
            BufferedReader br = new BufferedReader(new InputStreamReader(fileStream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                String target = "2019-01-01 10";
                if (strLine.contains("2019-01-01 10") ) {
                    String[] cols = strLine.split("\t");
                    String key = cols[1];
                    String value = cols[2];
                    if (url$ipMap.containsKey(key)) {
                        Set<String> ips = url$ipMap.get(key);
                        ips.add(value);
                    } else {
                        Set<String> ips = new HashSet<>();
                        ips.add(value);
                        url$ipMap.put(key, ips);
                    }
                } else if (strLine.contains("2019-01-01 11")) {
                    break;
                }
                System.out.println(strLine);
            }
            Map<String, Integer> url$ipCountMap = new HashMap<>();
            url$ipMap.forEach((url, ips) -> {
                url$ipCountMap.put(url, ips.size());
            });
            List<Map.Entry<String, Integer>> urlRankList = new ArrayList<Map.Entry<String, Integer>>(url$ipCountMap.entrySet());
            Collections.sort(urlRankList, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return (o2.getValue() - o1.getValue());
                }
            });
            return urlRankList.stream().limit(5).collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return null;
    }
}
