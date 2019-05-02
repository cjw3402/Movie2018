package mrs.vo;

import java.sql.Date;

/*
 * 상영 정보를 가지는 클래스
 */
public class Showing {

	private Movie movieInfo; // 영화 정보
	private Theater theaterInfo; // 상영관 정보
	private Date showingDateTime; // 상영시간 (yyyy/mm/dd hh24:mi)
	private int reservedSeatCount; // 예약된 좌석 수
	private int notReservedSeatCount; // 남은 좌석 수

	public Showing() {
	}

	public Showing(Movie movieInfo, Theater theaterInfo
			, Date showingDateTime, int reservedSeatCount,
			int notReservedSeatCount) {
		this.movieInfo = movieInfo;
		this.theaterInfo = theaterInfo;
		this.showingDateTime = showingDateTime;
		this.reservedSeatCount = reservedSeatCount;
		this.notReservedSeatCount = notReservedSeatCount;
	}

	public Movie getMovieInfo() {
		return movieInfo;
	}

	public void setMovieInfo(Movie movieInfo) {
		this.movieInfo = movieInfo;
	}

	public Theater getTheaterInfo() {
		return theaterInfo;
	}

	public void setTheaterInfo(Theater theaterInfo) {
		this.theaterInfo = theaterInfo;
	}

	public Date getShowingDateTime() {
		return showingDateTime;
	}

	public void setShowingDateTime(Date showingDateTime) {
		this.showingDateTime = showingDateTime;
	}

	public int getReservedSeatCount() {
		return reservedSeatCount;
	}

	public void setReservedSeatCount(int reservedSeatCount) {
		this.reservedSeatCount = reservedSeatCount;
	}

	public int getNotReservedSeatCount() {
		return notReservedSeatCount;
	}

	public void setNotReservedSeatCount(int notReservedSeatCount) {
		this.notReservedSeatCount = notReservedSeatCount;
	}

	@Override
	public String toString() {
		return "movieInfo: " + movieInfo + ", theaterInfo: " + theaterInfo
				+ ", showingDateTime: " + showingDateTime
				+ ", reservedSeatCount: " + reservedSeatCount
				+ ", notReservedSeatCount: " + notReservedSeatCount;
	}

}
