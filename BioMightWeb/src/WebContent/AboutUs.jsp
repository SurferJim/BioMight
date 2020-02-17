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
					<B>BioMight Inc.</B> is a software development company located in Long Beach, NY.  A small city about 20 miles from Manhattan,
					on the south shore of Long Island. 
					<BR><BR>
					The concept for BioMight was born in 2003, while the founder (a skilled software developer) was gaining a deeper 
					understanding of life sciences while attending presentations at the New York Academy of Sciences. While there, 
					he noticed that PowerPoint slides were the norm for presenting a researcher's work, and set upon a quest to 
					build a animation tool with libraries of components that they could use to captivate their audience while 
					better explaing their work in the lab.
					<BR><BR>
					One day, it is hoped, that BioMight will create a digital 'biological entity' that can be programmed around 
					your individual traits.  It will run in real time on your smart device and and simulate processes going on in your
					body as you perform your day, helping to keep you healthy and running at your peak.  We hope you will support the company on 
					that journey by making a donation to the organization.
					<BR><BR>
					<br>
			      </td>
			   </TR>
		
				<TR>
	      		 	<td class="tableDataWelcome">
			 		&nbsp;
			 		&nbsp;&nbsp;	
			 		<BR>				   		 	
					<div id="bioWindowBox" class=".divLoginContainer" style="height:320px; width:380px; ">
					  <x3d id="bioWindow" showlog="false" showstat="false" style="height:318px; width:378px;"> 
	    				<scene>
		    		        <navigationInfo id="head" headlight='true' type='"EXAMINE"'></navigationInfo>
		        			<background  skyColor="0 0 0"></background>
		    				<inline url="x3d/Phage.x3d"> </inline> 
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
