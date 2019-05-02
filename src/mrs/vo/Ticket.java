package mrs.vo;

import java.sql.Date;

/*
 * 티켓 정보를 가지는 클래스
 */
public class Ticket {

	private int ticketCode; // 티켓 코드
	private String movieTitle; // 영화 제목
	private String rating; // 관람 등급
	private Date showingDateTime; // 상영시간 (yyyy/mm/dd hh24:mi)
	private String theaterName; // 상영관 이름
	private String seatNumber; // 좌석 번호
	private int ticketPrice; // 티켓 가격

	public Ticket() {
	}

	public Ticket(int ticketCode, String movieTitle, String rating
			, Date showingDateTime , String theaterName, String seatNumber
			, int ticketPrice) {
		this.ticketCode = ticketCode;
		this.movieTitle = movieTitle;
		this.rating = rating;
		this.showingDateTime = showingDateTime;
		this.theaterName = theaterName;
		this.seatNumber = seatNumber;
		this.ticketPrice = ticketPrice;
	}

	public int getTicketCode() {
		return ticketCode;
	}

	public void setTicketCode(int ticketCode) {
		this.ticketCode = ticketCode;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Date getShowingDate() {
		return showingDateTime;
	}

	public void setShowingDate(Date showingDateTime) {
		this.showingDateTime = showingDateTime;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	@Override
	public String toString() {
		return "ticketCode: " + ticketCode + ", movieTitle: " + movieTitle
				+ ", rating: " + rating + ", showingDateTime: " + showingDateTime
				+ ", theaterName: " + theaterName + ", seatNumber: " + seatNumber
				+ ", ticketPrice: " + ticketPrice;
	}

}
