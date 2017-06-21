<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="rj7.bean.*,java.util.*,rj7.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>推送详情</title>
<link href="http://static.tianyaui.com/global/ty/TY.css" rel="stylesheet" type="text/css" />
<link href="http://static.tianyaui.com/global/bbs/web/static/css/bbs_article_813b107.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" charset="utf-8" src="http://static.tianyaui.com/global/ty/TY.js"></script>
<script type="text/javascript" charset="utf-8" src="http://static.tianyaui.com/global/bbs/web/static/js/main_0008808.js"></script>
</head>
<body>
<% Push p = (Push)request.getAttribute("push");//获取推送内容
   List<Object> list = null;
   list=(ArrayList)request.getAttribute("pushcmt");//获取评论
%>
	<div id="top_nav_banner">
    <div id="top_nav_wrap">
        <div class="clearfix" id="top_nav"></div>
    </div>
	</div>

<div id="doc">
    <div id="bd" class="clearfix">
		<div id="post_head" class="atl-head">
			<h1 class="atl-title">
				<span class="s_title"><span style="font-weight:400;"><%=p.getHead()%></span></span><span id="q_button_170_25_w"></span>
			</h1>
        </div>
		<div class="atl-main">
			<div class="atl-item host-item">
				<div class="atl-content">
					<div class="atl-con-bd clearfix">
						<div class="bbs-content clearfix">
							<%=p.getContent() %>
						</div>
						
						<!-- 如果有图片则打印图片 -->
						<div class="bbs-content clearfix">
						<%
						if(p.getUrlpush()!=null){
							String[] pictureurl = p.getUrlpush().split(" ");
							for(int i=1;i<pictureurl.length;i++){
							out.println("<img src=' ");
							out.println(pictureurl[0]+pictureurl[i]);
							out.println(" ' style='width:250px; height:180px;float:left;margin:30px;' /> " );
							}
						}
						%>
						</div>
						
                        <div class="host-data">
							<span>发布人<%=p.getPid()%></span>&nbsp;&nbsp;&nbsp;<span>点赞量<%=p.getLikecnt()%></span>&nbsp;&nbsp;&nbsp;<span>评论量<%=p.getCmtcnt()%></span>&nbsp;&nbsp;&nbsp;
							<span>收藏量<%=p.getCltcnt() %></span>&nbsp;&nbsp;&nbsp;<span>浏览量<%=p.getBrowsecnt()%></span>&nbsp;&nbsp;&nbsp;<span>分享量<%=p.getShrecnt()%></span>
						</div>
						<br>
			            <div class="atl-reply" id="alt_reply">
							<a href="#" class="a-link acl-share">分享</a>
							<a href="#" class="a-link acl-share">收藏</a>
							<a href="#" class="a-link acl-share">点赞</a>
							<a href="#" class="a-link acl-share">转发</a>
			            </div>
						</div>	
				</div>	
			</div>	
		</div>	
		<!-- 循环打印用户评论以及用户间回复 -->
		<%if(list!=null){
			for(int i = 0; i<list.size();i++){
				//获取到评论内容
				ptcmt pt = (ptcmt)list.get(i);
				if(pt.getCmtdid()==null){
					out.print("<div>");
					out.print(pt.getCmtid());//评论用户id
					out.print("&nbsp&nbsp&nbsp");//空格
					out.print(pt.getCmtt());//评论时间
					out.print("<a href='#'>回复</a>");//回复用户评论
					out.print("<br>");//换行
					out.print(pt.getCmtctt());//评论内容
					out.print("<br></div>");//换行
					
				}
			}
		}
		%>	
				
		
		<!-- 用户对文章发表评论 -->	
		<div class="post-div clearfix">
			<div class="mb10"><span id="author_name_reply"></span> <span style="color:#999;">发表评论</span></div>
			<form action="#" >
			<div id="bbsPost">
				<textarea class="textAreaContainer" name="ctt"></textarea>
				<input type="hidden" name="pid" value="<%=p.getPid()%>"/><br>
                <button class="common-submitBtn" type="submit">发送</button>
			</div>
			</form>
       </div>
   </div>
</div>	
</body>
</html>