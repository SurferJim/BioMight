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
<div id="divyCenterPage">
<img height="70px" src='images/biomight.gif' width='490px'>
</div>
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

function goAccount() {
	alert("Please see QuickStart Guide for login");	
	var frm = document.forms["BioMightLoginForm"];
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

<div id="divyCenterPage">
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
			 			<h3>BioMight Beta Release version 3.0 (June 1, 2018)<BR>
			 			</H3>
	      			</td>   
   				</TR>
   				
   				<TR>
	      		 	<td class="tableDataWelcome">
			 		&nbsp;
			 		&nbsp;&nbsp;	
			 		<BR>				   		 	
					<div id="bioWindowBox" class=".divLoginContainer" align="center" style="height:340px; width:700px;">
					  <x3d id="bioWindow" showlog="false" showstat="false" style="height:338px; width:698px;"> 
	    				<scene>
		    		        <navigationInfo id="head" headlight='true' type='"EXAMINE"'></navigationInfo>
		        			<background  skyColor="0 0 0"></background>
		    				<inline url="x3d/Bacteria.x3d"> </inline> 
		    			</scene> 
	    			  </x3d>           
        		  	</div>	
			 		
			 		<BR>
	      			</td>   
   				</TR>


   					
				<TR>
	      		 	<td class="tableDataWelcome">
			 		&nbsp;&nbsp;Read the <A href="images/BioMightQuickStart.pdf" target="_blank">BioMight QuickStartGuide (PDF)</A> for login instructions and use.
			 		Search BioMight <BR>
			 		&nbsp;&nbsp;on YouTube for instructional videos and samples;
			 	    <A href="https://www.youtube.com/watch?v=Pgb9-aP0hbc" target="_blank">BioMight YouTube Video</A>

			 		<BR><BR>	
	      			</td>   
   				</TR>
   	
   			  	   <s:form id="loginForm" action="loginProcess" method="post" theme='simple'>						
				   <TR>
				      <td class="tableDataWelcome">
						 &nbsp;&nbsp;Username: <s:textfield name="username" key="label.username" size="20" theme='simple'/>
	      			  </td>
				   </TR>
			  
				   <TR>
				      <td class="tableDataWelcome">
						&nbsp;&nbsp;Password:  &nbsp;<s:password name="password" key="label.password" size="20" theme='simple'/>
	      			  </td>
				   </TR>
				   
				   	<TR>
				      <td class="tableDataWelcome">
						  &nbsp;&nbsp;<s:submit method="execute" key="label.login" theme='simple'	/> 	&nbsp;&nbsp; <a href="javascript:goAccount();">New User</A>  	&nbsp;&nbsp;<a href="javascript:goAccount();">Assist</A>  
	      			  </td>
				   </TR>			   
				</s:form>
					   
				<TR>
	      		 	<td class="tableDataCW">
	   
	      			</td>   
   				</TR>					
   									   
				<TR>
	      		 	<td class="tableDataCW">
	      		 		<BR>
			 			Copyright 2018 BioMight Inc. Long Beach,  New York,  11561	 
	      			</td>   
   				</TR>
   					
			</TABLE>
 	</td>
 	</TR>
 </TABLE>


</div>
</body>
</html>
