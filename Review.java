import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Review extends JFrame implements ActionListener{
	Choice croll;
	JButton ch,ch1;
	JLabel s1,s2,s3,s4,s5,m1,m2,m3,m4,m5,cbco,csem;
	JCheckBox cb1,cb2,cb3,cb4,cb5;
	
	String url="jdbc:mysql:///university"; 
	String user="root";
	String pwd="system";
	
	String query1 = "select * from subject where roll = ? and sem = ?;";
	String query2 = "select * from marks where roll = ? and sem = ?;";
	String query3 = "insert into review values (?,?,?,?,?,?,?,?);";
	String query = "select s.roll,course,sem from student s, marks m WHERE s.roll = m.roll "
			+ "and s.roll = ?";
	Review(){
		setSize(400,530);
		setLocation(500,80);
		getContentPane().setBackground(Color.CYAN);
		setLayout(null);
		
		JLabel res = new JLabel("Result Review Page");
		res.setBounds(100,20,500,30);
		res.setFont(new Font("Tahoma",Font.BOLD,18));
		res.setForeground(Color.MAGENTA);
		add(res);
		
		JLabel sr = new JLabel("Enter Roll: ");
		sr.setBounds(50,80,80,30);
		sr.setFont(new Font("Sariff",Font.BOLD,15));
		add(sr);
		
		croll = new Choice();
		croll.setBounds(140,80,100,30); // location width,height,field width,height
		croll.setFont(new Font("tahoma",Font.CENTER_BASELINE,12));
		add(croll);
		
		try {
			Connection con = DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement("select * from student");
			ResultSet rs = ps.executeQuery();	
			while(rs.next()) {
				croll.add(rs.getString("roll"));
				}
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		JLabel sem = new JLabel("Semester:");
		sem.setBounds(50,120,120,30);
		sem.setFont(new Font("Sariff",Font.BOLD,15));
		add(sem);
		
		csem = new JLabel();
		csem.setBounds(130,120,70,30); // location width,height,field width,height
		csem.setFont(new Font("tahoma",Font.CENTER_BASELINE,12));
		add(csem);
		
		JLabel co = new JLabel("Course:");
		co.setBounds(220,120,60,30);
		co.setFont(new Font("Sariff",Font.BOLD,15));
		add(co);
		
		cbco = new JLabel();
		cbco.setBounds(280,120,70,30); // location width,height,field width,height
		cbco.setFont(new Font("tahoma",Font.CENTER_BASELINE,12));
		add(cbco);
		
		try {
			Connection con = DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, croll.getSelectedItem());
			ResultSet rs = ps.executeQuery();	
			while(rs.next()) {
				cbco.setText(rs.getString("course"));
				csem.setText(rs.getString("sem"));
				}
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		croll.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				try {
					Connection con = DriverManager.getConnection(url,user,pwd);
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, croll.getSelectedItem());
					ResultSet rs = ps.executeQuery();	
					while(rs.next()) {
						croll.add(rs.getString("roll"));
						cbco.setText(rs.getString("course"));
						csem.setText(rs.getString("sem"));
						}
				}catch(Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		
		JLabel lbsub = new JLabel("Subject");
		lbsub.setBounds(50,200,80,30); // location width,height,field width,height
		lbsub.setFont(new Font("tahoma",Font.BOLD,15));
		add(lbsub);
		
		JLabel lbmar = new JLabel("Marks");
		lbmar.setBounds(230,200,80,30); // location width,height,field width,height
		lbmar.setFont(new Font("tahoma",Font.BOLD,15));
		add(lbmar);
		
		
		s1 = new JLabel();
		s1.setBounds(50,240,140,30); // location width,height,field width,height
		s1.setFont(new Font("tahoma",Font.PLAIN,14));
		add(s1);
		s2 = new JLabel();
		s2.setBounds(50,280,140,30); // location width,height,field width,height
		s2.setFont(new Font("tahoma",Font.PLAIN,14));
		add(s2);
		s3 = new JLabel();
		s3.setBounds(50,320,140,30); // location width,height,field width,height
		s3.setFont(new Font("tahoma",Font.PLAIN,14));
		add(s3);
		s4 = new JLabel();
		s4.setBounds(50,360,140,30); // location width,height,field width,height
		s4.setFont(new Font("tahoma",Font.PLAIN,14));
		add(s4);
		s5 = new JLabel();
		s5.setBounds(50,400,140,30); // location width,height,field width,height
		s5.setFont(new Font("tahoma",Font.PLAIN,14));
		add(s5);
		
		m1 = new JLabel();
		m1.setBounds(230,240,80,30); // location width,height,field width,height
		m1.setFont(new Font("tahoma",Font.PLAIN,14));
		add(m1);
		m2 = new JLabel();
		m2.setBounds(230,280,80,30); // location width,height,field width,height
		m2.setFont(new Font("tahoma",Font.PLAIN,14));
		add(m2);
		m3 = new JLabel();
		m3.setBounds(230,320,80,30); // location width,height,field width,height
		m3.setFont(new Font("tahoma",Font.PLAIN,14));
		add(m3);
		m4 = new JLabel();
		m4.setBounds(230,360,80,30); // location width,height,field width,height
		m4.setFont(new Font("tahoma",Font.PLAIN,14));
		add(m4);
		m5 = new JLabel();
		m5.setBounds(230,400,80,30); // location width,height,field width,height
		m5.setFont(new Font("tahoma",Font.PLAIN,14));
		add(m5);
		
		cb1 = new JCheckBox("");
		cb1.setBounds(330,240,30,20);
		cb1.addActionListener(this);
		add(cb1);
		
		cb2 = new JCheckBox("");
		cb2.setBounds(330,280,30,20);
		cb2.addActionListener(this);
		add(cb2);
		
		cb3 = new JCheckBox("");
		cb3.setBounds(330,320,30,20);
		cb3.addActionListener(this);
		add(cb3);
		
		cb4 = new JCheckBox("");
		cb4.setBounds(330,360,30,20);
		cb3.addActionListener(this);
		add(cb4);
		
		cb5 = new JCheckBox("");
		cb5.setBounds(330,400,30,20);
		cb5.addActionListener(this);
		add(cb5);
		
		ch = new JButton("Get Result");
		ch.setBounds(140,170,100,20);
		ch.setFont(new Font("Sariff",Font.CENTER_BASELINE,13));
		ch.addActionListener(this);
		add(ch);
		
		ch1 = new JButton("Apply");
		ch1.setBounds(150,450,80,25);
		ch1.setFont(new Font("Sariff",Font.CENTER_BASELINE,14));
		ch1.addActionListener(this);
		add(ch1);
		
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ch) {
			try {
				Connection con = DriverManager.getConnection(url,user,pwd);
				PreparedStatement ps = con.prepareStatement(query1);
				ps.setString(1, croll.getSelectedItem());
				ps.setString(2, csem.getText());
				ResultSet rs = ps.executeQuery();
				if (!rs.next()) {
					JOptionPane.showMessageDialog(null,"No Record Found!!");
				}
				else {
					s1.setText(rs.getString("s1"));
					s2.setText(rs.getString("s2"));
					s3.setText(rs.getString("s3"));
					s4.setText(rs.getString("s4"));
					s5.setText(rs.getString("s5"));
				}
				PreparedStatement ps1 = con.prepareStatement(query2);
				ps1.setString(1, croll.getSelectedItem());
				ps1.setString(2, csem.getText());
				ResultSet rs1 = ps1.executeQuery();
				while(rs1.next()) {
					m1.setText(rs1.getString("m1"));
					m2.setText(rs1.getString("m2"));
					m3.setText(rs1.getString("m3"));
					m4.setText(rs1.getString("m4"));
					m5.setText(rs1.getString("m5"));
				}
		}catch(Exception e1) {
			e1.printStackTrace();
			}
		}
		else if(e.getSource()==ch1) {
			String sub1,sub2,sub3,sub4,sub5;
			try {
				Connection con = DriverManager.getConnection(url,user,pwd);
				PreparedStatement ps = con.prepareStatement(query3);
				String q = "select * from student where roll = ?;";
				PreparedStatement ps1 = con.prepareStatement(q);
				ps1.setString(1,croll.getSelectedItem());
				ResultSet rs1 = ps1.executeQuery();
				ps.setString(1, croll.getSelectedItem());
				if(rs1.next()) {
					ps.setString(2,rs1.getString("name"));
				}
				ps.setString(3, csem.getText());
				
				if(cb1.isSelected()) {
					sub1 = s1.getText();
					}
				else {
					sub1 = "Not Applied";
				}
				if(cb2.isSelected()) {
					sub2 = s2.getText();
					}
				else {
					sub2 = "Not Applied";
				}
				if(cb3.isSelected()) {
					sub3 = s3.getText();
					}
				else {
					sub3 = "Not Applied";
				}
				if(cb4.isSelected()) {
					sub4 = s4.getText();
					}
				else {
					sub4 = "Not Applied";
				}
				if(cb5.isSelected()) {
					sub5 = s5.getText();
					}
				else {
					sub5 = "Not Applied";
				}
				ps.setString(4, sub1);
				ps.setString(5, sub2);
				ps.setString(6, sub3);
				ps.setString(7, sub4);
				ps.setString(8, sub5);
				int r = ps.executeUpdate();
				if(r!=0) {
				JOptionPane.showMessageDialog(null,"Revew Applied for "+rs1.getString("name"));
				}
				else {
					JOptionPane.showMessageDialog(null,"Review already applied!!");
					}
				setVisible(false);
				}catch(Exception e1) {
					e1.printStackTrace();
					}
			}	
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Review();
	}
	
}
