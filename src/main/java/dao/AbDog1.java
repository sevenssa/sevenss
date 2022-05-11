package dao;
import java.util.*;

 
import dao.AbDog1;
import dao.AbDog;
 

import java.sql.*;
public class AbDog1 {
	  
	public static Connection getConnection() {
	    Connection con  = null;
	    try {
 			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
 			con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Dog","sa","passw0rd");
 			Statement st = con.createStatement();			
 			System.out.print("成功連結資料庫");		
//	    	Class.forName("com.mysql.jdbc.Driver");
//		     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/text", "root", "seven7777");
//		     Statement st = con.createStatement(); 
//	        System.out.println("連接資料庫成功");
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    return con;
	}
	//--------AAbdog-----------------------------
			
	public static int save(AbDog abdog) {
		int status=0;
		try {
			Connection con =AbDog1.getConnection();
			String sql = "INSERT INTO Abdog (abid,abname,abphone,abemail,abdogname,abaddress,abtype,abage,abdate) Values(?,?,?,?,?,?,?,?,?)";
	        PreparedStatement ps = con.prepareStatement(sql);
	        
	        ps.setString(1, abdog.getAbid());
	        ps.setString(2, abdog.getAbname());
	        ps.setString(3, abdog.getAbphone());
	        ps.setString(4, abdog.getAbemail());
	        ps.setString(5, abdog.getAbdogname());
	        ps.setString(6, abdog.getAbaddress());
	        ps.setString(7, abdog.getAbtype());
	        ps.setInt(8, abdog.getAbage());
	        ps.setString(9, abdog.getAbdate());

	        status = ps.executeUpdate();
			con.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	//-------------------------------------
	
	

	//-------TDog ADD------------------------------
	
		public static int saveADD(DOG dog) { 
		    int status = 0;
		    try {
		        Connection con = AbDog1.getConnection();//
		        String sql = "INSERT INTO  TDog  (pid,name,phone,mail,animaltype,animaleage,date) values (?,?,?,?,?,?,?)";

		        PreparedStatement ps = con.prepareStatement(sql);
		       

		        ps.setString(1, dog.getAid());
		        ps.setString(2, dog.getAd_name());
		        ps.setString(3, dog.getAd_phone());
		        ps.setString(4, dog.getAd_mail());
		        ps.setString(5, dog.getAd_animaltype()); 
		        ps.setInt(6, dog.getAd_amimalage());
		        ps.setString(7, dog.getAd_date());
		       // 
		        status = ps.executeUpdate();//RETURN CODE  status  

		        con.close();
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }

		    return status;
		}
		
	
	//-----------abdog更正
	
	public static int update(AbDog abdog) {
		int status=0;
			try {
				Connection con =AbDog1.getConnection();
				String sql = "UPDATE Abdog SET abname=?, abphone=?,abemail=?,abdogname=?,abaddress=?,abtype=?, abage=?, abdate=? where abid=?";
										 
			      
			        PreparedStatement ps = con.prepareStatement(sql);
			        ps.setString(1, abdog.getAbname());//用 e. 即有選項 getAd_name()
			        ps.setString(2, abdog.getAbphone());//用 e. 即有選項 .getAd_phone()
			        ps.setString(3, abdog.getAbphone());// 
			        ps.setString(4, abdog.getAbdogname());
			        ps.setString(5, abdog.getAbaddress());
			        ps.setString(6, abdog.getAbtype());
			        ps.setInt(7, abdog.getAbage());
			        ps.setString(8, abdog.getAbdate());	        
			        
			        		        
			        ps.setString(9, abdog.getAbid());
			   	    System.out.println(" 信 "+ abdog.getAbname());
			   	    System.out.println(abdog.getAbphone()); 
			   	    System.out.println(" ididididi "+ abdog.getAbid());
			   	    
			        status = ps.executeUpdate();

			        con.close();
					        
	}catch (Exception ex) {
        ex.printStackTrace();
	}	return status;
	
	}
	
	
//UPDATE Tdog	

	public static int updatedog(DOG dog) {
		int status=0;
			try {
	        Connection con = AbDog1.getConnection();
	        String sql = "UPDATE  TDog  SET name=?,  phone=?,mail=? where pid=?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, dog.getAd_name());//
	        ps.setString(2, dog.getAd_phone());//
	        ps.setString(3, dog.getAd_mail());// 
	        
	        ps.setString(4, dog.getAid());

	        status = ps.executeUpdate();

	        con.close();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }

	    return status;
	}	
	
		
	
	//--------del abdog-----------------------------
	
	public static int del(String abid) {
		int status=0;
		try
		{		Connection con =AbDog1.getConnection();
        String sql = "DELETE FROM Abdog WHERE abid=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, abid);
        status = ps.executeUpdate();

        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return status;
}
	
	
	
	
	
	
	//---------delt TDOG----------------------------
	
		public static int deldog(String id) {
			int status=0;
			try
			{		Connection con =AbDog1.getConnection();
	        String sql = "DELETE FROM TDog WHERE pid=?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, id);
	        status = ps.executeUpdate();

	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return status;
	}
	
	
	
	//-------------------------------------

	
	public static AbDog getById(String abid) {
		AbDog abdog = new AbDog();
		
		try {
			
       	Connection con = AbDog1.getConnection();
        String sql = "SELECT * FROM Abdog WHERE abid=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, abid);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
        	abdog.setAbid(rs.getString("abid")) ;
        	abdog.setAbname(rs.getString("abname"));
        	abdog.setAbphone(rs.getString("abphone"));
        	abdog.setAbemail(rs.getString("abemail"));
        	abdog.setAbdogname(rs.getString("abdogname"));
        	abdog.setAbaddress(rs.getString("abaddress"));
        	abdog.setAbtype(rs.getString("abtype"));
        	abdog.setAbage(rs.getInt("abage"));
        	abdog.setAbdate(rs.getString("abdate"));
        
            
        }
        con.close();
    }	 catch (Exception ex) {
        ex.printStackTrace();
    }

    return abdog;
}
	
	//-------------------------------------

	
	public static DOG getById1(String id) {
		DOG dog = new DOG();
		
		try {
			
       	Connection con = AbDog1.getConnection();
        String sql = "SELECT * FROM Tdog WHERE pid=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
        	dog.setAid(rs.getString("pid")) ;
        	dog.setAd_name(rs.getString("name"));
        	dog.setAd_phone(rs.getString("phone"));
            dog.setAd_mail(rs.getString("mail"));
            dog.setAd_animaltype(rs.getString("animaltype"));
            dog.setAd_amimalage(rs.getInt("animaleage"));
            dog.setAd_date(rs.getString("date"));
        
            
        }
        con.close();
    }	 catch (Exception ex) {
        ex.printStackTrace();
    }

    return dog;
}
	//READ  ALL         ABDOG LIST
	public static List<AbDog> getAll() {
		   List<AbDog> list = new ArrayList<AbDog>();		
		try {
			
			Connection con = AbDog1.getConnection();
	        String sql = "SELECT * FROM Abdog  ORDER BY Abid DESC";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	        	AbDog abdog = new AbDog();
	        	abdog.setAbid(rs.getString("abid")) ;
	        	abdog.setAbname(rs.getString("abname"));
	        	abdog.setAbphone(rs.getString("abphone"));
	        	abdog.setAbemail(rs.getString("abemail"));
	        	abdog.setAbdogname(rs.getString("abdogname"));
	        	abdog.setAbaddress(rs.getString("abaddress"));
	        	abdog.setAbtype(rs.getString("abtype"));
	        	abdog.setAbage(rs.getInt("abage"));
	        	abdog.setAbdate(rs.getString("abdate"));
	              list.add(abdog);
	        }
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	
	//READ  ALL         TDOG LIST
	
	public static List<DOG> getAlldog() {
		   List<DOG> list = new ArrayList<DOG>();		
		try {
			
			Connection con = AbDog1.getConnection();
	        String sql = "SELECT * FROM TDog  ORDER BY pid DESC";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	        	 
	              
	              
	              DOG dog  = new DOG();
	
	              dog.setAid(rs.getString("pid")) ;
	              dog.setAd_name(rs.getString("name"));
	              dog.setAd_phone(rs.getString("phone"));
	              dog.setAd_mail(rs.getString("mail"));
	              dog.setAd_animaltype(rs.getString("animaltype"));
	              dog.setAd_amimalage(rs.getInt("animaleage"));
	              dog.setAd_date(rs.getString("date"));
	        
	           
	               list.add(dog);
	          
	            
	              
	        }
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	
	
	
	}