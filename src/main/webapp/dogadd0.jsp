<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
    function check(form){
        with(form){
        	  if(pid.value == ""){
                  alert("認養表單ID不能為空");
                  return false;
              }
        	     	
            if(name.value == ""){
                alert("姓名名稱不能為空");
                return false;
            }
           
            if(phone.value == ""){
                alert("電話不能為空");
                return false;
            }
                 
            return true;
        }
    }
</script>



</head>
<body>

    <h1>添加認養表單</h1>
    <form action="main" method="get" onsubmit="return check(this);""/>
    
    <!--<form action="SaveServlet" method="get" onsubmit="return check(this);" >-->
    <!-- onsubmit="return check(this); 檢查輸入欄位空白null     --> 
     <!--會在head下增加 checkh段   this表示表單form --> 
        
        <table>
              
                 <td><input type="hidden" name="op" value="insert" /></td>
                
            <tr>
                <td>認養表單ID:</td>
                <td><input type="text" name="pid" value= "<c:out value='${user1.aid}'/>"  />  </td>
            </tr>
            <tr>
                <td>聯絡人:</td>
                <td><input type="text" name="name" value= "<c:out value='${user1.ad_name}'/>"  />  </td>
            
              <tr>
                <td>聯絡人電話:</td>
                <td><input type="text" name="phone" value= "<c:out value='${user1.ad_phone}'/>"  />  </td>
            </tr>
            
              <tr>
                <td>聯絡人信箱</td>
                <td><input type="text" name="mail" value= "<c:out value='${user1.ad_mail}'/>"  />  </td>
            </tr>
                        
            <tr>
                <td>寵物種類:</td>
                <td><input type="text" name="animaltype" value= "<c:out value='${user1.ad_animaltype}'/>"  />  </td>
            </tr>
            
            
               <tr>
                <td>想認養寵物年齡:</td>
                <td><input type="text" name="animaleage" value= "<c:out value='${user1.ad_amimalage}'/>"  />  </td>
             <tr>
                <td>填表單日期:</td>
                <td><input type="text" name="date" value= "<c:out value='${user1.ad_date}'/>"  />  </td>
            </tr>
           
            <tr>
                <td colspan="2"><input type="submit" value="新增" /></td>
            </tr>
        </table>
    </form>
    	<form   action="main" method="get"  >
      <td>輸入:</td>
		 <td><input type="text" name="pid1"/></td>
		 <td><input type="hidden" name="op" value="look1" /></td>
        <input type="submit" name="" value="單筆查詢" >
	</table>
	
	</form>
    
<a href="Animallist.jsp">查詢認養主選單</a>
<a href="index.jsp">回棄養主畫面</a>
<a href="Animallist.jsp">回認養主畫面</a>
    <br />
</body>
</html>