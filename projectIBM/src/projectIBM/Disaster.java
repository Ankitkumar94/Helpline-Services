package projectIBM;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.*;

public class Disaster extends JFrame implements ActionListener
{
	Vector columns_name=new Vector();
	Vector data=new Vector();
	JPanel p=new JPanel();
	
	Connection con=null;
	Statement stmt=null;
	JButton b1,b2;
	
	public Disaster()
	{
		b1=new JButton("List of Areas where relief activity is on");
		b2=new JButton("Help provided");
		setLayout(new BorderLayout());
		JLabel Background=new JLabel(new ImageIcon("C:\\Users\\A.K\\Desktop\\images_IBMproject\\disaster.jpg"));
		add(Background);
		Background.setLayout(null);
		b1.setBounds(350, 100, 300, 30);
		b2.setBounds(430,180,120,30);
		Background.add(b1); Background.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
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
		String sql="Create table relief(Location varchar(20), Address varchar(30))";
		stmt.executeUpdate(sql);
		sql="Create table dr_help(Disaster_type varchar(30), Contributions varchar(30), Helplines number)";
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
			String sql="insert into relief values('Dehradun','trunk road')";
			stmt.executeUpdate(sql);
			sql="insert into relief values('Manali','M-56 cottage')";
			stmt.executeUpdate(sql);
			sql="insert into relief values('Sikkim','s@56_d-87')";
			stmt.executeUpdate(sql);
			sql="insert into relief values('Tughlakabad','t-96')";
			stmt.executeUpdate(sql);
			sql="insert into relief values('Gurgaon','yd road')";
			stmt.executeUpdate(sql);
			sql="insert into relief values('Hisar','abc road')";
			stmt.executeUpdate(sql);
			sql="insert into relief values('Faridabad','f-58/765')";
			stmt.executeUpdate(sql);
			sql="insert into relief values('Agra','UP_98/769')";
			stmt.executeUpdate(sql);
			
			sql="insert into dr_help values('Earthquake','Food_Shelter',203)";
			stmt.executeUpdate(sql);
			sql="insert into dr_help values('Tsunami','Food_Money_Shelter',908)";
			stmt.executeUpdate(sql);
			sql="insert into dr_help values('Volcanic_Eruption','Shelter',566)";
			stmt.executeUpdate(sql);
			sql="insert into dr_help values('Fire','Shelter_Rehabilitation',333)";
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
				connect();
				Statement stmt=con.createStatement();
				String sql="Select Location, Address from relief";
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
			f.setSize(800,600);
			f.setVisible(true);
			//f.setDefaultCloseOperation(EXIT_ON_CLOSE);
			scrollpane.getViewport().setBackground(Color.BLACK);
			table.setRowHeight(40);

		}
		if(ae.getSource()==b2)
		{
			try
			{
				connect();
				Statement stmt=con.createStatement();
				String sql="Select Disaster_type, Contributions, Helplines from dr_help";
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
			f.setSize(800,600);
			f.setVisible(true);
			//f.setDefaultCloseOperation(EXIT_ON_CLOSE);
			scrollpane.getViewport().setBackground(Color.BLACK);
			table.setRowHeight(40);
		}
	}
	public static void main(String[] args) 
	{
		Disaster dr=new Disaster();
		dr.setTitle("Disaster relief activity details");
		dr.setResizable(false);
		dr.setLocation(60, 60);
		dr.setSize(1000,640);
		dr.setVisible(true);
		dr.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	}

