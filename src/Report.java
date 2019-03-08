

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * This class is used for generating reports periodically
 * @author Administrator
 *
 */
public class Report {

	private File file1;
	private File file2;
	private double Price[];
	private int Adult;
	private int Children;
	private int Senior;
	private int Student;
	private int Total;
	private int j=1;
	private int i=0;
	
	/**
	 * Constructor
	 */
	public Report(){
		// Thread, run every 60 seconds.
		final long timeInterval = 60000;
		Runnable runnable = new Runnable() {
			public void run() {
				while (true) {
					if(i==0)
					{
						i++;
					}
					else
					{
						Adult=0;
						Children=0;
						Senior=0;
						Student=0;
						Price=new double[5];
						for(int i=0;i<5;i++)
						{
							Price[i]=0;
						}
						
						file1 = new File("c://Theatre/Report"+j+".txt");
						File fileParent1 = file1.getParentFile();  
						if(!fileParent1.exists()){  
						    fileParent1.mkdirs();  
						}
						if (!file1.exists()) {
							try {
								file1.createNewFile();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						

						
						file2 = new File("c://Theatre/Verify.txt");
						File fileParent2 = file2.getParentFile();  
						if(!fileParent2.exists()){  
						    fileParent2.mkdirs();  
						}
						if (!file2.exists()) {
							try {
								file2.createNewFile();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						
						BufferedReader bfreader = null;
						ArrayList<String> content=new ArrayList<String>();
						content.clear();
						String content2[]=new String[6];
						try {
							FileReader reader = new FileReader(file2);

							bfreader = new BufferedReader(reader);
							String get;
							while ((get=bfreader.readLine())!= null) {
								content.add(get);
							}
							

						} catch (IOException h) {
							// TODO Auto-generated catch block
							h.printStackTrace();
						} finally {
							try {
								bfreader.close();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
						
						if(content!=null)
						{
							for(int q=0;q<content.size();q++)
							{
								if(content.get(q)!=null)
								{
									content2=content.get(q).split("\\*");
									Price[Integer.parseInt(content2[0])-1] += Double.parseDouble(content2[5]);
									Adult+=Integer.parseInt(content2[1]);
									Children+=Integer.parseInt(content2[2]);
									Senior+=Integer.parseInt(content2[3]);
									Student+=Integer.parseInt(content2[4]);
								}

							}
							
							Total=Adult+Children+Senior+Student;
							
							
							BufferedWriter bfwriter = null;
							try {
								FileWriter writer = new FileWriter(file1);

								bfwriter = new BufferedWriter(writer);
								
								bfwriter.write("KONG: SKULL ISLAND: "+Price[0]+"pounds");
								bfwriter.newLine();
								bfwriter.write("LOGAN: "+Price[1]+"pounds");
								bfwriter.newLine();
								bfwriter.write("BEAUTY AND THE BEAST: "+Price[2]+"pounds");
								bfwriter.newLine();
								bfwriter.write("MOONLIGHT: "+Price[3]+"pounds");
								bfwriter.newLine();
								bfwriter.write("LA LA LAND: "+Price[4]+"pounds");
								bfwriter.newLine();
								bfwriter.write("Adult ticket have sold: "+Adult);
								bfwriter.newLine();
								bfwriter.write("Children ticket have sold: "+Children);
								bfwriter.newLine();
								bfwriter.write("Senior ticket have sold: "+Senior);
								bfwriter.newLine();
								bfwriter.write("Student ticket have sold: "+Student);
								bfwriter.newLine();
								bfwriter.write("Total ticket have sold: "+Total);
								j++;
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

							FileWriter fw=null;
							try {
								fw = new FileWriter(file2);
								fw.write("");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							finally
							{
								try {
									fw.close();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
					
					
					
					
					try {
						Thread.sleep(timeInterval);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
	}
	

	
}
