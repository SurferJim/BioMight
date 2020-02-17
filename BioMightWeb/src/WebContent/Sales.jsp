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
			       <BR>
					Please make a donation to support the fast-creation of BioMight.  Your donation will be applied to your account's
					subscription when release 1.0 of the product goes officially live.  We greatly appreciate your support.<BR><BR>	
			      </td>
			   </TR>
			   
			   		
				<TR>
	      		 	<td class="tableDataWelcome">				   		 	
					<div id="bioWindowBox" class=".divLoginContainer" style="height:380px; width:720px; ">
					  <x3d id="bioWindow" showlog="false" showstat="false" style="height:378px; width:718px;"> 
	    				<scene>
		    		        <navigationInfo id="head" headlight='true' type='"EXAMINE"'></navigationInfo>
		        			<background  skyColor="0 0 0"></background>
		    				<inline url="x3d/VirusAnim.x3d"> </inline> 
		    			</scene> 
	    			  </x3d>           
        		  	</div>	
			 		
			 		<BR>
	      			</td>   
   				</TR>	
						   
				<TR>
	      		 <td class="tableDataCW">
				 	&nbsp;&nbsp;	 
					<form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_blank">
					<input type="hidden" name="cmd" value="_s-xclick">
					<input type="hidden" name="hosted_button_id" value="UH5FSXU7GNZH8">
					<input type="image" src="https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif" border="0" name="submit" alt="PayPal - The safer, easier way to pay online!">
					<img alt="" border="0" src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" width="1" height="1">
					</form>
					<BR><BR>
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
