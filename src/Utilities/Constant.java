package Utilities;

import java.io.File;

public class Constant {
	    public static final String URL = "https://www.amazon.com/";
		public static final String Path_TestData = "bin\\TestData\\";
		public static final String File_TestData = "TestData.xlsx";
		static File classpathRoot = new File(System.getProperty("user.dir"));
		static File IEDriver = new File(classpathRoot, "\\Drivers\\IEDriverServer.exe");
		static File ChromeDriver = new File(classpathRoot, "\\Drivers\\chromedriver.exe");
		public static String IEDriverPath = IEDriver.getAbsolutePath();
		public static String ChromeDriverPath = ChromeDriver.getAbsolutePath();
	
		//Test Data Sheet Columns
		public static final int Col_TestCaseName = 0;	
		public static final int Col_UserName =1 ; 
		public static final int Col_Password = 2;
		public static final int Col_Browser = 3;
		public static final int Col_Category=4 ;
		public static final int Col_SubCategory= 5;
		public static final int Col_ItemsCount = 6;
		public static final int Col_FullName = 8;
		public static final int Col_Adress1=9;
		public static final int Col_Adress2 = 10;
		public static final int Col_City = 11;
		public static final int Col_Region = 12;
		public static final int Col_ZIP = 13;
		public static final int Col_Country = 14;
		public static final int Col_PhoneNumber=15;
		public static final int Col_Result=16;
		
	}
