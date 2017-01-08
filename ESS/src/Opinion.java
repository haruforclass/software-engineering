import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.DropMode;
import javax.swing.JEditorPane;

public class Opinion extends JDialog {

	private JPanel contentPane2,imagePanel2;
	private JTextField textField;

	public Opinion() {
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
		
		JLabel label = new JLabel("意見反映");
		label.setFont(new Font("微軟正黑體", Font.BOLD, 36));
		label.setBounds(95,0, 262, 84);
		contentPane2.add(label);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(21, 78, 310, 177);
		contentPane2.add(editorPane);
		//按鈕
		JButton btnNewButton = new JButton(new ImageIcon("BUTTON1_確認.JPG"));
		btnNewButton.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent e) {   
	    		 

	    			  BufferedWriter fw = null;

	    			  try {

	    			      File file = new File("意見反映.txt");
	    			      fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8")); // 指點編碼格式，以免讀取時中文字符異常
	    			      fw.append(editorPane.getText());
	    			      fw.newLine();
	    			      fw.append("-----------------------------------");
	    			      fw.flush(); // 全部寫入緩存中的內容
	    			  } catch (Exception e1) {
	    			      e1.printStackTrace();
	    			  } finally {
	    			      if (fw != null) {
	    			        try {
	    			        fw.close();
	    			        } catch (IOException e1) {
	    			          e1.printStackTrace();
	    			          }
	    			      }
	    			    }
	    			  
	    	    	setVisible(false);  	
	    	        dispose();    
	    	  }
	       });
		btnNewButton.setBounds(120, 282, 100, 48);
		contentPane2.add(btnNewButton);
		
		

	}
}
