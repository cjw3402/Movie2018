package mrs.gui;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import mrs.vo.Theater;

public class AddTheaterPanel extends JPanel {

	private ManagerFrame managerFrame; // 이 Panel을 생성한 상위 Frame 객체
	private JTextField nameField, typeField;
	private JButton addTheaterBtn, backBtn;

	public AddTheaterPanel(ManagerFrame managerFrame) {
		this.managerFrame = managerFrame;

		panelSetting();
	}

	private void panelSetting() {
		setBackground(SystemColor.inactiveCaption);
		setBounds(0, 0, 994, 565);
		setLayout(null);
		setVisible(false);

		// addTheaterPanelTitle 생성 및 세팅
		JLabel addTheaterPanelTitle = new JLabel("상영관 추가");
		addTheaterPanelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		addTheaterPanelTitle.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		addTheaterPanelTitle.setBounds(400, 60, 200, 60);
		add(addTheaterPanelTitle);

		// lblTheaterName 생성 및 세팅
		JLabel lblTheaterName = new JLabel("상영관 이름");
		lblTheaterName.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheaterName.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblTheaterName.setBounds(320, 210, 150, 40);
		add(lblTheaterName);

		// lblTheaterType 생성 및 세팅
		JLabel lblTheaterType = new JLabel("좌석배치타입");
		lblTheaterType.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheaterType.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblTheaterType.setBounds(320, 300, 150, 40);
		add(lblTheaterType);

		// nameField 생성 및 세팅
		nameField = new JTextField();
		nameField.setHorizontalAlignment(SwingConstants.CENTER);
		nameField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		nameField.setBounds(465, 210, 200, 40);
		nameField.setColumns(10);
		add(nameField);

		// typeField 생성 및 세팅
		typeField = new JTextField();
		typeField.setHorizontalAlignment(SwingConstants.CENTER);
		typeField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		typeField.setColumns(10);
		typeField.setBounds(465, 300, 200, 40);
		add(typeField);

		// addTheaterBtn 생성 및 세팅
		addTheaterBtn = new JButton("등    록");
		addTheaterBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		addTheaterBtn.setBounds(280, 450, 200, 50);
		add(addTheaterBtn);
		addTheaterBtn.addActionListener(new ActionListener() { // 버튼 클릭 시, 상영관 정보를 추가하고 이전으로 돌아감
			@Override
			public void actionPerformed(ActionEvent e) {
				if (createTheater()) {
					goback();
				}
			}
		});

		// backBtn 생성 및 세팅
		backBtn = new JButton("돌아가기");
		backBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		backBtn.setBounds(520, 450, 200, 50);
		add(backBtn);
		backBtn.addActionListener(new ActionListener() { // 버튼 클릭 시, 이전 화면으로 돌아감
			@Override
			public void actionPerformed(ActionEvent e) {
				goback();
			}
		});
	}

	// 상영관 정보를 생성하여 DB에 저장
	private boolean createTheater() {
		try {
			Theater theater = new Theater(); // 상영관 정보를 저장하는 Theater
			theater.setTheaterName(nameField.getText());
			theater.setTheaterType(Integer.parseInt(typeField.getText()));

			if (theater.getTheaterName() == null || theater.getTheaterName().isEmpty()) {
				JOptionPane.showMessageDialog(null, "상영관 이름을 입력해주세요.");
			} else if (managerFrame.getDao().searchTheaterForTheaterName(theater.getTheaterName()) != null) {
				JOptionPane.showMessageDialog(null, "동일한 이름의 상영관이 이미 존재합니다.");
			} else if (theater.getTheaterType() < 1 || theater.getTheaterType() > 3) {
				JOptionPane.showMessageDialog(null, "상영관 타입이 올바르지 않습니다.");
			} else if (theater.getTheaterName() != null && typeField.getText() != null) {
				managerFrame.getDao().insertTheater(theater);
				managerFrame.getTheaterTabPanel().addTableRow(theater.toObject());
				JOptionPane.showMessageDialog(null, "상영관 정보 생성이 완료되었습니다.");
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "입력 상태를 확인해주세요.");
			}
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "상영관 타입이 올바르지 않습니다.");
		}

		return false;
	}

	// 이전 화면으로 돌아감
	private void goback() {
		// 값 초기화
		nameField.setText(null);
		typeField.setText(null);

		managerFrame.getTabbedPane().setVisible(true);
		setVisible(false);
	}

}
