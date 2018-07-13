package com.zyq.com.zyq;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author zyq
 * @date 2018/7/13 9:47
 */
public class MyBatisUtil {
    /*保证sqlSessionFactory 是只有一份的，工厂只有一份*/

    private  static SqlSessionFactory sqlSessionFactory;

    static {
        /*1.读取mybatis.xml的配置文件*/
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*2.创建SqlSessionFactory*/
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

    public static SqlSession getSqlSession(boolean autoCommit){
        return sqlSessionFactory.openSession(autoCommit);
    }

    public  static  SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
