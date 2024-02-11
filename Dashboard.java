import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
	
	Dashboard(){
		setSize(700,500);
		setLocation(350,70);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
		Image i2 = i1.getImage().getScaledInstance(700,440,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel im = new JLabel(i3);
		im.setBounds(0,0, 700, 440);
		add(im);
		
		JMenuBar mb = new JMenuBar();
		//new info
		JMenu info = new JMenu("New Info");
		info.setForeground(Color.BLUE);
		info.setFont(new Font("Sariff", Font.BOLD,16));
		mb.add(info);
		
		JMenuItem fac = new JMenuItem("New Faculty");
		fac.addActionListener(this);
		info.add(fac);
		JMenuItem stu = new JMenuItem("New Student");
		stu.addActionListener(this);
		info.add(stu);
		
		//details
		JMenu det = new JMenu("Details");
		det.setForeground(Color.green);
		det.setFont(new Font("Sariff", Font.BOLD,16));
		mb.add(det);
		
		JMenuItem fac1 = new JMenuItem("Faculty");
		det.add(fac1);
		fac1.addActionListener(this);
		JMenuItem stu1 = new JMenuItem("Student");
		det.add(stu1);
		stu1.addActionListener(this);
		JMenuItem hos1 = new JMenuItem("Hostel");
		hos1.addActionListener(this);
		det.add(hos1);
		
		//leave 
		JMenu l = new JMenu("Leave");
		l.setForeground(Color.red);
		l.setFont(new Font("Sariff", Font.BOLD,16));
		mb.add(l);
		
		JMenuItem app = new JMenuItem("Apply for Student leave");
		l.add(app);
		app.addActionListener(this);
		JMenuItem vl = new JMenuItem("View Student leaves");
		l.add(vl);
		vl.addActionListener(this);
		JMenuItem app1 = new JMenuItem("Apply for Faculty leave");
		l.add(app1);
		app1.addActionListener(this);
		JMenuItem vl1 = new JMenuItem("View Faculty leaves");
		l.add(vl1);
		vl1.addActionListener(this);
		
		//Exam
		JMenu ex = new JMenu("Examination");
		ex.setForeground(Color.MAGENTA);
		ex.setFont(new Font("Sariff", Font.BOLD,16));
		mb.add(ex);
		
		JMenuItem up = new JMenuItem("Upload marks");
		ex.add(up);
		up.addActionListener(this);
		JMenuItem res = new JMenuItem("Check result");
		res.addActionListener(this);
		ex.add(res);
		JMenuItem rev = new JMenuItem("Apply for review");
		rev.addActionListener(this);
		ex.add(rev);
		
		//Fee
		JMenu f = new JMenu("Fee");
		f.setForeground(Color.ORANGE);
		f.setFont(new Font("Sariff", Font.BOLD,16));
		mb.add(f);
		
		JMenuItem st = new JMenuItem("Fee structure");
		f.add(st);
		st.addActionListener(this);
		JMenuItem s = new JMenuItem("Submit fees");
		s.addActionListener(this);
		f.add(s);
		JMenuItem r = new JMenuItem("View receipt");
		r.addActionListener(this);
		f.add(r);
		
		JMenu exit = new JMenu("Exit");
		exit.setForeground(Color.BLACK);
		exit.setFont(new Font("Sariff", Font.BOLD,16));
		mb.add(exit);
		
		JMenuItem e1 = new JMenuItem("Exit");
		e1.addActionListener(this);
		exit.add(e1);
		
		setJMenuBar(mb);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = e.getActionCommand();
		if(msg.equals("Exit")) {
			setVisible(false);
		}
		else if(msg.equals("New Faculty")) {
			new AddFac();
		}
		else if(msg.equals("New Student")) {
			new AddStu();
		}
		else if(msg.equals("Student")) {
			new StDetails();
		}
		else if(msg.equals("Faculty")) {
			new FacDetails();
		}
		else if(msg.equals("Hostel")) {
			new Hostel();
		}
		else if(msg.equals("Apply for Student leave")) {
			new StLeave();
		}
		else if(msg.equals("Apply for Faculty leave")) {
			new FacLeave();
		}
		else if(msg.equals("View Student leaves")) {
			new StLeaveDet();
		}
		else if(msg.equals("View Faculty leaves")) {
			new FacLeaveDet();
		}
		else if(msg.equals("Upload marks")) {
			new UploadMarks();
		}
		else if(msg.equals("Check result")) {
			new ChResult();
		}
		else if(msg.equals("Fee structure")) {
			new FeeStr();
		}
		else if(msg.equals("Submit fees")) {
			new FeeSub();
		}
		else if(msg.equals("View receipt")) {
			new FeeRec();
		}
		else if(msg.equals("Apply for review")) {
			new Review();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Dashboard();
	}

}
