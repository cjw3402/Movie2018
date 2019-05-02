package mrs.vo;

import java.sql.Date;
import java.util.List;

/*
 * 티켓 결제 정보를 저장하는 클래스
 */
public class Payment {

	private int paymentCode; // 결제 코드
	private String userID; // 사용자 아이디
	private String paymentMethod; // 결제 방법
	private Date paymentDateTime; // 결제일 (yyyy/mm/dd hh24:mi)
	private List<Ticket> ticketList; // 결제한 티켓 정보를 가지는 리스트
	private int totalPrice; // 총 가격
	private int usedMileage; // 사용한 마일리지
	private int finalPrice; // 최종 가격

	public Payment() {
	}

	public Payment(int paymentCode, String userID, String paymentMethod
			, Date paymentDateTime, List<Ticket> ticketList, int totalPrice
			, int usedMileage, int finalPrice) {
		this.paymentCode = paymentCode;
		this.userID = userID;
		this.paymentMethod = paymentMethod;
		this.paymentDateTime = paymentDateTime;
		this.ticketList = ticketList;
		this.totalPrice = totalPrice;
		this.usedMileage = usedMileage;
		this.finalPrice = finalPrice;
	}

	public int getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(int paymentCode) {
		this.paymentCode = paymentCode;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Date getPaymentDate() {
		return paymentDateTime;
	}

	public void setPaymentDate(Date paymentDateTime) {
		this.paymentDateTime = paymentDateTime;
	}

	public List<Ticket> getTicketList() {
		return ticketList;
	}

	public void setTicketList(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getUsedMileage() {
		return usedMileage;
	}

	public void setUsedMileage(int usedMileage) {
		this.usedMileage = usedMileage;
	}

	public int getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(int finalPrice) {
		this.finalPrice = finalPrice;
	}

	@Override
	public String toString() {
		return "paymentCode: " + paymentCode + ", userID: " + userID
				+ ", paymentMethod: " + paymentMethod + ", paymentDateTime: "
				+ paymentDateTime + ", ticketList: " + ticketList
				+ ", totalPrice: " + totalPrice + ", usedMileage: "
				+ usedMileage + ", finalPrice: " + finalPrice;
	}

}
