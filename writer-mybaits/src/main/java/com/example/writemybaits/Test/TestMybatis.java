package com.example.writemybaits.Test;

import com.example.writemybaits.domain.User;
import com.example.writemybaits.service.UserMapper;
import com.example.writemybaits.util.SimpleExcutor;
import com.example.writemybaits.util.Sqlsession;

public class TestMybatis {
    public static void main(String [] args){
        Sqlsession sqlsession = new Sqlsession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        User userById = mapper.getUserById("1");
        System.out.println(userById.getName());
    }
}
