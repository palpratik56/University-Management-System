import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class StLeave extends JFrame implements ActionListener{
	Choice croll,cdur;
	JDateChooser dt1;
	JButton sub;
	
	String url="jdbc:mysql:///university"; 
	String user="root";
	String pwd="system";
	
	StLeave(){
		setSize(400,350);
		setLocation(450,100);
		getContentPane().setBackground(Color.pink);
		setLayout(null);
		
		JLabel hd = new JLabel("Apply Leave for Student");
		hd.setBounds(80,20,220,30);
		hd.setFont(new Font("Tahoma",Font.BOLD,18));
		add(hd);
		
		JLabel sr = new JLabel("Search by Roll: ");
		sr.setBounds(80,60,120,30);
		sr.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(sr);
		
		croll = new Choice();
		croll.setBounds(200,60,110,30); // location width,height,field width,height
		add(croll);
		String query = "select * from student;";
		
		try {
			Connection con = DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();	
			while(rs.next()) {
				croll.add(rs.getString("roll"));
				}
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		JLabel dt = new JLabel("Choose Date: ");
		dt.setBounds(80,110,100,30);
		dt.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(dt);
		
		dt1 = new JDateChooser();
		dt1.setBounds(180,110,100,30);
		add(dt1);
		
		JLabel dur = new JLabel("Choose Duration:");
		dur.setBounds(80,170,130,30);
		dur.setFont(new Font("Tahoma",Font.PLAIN,15));
		add(dur);
		
		cdur = new Choice();
		cdur.setBounds(210,170,100,30); // location width,height,field width,height
		cdur.add("Half day");
		cdur.add("Full day");
		cdur.add("Two days");
		cdur.add("Three days");
		add(cdur);
		
		sub = new JButton("Apply");
	    sub.setBounds(130,240,90,30);
	    sub.setFont(new Font("Tahoma",Font.CENTER_BASELINE,15));
	    sub.addActionListener(this);
		add(sub);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String roll = croll.getSelectedItem();
		String date = ((JTextField)dt1.getDateEditor().getUiComponent()).getText();
		String dur = cdur.getSelectedItem();
		String query = "insert into stuleave values(?,?,?);";
		Connection con;
		try {
			con = DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, roll);
			ps.setString(2, date);
			ps.setString(3, dur);
			int rc = ps.executeUpdate();
			JOptionPane.showMessageDialog(null,rc+" Record Inserted Successfully");
			setVisible(false);
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		new StLeave();

	}
	

}
