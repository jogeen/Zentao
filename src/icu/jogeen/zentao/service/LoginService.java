package icu.jogeen.zentao.service;

import com.google.gson.Gson;
import icu.jogeen.zentao.model.Account;
import icu.jogeen.zentao.model.SessionResult;
import icu.jogeen.zentao.model.User;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author jogeen
 * @Date 11:17 2021/6/4
 * @Version v1.0
 * @Description
 */
public class LoginService {
    public static SessionResult getSession() {
        try {
            ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://demo15.zentao.net/api-getsessionid.json", String.class);
            HttpStatus statusCode = forEntity.getStatusCode();
            if (statusCode.is2xxSuccessful()) {
                String bodyJson = forEntity.getBody();
                Map map = new Gson().fromJson(bodyJson, Map.class);
                String data = (String) map.get("data");
                SessionResult sessionResult = new Gson().fromJson(data, SessionResult.class);
                return sessionResult;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static User login(SessionResult sessionResult, Account account) {
        Gson gson = new Gson();

        String url = String.format("http://demo15.zentao.net/user-login.json?%s=%s", sessionResult.getSessionName(), sessionResult.getSessionID());

        MultiValueMap<String, String> params = new LinkedMultiValueMap();
        params.add("account", account.getUsername());
        params.add("password", account.getPassword());

        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpMethod method = HttpMethod.POST;
        // 以表单的方式提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //将请求头部和参数合成一个请求
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
        //执行HTTP请求，将返回的结构使用ResultVO类格式化
        ResponseEntity<String> response = client.exchange(url, method, requestEntity, String.class);
        User user = null;
        if (response.getStatusCode().is2xxSuccessful()) {
            String body = response.getBody();
            Map map = gson.fromJson(body, Map.class);
            user = gson.fromJson(gson.toJson(map.get("user")), User.class);
        }
        return user;
    }


    public static void main(String[] args) {
        SessionResult session = getSession();
        Account account = new Account();
        account.setUsername("demo");
        account.setPassword("123456");
        User user = login(session, account);
        System.out.println(user);
    }


}
