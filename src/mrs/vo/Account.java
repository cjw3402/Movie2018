package mrs.vo;

import java.sql.Date;

/*
 * 계정 정보를 가지는 VO
 * Member, Manager의 부모 클래스
 */
public class Account {

	private String id; // 아이디
	private String password; // 계정 비밀번호
	private String userName; // 사용자 이름
	private String tel; // 전화번호
	private String email; // 이메일
	private Date birth; // 생년월일
	private int mileage; // 마일리지
	private char isAdmin; // 관리자 계정인지 식별하기 위한 변수 (Y, N)
	
	public Account() {
	}

	public Account(String id, String password, String userName, String tel
			, String email, Date birth, int mileage, char isAdmin) {
		this.id = id;
		this.password = password;
		this.userName = userName;
		this.tel = tel;
		this.email = email;
		this.birth = birth;
		this.mileage = mileage;
		this.isAdmin = isAdmin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public char getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(char isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "id: " + id + ", password: " + password + ", userName: "
				+ userName + ", tel: " + tel + ", email: " + email + ", birth: "
				+ birth + ", mileage: " + mileage + ", isAdmin: " + isAdmin;
	}
	
	public Object[] toObject() {
		Object[] object = new Object[] {id, password, userName, tel, email, birth, mileage, isAdmin};
		
		return object;
	}

}
