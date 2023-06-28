package com.example.url_shortner.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ApiRepository {
    private final HashMap<String, String> longToShort;
    private final HashMap<String,String> shortToLong;
    {
        longToShort = new HashMap<>();
        shortToLong = new HashMap<>();
    }

    public boolean isShortUrlPresent(String url){
        return shortToLong.containsKey(url);
    }

    public boolean isLongUrlPresent(String url){
        return longToShort.containsKey(url);
    }

    public String getShortToLongUrl(String url){
        return shortToLong.get(url);
    }

    public String getLongToShort(String url){
        return longToShort.get(url);
    }

    public void addLongToShort(String key, String code) {
        longToShort.put(key, code);
    }

    public void addShortToLong(String code, String key) {
        shortToLong.put(code, key);
    }
}
