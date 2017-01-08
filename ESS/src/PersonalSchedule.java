import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonalSchedule extends JDialog {

	private JPanel contentPane2,imagePanel2;
	JTable table;

	public PersonalSchedule(String [] sport,String user) {
		    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);			
			contentPane2 = new JPanel();
			contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane2.setLayout(null);
			setContentPane(contentPane2);
			
			ImageIcon img = new ImageIcon("input_PersonalSchedule.jpg");
			JLabel background = new JLabel(img);
			background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
			imagePanel2 = (JPanel) this.getContentPane();
			imagePanel2.setOpaque(false);
			getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
			setSize(img.getIconWidth(),img.getIconHeight());
			setLocationRelativeTo(this);  //設定視窗初始位置在螢幕中心
			setResizable(false); //設定JFrame視窗大小不可變
			setVisible(true); 
			
			//建立一個JScrollPane給table用
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 82, 486, 299);
			contentPane2.add(scrollPane);
			
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
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 36));
			lblNewLabel.setBounds(10, 10, 443, 62);
			contentPane2.add(lblNewLabel);
			lblNewLabel.setText(user+" 的個人賽程表");
			
			
			//按鈕
			JButton btnNewButton = new JButton(new ImageIcon("BUTTON1_確認.JPG"));
			btnNewButton.addActionListener(new ActionListener() {
		    	  public void actionPerformed(ActionEvent e) {   	     
		    	    	setVisible(false);  	
		    	        dispose();    
		    	  }
		       });
			btnNewButton.setBounds(200, 401, 100, 48);
			contentPane2.add(btnNewButton);
			try{
				 Workbook workbook = Workbook.getWorkbook(new File("賽程表.xls"));
				 //讀比賽項目資料
				 for(int i=0;i<sport.length;i++){
					 Sheet sheet = workbook.getSheet(i);
					 int temp=sheet.getRows()-1;//讀出文件有幾行
					 for(int j=0;j<temp;j++){
						 if(sheet.getCell(3,j+1).getContents().equals(user)||sheet.getCell(4,j+1).getContents().equals(user)){
							 DTM.addRow(new Object[]{sheet.getCell(0,j+1).getContents(),
									                 sheet.getCell(1,j+1).getContents(),
									                 sheet.getCell(2,j+1).getContents(),
									                 sheet.getCell(3,j+1).getContents(),
									                 sheet.getCell(4,j+1).getContents()});
						 }
					 }
				 }
				 

			 }catch (IOException | BiffException e1) {
		         e1.printStackTrace();
		   }
	        
	}
}
