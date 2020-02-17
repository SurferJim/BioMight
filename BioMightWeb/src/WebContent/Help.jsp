<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<TITLE>BioMight - The Might of Biological Simulations</TITLE>
<link rel="stylesheet" href="theme/Master.css" type="text/css">
<link rel="stylesheet" href="theme/x3dom.css">
<script src="js/x3dom.js"></script>
</HEAD>

<HEADER>	
<img height="70px" src='images/biomight.gif' width='490px'>
</HEADER>

<BODY bgcolor="black" text="white">

<script  type="text/javascript">

function doLogin() {
	var frm = document.forms["BioMightLoginForm"];	
	frm.submit();
}

function goMenu(userAction) {
	var frm = document.forms["bioMightCorpForm"];
	frm.pageAction.value = userAction;
	frm.submit();
}

</script>

<NAV>
<%@include file="corpNav.jsp"%>
</NAV>

<s:actionerror />

<s:form id="bioMightCorpForm" name="bioMightCorpForm" action="BioMightCorporate" method="post">
<s:hidden property="pageAction" name="pageAction"  value=""/>
</s:form>

<TABLE class="tableOutline">
	<TR>
       <td>
			<TABLE class="tableWelcome">
			
				<TR>
	      		 	<td class="tableDataCW">
			 			&nbsp;
	      			</td>   
   				</TR>	

				<TR>
	      		 	<td class="tableDataNotice">
			 			&nbsp;&nbsp;To use the BioMight application, we recommend the <B>BS Contact</B> Plugin from BitManagement<BR>
			 			&nbsp;&nbsp;This free X3D viewer will allow you to see and manipulate BioMight's biological components.
			 			&nbsp;&nbsp; Get X3D Plugin Here: <A href="http://http://www.bitmanagement.com/en/download">BitManagement BS Contact</A>	 
	      			</td>   
   				</TR>
   					
				<TR>
	      		 	<td class="tableDataWelcome">
			 		After login, you will be taken to the Projects page.   This is where you store your 3D animations. 
			 		 <BR><BR>
	      			</td>   
   				</TR>
   			
   				<TR>
	      		 	<td class="tableDataWelcome">
			 		After you select a project, using the middle icon to the right you will be taken to the Palette page.
			 		 
			 		 <BR><BR>
	      			</td>   
   				</TR>
   							
			   <TR>
			      <td class="tableDataWelcome">
					<s:form id="loginForm" action="loginProcess" method="post">
						<s:textfield name="username" key="label.username" size="20" />
						<s:password name="password" key="label.password" size="20" />
						<s:submit method="execute" key="label.login" align="center" />
					</s:form>
      			  </td>
			      
			   </TR>

					   
				<TR>
	      		 	<td class="tableDataCW">
			 			&nbsp;
	      			</td>   
   				</TR>					
   									   
				<TR>
	      		 	<td class="tableDataCW">
			 			Copyright 2018 BioMight Inc. Long Beach,  New York,  11561	 
	      			</td>   
   				</TR>
   					
			</TABLE>
 	</td>
 	</TR>
 </TABLE>




</body>
</html>
