package mrs.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mrs.vo.Account;
import mrs.vo.Theater;

public class MrsDAO {

	// 데이터베이스 정보를 MybatisConfig에서 가져오기
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	private SqlSession session = null; // SQL 구문을 담는 객체

	// 모든 계정 정보를 담은 리스트를 반환함
	public Object[][] getAccountAll() {
		List<Account> accList = null; // DB로부터 데이터를 입력받을 리스트
		Object[][] accArray = null; // 데이터를 JTable에 입력하기 위한 2차원 배열 (accList에서 변환하여 저장)
		session = null; // SQL 구문을 담는 객체

		// DB에서 데이터를 읽어 accList에 저장
		try {
			// SQLSessionFactory 데이터베이스를 연결
			session = factory.openSession();
			// Mapper Interface를 읽어들여서 Interface 안에 있는 SQL구문을 담는 작업
			MrsMapper mapper = session.getMapper(MrsMapper.class);

			accList = mapper.getAccountAll(); // SQL문 실행
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 데이터베이스 연결을 했던 자원을 반환 -> 메모리 손실 줄이기
			if (session != null)
				session.close();
		}

		// accList의 데이터를 object[][]로 변환하여 accArray에 저장
		accArray = new Object[accList.size()][8];
		for (int i = 0; i < accArray.length; i++) {
			accArray[i] = accList.get(i).toObject();
		}

		return accArray;
	}

	// 모든 상영관 정보를 담은 리스트를 반환함
	public Object[][] getATheaterAll() {
		List<Theater> theaterList = null; // DB로부터 데이터를 입력받을 리스트
		Object[][] theaterArray = null; // 데이터를 JTable에 입력하기 위한 2차원 배열 (accList에서 변환하여 저장)
		session = null; // SQL 구문을 담는 객체

		// DB에서 데이터를 읽어 accList에 저장
		try {
			// SQLSessionFactory 데이터베이스를 연결
			session = factory.openSession();
			// Mapper Interface를 읽어들여서 Interface 안에 있는 SQL구문을 담는 작업
			MrsMapper mapper = session.getMapper(MrsMapper.class);

			theaterList = mapper.getATheaterAll(); // SQL문 실행
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 데이터베이스 연결을 했던 자원을 반환 -> 메모리 손실 줄이기
			if (session != null)
				session.close();
		}

		// theaterList의 데이터를 object[][]로 변환하여 theaterArray에 저장
		theaterArray = new Object[theaterList.size()][2];
		for (int i = 0; i < theaterArray.length; i++) {
			theaterArray[i] = theaterList.get(i).toObject();
		}

		return theaterArray;
	}

	// id로 검색한 계정을 반환함
	public Account searchAccountForId(String id) {
		Account searchedAcc = null; // SELECT 구문으로 반환된 값을 담는 객체
		session = null; // SQL 구문을 담는 객체

		try {
			// SQLSessionFactory 데이터베이스를 연결
			session = factory.openSession();
			// Mapper Interface를 읽어들여서 Interface 안에 있는 SQL구문을 담는 작업
			MrsMapper mapper = session.getMapper(MrsMapper.class);

			searchedAcc = mapper.searchAccountForId(id); // SQL문 실행
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 데이터베이스 연결을 했던 자원을 반환 -> 메모리 손실 줄이기
			if (session != null)
				session.close();
		}

		return searchedAcc;
	}
	
	// 상영관 이름으로 상영관을 검색하여 반환함
	public Theater searchTheaterForTheaterName(String theaterName) {
		Theater searchedTheater = null; // SELECT 구문으로 반환된 값을 담는 객체
		session = null; // SQL 구문을 담는 객체

		try {
			// SQLSessionFactory 데이터베이스를 연결
			session = factory.openSession();
			// Mapper Interface를 읽어들여서 Interface 안에 있는 SQL구문을 담는 작업
			MrsMapper mapper = session.getMapper(MrsMapper.class);

			searchedTheater = mapper.searchTheaterForTheaterName(theaterName); // SQL문 실행
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 데이터베이스 연결을 했던 자원을 반환 -> 메모리 손실 줄이기
			if (session != null)
				session.close();
		}

		return searchedTheater;
	}

	// 새로운 회원 계정을 DB에 추가
	public boolean insertMember(Account account) {
		SqlSession session = null;
		int cnt = 0;

		try {
			session = factory.openSession();
			MrsMapper mapper = session.getMapper(MrsMapper.class);
			cnt = mapper.insertMember(account);

			session.commit();
		} catch (Exception e) {
			System.out.println("회원 계정 등록을 실패했습니다." + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		if (cnt == 0) {
			return false;
		} else {
			return true;
		}
	}

	// 새로운 관리자 계정을 DB에 추가
	public boolean insertManager(Account account) {
		SqlSession session = null;
		int cnt = 0;

		try {
			session = factory.openSession();
			MrsMapper mapper = session.getMapper(MrsMapper.class);
			cnt = mapper.insertManager(account);

			session.commit();
		} catch (Exception e) {
			System.out.println("관리자 계정 등록을 실패했습니다." + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		if (cnt == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	// 새로운 상영관 정보를 DB에 추가
	public boolean insertTheater(Theater theater) {
		SqlSession session = null;
		int cnt = 0;

		try {
			session = factory.openSession();
			MrsMapper mapper = session.getMapper(MrsMapper.class);
			cnt = mapper.insertTheater(theater);

			session.commit();
		} catch (Exception e) {
			System.out.println("상영관 정보 등록을 실패했습니다." + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		if (cnt == 0) {
			return false;
		} else {
			return true;
		}
	}

	// 해당 아이디의 계정을 삭제함
	public boolean deleteAccount(String id) {
		session = null;
		int cnt = 0;

		try {
			session = factory.openSession();
			MrsMapper mapper = session.getMapper(MrsMapper.class);
			cnt = mapper.deleteAccount(id);

			session.commit();
		} catch (Exception e) {
			System.out.println("계정 삭제를 실패했습니다." + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		if (cnt == 0) {
			return false;
		} else {
			return true;
		}
	}

	// 해당 이름의 상영관을 삭제함
	public boolean deleteTheater(String theaterName) {
		session = null;
		int cnt = 0;

		try {
			session = factory.openSession();
			MrsMapper mapper = session.getMapper(MrsMapper.class);
			cnt = mapper.deleteTheater(theaterName);

			session.commit();
		} catch (Exception e) {
			System.out.println("상영관 삭제를 실패했습니다." + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		if (cnt == 0) {
			return false;
		} else {
			return true;
		}
	}

}
