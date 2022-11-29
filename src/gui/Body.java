package gui;

import api.ItemApi;
import entity.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Body extends JPanel {
	MainFrame mf;
	JPanel current_page;
	JPanel previous_page;

	Body(MainFrame mf) {
		this.mf = mf;

		setDesign();

	}

	void setDesign() {


		setSize(1296,650);
		setLocation(100,70);
		setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
		setBackground(Color.white);

		showLogin();
	}

	public void showBack() {
		if (previous_page != null) {
			JPanel previous_page = this.previous_page;
			this.previous_page = current_page;
			current_page = previous_page;
			// this.previous_page = null;
			removeAll();
			add(current_page);
			revalidate();
			repaint();
		}
	}

	public void showLogin() {
		previous_page = current_page;
		current_page = new BodyLogin(this);
		removeAll();
		add(current_page);
		revalidate();
		repaint();

	}

	public void showSignUp() {
		previous_page = current_page;
		current_page = new BodySignUp(this);
		removeAll();
		add(current_page);
		revalidate();
		repaint();
	}

	public void showMain() {
		previous_page = current_page;
		current_page = new BodyMain(this);
		removeAll();
		add(current_page);
		revalidate();
		repaint();
	}
	public void showItemList(int category, int page) {
		previous_page = current_page;
		current_page = new BodyItemList(this, category, page);
		removeAll();
		add(current_page);
		revalidate();
		repaint();
	}

	public void showItem(long item_key) {
		System.out.println(item_key);
		previous_page = current_page;
		current_page = new BodyItem(this, item_key);
		removeAll();
		add(current_page);
		revalidate();
		repaint();
	}

	public void showMyPage(int member_key) {
		previous_page = current_page;
		current_page = new BodyMyPage(this, member_key);
		removeAll();
		add(current_page);
		revalidate();
		repaint();
	}



}
