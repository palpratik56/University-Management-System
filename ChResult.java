import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.text.DecimalFormat;

import javax.swing.*;

public class ChResult extends JFrame implements ActionListener{
	Choice croll;
	JButton ch;
	JLabel csem,cbco,s1,s2,s3,s4,s5,m1,m2,m3,m4,m5,per,persc,cgpa,cgpasc;
	float percen;
	
	String url="jdbc:mysql:///university"; 
	String user="root";
	String pwd="system";
	
	String query1 = "select * from subject where roll = ? and sem = ?;";
	String query2 = "select * from marks where roll = ? and sem = ?;";
	String query = "select s.roll,course,sem from student s, marks m WHERE s.roll = m.roll "
			+ "and s.roll = ?";
	ChResult(){
		setSize(400,550);
		setLocation(500,80);
		getContentPane().setBackground(Color.CYAN);
		setLayout(null);
		
		
		JLabel res = new JLabel("Check Your Result");
		res.setBounds(100,20,500,30);
		res.setFont(new Font("Tahoma",Font.BOLD,20));
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
		sem.setBounds(50,120,80,30);
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
		
		//showing percentage and cgpa
		per = new JLabel("Percentage: ");
		per.setBounds(40,450,100,30); // location width,height,field width,height
		per.setFont(new Font("tahoma",Font.CENTER_BASELINE,14));
		add(per);
		persc = new JLabel();
		persc.setBounds(140,450,60,30); // location width,height,field width,height
		persc.setFont(new Font("tahoma",Font.CENTER_BASELINE,14));
		add(persc);
		
		cgpa = new JLabel("CGPA: ");
		cgpa.setBounds(220,450,50,30); // location width,height,field width,height
		cgpa.setFont(new Font("tahoma",Font.CENTER_BASELINE,14));
		add(cgpa);
		cgpasc = new JLabel();
		cgpasc.setBounds(270,450,100,30); // location width,height,field width,height
		cgpasc.setFont(new Font("tahoma",Font.CENTER_BASELINE,14));
		add(cgpasc);
		
		 ch = new JButton("Check");
		 ch.setBounds(140,170,80,20);
		 ch.setFont(new Font("Sariff",Font.CENTER_BASELINE,12));
		 ch.addActionListener(this);
		 add(ch);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
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
			if (rs1.next()) {
				float ma1 = Float.parseFloat(rs1.getString("m1"));
				float ma2 = Float.parseFloat(rs1.getString("m2"));
				float ma3 = Float.parseFloat(rs1.getString("m3"));
				float ma4 = Float.parseFloat(rs1.getString("m4"));
				float ma5 = Float.parseFloat(rs1.getString("m5"));
			
				m1.setText(rs1.getString("m1"));
				m2.setText(rs1.getString("m2"));
				m3.setText(rs1.getString("m3"));
				m4.setText(rs1.getString("m4"));
				m5.setText(rs1.getString("m5"));

				percen = (float) ((ma1+ma2+ma3+ma4+ma5)/5.00);
				persc.setText(Float.toString((percen)));
				
				final DecimalFormat decfor = new DecimalFormat("0.000"); 
				float gr = (float) ((percen)/9.50);
				decfor.format(gr);
				cgpasc.setText(Float.toString((gr)));
			}
			
		}catch(Exception e1) {
				e1.printStackTrace();
			}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChResult();
	}
	

}
