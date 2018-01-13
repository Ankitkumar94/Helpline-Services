package projectIBM;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.color.*;

public class Fin_Aid extends JFrame implements ActionListener
{
	JButton b1;
	JButton b2;
	
	public Fin_Aid()
	{
		//getContentPane().setBackground(Color.ORANGE);
		b1=new JButton("New Registeration");
		b2=new JButton("Get Details");
		
		setLayout(new BorderLayout());
		JLabel Background=new JLabel(new ImageIcon("C:\\Users\\A.K\\Desktop\\images_IBMproject\\doctors.jpg"));
		add(Background);
		Background.setLayout(null);
		
		b1.setBounds(220, 100, 170, 40);
		b2.setBounds(240,180,120,40);
		Background.add(b1); Background.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			Register r=new Register();
			r.setTitle("Registeration");
			r.setResizable(false);
			r.setLocation(60,60);
			r.setSize(1000,640);
			r.setVisible(true);
		}
		if(ae.getSource()==b2)
		{
			Get_details gd=new Get_details();
			gd.setTitle("Registeration");
			gd.setResizable(false);
			gd.setLocation(60,60);
			gd.setSize(1000,640);
			gd.setVisible(true);
		}
	}

	public static void main(String[] args) 
	{
		Fin_Aid fa=new Fin_Aid();
		fa.setTitle("Financial Aid");
		fa.setResizable(false);
		fa.setLocation(60,60);
		fa.setSize(1000,640);
		fa.setDefaultCloseOperation(EXIT_ON_CLOSE);
		fa.setVisible(true);

	}

}
