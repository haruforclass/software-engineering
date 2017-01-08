import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

public class InputSport extends JDialog {

    private JPanel contentPane;
    private JPanel imagePanel;
    private JTable table;
    String input1;
    int dataCheck;
	public InputSport() {
		setTitle("輸入運動項目");		
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
		
		//標題
		JLabel label = new JLabel("輸入資料ー運動項目");
		label.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		label.setBounds(20, 10, 250, 49);
		contentPane.add(label);
		
		JButton btnNewButton_1 = new JButton(new ImageIcon("question.jpg"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Instructions notice=new Instructions(0);
			}
		});
		btnNewButton_1.setBounds(625,5, 60, 57);
		contentPane.add(btnNewButton_1);
		
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
				String s[]={"運動項目"};
			    DTM.setColumnIdentifiers(s);
			    table.setBackground(Color.WHITE);
			    table.setPreferredScrollableViewportSize(new Dimension(200, 150));
				scrollPane.setViewportView(table);
		
		//建立儲存資料的Deque
	    ArrayList<String> dataSport  = new ArrayList<String>();
	    ArrayList<String> gototime   = new ArrayList<String>();
	    
		//新增運動項目的按鈕
		JButton addsport = new JButton(new ImageIcon("BUTTON1_新增資料.JPG"));
		addsport.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		addsport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dataCheck=0;
				inputwindows in=new inputwindows();
				 in.setModal(true);  
				 in.ininder();
				 
				 /*in.getTextField();*/
				 if(dataCheck==0){
					 DTM.addRow(new Object[]{input1});
					 
					 dataSport.add(input1);
					 gototime.add(input1);
				 }
				 else{
					 JOptionPane.showMessageDialog(null,"輸入資料不完整，請再輸入一次",  
							 "輸入錯誤",JOptionPane.WARNING_MESSAGE);
				 }
			}
		});
		addsport.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		addsport.setBounds(531, 69, 128, 64);
		contentPane.add(addsport);
		
	
		//刪除資料
		JButton button_1 = new JButton(new ImageIcon("BUTTON1_刪除資料.JPG"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 dataSport.remove(table.getSelectedRow());
				   gototime.remove(table.getSelectedRow());
				   DTM.removeRow(table.getSelectedRow());
			}
		});
		button_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		button_1.setBounds(531, 143, 128, 64);
		contentPane.add(button_1);
		//
		
		JButton button = new JButton(new ImageIcon("BUTTON1_重新輸入.JPG"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int index = DTM.getRowCount()-1; index >= 0; index--) {
					DTM.removeRow(index);
		        }
				int temp=gototime.size();
				for(int i=0;i<temp;i++){
					gototime.remove(0);
					dataSport.remove(0);
				}
			}
		});
		button.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		button.setBounds(531, 217, 128, 64);
		contentPane.add(button);
		//前往下一個視窗的按鈕
		JButton next = new JButton(new ImageIcon("BUTTON2_輸入完畢.JPG"));
		next.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				try {
					WritableWorkbook workbook = Workbook.createWorkbook(new File("系統資料.xls"));
					WritableSheet sheet = workbook.createSheet("運動項目", 0);
					
					
					
					//這邊是字形跟儲存格的設定
					WritableFont myFont = new WritableFont(WritableFont.createFont("標楷體"), 14);        
		            myFont.setColour(Colour.BLACK);
					WritableCellFormat cellFormat = new WritableCellFormat();
					cellFormat.setFont(myFont); // 指定字型
		            cellFormat.setBackground(Colour.SKY_BLUE); // 背景顏色
		            cellFormat.setAlignment(Alignment.CENTRE); // 對齊方式
		            
		            //儲存格大小
		            sheet.setColumnView(0, 50);
					
		            //設定第一格的標題
					sheet.addCell(new Label(0,0,"運動項目",cellFormat));
					int temp=dataSport.size();
		            for(int i=1;i<=temp;i++){
		            	//sheet.addCell(new Label(0,i,dataSport.pollFirst()));
		            	sheet.addCell(new Label(0,i,dataSport.get(i-1)));
		            }
		            
					workbook.write();
					workbook.close();
				} catch (IOException  | WriteException e) {
					e.printStackTrace();
				}
				String [] gototime2= new String [gototime.size()]; 
				int temp=gototime.size();
				for(int i=0;i<temp;i++){
					//gototime2[i]=gototime.pollFirst();
					gototime2[i]=gototime.get(i);
				}
				InputTime in=new InputTime(gototime2);
				setVisible(false);  
			}
		});
		next.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		next.setBounds(531, 315, 128, 64);
		contentPane.add(next);
		
		
		
		
	
	}
	
	
	//輸入的dialog視窗
	class inputwindows extends JDialog{
		private  JPanel contentPane2,imagePanel2;
	    JTextField textField;
	    JComboBox comboBox;
	    private JLabel lblNewLabel;
	    public inputwindows(){
	  	  
	    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);			
			contentPane2 = new JPanel();
			contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane2.setLayout(null);
			setContentPane(contentPane2);
			
			ImageIcon img = new ImageIcon("input_sport.jpg");
			JLabel background = new JLabel(img);
			background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
			imagePanel2 = (JPanel) this.getContentPane();
			imagePanel2.setOpaque(false);
	        getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));
			setSize(img.getIconWidth(),img.getIconHeight());
			setLocationRelativeTo(this);  //設定視窗初始位置在螢幕中心
			setResizable(false); //設定JFrame視窗大小不可變
			setVisible(false); 
			
			
			lblNewLabel = new JLabel("運動項目：");
			lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			lblNewLabel.setBounds(10, 30, 143, 25);
			contentPane2.add(lblNewLabel);
			
			textField = new javax.swing.JTextField();
			textField.setFont(new Font("微軟正黑體", Font.PLAIN,18));
			textField.setBounds(111, 27, 194, 31);
			contentPane2.add(textField);
			textField.setColumns(10);
			
		
			
			JButton btnNewButton = new JButton(new ImageIcon("BUTTON1_確認.JPG"));
			btnNewButton.addActionListener(new ActionListener() {
		    	  public void actionPerformed(ActionEvent e) {   	     
		    	    	setVisible(false);  	
		    	        dispose();    
		    	  }
		       });
			btnNewButton.setBounds(112,75,100, 48);
			contentPane2.add(btnNewButton);
			
			
		}
	    public void ininder(){
			setVisible(true);
			if(textField.getText().length() != 0){
	    	input1=textField.getText();
			}
			else{
				dataCheck=1;	
			}
	    }    
	}
}
