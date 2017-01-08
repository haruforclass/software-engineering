import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class Instructions extends JDialog {

	private JPanel contentPane2,imagePanel2;

	public Instructions() {
		setTitle("使用方法");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);			
		contentPane2 = new JPanel();
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane2.setLayout(null);
		setContentPane(contentPane2);
		
		ImageIcon img = new ImageIcon("input_Instructions1.jpg");
		JLabel background = new JLabel(img);
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		imagePanel2 = (JPanel) this.getContentPane();
		imagePanel2.setOpaque(false);
		getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		setSize(img.getIconWidth(),200);
		setLocationRelativeTo(this);  //設定視窗初始位置在螢幕中心
		setResizable(false); //設定JFrame視窗大小不可變
		setVisible(true); 
		
		JLabel label = new JLabel("1.若系統尚未輸入資料，請先點選輸入資料按鈕");
		label.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		label.setToolTipText("");
		label.setBounds(10, 10, 353, 31);
		contentPane2.add(label);
		
		JLabel label2 = new JLabel("2.點擊查看賽程，將會顯示一個賽程表的視窗");
		label2.setToolTipText("");
		label2.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		label2.setBounds(10, 51, 353, 31);
		contentPane2.add(label2);
		
		JLabel label3 = new JLabel("3.如有什麼意見提供，可點擊意見回應按鈕");
		label3.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		label3.setToolTipText("");
		label3.setBounds(10, 92, 353, 31);
		contentPane2.add(label3);
		
		JLabel label_2 = new JLabel("4.若使用者為運動員，將會出現個人賽程按鈕，選擇後可看到自己的賽程");
		label_2.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		label_2.setBounds(10, 133, 500, 38);
		label_2.setToolTipText("");
		contentPane2.add(label_2);
	}
	
	
	public Instructions(int a){
		setTitle("使用方法");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);			
		contentPane2 = new JPanel();
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane2.setLayout(null);
		setContentPane(contentPane2);
		
		ImageIcon img = new ImageIcon("input_Instructions1.jpg");
		JLabel background = new JLabel(img);
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		imagePanel2 = (JPanel) this.getContentPane();
		imagePanel2.setOpaque(false);
		getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		setSize(img.getIconWidth(),200);
		setLocationRelativeTo(this);  //設定視窗初始位置在螢幕中心
		setResizable(false); //設定JFrame視窗大小不可變
		setVisible(true); 
		
		JLabel label = new JLabel("1.按下新增資料按鈕，將會跳出視窗供輸入");
		label.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		label.setToolTipText("");
		label.setBounds(10, 10, 353, 31);
		contentPane2.add(label);
		
		JLabel label2 = new JLabel("2.點選表格內的資料，在按刪除資料，將可刪除該欄資料");
		label2.setToolTipText("");
		label2.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		label2.setBounds(10, 51, 500,31);
		contentPane2.add(label2);
		
		JLabel label3 = new JLabel("3.按下重新輸入按鈕，將會刪除所有已輸入的資料");
		label3.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		label3.setToolTipText("");
		label3.setBounds(10, 92, 353, 31);
		contentPane2.add(label3);
		
		JLabel label6 = new JLabel("注意事項：請確保每筆時間對應2名選手，且場地筆數必須和時間筆數相同");
		label6.setForeground(new Color(255, 0, 0));
		label6.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		label6.setToolTipText("");
		label6.setBounds(10, 133,600, 38);
		contentPane2.add(label6);
	}
	
	public Instructions(int a,int b){
		setTitle("使用方法");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);			
		contentPane2 = new JPanel();
		contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane2.setLayout(null);
		setContentPane(contentPane2);
		
		ImageIcon img = new ImageIcon("input_Instructions1.jpg");
		JLabel background = new JLabel(img);
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		imagePanel2 = (JPanel) this.getContentPane();
		imagePanel2.setOpaque(false);
		getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		setSize(img.getIconWidth(),160);
		setLocationRelativeTo(this);  //設定視窗初始位置在螢幕中心
		setResizable(false); //設定JFrame視窗大小不可變
		setVisible(true); 
		
		JLabel label = new JLabel("1.請先選擇要顯示的運動項目的賽程表");
		label.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		label.setToolTipText("");
		label.setBounds(10, 10, 353, 31);
		contentPane2.add(label);
		
		JLabel label2 = new JLabel("2.按下看賽程按鈕，即可得到該運動項目的賽程表");
		label2.setToolTipText("");
		label2.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		label2.setBounds(10, 51, 500,31);
		contentPane2.add(label2);
		
		JLabel label3 = new JLabel("3.雙擊賽程表的表格內的比賽，即可得到該欄比賽的詳細資料");
		label3.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		label3.setToolTipText("");
		label3.setBounds(10, 92, 500, 31);
		contentPane2.add(label3);
		
	}
}
