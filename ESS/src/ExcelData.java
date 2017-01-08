import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
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

public class ExcelData {
	
	int sportcount;
	int [] game;
	String [] sport;
	String [][]gameTime;
	String [][]gamePlayer;
	String [][]gameCourt;
	String [][]Player;
	
	public ExcelData(){
		 try{
			 Workbook workbook = Workbook.getWorkbook(new File("系統資料.xls"));
			 
			 //讀比賽項目資料
			 Sheet sheet = workbook.getSheet(0);
			 sportcount=sheet.getRows()-1;//讀出文件有幾行
		     sport=new String [sportcount];
		     for(int i=0;i<sportcount;i++){
		    	 sport[i]=sheet.getCell(0,i+1).getContents();
		     }
		     
		     //計算總場次
		     game=new int [sportcount];
		     sheet = workbook.getSheet(1);
		     int temp2 =sheet.getRows()-1;//讀出文件有幾行
		     for(int i=0;i<temp2;i++){
		    	 for(int j=0;j<sportcount;j++){
		    		 if(sheet.getCell(1,i+1).getContents()==sport[j]){
		    			 game[j]++;
		    			 break;
		    		 }
		    	 }
		     }
		     
		     //讀時間資料
		     gameTime=new String[sportcount][];
		     for(int i=0;i<sportcount;i++){
		    	 gameTime[i]=new String[game[i]];
		     }
		     int [] count=new int [sportcount];
		     
		     for(int i=0;i<temp2;i++){
		    	 for(int j=0;j<sportcount;j++){
		    		 if(sheet.getCell(1,i+1).getContents()==sport[j]){
		    			 gameTime[j][count[j]]=sheet.getCell(0,i+1).getContents();
		    			 count[j]++;
		    			 break;
		    		 }
		    	 }	
		     }
		     
		     
		     //讀選手資料
		     sheet = workbook.getSheet(2);
		     temp2 =sheet.getRows()-1;//讀出文件有幾行
		     
		     gamePlayer=new String[sportcount][];
		     for(int i=0;i<sportcount;i++){
		    	 gamePlayer[i]=new String[game[i]*2];
		     }
		     int [] count2=new int [sportcount];
		     
		     for(int i=0;i<temp2;i++){
		    	 for(int j=0;j<sportcount;j++){
		    		 if(sheet.getCell(1,i+1).getContents()==sport[j]){
		    			 gamePlayer[j][count2[j]]=sheet.getCell(0,i+1).getContents();
		    			 count2[j]++;
		    			 break;
		    		 }
		    	 }	
		     }
		     
		     
		     //讀場地資料
		     sheet = workbook.getSheet(3);
		     temp2 =sheet.getRows()-1;//讀出文件有幾行
		     
		     gameCourt=new String[sportcount][];
		     for(int i=0;i<sportcount;i++){
		    	 gameCourt[i]=new String[game[i]];
		     }
		     int [] count3=new int [sportcount];
		     
		     for(int i=0;i<temp2;i++){
		    	 for(int j=0;j<sportcount;j++){
		    		 if(sheet.getCell(1,i+1).getContents()==sport[j]){//Integer.parseInt(cell3.getContents())
		    			 
		    			 for(int k=0;k<Integer.parseInt(sheet.getCell(2,i+1).getContents());k++){
		    				 gameCourt[j][count3[j]]=(sheet.getCell(0,i+1).getContents()+(char)(k+65));
		    				 count3[j]++;
		    			 }
		    			 break;
		    		 }
		    	 }	
		     }
		     
		  }catch (IOException | BiffException e) {
		         e.printStackTrace();
		   }
	}
	
	public void sort(){
		try{
			WritableWorkbook workbook =Workbook.createWorkbook(new File("賽程表.xls")); 
		    for(int i=0;i<sportcount;i++){
			   int n=game[i];
			   
			   //取亂數
			   int [] randomNO=new int [2*n];
			   int [] randomNO2=new int [n];
			   int [][]game=new int [2][n];
			   int []game_court=new int [n];
			   //取選手亂數
			   for(int j=0;j<2;j++){
				  for(int k=0;k<n;k++){
					 int x=(int)(Math.random()*(2*n));
					 if(randomNO[x]==0){
					 	game[j][k]=x;
						randomNO[x]=1;
					 }
					 else{
						k--;
						continue;
					 }
				  }
			   } 
			   for(int j=0;j<n;j++){
				  int x=(int)(Math.random()*n);
				  if(randomNO2[x]==0){
					 game_court[j]=x;
					 randomNO2[x]=1;
				  }
			      else{
				     j--;
				     continue;
			      }
			   }
			
				WritableSheet sheet = workbook.createSheet(sport[i],i);
				//調整寬度
				for(int j=2;j<5;j++){
					sheet.setColumnView(j, 40);
		        }
				sheet.setColumnView(0, 30);
				sheet.setColumnView(1, 25);
		 
		         
				//字體部分
				WritableFont myFont = new WritableFont(WritableFont.createFont("標楷體"), 14);        
	            myFont.setColour(Colour.BLACK);            
	            WritableCellFormat cellFormat = new WritableCellFormat();
	            WritableCellFormat cellFormat2 = new WritableCellFormat();
					 
	            cellFormat.setFont(myFont); // 指定字型
	            //cellFormat.setBackground(Colour.LIGHT_BLUE); // 背景顏色
	            cellFormat.setAlignment(Alignment.CENTRE); // 對齊方式
	            cellFormat2.setFont(myFont); // 指定字型
	            cellFormat2.setBackground(Colour.ROSE); // 背景顏色
	            cellFormat2.setAlignment(Alignment.CENTRE); // 對齊方式
	              
	               
				 //匯出至excel
				     //匯出標題
				 Label title0 = new Label(0,0,"比賽時間",cellFormat2);
				 Label title1 = new Label(1,0,"運動項目",cellFormat2);
				 Label title2 = new Label(2,0,"比賽場地",cellFormat2);
			     Label title3 = new Label(3,0,"參賽者",cellFormat2);
				 Label title4 = new Label(4,0,"參賽者",cellFormat2);
				 sheet.addCell(title0);
				 sheet.addCell(title1);
				 sheet.addCell(title2);
				 sheet.addCell(title3);
				 sheet.addCell(title4);
				
				 for(int j=1;j<n+1;j++){

					 Label label0 = new Label(0,j,gameTime[i][j-1],cellFormat);
					 Label label1 = new Label(1,j,sport[i],cellFormat);
					 Label label2 = new Label(2,j,gameCourt[i][game_court[j-1]],cellFormat);
					 Label label3 = new Label(3,j,gamePlayer[i][game[0][j-1]],cellFormat);
					 Label label4 = new Label(4,j,gamePlayer[i][game[1][j-1]],cellFormat);
					 sheet.addCell(label0);
					 sheet.addCell(label1);
					 sheet.addCell(label2);
					 sheet.addCell(label3); 
					 sheet.addCell(label4); 
				 }
		      }
				 workbook.write();
				 workbook.close();
		  }catch (IOException | WriteException e1) {
					e1.printStackTrace();
		   } 
	}
	
	
}
