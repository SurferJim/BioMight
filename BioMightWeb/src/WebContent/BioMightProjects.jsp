<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="biomightweb.view.BioMightProjectView"%>

<jsp:useBean id="bioMightProjectsView" class="biomightweb.view.BioMightProjectsView" scope="request" />

<html>
<head>
<link rel="stylesheet" href="theme/Master.css" type="text/css">
<LINK href="theme/blue.css" rel="stylesheet" type="text/css">
<title>BioMight</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>


<script type="text/javascript">

function doDetails(calYear, entity, action) {
	var frm = document.forms["bioMightProjectsForm"];
	frm.pageAction.value = "details";
	frm.pageName.value = "";
	frm.submit();
}

function goPalette(projectID) {
	var frm = document.forms["bioMightPaletteForm"];
	frm.bioMightProjectID.value = "00001";
	frm.bioMightProjectName.value = "Project One";
	frm.pageAction.value = "projects";
	frm.submit();
}
</script>



<s:form id="bioMightPaletteForm" name="bioMightPaletteForm" action="BioMightPalette" method="post">
<s:hidden id="projectID" name="bioMightProjectID"  value=""/>
<s:hidden id="projectName" name="bioMightProjectName"  value=""/>
<s:hidden id="pageAction" name="pageAction"  value=""/>
</s:form>


<s:form id="BioMightProjectsForm" action="BioMightProjects" method="post">
<s:hidden id="pageAction" name="pageAction" value=""/>
<s:hidden id="pageName" name="pageName" value=""/>
 
  
<table class="tableTop"> 

	<tr>		
  		<td>
			<table>
				<tr>
				<td>	
					<img height="60px" src='images/biomight.gif' width='490px'>
				</td>
   					<td>Welcome</td> 
   					<td><A href="http://localhost:8080/BioMightWeb/">Account</A></td>
   					<td>&nbsp;&nbsp;</td>
   					<td><A href="http://localhost:8080/BioMightWeb/">Help</A></td>
   					<td>&nbsp;&nbsp;</td>
   					<td><A href="http://localhost:8080/BioMightWeb/">Logout</A></td>
   				</TR>
   		     </TABLE>	
         </td>		
	</tr>

<TR>
<TD> 

<div id='componentsDiv' class="divContainer" style="overflow:auto; height:725px; width:780px;">	
<table>

	<tr>
   		<td class="footer2Title">Project Name</td>
   		<td class="footer2">Create Date</td>
   		<td class="footer2">Size</td>
   		<td class="footer2">Duration</td>
   		<td class="footer2">Frames</td>
   		<td class="footer2" colspan=4><I></I>&nbsp;</td>
	</tr>

		<%	
		for (int i=0; i<bioMightProjectsView.getSize(); i++)
		{		
		BioMightProjectView	bioMightProjectView = null;
		bioMightProjectView	= (BioMightProjectView) bioMightProjectsView.get(i);
		
		%>
		<tr>
			<td>
			<%= bioMightProjectView.getProjectName()%>
			</td>
			<td>
			07/25/2007
			</td>
			<td>
			<%= bioMightProjectView.getSize()%>KB   
			</td>
			<td>
			<%= bioMightProjectView.getDuration()%>sec   
			</td>
			<td>
			<%= bioMightProjectView.getFramesPerSecond()* bioMightProjectView.getDuration() %>   
			</td>
			<td>&nbsp;&nbsp;&nbsp;</td>
			<td>
				<a href="javascript:doDetails('projid');"><img border="0" src="images/pencil.gif"></a>
			</td>
			<td>
				<a href="javascript:goPalette('projid');"><img border="0" src="images/zoom.gif"></a>
			</td>
			<td>
				<a href="javascript:doDelete('projid');"><img border="0" src="images/delete.gif"></a>
			</td>			
		</tr>
		<%
		}
		%>
			
		<tr>
	   		<td valign="top" height="5" colspan=9 class="footer2"><I></I></td>
		</tr>

		<tr>
	   		<td valign="top" height="12">
	   		<A href="http://localhost:8080/BioMightWeb/ProjectAdd.jsp"><img border="0" src="images/addnew.gif"></A>
	   		</td>  	
		</tr>		
		
			<TR>
	      	<td class="tableDataNotice" colSpan=8>
	      		&nbsp;&nbsp;This is the BioMights Projects page.  This is where your custom animations, logos,
	      		&nbsp;&nbsp;presentations, etc. will be stored when<BR> 
	      		&nbsp;&nbsp;release 1.0 is available. 
	      		For now, just click on the middle icon found to the right, which appears as a magnifying glass.<BR>
		 		
	    	</td>   
   			</TR>

</table>
</div>
	
</TD>
</TR>
</table>

</s:form>

</body>
</html>

