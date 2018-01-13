package projectIBM;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.color.*;
import java.awt.event.*;
import java.sql.*;

public class Get_details extends JFrame implements ActionListener
{
	Statement stmt=null;
	Connection con=null;
	PreparedStatement ps=null;
	JTextField t1,t2,t3,t4,t5,t6;
	JLabel l1,l2,l3,l4,l5,l6;
	JButton b1;
	
	public Get_details()
	{
		getContentPane().setBackground(Color.ORANGE);
		l1=new JLabel("F_no");
		l2=new JLabel("Name");
		l3=new JLabel("Age");
		l4=new JLabel("Address");
		l5=new JLabel("Policy_1");
		l6=new JLabel("Policy_2");
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		t6=new JTextField();
		t2.setEditable(false);
		t3.setEditable(false);
		t4.setEditable(false);
		t5.setEditable(false);
		t6.setEditable(false);
		b1=new JButton("Fetch Details");

		setLayout(new BorderLayout());
		JLabel Background=new JLabel(new ImageIcon("C:\\Users\\A.K\\Desktop\\images_IBMproject\\doctors.jpg"));
		add(Background);
		Background.setLayout(null);
		
		l1.setBounds(230,70,70,30);
		t1.setBounds(340,70,200,30);
		l2.setBounds(230,120,70,30);
		t2.setBounds(340,120,200,30);
		l3.setBounds(230,170,70,30);
		t3.setBounds(340,170,150,30);
		l4.setBounds(230,220,70,30);
		t4.setBounds(340,220,350,30);
		l5.setBounds(230,270,70,30);
		t5.setBounds(340,270,200,30);
		l6.setBounds(230,320,70,30);
		t6.setBounds(340,320,200,30);
		b1.setBounds(370,400,150,40);
		Background.add(l1);Background.add(t1);Background.add(l2);Background.add(t2);Background.add(l3);Background.add(t3);
		Background.add(l4);Background.add(t4);Background.add(l5);Background.add(t5);Background.add(l6);Background.add(t6);Background.add(b1);
		b1.addActionListener(this);

	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try
			{
			
				double fno=Double.valueOf(t1.getText());
				
				Class.forName("oracle.jdbc.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ankit123");		
				
				ps=con.prepareStatement("select * from Fin_aid where fno=?");
				ps.setDouble(1, fno);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					t2.setText(rs.getString("Name"));
					t3.setText(String.valueOf(rs.getInt("Age")));
					t4.setText(rs.getString("Address"));
					t5.setText(rs.getString("Policy_1"));
					t6.setText(rs.getString("Policy_2"));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Record not found");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
	}

	public static void main(String[] args) 
	{
		Get_details gd=new Get_details();
		gd.setTitle("Registeration");
		gd.setResizable(false);
		gd.setLocation(60,60);
		gd.setSize(1000,640);
		gd.setDefaultCloseOperation(EXIT_ON_CLOSE);
		gd.setVisible(true);


	}

}
