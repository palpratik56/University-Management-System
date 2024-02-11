import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class UpStu extends JFrame implements ActionListener {
	JTextField tbadd,tbpin,tbph;
	JLabel lbname1,lbfname1,lbmname1,dob,X,Xii;
	JButton sub;
	Choice croll;
	JComboBox <?> cbco,cbbr;
	String url="jdbc:mysql:///university"; 
	String user="root";
	String pwd="system";
	String query = "select * from student";
	String query1 = "select * from student where roll = ?";
	
	UpStu(){
		setSize(750,550);
		setLocation(350,30);
		getContentPane().setBackground(Color.CYAN);
		setLayout(null);
		
		JLabel hd = new JLabel("Update Student Details");
		hd.setBounds(250,20,500,30);
		hd.setFont(new Font("tahoma",Font.BOLD,22));
		hd.setForeground(Color.MAGENTA);
		add(hd);
		

		JLabel sroll = new JLabel("Search Roll Number:");
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
				croll.add(rs.getString("roll"));
				}
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		JLabel lbname = new JLabel("Name:");
		lbname.setBounds(80,100,60,30); // location width,height,field width,height
		lbname.setFont(new Font("tahoma",Font.BOLD,15));
		add(lbname);
		
		JLabel lbname1 = new JLabel();
		lbname1.setBounds(150,100,120,30); // location width,height,field width,height
		lbname1.setFont(new Font("tahoma",Font.HANGING_BASELINE,15));
		add(lbname1);
		
		JLabel lbfname = new JLabel("Father's Name:");
		lbfname.setBounds(390,100,120,30);
		lbfname.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbfname);
		
		JLabel lbfname1 = new JLabel();
		lbfname1.setBounds(520,100,150,30); // location width,height,field width,height
		lbfname1.setFont(new Font("tahoma",Font.HANGING_BASELINE,15));
		add(lbfname1);
		
		JLabel lbmname = new JLabel("Mother's Name:");
		lbmname.setBounds(20,150,120,30);
		lbmname.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbmname);
		
		JLabel lbmname1 = new JLabel();
		lbmname1.setBounds(150,150,120,30); // location width,height,field width,height
		lbmname1.setFont(new Font("tahoma",Font.HANGING_BASELINE,15));
		add(lbmname1);
		
		JLabel lbroll = new JLabel("Roll Number:");
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
		add(dob);
		
		JLabel lbph = new JLabel("Contact No.:");
		lbph.setBounds(50,300,100,30);
		lbph.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbph);
		
		 tbph = new JTextField();
		tbph.setBounds(140,300,120,30);
		add(tbph);
		
		JLabel lbX = new JLabel("Class X Marks(%):");
		lbX.setBounds(370,300,140,30);
		lbX.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbX);
		
		JLabel X = new JLabel();
		X.setBounds(510,300,70,30); // location width,height,field width,height
		X.setFont(new Font("tahoma",Font.HANGING_BASELINE,15));
		//getval(X,"X(%)");
		add(X);
		
		JLabel lbXII = new JLabel("Class XII Marks(%):");
		lbXII.setBounds(20,350,140,30);
		lbXII.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbXII);
		
		JLabel Xii = new JLabel();
		Xii.setBounds(170,350,70,30); // location width,height,field width,height
		Xii.setFont(new Font("tahoma",Font.HANGING_BASELINE,15));
		//getval(Xii,"XII(%)");
		add(Xii);
	
		JLabel lbco = new JLabel("Choose Course:");
		lbco.setBounds(380,350,140,30);
		lbco.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbco);
		
		String course [] = {"BSc","BA","BCom","BCA","BBA","BTech","MTech","MSc","MA","MCom",
				            "MCA","MBA","Phd"};
		cbco = new JComboBox<Object>(course);
		cbco.setBounds(510,350,70,30);
		add(cbco);
		
		JLabel lbbr = new JLabel("Choose Branch:");
		lbbr.setBounds(250,400,140,30);
		lbbr.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbbr);
		
		String branch [] = {"ENGLISH","BENGALI","HISTORY","GEOGRAPHY","POLITICAL SCIENCE",
				"MARKETING","BANKING","FINTECH","MATHS","CHEMISTRY","PHYSICS","DATA SCIENCE",
				"COMPUTER SCIENCE"};
		cbbr = new JComboBox<Object>(branch);
		cbbr.setBounds(390,400,150,30);
		add(cbbr);
		
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
				lbr.setText(rs.getString("roll"));
				dob.setText(rs.getString("dob"));
				X.setText(rs.getString("X(%)"));
				Xii.setText(rs.getString("XII(%)"));
				tbadd.setText(rs.getString("address"));
				tbpin.setText(rs.getString("pin"));
				tbph.setText(rs.getString("contact"));
				cbco.setSelectedItem(rs.getString("course"));
				cbbr.setSelectedItem(rs.getString("branch"));
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
						X.setText(rs.getString("X(%)"));
						Xii.setText(rs.getString("XII(%)"));
						tbadd.setText(rs.getString("address"));
						tbpin.setText(rs.getString("pin"));
						tbph.setText(rs.getString("contact"));
						cbco.setSelectedItem(rs.getString("course"));
						cbbr.setSelectedItem(rs.getString("branch"));
						}
					
				}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			});
	}
	
	public void Update_value() {
		try {
			String query = "update student set address = ?,pin = ?,contact = ?,course = ?,"
					+ "branch = ? where roll = ?";
			Connection con = DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement(query);
		
			String add  = tbadd.getText();
			String pin  = tbpin.getText();
			String phone  = tbph.getText();
			String co  = (String) cbco.getSelectedItem();
			String br  = (String) cbbr.getSelectedItem();
			ps.setString(1, add);
			ps.setString(2, pin);
			ps.setString(3, phone);
			ps.setString(4, co);
			ps.setString(5, br);
			ps.setString(6, croll.getSelectedItem());
			
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
		new UpStu();
	}
}


