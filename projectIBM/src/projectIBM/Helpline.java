package projectIBM;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;


public class Helpline extends JFrame implements ActionListener
{
	JLabel l1;
    JButton b1,b2,b3,b4;

public Helpline()
{
	//getContentPane().setBackground(Color.PINK);
	l1=new JLabel("HELPLINE SERVICES AND SOS LOCATOR");
	l1.setFont(new Font("Times New Roman",Font.BOLD,20));
	l1.setForeground(Color.BLACK);
	b1=new JButton("Medicare");
	b2=new JButton("Blood Bank");
	b3=new JButton("Financial Aid");
	b4=new JButton("Disaster Hit SOS");
	
	setLayout(new BorderLayout());
	JLabel Background=new JLabel(new ImageIcon("C:\\Users\\A.K\\Desktop\\images_IBMproject\\Southlake 2.jpg"));
	add(Background);
	Background.setLayout(null);
	
	b1.setBounds(340, 100, 110, 30);
	b2.setBounds(490, 100, 110, 30);
	b3.setBounds(640, 100, 110, 30);
	b4.setBounds(790, 100, 130, 30);
	l1.setBounds(450,30,400,50);
	Background.add(l1); 
	Background.add(b1); Background.add(b2); 
	Background.add(b3); Background.add(b4); 
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b4.addActionListener(this);
	
}
public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==b1)
	{	
		Location lc=new Location();
		lc.setTitle("Location");
		lc.setResizable(false);
		lc.setLocation(30, 30);
		lc.setSize(1000,640);
		lc.setVisible(true);

	}
	if(ae.getSource()==b2)
	{
		Location1 lc1=new Location1();
		lc1.setTitle("Location");
		lc1.setResizable(false);
		lc1.setLocation(60, 60);
		lc1.setSize(1000,640);
		lc1.setVisible(true);

	}
	if(ae.getSource()==b3)
	{
		Fin_Aid fa=new Fin_Aid();
		fa.setTitle("Financial Aid");
		fa.setResizable(false);
		fa.setLocation(60,60);
		fa.setSize(1000,640);
		fa.setVisible(true);
	}
	if(ae.getSource()==b4)
	{
		Disaster dr=new Disaster();
		dr.setTitle("Disaster relief activity details");
		dr.setResizable(false);
		dr.setLocation(60, 60);
		dr.setSize(1000,640);
		dr.setVisible(true);
	}
}
	public static void main(String[] args) 
	{
		Helpline hl=new Helpline();
		hl.setTitle("Helpline Services");
		hl.setResizable(false);
		hl.setLocation(30, 30);
		hl.setSize(1300,640);
		hl.setVisible(true);
		hl.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
}
