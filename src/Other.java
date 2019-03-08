

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.html.ImageView;

//import com.yiibai.iofile.ReadFromFile;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * This class is used for implement functions other than choosing seats, choosing tickets and sending reports.
 * @author Administrator
 *
 */
public class Other extends JPanel implements ActionListener {

	private JFrame f;
	private JButton nextstep;
	private JButton prevstep;
	private JButton quit;
	static Ticket ticket;
	ListSelectionModel listSelectionModel1;
	ListSelectionModel listSelectionModel2;
	ListSelectionModel listSelectionModel3;
	JList list1;
	JList list2;
	JList list3;
	
	/**
	 * Constructor
	 * @param ticket (the initialize of ticket)
	 */
	public Other(Ticket ticket){
		Report report = new Report();
		this.ticket = ticket;
	}
	
	/**
	 * The Welcome interface of the program
	 * 
	 */
	public void Welcome(){
		ticket=new Ticket();
		f=new JFrame("Theatre");
		nextstep=new JButton("Start");
		f.setBounds(300,100,800,600);
		f.getContentPane().setBackground(new Color(137, 207, 240));
		f.setLayout(null);
		f.add(nextstep);
		nextstep.setBounds(350,500,100,50);
		nextstep.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		
		JLabel label = new JLabel("Welcome to our theatre!");
		f.add(label);
		label.setBounds(150, 100, 500, 300);
		label.setFont(new Font("Cambria", Font.PLAIN, 45));
		label.setForeground(Color.white);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		nextstep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
    			try {
                    f.setVisible(false);  
                    ChooseFilms();          
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}
	
	/**
	 * The Movie choosing interface of the program
	 */
	public void ChooseFilms(){
		f=new JFrame("Theatre");
		quit=new JButton("quit");
		f.setBounds(300,100,800,600);
		f.getContentPane().setBackground(new Color(137, 207, 240));
		f.setLayout(null);
		f.add(quit);
		quit.setBounds(340,500,100,50);
		quit.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		
		JLabel label = new JLabel("Please Choose the Film you want to watch.");
		f.add(label);
		label.setBounds(35, 30, 750, 50);
		label.setFont(new Font("Cambria", Font.PLAIN, 40));
		label.setForeground(Color.white);
						
		ImageIcon i = new ImageIcon("1.gif");
		JLabel label1 = new JLabel(i);
		f.add(label1);
		label1.setBounds(20, 120, 140, 180);		
		JButton button1 = new JButton("choose");
		f.add(button1);
		button1.setBounds(40,320,100,50);
		button1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		
		ImageIcon ii = new ImageIcon("2.gif");
		JLabel label2 = new JLabel(ii);
		f.add(label2);
		label2.setBounds(170, 120, 140, 180);
		JButton button2 = new JButton("choose");
		f.add(button2);
		button2.setBounds(190,320,100,50);
		button2.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		
		ImageIcon iii = new ImageIcon("3.gif");
		JLabel label3 = new JLabel(iii);
		f.add(label3);
		label3.setBounds(320, 120, 140, 180);
		JButton button3 = new JButton("choose");
		f.add(button3);
		button3.setBounds(340,320,100,50);
		button3.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		
		ImageIcon iv = new ImageIcon("4.gif");
		JLabel label4 = new JLabel(iv);
		f.add(label4);
		label4.setBounds(470, 120, 140, 180);
		JButton button4 = new JButton("choose");
		f.add(button4);
		button4.setBounds(490,320,100,50);
		button4.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		
		ImageIcon v = new ImageIcon("5.gif");
		JLabel label5 = new JLabel(v);
		f.add(label5);
		label5.setBounds(620, 120, 140, 180);
		JButton button5 = new JButton("choose");
		f.add(button5);
		button5.setBounds(640,320,100,50);
		button5.setFont(new Font("Times New Roman", Font.PLAIN, 19));

		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
			
		
		quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
    			try {
                    f.setVisible(false); 
                    Welcome();          
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });	
		
		button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
    			try {
                    f.setVisible(false); 
                    if(ticket.getMovieNumber()!=1)
                    {
                    	ticket=new Ticket();
                    }
                    ticket.setMovieName("KONG: SKULL ISLAND");
                    ticket.setMovieNumber(1);
                    Time1(1);         
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

		button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
    			try {
    				f.setVisible(false); 
                    if(ticket.getMovieNumber()!=2)
                    {
                    	ticket=new Ticket();
                    }
                    ticket.setMovieName("LOGAN");
                    ticket.setMovieNumber(2);
                    ticket.setScreenNumber(3);
                    Time2(2);         
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
		
		button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
    			try {
                    f.setVisible(false); 
                    if(ticket.getMovieNumber()!=3)
                    {
                    	ticket=new Ticket();
                    }
                    ticket.setMovieName("BEAUTY AND THE BEAST");
                    ticket.setMovieNumber(3);
                    Time3(3);         
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
		
		button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
    			try {
                    f.setVisible(false); 
                    if(ticket.getMovieNumber()!=4)
                    {
                    	ticket=new Ticket();
                    }
                    ticket.setMovieName("MOONLIGHT");
                    ticket.setScreenNumber(2);
                    ticket.setMovieNumber(4);
                    Time4(4);         
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
		
		button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
    			try {
                    f.setVisible(false); 
                    if(ticket.getMovieNumber()!=5)
                    {
                    	ticket=new Ticket();
                    }
                    ticket.setMovieName("LA LA LAND");
                    ticket.setScreenNumber(2);
                    ticket.setMovieNumber(5);
                    Time5(5);         
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
		
	}
	
	/**
	 * One of the Show Time choosing interface of the program
	 * @param movieID (used for judgment)
	 */
	public void Time1(int movieID){	
		f=new JFrame("Theatre");
		nextstep=new JButton("nextstep");
		prevstep=new JButton("prevstep");
		quit=new JButton("quit");
		f.setBounds(300,100,800,600);
		f.setLayout(null);
		f.getContentPane().setBackground(new Color(137, 207, 240));
		
		
		JLabel label = new JLabel("Please choose the time you want!");
		f.add(label);
		label.setBounds(100, 380, 750, 50);
		label.setFont(new Font("Cambria", Font.PLAIN, 40));
		label.setForeground(Color.white);
		
		f.add(nextstep);
		f.add(prevstep);
		f.add(quit);
		prevstep.setBounds(175,500,100,50);
		nextstep.setBounds(350,500,100,50);
		quit.setBounds(525,500,100,50);
		prevstep.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		nextstep.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		quit.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		
		JPanel panel = new JPanel();
		f.add(panel);
		panel.setBounds(0, 0, 500, 300);
		panel.setLayout(new GridLayout(1,3));
		
		String[] s1 = {"15:30","18:30","21:00"};	
		list1 = new JList(s1);
        list1.setBorder(BorderFactory.createTitledBorder("Screen 1"));
        
        String[] s2 = {"20:00"};
        list2 = new JList(s2);
        list2.setBorder(BorderFactory.createTitledBorder("Screen 2"));
        
        String[] s3 = {"20:30"};
        list3 = new JList(s3);
        list3.setBorder(BorderFactory.createTitledBorder("Screen 3"));
      
        panel.add(new JScrollPane(list1));
        panel.add(new JScrollPane(list2));
        panel.add(new JScrollPane(list3));
  
        listSelectionModel1 = list1.getSelectionModel();
        listSelectionModel2 = list2.getSelectionModel();
        listSelectionModel3 = list3.getSelectionModel();
        
        listSelectionModel1.addListSelectionListener(new SharedListSelectionHandler());  
        listSelectionModel2.addListSelectionListener(new SharedListSelectionHandler());
        listSelectionModel3.addListSelectionListener(new SharedListSelectionHandler());
                
        list1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                do_list_valueChanged1(e);
                list2.clearSelection();
                list3.clearSelection();
            }
        });
        
        list2.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                do_list_valueChanged2(e);
                list1.clearSelection();
                list3.clearSelection();
            }
        });
        
        list3.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                do_list_valueChanged3(e);
                list1.clearSelection();
                list2.clearSelection();
            }
        });
        
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		prevstep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
    			try {
                    f.setVisible(false);  
                    ChooseFilms();          
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });		
			
		nextstep.addActionListener(new ActionListener() {//come to the second interface
            public void actionPerformed(ActionEvent a){
    			try {
    				if(ticket.getTimeNumber()==0)
    				{
						Object[] options = {"OK"}; 
						JOptionPane.showOptionDialog(null, "You haven't select a time!", "Warning", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
						null, options, options[0]); 
    				}
    				else
    				{
    					String[] time = new String[2];
    					time=ticket.getTime().split(":");
    					if(!timeAnalysis(Integer.parseInt(time[0]),Integer.parseInt(time[1])))
    					{
    						Object[] options = {"OK"}; 
    						JOptionPane.showOptionDialog(null, "This time has already passed", "Warning", 
    						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
    						null, options, options[0]);
    					}
    					else
    					{
    						f.setVisible(false);
    						TicketNum f1 = new TicketNum(ticket,0); 
    					}

    				}
     	   
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });	
		
		quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
    			try {
                    f.setVisible(false);  
                    Welcome();          
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });				
	}
	
	
	/**
	 * One of the Show Time choosing interface of the program
	 * @param movieID (used for judgment)
	 */
	public void Time2(int movieID){	
		f=new JFrame("Theatre");
		nextstep=new JButton("nextstep");
		prevstep=new JButton("prevstep");
		quit=new JButton("quit");
		f.setBounds(300,100,800,600);
		f.setLayout(null);
		
		f.getContentPane().setBackground(new Color(137, 207, 240));
		
		
		JLabel label = new JLabel("Please choose the time you want!");
		f.add(label);
		label.setBounds(100, 380, 750, 50);
		label.setFont(new Font("Cambria", Font.PLAIN, 40));
		label.setForeground(Color.white);
		
		f.add(nextstep);
		f.add(prevstep);
		f.add(quit);
		prevstep.setBounds(175,500,100,50);
		nextstep.setBounds(350,500,100,50);
		quit.setBounds(525,500,100,50);
		prevstep.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		nextstep.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		quit.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		
		JPanel panel = new JPanel();
		f.add(panel);
		panel.setBounds(0, 0, 500, 300);
		panel.setLayout(new GridLayout(1,2));
		
		String[] s1 = {"15:30","18:00"};	
		list1 = new JList(s1);
        list1.setBorder(BorderFactory.createTitledBorder("Screen 3"));

        panel.add(new JScrollPane(list1));
        listSelectionModel1 = list1.getSelectionModel();
        listSelectionModel1.addListSelectionListener(new SharedListSelectionHandler());  
        list1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                do_list_valueChanged1(e);
            }
        });
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		prevstep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
    			try {
                    f.setVisible(false);  
                    ChooseFilms();          
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });		
			
		nextstep.addActionListener(new ActionListener() {//come to the second interface
            public void actionPerformed(ActionEvent a){
    			try {
    				if(ticket.getTimeNumber()==0)
    				{
						Object[] options = {"OK"}; 
						JOptionPane.showOptionDialog(null, "You haven't select a time!", "Warning", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
						null, options, options[0]); 
    				}
    				else
    				{
    					String[] time = new String[2];
    					time=ticket.getTime().split(":");
    					if(!timeAnalysis(Integer.parseInt(time[0]),Integer.parseInt(time[1])))
    					{
    						Object[] options = {"OK"}; 
    						JOptionPane.showOptionDialog(null, "This time has already passed", "Warning", 
    						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
    						null, options, options[0]);
    					}
    					else
    					{
    						f.setVisible(false);
    						TicketNum f1 = new TicketNum(ticket,0); 
    					}
    				}         	   
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });	
		
		quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
    			try {
                    f.setVisible(false);  
                    Welcome();          
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });				
	}
	
	/**
	 * One of the Show Time choosing interface of the program
	 * @param movieID (used for judgment)
	 */
	public void Time3(int movieID){	
		f=new JFrame("Theatre");
		nextstep=new JButton("nextstep");
		prevstep=new JButton("prevstep");
		quit=new JButton("quit");
		f.setBounds(300,100,800,600);
		f.setLayout(null);
		
		f.getContentPane().setBackground(new Color(137, 207, 240));
		
		
		JLabel label = new JLabel("Please choose the time you want!");
		f.add(label);
		label.setBounds(100, 380, 750, 50);
		label.setFont(new Font("Cambria", Font.PLAIN, 40));
		label.setForeground(Color.white);
		
		f.add(nextstep);
		f.add(prevstep);
		f.add(quit);
		prevstep.setBounds(175,500,100,50);
		nextstep.setBounds(350,500,100,50);
		quit.setBounds(525,500,100,50);
		prevstep.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		nextstep.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		quit.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		
		JPanel panel = new JPanel();
		f.add(panel);
		panel.setBounds(0, 0, 500, 300);
		panel.setLayout(new GridLayout(1,2));
		
		String[] s1 = {"10:00","12:30"};	
		list1 = new JList(s1);
        list1.setBorder(BorderFactory.createTitledBorder("Screen 1"));
        
        String[] s2 = {"10:30","13:00"};
        list2 = new JList(s2);
        list2.setBorder(BorderFactory.createTitledBorder("Screen 3"));
        
        panel.add(new JScrollPane(list1));
        panel.add(new JScrollPane(list2));
       
        listSelectionModel1 = list1.getSelectionModel();
        listSelectionModel2 = list2.getSelectionModel();
        
        listSelectionModel1.addListSelectionListener(new SharedListSelectionHandler());  
        listSelectionModel2.addListSelectionListener(new SharedListSelectionHandler());
                
        list1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                do_list_valueChanged1(e);
                list2.clearSelection();
            }
        });
        
        list2.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                do_list_valueChanged2(e);
                list1.clearSelection();
            }
        });
        
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		prevstep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
    			try {
                    f.setVisible(false);  
                    ChooseFilms();          
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });		
			
		nextstep.addActionListener(new ActionListener() {//come to the second interface
            public void actionPerformed(ActionEvent a){
    			try {
    				if(ticket.getTimeNumber()==0)
    				{
						Object[] options = {"OK"}; 
						JOptionPane.showOptionDialog(null, "You haven't select a time!", "Warning", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
						null, options, options[0]); 
    				}
    				else
    				{
    					String[] time = new String[2];
    					time=ticket.getTime().split(":");
    					if(!timeAnalysis(Integer.parseInt(time[0]),Integer.parseInt(time[1])))
    					{
    						Object[] options = {"OK"}; 
    						JOptionPane.showOptionDialog(null, "This time has already passed", "Warning", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
						null, options, options[0]);
    					}
    					else
    					{
    						f.setVisible(false);
    						TicketNum f1 = new TicketNum(ticket,0); 
    					}
 
    				}         	   
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });	
		
		quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
    			try {
                    f.setVisible(false);  
                    Welcome();          
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });				
	}
	
	/**
	 * One of the Show Time choosing interface of the program
	 * @param movieID (used for judgment)
	 */
	public void Time4(int movieID){	
		f=new JFrame("Theatre");
		nextstep=new JButton("nextstep");
		prevstep=new JButton("prevstep");
		quit=new JButton("quit");
		f.setBounds(300,100,800,600);
		f.setLayout(null);
		
		f.getContentPane().setBackground(new Color(137, 207, 240));
		
		
		JLabel label = new JLabel("Please choose the time you want!");
		f.add(label);
		label.setBounds(100, 380, 750, 50);
		label.setFont(new Font("Cambria", Font.PLAIN, 40));
		label.setForeground(Color.white);
		
		f.add(nextstep);
		f.add(prevstep);
		f.add(quit);
		prevstep.setBounds(175,500,100,50);
		nextstep.setBounds(350,500,100,50);
		quit.setBounds(525,500,100,50);
		prevstep.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		nextstep.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		quit.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		
		JPanel panel = new JPanel();
		f.add(panel);
		panel.setBounds(0, 0, 500, 300);
		panel.setLayout(new GridLayout(1,2));
		
		String[] s1 = {"16:00","18:00"};	
		list1 = new JList(s1);
        list1.setBorder(BorderFactory.createTitledBorder("Screen 2"));

        panel.add(new JScrollPane(list1));
        listSelectionModel1 = list1.getSelectionModel();
        listSelectionModel1.addListSelectionListener(new SharedListSelectionHandler());  
        list1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                do_list_valueChanged1(e);
            }
        });
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		prevstep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
    			try {
                    f.setVisible(false);  
                    ChooseFilms();          
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });		
			
		nextstep.addActionListener(new ActionListener() {//come to the second interface
            public void actionPerformed(ActionEvent a){
    			try {
    				if(ticket.getTimeNumber()==0)
    				{
						Object[] options = {"OK"}; 
						JOptionPane.showOptionDialog(null, "You haven't select a time!", "Warning", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
						null, options, options[0]); 
    				}
    				else
    				{
    					String[] time = new String[2];
    					time=ticket.getTime().split(":");
    					if(!timeAnalysis(Integer.parseInt(time[0]),Integer.parseInt(time[1])))
    					{
    						Object[] options = {"OK"}; 
    						JOptionPane.showOptionDialog(null, "This time has already passed", "Warning", 
    						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
    						null, options, options[0]);
    					}
    					else
    					{
    						f.setVisible(false);
    						TicketNum f1 = new TicketNum(ticket,0); 
    					}
 
    				}       	   
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });	
		
		quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
    			try {
                    f.setVisible(false);  
                    Welcome();          
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });				
	}
	
	/**
	 * One of the Show Time choosing interface of the program
	 * @param movieID (used for judgment)
	 */
	public void Time5(int movieID){	
		f=new JFrame("Theatre");
		nextstep=new JButton("nextstep");
		prevstep=new JButton("prevstep");
		quit=new JButton("quit");
		f.setBounds(300,100,800,600);
		f.setLayout(null);
		
		f.getContentPane().setBackground(new Color(137, 207, 240));
		
		
		JLabel label = new JLabel("Please choose the time you want!");
		f.add(label);
		label.setBounds(100, 380, 750, 50);
		label.setFont(new Font("Cambria", Font.PLAIN, 40));
		label.setForeground(Color.white);
		
		f.add(nextstep);
		f.add(prevstep);
		f.add(quit);
		prevstep.setBounds(175,500,100,50);
		nextstep.setBounds(350,500,100,50);
		quit.setBounds(525,500,100,50);
		prevstep.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		nextstep.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		quit.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		
		JPanel panel = new JPanel();
		f.add(panel);
		panel.setBounds(0, 0, 500, 300);
		panel.setLayout(new GridLayout(1,2));
		
		String[] s1 = {"10:30","18:00"};	
		list1 = new JList(s1);
        list1.setBorder(BorderFactory.createTitledBorder("Screen 2"));

        panel.add(new JScrollPane(list1));
        listSelectionModel1 = list1.getSelectionModel();
        listSelectionModel1.addListSelectionListener(new SharedListSelectionHandler());  
        list1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                do_list_valueChanged1(e);
            }
        });
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		prevstep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
    			try {
                    f.setVisible(false);  
                    ChooseFilms();          
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });		
			
		nextstep.addActionListener(new ActionListener() {//come to the second interface
            public void actionPerformed(ActionEvent a){
    			try {
    				if(ticket.getTimeNumber()==0)
    				{
						Object[] options = {"OK"}; 
						JOptionPane.showOptionDialog(null, "You haven't select a time!", "Warning", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
						null, options, options[0]); 
    				}
    				else
    				{
    					String[] time = new String[2];
    					time=ticket.getTime().split(":");
    					if(!timeAnalysis(Integer.parseInt(time[0]),Integer.parseInt(time[1])))
    					{
    						Object[] options = {"OK"}; 
    						JOptionPane.showOptionDialog(null, "This time has already passed", "Warning", 
    						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
    						null, options, options[0]);
    					}
    					else
    					{
    						f.setVisible(false);
    						TicketNum f1 = new TicketNum(ticket,0); 
    					}

    				}
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });	
		
		quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
    			try {
                    f.setVisible(false);  
                    Welcome();          
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });				
	}
	
	/**
	 * Used for monitoring the change of list1
	 * @param e
	 */
    protected void do_list_valueChanged1(ListSelectionEvent e) {
    	int ID = ticket.getMovieNumber();
    	String Name = ticket.getMovieName();
    	if((String)list1.getSelectedValue()!=ticket.getTime())
    	{
    		ticket=new Ticket();
    		ticket.setMovieName(Name);
    		ticket.setMovieNumber(ID);
    	}
        ticket.setTime((String) list1.getSelectedValue());        
    }
    	
	/**
	 * Used for monitoring the change of list2
	 * @param e
	 */
    protected void do_list_valueChanged2(ListSelectionEvent e) {
    	int ID = ticket.getMovieNumber();
    	String Name = ticket.getMovieName();
    	if((String)list1.getSelectedValue()!=ticket.getTime())
    	{
    		ticket=new Ticket();
    		ticket.setMovieName(Name);
    		ticket.setMovieNumber(ID);
    	}
        ticket.setTime((String) list2.getSelectedValue());        
    }
    
    /**
	 * Used for monitoring the change of list3
	 * @param e
     */
    protected void do_list_valueChanged3(ListSelectionEvent e) {
    	int ID = ticket.getMovieNumber();
    	String Name = ticket.getMovieName();
    	if((String)list1.getSelectedValue()!=ticket.getTime())
    	{
    		ticket=new Ticket();
    		ticket.setMovieName(Name);
    		ticket.setMovieNumber(ID);
    	}
        ticket.setTime((String) list3.getSelectedValue());        
    }
    
    /**
     * Used for getting input from lists
     * @author Administrator
     *
     */
	class SharedListSelectionHandler implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) { 
	        ListSelectionModel lsm = (ListSelectionModel)e.getSource();
	        ticket.setTimeNumber((lsm.getMaxSelectionIndex()+1));
	        
	    }
	}
	    

	
	/**
	 * The Verify interface of the program
	 */
	public void Verify(){
		f=new JFrame("Theatre");
		nextstep=new JButton("nextstep");
		prevstep=new JButton("prevstep");
		quit=new JButton("quit");
		f.setBounds(300,100,800,600);
		f.setLayout(null);
		
		f.getContentPane().setBackground(new Color(137, 207, 240));
		
		
		JLabel label = new JLabel("Choose the time you want to watch this movie:");
		f.add(label);
		
		
		
		f.add(nextstep);
		f.add(prevstep);
		f.add(quit);
		prevstep.setBounds(175,500,100,50);
		nextstep.setBounds(350,500,100,50);
		quit.setBounds(525,500,100,50);
		prevstep.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		nextstep.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		quit.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		
		
		JLabel label1 = new JLabel("Film: " + ticket.getMovieName());
		JLabel label2 = new JLabel("Screen: " + "screen " + ticket.getScreenNumber());
		JLabel label3 = new JLabel("Time: " + ticket.getTime());
		JLabel label4 = new JLabel("Price: " + ticket.getPrice());
		JLabel label5 = new JLabel("Seat Number: " +Arrays.toString(ticket.getSeatSelect()));
		JLabel label6 = new JLabel("Warning: Your tickets will be generated after you have pressed the 'nextstep' button!");
		JLabel label7 = new JLabel("And payment will be completed at the same time!");
		
		
		
		f.add(label1);
		f.add(label2);	
		f.add(label3);
		f.add(label4);
		f.add(label5);
		f.add(label6);
		f.add(label7);
		label1.setBounds(150, 30, 500, 50);
		label1.setFont(new Font("Cambria", Font.PLAIN, 30));
		label1.setForeground(Color.white);
		label2.setBounds(150, 100, 500, 50);
		label2.setFont(new Font("Cambria", Font.PLAIN, 30));
		label2.setForeground(Color.white);
		label3.setBounds(150, 170, 500, 50);
		label3.setFont(new Font("Cambria", Font.PLAIN, 30));
		label3.setForeground(Color.white);
		label4.setBounds(150, 240, 500, 50);
		label4.setFont(new Font("Cambria", Font.PLAIN, 30));
		label4.setForeground(Color.white);
		label5.setBounds(150, 310, 500, 50);
		label5.setFont(new Font("Cambria", Font.PLAIN, 30));
		label5.setForeground(Color.white);
		label6.setBounds(50, 380, 700, 50);
		label6.setFont(new Font("Cambria", Font.PLAIN, 18));
		label6.setForeground(Color.red);
		label7.setBounds(50, 410, 700, 50);
		label7.setFont(new Font("Cambria", Font.PLAIN, 18));
		label7.setForeground(Color.red);
	
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

		prevstep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
    			try {
    				SeatInterface f1 = new SeatInterface(ticket);
                    f.setVisible(false);    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });		
			
		nextstep.addActionListener(new ActionListener() {//come to the second interface
            public void actionPerformed(ActionEvent a){
    			try {
    				f.setVisible(false);
    				Finished();           	   
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });	
		
		quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
    			try {
                    f.setVisible(false);  
                    Welcome();          
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });		
	}
	
	/**
	 * The Success interface of the program
	 */
	public void Finished(){
		f=new JFrame("Theatre");
		quit=new JButton("quit");
		f.setBounds(300,100,800,600);
		f.setLayout(null);
		f.add(quit);
		quit.setBounds(350,500,100,50);
		quit.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		
		f.getContentPane().setBackground(new Color(137, 207, 240));
		
		
		
		
		JLabel label1 = new JLabel("The Tickets are generated successfully!");
		JLabel label2 = new JLabel("Thanks for using the kiosk system!");
		f.add(label1);
		label1.setBounds(60, 100, 700, 300);
		label1.setFont(new Font("Cambria", Font.PLAIN, 40));
		label1.setForeground(Color.white);
		f.add(label2);
		label2.setBounds(100, 150, 600, 300);
		label2.setFont(new Font("Cambria", Font.PLAIN, 40));
		label2.setForeground(Color.white);
		
		
		WriteTicket(ticket);
		
		File seatfile=new File("C:/Theatre/tempfiles/"+ticket.getScreenNumber()+"_"+ticket.getTimeNumber()+".txt");
		File fileParent = seatfile.getParentFile();  
		if(!fileParent.exists()){  
		    fileParent.mkdirs();  
		}    

		if (!seatfile.exists()) {
			try {
				seatfile.createNewFile();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		BufferedWriter seats = null;
        try {                                                                        
            seats = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(seatfile, true)));
            for(int i=0; i<ticket.getSeatSelect().length;i++)
            {
            	seats.write(ticket.getSeatSelect()[i]);
           		seats.newLine();
            }
        } catch (Exception e) {                                                     
            e.printStackTrace();                                                    
        } finally {                                                                 
           try {                                                                    
                seats.close();                                                        
            } catch (IOException e) {                                               
                e.printStackTrace();                                                
            }                                                                       
        } 
        

		
		
		
		String fileName = "c://Theatre/Verify.txt";
		
		File Verify=new File(fileName);
		File fileParentV = Verify.getParentFile();  
		if(!fileParentV.exists()){  
		    fileParentV.mkdirs();  
		}    

		if (!Verify.exists()) {
			try {
				Verify.createNewFile();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
        String content = ticket.getMovieNumber() +"*"+ticket.getAdult()+"*"+ticket.getChild()+"*"+ticket.getSenior()+"*"+ticket.getStudent()+"*"+ticket.getPrice();
        writeDoc(Verify, content);
       
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
			
			
		
		quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a){
    			try {
                    f.setVisible(false);  
                    Welcome();          
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });		
	}
	
	
	/**
	 * Used for generating ticket files
	 * @param ticket (The one will be generated as a file)
	 */
	public void WriteTicket(Ticket ticket)
	{
		String ID=new String();
        int max=4;
        int min=1;
        Random random = new Random();
        int s;
        int Adult;
        int Child;
        int Senior;
        int Student;
        String Type;
        File file;
        String content1,content2,content3,content4,content5,content6,content7;
        
        Adult=ticket.getAdult();
        Type = "Adult Ticket";
        	
		for(int count=0;count<Adult;count++)
		{

	        ID=new String();
	        for(int i=0;i<8;i++)
	        {
	        	s = random.nextInt(max)%(max-min+1) + min;
	        	ID = ID + s;
	        }
	        
	        
			file = new File("c://Theatre/Tickets/"+ID+".txt");
			File fileParentT = file.getParentFile();  
			if(!fileParentT.exists()){  
			    fileParentT.mkdirs();  
			}
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	        
		    content1 = "File Name: "+ticket.getMovieName();
		    content2 = "Time: "+ticket.getTime();
		    content3 = "Screen: "+ticket.getScreenNumber();
		    content4 = "Type: "+Type;
		    content6 = "Price: 16 pounds";
		    content7 = "Seat: "+ticket.getSeatSelect()[count];
		    writeDoc(file,content1);
		    writeDoc(file,content2);
		    writeDoc(file,content3);
		    writeDoc(file,content4);
		    writeDoc(file,content6);
		    writeDoc(file,content7);
		}
        	
      	Child=ticket.getChild();
       	Type = "Child Ticket";
     
        
		for(int count=0;count<Child;count++)
		{

	        ID=new String();
	        for(int i=0;i<8;i++)
	        {
	        	s = random.nextInt(max)%(max-min+1) + min;
	        	ID = ID + s;
	        }
	        
	        
			file = new File("c://Theatre/Tickets/"+ID+".txt");
			File fileParentT = file.getParentFile();
			if(!fileParentT.exists()){  
			    fileParentT.mkdirs();  
			}
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	        
		    content1 = "File Name: "+ticket.getMovieName();
		    content2 = "Time: "+ticket.getTime();
		    content3 = "Screen: "+ticket.getScreenNumber();
		    content4 = "Type: "+Type;
		    content6 = "Price: 8 pounds";
		    content7 = "Seat: "+ticket.getSeatSelect()[count+Adult];
		    writeDoc(file,content1);
		    writeDoc(file,content2);
		    writeDoc(file,content3);
		    writeDoc(file,content4);
		    writeDoc(file,content6);
		    writeDoc(file,content7);
		}
       	
       	
       	Senior=ticket.getSenior();
       	Type = "Senior Ticket";
       	
		for(int count=0;count<Senior;count++)
		{

	        ID=new String();
	        for(int i=0;i<8;i++)
	        {
	        	s = random.nextInt(max)%(max-min+1) + min;
	        	ID = ID + s;
	        }
	        
	        
			file = new File("c://Theatre/Tickets/"+ID+".txt");
			File fileParentT = file.getParentFile();
			if(!fileParentT.exists()){  
			    fileParentT.mkdirs();  
			}
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	        
		    content1 = "File Name: "+ticket.getMovieName();
		    content2 = "Time: "+ticket.getTime();
		    content3 = "Screen: "+ticket.getScreenNumber();
		    content4 = "Type: "+Type;
		    content6 = "Price:  3.2 pounds";
		    content7 = "Seat: "+ticket.getSeatSelect()[count+Adult+Child];
		    writeDoc(file,content1);
		    writeDoc(file,content2);
		    writeDoc(file,content3);
		    writeDoc(file,content4);
		    writeDoc(file,content6);
		    writeDoc(file,content7);
		}
       	
       	
        Student=ticket.getStudent();
        Type = "Student Ticket";

		
		for(int count=0;count<Student;count++)
		{

	        ID=new String();
	        for(int i=0;i<8;i++)
	        {
	        	s = random.nextInt(max)%(max-min+1) + min;
	        	ID = ID + s;
	        }
	        
	        
			file = new File("c://Theatre/Tickets/"+ID+".txt");
			File fileParentT = file.getParentFile();
			if(!fileParentT.exists()){  
			    fileParentT.mkdirs();  
			}
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	        
		    content1 = "File Name: "+ticket.getMovieName();
		    content2 = "Time: "+ticket.getTime();
		    content3 = "Screen: "+ticket.getScreenNumber();
		    content4 = "Type: "+Type;
            content5 = "Student ID: "+ticket.getStudentID()[count];
            content6 = "Price: 2.4 pounds";
            content7 = "Seat: "+ticket.getSeatSelect()[count+Adult+Child+Senior];
		    writeDoc(file,content1);
		    writeDoc(file,content2);
		    writeDoc(file,content3);
		    writeDoc(file,content4);
		    writeDoc(file,content5);
		    writeDoc(file,content6);
		    writeDoc(file,content7);
		}
		

			
	}
	
	/**
	 * Used for writing specific content to a specific file
	 * @param writefile (The file used for writing)
	 * @param content (writing content)
	 */
	public void writeDoc(File writefile, String content) {
		BufferedWriter bfwriter = null;
		try {
			FileWriter writer = new FileWriter(writefile, true);

			bfwriter = new BufferedWriter(writer);
				//bfwriter.newLine();
			bfwriter.write(content);
			bfwriter.newLine();
		} catch (IOException h) {
			// TODO Auto-generated catch block
			h.printStackTrace();
		} finally {
			try {
				bfwriter.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
	/**
	 * Used for analyzing whether the current time is earlier than the time user have chose
	 * @param Hour (hour of the movie's show time)
	 * @param Minute (minute of the movie's show time)
	 * @return (true for available(early), false for unavailable(late))
	 */
	public boolean timeAnalysis(int Hour, int Minute)
	{
		Calendar now = Calendar.getInstance();
		int NowHour = now.get(Calendar.HOUR_OF_DAY);
		int NowMinute = now.get(Calendar.MINUTE);
		if(NowHour>Hour)
		{
			return false;
		}
		if(NowHour<Hour)
		{
			return true;
		}
		else
		{
			if(NowMinute>Minute)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
	}
	
	/**
	 * Main function
	 * @param args
	 */
	public static void main(String[] args) {
		ticket = new Ticket();
		Other f1 =new Other(ticket);
		f1.Welcome();
	}

	/**
	 * A function used for action listener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
