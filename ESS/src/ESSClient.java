import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Button;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import javax.swing.Icon;

public class ESSClient extends JFrame {

	private JPanel contentPane;
	private JPanel imagePanel;
	//Create the frame.	 
	public ESSClient(String user,String user2) {
		setTitle("ESS Schedule events");
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		ImageIcon img = new ImageIcon("EssClient.jpg");
		JLabel background = new JLabel(img);
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		
		imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
        getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		
		setSize(img.getIconWidth(),img.getIconHeight());
		setLocationRelativeTo(this);  //設定視窗初始位置在螢幕中心
		setResizable(false); //設定JFrame視窗大小不可變
		setVisible(true);
		
		
		
		
		
		JButton btnNewButton_1 = new JButton(new ImageIcon("question.jpg"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Instructions notice=new Instructions();
			}
		});
		btnNewButton_1.setBounds(348, 360, 60, 57);
		contentPane.add(btnNewButton_1);
		
		
		JButton button_3 = new JButton(new ImageIcon("Home_mark.jpg"));
		button_3.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		    	setVisible(false);
		    	new EnterFrame();
		    }
	    });
		button_3.setBounds(241, 360, 60, 57);
		contentPane.add(button_3);
		
		
		//輸入的按鈕
		JButton Input = new JButton(new ImageIcon("BUTTON1_輸入資料.jpg"));
		Input.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		Input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InputSport in =new InputSport();
				
			}
		});
		Input.setBackground(new Color(255, 222, 173));
		Input.setBounds(170, 222, 131, 57);
		if(user2.equals("管理員")){
			contentPane.add(Input);
		}
		
		
		JButton btnNewButton = new JButton(new ImageIcon("BUTTON1_查看賽程.jpg"));
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> data = new ArrayList<String>();
				try{
					 Workbook workbook = Workbook.getWorkbook(new File("系統資料.xls"));
					 //讀比賽項目資料
					 Sheet sheet = workbook.getSheet(0);
					 int temp=sheet.getRows()-1;//讀出文件有幾行
					 String [] sport=new String [temp];
					 for(int i=0;i<temp;i++){
						 data.add(sheet.getCell(0,i+1).getContents());
					 }
				 }catch (IOException | BiffException e1) {
			         e1.printStackTrace();
			   }
				int temp=data.size();
				String [] sport=new String [temp];
				for(int i=0;i<temp;i++){
					 sport[i]=data.get(i);
				 }
				
				ScheduleWindows in =new ScheduleWindows(sport);
			}
		});
		btnNewButton.setBackground(new Color(255, 222, 173));
		btnNewButton.setBounds(170, 155, 131, 57);
		contentPane.add(btnNewButton);		
				
		JButton button = new JButton(new ImageIcon("BUTTON1_公共資源.jpg"));
		button.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PublicResource();
			}
		});
		button.setBounds(348, 155, 131, 57);
		contentPane.add(button);
		
		JButton button_2 = new JButton(new ImageIcon("BUTTON1_意見反應.jpg"));
		button_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Opinion();
			}
		});
		button_2.setBackground(new Color(255, 222, 173));
		button_2.setBounds(170, 222, 131, 57);
		if(!user2.equals("管理員")){
			contentPane.add(button_2);
		}

		JButton button_1 = new JButton(new ImageIcon("BUTTON1_個人賽程.jpg"));
		button_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> data = new ArrayList<String>();
				try{
					 Workbook workbook = Workbook.getWorkbook(new File("系統資料.xls"));
					 //讀比賽項目資料
					 Sheet sheet = workbook.getSheet(0);
					 int temp=sheet.getRows()-1;//讀出文件有幾行
					 String [] sport=new String [temp];
					 for(int i=0;i<temp;i++){
						 data.add(sheet.getCell(0,i+1).getContents());
					 }
				 }catch (IOException | BiffException e1) {
			         e1.printStackTrace();
			   }
				int temp=data.size();
				String [] sport=new String [temp];
				for(int i=0;i<temp;i++){
					 sport[i]=data.get(i);
				 }
				PersonalSchedule in =new PersonalSchedule(sport,user);
			}
		});
		button_1.setBackground(new Color(255, 222, 173));
		button_1.setBounds(348, 222, 131, 57);
		if(user2.equals("運動員")){
			contentPane.add(button_1);
		}
		
		
		JLabel label = new JLabel("功能選單");
		label.setFont(new Font("微軟正黑體", Font.BOLD, 36));
		label.setBounds(256, 51, 223, 74);
		contentPane.add(label);

	}
}
