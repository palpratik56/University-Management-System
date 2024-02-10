import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class UpFac extends JFrame implements ActionListener {
	JTextField tbadd,tbpin,tbph,tbhq;
	JLabel lbname1,lbfname1,lbmname1,dob,lbhq;
	JButton sub;
	Choice croll;
	JComboBox <?> cbexp,cbbr;
	String url="jdbc:mysql:///university"; 
	String user="root";
	String pwd="system";
	String query = "select * from faculty";
	String query1 = "select * from faculty where eid = ?";
	UpFac(){
		setSize(750,550);
		setLocation(350,30);
		getContentPane().setBackground(Color.CYAN);
		setLayout(null);
		
		JLabel hd = new JLabel("Update Faculty Details");
		hd.setBounds(250,20,500,30);
		hd.setFont(new Font("tahoma",Font.BOLD,22));
		hd.setForeground(Color.MAGENTA);
		add(hd);
		

		JLabel sroll = new JLabel("Search Employee Id:");
		sroll.setBounds(80,60,150,30);
		sroll.setFont(new Font("Sariff",Font.BOLD,15));
		add(sroll);
		
		croll = new Choice();
		croll.setBounds(240,60,120,30); // location width,height,field width,height
		add(croll);
		
		try {
			Connection con = DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();	
			while(rs.next()) {
				croll.add(rs.getString("eid"));
				}
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		JLabel lbname = new JLabel("Name:");
		lbname.setBounds(80,100,60,30); // location width,height,field width,height
		lbname.setFont(new Font("tahoma",Font.BOLD,15));
		add(lbname);
		
		JLabel lbname1 = new JLabel();
		lbname1.setBounds(150,100,150,30); // location width,height,field width,height
		lbname1.setFont(new Font("tahoma",Font.HANGING_BASELINE,15));
		//getval(lbname1,"name");
		add(lbname1);
		
		JLabel lbfname = new JLabel("Father's Name:");
		lbfname.setBounds(390,100,120,30);
		lbfname.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbfname);
		
		JLabel lbfname1 = new JLabel();
		lbfname1.setBounds(520,100,150,30); // location width,height,field width,height
		lbfname1.setFont(new Font("tahoma",Font.HANGING_BASELINE,15));
		//getval(lbfname1,"fathername");
		add(lbfname1);
		
		JLabel lbmname = new JLabel("Mother's Name:");
		lbmname.setBounds(20,150,120,30);
		lbmname.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbmname);
		
		JLabel lbmname1 = new JLabel();
		lbmname1.setBounds(150,150,120,30); // location width,height,field width,height
		lbmname1.setFont(new Font("tahoma",Font.HANGING_BASELINE,15));
		//getval(lbmname1,"mothername");
		add(lbmname1);
		
		JLabel lbroll = new JLabel("Employee Id:");
		lbroll.setBounds(390,150,120,30);
		lbroll.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbroll);
		
		JLabel lbr = new JLabel();
		lbr.setBounds(520,150,120,30); // location width,height,field width,height
		lbr.setFont(new Font("tahoma",Font.HANGING_BASELINE,15));
		lbr.setText(croll.getSelectedItem());
		add(lbr);
		
		JLabel lbadd = new JLabel("Address:");
		lbadd.setBounds(60,200,100,30);
		lbadd.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbadd);
		
		tbadd = new JTextField();
		tbadd.setBounds(140,200,480,30);
		add(tbadd);
		
		JLabel lbpin = new JLabel("PIN Code:");
		lbpin.setBounds(50,250,100,30);
		lbpin.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbpin);
		
		tbpin = new JTextField();
		tbpin.setBounds(140,250,120,30);
		add(tbpin);
		
		JLabel lbdob = new JLabel("Date of Birth:");
		lbdob.setBounds(390,250,100,30);
		lbdob.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbdob);
		
		JLabel dob = new JLabel();
		dob.setBounds(510,250,100,30); // location width,height,field width,height
		dob.setFont(new Font("tahoma",Font.HANGING_BASELINE,15));
		//getval(dob,"dob");
		add(dob);
		
		JLabel lbph = new JLabel("Contact No.:");
		lbph.setBounds(50,300,100,30);
		lbph.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbph);
		
		 tbph = new JTextField();
		tbph.setBounds(140,300,120,30);
		add(tbph);
		
		JLabel lbhq = new JLabel("Highest Qualification:");
		lbhq.setBounds(340,300,200,30);
		lbhq.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbhq);
		
		tbhq = new JTextField();
		tbhq.setBounds(510,300,120,30);
		add(tbhq);
		
		JLabel lbbr = new JLabel("Choose Branch:");
		lbbr.setBounds(30,350,140,30);
		lbbr.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbbr);
		
		String branch [] = {"ENGLISH","BENGALI","SANSKRIT","HISTORY","GEOGRAPHY","POLITICAL"
				+ " SCIENCE","MATHS","CHEMISTRY","PHYSICS","DATA SCIENCE","COMPUTER SCIENCE"};
		cbbr = new JComboBox<Object>(branch);
		cbbr.setBounds(150,350,150,30);
		add(cbbr);
		
		JLabel lbexp = new JLabel("Choose Experince(yrs):");
		lbexp.setBounds(340,350,170,30);
		lbexp.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbexp);
		
		String exp [] = {"3-5","5-7","7-9","9-11","11-13","13-15","15-17","17-20","20+"};
		cbexp = new JComboBox<Object>(exp);
		cbexp.setBounds(510,350,60,30);
		add(cbexp);
		
	    sub = new JButton("Update");
	    sub.setBounds(320,450,100,30);
	    sub.setFont(new Font("Sariff",Font.BOLD,15));
	    sub.addActionListener(this);
		add(sub);
		
		
		setVisible(true);
	
		try {
			Connection con = DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement(query1);
			ps.setString(1, croll.getSelectedItem());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				lbname1.setText(rs.getString("name"));
				lbmname1.setText(rs.getString("mothername"));
				lbfname1.setText(rs.getString("fathername"));
				dob.setText(rs.getString("dob"));
				tbhq.setText(rs.getString("highest_quali"));
				tbadd.setText(rs.getString("address"));
				tbpin.setText(rs.getString("pin"));
				tbph.setText(rs.getString("contact"));
			
				}
			
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		croll.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				try {
					Connection con = DriverManager.getConnection(url,user,pwd);
					PreparedStatement ps = con.prepareStatement(query1);
					ps.setString(1, croll.getSelectedItem());
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						lbname1.setText(rs.getString("name"));
						lbmname1.setText(rs.getString("mothername"));
						lbfname1.setText(rs.getString("fathername"));
						dob.setText(rs.getString("dob"));
						tbhq.setText(rs.getString("highest_quali"));
						tbadd.setText(rs.getString("address"));
						tbpin.setText(rs.getString("pin"));
						tbph.setText(rs.getString("contact"));
						}
					
				}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			});
	}
	
	public void Update_value() {
		try {
			String query = "update faculty set address = ?,pin = ?,contact = ?,"
					+ "highest_quali = ?,exp = ?,branch = ? where eid = ?";
			Connection con = DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement(query);
		
			String add  = tbadd.getText();
			String pin  = tbpin.getText();
			String phone  = tbph.getText();
			String co  = (String) cbexp.getSelectedItem();
			String br  = (String) cbbr.getSelectedItem();
			String hq = tbhq.getText();
			ps.setString(1, add);
			ps.setString(2, pin);
			ps.setString(3, phone);
			ps.setString(4, hq);
			ps.setString(5, co);
			ps.setString(6, br);
			ps.setString(7, croll.getSelectedItem());
			
			int rc = ps.executeUpdate();
			JOptionPane.showMessageDialog(null,rc+" Record Updated Successfully");
			setVisible(false);
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== sub) {
			Update_value();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UpFac();
	}
}


