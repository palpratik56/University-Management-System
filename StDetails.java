import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import net.proteanit.sql.DbUtils;

public class StDetails extends JFrame implements ActionListener{
	Choice croll;
	JTable tb;
	JButton src,pr,upd,can;
	String url="jdbc:mysql:///university"; 
	String user="root";
	String pwd="system";
	
	StDetails(){
		setSize(1100,700);
		setLocation(180,20);
		getContentPane().setBackground(Color.CYAN);
		setLayout(null);
		
		JLabel sr = new JLabel("Search by Roll: ");
		sr.setBounds(50,20,120,30);
		sr.setFont(new Font("Sariff",Font.BOLD,15));
		add(sr);
		
		croll = new Choice();
		croll.setBounds(180,20,140,30); // location width,height,field width,height
		add(croll);
		String query = "select * from student;";
		
		try {
			Connection con = DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();	
			while(rs.next()) {
				croll.add(rs.getString("roll"));
				tb = new JTable();
				tb.setRowHeight(20); 
				// Create a new DefaultTableCellRenderer
		        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();

		        // Set the alignment of the renderer to center
		        renderer.setHorizontalAlignment(SwingConstants.CENTER);
				tb.setModel(DbUtils.resultSetToTableModel(rs));
				}
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		try {
			Connection con = DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();	
			tb = new JTable();
			tb.setRowHeight(20); 
			// Create a new DefaultTableCellRenderer
	        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();

	        // Set the alignment of the renderer to center
	        renderer.setHorizontalAlignment(SwingConstants.CENTER);
			tb.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		JScrollPane jsp = new JScrollPane(tb);
		jsp.setBounds(0,100,1100,560);
		add(jsp);
		
		//buttons
		src = new JButton("Search");
		src.setBounds(50,60,90,25);
		src.setFont(new Font("Sariff",Font.BOLD,14));
		src.addActionListener(this);
		add(src);
		
		pr = new JButton("Print");
		pr.setBounds(160,60,90,25);
		pr.setFont(new Font("Sariff",Font.BOLD,14));
		pr.addActionListener(this);
		add(pr);
		
		upd = new JButton("Update");
		upd.setBounds(270,60,90,25);
		upd.setFont(new Font("Sariff",Font.BOLD,14));
		upd.addActionListener(this);
		add(upd);
		
		can = new JButton("Close");
		can.setBounds(380,60,90,25);
		can.setFont(new Font("Sariff",Font.BOLD,14));
		can.addActionListener(this);
		add(can);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			if(e.getSource()== can) {
			setVisible(false);
			}
			else if(e.getSource()== src) {
				Connection con = DriverManager.getConnection(url,user,pwd);
				String query = "select * from student where roll = ?;";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, croll.getSelectedItem());
				ResultSet rs = ps.executeQuery();	
				tb.setModel(DbUtils.resultSetToTableModel(rs));
			}
			else if(e.getSource()== pr) {
					tb.print();
			}
			else {
				new UpStu();
			}
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StDetails();

	}
	

}
