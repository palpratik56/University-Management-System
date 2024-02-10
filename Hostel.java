import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Hostel extends JFrame{
	JTable tb;
	Hostel(){
		setSize(600,350);
		setLocation(350,150);
		getContentPane().setBackground(Color.GRAY);
		setLayout(null);
		
		JLabel hd = new JLabel("Hostel Details");
		hd.setBounds(200,10,500,30);
		hd.setFont(new Font("Sariff",Font.BOLD,24));
		hd.setForeground(Color.BLACK);
		add(hd);
		
		String url="jdbc:mysql:///university"; 
		String user="root";
		String pwd="system";
		String query = "select * from hostel;";
		try {
			Connection con = DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();	
			tb = new JTable();
			tb.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		JScrollPane jsp = new JScrollPane(tb);
		jsp.setBounds(0,50,600,600);
		add(jsp);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Hostel();
	}

}
