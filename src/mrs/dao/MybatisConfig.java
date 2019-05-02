package mrs.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConfig {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	// static 초기화 블럭을 사용하게 되면 클래스가 실행될 때 최초 한 번만 실행하게 됨.
	static {	// Mybatis 환경설정 파일 정보를 담음
		String resource = "mybatis-config.xml";
		
		try {
			/* Reader 객체를 통해서 mybatis-config.xml 파일을 위에서부터 한 줄씩 읽어들여서
			 * 데이터베이스 접속 정보(오라클 SID, 계정 이름, 계정 비밀번호 등)을
			 * SqlSessionFactory 객체에 넣는다.
			*/
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
}
