import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
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
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;

public class ScheduleWindows extends JDialog {

    JPanel contentPane,imagePanel;
    private JTable table;
    private JTable table2;
    JComboBox comboBox;
    String input1=null;
    int input2=0;
    int dataCheck=0;
    String [][] player;
    int playerCount=0;
	public ScheduleWindows(String [] sport) {
		setTitle("賽程表");
		
		//
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		ImageIcon img = new ImageIcon("schedule.jpg");
		JLabel background = new JLabel(img);
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		
		imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		
		setSize(img.getIconWidth(),img.getIconHeight());
		setLocationRelativeTo(this);  //設定視窗初始位置在螢幕中心
		setResizable(false); //設定JFrame視窗大小不可變
		setVisible(true);
		
		//建立一個JScrollPane給table用
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 486, 299);
		contentPane.add(scrollPane);
		
		table = new JTable();
		DefaultTableModel DTM = new DefaultTableModel(){
	    	 public boolean isCellEditable(int rowIndex, int columnIndex){
	    	     return false;
	    	 }
	    };
	    table.setModel(DTM);
		String s[]={"比賽時間","運動項目","比賽場地","參賽者","參賽者"};
	    DTM.setColumnIdentifiers(s);
	    table.setBackground(Color.WHITE);
	    table.setPreferredScrollableViewportSize(new Dimension(200, 150));
		scrollPane.setViewportView(table); 
		//第二個table
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 452, 659, 185);
		contentPane.add(scrollPane_1);
		
		table2 = new JTable();
		DefaultTableModel DTM2 = new DefaultTableModel(){
	    	 public boolean isCellEditable(int rowIndex, int columnIndex){
	    	     return false;
	    	 }
	    };
	    table2.setModel(DTM2);
	    //使用方法
		 JButton btnNewButton_1 = new JButton(new ImageIcon("question.jpg"));
		 btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		  		Instructions notice=new Instructions(0,0);
			}
		 });
		 btnNewButton_1.setBounds(615,5, 60, 57);
		 contentPane.add(btnNewButton_1);
		
		//滑鼠點擊事件
				table.addMouseListener(new MouseListener(){ 
					public void mouseClicked(MouseEvent e){
		            int clickCount = e.getClickCount();
		            if (clickCount == 2){
		               int n=0,m=0;
		                for(int i=0;i<playerCount;i++){
		                	if(player[i][0].equals(DTM.getValueAt(table.getSelectedRow(),3))){
		                		n=i;
		                	}
		                	if(player[i][0].equals(DTM.getValueAt(table.getSelectedRow(),4))){
		                		m=i;
		                	}
		                }
		                
		                DTM2.setValueAt(DTM.getValueAt(table.getSelectedRow(),0),0,1);
		                DTM2.setValueAt(DTM.getValueAt(table.getSelectedRow(),1),1,1);
		                DTM2.setValueAt(DTM.getValueAt(table.getSelectedRow(),2),2,1);
		                String [] title={"選手名稱","運動項目","選手性別","選手國籍","選手生日","選手手機"};
		                for(int i=0;i<6;i++){
		                	DTM2.setValueAt(title[i],i,2);
		                	DTM2.setValueAt(player[n][i],i,3);
		                	DTM2.setValueAt(player[m][i],i,4);
		                }
					    table2.setBackground(Color.WHITE);
					    table2.setPreferredScrollableViewportSize(new Dimension(200, 150));
						scrollPane_1.setViewportView(table2);
		               
						
		            }
		            
		          }
				  public void mousePressed(MouseEvent e){}
			      public void mouseReleased(MouseEvent e){}
			      public void mouseEntered(MouseEvent e){}
			      public void mouseExited(MouseEvent e){}
			    });
		
		//combobox
		comboBox = new JComboBox(sport);
		comboBox.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u8ACB\u9078\u64C7\u904B\u52D5\u9805\u76EE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		comboBox.setBounds(506, 117, 163, 73);
		contentPane.add(comboBox);
        
		//上面的字
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 34));
		lblNewLabel.setBounds(10, 10, 423, 44);
		contentPane.add(lblNewLabel);
		
		
		
		//顯示賽程按鈕
		JButton btnNewButton = new JButton(new ImageIcon("BUTTON1_看賽程.jpg"));
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollPane_1.setViewportView(null);
				lblNewLabel.setText(sport[comboBox.getSelectedIndex()]+"的賽程表");
				for (int index = DTM.getRowCount()-1; index >= 0; index--) {
					DTM.removeRow(index);
		        }
				
				try{
					 Workbook workbook = Workbook.getWorkbook(new File("賽程表.xls"));
					 Sheet sheet = workbook.getSheet(comboBox.getSelectedIndex());
					 int temp=sheet.getRows()-1;
					 for(int i=0;i<temp;i++){
						 DTM.addRow(new Object[]{sheet.getCell(0,i+1).getContents(),
						                         sheet.getCell(1,i+1).getContents(),
						                         sheet.getCell(2,i+1).getContents(),
						                         sheet.getCell(3,i+1).getContents(),
						                         sheet.getCell(4,i+1).getContents()});
					 }
					 ArrayList<String> dataTable = new ArrayList<String>();
					 ArrayList<String> dataEquipment = new ArrayList<String>();
					 ArrayList<String> dataEquipmentCount = new ArrayList<String>();
					 
					 for(int i=0;i<3;i++){
						 dataTable.add(s[i]);
					 }
					 
					 workbook = Workbook.getWorkbook(new File("系統資料.xls"));
					 sheet = workbook.getSheet(4);
					 temp=sheet.getRows()-1;
					 for(int i=0;i<temp;i++){
						 if(sport[comboBox.getSelectedIndex()].equals(sheet.getCell(1,i+1).getContents())){
							 if(i==0){
								 dataTable.add("設備");
								 dataEquipment.add(sheet.getCell(0,i+1).getContents());
								 dataEquipmentCount.add(sheet.getCell(2,i+1).getContents());
							 }
							 else{
								 dataTable.add("");
								 dataEquipment.add(sheet.getCell(0,i+1).getContents());
								 dataEquipmentCount.add(sheet.getCell(2,i+1).getContents());
							 }
						 }
					 }
				     //DTM2.setColumnIdentifiers(s2);
					 getPlayer(sport,(DTM.getRowCount()*2));
				
					 String s2[]={"","比賽資料","","選手資料","選手資料"};
					 if(dataTable.size()<6){
						 String s3[][]=new String[6][5];
						 for(int i=0;i<6;i++){
							 if(i<dataTable.size()){
					    	 s3[i][0]=dataTable.get(i);
							 }
							 else{
								 s3[i][0]="";
							 }
							 
					    	 if(i>2&&i<dataTable.size()){
					    		 s3[i][1]=(dataEquipment.get(i-3)+"*"+Integer.toString( Integer.parseInt(dataEquipmentCount.get(i-3))/(playerCount/2)));
					    	 }
					    	 else if(i>=dataTable.size()){
					    		 s3[i][1]="";
							 }
					     }
					     DTM2.setDataVector(s3, s2);
					 }
					 else{
						 String s3[][]=new String[dataTable.size()][5];
						 for(int i=0;i<dataTable.size();i++){
								
					    	 s3[i][0]=dataTable.get(i);
					    	 if(i>2&&i<dataTable.size()){
					    		 s3[i][1]=(dataEquipment.get(i-3)+"*"+Integer.toString( Integer.parseInt(dataEquipmentCount.get(i-3))/(playerCount/2)));
					    	 }
					     }
					     DTM2.setDataVector(s3, s2);
					 }
				     
				     
				}catch (IOException | BiffException e1) {
			         e1.printStackTrace();
			   }
			}
		});
		btnNewButton.setBounds(506, 208, 163, 73);
		contentPane.add(btnNewButton);	
		
		JLabel label = new JLabel("詳細資料");
		label.setFont(new Font("微軟正黑體", Font.PLAIN, 34));
		label.setBounds(10, 386, 423, 44);
		contentPane.add(label);
	}

	public void getPlayer(String [] sport,int n){
		try {
			 Workbook workbook = Workbook.getWorkbook(new File("系統資料.xls"));
			 Sheet sheet = workbook.getSheet(2);
			 int temp=sheet.getRows()-1;
			 player=new String[n][6];
			 playerCount=n;
			 int k=0;
			 for(int i=0;i<temp;i++){
				 if(sheet.getCell(1,i+1).getContents().equals(sport[comboBox.getSelectedIndex()])){
					 for(int j=0;j<6;j++){
						 player[k][j]= sheet.getCell(j,i+1).getContents();
					 }
					 k++;
				 }
			 }
			 
		} catch (IOException | BiffException e) {
			e.printStackTrace();
		} 
		
	}
}
