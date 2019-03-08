

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

/**
 * This class is used for implementing the function of choosing tickets and entering student IDs
 * @author Administrator
 *
 */
public class TicketNum extends JFrame implements ActionListener{

	private JFrame f;
	private JButton nextstep;
	private JButton prevstep;
	private JButton quit;
	private float cost;
	private int page;
	private Ticket ticket;
	private int[] number = new int[4];
	private JLabel[] numlabel = new JLabel[4];
	private JButton[] buttonplus = new JButton[4];
	private JButton[] buttonminus = new JButton[4];
	private JPanel CenterPanel = new JPanel();
	private JTextField[] stuTextfield;
	SeatInterface f1;
	private Other other;


	/**
	 * Constructor
	 * @param tkt(Used for getting information of ticket)
	 * @param flag (Used for analyzing which interface should be generated)
	 */
	public TicketNum(Ticket tkt,int flag){
		init();
		ticket = tkt;
		if(ticket.getMovieName().equals("KONG: SKULL ISLAND") ){
			if(ticket.getTime().equals("15:30")||ticket.getTime().equals("18:30")||ticket.getTime().equals("21:00"))
				ticket.setScreenNumber(1);
			else if(ticket.getTime().equals("20:00"))
				ticket.setScreenNumber(2);
			else if(ticket.getTime().equals("20:30"))
				ticket.setScreenNumber(3);
			else
				System.out.println("KONG: SKULL ISLAND error");
		}else if(ticket.getMovieName().equals("BEAUTY AND THE BEAST") ){
			if(ticket.getTime().equals("10:00")||ticket.getTime().equals("12:30"))
				ticket.setScreenNumber(1);
			else if(ticket.getTime().equals("10:30")||ticket.getTime().equals("13:00"))
				ticket.setScreenNumber(3);
			else
				System.out.println("BEAUTY AND THE BEAST error");
		}
		else if(ticket.getMovieNumber()==2)
		{
			ticket.setScreenNumber(3);
		}
		else if(ticket.getMovieNumber()==4)
		{
			ticket.setScreenNumber(2);
		}
		else{
			ticket.setScreenNumber(2);
		}
		
		if(flag==1)
		{
			number[0]=ticket.getChild();
			number[1]=ticket.getAdult();
			number[2]=ticket.getSenior();
			number[3]=ticket.getStudent();
			StudentID();
			int num = ticket.getStudent();
			if(ticket.getStudentID()!=null)
			{
				int stuID[] = ticket.getStudentID();
				for(int i=0;i<num;i++){				
					stuTextfield[i].setText(String.valueOf(stuID[i]));
				}
			}
			
		}
		else
		{
			TicketType();
			number[0]=ticket.getChild();
			number[1]=ticket.getAdult();
			number[2]=ticket.getSenior();
			number[3]=ticket.getStudent();
			numlabel[0].setText(""+ticket.getChild());
			numlabel[1].setText(""+ticket.getAdult());
			numlabel[2].setText(""+ticket.getSenior());
			numlabel[3].setText(""+ticket.getStudent());
		}
	}

	/**
	 * Initiation function
	 */
	private void init (){
		
		

		f=new JFrame("Theatre");
		nextstep=new JButton("nextstep");
		prevstep=new JButton("prevstep");
		quit=new JButton("quit");
		CenterPanel = new JPanel();
		f.setBounds(300,100,800,600);
		f.add(CenterPanel);
		f.setLayout(null);
		
		f.getContentPane().setBackground(new Color(137, 207, 240));
		
		
		
		
		f.add(nextstep);
		f.add(prevstep);
		f.add(quit);
		prevstep.setBounds(175,500,100,50);
		nextstep.setBounds(350,500,100,50);
		quit.setBounds(525,500,100,50);
		CenterPanel.setBounds(10,10,780,480);
		prevstep.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		nextstep.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		quit.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		prevstep.addActionListener(this);
		nextstep.addActionListener(this);
		quit.addActionListener(this);

		TicketType();
	}

	/**
	 * The function used for open ticket choosing interface
	 */
	private void TicketType(){
		f.getContentPane().setBackground(new Color(137, 207, 240));
		page = 1;
		CenterPanel.removeAll();
		CenterPanel.repaint();
		JLabel textLabel = new JLabel("Please Select Your Ticket Type",JLabel.CENTER);
		JPanel dowmPanel = new JPanel();
		JPanel[] panel = new JPanel[4];
		JPanel[] panelRight = new JPanel[4];
		JLabel[] label = new JLabel[4];

		CenterPanel.setLayout(new BorderLayout(20,20));
		CenterPanel.setBackground(new Color(137, 207, 240));
		dowmPanel.setLayout(new GridLayout(4,1,20,20));

		dowmPanel.setBackground(new Color(137, 207, 240));
		
		number[0] = 0;
		number[1] = 0;
		number[2] = 0;
		number[3] = 0;
		label[0]=new JLabel("Child   8 pounds(50% discount)",JLabel.CENTER);
		label[1]=new JLabel("Adult  16 pounds(None discount)",JLabel.CENTER);
		label[2]=new JLabel("Senior  3.2 pounds(20% discount)",JLabel.CENTER);
		label[3]=new JLabel("Student 2.4 pounds(15% discount)",JLabel.CENTER);

		CenterPanel.add(textLabel,BorderLayout.NORTH);
		CenterPanel.add(dowmPanel,BorderLayout.CENTER);
		textLabel.setFont(new Font("Cambria", Font.PLAIN, 45));
		textLabel.setForeground(Color.white);

		for(int i=0;i<4;i++){
			panel[i] = new JPanel();
			panelRight[i] = new JPanel();
			buttonplus[i] = new JButton("+");
			buttonminus[i] = new JButton("-");
			numlabel[i]=new JLabel(""+number[i],JLabel.CENTER);
			dowmPanel.add(panel[i]);
			panel[i].setBackground(new Color(137, 207, 240));
			panel[i].setLayout(null);
			panel[i].add(label[i]);
			label[i].setBounds(100,0,400,90);
			panel[i].add(panelRight[i]);
			panelRight[i].setBounds(500,10,400,90);
			panelRight[i].setLayout(null);
			panelRight[i].add(buttonminus[i]);
			buttonminus[i].setBounds(0,20,50,30);
			panelRight[i].add(numlabel[i]);
			panelRight[i].setBackground(new Color(137, 207, 240));
			numlabel[i].setBounds(52,5,60,60);
			panelRight[i].add(buttonplus[i]);
			buttonplus[i].setBounds(120,20,50,30);
			label[i].setFont(new Font("Cambria", Font.PLAIN, 25));
			label[i].setForeground(Color.white);
			numlabel[i].setFont(new Font("Cambria", Font.PLAIN, 45));
			numlabel[i].setForeground(Color.white);
			buttonminus[i].setFont(new Font("Times New Roman", Font.PLAIN, 20));
			buttonplus[i].setFont(new Font("Times New Roman", Font.PLAIN, 20));
			buttonplus[i].addActionListener(this);
			buttonminus[i].addActionListener(this);
		}
		CenterPanel.validate();

	}

	/**
	 * The function used for open student ID entering interface
	 */
	private void StudentID(){
		f.getContentPane().setBackground(new Color(137, 207, 240));
		page = 2;
		CenterPanel.removeAll();
		CenterPanel.repaint();
		JLabel[] stulabel = new JLabel[number[3]];
		JLabel textLabel = new JLabel("Please Input Your StudentID",JLabel.CENTER);
		JPanel dowmPanel = new JPanel();
		stuTextfield = new JTextField[number[3]];
		JPanel[] listPanel = new JPanel[number[3]];
		CenterPanel.setLayout(new BorderLayout(10,10));
		
		CenterPanel.setBackground(new Color(137, 207, 240));
		dowmPanel.setBackground(new Color(137, 207, 240));
		
		dowmPanel.setLayout(new GridLayout(number[3],1,20,10));
		CenterPanel.add(textLabel,BorderLayout.NORTH);
		CenterPanel.add(dowmPanel,BorderLayout.CENTER);
		for(int i=0;i<number[3];i++){
			listPanel[i] = new JPanel();
			listPanel[i].setLayout(null);
			dowmPanel.add(listPanel[i]);
			int j=i+1;
			stulabel[i] = new JLabel("StudntID " + j + ":",JLabel.CENTER);
			stuTextfield[i] = new JTextField();
			listPanel[i].add(stulabel[i]);
			stulabel[i].setBounds(150,0,150,40);
			listPanel[i].add(stuTextfield[i]);
			stuTextfield[i].setBounds(350,0,200,40);
			stulabel[i].setFont(new Font("Cambria", Font.PLAIN, 20));
			stulabel[i].setForeground(Color.white);
			textLabel.setFont(new Font("Cambria", Font.PLAIN, 45));
			textLabel.setForeground(Color.white);
			listPanel[i].setBackground(new Color(137, 207, 240));
		}
		CenterPanel.validate();
	}

	/**
	 * function used for going to next page
	 */
	public void gonext()
	{
		int Total =number[0]+number[1]+number[2]+number[3];
		String Seat[] = ticket.getSeatSelect();
		if(Seat!=null)
		{
			if(Total != Seat.length)
			{
				ticket.setSeatSelect(null);
			}
		}

		if(Total==0)
		{
			Object[] options = {"OK"}; 
			JOptionPane.showOptionDialog(null, "You haven't bought a ticket!", "Warning", 
			JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
			null, options, options[0]);
		}
		else
		{
			f1 = new SeatInterface(ticket);
			f.setVisible(false);
		}
	}

	/**
	 * Used for reacting to the action of buttons
	 */
	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(prevstep)){
			if(page==1)
			{
				ticket.setChild(number[0]);
				ticket.setAdult(number[1]);
				ticket.setSenior(number[2]);
				ticket.setStudent(number[3]);
				Other f2 = new Other(ticket);
				f2.ChooseFilms();
				f.setVisible(false);
			}
			if(page==2){
				page = 1;
				if(ticket.getStudentID()!=null)
				{
					int stuID[] = ticket.getStudentID();
					if(stuID.length!=number[3])
					{
						ticket.setStudentID(null);	
					}
					else
					{
						ticket.setStudentID(stuID);	
					}
					
				}
				TicketType();
				number[0]=ticket.getChild();
				number[1]=ticket.getAdult();
				number[2]=ticket.getSenior();
				number[3]=ticket.getStudent();
				numlabel[0].setText(""+ticket.getChild());
				numlabel[1].setText(""+ticket.getAdult());
				numlabel[2].setText(""+ticket.getSenior());
				numlabel[3].setText(""+ticket.getStudent());
			}
		}
		if(e.getSource().equals(nextstep)){

			if(page==1){
				ticket.setChild(number[0]);
				ticket.setAdult(number[1]);
				ticket.setSenior(number[2]);
				ticket.setStudent(number[3]);
				if(number[3]==0)
				{
					int stuID1[]=null;
					ticket.setStudentID(stuID1);
					gonext();
				}
				else{
					number[0]=ticket.getChild();
					number[1]=ticket.getAdult();
					number[2]=ticket.getSenior();
					number[3]=ticket.getStudent();
					StudentID();
					int num = ticket.getStudent();
					if(ticket.getStudentID()!=null)
					{
						int stuID[] = ticket.getStudentID();
						if(stuID.length!=number[3])
						{
							int stuID2[]=null;
							ticket.setStudentID(stuID2);	
						}
						else
						{
							for(int i=0;i<num;i++){				
								stuTextfield[i].setText(String.valueOf(stuID[i]));
							}	
						}
						
					}
				}
			}
			else{
				int stuID[]=new int[number[3]];	
				int p = 0;
				for(int i=0;i<number[3];i++){
					if(stuTextfield[i].getText().trim().equals(""))
					{
						Object[] options = {"OK"}; 
						JOptionPane.showOptionDialog(null, "You haven't typed in enough Student IDs for all your tickets!", "Warning", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
						null, options, options[0]);
						break;
					}
					else
					{
						Pattern pattern = Pattern.compile("[0-9]*"); 
						Matcher isNum = pattern.matcher(stuTextfield[i].getText());
						if( !isNum.matches() ){
							Object[] options = {"OK"}; 
							JOptionPane.showOptionDialog(null, "You should only enter numbers!", "Warning", 
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
							null, options, options[0]);
							break;
						} 
						else
						{
							stuID[i]=Integer.parseInt(stuTextfield[i].getText());
							ticket.setStudentID(stuID);
							p++;
						}
					}
				}
				
				if(p==number[3])
				{
					gonext();
				}
			}
		}

		if(e.getSource().equals(quit))
		{
			f.setVisible(false);
			other=new Other(ticket);
			other.Welcome();
		}
		for(int i=0;i<4;i++){
			if(e.getSource().equals(buttonplus[i])){
				number[i]++;
				numlabel[i].setText(""+number[i]);
			}
		}
		for(int i=0;i<4;i++){
			if(e.getSource().equals(buttonminus[i])){
				if(number[i]<=0)
					break;
				number[i]--;
				numlabel[i].setText(""+number[i]);
			}
		}

	}

}
