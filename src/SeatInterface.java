

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 * This class is used for generating choosing seats interface
 * @author Administrator
 *
 */
public class SeatInterface {

		private JFrame f;
		private JButton nextstep;
		private JButton prevstep;
		private JButton quit;
		private int number;
		private int Time;
		private int Screen;
		private boolean firstflag;
		private File seatfile;
		private JButton[] seat;
		private ArrayList SeatChoice;
		private String[] SeatChosen;
		private int Line;
		private JLabel screenmodel;
		private JLabel title;
		private JLabel hint;
		private Ticket ticket;
		private Other other;
		
		/**
		 * Constructor
		 * @param ticket(Used for getting information of ticket)
		 */
		public SeatInterface(Ticket ticket){
			this.ticket = ticket;
			number=ticket.getTotalNumber();
			Time=ticket.getTimeNumber();
			Screen=ticket.getScreenNumber();
			firstflag=true;
			SeatChoice= new ArrayList();
			Line=0;
			if(Screen == 1)
			{
				SeatChosen = new String[32];
			}
			else if(Screen == 2){
				SeatChosen = new String[26];
			}
			else
			{
				SeatChosen = new String[32];
			}
			init(ticket);
		}
		
		/**
		 * Used for initiating the interface
		 * @param ticket (Used for getting information of ticket)
		 */
		private void init(Ticket ticket){
			f=new JFrame("Theatre");
			nextstep=new JButton("nextstep");
			prevstep=new JButton("prevstep");
			screenmodel = new JLabel("Screen",JLabel.CENTER);
			title = new JLabel("Please select your SEATS!",JLabel.CENTER);
			hint = new JLabel("(Click once: Select; Click twice: Cancel)",JLabel.CENTER);
			quit=new JButton("quit");
			f.setBounds(300,100,800,600);
			f.setLayout(null);
			f.add(nextstep);
			f.add(prevstep);
			f.add(quit);
			f.add(screenmodel);
			f.add(title);
			f.add(hint);
			
			f.getContentPane().setBackground(new Color(137, 207, 240));
			
		
			title.setForeground(Color.white);
			hint.setForeground(Color.white);
			
			screenmodel.setBounds(100,425,600,50);
			title.setBounds(150,30,500,50);
			hint.setBounds(150,70,500,50);
			screenmodel.setOpaque(true);
			screenmodel.setBackground(Color.lightGray);
			screenmodel.setForeground(Color.white);
			prevstep.setBounds(175,500,100,50);
			nextstep.setBounds(350,500,100,50);
			quit.setBounds(525,500,100,50);
			screenmodel.setFont(new Font("Cambria", Font.PLAIN, 19));
			prevstep.setFont(new Font("Times New Roman", Font.PLAIN, 19));
			nextstep.setFont(new Font("Times New Roman", Font.PLAIN, 19));
			quit.setFont(new Font("Times New Roman", Font.PLAIN, 19));
			hint.setFont(new Font("Cambria", Font.PLAIN, 15));
			title.setFont(new Font("Cambria", Font.PLAIN, 30));
			f.setVisible(true);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			String Filename = Screen + "_" + Time + ".txt";
			OpenFile(Filename);
			SeatSelection();
			
			prevstep.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(SeatChoice.size()==number)
					{
						String Seat[] = new String[number];
						int o =0;
						while(o<number)
						{
							Seat[o]=(String) SeatChoice.get(o);
							o++;
						}
						ticket.setSeatSelect(Seat);
					}
					
					int stuID[]=ticket.getStudentID();
					if(stuID!=null)
					{
						TicketNum f1 = new TicketNum(ticket,1);
					}
					else
					{
						TicketNum f1 = new TicketNum(ticket,0);
					}
					f.setVisible(false);
					/*此处添加打开上一步界面*/
				}
			});
			
			nextstep.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(SeatChoice.size()<number)
					{
						Object[] options = {"OK"}; 
						JOptionPane.showOptionDialog(null, "You haven't chosen enough seats for all your tickets!", "Warning", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
						null, options, options[0]);  
					}
					
					else if(SeatChoice.size()>number)
					{
						Object[] options = {"OK"}; 
						JOptionPane.showOptionDialog(null, "The number of seats you have chosen is more than the number of your tickets!", "Warning", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
						null, options, options[0]);  
					}
					
					else
					{
						String Seat[] = new String[number];
						int o =0;
						while(o<number)
						{
							Seat[o]=(String) SeatChoice.get(o);
							o++;
						}
						ticket.setSeatSelect(Seat);
						Other f2 = new Other(ticket);
						f2.Verify();
						f.setVisible(false);	
					}
				}
			});
			
			
			
			
			
			quit.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					
					f.setVisible(false);
					other=new Other(ticket);
					other.Welcome();

				}
			});
		}
		
		/**
		 * Implementation of the function of choosing seats
		 */
		private void SeatSelection(){
			int seat_total=0;
			int i=0,j=0,k=0;
			if(Screen == 1)
			{
				seat_total=32;
				seat=new JButton[seat_total];
				while(i<4)
				{
					while(j<4)
					{
						int d = 68 - i;
						char letter =  (char)d;
						String name1 = String.valueOf(letter) + (8-j);
						seat[k] = new JButton(name1);
						f.add(seat[k]);
						seat[k].setBounds(125+j*60, 125+i*70, 50, 50);
						k++;
						String name2 = String.valueOf(letter) + (4-j);
						seat[k] = new JButton(name2);
						f.add(seat[k]);
						seat[k].setBounds(800-(125+(4-j)*60), 125+i*70, 50, 50);
						j++;
						k++;
					}
					j=0;
					i++;
				}
				
				

			}
			else if(Screen == 2)
			{
				seat_total=26;
				seat=new JButton[seat_total];
				while(j<4)
				{
					int d = 68 - i;
					char letter =  (char)d;
					String name1 = String.valueOf(letter) + (8-j);
					seat[k] = new JButton(name1);
					f.add(seat[k]);
					seat[k].setBounds(125+j*60, 125+i*70, 50, 50);
					k++;
					String name2 = String.valueOf(letter) + (4-j);
					seat[k] = new JButton(name2);
					f.add(seat[k]);
					seat[k].setBounds(800-(125+(4-j)*60), 125+i*70, 50, 50);
					j++;
					k++;
				}
				j=0;
				while(i<3)
				{
					while(j<3)
					{
						int d = 67 - i;
						char letter =  (char)d;
						String name1 = String.valueOf(letter) + (6-j);
						seat[k] = new JButton(name1);
						f.add(seat[k]);
						seat[k].setBounds(185+j*60, 195+i*70, 50, 50);
						k++;
						String name2 = String.valueOf(letter) + (3-j);
						seat[k] = new JButton(name2);
						f.add(seat[k]);
						seat[k].setBounds(800-(185+(3-j)*60), 195+i*70, 50, 50);
						j++;
						k++;
					}
					j=0;
					i++;
				}
				
				
			}
			else
			{
				seat_total=32;
				seat=new JButton[seat_total];
				while(j<8)
				{
					int d = 69 - i;
					char letter =  (char)d;
					String name1 = String.valueOf(letter) + (8-j);
					seat[k] = new JButton(name1);
					f.add(seat[k]);
					seat[k].setBounds(165+j*60, 125+i*55, 50, 50);
					j++;
					k++;
				}
				j=0;
				while(i<4)
				{
					while(j<2)
					{
						int d = 68 - i;
						char letter =  (char)d;
						String name1 = String.valueOf(letter) + (6-j);
						seat[k] = new JButton(name1);
						f.add(seat[k]);
						seat[k].setBounds(155+j*60, 180+i*55, 50, 50);
						k++;
						String name2 = String.valueOf(letter) + (4-j);
						seat[k] = new JButton(name2);
						f.add(seat[k]);
						seat[k].setBounds(345+j*60, 180+i*55, 50, 50);
						k++;
						String name3 = String.valueOf(letter) + (2-j);
						seat[k] = new JButton(name3);
						f.add(seat[k]);
						seat[k].setBounds(535+j*60, 180+i*55, 50, 50);
						j++;
						k++;
					}
					j=0;
					i++;
				}
			}
			
			

			k=0;
			
			Color x = seat[0].getBackground();
			
			while(k<seat_total)
			{
				
				seat[k].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton c = (JButton) e.getSource();
						if(c.getBackground()!=Color.GRAY)
						{
							if(c.getBackground()==x){
								c.setBackground(Color.YELLOW);
								String position = c.getText();
								SeatChoice.add(position);
							}
								
							else
							{
								c.setBackground(x);
								String position = c.getText();
								for (int i = 0; i < SeatChoice.size(); i++) { 
									 
									if (SeatChoice.get(i) == position) { 
									 
									SeatChoice.remove(i); 
									 
									i--;
									 
									} 
								}
							}
						}
						
						else
						{
							Object[] options = {"OK"}; 
							JOptionPane.showOptionDialog(null, "This seat has already been chosen by someone else!", "Warning", 
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
							null, options, options[0]);  
						}

							

					}
					});
				k++;
			}
			
			int a=0;
			int b=0;
			while(a<Line)
			{
				while(b<seat_total)
				{
					if(seat[b].getText().equals(SeatChosen[a]))
					{
						seat[b].setBackground(Color.GRAY);
					}
					b++;
				}
				b=0;
				a++;
			}
			
			if(ticket.getSeatSelect()!=null)
			{
				String Chosen[] = ticket.getSeatSelect();
				a=0;
				b=0;
				while(a<Chosen.length)
				{
					while(b<seat_total)
					{
						if(seat[b].getText().equals(Chosen[a]))
						{
							seat[b].setBackground(Color.YELLOW);
						}
						b++;
					}
					b=0;
					a++;
				}
			}
		}
		
		
		/**
		 * Used for open specific file and read the information
		 * @param filename (the file have been chosen to open)
		 */
		private void OpenFile(String filename){
			seatfile=new File("C:/Theatre/tempfiles/"+filename);
			File fileParent = seatfile.getParentFile();  
			if(!fileParent.exists()){  
			    fileParent.mkdirs();  
			}
			if (!seatfile.exists()) {
				try {
					seatfile.createNewFile();
					firstflag=false;
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			
			
			if(firstflag==true)
			{
				try 
				{
					FileReader read = new FileReader(seatfile);
					BufferedReader br = new BufferedReader(read);
					String row;
					while((row = br.readLine())!=null)
					{
						SeatChosen[Line]=row;
						Line++;
					}
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			
			
			
		}


		

		
		
		
		
		
		

}

