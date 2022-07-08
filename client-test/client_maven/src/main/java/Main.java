import netscape.javascript.JSObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.codehaus.plexus.util.IOUtil;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws IOException {
        /*CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(new HttpGet("http://localhost:8080/user/get"));
        HttpEntity entity = response.getEntity();
        String data = IOUtil.toString(entity.getContent());
        System.out.println(data);*/

        CloseableHttpClient client1 = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8080/user/login");
        BaseDto baseDto = new BaseDto();
        baseDto.setLogin("123");
        baseDto.setPassword("123");
        JSONObject jo = new JSONObject(baseDto);
        System.out.println(jo.toString());
        httpPost.setEntity(new StringEntity(jo.toString()));
        CloseableHttpResponse response1 = client1.execute(httpPost);
        String data1 = IOUtil.toString(response1.getEntity().getContent());
        System.out.println(data1);

        CloseableHttpClient client2 = HttpClients.createDefault();
        HttpPost httpPostAdd = new HttpPost("http://localhost:8080/user/add");
        EmployeeDto employeeDto = new EmployeeDto("123", "Test", "Test", "Test", "Test", new BigDecimal("13.4"), "2020-10-10", "2020-10-10", "test", "test", "test", "test", "test");
        employeeDto.setLogin("123");
        employeeDto.setPassword("123");
        employeeDto.setSalary(new BigDecimal("13.4"));
        jo = new JSONObject(employeeDto);
        System.out.println(jo.toString());
        httpPostAdd.setEntity(new StringEntity(jo.toString()));
        CloseableHttpResponse response2 = client2.execute(httpPostAdd);
        String data2 = IOUtil.toString(response2.getEntity().getContent());
        System.out.println(data2);

        CloseableHttpClient client3 = HttpClients.createDefault();
        HttpPost httpPost3 = new HttpPost("http://localhost:8080/user/getInfo");
        BaseDto baseDto3 = new BaseDto();
        baseDto3.setLogin("123");
        baseDto3.setPassword("123");
        JSONObject jo3 = new JSONObject(baseDto3);
        System.out.println(jo3.toString());
        httpPost3.setEntity(new StringEntity(jo3.toString()));
        CloseableHttpResponse response3 = client3.execute(httpPost3);
        String data3 = IOUtil.toString(response3.getEntity().getContent());
        System.out.println(data3);

        CloseableHttpClient client4 = HttpClients.createDefault();
        HttpPost httpPost4 = new HttpPost("http://localhost:8080/user/getAllEmployee");
        BaseDto baseDto4 = new BaseDto();
        baseDto4.setLogin("123");
        baseDto4.setPassword("123");
        JSONObject jo4 = new JSONObject(baseDto4);
        System.out.println(jo4.toString());
        httpPost4.setEntity(new StringEntity(jo4.toString()));
        CloseableHttpResponse response4 = client4.execute(httpPost4);
        String data4 = IOUtil.toString(response4.getEntity().getContent());
        System.out.println(data4);
    }
}
