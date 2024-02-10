import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Admin extends JFrame implements ActionListener {
	
	JButton login,can;
	JTextField tuname;
	JPasswordField tupwd;
	Admin(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel im = new JLabel(i3);
		im.setBounds(5,5,200,200);
		add(im);
		
		
		JLabel luname = new JLabel("Give Username:");
		luname.setBounds(220,30,100,30);
		add(luname);
		
		tuname = new JTextField();
		tuname.setBounds(320,30,200,30);
		add(tuname);
		
		JLabel lupwd = new JLabel("Give Password:");
		lupwd.setBounds(220,70,100,30);
		add(lupwd);
		
		tupwd = new JPasswordField();
		tupwd.setBounds(320,70,200,30);
		add(tupwd);
		
		login = new JButton("Login");
		login.setBounds(330, 120, 80, 30);
		login.setFont(new Font("Tahoma",Font.CENTER_BASELINE,14));
		login.addActionListener(this);
		add(login);
		
		can = new JButton("Cancel");
		can.setBounds(425, 120, 80, 30);
		can.setFont(new Font("Tahoma",Font.CENTER_BASELINE,14));
		can.addActionListener(this);
		add(can);
		
		setLocation(400,150);
		setSize(600,300);
		setVisible(true);
		
	}
	
	public PreparedStatement fetch_user(String u,char[] p) {
		PreparedStatement ps = null ;
		try {
			String url="jdbc:mysql:///university"; 
			String user="root";
			String pwd="system";
			Connection con = DriverManager.getConnection(url,user,pwd);
			
			String str1 = String.valueOf(p);
			String query = "select * from admin where uid ='"+u+"'and password = '"+str1+"'";
			ps = con.prepareStatement(query);
			ResultSet rs =ps.executeQuery();
			
			if(rs.next()) {
				setVisible(false);
				new Dashboard();
			}
			else {
				JOptionPane.showMessageDialog(null,"Invalid userid or password");
				setVisible(false);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ps;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login) {
			String user = tuname.getText();
			char[] pwd = tupwd.getPassword();
			fetch_user(user,pwd);
		}
		else {
			setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Admin();
	}
	
}
