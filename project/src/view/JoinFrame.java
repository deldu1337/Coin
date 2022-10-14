package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import User.DTO;
import User.DAO;

public class JoinFrame extends JFrame {
	JScrollPane scrollpane;
	ImageIcon img;
	DTO dto = new DTO();
	DAO dao = new DAO();
	ChooseRoom num;
	static int loginCnt, join_num;
	
	JoinFrame(int num) {
		join_num=num;
		Font font1 = new Font("맑은 고딕", Font.BOLD, 13); // 폰트 추가
		Font font2 = new Font("맑은 고딕", Font.BOLD, 15);

		img = new ImageIcon("Image/JoinFrame.png");
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(img.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		setTitle("회원가입");
		setSize(425, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panel.setLayout(null);
		setLocationRelativeTo(null);

		JLabel join_label = new JLabel("JOIN"); // 텍스트 사용을 위해 JLabel 변수 선언
		JLabel name_label = new JLabel("성         명  :");
		JLabel id_label = new JLabel("아   이   디  :");
		JLabel pwd_label = new JLabel("비 밀 번 호  : ");
		JLabel checkpwd_label = new JLabel("비밀번호확인 : ");
		join_label.setBounds(190, 15, 100, 45);
		name_label.setBounds(20, 85, 100, 25);
		id_label.setBounds(20, 155, 100, 25);
		pwd_label.setBounds(20, 225, 100, 25);
		checkpwd_label.setBounds(15, 295, 100, 25);
		join_label.setFont(font2); // 폰트 적용
		name_label.setFont(font1);
		id_label.setFont(font1);
		pwd_label.setFont(font1);
		checkpwd_label.setFont(font1);
		join_label.setForeground(Color.BLACK); // 폰트의 색상 적용
		name_label.setForeground(Color.BLACK);
		id_label.setForeground(Color.BLACK);
		pwd_label.setForeground(Color.BLACK);
		checkpwd_label.setForeground(Color.BLACK);
		panel.add(join_label); // 패널에 라벨 적용
		panel.add(name_label);
		panel.add(id_label);
		panel.add(pwd_label);
		panel.add(checkpwd_label);

		JTextField name_field = new JTextField(); // 타이핑한 글씨가 보이는 JTextField
		JTextField id_field = new JTextField();
		JPasswordField pwd_field = new JPasswordField(); // 타이핑한 글씨가 보이지 않는 JPasswordField
		JPasswordField checkpwd_field = new JPasswordField();
		name_field.setBounds(115, 85, 180, 25);
		id_field.setBounds(115, 155, 180, 25);
		pwd_field.setBounds(115, 225, 180, 25);
		checkpwd_field.setBounds(115, 295, 180, 25);
		panel.add(name_field);
		panel.add(id_field);
		panel.add(pwd_field);
		panel.add(checkpwd_field);

		JButton back_button = new JButton("Back");
		JButton checklogin_button = new JButton("중복 확인");
		JButton join_button = new JButton("회원가입");
		back_button.setBounds(0, 0, 70, 30);
		checklogin_button.setBounds(300, 155, 100, 25);
		join_button.setBounds(160, 360, 100, 50);
		back_button.setFont(font1);
		checklogin_button.setFont(font1);
		join_button.setFont(font1);
		panel.add(back_button);
		panel.add(checklogin_button);
		panel.add(join_button);

		scrollpane = new JScrollPane(panel);
		setContentPane(scrollpane);

		setVisible(true);

		dao.createTable();
		checklogin_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(dao.checkID(id_field.getText())==true) {
					JOptionPane.showMessageDialog(null, "이미 사용중인 아이디입니다.", 
							"아이디 중복", JOptionPane.WARNING_MESSAGE);
					loginCnt=0;
				}
				else {
					JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다.");
					loginCnt=1;
				}
			}
		});
		
		join_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(name_field.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(null, "성명을 입력해 주세요.",
							"성명 입력", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(id_field.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해 주세요.",
							"아이디 입력", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(loginCnt==0) {
					JOptionPane.showMessageDialog(null, "아이디 중복 확인이 필요합니다.",
							"아이디 중복 확인", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(pwd_field.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해 주세요.",
							"비밀번호 입력", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(checkpwd_field.getText().trim().length()==0) {
					JOptionPane.showMessageDialog(null, "비밀번호 확인을 입력해 주세요.",
							"비밀번호 확인 입력", JOptionPane.WARNING_MESSAGE);
					return;
				}
				if(!(pwd_field.getText().trim().equals(checkpwd_field.getText().trim()))) {
					JOptionPane.showMessageDialog(null, "비밀번호가 같지 않습니다.",
							"비밀번호 확인", JOptionPane.WARNING_MESSAGE);
					return;
				}
				dto.setName(name_field.getText());
				dto.setID(id_field.getText());
				dto.setPW(pwd_field.getText());
				loginCnt=0;
				new LoginFrame(num);
				setVisible(false);
				try {
					dao.createUser(dto.getName(), dto.getID(), dto.getPW());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		back_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginCnt=0;
				new LoginFrame(num);
				setVisible(false);
			}
		});
	}

	public static void main(String[] args) {
		new JoinFrame(join_num);
	}
}