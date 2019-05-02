package mrs.vo;

/*
 * 상영관 정보를 가지는 클래스
 */
public class Theater {

	private String theaterName; // 상영관 이름
	private int theaterType; // 상영관 타입

	public Theater() {
	}

	public Theater(String theaterName, int theaterType) {
		this.theaterName = theaterName;
		this.theaterType = theaterType;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public int getTheaterType() {
		return theaterType;
	}

	public void setTheaterType(int theaterType) {
		this.theaterType = theaterType;
	}

	@Override
	public String toString() {
		return "theaterName: " + theaterName + ", theaterType: " + theaterType;
	}

	public Object[] toObject() {
		Object[] object = new Object[] { theaterName, theaterType };

		return object;
	}

}
