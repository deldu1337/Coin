package view;

import java.awt.event.*;
import java.sql.Connection;
import java.awt.*;
import javax.swing.*;

import User.DAO;

public class FirstFrame extends JFrame { // JFrame을 상속받은 FirstFrame 클래스
	JScrollPane scrollpane; // 이미지 적용을 위한 틀
	ImageIcon img; // 이미지 변수 선언
	DAO dao;
	FirstFrame() {
		img = new ImageIcon("Image/FirstFrame.png"); // 배경 이미지 생성
		JPanel background = new JPanel() { // 패널 변수 선언 및 생성
			public void paintComponent(Graphics g) { // 이미지 그리기 위한 메소드
				g.drawImage(img.getImage(), 0, 0, null); // 이미지 그리기
				setOpaque(false); // 그림을 표시하게 설정, 투명하게 조절
				super.paintComponent(g);
			}
		};

		setTitle("코인노래방"); // 타이틀
		setSize(1200, 750); // 창 사이즈
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 없으면 X를 눌러도 JVM 상에 메모리로 상주
		background.setLayout(null); // 레이아웃 옵션을 사용하지 않음
		setLocationRelativeTo(null); // 창을 화면 상의 가운데에 정렬. null(기본값)은 가운데


		JButton button = new JButton("ENTRANCE"); // 버튼 변수 선언 및 생성
		button.setBounds(550, 400, 100, 50); // 버튼 시작점 위치(550,400)와 크기(100,50)
		background.add(button); // 패널에 버튼 적용
		scrollpane = new JScrollPane(background); // 패널에 스크롤팬 변수 선언 및 생성
		setContentPane(scrollpane); // 컨텐트팬을 scrollpane 객체로 변경

		setVisible(true); // 화면에 프레임 출력
		
		button.addActionListener(new ActionListener() { // 버튼 클릭에 관한 메소드
			@Override // ActionListener메소드 사용을 위한 오버라이딩
			public void actionPerformed(ActionEvent e) {
				new SecondFrame(); // 버튼이 클릭되면 SecondFrame 클래스 호출
				setVisible(false); // 창 안보이게 하기
			}
		});
	}

	public static void main(String[] args) { // 메인 메소드
		new FirstFrame(); // FirstFrame 클래스 호출
	}
}