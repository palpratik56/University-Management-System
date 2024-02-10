import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class UploadMarks extends JFrame implements ActionListener{
	Choice croll;
	JComboBox<?> csem;
	JTextField s1,s2,s3,s4,s5,m1,m2,m3,m4,m5;
	JButton up;
	
	String url="jdbc:mysql:///university"; 
	String user="root";
	String pwd="system";
	String query = "select * from student;";
	String query1 = "insert into subject values (?,?,?,?,?,?,?)";
	String query2 = "insert into marks values (?,?,?,?,?,?,?)";
	
	UploadMarks(){
		setSize(700,500);
		setLocation(370,100);
		getContentPane().setBackground(Color.CYAN);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
		Image i2 = i1.getImage().getScaledInstance(280,300,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel im = new JLabel(i3);
		im.setBounds(380,90,280,300);
		add(im);
		
		JLabel hd = new JLabel("Upload Student Marks");
		hd.setBounds(250,10,500,30);
		hd.setFont(new Font("tahoma",Font.BOLD,22));
		hd.setForeground(Color.MAGENTA);
		add(hd);
		

		JLabel sroll = new JLabel("Search Roll:");
		sroll.setBounds(30,60,100,30);
		sroll.setFont(new Font("Sariff",Font.BOLD,15));
		add(sroll);
		
		croll = new Choice();
		croll.setBounds(140,60,100,30); // location width,height,field width,height
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
		
		JLabel sem = new JLabel("Choose Semester:");
		sem.setBounds(30,100,140,30);
		sem.setFont(new Font("Sariff",Font.BOLD,15));
		add(sem);
		
		String[] jcsem = {"1st","2nd","3rd","4th","5th","6th","7th","8th","9th","10th"};
		csem = new JComboBox<Object>(jcsem);
		csem.setBounds(170,100,70,30); // location width,height,field width,height
		add(csem);
		
		JLabel lbname = new JLabel("Subject");
		lbname.setBounds(70,160,80,30); // location width,height,field width,height
		lbname.setFont(new Font("tahoma",Font.BOLD,15));
		add(lbname);
		
		JLabel lbname1 = new JLabel("Marks");
		lbname1.setBounds(210,160,80,30); // location width,height,field width,height
		lbname1.setFont(new Font("tahoma",Font.BOLD,15));
		add(lbname1);
		
		s1 = new JTextField();
		s1.setBounds(40,200,120,30); // location width,height,field width,height
		s1.setFont(new Font("tahoma",Font.BOLD,15));
		add(s1);
		
		s2 = new JTextField();
		s2.setBounds(40,240,120,30); // location width,height,field width,height
		s2.setFont(new Font("tahoma",Font.BOLD,15));
		add(s2);
		
		s3 = new JTextField();
		s3.setBounds(40,280,120,30); // location width,height,field width,height
		s3.setFont(new Font("tahoma",Font.BOLD,15));
		add(s3);
		
		s4 = new JTextField();
		s4.setBounds(40,320,120,30); // location width,height,field width,height
		s4.setFont(new Font("tahoma",Font.BOLD,15));
		add(s4);
		
		s5 = new JTextField();
		s5.setBounds(40,360,120,30); // location width,height,field width,height
		s5.setFont(new Font("tahoma",Font.BOLD,15));
		add(s5);
		

		m1 = new JTextField();
		m1.setBounds(180,200,120,30); // location width,height,field width,height
		m1.setFont(new Font("tahoma",Font.BOLD,15));
		add(m1);
		
		m2 = new JTextField();
		m2.setBounds(180,240,120,30); // location width,height,field width,height
		m2.setFont(new Font("tahoma",Font.BOLD,15));
		add(m2);
		
		m3 = new JTextField();
		m3.setBounds(180,280,120,30); // location width,height,field width,height
		m3.setFont(new Font("tahoma",Font.BOLD,15));
		add(m3);
		
		m4 = new JTextField();
		m4.setBounds(180,320,120,30); // location width,height,field width,height
		m4.setFont(new Font("tahoma",Font.BOLD,15));
		add(m4);
		
		m5 = new JTextField();
		m5.setBounds(180,360,120,30); // location width,height,field width,height
		m5.setFont(new Font("tahoma",Font.BOLD,15));
		add(m5);
		

	    up = new JButton("Upload");
	    up.setBounds(110,410,100,30);
	    up.setFont(new Font("Sariff",Font.BOLD,16));
	    up.addActionListener(this);
		add(up);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		try{
			Connection con = DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement(query1);
			PreparedStatement ps1 = con.prepareStatement(query2);
			String roll  = croll.getSelectedItem();
			String sem  = (String) csem.getSelectedItem();
			String su1  = s1.getText();
			String su2  = s2.getText();
			String su3  = s3.getText();
			String su4  = s4.getText();
			String su5  = s5.getText();
			
			ps.setString(1, roll);
			ps.setString(2, sem);
			ps.setString(3, su1);
			ps.setString(4, su2);
			ps.setString(5, su3);
			ps.setString(6, su4);
			ps.setString(7, su5);
			
			int rc = ps.executeUpdate();
			
			Float ma1  = Float.parseFloat(m1.getText());
			Float ma2  = Float.parseFloat(m2.getText());
			Float ma3  = Float.parseFloat(m3.getText());
			Float ma4  = Float.parseFloat(m4.getText());
			Float ma5  = Float.parseFloat(m5.getText());
			
			ps1.setString(1, roll);
			ps1.setString(2, sem);
			ps1.setFloat(3, ma1);
			ps1.setFloat(4, ma2);
			ps1.setFloat(5, ma3);
			ps1.setFloat(6, ma4);
			ps1.setFloat(7, ma5);
			
			ps1.executeUpdate();
			JOptionPane.showMessageDialog(null,rc+" Record Inserted Successfully");
			setVisible(false);
		}
		catch(Exception e1) {
		e1.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UploadMarks();
	}

}
