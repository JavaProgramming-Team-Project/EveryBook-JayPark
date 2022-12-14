package gui;

import login.LoginMember;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Head extends JPanel {
	MainFrame mf;

	JLabel logo;
	JPanel menu;
	String str_menu[] = {"검색", "카테고리", "마이페이지", "로그아웃"};
	JLabel btn_menu[] = new JLabel[str_menu.length];

	Head(MainFrame mf) {
		this.mf = mf;

		setDesign();

		addMenu();

	}

	void setDesign() {

		setSize(1280,70);
		setLocation(0,0);
		setLayout(null);
		setBackground(new Color(0x58CCFF));

		logo = new JLabel(Tools.resizeImage(new ImageIcon(getClass().getClassLoader().getResource("img/logo.png")), 200,64));
		logo.setSize(200,35);
		logo.setLocation(100,20);
		logo.setFont(Fonts.f1);
		logo.setForeground(Color.white);
		add(logo);
	}

	void addMenu() {
		menu = new JPanel();
		menu.setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));
		menu.setSize(400,34);
		menu.setLocation(780,20);
		menu.setOpaque(false);
		menu.setVisible(false);

		for (int i = 0; i < btn_menu.length; i++) {
			btn_menu[i] = new JLabel(str_menu[i]);
			btn_menu[i].setHorizontalAlignment(JLabel.CENTER);
			btn_menu[i].setFont(Fonts.f2);
			btn_menu[i].setForeground(Color.white);
			btn_menu[i].setOpaque(false);
			int index = i;
			btn_menu[i].addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					switch(index) {
						case 0: // 검색
							mf.body.showSearch(null);
							break;
						case 1: // 카테고리
							mf.body.showItemList(1,1);
							break;
						case 2: // 마이페이지
							mf.body.showMyPage();
							break;
						case 3: // 로그아웃
							System.exit(0);
							break;
						case 4: // 뒤로가기
							mf.body.showBack();
							break;

					}
				}
			});
			menu.add(btn_menu[i]);
		}
		add(menu);
	}

}
