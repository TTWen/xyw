<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>推送点赞</title>
<link href="css/pushlike1.css" rel="stylesheet" type="text/css">
</head>
<body>
${reback}
 <div class="like" style="margin-top:40px;margin-left:20px;">
 <div>
   <div style="margin-left:30px;margin-top:20px;"> 
	  <label for="点赞人id" margin-top=10px;>&nbsp;点赞人id&nbsp;&nbsp;</label>
	  <input type="" name="likename" size="20"  style="width:200px;height:30px;border:2px solid lightblue;" />
	 
   </div><br>   
  <div style="margin-left:30px;"> 
      <label for="被点赞人id:">被点赞人id</label>     
	  <input type="" name="likedname" size="20" style="width:200px;height:30px;border:2px solid lightblue;"/>
	  
   </div><br>    
    <div >       
	  <input type="submit" value="点赞" style="width:100px;margin-left:70px;" class="button1"/>
	        <a href="PushlikeServ?flag=pushlike_add"></a>  	
    </div>		
 </div>  	     
</div>
</body>
</html>