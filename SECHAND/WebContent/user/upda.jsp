﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>修改用户信息</title>
<link rel=stylesheet href="../css/demo.css" type="text/css">
</head>
<script src='../common/date/date.js'></script>
<script>
	function check() {
		var nickname = document.getElementsByName("UserNickname")[0].value;
		if (nickname == "") {
			alert("亲！昵称不能为空哟！！");
			return;
		}
		//提交页面
		document.getElementsByName("frmAction")[0].submit();

	}

	function back() {
		//使用location.href跳转到list.jsp页面
		//location.href("/linguser/ListUserServlet");
	}
</Script>
<body topmargin="10" leftmargin="10">
	<form name="frmAction" method="post" action="/SECHAND/AddUserService">
		<table width="95%" border="0" cellpadding="3" cellspacing="1"
			class="toolBar" align="center">
			<tr align=left class="colom">
				<td colspan="2">修改个人信息</td>
			</tr>

			<tr class=even>
				<td width='100' align='right' nowrap>昵称:&nbsp;</td>
				<td bgcolor='#ffffff'><input type="text" name="UserNickname"><font
					color=#ff0000>*</font></td>
			</tr>
			<tr class=even>
				<td width='100' align='right' nowrap>学校名:&nbsp;</td>
				<td bgcolor='#ffffff'><input type="text" name="UserSchool_id"><font
					color=#ff0000>*</font></td>
			</tr>
			<tr class=even>
				<td width='100' align='right' nowrap>性别:&nbsp;</td>
				<td bgcolor='#ffffff'><input type="radio" checked value="1"
					name="UserSex">男 <input type="radio" value="0"
					name="UserSex">女 <input type="radio" value=""
					name="UserSex">秘密哟</td>
			</tr>
			<tr class=even>
				<td width='100' align='right' nowrap>电话:&nbsp;</td>
				<td bgcolor='#ffffff'><input type="text" name="UserPhone"><font
					color=#ff0000>*</font></td>
			</tr>
			<tr class=even>
				<td width='100' align='right' nowrap>邮箱:&nbsp;</td>
				<td bgcolor='#ffffff'><input type="text" name="UserEmail"><font
					color=#ff0000>*</font></td>
			</tr>

			<tr class=even>
				<td height=35 colspan="2"><input class="input" type="button"
					value="确定" onclick="check()"> <input class="input"
					type="button" value="返回" onclick="javascript:back()"></td>
			</tr>
		</table>
		<input type="hidden" name="urlid" value="update">
	</form>
</body>
</html>
