<% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
response.setHeader("Pragma","no-cache"); //HTTP 1.0 
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server %>

<%@ page language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" >
<HTML>
	<HEAD>

	</HEAD>

	<BODY onload="javascript:levanta();">
		<SCRIPT language="JavaScript" type="text/javascript">
		  function levanta() {
			//largo = 1024 - 10;
			//ancho = 768 - 57;
			largo = screen.width - 15;
			ancho = screen.height - 90;
			b = window.open("login/fLogin.xhtml?rnd=" + (Math.random() * 1000000000000) + "&sLogout=0", "", "location=no; menubar=no; scrollbars=auto; toolbar=no; width=" + largo + "px; height=" + ancho + "px; top=0px; left=0px");
			opener = b.top;
			window.close();
		  }
		</SCRIPT>
	</BODY>
</HTML>