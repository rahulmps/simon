
package claimAutomation2;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class Anulacion{
	public  void anulcion() throws InterruptedException, IOException{
		
		
		List<String> fieldError = new ArrayList<String>();
		FileInputStream file = new FileInputStream(new File("C:\\Documents and Settings\\mann\\Desktop\\autom\\anul\\MyDataSheetss.xls"));
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		
		
		WebDriver wd = new FirefoxDriver();
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		wd.get("http://10.1.0.184:2005/SimonWeb/login.html");
		
		wd.findElement(By.name("Username")).clear();
		wd.findElement(By.name("Username")).sendKeys("52007029");
		wd.findElement(By.id("submit")).click();
		
		String subWindowHandler=null;
		Set<String> handles = wd.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while(iterator.hasNext()){
			subWindowHandler = iterator.next();
		}
		wd.switchTo().window(subWindowHandler);
		
		Thread.sleep(2000);
		
		new Select(wd.findElement(By.id("j_idt116:companyList"))).selectByIndex(0);
		
		wd.findElement(By.name("j_idt116:j_idt122")).click();
		
		for(int count=0 ; count<=sheet.getLastRowNum();++count ){
			HSSFRow row = sheet.getRow(count);
			
			try{
				
				WebElement we = wd.findElement(By.id("dynamicMenuform:j_id12_label"));
				Actions action=new Actions(wd);
				action.moveToElement(we).perform();
				
				Thread.sleep(2000);
				
				WebElement we1 = wd.findElement(By.id("dynamicMenuform:j_id14"));
				//Actions action=new Actions(wd);
				action.moveToElement(we1).perform();
				
				Thread.sleep(2000);
				
		        WebElement we2 =wd.findElement(By.xpath(".//*[@id='dynamicMenuform:Anulacion_Expedientes_Test']"));
		        action.moveToElement(we2).click().perform();
		        Thread.sleep(2000);
				
		        String value = row.getCell(0).toString();
		        wd.findElement(By.id("searchForm:claimNumber")).sendKeys(value);
		        
		        Thread.sleep(3000);
		        wd.findElement(By.id("searchForm:j_idt492")).click();
		        
		        Thread.sleep(3000);
		        WebElement tableId = wd.findElement(By.id("searchForm:claimsList:tb"));
		        List<WebElement> rows = tableId.findElements(By.tagName("tr"));
		        //int id = rows.size();
		        
		        Iterator<WebElement> i = rows.iterator();
		        outerloop:
		        while(i.hasNext()) {
		        	 WebElement r=i.next();
		        	 List<WebElement> cols = r.findElements(By.tagName("td"));
		        	 Iterator<WebElement> j = cols.iterator();
		        	 int counter = 0 ;
		        	 while(j.hasNext()) {
		        		 
		        		 WebElement c=j.next();
		        		 ++counter;
		        		 String sg = c.getText();
		        		 System.out.print("C-"+counter+"-");
		        		 System.out.print(sg);
		        		 System.out.print("    |  ");
		        		 if(counter==13 && sg.equals("PENDIENTE")) { //OBJETADO PENDIENTE
		        			// WebElement co = j.next();
		        			System.out.println("Inside IF");
	                        r.click();
		        			break outerloop;
	                        //System.exit(0);
		        			 }
		        		
		        		 }
		        	 System.out.println();
		        	 
		        	
		        
		        }
		        
		      //searchForm:expedienteDataTable:tb
		        Thread.sleep(4000);
		        WebElement tableId1 = wd.findElement(By.id("searchForm:expedienteDataTable:tb"));
		        List<WebElement> rows1 = tableId1.findElements(By.tagName("tr"));
		        
		        Iterator<WebElement> ii= rows1.iterator();
		        outOfloop:
		        while(ii.hasNext()) {
		        	WebElement r1 = ii.next();
		        	List<WebElement> cols1 = r1.findElements(By.tagName("td"));
		        	Iterator<WebElement> jj = cols1.iterator();
		        	int ctr=0;
		        	while(jj.hasNext()) {
		        		WebElement cc=jj.next();
		        		++ctr;
		        		 String str=null;
		        		 Thread.sleep(2000);
		        		 str = cc.getText();
		        		 System.out.print("C-"+ctr+"-");
		        		 System.out.print(str);
		        		 System.out.print("    |  ");
		        		 if(ctr == 6 && str.equals("P - PENDIENTE")) {  
		        			System.out.println("Inside IF");
		        			for(int ct=7;ct<=13;++ct) {cc=jj.next();}
	                        //r1.findElement(By.xpath("//*[@src='/SimonWeb/resources/images/miicons/anul.gif']")).click();
		        			Thread.sleep(4000);
		        			cc.findElement(By.xpath("//*[@src='/SimonWeb/resources/images/miicons/anul.gif']")).click();
		        			 //r1.findElement(By.className("imageSize")).click();
	                         //r1.findElement(By.cssSelector("#searchForm:expedienteDataTable:0:j_idt574")).click();
	                       break outOfloop;
	                       //System.exit(0);
		        			 }
		        		 
		        	}
		        	
		        	
		        	
		        	
		        }
		        
		        
		        
		        
		        
		        //Thread.sleep(3000);
		        //wd.findElement(By.xpath(".//*[@id='searchForm:claimsList:0:col0']")).click();
		        
		        //Reopen 
		        Thread.sleep(3000);
		        //wd.findElement(By.xpath(".//*[@id='searchForm:expedienteDataTable:2:j_idt572']")).click();
		        //Thread.sleep(5000);
		        new Select(wd.findElement(By.id("expedienteConfirmacionForm:annulationCause"))).selectByIndex(2);
		        Thread.sleep(5000);
		        wd.findElement(By.xpath(".//*[@id='expedienteConfirmacionForm:j_idt1482']")).click();
		        
		        
		       
		        
		        //wd.findElement(By.id("expedienteConfirmacionForm:j_idt1482")).click();
		        
		        Thread.sleep(5000);
		        
		        wd.findElement(By.id("expedienteConfirmacionForm:j_idt1483")).click();
		        

		        Thread.sleep(5000);
		        
		        String subWindowHandler1=null;
		        
		        Set<String> handles1 = wd.getWindowHandles();
		        Iterator<String> iterator1 = handles1.iterator();
		        while(iterator1.hasNext()){
		        	subWindowHandler1=iterator1.next();
		        }
		        
		        wd.switchTo().window(subWindowHandler1);
		       
		        Thread.sleep(5000);
		        File screen = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
			    FileUtils.copyFile(screen, new File("C:\\Documents and Setting\\mann\\Desktop\\autom\\anul\\anul_screenshot\\screenshot_"+ value +".png"));
		       
		        wd.findElement(By.id("j_idt1517")).click();
		        fieldError.add("Anulacion claim No :"+value);
		        Thread.sleep(2000);
		        
				
				
				
			  }
		        
			catch(Exception e){
				String value = row.getCell(0).toString(); //row.getCell(0).toString();
	    		System.out.println(value);
	    		fieldError.add("Error in Anuling claim No :"+value);
	    		Thread.sleep(3000);
	    		File screenshot = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
	    		FileUtils.copyFile(screenshot, new File("C:\\Documents and Settings\\mann\\Desktop\\autom\\anul\\screenshot\\screenshot_"+ value +".png"));
	    		
	    		Thread.sleep(7000);
	    		
	    		wd.findElement(By.xpath(".//*[@src='/SimonWeb/resources/images/miicons/home.png']")).click();
	    		Thread.sleep(5000);
	    		//file.close();
	    		//wd.close();
					
			}
			
	
		}
		
		wd.close();
		file.close();
		FileOutputStream fos = new FileOutputStream("C:\\Documents and Settings\\mann/Desktop\\autom\\anul\\MyDataSheetresult.xls");
    	HSSFWorkbook wbk =  new HSSFWorkbook();
    	HSSFSheet spread =  wbk.createSheet("Result");
    	HSSFRow r;
    	HSSFCell c;
    	
    	for(int i=0; i< fieldError.size() ;i++){
    		r=spread.createRow(i);
    		c=r.createCell(0);
    		System.out.println("Print it "+fieldError.get(i));
    		c.setCellValue(fieldError.get(i).toString());
    		
    	}
    	wbk.write(fos);
    	fos.close();
 
	}
}



	

