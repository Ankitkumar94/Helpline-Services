package projectIBM;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.*;

public class Location extends JFrame implements ActionListener
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
	
	public Location()
	{
		//getContentPane().setBackground(Color.PINK);
		l1=new JLabel("Select your location");
		l1.setFont(new Font("",Font.BOLD,20));
		l1.setForeground(Color.RED);
		cb=new JComboBox();
		cb.addItem("**Select**");
		cb.addItem("Kalkaji");
		cb.addItem("Janakpuri");
		cb.addItem("Saket");
		cb.addItem("Munirka");
		cb.addItem("Karol Bagh");
		b1=new JButton("OK");
		
		setLayout(new BorderLayout());
		JLabel Background=new JLabel(new ImageIcon("C:\\Users\\A.K\\Desktop\\images_IBMproject\\night_hospital.jpg"));
		add(Background);
		Background.setLayout(null);
		
		cb.setBounds(240,130,100,30);
		l1.setBounds(200,80,200,30);
		b1.setBounds(250,200,70,30);
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
		String sql="Create table medicare(Area varchar(20), Address varchar(30), PhoneNo number, Distance_kj number, Distance_jp number, Distance_sk number, Distance_mk number, Distance_kb number)";
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
			String sql="insert into medicare values('kj1','30@dda',9987562301,1,3,2,7,5)";
			stmt.executeUpdate(sql);
			sql="insert into medicare values('kj2','123@dda',9237562301,1.5,2,2,8,3)";
			stmt.executeUpdate(sql);
			sql="insert into medicare values('jp1','tc@4',9987902301,3,2,6,12,4.5)";
			stmt.executeUpdate(sql);
			sql="insert into medicare values('jp2','jp@II',9785562301,4,1,9,3,2.5)";
			stmt.executeUpdate(sql);
			sql="insert into medicare values('sk1','pspIV',9987562364,8.5,6,1,4,8)";
			stmt.executeUpdate(sql);
			sql="insert into medicare values('sk2','pspV',9987564538,5,2,2,4,3.5)";
			stmt.executeUpdate(sql);
			sql="insert into medicare values('mk1','mk@48',8876458913,7,3,2,1.5,8)";
			stmt.executeUpdate(sql);
			sql="insert into medicare values('mk2','mk@96',9076453728,4,7,3,1,5)";
			stmt.executeUpdate(sql);
			sql="insert into medicare values('kb1','sec_II',9086455643,9,3,2,7,1)";
			stmt.executeUpdate(sql);
			sql="insert into medicare values('kb2','sec_VI',9845375698,10,3,2,7,1.5)";
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
			
			if(k=="Kalkaji")
			{
				//this.dispose();
			try
			{
				connect();
				Statement stmt=con.createStatement();
				String sql="Select Area,Address,PhoneNo,Distance_kj from medicare where Distance_kj<=4";
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
				String sql="Select Area,Address,PhoneNo,Distance_jp from medicare where Distance_jp<=4";
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
			else if(k=="Saket")
			{
				//this.dispose();
				//this.setVisible(false);
			try
			{
				connect();
				Statement stmt=con.createStatement();
				String sql="Select Area,Address,PhoneNo,Distance_sk from medicare where Distance_sk<=4";
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
			scrollpane.getViewport().setBackground(Color.black);
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
				String sql="Select Area,Address,PhoneNo,Distance_mk from medicare where Distance_mk<=4";
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
			scrollpane.getViewport().setBackground(Color.black);
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
				String sql="Select Area,Address,PhoneNo,Distance_kb from medicare where Distance_kb<=4";
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
			TableColumnModel columnModel=table.getColumnModel();
			columnModel.getColumn(3).setPreferredWidth(60);
				
			}

		}		
}
	
	public static void main(String[] args) 
	{
		Location lc=new Location();
		lc.setTitle("Location");
		lc.setResizable(false);
		lc.setLocation(60, 60);
		lc.setSize(1000,640);
		lc.setVisible(true);
		lc.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
