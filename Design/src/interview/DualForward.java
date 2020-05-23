/**
 * @program: Deli-AlgorithmEx
 * @description:
 * @author: Shaobo.Qian
 * @create: 2020-04-09 19:10
 **/

package interview;

import java.net.HttpURLConnection;
import java.net.URL;

public class DualForward {



    int forward(String uri, String targetServiceHost, String trafficRepositoryHost) throws Exception {

        // 返回http status code         return ; 

        //通过 redis 过期时间来控制￿
        //可用性即在 redis 和数据库中都存一份
        //用线程池, 消费

        return sendGet(targetServiceHost);
    }

    public int sendGet(String targetServiceHost) throws Exception {
        URL urlForGetRequest = new URL(targetServiceHost);
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5 * 1000);
        return connection.getResponseCode();

    }

}
