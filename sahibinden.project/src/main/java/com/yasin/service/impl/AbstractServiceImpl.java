package com.yasin.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yasin.POJO.AbstractCoin;
import com.yasin.POJO.SCoin;
import com.yasin.service.AbstractService;
import com.yasin.utilities.NetworkUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractServiceImpl<T extends AbstractCoin> implements AbstractService<T> {

    @Autowired
    NetworkUtil networkUtil;
    List<T> items;
    T item;
    private final static double Euro = 5.0;
    private final static double Dolar = 4.0;
    private final static double Tl = 1.0;
    private final static double Yen = 0.5;
    public double converter(boolean flag, String type, double value) {
        if(type.compareTo("Euro")==0){
            if(flag){
                return (value/Dolar)*Euro;
            }
            else{
                return (value/Euro)*Dolar;
            }
        }
        else if(type.compareTo("Tl")==0){
            if(flag){
                return (value/Dolar)*Tl;
            }
            else{
                return (value/Tl)*Dolar;
            }
        }
        else if(type.compareTo("Yen")==0){
            if(flag){
                return (value/Dolar)*Yen;
            }
            else{
                return (value/Yen)*Dolar;
            }
        }
        else if(type.compareTo("Dolar")==0){
            return value;
        }

        return 0;
    }

    public T getCurrent() {

        item = new Gson().fromJson(networkUtil.networkService("ticker"), new TypeToken<SCoin>() {}.getType());
        return item;
    }

    public List<T> getAll() {
        items = new Gson().fromJson(networkUtil.networkService("history"), new TypeToken<ArrayList<SCoin>>() {}.getType());
        return items;
    }

}
