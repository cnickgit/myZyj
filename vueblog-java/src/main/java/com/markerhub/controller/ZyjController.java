package com.markerhub.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@RestController
public class ZyjController {

    @GetMapping(value = "/zyjLogin")
    public String zyjLog(@RequestParam("cookies") String cookie){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://139.159.141.200/app/superscan/op.jsp";
        HttpHeaders headers = new HttpHeaders();
        List<String> cookies =new ArrayList<String>();
        /* 登录获取Cookie 这里是直接给Cookie，可使用下方的login方法拿到Cookie给入*/
        cookies.add(cookie);       //在 header 中存入cookies
        headers.put(HttpHeaders.COOKIE,cookies);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("m", "login");
        map.add("username", "13868612368");
        map.add("password", "gl112233");
        map.add("parcame", "ajax");
        map.add("type", "1");
        map.add("origin", "cktoolApp");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );
        System.out.println(response.getHeaders().get("Set-Cookie").get(0));
        System.out.println(response.getBody());
        return response.getBody()+"zyj";
    }
    @GetMapping(value = "/search")
    public String zySearch(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://139.159.141.200/app/superscanPH/opQuery.jsp";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("m", "sAliim");
        map.add("ifQBase", "true");
        map.add("ifQReport", "true");
        map.add("judgeAnother", "true");
        map.add("aliim", "aa");
        map.add("c", "nznd");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );
        System.out.println(response.getHeaders().get("Set-Cookie").get(0));
        System.out.println(response.getBody());
        return response.getBody();
    }
}
