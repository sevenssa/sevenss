package SqlCreat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
public class CreatSql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//			Connection con =AbDog1.getConnection();
 			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Dog","sa","passw0rd");
 			Statement st = con.createStatement();			
 			System.out.print("成功連結資料庫");		

            String sql="CREATE TABLE Abdog("
					    + "abid VARCHAR(45) NOT NULL,"//表單ID
        		        + "abname varchar(50)," //聯絡人
	            		+ "abphone varchar(50)," //聯絡人電話
	                    + "abemail varchar(50)," //聯絡人信箱	         
	                    + "abdogname varchar(50),"//
	                    + "abaddress varchar(50),"//            
	                    + "abtype varchar(50),"//                   
	                    + "abage INT ,"//              
	                    + "abdate DATETIme ,"//
	            		+ "PRIMARY KEY (abid))";//
			

	st.executeUpdate(sql);
	
	System.out.println("Created table in given database...");
	 con.close();      

        }

              catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

              catch (SQLException e) {

            e.printStackTrace();

        }

}
}


 

