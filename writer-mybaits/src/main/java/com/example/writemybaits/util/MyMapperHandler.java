package com.example.writemybaits.util;

import com.example.writemybaits.service.UserMapper;
import com.example.writemybaits.service.UserMapperXml;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyMapperHandler<T> implements InvocationHandler {
    private Sqlsession sqlsession = null;

    public MyMapperHandler(Sqlsession sqlsession){
        this.sqlsession = sqlsession;
    }

    @Override
    public Object invoke(Object proxy, Method method,Object[] args)throws Throwable{
        System.out.println("运行invoke方法");
        System.out.println(method.getDeclaringClass().getName());
        System.out.println("args "+args[0]);
        if(method.getDeclaringClass().getName().equals(UserMapperXml.namespate)){
            String sql = UserMapperXml.map.get(method.getName());
            System.out.println(sql);
            return sqlsession.selectOne(sql,String.valueOf(args[0]));
        }
        return null;
    }
}
