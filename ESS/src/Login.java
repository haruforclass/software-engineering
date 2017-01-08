import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPanel imagePanel = null;
	private JTextField textField;
	private JTextField textField_1;
	String input1=null;
	String input2=null;
	String input3=null;
	String input4=null;
	String input5=null;
	String input6=null;
	int dataCheck=0;

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		ImageIcon img = new ImageIcon("LOGIN.jpg");
		JLabel background = new JLabel(img);
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		
		imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		
		setSize(img.getIconWidth(),img.getIconHeight());
		setLocationRelativeTo(this);  
		setResizable(false);
		setResizable(false); //設定JFrame視窗大小不可變
		setVisible(true);
		//標題

		JLabel lblNewLabel = new JLabel("登入系統");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 40));
		lblNewLabel.setBounds(224, 25, 215, 57);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("帳號：");
		label.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		label.setBounds(143, 111, 99, 57);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("密碼：");
		label_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		label_1.setBounds(143, 179, 128, 57);
		contentPane.add(label_1);
		//textField
		
		textField = new JTextField();
		textField.setBounds(207, 123, 215, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(207, 194, 215, 35);
		contentPane.add(textField_1);
		//
		 
		    
		//button
		JButton btnNewButton = new JButton(new ImageIcon("BUTTON2_申請帳號.jpg"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> name  = new ArrayList<String>();
				ArrayList<String> user   = new ArrayList<String>();
				ArrayList<String> male  = new ArrayList<String>();
				ArrayList<String> account  = new ArrayList<String>();
				ArrayList<String> password  = new ArrayList<String>();
				ArrayList<String> phone   = new ArrayList<String>();
				
				dataCheck=0;
				inputwindows in = new inputwindows();
				in.setModal(true);  
				in.ininder();
				if(dataCheck==0){
					try{
						 Workbook workbook = Workbook.getWorkbook(new File("帳號密碼.xls"));
						 //讀比賽項目資料
						 Sheet sheet = workbook.getSheet(0);
						 int temp=sheet.getRows()-1;//讀出文件有幾行
						 for(int i=1;i<=temp;i++){
							 name.add(sheet.getCell(0,i).getContents());
						 }
						 for(int i=1;i<=temp;i++){
							 user.add(sheet.getCell(1,i).getContents());
						 }
						 for(int i=1;i<=temp;i++){
							 male.add(sheet.getCell(2,i).getContents());
						 }
						 for(int i=1;i<=temp;i++){
							 account.add(sheet.getCell(3,i).getContents());
						 }
						 for(int i=1;i<=temp;i++){
							 password.add(sheet.getCell(4,i).getContents());
						 }
						 for(int i=1;i<=temp;i++){
							 phone.add(sheet.getCell(5,i).getContents());
						 }
					  }catch (IOException | BiffException e1) {
					         e1.printStackTrace();
					   }
					
					name.add(input1);
					user.add(input2);
					male.add(input3);
					account.add(input4);
					password.add(input5);
					phone.add(input6);
					
					try {
						WritableWorkbook workbook = Workbook.createWorkbook(new File("帳號密碼.xls"));
						WritableSheet sheet = workbook.createSheet("運動項目", 0);
						
						
						
						//這邊是字形跟儲存格的設定
						WritableFont myFont = new WritableFont(WritableFont.createFont("標楷體"), 14);        
			            myFont.setColour(Colour.BLACK);
						WritableCellFormat cellFormat = new WritableCellFormat();
						cellFormat.setFont(myFont); // 指定字型
			            cellFormat.setBackground(Colour.SKY_BLUE); // 背景顏色
			            cellFormat.setAlignment(Alignment.CENTRE); // 對齊方式
			            
			            //儲存格大小
			            for(int i=0;i<6;i++){
			            	sheet.setColumnView(i,30);
			            }
						
			            //設定第一格的標題
						sheet.addCell(new Label(0,0,"姓名",cellFormat));
						sheet.addCell(new Label(1,0,"身分",cellFormat));
						sheet.addCell(new Label(2,0,"性別",cellFormat));
						sheet.addCell(new Label(3,0,"帳號",cellFormat));
						sheet.addCell(new Label(4,0,"密碼",cellFormat));
						sheet.addCell(new Label(5,0,"聯絡資料",cellFormat));
						int temp=name.size();
			            for(int i=1;i<=temp;i++){
			            	//sheet.addCell(new Label(0,i,dataSport.pollFirst()));
			            	sheet.addCell(new Label(0,i,name.get(i-1)));
			            	sheet.addCell(new Label(1,i,user.get(i-1)));
			            	sheet.addCell(new Label(2,i,male.get(i-1)));
			            	sheet.addCell(new Label(3,i,account.get(i-1)));
			            	sheet.addCell(new Label(4,i,password.get(i-1)));
			            	sheet.addCell(new Label(5,i,phone.get(i-1)));
			            }
			            
						workbook.write();
						workbook.close();
					} catch (IOException  | WriteException e1) {
						e1.printStackTrace();
					}
					
				}
				else{
					JOptionPane.showMessageDialog(null,"輸入資料不完整，請再輸入一次",  
							 "輸入錯誤",JOptionPane.WARNING_MESSAGE);
							  
				}
				
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(152, 251, 152));
		btnNewButton.setBounds(143, 278, 128, 45);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton(new ImageIcon("BUTTON1_確認登入.jpg"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					 Workbook workbook = Workbook.getWorkbook(new File("帳號密碼.xls"));
					 //讀比賽項目資料
					 Sheet sheet = workbook.getSheet(0);
					 int temp=sheet.getRows()-1;//讀出文件有幾行
					 String account=textField.getText();
					 String password=textField_1.getText();
					 
					 for(int i=1;i<=temp;i++){
						 if(sheet.getCell(3,i).getContents().equals(account)){
							 if(sheet.getCell(4,i).getContents().equals(password)){
								 JOptionPane.showMessageDialog(null,"使用者 "+sheet.getCell(0,i).getContents()+
								 " 你好，歡迎使用系統!","你好",JOptionPane.INFORMATION_MESSAGE);
								 ESSClient in = new ESSClient(sheet.getCell(0,i).getContents(),sheet.getCell(1,i).getContents());
								 setVisible(false);
							 }
							 else{
								 JOptionPane.showMessageDialog(null,"密碼輸入錯誤，請再輸入一次",  
										 "輸入錯誤",JOptionPane.WARNING_MESSAGE);
							 }
							 break;
						 }
						 if(i==temp){
							 JOptionPane.showMessageDialog(null,"查無此帳號，請再輸入一次",  
									 "輸入錯誤",JOptionPane.WARNING_MESSAGE);
						 }
					 }
					 
					 
				  }catch (IOException | BiffException e1) {
				         e1.printStackTrace();
				   }
    	    	
			}
		});
		button.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		button.setBackground(new Color(255, 222, 173));
		button.setBounds(327, 278, 128, 45);
		contentPane.add(button);

	}
	class inputwindows extends JDialog{
		private JPanel contentPane2,imagePanel2;
		private JLabel lblNewLabel;
		private JLabel label;
		private JLabel label_1;
		private JLabel label_2;
	    private JLabel label_3;
	    private JRadioButton radio0;
	    private JRadioButton radio1; 
	    private JTextField textField;
	    private JTextField textField_1;
	    private JTextField textField_2;
	    private JTextField textField_3;
	    JComboBox comboBox;
	   
	   
	    public inputwindows(){
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);			
			contentPane2 = new JPanel();
			contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane2.setLayout(null);
			setContentPane(contentPane2);
			
			ImageIcon img = new ImageIcon("input_player.jpg");
			JLabel background = new JLabel(img);
			background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
			imagePanel2 = (JPanel) this.getContentPane();
			imagePanel2.setOpaque(false);
	        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
	        setSize(img.getIconWidth(),img.getIconHeight());
			setLocationRelativeTo(this);  //設定視窗初始位置在螢幕中心
			setResizable(false); //設定JFrame視窗大小不可變
			setVisible(false); 
			
			
			
			
			
			
			//以下全部都是textField
			textField = new JTextField();
			textField.setFont(new Font("微軟正黑體", Font.PLAIN,18));
			textField.setBounds(131, 57, 194, 31);
			contentPane2.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
			textField_1.setColumns(10);
			textField_1.setBounds(131, 168, 194, 31);
			contentPane2.add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
			textField_2.setColumns(10);
			textField_2.setBounds(131, 202, 194, 31);
			contentPane2.add(textField_2);
			
			textField_3 = new JTextField();
			textField_3.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
			textField_3.setColumns(10);
			textField_3.setBounds(131, 236, 194, 31);
			contentPane2.add(textField_3);
			
			
			//JRadioButton 
			radio1 = new JRadioButton("男性");
			radio1.setBounds(131, 141, 69, 23);
			radio1.setSelected(true);
			contentPane2.add(radio1);
			
			radio0 = new JRadioButton("女性");
			radio0.setBounds(218, 141, 69, 23);
			contentPane2.add(radio0);
			
			//讓JRadioButton只有一個是被選擇的 
			ButtonGroup bgroup1 = new ButtonGroup();
			bgroup1.add(radio0);
			bgroup1.add(radio1);
			
			//這邊進行combobox的輸入
			comboBox = new JComboBox(new String []{"運動員","管理員"});
			comboBox.setBounds(131, 98, 194, 37);
			contentPane2.add(comboBox);
			
			
			//按鈕
			JButton btnNewButton = new JButton(new ImageIcon("BUTTON1_確認.JPG"));
			btnNewButton.addActionListener(new ActionListener() {
		    	  public void actionPerformed(ActionEvent e) {   	     
		    	    	setVisible(false);  	
		    	        dispose();    
		    	  }
		       });
			btnNewButton.setBounds(120, 295, 100, 48);
			contentPane2.add(btnNewButton);
			
			//下面全部都是字
			lblNewLabel = new JLabel("姓名：");
			lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			lblNewLabel.setBounds(40, 60, 163, 25);
			contentPane2.add(lblNewLabel);
			
			label_2 = new JLabel("身分選擇：");
			label_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			label_2.setBounds(40, 98, 163, 25);
			contentPane2.add(label_2);
			
			label = new JLabel("性別：");
			label.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			label.setBounds(40, 136, 163, 25);
			contentPane2.add(label);
			
			label_1 = new JLabel("帳號：");
			label_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			label_1.setBounds(40, 171, 163, 25);
			contentPane2.add(label_1);
			
			label_3 = new JLabel("密碼：");
			label_3.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			label_3.setBounds(40, 205, 163, 25);
			contentPane2.add(label_3);
			label_3 = new JLabel("聯絡資料：");
			label_3.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			label_3.setBounds(40, 239, 163, 25);
			contentPane2.add(label_3);
			
			JLabel lblNewLabel = new JLabel("申請帳號");
			lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 36));
			lblNewLabel.setBounds(98,0, 297, 71);
			contentPane2.add(lblNewLabel);
		}
	    public void ininder(){
			setVisible(true);
			if(textField.getText().length() != 0 && textField_1.getText().length() != 0 && textField_2.getText().length() != 0&& textField_3.getText().length() != 0){
	    	input1=textField.getText();
	    	  if(comboBox.getSelectedIndex()==0){
	    		  input2="運動員";
	    	  }
	    	  else{
	    		  input2="管理員";
	    	  }
	    		  
	    	  if(radio0.isSelected()){
	    		  input3="女性";
	    	  }
	    	  else if(radio1.isSelected()){
	    		  input3="男性";
	    	  }
	    	input4=textField_1.getText();
	    	input5=textField_2.getText();
	    	input6=textField_3.getText();
			}
			else{
				dataCheck=1;	
			}
	    }
	    
	}
}
