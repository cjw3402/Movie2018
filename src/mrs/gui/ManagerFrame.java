package mrs.gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import mrs.dao.MrsDAO;

public class ManagerFrame {

	private MrsDAO dao;
	private JFrame managerFrame;
	private JTabbedPane tabbedPane;
	
	private AccountTabPanel accountTabPanel;
	private AddAccountPanel addAccountPanel;
	
//	private MovieListPanel movieListPanel;
	
	private TheaterTabPanel theaterTabPanel;
	private AddTheaterPanel addTheaterPanel;

	private JPanel movieListPanel, showingSchedulePanel, paymentStatePanel, ticketListPanel;
	private JButton btn2, btn3, btn4, btn5, btn6;

	public ManagerFrame(MrsDAO dao) {

		this.dao = dao;
		frameSetting();

	}
	
	public MrsDAO getDao() {
		return dao;
	}
	
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	
	public AddAccountPanel getAddAccountPanel() {
		return addAccountPanel;
	}
	
	public AccountTabPanel getAccountTabPanel() {
		return accountTabPanel;
	}

	public TheaterTabPanel getTheaterTabPanel() {
		return theaterTabPanel;
	}
	
	public AddTheaterPanel getAddTheaterPanel() {
		return addTheaterPanel;
	}

	private void frameSetting() {

		managerFrame = new JFrame();
		managerFrame.setTitle("MRS - 관리자 모드");
		managerFrame.setBounds(0, 0, 1000, 600);


		// tabbedPane 생성 및 세팅
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 994, 565);
		tabbedPane.setVisible(true);
		managerFrame.getContentPane().add(tabbedPane);

		accountTabPanel = new AccountTabPanel(this); // tab1 세팅
		tabbedPane.add(accountTabPanel, " 계정 목록 ");
		addAccountPanel = new AddAccountPanel(this); // 계정 추가 패널 세팅
		managerFrame.add(addAccountPanel);

		movieListPanelSetting(); // tab2 세팅
		
		theaterTabPanel = new TheaterTabPanel(this); // tab3 세팅
		tabbedPane.add(theaterTabPanel, " 상영관 정보 ");
		addTheaterPanel = new AddTheaterPanel(this); // 상영관 추가 패널 세팅
		managerFrame.add(addTheaterPanel);
		
		showingSchedulePanelSetting(); // tab4 세팅
		paymentStatePanelSetting(); // tab5 세팅
		ticketListPanelSetting(); // tab6 세팅

		managerFrame.setResizable(false); // 화면 크기 고정시킴
		managerFrame.setLocationRelativeTo(null); // 화면 중앙에 생성
		managerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료시 프로세스도 종료
		managerFrame.getContentPane().setLayout(null);
		managerFrame.setVisible(true);

	}

	private void movieListPanelSetting() {

		// tab1 생성 및 세팅
		movieListPanel = new JPanel();
		movieListPanel.setBounds(0, 0, 794, 565);
		movieListPanel.setLayout(null);
		tabbedPane.add(movieListPanel, " 영화 목록 ");

		// lbl1 생성 및 세팅
		btn2 = new JButton("2");
		btn2.setBounds(150, 20, 200, 50);
		btn2.setHorizontalAlignment(SwingConstants.CENTER);
		btn2.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		movieListPanel.add(btn2);

	}
	
	private void showingSchedulePanelSetting() {

		// tab1 생성 및 세팅
		showingSchedulePanel = new JPanel();
		showingSchedulePanel.setBounds(0, 0, 794, 565);
		showingSchedulePanel.setLayout(null);
		tabbedPane.add(showingSchedulePanel, " 상영 일정 ");

		// lbl1 생성 및 세팅
		btn4 = new JButton("4");
		btn4.setBounds(150, 20, 200, 50);
		btn4.setHorizontalAlignment(SwingConstants.CENTER);
		btn4.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		showingSchedulePanel.add(btn4);

	}

	private void paymentStatePanelSetting() {

		// tab1 생성 및 세팅
		paymentStatePanel = new JPanel();
		paymentStatePanel.setBounds(0, 0, 794, 565);
		paymentStatePanel.setLayout(null);
		tabbedPane.add(paymentStatePanel, " 결제 현황 ");

		// lbl1 생성 및 세팅
		btn5 = new JButton("5");
		btn5.setBounds(150, 20, 200, 50);
		btn5.setHorizontalAlignment(SwingConstants.CENTER);
		btn5.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		paymentStatePanel.add(btn5);

	}

	private void ticketListPanelSetting() {

		// tab1 생성 및 세팅
		ticketListPanel = new JPanel();
		ticketListPanel.setBounds(0, 0, 794, 565);
		ticketListPanel.setLayout(null);
		tabbedPane.add(ticketListPanel, " 티켓 목록 ");

		// lbl1 생성 및 세팅
		btn6 = new JButton("6");
		btn6.setBounds(150, 20, 200, 50);
		btn6.setHorizontalAlignment(SwingConstants.CENTER);
		btn6.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		ticketListPanel.add(btn6);

	}

}
