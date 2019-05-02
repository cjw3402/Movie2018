package mrs.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class AccountTabPanel extends JPanel {

	private ManagerFrame managerFrame; // 이 Panel을 생성한 상위 Frame 객체
	private DefaultTableModel model; // 테이블 조작을 위한 변수

	public AccountTabPanel(ManagerFrame managerFrame) {

		this.managerFrame = managerFrame;
		panelSetting();

	}

	private void panelSetting() {

		setBounds(0, 0, 994, 565);
		setLayout(null);

		// lblSearch 생성 및 세팅
		JLabel lblSearch = new JLabel("검  색");
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblSearch.setBounds(45, 20, 50, 30);
		add(lblSearch);

		// accountTable의 header와 data 생성
		Object[][] data = managerFrame.getDao().getAccountAll();
		String[] headers = new String[] { "아이디", "비밀번호", "이름", "전화번호", "이메일", "생년월일", "남은 마일리지", "관리자 여부" };

		// 테이블 조작을 위한 DefaultTableModel 선언
		model = new DefaultTableModel(data, headers);

		// accountTable 생성 및 세팅
		JTable accountTable = new JTable(model); // 실행용, 아래는 Design용
		accountTable.setRowHeight(30);
		accountTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		accountTable.setAlignmentX(0);
		accountTable.setAutoCreateRowSorter(true);

		// searchField 생성 및 세팅
		JTextField searchField = new JTextField();
		searchField.setBounds(105, 20, 840, 30);
		searchField.setColumns(10);
		searchField.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		add(searchField);
		searchField.addKeyListener(new KeyAdapter() { // 검색창 이벤트 처리
			@Override
			public void keyReleased(KeyEvent e) { // 검색창에 문자 입력 시, 검색 수행
				String val = searchField.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<>(accountTable.getModel());
				accountTable.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});

		// accountTableScrollPane 생성 및 세팅
		JScrollPane accountTableScrollPane = new JScrollPane(accountTable);
		accountTableScrollPane.setBounds(45, 70, 900, 350);
		add(accountTableScrollPane);

		// rowAddBtn 생성 및 세팅
		JButton rowAddBtn = new JButton("계정 추가");
		rowAddBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		rowAddBtn.setBounds(300, 450, 150, 50);
		add(rowAddBtn);
		rowAddBtn.addActionListener(new ActionListener() { // 계정 추가 버튼 이벤트 처리
			@Override
			public void actionPerformed(ActionEvent e) { // 계정 생성 화면 오픈
				managerFrame.getAddAccountPanel().setVisible(true);
				managerFrame.getTabbedPane().setVisible(false);
			}
		});

		// rowDeleteBtn 생성 및 세팅
		JButton rowDeleteBtn = new JButton("계정 삭제");
		rowDeleteBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		rowDeleteBtn.setBounds(550, 450, 150, 50);
		add(rowDeleteBtn);
		rowDeleteBtn.addActionListener(new ActionListener() { // 계정 삭제 버튼 이벤트 처리
			@Override
			public void actionPerformed(ActionEvent e) { // 선택된 행의 데이터를 삭제함
				int rowNumber = accountTable.getSelectedRow(); // 선택된 행의 번호를 저장

				// 선택한 행의 정보를 삭제함 (테이블, DB)
				if (rowNumber >= 0 && rowNumber < accountTable.getRowCount()) {
					String id = (String) accountTable.getValueAt(rowNumber, 0);
					managerFrame.getDao().deleteAccount(id); // DB 내용 삭제
					model.removeRow(rowNumber);
				} else {
					JOptionPane.showMessageDialog(null, "행을 선택하세요.");
				}
			}
		});

	}

	public void addTableRow(Object[] rowData) {

		model.addRow(rowData);

	}

}
