package mrs.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import mrs.dao.MrsDAO;
import mrs.vo.Account;

public class LoginFrame {

	private JFrame loginFrame;
	private MrsDAO dao; // DB를 관리하는 객체

	private JTextField inputId; // 아이디를 입력받을 텍스트 필드
	private JPasswordField inputPW; // 비밀번호를 입력받을 패스워드 필드
	private JButton loginBtn, signupBtn; // 버튼

	public LoginFrame() {

		dao = new MrsDAO();
		frameSetting();

	}

	private void frameSetting() {
		// 이미지 파일 경로 저장
		String backgroundImagePath = "./image/login_background.jpg";
		String loginBtnImagePath = "./image/login_btn.jpg";
		String pressedLoginBtnImagePath = "./image/login_btn_click.jpg";
		String signupBtnImagePath = "./image/signup_btn.jpg";
		String pressedSignupBtnImagePath = "./image/signup_btn_click.jpg";

		loginFrame = new JFrame();
		loginFrame.setTitle("영화 예매&관리 시스템 로그인");

		// loginPanel 생성 및 세팅
		ImagePanel loginPanel = new ImagePanel(new ImageIcon(backgroundImagePath).getImage());
		loginFrame.setSize(loginPanel.getWidth(), loginPanel.getHeight());
		loginFrame.add(loginPanel);

		// lblLogIn 생성 및 세팅
		JLabel lblLogIn = new JLabel("Log In");
		lblLogIn.setFont(new Font("Tahoma", Font.BOLD, 48));
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setBounds(360, 34, 371, 61);
		loginPanel.add(lblLogIn);

		// lblID 생성 및 세팅
		JLabel lblId = new JLabel("아 이 디");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("바탕체", Font.BOLD, 30));
		lblId.setBounds(328, 130, 180, 40);
		loginPanel.add(lblId);

		// lblPassword 생성 및 세팅
		JLabel lblPW = new JLabel("비밀번호");
		lblPW.setHorizontalAlignment(SwingConstants.CENTER);
		lblPW.setFont(new Font("바탕체", Font.BOLD, 30));
		lblPW.setBounds(328, 195, 180, 40);
		loginPanel.add(lblPW);

		// inputId 생성 및 세팅
		inputId = new JTextField();
		inputId.setFont(new Font("바탕체", Font.BOLD, 30));
		inputId.setBounds(499, 130, 250, 40);
		inputId.setColumns(10);
		loginPanel.add(inputId);
		inputId.addActionListener(new ActionListener() { // 엔터 누르면 로그인 시도
			@Override
			public void actionPerformed(ActionEvent e) {
				tryLogin();
			}
		});

		// inputPassword 생성 및 세팅
		inputPW = new JPasswordField();
		inputPW.setFont(new Font("바탕체", Font.PLAIN, 30));
		inputPW.setColumns(10);
		inputPW.setBounds(499, 195, 250, 40);
		loginPanel.add(inputPW);
		inputPW.addActionListener(new ActionListener() { // 엔터 누르면 로그인 시도
			@Override
			public void actionPerformed(ActionEvent e) {
				tryLogin();
			}
		});

		// loginBtn 생성 및 세팅
		loginBtn = new JButton();
		loginBtn.setIcon(new ImageIcon(loginBtnImagePath));
		loginBtn.setPressedIcon(new ImageIcon(pressedLoginBtnImagePath));
		loginBtn.setBounds(574, 271, 117, 37);
		loginPanel.add(loginBtn);
		loginBtn.addActionListener(new ActionListener() { // 로그인 버튼 이벤트 처리
			@Override
			public void actionPerformed(ActionEvent e) {
				tryLogin();
			}
		});

		// signupBtn 생성 및 세팅
		signupBtn = new JButton();
		signupBtn.setIcon(new ImageIcon(signupBtnImagePath));
		signupBtn.setPressedIcon(new ImageIcon(pressedSignupBtnImagePath));
		signupBtn.setBounds(405, 271, 117, 37);
		loginPanel.add(signupBtn);
		signupBtn.addActionListener(new ActionListener() { // 회원가입 버튼 이벤트 처리
			@Override
			public void actionPerformed(ActionEvent e) {
				trySignup();
			}
		});
		
		loginFrame.setResizable(false); // 화면 크기 고정시킴
		loginFrame.setLocationRelativeTo(null); // 화면 중앙에 생성
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료시 프로세스도 종료
		loginFrame.getContentPane().setLayout(null);
		loginFrame.setVisible(true);

	}

	// 로그인 버튼 클릭 시 실행
	private void tryLogin() {

		try {
			String id = inputId.getText();
			char[] pw = inputPW.getPassword();
			Account searchedAcc = dao.searchAccountForId(id);

			if (id == null || id.length() == 0) {
				JOptionPane.showMessageDialog(null, "아이디를 입력하세요.");
			} else if (pw == null || pw.length == 0) {
				JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.");
			} else if (id.equals(searchedAcc.getId()) && !Arrays.equals(pw, searchedAcc.getPassword().toCharArray())) {
				JOptionPane.showMessageDialog(null, "비밀번호가 잘못 입력되었습니다.");
			} else if (id.equals(searchedAcc.getId()) && Arrays.equals(pw, searchedAcc.getPassword().toCharArray())) {
				JOptionPane.showMessageDialog(null, "로그인 성공!");
				if (searchedAcc.getIsAdmin() == 'Y') {
					new ManagerFrame(dao);
					loginFrame.dispose();
				} else if (searchedAcc.getIsAdmin() == 'N') {
					new MemberFrame(dao);
					loginFrame.dispose();
				}
			}
		} catch (NullPointerException npe) {
			JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다.");
		}

	}

	// 회원가입 버튼 클릭 시 실행
	private void trySignup() {

		inputId.setText(null);
		inputPW.setText(null);
		loginFrame.dispose();
		new MemberSignupFrame(dao);

	}

}
