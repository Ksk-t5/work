<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <meta http-equiv="Content-Script-Type" content="text/javascript"/>
    <meta http-equiv="imagetoolbar" content="no"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <title>UserList画面</title>


<style type="text/css">
body{
  margin:0;
  padding:0;
  line-height:1.6;
  letter-spacing:1px;
  font-family:Verdana,Helvetica,sans-serif;
  font-size:12px;
  color:#333;
  background:#fff;
}

table{
  text-align:center;
  margin:0 auto;
}
/*========ecsite LAYOUT========*/
#top{
  width:780px;
  margin:30px auto;
  border:1px solid #333;
}

#header{
  width:100%;
  height:80px;
  background-color:black;
}

#main{
  width:100%;
  height:500px;
  text-align:center;
}

#footer{
  width:100%
  height:80px;
  background-color:black;
  clear:both;
}

#text-right{
  display;inline-block;
  text-align:right;
}

</style>
<script type="text/javascript">
function submitAction(url){
	$('form').attr('action',url);
	$('form').submit();
}
</script>
<script>
function UserListDeleteConfirm(){
	var res=confirm("すべてのユーザーを削除します。よろしいですか？");
	if(res==true){
		submitAction("UserListDeleteAction")
	}
	else{
		alert("削除をキャンセルしました。")
	}
	return res;
}
</script>
</head>
<body>
    <div id="header">
        <div id="pr">
        </div>
    </div>
    <div id="main">
        <div id="top">
            <p>UserList</p>
        </div>
        <div>
        <s:if test="UserInfoDTOList==null">
           <h3>ユーザー情報はありません。</h3>
        </s:if>
        <s:elseif test="message==null">
            <h3>ユーザー情報は以下になります。</h3>
            <table border="1">
            <tr>
                <%-- <th>id</th>--%>
                <th>ログインID</th>
                <th>パスワード</th>
                <th>ユーザー名</th>
                <th>登録日</th>
                <th>更新日</th>
            </tr>
        <s:iterator value="userInfoDTOList">
            <tr>
                <%-- <td><s:property value="id"/><td>--%>
                <td><s:property value="loginId"/></td>
                <td><s:property value="loginPass"/></td>
                <td><s:property value="userName"/></td>
                <td><s:property value="insert_date"/></td>
                <td><s:property value="updated_date"/></td>
            </tr>
        </s:iterator>
            </table>
        </s:elseif>
        <s:if test="message!=null">
            <h3><s:property value="message"/></h3>
        </s:if>
        <s:form>
           <%--  <input type="hidden" name="deleteFlg" value="1">--%>
            <s:submit value="削除"  onclick="UserListDeleteConfirm()"/>
        </s:form>
        <div id="text-right">
            <p>前画面へ戻る場合は<a href='<s:url action="GoAdminAction"/>'>こちら</a></p>
        </div>
        </div>
    </div>
    <div id="footer">
        <div id="pr">
        </div>
    </div>
</body>
</html>