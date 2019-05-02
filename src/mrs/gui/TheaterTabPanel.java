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

public class TheaterTabPanel extends JPanel {

	private ManagerFrame managerFrame; // 이 Panel을 생성한 상위 Frame 객체
	private DefaultTableModel model; // 테이블 조작을 위한 변수

	public TheaterTabPanel(ManagerFrame managerFrame) {
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

		// theaterTable의 header와 data 생성
		Object[][] data = managerFrame.getDao().getATheaterAll();
		String[] headers = new String[] { "상영관 이름", "좌석 배치 타입" };

		// 테이블 조작을 위한 DefaultTableModel 선언
		model = new DefaultTableModel(data, headers);

		// theaterTable 생성 및 세팅
		JTable theaterTable = new JTable(model);
		theaterTable.setRowHeight(30);
		theaterTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		theaterTable.setAlignmentX(0);
		theaterTable.setAutoCreateRowSorter(true);

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
				TableRowSorter<TableModel> trs = new TableRowSorter<>(theaterTable.getModel());
				theaterTable.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});

		// theaterTableScrollPane 생성 및 세팅
		JScrollPane theaterTableScrollPane = new JScrollPane(theaterTable);
		theaterTableScrollPane.setBounds(45, 70, 900, 350);
		add(theaterTableScrollPane);

		// rowAddBtn 생성 및 세팅
		JButton rowAddBtn = new JButton("상영관 추가");
		rowAddBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		rowAddBtn.setBounds(300, 450, 150, 50);
		add(rowAddBtn);
		rowAddBtn.addActionListener(new ActionListener() { // 상영관 추가 버튼 이벤트 처리
			@Override
			public void actionPerformed(ActionEvent e) { // 상영관 생성 화면 오픈
				managerFrame.getAddTheaterPanel().setVisible(true);
				managerFrame.getTabbedPane().setVisible(false);
			}
		});

		// rowDeleteBtn 생성 및 세팅
		JButton rowDeleteBtn = new JButton("상영관 삭제");
		rowDeleteBtn.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		rowDeleteBtn.setBounds(550, 450, 150, 50);
		add(rowDeleteBtn);
		rowDeleteBtn.addActionListener(new ActionListener() { // 상영관 삭제 버튼 이벤트 처리
			@Override
			public void actionPerformed(ActionEvent e) { // 선택된 행의 데이터를 삭제함
				int rowNumber = theaterTable.getSelectedRow(); // 선택된 행의 번호를 저장

				// 선택한 행의 정보를 삭제함 (테이블, DB)
				if (rowNumber >= 0 && rowNumber < theaterTable.getRowCount()) {
					String theaterName = (String) theaterTable.getValueAt(rowNumber, 0);
					managerFrame.getDao().deleteTheater(theaterName); // DB 내용 삭제
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
