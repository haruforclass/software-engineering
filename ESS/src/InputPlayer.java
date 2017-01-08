import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
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

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Window.Type;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class InputPlayer extends JDialog {

    JPanel contentPane;
    private JPanel imagePanel;
    private JTable table;
    private JTable table2;
    String input1=null;
    int input2=0;
    String input3=null;
    String input4=null;
    String input5=null;
    String input6=null;
    int dataCheck=0;
	public InputPlayer(String [] sport) {
		setTitle("輸入選手資料");
	
		//
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		ImageIcon img = new ImageIcon("input.jpg");
		JLabel background = new JLabel(img);
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		
		imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		
        setSize(img.getIconWidth(),img.getIconHeight());
		setLocationRelativeTo(this);  //設定視窗初始位置在螢幕中心
		setResizable(false); //設定JFrame視窗大小不可變
		setVisible(true);
		//
		
		//新增一個scrollPane給Jtable用
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 69, 501, 365);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		DefaultTableModel DTM = new DefaultTableModel(){
	    	 public boolean isCellEditable(int rowIndex, int columnIndex){
	    	     return false;
	    	 }
	    };
	    table.setModel(DTM);
		String s[]={"選手名稱","運動項目","性別","國籍","生日","手機"};
	    DTM.setColumnIdentifiers(s);
	    table.setBackground(Color.WHITE);
	    //table.setPreferredScrollableViewportSize(new Dimension(200, 150));
		scrollPane.setViewportView(table);
	
		
		//標題
		JLabel label = new JLabel("輸入資料ー選手資料");
		label.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		label.setBounds(20, 10, 250, 49);
		contentPane.add(label);
		//使用方法
		JButton btnNewButton_1 = new JButton(new ImageIcon("question.jpg"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Instructions notice=new Instructions(0);
			}
		});
		btnNewButton_1.setBounds(625,5, 60, 57);
		contentPane.add(btnNewButton_1);
		//輸入按鈕-儲存資料的deque
		   ArrayList<String> dataSport  = new ArrayList<String>();
		   ArrayList<String> dataPlayer = new ArrayList<String>();
		   ArrayList<String> male = new ArrayList<String>();
		   ArrayList<String> country = new ArrayList<String>();
		   ArrayList<String> age = new ArrayList<String>();
		   ArrayList<String> phonenumber = new ArrayList<String>();
		//輸入按鈕-實際按鈕本體
		JButton inputButton = new JButton(new ImageIcon("BUTTON1_新增資料.JPG"));
		inputButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		inputButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dataCheck=0;
				inputwindows in=new inputwindows(sport);
				 in.setModal(true);  
				 in.ininder();
				 if(dataCheck==0){
					 DTM.addRow(new Object[]{input1,sport[input2],input3,input4,input5,input6});
					 dataPlayer.add(input1);
					 dataSport.add(sport[input2]);
					 male.add(input3);
					 country.add(input4);
					 age.add(input5);
					 phonenumber.add(input6);
				 }
				 else{
					 JOptionPane.showMessageDialog(null,"輸入資料不完整，請再輸入一次",  
							 "輸入錯誤",JOptionPane.WARNING_MESSAGE);
				 }
			}
		});
		inputButton.setBounds(531, 69, 128, 64);
		inputButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		inputButton.setBackground(Color.WHITE);
		contentPane.add(inputButton);
		
		/*
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		label_1.setBounds(324, 10, 278, 49);
		contentPane.add(label_1);
		*/
		
	
		//刪除資料
		JButton button_1 = new JButton(new ImageIcon("BUTTON1_刪除資料.JPG"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dataSport.remove(table.getSelectedRow());
                 dataPlayer.remove(table.getSelectedRow());
                 male.remove(table.getSelectedRow());
				   country.remove(table.getSelectedRow());
				   age.remove(table.getSelectedRow());
				   phonenumber.remove(table.getSelectedRow());
				   DTM.removeRow(table.getSelectedRow());
			}
		});
		button_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		button_1.setBackground(new Color(255, 222, 173));
		button_1.setBounds(531, 143, 128, 64);
		contentPane.add(button_1);
		
		//重新輸入按鈕
				JButton removeAll = new JButton(new ImageIcon("BUTTON1_重新輸入.JPG"));
				removeAll.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for (int index = DTM.getRowCount()-1; index >= 0; index--) {
							DTM.removeRow(index);
				        }
						int temp=dataPlayer.size();
						for(int i=0;i<temp;i++){
							dataPlayer.remove(0);
							dataSport.remove(0);
							male.remove(0);
							country.remove(0);
							phonenumber.remove(0);
							age.remove(0);
						}
					}
				});
				removeAll.setFont(new Font("微軟正黑體", Font.BOLD, 20));
				removeAll.setBounds(531, 217, 128, 64);
				contentPane.add(removeAll);
		
		//前往下一個視窗按鈕
		JButton button = new JButton(new ImageIcon("BUTTON2_輸入完畢.JPG"));
		button.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/*WritableWorkbook workbook = Workbook.createWorkbook(new File("系統資料.xls"));
					WritableSheet sheet = workbook.createSheet("運動項目", 0);*/
					
					Workbook wb = Workbook.getWorkbook(new File("系統資料.xls"));
					WritableWorkbook workbook = Workbook.createWorkbook(new File("系統資料.xls"), wb);
					WritableSheet sheet = workbook.createSheet("選手資料", 2);
					
					//這邊是字形跟儲存格的設定
					WritableFont myFont = new WritableFont(WritableFont.createFont("標楷體"), 14);        
		            myFont.setColour(Colour.BLACK);
					WritableCellFormat cellFormat = new WritableCellFormat();
					cellFormat.setFont(myFont); // 指定字型
		            cellFormat.setBackground(Colour.SKY_BLUE); // 背景顏色
		            cellFormat.setAlignment(Alignment.CENTRE); // 對齊方式
		            
		            //儲存格大小
		            for(int i=0;i<6;i++){
		            	sheet.setColumnView(i, 30);
		            }
					
					
					sheet.addCell(new Label(0,0,"選手名稱",cellFormat));
					sheet.addCell(new Label(1,0,"運動項目",cellFormat));
					sheet.addCell(new Label(2,0,"性別",cellFormat));
					sheet.addCell(new Label(3,0,"國籍",cellFormat));
					sheet.addCell(new Label(4,0,"生日",cellFormat));
					sheet.addCell(new Label(5,0,"電話",cellFormat));
					int temp=dataPlayer.size();
		            for(int i=1;i<=temp;i++){
		            	sheet.addCell(new Label(0,i,dataPlayer.get(i-1)));
		            	sheet.addCell(new Label(1,i,dataSport.get(i-1)));
		            	sheet.addCell(new Label(2,i,male.get(i-1)));
		            	sheet.addCell(new Label(3,i,country.get(i-1)));
		            	sheet.addCell(new Label(4,i,age.get(i-1)));
		            	sheet.addCell(new Label(5,i,phonenumber.get(i-1)));
		            }
					workbook.write();
					workbook.close();
				} catch (IOException  | WriteException | BiffException e1) {
					// TODO 自動產生的 catch 區塊
					e1.printStackTrace();
				}
				InputCourt in=new InputCourt(sport);
				setVisible(false); 
			}
		});
		button.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		button.setBounds(531, 315, 128, 64);
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
	   
	   
	    public inputwindows(String [] sport){
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
			textField.setBounds(131, 27, 194, 31);
			contentPane2.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
			textField_1.setColumns(10);
			textField_1.setBounds(131, 138, 194, 31);
			contentPane2.add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
			textField_2.setColumns(10);
			textField_2.setBounds(131, 172, 194, 31);
			contentPane2.add(textField_2);
			
			textField_3 = new JTextField();
			textField_3.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
			textField_3.setColumns(10);
			textField_3.setBounds(131, 206, 194, 31);
			contentPane2.add(textField_3);
			
			
			//JRadioButton 
			radio1 = new JRadioButton("男性");
			radio1.setBounds(131, 111, 69, 23);
			radio1.setSelected(true);
			contentPane2.add(radio1);
			
			radio0 = new JRadioButton("女性");
			radio0.setBounds(218, 111, 69, 23);
			contentPane2.add(radio0);
			
			//讓JRadioButton只有一個是被選擇的 
			ButtonGroup bgroup1 = new ButtonGroup();
			bgroup1.add(radio0);
			bgroup1.add(radio1);
			
			//這邊進行combobox的輸入
			comboBox = new JComboBox(sport);
			comboBox.setBounds(131, 68, 194, 37);
			contentPane2.add(comboBox);
			
			
			//按鈕
			JButton btnNewButton = new JButton(new ImageIcon("BUTTON1_確認.JPG"));
			btnNewButton.addActionListener(new ActionListener() {
		    	  public void actionPerformed(ActionEvent e) {   	     
		    	    	setVisible(false);  	
		    	        dispose();    
		    	  }
		       });
			btnNewButton.setBounds(120, 282, 100, 48);
			contentPane2.add(btnNewButton);
			
			//下面全部都是字
			lblNewLabel = new JLabel("姓名：");
			lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			lblNewLabel.setBounds(40, 30, 163, 25);
			contentPane2.add(lblNewLabel);
			
			label_2 = new JLabel("比賽項目：");
			label_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			label_2.setBounds(40, 68, 163, 25);
			contentPane2.add(label_2);
			
			label = new JLabel("性別：");
			label.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			label.setBounds(40, 106, 163, 25);
			contentPane2.add(label);
			
			label_1 = new JLabel("國籍：");
			label_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			label_1.setBounds(40, 141, 163, 25);
			contentPane2.add(label_1);
			
			label_3 = new JLabel("生日：");
			label_3.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			label_3.setBounds(40, 175, 163, 25);
			contentPane2.add(label_3);
			label_3 = new JLabel("手機：");
			label_3.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			label_3.setBounds(40, 209, 163, 25);
			contentPane2.add(label_3);
		}
	    public void ininder(){
			setVisible(true);
			if(textField.getText().length() != 0 && textField_1.getText().length() != 0 && textField_2.getText().length() != 0){
	    	input1=textField.getText();
	    	input2=comboBox.getSelectedIndex();
	    	   if(radio0.isSelected()){
	    		   input3="女性";
	    	   }
	    	   else if(radio1.isSelected()){
	    		   input3="男性";
	    	   }
	    	   else {
	    		   dataCheck=1;
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