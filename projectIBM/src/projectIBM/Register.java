package projectIBM;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.color.*;
import java.awt.event.*;
import java.sql.*;
import java.lang.Math.*;

public class Register extends JFrame implements ActionListener
{
	Statement stmt=null;
	Connection con=null;
	PreparedStatement ps=null;
	JTextField t1,t2,t3,t4,t5,t6;
	JLabel l1,l2,l3,l4,l5,l6;
	JButton b1;
	
	public Register()
	{
		getContentPane().setBackground(Color.ORANGE);
		l1=new JLabel("F_no");
		l2=new JLabel("Name");
		l3=new JLabel("Age");
		l4=new JLabel("Address");
		l5=new JLabel("Policy_1");
		l6=new JLabel("Policy_2");
		t1=new JTextField();
		t1.setEditable(false);
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		t6=new JTextField();
		b1=new JButton("Submit");

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
		b1.setBounds(370,400,100,40);
		Background.add(l1);Background.add(t1);Background.add(l2);Background.add(t2);Background.add(l3);Background.add(t3);
		Background.add(l4);Background.add(t4);Background.add(l5);Background.add(t5);Background.add(l6);Background.add(t6);Background.add(b1);
		b1.addActionListener(this);

	}
	public void create()
	{
		try
		{
		Statement stmt=con.createStatement();
		String sql="Create table Fin_aid(fno number(25,20), Name varchar(30), Age number, Address varchar(30), Policy_1 varchar(30), Policy_2 varchar(30))";
		stmt.executeUpdate(sql);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try
			{
				int fno=(int)((Math.random()*90000)+10000);
				String name=t2.getText();
				int age=Integer.parseInt(t3.getText());
				String address=t4.getText();
				String policy_1=t5.getText();
				String policy_2=t6.getText();
				
				Class.forName("oracle.jdbc.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ankit123");		
				create();
				ps=con.prepareStatement("insert into Fin_aid values(?,?,?,?,?,?)");
				ps.setDouble(1, fno );
				ps.setString(2, name);
				ps.setInt(3, age);
				ps.setString(4, address);
				ps.setString(5, policy_1);
				ps.setString(6, policy_2);
				int rs=ps.executeUpdate();
				if(rs==1)
				{
					JOptionPane.showMessageDialog(null, "Record added");
					t1.setText(String.valueOf(fno));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Error adding record");
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
		Register r=new Register();
		r.setTitle("Registeration");
		r.setResizable(false);
		r.setLocation(60,60);
		r.setSize(1000,640);
		r.setDefaultCloseOperation(EXIT_ON_CLOSE);
		r.setVisible(true);


	}

}
