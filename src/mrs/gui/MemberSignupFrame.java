package mrs.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import mrs.dao.MrsDAO;
import mrs.vo.Account;

public class MemberSignupFrame {

	private JFrame signupFrame;
	private MrsDAO dao;

	private JTextField signupId, signupName, signupTel, signupBirth; // 다양한 값을 받을 텍스트 필드
	private JPasswordField signupPassword, signupPasswordCheck; // 비밀번호를 입력받을 패스워드 필드
	private JButton addAccountBtn, goBackBtn; // 버튼

	public MemberSignupFrame(MrsDAO dao) {
		this.dao = dao;
		frameSetting();

	}

	private void frameSetting() {
		signupFrame = new JFrame();
		signupFrame.setTitle("회원가입");
		signupFrame.setSize(500, 550);
		

		// signupPanel 생성 및 세팅
		JPanel signupPanel = new JPanel();
		signupPanel.setBackground(Color.WHITE);
		signupPanel.setBounds(0, 0, signupFrame.getWidth(), signupFrame.getHeight());
		signupPanel.setLayout(null);
		signupFrame.getContentPane().add(signupPanel);

		// lblTitle 생성 및 세팅
		JLabel lblTitle = new JLabel("회원가입");
		lblTitle.setBounds(150, 20, 200, 50);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		signupPanel.add(lblTitle);

		// lblId 생성 및 세팅
		JLabel lblId = new JLabel("아    이   디");
		lblId.setBounds(75, 110, 120, 30);
		lblId.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		signupPanel.add(lblId);

		// lblPW 생성 및 세팅
		JLabel lblPW = new JLabel("비  밀  번  호");
		lblPW.setBounds(75, 160, 120, 30);
		lblPW.setHorizontalAlignment(SwingConstants.CENTER);
		lblPW.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		signupPanel.add(lblPW);

		// lblName 생성 및 세팅
		JLabel lblName = new JLabel("이           름");
		lblName.setBounds(75, 260, 120, 30);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		signupPanel.add(lblName);

		// lblTel 생성 및 세팅
		JLabel lblTel = new JLabel("전  화  번  호");
		lblTel.setBounds(75, 310, 120, 30);
		lblTel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		signupPanel.add(lblTel);

		// lblPWCheck 생성 및 세팅
		JLabel lblPWCheck = new JLabel("비밀번호확인");
		lblPWCheck.setBounds(75, 210, 120, 30);
		lblPWCheck.setHorizontalAlignment(SwingConstants.CENTER);
		lblPWCheck.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		signupPanel.add(lblPWCheck);

		// signupId 생성 및 세팅
		signupId = new JTextField();
		signupId.setBounds(205, 110, 200, 30);
		signupId.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		signupId.setColumns(10);
		signupPanel.add(signupId);

		// signupPassword 생성 및 세팅
		signupPassword = new JPasswordField();
		signupPassword.setBounds(205, 160, 200, 30);
		signupPassword.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		signupPassword.setColumns(10);
		signupPanel.add(signupPassword);

		// signupPasswordCheck 생성 및 세팅
		signupPasswordCheck = new JPasswordField();
		signupPasswordCheck.setBounds(205, 210, 200, 30);
		signupPasswordCheck.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		signupPasswordCheck.setColumns(10);
		signupPanel.add(signupPasswordCheck);

		// signupName 생성 및 세팅
		signupName = new JTextField();
		signupName.setBounds(205, 260, 200, 30);
		signupName.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		signupName.setColumns(10);
		signupPanel.add(signupName);

		// signupTel 생성 및 세팅
		signupTel = new JTextField();
		signupTel.setBounds(205, 310, 200, 30);
		signupTel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		signupTel.setColumns(10);
		signupPanel.add(signupTel);

		// lblBirth 생성 및 세팅
		JLabel lblBirth = new JLabel("생  년  월  일");
		lblBirth.setBounds(75, 360, 120, 30);
		lblBirth.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirth.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		signupPanel.add(lblBirth);

		// signupBirth 생성 및 세팅
		signupBirth = new JTextField();
		signupBirth.setBounds(205, 360, 200, 30);
		signupBirth.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		signupBirth.setColumns(10);
		signupPanel.add(signupBirth);

		// addAccountBtn 생성 및 세팅
		addAccountBtn = new JButton("등    록");
		addAccountBtn.setBounds(125, 450, 100, 30);
		addAccountBtn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		signupPanel.add(addAccountBtn);
		addAccountBtn.addActionListener(new ActionListener() { // 입력받은 정보를 DB에 등록함
			public void actionPerformed(ActionEvent e) {
				addNewId();
			}
		});

		// goBackBtn 생성 및 세팅
		goBackBtn = new JButton("돌아가기");
		goBackBtn.setBounds(245, 450, 100, 30);
		goBackBtn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		signupPanel.add(goBackBtn);
		goBackBtn.addActionListener(new ActionListener() { // 로그인 화면으로 돌아가기
			public void actionPerformed(ActionEvent e) {
				comebackMain();
			}
		});

		JLabel lblTelEx = new JLabel("입력예시) 1984-03-22");
		lblTelEx.setForeground(Color.LIGHT_GRAY);
		lblTelEx.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelEx.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 14));
		lblTelEx.setBounds(205, 385, 200, 30);
		signupPanel.add(lblTelEx);

		signupFrame.getContentPane().add(signupPanel);
		signupFrame.setResizable(false); // 화면 크기 고정시킴
		signupFrame.setLocationRelativeTo(null); // 화면 중앙에 생성
		signupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료시 프로세스도 종료
		signupFrame.getContentPane().setLayout(null);
		signupFrame.setVisible(true);
	}

	// 입력받은 정보로 새 계정을 생성함
	private void addNewId() {
		try {
			String pwCheck = new String(signupPasswordCheck.getPassword(), 0, signupPasswordCheck.getPassword().length);

			Account insertAcc = new Account(); // 회원의 정보를 저장하는 Account
			insertAcc.setId(signupId.getText());
			insertAcc.setPassword(new String(signupPassword.getPassword(), 0, signupPassword.getPassword().length));
			insertAcc.setUserName(signupName.getText());
			insertAcc.setTel(signupTel.getText());
			insertAcc.setBirth(Date.valueOf(signupBirth.getText()));
			insertAcc.setMileage(0);

			if (insertAcc.getId() == null || insertAcc.getPassword() == null || insertAcc.getUserName() == null
					|| insertAcc.getTel() == null || insertAcc.getBirth() == null) {
				JOptionPane.showMessageDialog(null, "모든 정보를 입력해주세요.");
			} else if (dao.searchAccountForId(insertAcc.getId()) != null) {
				JOptionPane.showMessageDialog(null, "아이디가 이미 존재합니다.");
			} else if (!insertAcc.getPassword().equals(pwCheck)) {
				JOptionPane.showMessageDialog(null, "비밀번호가 다릅니다.");
			} else if (insertAcc.getId() != null && insertAcc.getPassword() != null && insertAcc.getUserName() != null
					&& insertAcc.getTel() != null && insertAcc.getBirth() != null) {
				dao.insertMember(insertAcc);
				JOptionPane.showMessageDialog(null, "가입이 완료되었습니다.");
				comebackMain();
			} else {
				JOptionPane.showMessageDialog(null, "모든 정보를 입력해주세요.");
			}
		} catch (IllegalArgumentException iae) {
			JOptionPane.showMessageDialog(null, "생년월일 입력 형식을 맞춰주세요.");
		}

	}

	// 돌아가기 버튼 클릭 또는 회원가입 완료 시 실행
	private void comebackMain() {

		signupFrame.dispose();
		new LoginFrame();

	}
}
