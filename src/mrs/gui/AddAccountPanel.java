package mrs.gui;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import mrs.vo.Account;

public class AddAccountPanel extends JPanel {

	private ManagerFrame managerFrame; // 이 Panel을 생성한 상위 Frame 객체

	private JPanel radioBtnPanel;
	private JRadioButton managerRadioBtn, memberRadioBtn;
	private ButtonGroup btnGroup;
	private JTextField idField, pwField, nameField, telField, emailField, birthField, mileageField;
	private JButton addAccountBtn, backBtn;

	public AddAccountPanel(ManagerFrame managerFrame) {
		this.managerFrame = managerFrame;

		panelSetting();

		managerRadioBtn.setSelected(true); // 관리자 입력 버튼이 선택된 상태로 초기화
		setManagerInput(); // 관리자 입력 활성화
	}

	private void panelSetting() {
		// addAccountPanel 생성 및 세팅
		setBackground(SystemColor.inactiveCaption);
		setBounds(0, 0, 994, 565);
		setLayout(null);
		setVisible(false);

		// addAccountPanelTitle 생성 및 세팅
		JLabel addAccountPanelTitle = new JLabel("새 계정 추가");
		addAccountPanelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		addAccountPanelTitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		addAccountPanelTitle.setBounds(150, 30, 200, 60);
		add(addAccountPanelTitle);

		// radioBtnPanel 생성 및 세팅
		radioBtnPanel = new JPanel();
		radioBtnPanel.setBorder(BorderFactory.createTitledBorder("계정 종류"));
		radioBtnPanel.setBackground(SystemColor.inactiveCaption);
		radioBtnPanel.setBounds(500, 30, 350, 60);
		radioBtnPanel.setLayout(null);
		add(radioBtnPanel);

		// managerRadioBtn 생성 및 세팅
		managerRadioBtn = new JRadioButton("관리자");
		managerRadioBtn.setBackground(SystemColor.inactiveCaption);
		managerRadioBtn.setBounds(50, 20, 100, 30);
		managerRadioBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		managerRadioBtn.setHorizontalAlignment(SwingConstants.CENTER);
		radioBtnPanel.add(managerRadioBtn);
		managerRadioBtn.addActionListener(new ActionListener() { // 버튼 클릭 시
			@Override
			public void actionPerformed(ActionEvent e) { // 관리자 정보 입력만 활성화
				setManagerInput();
			}
		});

		// memberRadioBtn 생성 및 세팅
		memberRadioBtn = new JRadioButton("고객");
		memberRadioBtn.setBackground(SystemColor.inactiveCaption);
		memberRadioBtn.setBounds(200, 20, 100, 30);
		memberRadioBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		memberRadioBtn.setHorizontalAlignment(SwingConstants.CENTER);
		radioBtnPanel.add(memberRadioBtn);
		memberRadioBtn.addActionListener(new ActionListener() { // 버튼 클릭 시
			@Override
			public void actionPerformed(ActionEvent e) { // 회원 정보 입력만 활성화
				setMemberInput();
			}
		});

		// btnGroup 생성 및 세팅
		btnGroup = new ButtonGroup();
		btnGroup.add(managerRadioBtn);
		btnGroup.add(memberRadioBtn);

		// lblId 생성 및 세팅
		JLabel lblId = new JLabel("아   이   디");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblId.setBounds(82, 139, 150, 40);
		add(lblId);

		// lblPw 생성 및 세팅
		JLabel lblPw = new JLabel("비 밀 번 호");
		lblPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblPw.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblPw.setBounds(532, 139, 150, 40);
		add(lblPw);

		// lblName 생성 및 세팅
		JLabel lblName = new JLabel("이        름");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblName.setBounds(82, 219, 150, 40);
		add(lblName);

		// lblTel 생성 및 세팅
		JLabel lblTel = new JLabel("전 화 번 호");
		lblTel.setHorizontalAlignment(SwingConstants.CENTER);
		lblTel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblTel.setBounds(532, 219, 150, 40);
		add(lblTel);

		// lblEmail 생성 및 세팅
		JLabel lblEmail = new JLabel("이  메  일");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblEmail.setBounds(82, 299, 150, 40);
		add(lblEmail);

		// lblBirth 생성 및 세팅
		JLabel lblBirth = new JLabel("생 년 월 일");
		lblBirth.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirth.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblBirth.setBounds(532, 299, 150, 40);
		add(lblBirth);

		// lblMileage 생성 및 세팅
		JLabel lblMileage = new JLabel("남은마일리지");
		lblMileage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMileage.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblMileage.setBounds(82, 379, 150, 40);
		add(lblMileage);

		// idField 생성 및 세팅
		idField = new JTextField();
		idField.setHorizontalAlignment(SwingConstants.CENTER);
		idField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		idField.setBounds(222, 139, 200, 40);
		idField.setColumns(10);
		add(idField);

		// pwField 생성 및 세팅
		pwField = new JTextField();
		pwField.setHorizontalAlignment(SwingConstants.CENTER);
		pwField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		pwField.setColumns(10);
		pwField.setBounds(672, 139, 200, 40);
		add(pwField);

		// nameField 생성 및 세팅
		nameField = new JTextField();
		nameField.setHorizontalAlignment(SwingConstants.CENTER);
		nameField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		nameField.setColumns(10);
		nameField.setBounds(222, 219, 200, 40);
		add(nameField);

		// telField 생성 및 세팅
		telField = new JTextField();
		telField.setHorizontalAlignment(SwingConstants.CENTER);
		telField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		telField.setColumns(10);
		telField.setBounds(672, 219, 200, 40);
		add(telField);

		// emailField 생성 및 세팅
		emailField = new JTextField();
		emailField.setHorizontalAlignment(SwingConstants.CENTER);
		emailField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		emailField.setColumns(10);
		emailField.setBounds(222, 299, 200, 40);
		add(emailField);

		// birthField 생성 및 세팅
		birthField = new JTextField();
		birthField.setHorizontalAlignment(SwingConstants.CENTER);
		birthField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		birthField.setColumns(10);
		birthField.setBounds(672, 299, 200, 40);
		add(birthField);

		// mileageField 생성 및 세팅
		mileageField = new JTextField();
		mileageField.setHorizontalAlignment(SwingConstants.CENTER);
		mileageField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		mileageField.setColumns(10);
		mileageField.setBounds(222, 379, 200, 40);
		add(mileageField);

		// addAccountBtn 생성 및 세팅
		addAccountBtn = new JButton("등    록");
		addAccountBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		addAccountBtn.setBounds(280, 480, 200, 50);
		add(addAccountBtn);
		addAccountBtn.addActionListener(new ActionListener() { // 버튼 클릭 시, 계정을 생성하고 이전으로 돌아감
			@Override
			public void actionPerformed(ActionEvent e) {
				if (managerRadioBtn.isSelected()) { // 관리자 계정 생성
					if (createManager()) {
						goback();
					}
				} else if (memberRadioBtn.isSelected()) { // 회원 계정 생성
					if (createMemeber()) {
						goback();
					}
				} else { // 오류
					JOptionPane.showMessageDialog(null, "계정 종류를 선택해 주세요.");
				}
			}
		});

		// backBtn 생성 및 세팅
		backBtn = new JButton("돌아가기");
		backBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		backBtn.setBounds(520, 480, 200, 50);
		add(backBtn);
		backBtn.addActionListener(new ActionListener() { // 버튼 클릭 시, 이전 화면으로 돌아감
			@Override
			public void actionPerformed(ActionEvent e) {
				goback();
			}
		});
	}

	// 관리자 계정을 생성하여 DB에 저장
	private boolean createManager() {
		try {
			Account insertAcc = new Account(); // 회원의 정보를 저장하는 Account
			insertAcc.setId(idField.getText());
			insertAcc.setPassword(pwField.getText());
			insertAcc.setUserName(nameField.getText());
			insertAcc.setTel(telField.getText());
			insertAcc.setEmail(emailField.getText());
			insertAcc.setIsAdmin('Y');

			if (insertAcc.getId() == null || insertAcc.getId().isEmpty() || insertAcc.getPassword() == null
					|| insertAcc.getPassword().isEmpty() || insertAcc.getUserName() == null
					|| insertAcc.getUserName().isEmpty() || insertAcc.getTel() == null || insertAcc.getTel().isEmpty()
					|| insertAcc.getEmail() == null || insertAcc.getEmail().isEmpty()) {
				JOptionPane.showMessageDialog(null, "모든 정보를 입력해주세요.");
			} else if (managerFrame.getDao().searchAccountForId(insertAcc.getId()) != null) {
				JOptionPane.showMessageDialog(null, "아이디가 이미 존재합니다.");
			} else if (insertAcc.getId() != null && insertAcc.getPassword() != null && insertAcc.getUserName() != null
					&& insertAcc.getTel() != null && insertAcc.getEmail() != null) {
				managerFrame.getDao().insertManager(insertAcc);
				managerFrame.getAccountTabPanel().addTableRow(insertAcc.toObject());
				JOptionPane.showMessageDialog(null, "관리자 계정 생성이 완료되었습니다.");
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "모든 정보를 입력해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// 회원 계정을 생성하여 DB에 저장
	private boolean createMemeber() {
		try {
			Account insertAcc = new Account(); // 회원의 정보를 저장하는 Account
			insertAcc.setId(idField.getText());
			insertAcc.setPassword(pwField.getText());
			insertAcc.setUserName(nameField.getText());
			insertAcc.setTel(telField.getText());
			insertAcc.setBirth(Date.valueOf(birthField.getText()));
			insertAcc.setMileage(Integer.parseInt(mileageField.getText()));
			insertAcc.setIsAdmin('N');

			if (insertAcc.getId() == null || insertAcc.getId().isEmpty() || insertAcc.getPassword() == null
					|| insertAcc.getPassword().isEmpty() || insertAcc.getUserName() == null
					|| insertAcc.getUserName().isEmpty() || insertAcc.getTel() == null || insertAcc.getTel().isEmpty()
					|| insertAcc.getBirth() == null || insertAcc.getBirth().toString().length() == 0) {
				JOptionPane.showMessageDialog(null, "모든 정보를 입력해주세요.");
			} else if (managerFrame.getDao().searchAccountForId(insertAcc.getId()) != null) {
				JOptionPane.showMessageDialog(null, "아이디가 이미 존재합니다.");
			} else if (insertAcc.getMileage() < 0) {
				JOptionPane.showMessageDialog(null, "정상적인 마일리지 값을 넣어주세요.");
			} else if (insertAcc.getId() != null && insertAcc.getPassword() != null && insertAcc.getUserName() != null
					&& insertAcc.getTel() != null && insertAcc.getBirth() != null) {
				managerFrame.getDao().insertMember(insertAcc);
				managerFrame.getAccountTabPanel().addTableRow(insertAcc.toObject());
				JOptionPane.showMessageDialog(null, "회원 계정 생성이 완료되었습니다.");
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "모든 정보를 입력해주세요.");
			}
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "마일리지는 숫자 값을 넣어주세요.");
		} catch (IllegalArgumentException iae) {
			JOptionPane.showMessageDialog(null, "생년월일 입력 형식을 맞춰주세요.");
		}

		return false;
	}

	// 이전 화면으로 돌아감
	private void goback() {
		// 값 초기화
		idField.setText(null);
		pwField.setText(null);
		nameField.setText(null);
		telField.setText(null);
		emailField.setText(null);
		birthField.setText(null);
		mileageField.setText(null);

		managerRadioBtn.setSelected(true); // 관리자 입력 버튼이 선택된 상태로 초기화
		setManagerInput(); // 관리자 입력 활성화

		managerFrame.getTabbedPane().setVisible(true);
		setVisible(false);
	}

	// 관리자 정보 입력 활성화
	private void setManagerInput() {

		emailField.setEnabled(true);
		birthField.setEnabled(false);
		mileageField.setEnabled(false);

	}

	// 회원 정보 입력 활성화
	private void setMemberInput() {

		emailField.setEnabled(false);
		birthField.setEnabled(true);
		mileageField.setEnabled(true);

	}

}
