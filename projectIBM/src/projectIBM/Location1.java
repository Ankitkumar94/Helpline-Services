package projectIBM;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.*;

public class Location1 extends JFrame implements ActionListener
{
	Vector columns_name=new Vector();
	Vector data=new Vector();
	JPanel p=new JPanel();
	
	Connection con=null;
	PreparedStatement ps=null;
	Statement stmt=null;
	JComboBox cb;
	JLabel l1;
	JButton b1;
	String k;
	
	public Location1()
	{
		//getContentPane().setBackground(Color.PINK);
		l1=new JLabel("Select your location");
		l1.setFont(new Font("",Font.BOLD,20));
		cb=new JComboBox();
		cb.addItem("**Select**");
		cb.addItem("Greater Kailash");
		cb.addItem("Janakpuri");
		cb.addItem("Pushp Vihar");
		cb.addItem("Munirka");
		cb.addItem("Karol Bagh");
		b1=new JButton("OK");

		setLayout(new BorderLayout());
		JLabel Background=new JLabel(new ImageIcon("C:\\Users\\A.K\\Desktop\\images_IBMproject\\Blood.jpg"));
		add(Background);
		Background.setLayout(null);
		
		cb.setBounds(120,130,100,30);
		l1.setBounds(80,80,200,30);
		b1.setBounds(130,200,70,30);
		Background.add(cb); Background.add(l1); Background.add(b1);
		cb.addActionListener(this);
		b1.addActionListener(this);
		}
	public void connect()
	{
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","ankit123");
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void create()
	{
		try
		{
		
		stmt=con.createStatement();
		String sql="Create table B_Bank(Name varchar(20), Area varchar(20), Address varchar(30), PhoneNo number, Distance_gk number, Distance_jp number, Distance_pv number, Distance_mk number, Distance_kb number)";
		stmt.executeUpdate(sql);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void insert()
	{
		try
		{
			
			stmt=con.createStatement();
			String sql="insert into B_Bank values('Rotary_BBank','gk1','30@gk1',9987562301,1,3,7,2,5)";
			stmt.executeUpdate(sql);
			sql="insert into B_Bank values('Sai_BBank','gk2','123@gk2',9237562301,1.5,2,2.7,8,3)";
			stmt.executeUpdate(sql);
			sql="insert into B_Bank values('Cross_BBank','jp1','tc@4',9987902301,5,2,6,12,4.5)";
			stmt.executeUpdate(sql);
			sql="insert into B_Bank values('DD_BBank','jp2','jp@II',9785562301,4,1.8,9,3,2.5)";
			stmt.executeUpdate(sql);
			sql="insert into B_Bank values('Rotary_BBank','pv1','pspIV',9987562364,8.5,6,1,4,8)";
			stmt.executeUpdate(sql);
			sql="insert into B_Bank values('PV_BBank','pv2','pspV',9987564538,5,2,2,4,3.5)";
			stmt.executeUpdate(sql);
			sql="insert into B_Bank values('ST_BBank','mk1','mk@48',8876458913,4,3,2,1.5,8)";
			stmt.executeUpdate(sql);
			sql="insert into B_Bank values('Singh_BBank','mk2','mk@96',9076453728,4,7,3,1.3,5)";
			stmt.executeUpdate(sql);
			sql="insert into B_Bank values('Bless_BBank','kb1','sec_II',9086455643,9,3,2,4,1)";
			stmt.executeUpdate(sql);
			sql="insert into B_Bank values('Rotary_BBank','kb2','sec_VI',9845375698,10,3.5,2,7,1.5)";
			stmt.executeUpdate(sql);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource()==cb)
		{ 
			k=cb.getSelectedItem().toString();
		}
		if(ae.getSource()==b1)
		{
			
			if(k=="Greater Kailash")
			{
				//this.dispose();
				//this.setVisible(false);
			try
			{
				connect();
				Statement stmt=con.createStatement();
				String sql="Select Name,Area,Address,PhoneNo,Distance_gk from B_Bank where Distance_gk<=4";
				ResultSet rs=stmt.executeQuery(sql);
				ResultSetMetaData md=rs.getMetaData();
				int columns=md.getColumnCount();
		
				for(int i=1; i<=columns; i++)
				{
					columns_name.addElement(md.getColumnName(i));
				}

				while(rs.next())
				{
					Vector row=new Vector(columns);
					for(int j=1; j<=columns; j++)
					{
						row.addElement(rs.getObject(j));
					}
					data.addElement(row);
				}
				rs.close();
				stmt.close();
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			JTable table=new JTable(data,columns_name);
			
			JScrollPane scrollpane=new JScrollPane(table);
			p.add(scrollpane);
			JFrame f=new JFrame();
			f.add(p);
			f.setSize(600, 400);
			f.setVisible(true);
			scrollpane.getViewport().setBackground(Color.BLACK);
			table.setRowHeight(40);
				
			}
			
			else if(k=="Janakpuri")
			{
				//this.dispose();
				//this.setVisible(false);
			try
			{
				connect();
				Statement stmt=con.createStatement();
				String sql="Select Name,Area,Address,PhoneNo,Distance_jp from B_Bank where Distance_jp<=4";
				ResultSet rs=stmt.executeQuery(sql);
				ResultSetMetaData md=rs.getMetaData();
				int columns=md.getColumnCount();
		
				for(int i=1; i<=columns; i++)
				{
					columns_name.addElement(md.getColumnName(i));
				}

				while(rs.next())
				{
					Vector row=new Vector(columns);
					for(int j=1; j<=columns; j++)
					{
						row.addElement(rs.getObject(j));
					}
					data.addElement(row);
				}
				rs.close();
				stmt.close();
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			JTable table=new JTable(data,columns_name);
			
			JScrollPane scrollpane=new JScrollPane(table);
			p.add(scrollpane);
			JFrame f=new JFrame();
			f.add(p);
			f.setSize(600, 400);
			f.setVisible(true);
			scrollpane.getViewport().setBackground(Color.BLACK);
			table.setRowHeight(40);
				
			}
			else if(k=="Pushp Vihar")
			{
				//this.dispose();
				//this.setVisible(false);
			try
			{
				connect();
				Statement stmt=con.createStatement();
				String sql="Select Name,Area,Address,PhoneNo,Distance_pv from B_Bank where Distance_pv<=4";
				ResultSet rs=stmt.executeQuery(sql);
				ResultSetMetaData md=rs.getMetaData();
				int columns=md.getColumnCount();
		
				for(int i=1; i<=columns; i++)
				{
					columns_name.addElement(md.getColumnName(i));
				}

				while(rs.next())
				{
					Vector row=new Vector(columns);
					for(int j=1; j<=columns; j++)
					{
						row.addElement(rs.getObject(j));
					}
					data.addElement(row);
				}
				rs.close();
				stmt.close();
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			JTable table=new JTable(data,columns_name);
			
			JScrollPane scrollpane=new JScrollPane(table);
			p.add(scrollpane);
			JFrame f=new JFrame();
			f.add(p);
			f.setSize(600, 400);
			f.setVisible(true);
			scrollpane.getViewport().setBackground(Color.BLACK);
			table.setRowHeight(40);
				
			}
			
			else if(k=="Munirka")
			{
				//this.dispose();
				//this.setVisible(false);
			try
			{
				connect();
				Statement stmt=con.createStatement();
				String sql="Select Name,Area,Address,PhoneNo,Distance_mk from B_Bank where Distance_mk<=4";
				ResultSet rs=stmt.executeQuery(sql);
				ResultSetMetaData md=rs.getMetaData();
				int columns=md.getColumnCount();
		
				for(int i=1; i<=columns; i++)
				{
					columns_name.addElement(md.getColumnName(i));
				}

				while(rs.next())
				{
					Vector row=new Vector(columns);
					for(int j=1; j<=columns; j++)
					{
						row.addElement(rs.getObject(j));
					}
					data.addElement(row);
				}
				rs.close();
				stmt.close();
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			JTable table=new JTable(data,columns_name);
			
			JScrollPane scrollpane=new JScrollPane(table);
			p.add(scrollpane);
			JFrame f=new JFrame();
			f.add(p);
			f.setSize(600, 400);
			f.setVisible(true);
			scrollpane.getViewport().setBackground(Color.BLACK);
			table.setRowHeight(40);
				
			}
			if(k=="Karol Bagh")
			{
				//this.dispose();
				//this.setVisible(false);
			try
			{
				connect();
				Statement stmt=con.createStatement();
				String sql="Select Name,Area,Address,PhoneNo,Distance_kb from B_Bank where Distance_kb<=4";
				ResultSet rs=stmt.executeQuery(sql);
				ResultSetMetaData md=rs.getMetaData();
				int columns=md.getColumnCount();
		
				for(int i=1; i<=columns; i++)
				{
					columns_name.addElement(md.getColumnName(i));
				}

				while(rs.next())
				{
					Vector row=new Vector(columns);
					for(int j=1; j<=columns; j++)
					{
						row.addElement(rs.getObject(j));
					}
					data.addElement(row);
				}
				rs.close();
				stmt.close();
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			JTable table=new JTable(data,columns_name);
			
			JScrollPane scrollpane=new JScrollPane(table);
			p.add(scrollpane);
			JFrame f=new JFrame();
			f.add(p);
			f.setSize(600, 400);
			f.setVisible(true);
			scrollpane.getViewport().setBackground(Color.BLACK);
			table.setRowHeight(40);
				
			}

		}		
}
	
	public static void main(String[] args) 
	{
		Location1 lc1=new Location1();
		lc1.setTitle("Location");
		lc1.setResizable(false);
		lc1.setLocation(60, 60);
		lc1.setSize(1000,640);
		lc1.setVisible(true);
		lc1.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
