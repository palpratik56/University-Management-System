import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FeeRec extends JFrame implements ActionListener {
	JButton pr;
	Choice croll;
	String url="jdbc:mysql:///university"; 
	String user="root";
	String pwd="system";
	String query = "select * from receipt where roll = ?";
	String query1 = "select * from student";
	FeeRec(){
		setSize(360,500);
		setLocation(500,120);
		setLayout(null);
		
		JLabel rec = new JLabel("Fee Receipt");
		rec.setBounds(100,10,160,30);
		rec.setFont(new Font("Tahoma",Font.BOLD,24));
		rec.setForeground(Color.ORANGE);
		add(rec);
		
		JLabel sroll = new JLabel("Select Roll:");
		sroll.setBounds(50,50,90,30);
		sroll.setFont(new Font("Sariff",Font.BOLD,15));
		add(sroll);
		
		croll = new Choice();
		croll.setBounds(150,50,120,30); // location width,height,field width,height
		add(croll);
		
		try {
			Connection con = DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement(query1);
			ResultSet rs = ps.executeQuery();	
			while(rs.next()) {
				croll.add(rs.getString("roll"));
				}
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		JLabel sr = new JLabel("Roll: ");
		sr.setBounds(50,80,70,30);
		sr.setFont(new Font("Sariff",Font.BOLD,15));
		add(sr);
		
		JLabel lbroll1 = new JLabel();
		lbroll1.setBounds(130,80,140,30); // location width,height,field width,height
		lbroll1.setFont(new Font("tahoma",Font.HANGING_BASELINE,15));
		add(lbroll1);
		
		JLabel lbname = new JLabel("Name:");
		lbname.setBounds(50,120,60,30); // location width,height,field width,height
		lbname.setFont(new Font("tahoma",Font.BOLD,15));
		add(lbname);
		
		JLabel lbname1 = new JLabel();
		lbname1.setBounds(120,120,150,30); // location width,height,field width,height
		lbname1.setFont(new Font("tahoma",Font.HANGING_BASELINE,15));
		add(lbname1);
		
		JLabel lbco = new JLabel("Course:");
		lbco.setBounds(50,160,60,30); // location width,height,field width,height
		lbco.setFont(new Font("tahoma",Font.BOLD,15));
		add(lbco);
		
		JLabel lbco1 = new JLabel();
		lbco1.setBounds(120,160,150,30); // location width,height,field width,height
		lbco1.setFont(new Font("tahoma",Font.HANGING_BASELINE,15));
		add(lbco1);
		
		JLabel lbbr = new JLabel("Branch:");
		lbbr.setBounds(50,200,60,30); // location width,height,field width,height
		lbbr.setFont(new Font("tahoma",Font.BOLD,15));
		add(lbbr);
		
		JLabel lbbr1 = new JLabel();
		lbbr1.setBounds(120,200,150,30); // location width,height,field width,height
		lbbr1.setFont(new Font("tahoma",Font.HANGING_BASELINE,15));
		add(lbbr1);
		
		JLabel lbsem = new JLabel("Semester:");
		lbsem.setBounds(50,240,80,30); // location width,height,field width,height
		lbsem.setFont(new Font("tahoma",Font.BOLD,15));
		add(lbsem);
		
		JLabel lbsem1 = new JLabel();
		lbsem1.setBounds(140,240,60,30); // location width,height,field width,height
		lbsem1.setFont(new Font("tahoma",Font.HANGING_BASELINE,15));
		add(lbsem1);
		
		JLabel lbfee = new JLabel("Fee paid: ");
		lbfee.setBounds(50,280,80,30);
		lbfee.setFont(new Font("tahoma",Font.BOLD,15));
		add(lbfee);
		
		JLabel lbfee1 = new JLabel();
		lbfee1.setBounds(140,280,80,30);
		lbfee1.setFont(new Font("tahoma",Font.HANGING_BASELINE,15));
		add(lbfee1);
		
		JLabel lbopt = new JLabel("Payment Mode: ");
		lbopt.setBounds(50,320,120,30);
		lbopt.setFont(new Font("tahoma",Font.BOLD,15));
		add(lbopt);
		
		JLabel lbopt1 = new JLabel();
		lbopt1.setBounds(180,320,150,30); // location width,height,field width,height
		lbopt1.setFont(new Font("tahoma",Font.HANGING_BASELINE,15));
		add(lbopt1);
		
		JLabel lbtran = new JLabel("Transaction Id: ");
		lbtran.setBounds(50,360,120,30);
		lbtran.setFont(new Font("tahoma",Font.BOLD,15));
		add(lbtran);
		
		JLabel lbtran1 = new JLabel();
		lbtran1.setBounds(180,360,200,30); // location width,height,field width,height
		lbtran1.setFont(new Font("tahoma",Font.HANGING_BASELINE,15));
		add(lbtran1);
		
		try {
			Connection con = DriverManager.getConnection(url,user,pwd);
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, croll.getSelectedItem());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				lbname1.setText(rs.getString("name"));
				lbroll1.setText(rs.getString("roll"));
				lbco1.setText(rs.getString("course"));
				lbbr1.setText(rs.getString("branch"));
				lbsem1.setText(rs.getString("sem"));
				lbfee1.setText(rs.getString("amount"));
				lbopt1.setText(rs.getString("mode"));
				lbtran1.setText(rs.getString("trid"));
			}
			
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		croll.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				try {
					Connection con = DriverManager.getConnection(url,user,pwd);
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, croll.getSelectedItem());
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						lbname1.setText(rs.getString("name"));
						lbroll1.setText(rs.getString("roll"));
						lbco1.setText(rs.getString("course"));
						lbbr1.setText(rs.getString("branch"));
						lbsem1.setText(rs.getString("sem"));
						lbfee1.setText(rs.getString("amount"));
						lbopt1.setText(rs.getString("mode"));
						lbtran1.setText(rs.getString("trid"));
						}
				}catch(Exception e1) {
						e1.printStackTrace();
					}
			}
		});
		
		pr = new JButton("Print");
		pr.setBounds(130,410,80,30);
		pr.setFont(new Font("Sariff",Font.BOLD,15));
		pr.addActionListener(this);
		add(pr);
		
		setVisible(true);
	}
	
	public void PrintPage() {
		PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                // Print the content
                Graphics2D g2d = (Graphics2D) graphics;
                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                g2d.scale(0.4, 0.4);
                getContentPane().printAll(graphics);
                return Printable.PAGE_EXISTS;
            }
        });

        boolean doPrint = job.printDialog();
        if (doPrint) {
            try {
                job.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		PrintPage();   
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FeeRec();
	}
	

}
