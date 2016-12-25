import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import java.io.*;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;                          //jxl java excel api
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Panel;
import java.awt.ScrollPane;

public class SeWork_Ver_1_1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			//比賽時間.xls的建立
			WritableWorkbook workbook = Workbook.createWorkbook(new File("比賽時間.xls"));
			WritableSheet sheet = workbook.createSheet("比賽時間", 0);
			
			sheet.setColumnView(0, 50);
			sheet.setColumnView(1, 50);
			//字體部分
			WritableFont myFont = new WritableFont(WritableFont.createFont("標楷體"), 14);        
            myFont.setColour(Colour.BLACK);            
            WritableCellFormat cellFormat = new WritableCellFormat();
            
			cellFormat.setFont(myFont); // 指定字型
            cellFormat.setBackground(Colour.SKY_BLUE); // 背景顏色
            cellFormat.setAlignment(Alignment.CENTRE); // 對齊方式
            
			Label title = new Label(0,0,"請在下方輸入比賽時間",cellFormat);
			sheet.addCell(title);
			title = new Label(1,0,"請在下方輸入運動項目",cellFormat);
			sheet.addCell(title);
			
			workbook.write();
			workbook.close();
			//選手資料.xls的建立
			workbook = Workbook.createWorkbook(new File("選手資料.xls"));
			sheet = workbook.createSheet("選手資料", 0);
			
			sheet.setColumnView(0, 50);
			sheet.setColumnView(1, 50);
			//字體部分
			myFont = new WritableFont(WritableFont.createFont("標楷體"), 14);        
            myFont.setColour(Colour.BLACK);            
            cellFormat = new WritableCellFormat();
            
			cellFormat.setFont(myFont); // 指定字型
            cellFormat.setBackground(Colour.SKY_BLUE); // 背景顏色
            cellFormat.setAlignment(Alignment.CENTRE); // 對齊方式
            
			Label title2 = new Label(0,0,"請在下方輸入選手名稱",cellFormat);
			sheet.addCell(title2);
			title2 = new Label(1,0,"請在下方輸入運動項目",cellFormat);
			sheet.addCell(title2);
			
			workbook.write();
			workbook.close();
			
			//場地資料.xls的建立
			workbook = Workbook.createWorkbook(new File("場地資料.xls"));
			sheet = workbook.createSheet("場地資料", 0);
			
			sheet.setColumnView(0, 50);
			sheet.setColumnView(1, 50);
			sheet.setColumnView(2, 50);
			//字體部分
			myFont = new WritableFont(WritableFont.createFont("標楷體"), 14);        
            myFont.setColour(Colour.BLACK);            
            cellFormat = new WritableCellFormat();
            
			cellFormat.setFont(myFont); // 指定字型
            cellFormat.setBackground(Colour.SKY_BLUE); // 背景顏色
            cellFormat.setAlignment(Alignment.CENTRE); // 對齊方式
            
			title2 = new Label(0,0,"請在下方輸入場地名稱",cellFormat);
			sheet.addCell(title2);
			title2 = new Label(1,0,"請在下方輸入運動項目",cellFormat);
			sheet.addCell(title2);
			title2 = new Label(2,0,"請在下方場地數量",cellFormat);
			sheet.addCell(title2);
			
			
			workbook.write();
			workbook.close();
			
		 }catch (IOException | WriteException e1) {
			e1.printStackTrace();
		  } 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeWork_Ver_1_1 frame = new SeWork_Ver_1_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SeWork_Ver_1_1() {
		setTitle("ESS Schedule events");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 438);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//使用說明按鈕
		JButton btnNewButton_2 = new JButton(new ImageIcon("image.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   notice note = new notice();
			}
		});
		btnNewButton_2.setBounds(578, 10, 60, 61);
		contentPane.add(btnNewButton_2);
		
		java.awt.Label label = new java.awt.Label("安排賽程");
		label.setFont(new Font("微軟正黑體", Font.BOLD | Font.ITALIC, 40));
		label.setBounds(224, 22, 207, 51);
		contentPane.add(label);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(64, 88, 207, 280);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//第一個按鈕
		JButton button = new JButton("時間");
		button.setBackground(new Color(135, 206, 235));
		button.setBounds(34, 61, 132, 56);
		panel.add(button);
		button.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		button.setForeground(new Color(0, 0, 0));
		
		//第二個按鈕
		JButton btnNewButton_1 = new JButton("運動員");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(135, 206, 235));
		btnNewButton_1.setBounds(34, 127, 132, 56);
		panel.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		//第三個按鈕
		
		JButton btnNewButton_3 = new JButton("場地");
		btnNewButton_3.setBackground(new Color(135, 206, 235));
		btnNewButton_3.setBounds(34, 199, 132, 56);
		panel.add(btnNewButton_3);
		btnNewButton_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		java.awt.Label label_1 = new java.awt.Label("匯入資料");
		label_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		label_1.setBounds(23, 10, 112, 36);
		panel.add(label_1);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(255, 235, 205));
		panel_1.setBounds(345, 88, 243, 280);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		//jcombobox 判斷球賽種類
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(33, 79, 196, 56);
		panel_1.add(comboBox);
		comboBox.setBackground(new Color(152, 251, 152));
		comboBox.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		comboBox.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u8ACB\u9078\u64C7\u904B\u52D5\u9805\u76EE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"----請選擇----", "籃球", "排球", "棒球", "羽球", "足球"}));
		//第三個按鈕,maybe第4個

		JButton btnNewButton = new JButton("瀏覽賽程表");
		btnNewButton.setBounds(43, 181, 156, 61);
		panel_1.add(btnNewButton);
		btnNewButton.setBackground(new Color(221, 160, 221));
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		
		java.awt.Label label_2 = new java.awt.Label("賽程安排");
		label_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		label_2.setBounds(33, 20, 112, 36);
		panel_1.add(label_2);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
					 try {
						 File f = new File("賽程表.xls");
						Runtime.getRuntime().exec("cmd   /c   start   excel   \""   +   f.getAbsolutePath()   +   "\"");
					} catch (IOException e) {
						// TODO 自動產生的 catch 區塊
						e.printStackTrace();
					}
		}
	});
		comboBox.addItemListener(new ItemListener() {
			       public void itemStateChanged(final ItemEvent e) {
			    	   int index = comboBox.getSelectedIndex();
			    	      if (index != 0) { // ==0表示选中的事第一个
			    	    	  
			    	    
			    	    	  try{
			  					
			  					//主要演算法
			  		            
			  		            //讀取選手資料
			  		            testcase data=new testcase();			  		            
			  		            int change=comboBox.getSelectedIndex()-1;
			  				    int n=data.time_ball[change];
			  				    String sport=null;
			  				    switch(change){
			  				    case 0:
			  				    	sport="籃球";
			  				    	break;
			  				    case 1:
			  				    	sport="排球";
			  				    	break;
			  				    case 2:
			  				    	sport="棒球";
			  				    	break;
			  				    case 3:
			  				    	sport="羽球";
			  				    	break;
			  				    case 4:
			  				    	sport="足球";
			  				    	break;
			  				    }
			  				    
			  				    //取亂數
			  					int [] randomNO=new int [2*n];
			  					int [] randomNO2=new int [n];
			  					int [][]game=new int [2][n];
			  					int []game_court=new int [n];
			  					for(int i=0;i<2;i++){
			  						for(int j=0;j<n;j++){
			  							int x=(int)(Math.random()*(2*n));
			  							if(randomNO[x]==0){
			  								game[i][j]=x;
			  								randomNO[x]=1;
			  							}
			  							else{
			  								j--;
			  								continue;
			  							}
			  						}
			  					}
			  					for(int j=0;j<n;j++){
		  							int x=(int)(Math.random()*n);
		  							if(randomNO2[x]==0){
		  								game_court[j]=x;
		  								randomNO2[x]=1;
		  							}
		  							else{
		  								j--;
		  								continue;
		  							}
		  						}

			  					WritableWorkbook workbook =Workbook.createWorkbook(new File("賽程表.xls")); 
			  					WritableSheet sheet = workbook.createSheet(sport,0);
			  					//調整寬度
			  					for(int i=2;i<5;i++){
			  						sheet.setColumnView(i, 40);
			  			        }
			  					sheet.setColumnView(0, 30);
			  					sheet.setColumnView(1, 25);
			  			 
			  			         
			  					   //字體部分
			  					   WritableFont myFont = new WritableFont(WritableFont.createFont("標楷體"), 14);        
			  		               myFont.setColour(Colour.BLACK);            
			  		               WritableCellFormat cellFormat = new WritableCellFormat();
			  		               WritableCellFormat cellFormat2 = new WritableCellFormat();
			  						 
			  		               cellFormat.setFont(myFont); // 指定字型
			  		               //cellFormat.setBackground(Colour.LIGHT_BLUE); // 背景顏色
			  		               cellFormat.setAlignment(Alignment.CENTRE); // 對齊方式
			  		               cellFormat2.setFont(myFont); // 指定字型
			  		               cellFormat2.setBackground(Colour.ROSE); // 背景顏色
			  		               cellFormat2.setAlignment(Alignment.CENTRE); // 對齊方式
			  		              
			  		               
			  					 //匯出至excel
			  					     //匯出標題
			  					     Label title0 = new Label(0,0,"比賽時間",cellFormat2);
			  					     Label title1 = new Label(1,0,"運動項目",cellFormat2);
			  					     Label title2 = new Label(2,0,"比賽場地",cellFormat2);
			  						 Label title3 = new Label(3,0,"參賽者",cellFormat2);
			  						 Label title4 = new Label(4,0,"參賽者",cellFormat2);
			  						 sheet.addCell(title0);
			  						 sheet.addCell(title1);
			  						 sheet.addCell(title2);
			  						 sheet.addCell(title3);
			  						 sheet.addCell(title4);
			  						 
			  					
			  					 for(int i=1;i<n+1;i++){
			  						 Label label0 = new Label(0,i,data.time[change][i-1],cellFormat);
			  						 Label label1 = new Label(1,i,sport,cellFormat);
			  						 Label label2 = new Label(2,i,data.court[change][game_court[i-1]],cellFormat);
			  						 Label label3 = new Label(3,i,data.player[change][game[0][i-1]],cellFormat);
			  						 Label label4 = new Label(4,i,data.player[change][game[1][i-1]],cellFormat);
			  						 sheet.addCell(label0);
			  						 sheet.addCell(label1);
			  						 sheet.addCell(label2);
			  						 sheet.addCell(label3); 
			  						 sheet.addCell(label4); 
			  					 }
			  					
			  					 workbook.write();
			  					 workbook.close();
			  					
			  				  }catch (IOException | WriteException e1) {
			  						e1.printStackTrace();
			  					} 
			    	   }
			       }
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {				
					File f = new File("場地資料.xls");
					Runtime.getRuntime().exec("cmd   /c   start   excel   \""   +   f.getAbsolutePath()   +   "\"");
				  }catch (IOException e1) {
					e1.printStackTrace();
				   } 
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				  try {				
					File f = new File("選手資料.xls");
					Runtime.getRuntime().exec("cmd   /c   start   excel   \""   +   f.getAbsolutePath()   +   "\"");
				  }catch (IOException e1) {
					e1.printStackTrace();
				   } 
			}
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File f = new File("比賽時間.xls");
					Runtime.getRuntime().exec("cmd   /c   start   excel   \""   +   f.getAbsolutePath()   +   "\"");
				 }catch (IOException  e1) {
					e1.printStackTrace();
				  } 
			}
		});
		
		
		
		
	}
}


class testcase{
   String [][] time=new String [5][];
   String [][] player=new String [5][];
   String [][] court=new String [5][];
   int temp;
   int [] time_ball=new int [5];
   int [] count_time=new int [5];
   int [] count_player=new int [5];
   int [] count_court=new int [5];
   testcase(){
	   //計算要開幾個不同的陣列
	  try{
		 Workbook workbook = Workbook.getWorkbook(new File("比賽時間.xls"));
		 Sheet sheet = workbook.getSheet(0);
		 temp=sheet.getRows()-1;//讀出文件有幾行
		 for(int i=0;i<temp;i++){     
		    Cell cell = sheet.getCell(1,i+1);
		    switch(cell.getContents()){
		       case "籃球":
		    	   time_ball[0]++;
		    	   break;
		       case "排球":
		    	   time_ball[1]++;
		    	   break;
		       case "棒球":
		    	   time_ball[2]++;
		    	   break;
		       case "羽球":
		    	   time_ball[3]++;
		    	   break;
		       case "足球":
		    	   time_ball[4]++;
		    	   break;
		    }
		 }

		    //資料輸入time
		    for(int i=0;i<5;i++){
	    	 time[i]=new String [time_ball[i]];
	        }
		    for(int i=0;i<temp;i++){     
			    Cell cell = sheet.getCell(0,i+1);//得到那欄
			    Cell cell2 = sheet.getCell(1,i+1);//得到那欄
			    String s=cell2.getContents();
			    
			    switch(s){
			    
			       case "籃球":
			    	   
			    	   time[0][count_time[0]]=cell.getContents();//讀取那欄的資料
			    	   count_time[0]++;
			    	   
			    	   break;
			       case "排球":
			    	   time[1][count_time[1]]=cell.getContents();
			    	   count_time[1]++;
			    	   break;
			       case "棒球":
			    	   time[2][count_time[2]]=cell.getContents();
			    	   count_time[2]++;
			    	   break;
			       case "羽球":
			    	   time[3][count_time[3]]=cell.getContents();
			    	   count_time[3]++;
			    	   break;
			       case "足球":
			    	   time[4][count_time[4]]=cell.getContents();
			    	   count_time[4]++;
			    	   break;
			    }
			 }
		  //資料輸入player
	     workbook = Workbook.getWorkbook(new File("選手資料.xls"));
	     sheet = workbook.getSheet(0);
	     temp=sheet.getRows()-1;//讀出文件有幾行
	     for(int i=0;i<5;i++){
	    	 player[i]=new String [time_ball[i]*2];
	     }
	     
	     for(int i=0;i<temp;i++){     
	        Cell cell = sheet.getCell(0,i+1);  //得到那欄
	        Cell cell2 = sheet.getCell(1,i+1);
	       //player[i]= cell.getContents();        //讀取那欄的資料
	        switch(cell2.getContents()){
		       case "籃球":
		    	   player[0][count_player[0]]=cell.getContents();
		    	   count_player[0]++;
		    	   break;
		       case "排球":
		    	   player[1][count_player[1]]=cell.getContents();
		    	   count_player[1]++;
		    	   break;
		       case "棒球":
		    	   player[2][count_player[2]]=cell.getContents();
		    	   count_player[2]++;
		    	   break;
		       case "羽球":
		    	   player[3][count_player[3]]=cell.getContents();
		    	   count_player[3]++;
		    	   break;
		       case "足球":
		    	   player[4][count_player[4]]=cell.getContents();
		    	   count_player[4]++;
		    	   break;
		    }
	     }
	     
	   //資料輸入court
	     workbook = Workbook.getWorkbook(new File("場地資料.xls"));
	     sheet = workbook.getSheet(0);
	     temp=sheet.getRows()-1;//讀出文件有幾行
	     for(int i=0;i<5;i++){
	    	 court[i]=new String [time_ball[i]];
	    	 //System.out.println(time_ball[i]+"yaya");
	     }
	     
	     for(int i=0;i<temp;i++){     
	        Cell cell = sheet.getCell(0,i+1);  //得到那欄
	        Cell cell2 = sheet.getCell(1,i+1);
	        Cell cell3 =sheet.getCell(2,i+1);
	       //player[i]= cell.getContents();        //讀取那欄的資料

	        switch(cell2.getContents()){
		       case "籃球":
		    	   for(int j=0;j<Integer.parseInt(cell3.getContents());j++){
		   	        
		    		   court[0][count_court[0]]=(cell.getContents()+(char)(j+65));
		    		   count_court[0]++;
		    	   }
		    	   break;
		       case "排球":
		    	   for(int j=0;j<Integer.parseInt(cell3.getContents());j++){
		    		   court[1][count_court[1]]=(cell.getContents()+(char)(j+65));
		    		   count_court[1]++;
		    	   }
		    	   break;
		       case "棒球":
		
		    	   for(int j=0;j<Integer.parseInt(cell3.getContents());j++){
			        	   
		    		   court[2][count_court[2]]=(cell.getContents()+(char)(j+65));
		    		   count_court[2]++;
		    	   }
		    	   break;
		       case "羽球":
		    	   for(int j=0;j<Integer.parseInt(cell3.getContents());j++){
		    		   court[3][count_court[3]]=cell.getContents()+(char)(j+65);
		    		   count_court[3]++;
		    	   }
		    	   break;
		       case "足球":
		    	   for(int j=0;j<Integer.parseInt(cell3.getContents());j++){
		    		   court[4][count_court[4]]=cell.getContents()+(char)(j+65);
		    		   count_court[4]++;
		    	   }
		    	   break;
		    }
	     }
	     //System.out.println(sheet.getRows());  //讀出文件有幾行
		 //System.out.println(sheet.getColumns()); //讀出文件有幾列
	     workbook.close();
	  }catch (IOException e) {
         e.printStackTrace();
       }catch (BiffException e) {
         e.printStackTrace();
        }
   }
}

class notice extends JFrame//子視窗
{ 
    public notice() 
    { 
        super("使用方法"); 
        setSize(500,200); 
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
        setVisible(true); 
        //容器 
        Container pn = getContentPane(); 
        //設定成FlowLayout
        FlowLayout fy = new FlowLayout();
        pn.setLayout(fy); 
        
        JLabel bt1 = new JLabel("1.當你打開系統時，此系統會自動建立比賽時間、選手資料、場地資料三個excel檔  "); 
        bt1.setFont(new Font("微軟正黑體", Font.BOLD, 13));
        pn.add(bt1); 
        bt1 = new JLabel("2.請使用按鈕【輸入比賽時間】、【輸入選手資料】、【輸入場地資料】來進行輸入"); 
        bt1.setFont(new Font("微軟正黑體", Font.BOLD, 13));
        pn.add(bt1); 
        bt1 = new JLabel("3.選擇輸出的賽程表的運動類型，當選擇的時候就會進行排賽程的動作                          "); 
        bt1.setFont(new Font("微軟正黑體", Font.BOLD, 13));
        pn.add(bt1); 
        bt1 = new JLabel("4.接下來使用【瀏覽賽程表】按鈕就可以看到你所選擇的賽程表摟                                  "); 
        bt1.setFont(new Font("微軟正黑體", Font.BOLD, 13));
        pn.add(bt1); 
        bt1 = new JLabel("注意事項1：每筆比賽時間對應兩筆選手資料和一個場地且運動項目必須相同              "); 
        bt1.setForeground(Color.RED);
        bt1.setFont(new Font("微軟正黑體", Font.BOLD, 13));
        pn.add(bt1);
        bt1 = new JLabel("注意事項2：運動項目請由籃球、排球、棒球、羽球、足球中做選擇                               "); 
        bt1.setForeground(Color.RED);
        bt1.setFont(new Font("微軟正黑體", Font.BOLD, 13));
        pn.add(bt1); 
        setContentPane(pn); 
    } 
}