<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>注册用户信息</title>
<link rel=stylesheet href="../css/demo.css" type="text/css">
</head>
<script src='../common/date/date.js'></script>
<script>
function check() {
	var name=document.getElementsByName("UserName")[0].value;
	if(name==""){
		alert("亲！！手机号不能为空哟！");
		return;
	}
		var password=document.getElementsByName("UserPassword")[0].value;
	if(password==""){
		alert("亲！！密码不能为空哟！");
		return;
	}
	var nickname=document.getElementsByName("UserNickname")[0].value;
	if(nickname==""){
		alert("亲！昵称不能为空哟！！");
		return;
		}
	//提交页面
	document.getElementsByName("frmAction")[0].submit();

}

function back() {
	//使用location.href跳转到list.jsp页面
	//location.href("/studentweb/ListStudentServlet");
}

</Script>
<body topmargin="10" leftmargin="10">
	<form name="frmAction" method="post" action="/linguser/AddUserService">
		<table width="95%" border="0" cellpadding="3" cellspacing="1"
			class="toolBar" align="center">
			<tr align=left class="colom">
				<td colspan="2">欢迎来到德莱联盟！(手机注册)</td>
			</tr>
			<tr class=even>
				<td width='100' align='right' nowrap>手机号:&nbsp;</td>
				<td bgcolor='#ffffff'><input type="text" name="UserName"><font
					color=#ff0000>*</font></td>
			</tr>
						<tr class=even>
				<td width='100' align='right' nowrap>验证码:&nbsp;</td>
				<td bgcolor='#ffffff'><input type="text"
					name=""><font color=#ff0000>*</font></td>
			</tr>
			<tr class=even>
				<td width='100' align='right' nowrap>密码:&nbsp;</td>
				<td bgcolor='#ffffff'><input type="password"
					name="UserPassword"><font color=#ff0000>*</font></td>
			</tr>
			<tr class=even>
				<td width='100' align='right' nowrap>确认密码:&nbsp;</td>
				<td bgcolor='#ffffff'><input type="password"
					name="UserPass"><font color=#ff0000>*</font></td>
			</tr>
			<tr class=even>
				<td width='100' align='right' nowrap>昵称:&nbsp;</td>
				<td bgcolor='#ffffff'><input type="text" name="UserNickname"><font
					color=#ff0000>*</font></td>
			</tr>
			<tr class=even>
				<td height=35 colspan="2"><input class="input" type="button"
					value="确定" onclick="check(this)"> <input class="input"
					type="button" value="返回" onclick="javascript:back()"></td>
			</tr>
		</table>
	</form>
	<iframe name='hideFrame' style="display: none"></iframe>
</body>
</html>
