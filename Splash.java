import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Splash extends JFrame implements ActionListener {
	JButton  pr;
	Splash(){
		setSize(1100,700);
		setLocation(120,05);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1100,650,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel im = new JLabel(i3);
		im.setBounds(0, 40, 1100, 650);
		add(im);
		
		
		JLabel jnu = new JLabel("WELCOME TO JAWAHARLAL NEHRU UNIVERSITY");
		jnu.setBounds(220,-20,650,80);
		jnu.setFont(new Font("Sariff",Font.BOLD,24));
		jnu.setForeground(Color.RED);
		add(jnu);
		
		pr = new JButton("Proceed");
		pr.setBounds(980,10,90,25);
		pr.setFont(new Font("Sariff",Font.CENTER_BASELINE,12));
		pr.addActionListener(this);
		add(pr);
		setVisible(true);
		
		while(true) {
			jnu.setVisible(true);
			try {
				Thread.sleep(700);
			}catch(Exception e) {
				e.printStackTrace();
			}
			jnu.setVisible(false);
			try {
				Thread.sleep(700);
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new Admin();
		setVisible(false);
	}
	
	public static void main(String[] arg) {
		new Splash();
	}

}
