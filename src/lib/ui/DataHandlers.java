package lib.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataHandlers {

	public static String getDataFromProperties(String fileName, String sheetName,int rowIndex,int cellIndex) {
		
		// TODO Auto-generated method stub
		String data=null;
		try {
			File f= new File("./test-data"+"fileName+.xlsx");
			FileInputStream fis= new FileInputStream(f);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet st=wb.getSheet(sheetName);
			Row r=st.getRow(rowIndex);
			Cell c=r.createCell(cellIndex);
			data=c.toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
		public static void setDataToExcel(String fileName,String sheetName,int rowIndex,int cellIndex,String data)
		{
			try
			{
				File f=new File("./test-data/"+"fileName+.xlsx");
				FileInputStream fis= new FileInputStream(f);
				Workbook wb=WorkbookFactory.create(fis);
				Sheet st=wb.getSheet(sheetName);
				Row r=st.getRow(rowIndex);
				Cell c=r.createCell(cellIndex);
				FileOutputStream fos=new FileOutputStream(f);
				wb.write(fos);		
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}}
		public static String getDataFromProperties1(String fileName,String key)
		{
			String data=null;		
			try
			{
				File f=new File("./test-data/"+"fileName+Properties");	
				FileInputStream fis= new FileInputStream(f);
				Properties Prop=new Properties();
				Prop.load(fis);
				data=Prop.get(key).toString();				
			}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			return data;
		}
			public static void setDataToProperties(String fileName,String key,String value,String comment)
			{				
				try
				{
					File f=new File("./test-data/"+"fileName+Properties");	
					FileInputStream fis= new FileInputStream(f);
					Properties Prop=new Properties();
					Prop.load(fis);
					Prop.setProperty(key, value);
					FileOutputStream fos=new FileOutputStream(f);
					Prop.store(fos,comment);
				}
					catch(Exception e)
					{
						e.printStackTrace();
					}	
				}

}
