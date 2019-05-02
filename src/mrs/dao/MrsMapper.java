package mrs.dao;

import java.util.List;

import mrs.vo.Account;
import mrs.vo.Theater;

/*
 *  mrsMapper.xml 사용 메서드 정의
 *  메소드 명이 mrsMapper.xml 안에 있는 SQL문의 id와 같아야 함
 */
public interface MrsMapper {
	
	public List<Account> getAccountAll(); // 모든 계정 정보를 담은 리스트를 반환함
	public List<Theater> getATheaterAll(); // 모든 상영관 정보를 담은 리스트를 반환함
	public Account searchAccountForId(String id); // id로 검색한 계정을 반환함
	public Theater searchTheaterForTheaterName(String theaterName); // 상영관 이름으로 상영관을 검색하여 반환함
	public int insertMember(Account account); // 회원 계정을 생성하여 DB에 추가
	public int insertManager(Account account); // 관리자 계정을 생성하여 DB에 추가
	public int insertTheater(Theater theater); // 새로운 상영관 정보를 DB에 추가
	public int deleteAccount(String id); // 해당 아이디의 계정을 삭제함
	public int deleteTheater(String theaterName); // 해당 이름의 상영관을 삭제함
	
}
