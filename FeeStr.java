import java.awt.Color;
import java.awt.Font;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import net.proteanit.sql.DbUtils;

public class FeeStr extends JFrame {
	String url="jdbc:mysql:///university"; 
	String user="root";
	String pwd="system";
	String query = "select * from feestr;";
	
	FeeStr(){
		setSize(800,410);
		setLocation(330,100);
		getContentPane().setBackground(Color.CYAN);
		setLayout(null);
		
		JLabel hd = new JLabel("Coursewise Fee Structure");
		hd.setBounds(240,10,300,30);
		hd.setForeground(Color.MAGENTA);
		hd.setFont(new Font("Sariff",Font.BOLD,24));
		add(hd);
		
		JTable tab = new JTable();
		tab.setRowHeight(22);
		tab.setBackground(Color.GRAY);
		// Create a new DefaultTableCellRenderer
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();

        // Set the alignment of the renderer to center
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

		JScrollPane jsp = new JScrollPane(tab);
		jsp.setBounds(5,60,775,310);
		add(jsp);
		
		try {
			Connection con = DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();	
			tab.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FeeStr();
	}

}
