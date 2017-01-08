import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class EnterFrame extends JFrame {

	private JPanel contentPane;
	private JPanel imagePanel = null;

	public static void main(String[] args) {
		EnterFrame frame = new EnterFrame();		
	}
	public EnterFrame() {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		ImageIcon img = new ImageIcon("enterFrame.jpg");
		JLabel background = new JLabel(img);
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		
		imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		
		setSize(img.getIconWidth(),img.getIconHeight());
		setLocationRelativeTo(this);
		setResizable(false); //設定JFrame視窗大小不可變
		setVisible(true);
		
		
		
		JLabel lblNewLabel = new JLabel("請選擇進入系統身分");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel.setBounds(401, 40, 163, 25);
		contentPane.add(lblNewLabel);
		
		
		//button按鈕按鈕按鈕
		JButton button_1 = new JButton(new ImageIcon("BUTTON1_公眾.jpg"));
		button_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		button_1.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {   
	    		    new ESSClient(null,"GUEST");
	    	    	setVisible(false);  	
	    	        
	    	  }
	       });
		button_1.setBounds(429, 103, 126, 44);
		contentPane.add(button_1);
		
		JButton button = new JButton(new ImageIcon("BUTTON1_運動員.jpg"));
		button.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		button.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {  
	    		    new Login();  
	    	    	setVisible(false);  	    
	    	  }
	       });
		button.setBounds(429, 161, 126, 44);
		contentPane.add(button);
		
		
		JButton btnNewButton = new JButton(new ImageIcon("BUTTON1_管理員.jpg"));
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {   
	    		    new Login();  
	    	    	setVisible(false); 
	    	  }
	       });
		btnNewButton.setBounds(429, 219, 124, 44);
		contentPane.add(btnNewButton);
		
		JButton button_2 = new JButton(new ImageIcon("BUTTON2_EXIT.jpg"));
		button_2.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		button_2.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {   	     
	    	    	setVisible(false);  	
	    	        dispose();    
	    	  }
	       });
		button_2.setBounds(429, 291, 128, 64);
		contentPane.add(button_2);
	}

}
