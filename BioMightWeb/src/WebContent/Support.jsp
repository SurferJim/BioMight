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
			      <td class="tableDataCorporate">
					Welcome to BioMight Support page.  Please reach us at 516-780-5957 for issues or questions.  
					<BR><BR>
			      </td>
			   </TR>
		
			<TR>
	      		 	<td class="tableDataWelcome">
					<div id="bioWindowBox" class=".divLoginContainer" style="height:500px; width:700px; ">
					  <x3d id="bioWindow" showlog="false" showstat="false" style="height:498px; width:698px;"> 
	    				<scene>
		    		        <navigationInfo id="head" headlight='true' type='"EXAMINE"'></navigationInfo>
		        			<background  skyColor="0 0 0"></background>
		    				<inline url="x3d/LungAnim.x3d"> </inline> 
		    			</scene> 
	    			  </x3d>           
        		  	</div>	
			 		
			 		<BR>
	      			</td>   
   				</TR>	
					   
				<TR>
	      		 	<td class="tableDataCW">
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
