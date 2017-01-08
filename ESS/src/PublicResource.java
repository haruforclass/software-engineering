import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class PublicResource extends  JDialog {

	private JPanel contentPane2,imagePanel2;
	
	public PublicResource() {
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
		setSize(img.getIconWidth(),img.getIconHeight());
		getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));
		setLocationRelativeTo(this);  //設定視窗初始位置在螢幕中心
		setResizable(false); //設定JFrame視窗大小不可變
		setVisible(true); 
		
		JButton btnNewButton = new JButton(new ImageIcon("BUTTON1_現有資源.jpg"));
		btnNewButton.setBounds(98, 91, 131,57);
		contentPane2.add(btnNewButton);
		
		JButton button = new JButton(new ImageIcon("BUTTON1_總花費金額.jpg"));
		button.setBounds(98, 163, 131,57);
		contentPane2.add(button);
		
		JButton button_1 = new JButton(new ImageIcon("BUTTON1_贊助資源.jpg"));
		button_1.setBounds(98, 235, 131,57);
		contentPane2.add(button_1);
		
		JLabel lblNewLabel = new JLabel("公共資源");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 36));
		lblNewLabel.setBounds(98, 10, 297, 71);
		contentPane2.add(lblNewLabel);
		
       
	}
}
