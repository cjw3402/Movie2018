package mrs.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import mrs.dao.MrsDAO;

public class MemberFrame {

	private JFrame memberFrame;
	private MrsDAO dao;

	private JButton btn; // 버튼

	public MemberFrame(MrsDAO dao) {

		this.dao = dao;
		frameSetting();

	}

	private void frameSetting() {

		String backgroundImagePath = "./image/signup_background2222.jpg";
		memberFrame = new JFrame();
		memberFrame.setTitle("영화 예매 프로그램");

		// signupPanel 생성 및 세팅
		ImagePanel tempPanel = new ImagePanel(new ImageIcon(backgroundImagePath).getImage());
		tempPanel.setLocation(0, 0);
		memberFrame.setSize(tempPanel.getWidth(), tempPanel.getHeight());
		memberFrame.getContentPane().add(tempPanel);
		tempPanel.setLayout(null);

		// btn 생성 및 세팅
		btn = new JButton("사용자용 화면");
		btn.setBounds(298, 185, 250, 40);
		btn.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		tempPanel.add(btn);
		btn.addActionListener(new ActionListener() { // 입력받은 정보를 DB에 등록함
			public void actionPerformed(ActionEvent e) {
			}
		});

		memberFrame.setResizable(false); // 화면 크기 고정시킴
		memberFrame.setLocationRelativeTo(null); // 화면 중앙에 생성
		memberFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료시 프로세스도 종료
		memberFrame.getContentPane().setLayout(null);
		memberFrame.setVisible(true);

	}

}
