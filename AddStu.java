import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class AddStu extends JFrame implements ActionListener {
	JTextField tbname,tbfname,tbmname,tbroll,tbadd,tbpin,tbph,tbX,tbXII;
	JDateChooser dtdob;
	JComboBox<?> cbbr,cbco;
	JButton sub;
	
	AddStu(){
		setSize(700,550);
		setLocation(350,30);
		getContentPane().setBackground(Color.CYAN);
		setLayout(null);
		
		JLabel hd = new JLabel("New Student Details");
		hd.setBounds(240,30,500,30);
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
		
		JLabel lbroll = new JLabel("Roll Number:");
		lbroll.setBounds(390,150,120,30);
		lbroll.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbroll);
		
		 tbroll = new JTextField("JNU/23/");
		tbroll.setBounds(510,150,150,30);
		add(tbroll);
		
		JLabel lbadd = new JLabel("Address:");
		lbadd.setBounds(60,200,100,30);
		lbadd.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbadd);
		
		 tbadd = new JTextField();
		tbadd.setBounds(140,200,520,30);
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
		
		JLabel lbX = new JLabel("Class X Marks(%):");
		lbX.setBounds(370,300,140,30);
		lbX.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbX);
		
		 tbX = new JTextField();
		tbX.setBounds(510,300,70,30);
		add(tbX);
		
		JLabel lbXII = new JLabel("Class XII Marks(%):");
		lbXII.setBounds(20,350,140,30);
		lbXII.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbXII);
		
		 tbXII = new JTextField();
		tbXII.setBounds(170,350,70,30);
		add(tbXII);
		
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
		lbbr.setBounds(380,400,140,30);
		lbbr.setFont(new Font("Sariff",Font.BOLD,15));
		add(lbbr);
		
		String branch [] = {"ENGLISH","BENGALI","HISTORY","GEOGRAPHY","POLITICAL SCIENCE",
				"MARKETING","BANKING","FINTECH","MATHS","CHEMISTRY","PHYSICS","DATA SCIENCE",
				"COMPUTER SCIENCE"};
		cbbr = new JComboBox<Object>(branch);
		cbbr.setBounds(510,400,140,30);
		add(cbbr);
		
	    sub = new JButton("Submit");
	    sub.setBounds(280,460,100,30);
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
			String query = "insert into student values(?,?,?,?,?,?,?,?,?,?,?,?);";
			Connection con = DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement(query);
			
			String name  = tbname.getText();
			String fname  = tbfname.getText();
			String mname  = tbmname.getText();
			String roll  = tbroll.getText();
			String add  = tbadd.getText();
			String pin  = tbpin.getText();
			String phone  = tbph.getText();
			Float X  = Float.parseFloat(tbX.getText());
			Float Xii  = Float.parseFloat(tbXII.getText());
			String dob  = ((JTextField)dtdob.getDateEditor().getUiComponent()).getText();
			String co  = (String) cbco.getSelectedItem();
			String br  = (String) cbbr.getSelectedItem();
			
			ps.setString(1, roll);
			ps.setString(2, name);
			ps.setString(3, fname);
			ps.setString(4, mname);
			ps.setString(5, add);
			ps.setString(6, pin);
			ps.setString(7, dob);
			ps.setString(8, phone);
			ps.setFloat(9, X);
			ps.setFloat(10, Xii);
			ps.setString(11, co);
			ps.setString(12, br);
			
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
		new AddStu();
	}
	
}
