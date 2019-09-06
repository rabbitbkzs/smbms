package com.githup.mybatis.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    //1.私有化构造
    private SqlSessionUtil(){};
    //2.提供静态的获取SqlSessionUtil的实例
    public static SqlSessionFactory sqlSessionFactory;
    //3.使用单例模式
    public static SqlSessionFactory getSqlSessionFactoryInstence() throws IOException {
        if (sqlSessionFactory == null){
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        }
        return sqlSessionFactory;
    }
    //4.获取sqlSession
    public static SqlSession getSqlSession() throws IOException {
        return  getSqlSessionFactoryInstence().openSession(false);
    }

    //5.编写关流的操作
    public static void closeSqlSession(SqlSession sqlSession){
        sqlSession.close();
    }



}
