package SqlCreat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
public class CreatSql1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//			Connection con =AbDog1.getConnection();
 			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Dog","sa","passw0rd");
 			Statement st = con.createStatement();			
 			System.out.print("成功連結資料庫");		

            String sql="CREATE TABLE TDog("
					    + "pid VARCHAR(45) NOT NULL,"//表單ID
        		        + "name varchar(50)," //聯絡人
	            		+ "phone varchar(50)," //聯絡人電話
	                    + "mail varchar(50)," //聯絡人信箱	         
	                    + "animaltype varchar(50),"//
	                    + "animaleage INT ,"//              
	                    + "date DATETIme ,"//
	            		+ "PRIMARY KEY (pid))";//
			

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


 

