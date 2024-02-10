import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class AddFac extends JFrame implements ActionListener{
	JTextField tbname,tbfname,tbmname,tbid,tbadd,tbpin,tbph,tbhq;
	JDateChooser dtdob;
	JComboBox<?> cbbr,cbexp;
	JButton sub;
	
	AddFac(){
		setSize(800,500);
		setLocation(350,30);
		getContentPane().setBackground(Color.CYAN);
		setLayout(null);
		
		JLabel hd = new JLabel("New Faculty Details");
		hd.setBounds(300,30,500,30);
		hd.setFont(new Font("Sariff",Font.BOLD,22));
		hd.setForeground(Color.MAGENTA);
		add(hd);
		
		JLabel lbname = new JLabel("Name:");
		lbname.setBounds(80,100,60,30); // location width,height,field width,height
		lbname.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbname);
		
		 tbname = new JTextField();
		tbname.setBounds(140,100,150,30);
		add(tbname);
		
		JLabel lbfname = new JLabel("Father's Name:");
		lbfname.setBounds(390,100,120,30);
		lbfname.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbfname);
		
		 tbfname = new JTextField();
		tbfname.setBounds(510,100,150,30);
		add(tbfname);
		
		JLabel lbmname = new JLabel("Mother's Name:");
		lbmname.setBounds(20,150,120,30);
		lbmname.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbmname);
		
		 tbmname = new JTextField();
		tbmname.setBounds(140,150,150,30);
		add(tbmname);
		
		JLabel lbroll = new JLabel("Employee Id:");
		lbroll.setBounds(390,150,120,30);
		lbroll.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbroll);
		
		 tbid = new JTextField("JNU/23/");
		 tbid.setBounds(510,150,150,30);
		add(tbid);
		
		JLabel lbadd = new JLabel("Address:");
		lbadd.setBounds(60,200,100,30);
		lbadd.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbadd);
		
		 tbadd = new JTextField();
		tbadd.setBounds(140,200,550,30);
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
		
		 dtdob = new JDateChooser();
		dtdob.setBounds(510,250,100,30);
		add(dtdob);
		
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
		
	    sub = new JButton("Submit");
	    sub.setBounds(320,400,100,30);
	    sub.setFont(new Font("Sariff",Font.BOLD,15));
	    sub.addActionListener(this);
		add(sub);
		
		
		setVisible(true);
	}
	
	public void Insert_value() {
		try {
			String url="jdbc:mysql:///university"; 
			String user="root";
			String pwd="system";
			String query = "insert into faculty values(?,?,?,?,?,?,?,?,?,?,?);";
			Connection con = DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement(query);
			
			String name  = tbname.getText();
			String fname  = tbfname.getText();
			String mname  = tbmname.getText();
			String id  = tbid.getText();
			String add  = tbadd.getText();
			String pin  = tbpin.getText();
			String phone  = tbph.getText();
			String hq  = tbhq.getText();
			String dob  = ((JTextField)dtdob.getDateEditor().getUiComponent()).getText();
			String br  = (String) cbbr.getSelectedItem();
			String exp  = (String) cbexp.getSelectedItem();
			
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, fname);
			ps.setString(4, mname);
			ps.setString(5, add);
			ps.setString(6, pin);
			ps.setString(7, dob);
			ps.setString(8, phone);
			ps.setString(9, hq);
			ps.setString(10, br);
			ps.setString(11, exp);
			
			int rc = ps.executeUpdate();
			JOptionPane.showMessageDialog(null,rc+" Record Inserted Successfully");
			setVisible(false);
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== sub) {
			Insert_value();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AddFac();
	}
	
}
