package com.example.writemybaits.util;

/**
 * @author Jet
 * 创建一个执行器
 */
public interface Excutor {
    public <T> T query(String statement,Object parameter);
}
