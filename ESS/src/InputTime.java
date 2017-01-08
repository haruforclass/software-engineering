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

public class InputTime extends JDialog {

    JPanel contentPane,imagePanel ;
    private JTable table;
    String input1=null;
    int input2=0;
    int dataCheck=0;
	public InputTime(String [] sport) {
		setTitle("輸入時間資料");
		
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
		String s[]={"比賽時間","運動項目"};
	    DTM.setColumnIdentifiers(s);
	    table.setBackground(Color.WHITE);
	    table.setPreferredScrollableViewportSize(new Dimension(200, 150));
		scrollPane.setViewportView(table);
		
		//標題
		JLabel label = new JLabel("輸入資料ー比賽時間");
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
	    ArrayList<String> dataTime   = new ArrayList<String>();
		//Deque<String> dataTime = new ArrayDeque<String>();
		//Deque<String> dataSport = new ArrayDeque<String>();
		//輸入按鈕-實際按鈕本體
		JButton inputButton = new JButton(new ImageIcon("BUTTON1_新增資料.JPG"));
		inputButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		inputButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dataCheck=0;
				inputwindows in=new inputwindows(sport);
				 in.setModal(true);  
				 in.ininder();
				 
				 /*in.getTextField();*/
				 if(dataCheck==0){
					 DTM.addRow(new Object[]{input1,sport[input2]});
					 dataTime.add(input1);
					 dataSport.add(sport[input2]);
				 }
				 else{
					 JOptionPane.showMessageDialog(null,"輸入資料不完整，請再輸入一次",  
							 "輸入錯誤",JOptionPane.WARNING_MESSAGE);
				 }
			}
		});
		inputButton.setBounds(531, 69, 128, 64);
		contentPane.add(inputButton);
		
		
		//刪除資料
				JButton button_1 = new JButton(new ImageIcon("BUTTON1_刪除資料.JPG"));
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dataSport.remove(table.getSelectedRow());
		                   dataTime.remove(table.getSelectedRow());
						   DTM.removeRow(table.getSelectedRow());
					}
				});
				button_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
				button_1.setBounds(531, 143, 128, 64);
				contentPane.add(button_1);
		//重新輸入
		JButton removeAll = new JButton(new ImageIcon("BUTTON1_重新輸入.JPG"));
		removeAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int index = DTM.getRowCount()-1; index >= 0; index--) {
					DTM.removeRow(index);
		        }
				int temp=dataTime.size();
				for(int i=0;i<temp;i++){
					dataTime.remove(0);
					dataSport.remove(0);
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
					
					Workbook wb = Workbook.getWorkbook(new File("系統資料.xls"));
					WritableWorkbook workbook = Workbook.createWorkbook(new File("系統資料.xls"), wb);
					WritableSheet sheet = workbook.createSheet("比賽時間", 1);
					
					//這邊是字形跟儲存格的設定
					WritableFont myFont = new WritableFont(WritableFont.createFont("標楷體"), 14);        
		            myFont.setColour(Colour.BLACK);
					WritableCellFormat cellFormat = new WritableCellFormat();
					cellFormat.setFont(myFont); // 指定字型
		            cellFormat.setBackground(Colour.SKY_BLUE); // 背景顏色
		            cellFormat.setAlignment(Alignment.CENTRE); // 對齊方式
		            
		            //儲存格大小
		            sheet.setColumnView(0, 50);
		            sheet.setColumnView(1, 50);
					
					sheet.addCell(new Label(0,0,"比賽時間",cellFormat));
					sheet.addCell(new Label(1,0,"運動項目",cellFormat));
					
					int temp=dataTime.size();
		            for(int i=1;i<=temp;i++){
		            	sheet.addCell(new Label(0,i,dataTime.get(i-1)));
		            	sheet.addCell(new Label(1,i,dataSport.get(i-1)));
		            }
					workbook.write();
					workbook.close();
				} catch (IOException  | WriteException | BiffException e1) {
					e1.printStackTrace();
				}
				InputPlayer in=new InputPlayer(sport);
				setVisible(false); 
			}
		});
		button.setBounds(531, 315, 128, 64);
		contentPane.add(button);
		
	}
	
	class inputwindows extends JDialog{
	    JPanel contentPane2,imagePanel2 ;
	    JTextField textField;
	    JComboBox comboBox;
	    private JLabel lblNewLabel;
	    private JLabel label;
	    public inputwindows(String [] sport){
	  	  
	    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);			
			contentPane2 = new JPanel();
			contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane2.setLayout(null);
			setContentPane(contentPane2);
			
			ImageIcon img = new ImageIcon("input_time.jpg");
			JLabel background = new JLabel(img);
			background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
			imagePanel2 = (JPanel) this.getContentPane();
			imagePanel2.setOpaque(false);
	        getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));
			setSize(img.getIconWidth(),img.getIconHeight());
			setLocationRelativeTo(this);  //設定視窗初始位置在螢幕中心
			setResizable(false); //設定JFrame視窗大小不可變
			setVisible(false); 
			
			textField = new javax.swing.JTextField();
			textField.setFont(new Font("微軟正黑體", Font.PLAIN,18));
			textField.setBounds(111, 27, 194, 31);
			contentPane2.add(textField);
			textField.setColumns(10);
			
			//這邊進行combobox的輸入
			comboBox = new JComboBox(sport);
			comboBox.setBounds(111, 68, 194, 37);
			contentPane2.add(comboBox);
			
			JButton btnNewButton = new JButton(new ImageIcon("BUTTON1_確認.JPG"));
			btnNewButton.addActionListener(new ActionListener() {
		    	  public void actionPerformed(ActionEvent e) {   	     
		    	    	setVisible(false);  	
		    	        dispose();    
		    	  }
		       });
			btnNewButton.setBounds(117, 129, 99, 48);
			contentPane2.add(btnNewButton);
			
			lblNewLabel = new JLabel("比賽時間：");
			lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			lblNewLabel.setBounds(10, 30, 163, 25);
			contentPane2.add(lblNewLabel);
			
			label = new JLabel("運動項目：");
			label.setFont(new Font("微軟正黑體", Font.BOLD, 18));
			label.setBounds(10, 68, 163, 25);
			contentPane2.add(label);
		}
	    public void ininder(){
			setVisible(true);
			if(textField.getText().length() != 0){
	    	input1=textField.getText();
	    	input2=comboBox.getSelectedIndex();
			}
			else{
				dataCheck=1;	
			}
	    }
	    
	}
}