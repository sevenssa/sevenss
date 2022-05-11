package SqlCreat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class add20221 {

	public static void main(String[] args) {
		 ResultSet rs = null;
         ResultSetMetaData rsmeta = null;
        try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Dog","sa", "passw0rd");
			Statement stmt = con.createStatement();			
			System.out.print("成功連結資料庫");

 
            String sql;
       	
//         sql = "INSERT INTO Abdog " +
//        	   "VALUES ('B001','沈七七','0908776891','seven775207@gmail.com','小白','艾爾登','中型犬','5','20220214')";
            	 
//            	 stmt.executeUpdate(sql);
    	 
        sql = "INSERT INTO Tdog " +
        	        "VALUES ('A002','天涯明月刀','0908776891','seven775207@gmail.com','大型犬','5','20220214')";
            	 
          stmt.executeUpdate(sql);
            	 
        sql = "INSERT INTO Tdog " +
        	        "VALUES ('A003','漫畫王','0908776891','seven775207@gmail.com','小型犬','5','20220214')";
            	 
            stmt.executeUpdate(sql);
            	 
            
         sql = "INSERT INTO Tdog " +
	        "VALUES ('A004','張無忌','0908776891','seven775207@gmail.com','小型犬','5','20220214')";
    	 
    	 stmt.executeUpdate(sql);
    	 
         sql = "INSERT INTO Tdog " +
	        "VALUES ('A005','阿九','0908776891','seven775207@gmail.com','小型犬','5','20220214')";
    	 
    	 stmt.executeUpdate(sql);
    	 
         sql = "INSERT INTO Tdog " +
	        "VALUES ('A006','超級阿狗','0908776891','seven775207@gmail.com','小型犬','5','20220214')";
    	 
    	 stmt.executeUpdate(sql);
    	 
         sql = "INSERT INTO Tdog " +
	        "VALUES ('A007','楊柳','0908776891','seven775207@gmail.com','小型犬','5','20220214')";
    	 
    	 stmt.executeUpdate(sql);
    	 
         sql = "INSERT INTO Tdog " +
	        "VALUES ('ASB008','虎猛小編','0908776891','seven775207@gmail.com','中型犬','5','20220214')";
    	 
    	 stmt.executeUpdate(sql);
    	 
         sql = "INSERT INTO Tdog " +
	        "VALUES ('A009','守墓人','0908776891','seven775207@gmail.com','小型犬','5','20220214')";
    	 
    	 stmt.executeUpdate(sql);
    	 
    	 

       	 
       	 
       	 
       	 rs=stmt.executeQuery("select * from Tdog ");
       	 while(rs.next()) {
                System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getString(4)+rs.getString(5)+rs.getInt(6)+rs.getString(7)); // ID   줺 e
	
       	 
       	 }
       	
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