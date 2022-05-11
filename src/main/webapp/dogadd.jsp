<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>寵物</title>

	<script type="text/javascript" >
	function check(form){
		with(form){
			if(abid.value == ""){
				alert("棄養表單ID不能空值");
				return false;
			}
			if(abname.value == ""){
				alert("聯絡人不能為空值");
				return false;
			
		}	if(abphone.value == ""){
			alert("電話欄位不能為空值");
			return false;
	
		}
			if(abemail.value == ""){
				alert==("信箱不能為空值");
				return false;
			
		}
			if(abdogname.value == ""){
				alert("狗名子欄位不可空");
				return false;
			
		}
			if(abaddress.value == ""){
				alert("所在地欄位不可空");
				return false;
			
		}	if(abtype.value == ""){
				alert("種類欄位不可空");
				return false;
		
	}		if(abage.value == ""){
				alert("年紀欄位不可空");
				return false;

}
			if(abdate.value == ""){
				alert("日期欄位不可空");
				return false;

}		return true;
		}
		
	}
		</script>
</head>
<body>

	<h1>添加棄養表單</h1>
	    <form action="main" method="post" onsubmit="return check(this);""/>
			<table>
		
		<tr>
              <td><input type="hidden" name="op" value="insertdog" /></td>
		</tr>
		
		<tr>
			<td>棄養表單ID:</td>
			<td><input type="text" name="abid" value= "<c:out value='${user.abid}'/>"  />  </td>
		</tr>
			<td>聯絡人姓名:</td>
			<td><input type="text" name="abname" value= "<c:out value='${user.abname}'/>" />  </td>   <!-- 錢號為運算值 -->
		<tr>
			<td>聯絡人電話:</td>
				<td><input type="text" name="abphone" value= "<c:out value='${user.abphone}'/>"  />  </td>
		</tr>
			<td>聯絡人信箱:</td>
			<td><input type="text" name="abemail"  value= "<c:out value='${user.abemail}'/>"  />  </td>
		<tr>
			<td>棄養寵物名:</td>
			<td><input type="text" name="abdogname" value= "<c:out value='${user.abdogname}'/>"  />  </td>
		</tr>
		<tr>
			<td>棄養寵物所在地:</td>
			<td><input type="text" name="abaddress" value= "<c:out value='${user.abaddress}'/>"  />  </td>
		</tr>
			
		<tr>
			<td>棄養寵物種類:</td>
			<td><input type="text" name="abtype" value= "<c:out value='${user.abtype}'/>"  />  </td>
		</tr>
			<td>棄養寵物年齡:</td>
			<td><input type="text" name="abage" value= "<c:out value='${user.abage}'/>"  />  </td>
		<tr>
			<td>填單日期:</td>
			<td><input type="text" name="abdate" value="<c:out value='${user.abdate}'/>"  />  </td>
		</tr>
           
            <tr>
                <td colspan="2"><input type="submit" value="保存資料" /></td>
            </tr>
        </table>
    </form>		
	<form   action="main" method="get"  >
      <td>輸入:</td>
		 <td><input type="text" name="abid1"/></td>
		 <td><input type="hidden" name="op" value="look" /></td>
        <input type="submit" name="" value="單筆查詢" >
</form>  
	
			
	
	</table>
	
	</form>

<a href="index.jsp">回棄養主畫面</a>
<a href="Animallist.jsp">回認養主畫面</a>


</body>
</html>