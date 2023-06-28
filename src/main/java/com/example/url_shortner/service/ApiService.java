package com.example.url_shortner.service;

import com.example.url_shortner.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Random;

@Service
public class ApiService {
    @Autowired
    private ApiRepository repository;
    private final Random random = new Random();
    private void addTrade(@RequestBody String body){
        System.out.println(body);
    }

    private String getLongToShortKey(String url, Integer clientId){
        return url + "$" + clientId;
    }
    private String getShortUrlHash() {
        StringBuilder builder = new StringBuilder();
        String encodeVal = "abcdefghijklmnopqrstuvwxyz";
        for(int i=0;i<8;i++){
            builder.append(encodeVal.charAt(random.nextInt(26)));
        }
        String code  = builder.toString();
        if(repository.isShortUrlPresent(code)) return getShortUrlHash();
        return code;
    }
    public String getShortUrl(String url, Integer clientId) {
        String key = getLongToShortKey(url, clientId);
        if(repository.isLongUrlPresent(key)){
            return repository.getLongToShort(key);
        }

        String code = getShortUrlHash();
        repository.addLongToShort(key, code);
        repository.addShortToLong(code, key);
        return code;
    }

    public String getLongUrl(String url){
        if(!repository.isShortUrlPresent(url)){
            return "Invalid Url";
        }

        String val = repository.getShortToLongUrl(url);
        return val.split("\\$")[0];
    }
}
