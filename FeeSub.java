import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import javax.swing.*;

public class FeeSub extends JFrame implements ActionListener{
	Choice croll,copt;
	JLabel lbname,lbco,cbco,lbbr,cbbr,lbsem,lbfee,lbam,lbopt;
	JComboBox<Object> csem;
	JButton get,pay;
	String url="jdbc:mysql:///university"; 
	String user="root";
	String pwd="system";
	String query = "select * from student;";
	String query1 = "select * from student where roll = ?;";
	
	FeeSub(){
		setSize(700,550);
		setLocation(370,100);
		getContentPane().setBackground(Color.CYAN);
		setLayout(null);
		
		JLabel hd = new JLabel("Fee Submission Page");
		hd.setBounds(250,10,250,40);
		hd.setForeground(Color.MAGENTA);
		hd.setFont(new Font("Sariff",Font.CENTER_BASELINE,20));
		add(hd);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
		Image i2 = i1.getImage().getScaledInstance(350,380,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel im = new JLabel(i3);
		im.setBounds(350,70,350,380);
		add(im);
		
		JLabel sr = new JLabel("Search Roll: ");
		sr.setBounds(50,90,100,30);
		sr.setFont(new Font("Sariff",Font.BOLD,15));
		add(sr);
		
		croll = new Choice();
		croll.setBounds(150,90,130,30); // location width,height,field width,height
		add(croll);
		
		JLabel lbname1 = new JLabel("Name:");
		lbname1.setBounds(50,130,60,30); // location width,height,field width,height
		lbname1.setFont(new Font("tahoma",Font.BOLD,15));
		add(lbname1);
		
		lbname = new JLabel();
		lbname.setBounds(110,130,150,30); // location width,height,field width,height
		lbname.setFont(new Font("tahoma",Font.HANGING_BASELINE,15));
		add(lbname);
		

		lbco = new JLabel("Course:");
		lbco.setBounds(50,170,60,30); // location width,height,field width,height
		lbco.setFont(new Font("tahoma",Font.BOLD,15));
		add(lbco);
		

		lbbr = new JLabel("Branch:");
		lbbr.setBounds(50,210,60,30); // location width,height,field width,height
		lbbr.setFont(new Font("tahoma",Font.BOLD,15));
		add(lbbr);
		

		lbsem = new JLabel("Semester:");
		lbsem.setBounds(50,250,80,30); // location width,height,field width,height
		lbsem.setFont(new Font("tahoma",Font.BOLD,15));
		add(lbsem);
		

		lbfee = new JLabel("Fee to be paid: ");
		lbfee.setBounds(50,290,140,40);
		lbfee.setFont(new Font("tahoma",Font.BOLD,17));
		add(lbfee);
		
		lbam = new JLabel();
		lbam.setBounds(200,290,80,40);
		lbam.setForeground(Color.RED);
		lbam.setFont(new Font("tahoma",Font.PLAIN,16));
		add(lbam);
		
		lbopt = new JLabel("Payment Mode: ");
		lbopt.setBounds(50,330,120,30);
		lbopt.setFont(new Font("tahoma",Font.BOLD,15));
		add(lbopt);
		
		get = new JButton("Get Fee");
		get.setBounds(50,380,100,30);
		get.setFont(new Font("Sariff",Font.CENTER_BASELINE,14));
		get.addActionListener(this);
		add(get);
		
		pay = new JButton("Pay Fee");
		pay.setBounds(180,380,100,30);
		pay.setFont(new Font("Sariff",Font.CENTER_BASELINE,14));
		pay.addActionListener(this);
		add(pay);
		
		croll.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				try {
					Connection con = DriverManager.getConnection(url,user,pwd);
					PreparedStatement ps = con.prepareStatement(query);
					PreparedStatement ps1 = con.prepareStatement(query1);
					ps1.setString(1, croll.getSelectedItem());
					ResultSet rs = ps.executeQuery();
					ResultSet rs1 = ps1.executeQuery();
					while(rs.next()) {
						croll.add(rs.getString("roll"));
						}
					while(rs1.next()) {
						lbname.setText(rs1.getString("name"));
						cbco.setText(rs1.getString("course"));
						cbbr.setText(rs1.getString("branch"));
						}
				}catch(Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		
		cbco = new JLabel();
		cbco.setFont(new Font("tahoma",Font.HANGING_BASELINE,15));
		cbco.setBounds(120,170,80,30);
		add(cbco);
		
		cbbr = new JLabel();
		cbbr.setFont(new Font("tahoma",Font.HANGING_BASELINE,15));
		cbbr.setBounds(120,210,140,30);
		add(cbbr);
		
		
		String[] jcsem = {"sem1","sem2","sem3","sem4","sem5","sem6","sem7","sem8",
				   "sem9","sem10"};
		csem = new JComboBox<Object>(jcsem);
		csem.setBounds(140,250,70,30); // location width,height,field width,height
		add(csem);
		
		copt = new Choice();
		copt.setBounds(180,335,110,30);
		copt.setFont(new Font("tahoma",Font.CENTER_BASELINE,14));
		copt.add("Cash");
		copt.add("Card");
		copt.add("UPI");
		copt.add("Net Banking");
		add(copt);
		
		try {
			Connection con = DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				croll.add(rs.getString("roll"));
				lbname.setText(rs.getString("name"));
				cbco.setText(rs.getString("course"));
				cbbr.setText(rs.getString("branch"));
				}
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== get) {
			try {
				Connection con = DriverManager.getConnection(url,user,pwd);
				String query = "select * from feestr where course = ?;";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, cbco.getText());
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					lbam.setText(rs.getString((String)csem.getSelectedItem()));
					}
			}catch(Exception e1) {
					e1.printStackTrace();
				}
		}
		else {
			try {
				Connection con = DriverManager.getConnection(url,user,pwd);
				String query = "insert into receipt values(?,?,?,?,?,?,?,?);";
				PreparedStatement ps = con.prepareStatement(query);
				
				String name  = lbname.getText();
				String roll  = (String)croll.getSelectedItem();
				String co  = cbco.getText();
				String br  = cbbr.getText();
				String sem = (String)csem.getSelectedItem();
				String amount = lbam.getText();
				String opt = (String)copt.getSelectedItem();
				String tranid = "JNU2023110067"+roll.substring(8,roll.length())
									+name.charAt(0);
				ps.setString(1, roll);
				ps.setString(2, name);
				ps.setString(3, co);
				ps.setString(4, br);
				ps.setString(5, sem);
				ps.setString(6, amount);
				ps.setString(7, opt);
				ps.setString(8, tranid);
				
				ps.executeUpdate();
				JOptionPane.showMessageDialog(null,"Fee paid Successfully for "+name);
				setVisible(false);
				
			}catch(Exception e1) {
					e1.printStackTrace();
				}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FeeSub();
	}

}


	