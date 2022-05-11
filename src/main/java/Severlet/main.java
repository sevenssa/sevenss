package Severlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import dao.*;
@WebServlet("/main")
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.getWriter().append("Served at: ").append(request.getContextPath());
        PrintWriter out =response.getWriter();
        
        String id = request.getParameter("id");
        String op = request.getParameter("op");
       
        
        //---delete-------abdog

        if (op.equalsIgnoreCase("del")){
   		    id=request.getParameter("id");

   		    AbDog1.del(id);
   		   response.sendRedirect("index.jsp");//?
         
   		}
       
        //---------- 
        
        
        //認養delete Tdog
        if (op.equalsIgnoreCase("deldog")){
        	AbDog1.deldog(id);
   		   response.sendRedirect("Animallist.jsp");//?
         
   		}
              
        
     //    ABdog uPDATE
        else if (op.equalsIgnoreCase("update"))
        {
        	
        	//String abid = request.getParameter("abid"); 因為更正id不更改不傳值null
        	String abid = request.getParameter("id"); 
        	String abname = request.getParameter("abname"); 
   	        String abphone = request.getParameter("abphone"); 
   	        String abemail = request.getParameter("abemail");
        	String abdogname = request.getParameter("abdogname"); 
   	        String abaddress = request.getParameter("abaddress"); 
   	        String abtype = request.getParameter("abtype");
        	String abage1 = request.getParameter("abage"); 
	        int abage = Integer.parseInt(abage1);
   	        String abdate = request.getParameter("abdate"); 
   	        AbDog abdog = new AbDog();       
	        abdog.setAbid(abid);
   	        abdog.setAbname(abname);
   	        abdog.setAbphone(abphone);
   	        abdog.setAbemail(abemail);
   	    	abdog.setAbdogname(abdogname);
   	    	abdog.setAbaddress(abaddress);
   	     	abdog.setAbtype(abtype);
   	     	abdog.setAbage(abage);
   	     	abdog.setAbdate(abdate);
   	        //執行DAO 回傳成功與否
	        //取得 介面DogDao..update(e)傳值 單一資料取出犀SQL 有條件 sid
	        //回傳    成功與 
   	     int status = AbDog1.update(abdog);
	        if (status > 0) {
	          
		            response.sendRedirect("index.jsp");
		        } else {
		            out.println("對不起更新信息失敗！");
		          }
        	        	
        	
        }
   
    //    認養 Tdog uPDATE
        else if (op.equalsIgnoreCase("updatedog"))
        {    String  sid = request.getParameter("id");
          
        	String name = request.getParameter("name"); //�request.暺����
   	        String phone = request.getParameter("phone"); //�request.暺����
   	        
   	        String mail1 = request.getParameter("email");//�request.暺����
   	        DOG dog = new DOG();       
	        dog.setAid(id);
	        
	        dog.setAd_name(name) ;
	       dog.setAd_phone(phone);
	       dog.setAd_mail(mail1);
	          
	         int status = AbDog1.updatedog(dog);
		        if (status > 0) {
		            response.sendRedirect("Animallist.jsp");
		        } else {
		            out.println("error");
		        }
        	
        	
        	
        }
        
       	
		
	 

      //認養新增
      //認養新增
        else if (op.equalsIgnoreCase("insert"))
        {
        	String pid = request.getParameter("pid");
  	        String name = request.getParameter("name");	        
  	        String phone = request.getParameter("phone");
  	        String mail = request.getParameter("mail");	        
  	        String animaltype = request.getParameter("animaltype");
  	        String animaleage1 = request.getParameter("animaleage");
  			int animaleage = Integer.parseInt(animaleage1);
  	        String  date = request.getParameter("date");
  	     
  	         DOG dog = new DOG();     
  	         
  	       dog.setAid(pid) ;          
  	       dog.setAd_name(name);
  	       dog.setAd_phone(phone);
  	       dog.setAd_mail(mail);
  	       dog.setAd_animaltype(animaltype);
  	       dog.setAd_amimalage(animaleage);
	       dog.setAd_date(date);
  	          	       
  	         // e.setPrice(Integer.parseInt(price));
  	         // e.setQty(Integer.parseInt(qty));
  	        	                     //��ea class 
  	        int status = AbDog1.saveADD(dog);//TeaDao class撖虫���
  	        if (status > 0) {
  	            out.print("<p>新増完成</p>");
  	            out.println("<a href='Animallist.jsp'>回首頁/a>");  
  	            //response.setCharacterEncoding("UTF-8");
  	            //request.getRequestDispatcher("index.html").include(request, response);
  	            } 
  	        else {
  	            out.println("新增錯誤");
  	             }
  	            out.close();
  	     }  
        
        
          else if (op.equalsIgnoreCase("look"))
          {
    		//取更正ID

  	        String abid1 =request.getParameter("abid1");
    		//回User 格式
    		//userDAO.selectUser(id)單筆資料查詢 
  	        
  	         AbDog lookdog =    dao.AbDog1.getById(abid1);
    		 
    		//回到 自己晝面
    		RequestDispatcher dispatcher = request.getRequestDispatcher("dogadd.jsp");
    		//把 使用者 寫進SESSION會話機中"user" 做為首頁判斷新增更正功能
    		//因首頁"user"    共用 空    判斷新增  有ID更正功能 
    		//bean Dog dog=(Dog) request.get("user","lookdog")
    		//list List<Dog> listdog = (Dog) List(Dog) getAttribute(user)
    		request.setAttribute("user", lookdog);
    		dispatcher.forward(request, response);

    	}
          else if (op.equalsIgnoreCase("look1"))
           {
       		//取更正ID

     	        String pid1 =request.getParameter("pid1");
       		//回User 格式
       		//userDAO.selectUser(id)單筆資料查詢 
     	        
     	         DOG lookdog1 =    dao.AbDog1.getById1(pid1);
       		 
       		//回到 自己晝面
       		RequestDispatcher dispatcher = request.getRequestDispatcher("dogadd0.jsp");
       		//把 使用者 寫進SESSION會話機中"user" 做為首頁判斷新增更正功能
       		//因首頁"user"    共用 空    判斷新增  有ID更正功能 
       		//bean Dog dog=(Dog) request.get("user","lookdog")
       		//list List<Dog> listdog = (Dog) List(Dog) getAttribute(user)
       		request.setAttribute("user1", lookdog1);
       		dispatcher.forward(request, response);

       	}

              
        
        	
        	
        }
               
   
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		doGet(request, response);
    		    response.setCharacterEncoding("UTF-8");
    	        response.setContentType("text/html;charset=UTF-8");
    	        request.setCharacterEncoding("UTF-8");
    	        PrintWriter out = response.getWriter();

    	        String abid =request.getParameter("abid");
    	        String abname=request.getParameter("abname");
    	        String abphone =request.getParameter("abphone");
    	        String abemail=request.getParameter("abemail");
    	        String abdogname =request.getParameter("abdogname");
    	        String abaddress=request.getParameter("abaddress");
    	        String abtype =request.getParameter("abtype");
    	        String abage1 =request.getParameter("abage");

    	        int abage =Integer.parseInt(abage1);
    	        String abdate=request.getParameter("abdate");
    	        String op = request.getParameter("op");
    	        if (op.equalsIgnoreCase("insertdog"))
    	        { AbDog abdog =new AbDog();
    	          abdog.setAbid(abid);
    	          abdog.setAbname(abname);
    	          abdog.setAbphone(abphone);
    	          abdog.setAbemail(abemail);
    	          abdog.setAbdogname(abdogname);
    	          abdog.setAbaddress(abaddress);
    	          abdog.setAbtype(abtype);
    	          abdog.setAbage(abage);
    	          abdog.setAbdate(abdate);
    	          int status = dao.AbDog1.save(abdog);
    	          
    	  	        if (status > 0) {
    	  	            out.print("<p>新増完成</p>");
    	  	            out.println("<a href='index.jsp'>回首頁/a>");  
    	  	            //response.setCharacterEncoding("UTF-8");
    	  	            //request.getRequestDispatcher("index.html").include(request, response);
    	  	            } 
    	  	        else {
    	  	            out.println("新增錯誤");
    	  	             }
    	  	            out.close();
    	  	     }  
    	        
    	        

    	          
    	          
    	          
    	          
    	          
    	          
    	          
    	        }
    	       
    	       
    }
