<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="chrome=1" />
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<title>BioMight Sample HTML5 Template</title>
	
	<!-- REMOVE THIS ONE LINE OF CODE HERE -->
	<link rel="stylesheet" href="theme/Master.css" type="text/css">
	
	
	<!-- ******* USE THIS CODE HERE ********* -->
	<!-- These two lines must be declared in your HTML 5 web page. They make the 3D graphics possible -->
	<script src="http://www.x3dom.org/release/x3dom.js"></script>
 	<link rel="stylesheet" href="http://www.x3dom.org/release/x3dom.css">
 	<!-- ****************************  -->
 	
</head>

<HEADER>
<div id="divyCenterPage">
<img height="70px" src='images/biomight.gif' width='490px'>
</div>
</HEADER>

<NAV>
<%@include file="corpNav.jsp"%>
</NAV>

<BODY>

<script  type="text/javascript">

function goMenu(userAction) {
	var frm = document.forms["bioMightCorpForm"];
	frm.pageAction.value = userAction;		
	frm.submit();
}

</script>

<!-- Going to the BioMightView to get view components -->
<s:form id="bioMightCorpForm" name="bioMightCorpForm" action="BioMightCorporate" method="post">
<s:hidden property="pageAction" name="pageAction"  value=""/>
</s:form>

<div id="divyCenterPage">
<TABLE class="tableOutline">
	<TR>
       <td>
			<TABLE class="tableWelcome">	
			<TR>
			 	<td class="tableDataWelcome">
			 	<BR>
				Once you have created your animation in BioMight, export the file and save it to your local drive.<br>
				It will appear as an .X3D file.  Open this webpage as 'view source' and use the below sample to set up 
				the animation on your website.  
	   			</td>
	   		</TR>
	   			
	   			
	   			
			<TR>
		       <td>
		
		   		<h1>BioMight Sample HTML5 Template</h1>
		
				<!-- USE THIS CODE HERE -->   
				<!-- Update the inline url line with the name of your animation -->	   		
				<x3d id="bioWindow" showlog="false" showstat="false" width=600 height=500> 
				<scene>			
			        <navigationInfo id="head" headlight='true' type='"EXAMINE"'></navigationInfo>
		   			<background  skyColor="0 0 0"></background>
					<inline url="x3d/BCellAnim.x3d"> </inline> 
				</scene> 
			  	</x3d> 
			  	<!-- Setup this above snippet in your web page to run the X3D animation -->	
		
			</td>
		 	</TR>
	   			
	   		<TR>
     		 	<td class="tableDataCW">
     		 		<BR><BR>
     		 		<BR><BR>
		 			Copyright 2018 BioMight Inc.   Long Beach   New York 11561	 
      			</td>   
   			</TR>
   				
   						
			</TABLE>
 		</td>
 	</TR>
	 </TABLE>
	 
</div>
</body>
</html>
