package com.example.writemybaits.util;

import java.lang.reflect.Proxy;



public class Sqlsession {
    private Excutor excutor = new SimpleExcutor();

    public <T> T selectOne(String statement,Object parameter){
        return excutor.query(statement,parameter);
    }

    public <T> T getMapper(Class<T> tClass){
        return (T) Proxy.newProxyInstance(tClass.getClassLoader(),new Class[]{tClass},new MyMapperHandler<>(this));
    }
}
