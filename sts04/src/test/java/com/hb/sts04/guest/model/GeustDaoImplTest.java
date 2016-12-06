package com.hb.sts04.guest.model;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

public class GeustDaoImplTest {
	
	private static SqlSession session;
	
	@BeforeClass
	public static void textBefore() throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
	}
	
	@Test
	public void testSelectAll() {
		List<GuestVo> list = session.selectList("guest.selectAll");
		assertNotNull(list);
		for(GuestVo bean:list){
			System.out.println(bean);
		}
	}

}
