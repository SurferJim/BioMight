<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page language="java" pageEncoding="ISO-8859-1"%>

<%@page import="biomight.view.BioMightMethodView"%>
<%@page import="biomight.view.BioMightPropertyView"%>
<%@page import="biomight.Constants"%>
<%@page import="java.util.ArrayList"%>
<%@page import="biomight.BioMightKey"%>
<%@page import="biomight.BioMightKeys"%>


		
<html manifest="cache.manifest">
<head>
	<title>BioMight</title>
	<link rel="stylesheet" href="theme/Master.css" type="text/css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
	<META HTTP-EQUIV="EXPIRES" CONTENT="Fri, 11 Nov 2013 11:21:01 GMT"></head>
	
	<script type='text/javascript' src='js/x3dom-full.js'> </script> 
	<link rel='stylesheet' type='text/css' href='theme/x3dom.css'></link>

		
	<style>
		#launchAnimer {
	    position: absolute;
	    float: left;
	    z-index: 1;
	    top: 0px;
	    left: 0px;
	    width: 8em;
	    height: 2em;
	    border: none;
	    background-color: #202021;
	    color: #ccc;
	    }
	    	    
		#zoomer {
	    position: absolute;
	    float: left;
	    z-index: 1;
	    top: 0px;
	    left: 80px;
	    width: 8em;
	    height: 2em;
	    border: none;
	    background-color: #202021;
	    color: #ccc;
	    }
	    	    
    	#bioWindow {
        width:  745px;
        height: 700px;
        border: none;
        display: block;
        position:relative;
    }	    
    
    </style>
	
	 
</head> 


<body onload="goToggle('components');" >

<SCRIPT>

	function bioExplore(componentID, componentType, componentName, componentRef, componentParentID, collectionFlag)
	{
		//alert("Setting BioExplore Values:");
		var frm = document.forms["bioMightForm"];
		//document.getElementById("bioMightBodyID").value = bioMightProjectID;
		//document.getElementById("bioMightProjectID").value = bioMightProjectID;
		document.getElementById("bioMightComponentID").value = componentID;
		document.getElementById("bioMightComponentType").value = componentType;
		document.getElementById('bioMightComponentName').value = componentName;
		document.getElementById('bioMightComponentRef').value = componentRef;
		document.getElementById('bioMightComponentParentID').value = componentParentID;
		document.getElementById('bioMightCollection').value=collectionFlag;
		frm.pageAction.value = "bioExplore";
		//alert("Submitting BioExplore Values:");
		frm.submit();
	}


	function bioProcess()
	{
		//alert("Setting BioExplore Values:");
		var frm = document.forms["bioMightForm"];
		//document.getElementById("bioMightBodyID").value = bodyID;
		//document.getElementById("bioMightProjectID").value = projectID;
		document.getElementById("bioMightComponentID").value = '${bioMightComponent.bioMightComponentID}';
		document.getElementById("bioMightComponentType").value = '${bioMightComponent.bioMightComponentType}';
		document.getElementById('bioMightComponentName').value = '${bioMightComponent.bioMightComponentName}';
		document.getElementById('bioMightComponentParentID').value = '${bioMightComponent.bioMightComponentParentID}';
		document.getElementById('bioMightComponentRef').value = '${bioMightComponent.bioMightComponentRef}';
		document.getElementById('bioMightCollection').value = '${bioMightComponent.bioMightCollection}';
		frm.pageAction.value = "bioProcess";
		//alert("Submitting BioProcess Values:");
		frm.submit();
	}


	// Go to the Palette with the information from the current view
	function goPalette(pageAction)
	{
		var frm = document.forms["bioMightPaletteForm"];
		//document.getElementById("bioMightBodyID").value = bodyID;
		//document.getElementById("bioMightProjectID").value = projectID;
		document.getElementById("bioMightComponentID_p").value = '${bioMightComponent.bioMightComponentID}';
		document.getElementById("bioMightComponentType_p").value = '${bioMightComponent.bioMightComponentType}';
		document.getElementById('bioMightComponentName_p').value = '${bioMightComponent.bioMightComponentName}';
		document.getElementById('bioMightComponentParentID_p').value = '${bioMightComponent.bioMightComponentParentID}';
		document.getElementById('bioMightComponentRef_p').value = '${bioMightComponent.bioMightComponentRef}';
		document.getElementById('bioMightCollection_p').value = '${bioMightComponent.bioMightCollection}';
		frm.pageAction.value = pageAction;
		frm.submit();
	}

	
	function doBuild(componentType, parentID)
	{
		alert("Setting BioBuild Values: " +  componentType + "  " + parentID);
		var frm = document.forms["bioMightForm"];
		//document.getElementById("bioMightBodyID").value = bodyID;
		//document.getElementById("bioMightProjectID").value = projectID;
		document.getElementById("bioMightComponentID").value = '${bioMightComponent.bioMightComponentID}';
		document.getElementById("bioMightComponentType").value = '${bioMightComponent.bioMightComponentType}';
		document.getElementById('bioMightComponentName').value = '${bioMightComponent.bioMightComponentName}';
		document.getElementById('bioMightComponentParentID').value = parentID;
		document.getElementById('bioMightComponentRef').value = '${bioMightComponent.bioMightComponentRef}';
		document.getElementById('bioMightCollection').value = '${bioMightComponent.bioMightCollection}';
		document.getElementById("bioMightBuildComponentType").value = componentType;
		frm.pageAction.value = "build";
		frm.submit();
	}
	
	
	function expandTree(title)
	{
		var frm = document.forms["bioMightForm"];
		frm.biomightComponent.value = '%{bioMightComponent.getBioMightComponentID()}%';
		frm.propertyTitle.value = title;
		frm.pageAction.value = "expand";
		frm.submit();
	}

	function collapseTree(title)
	{
		var frm = document.forms["bioMightForm"];
		frm.biomightComponent.value = '%{bioMightComponent.getBioMightComponentID()}%';
		frm.propertyTitle.value = title;
		frm.pageAction.value = "collapse";
		frm.submit();
	}
	

	function scrollTemplate(component, currentImg, direction) 
	{ 
    	var compDiv = document.getElementById(compDiv);
    	if(compDiv.style.display=="none")
    	{
        	compDiv.style.display="";
    	}
    	else 
    	{
       	 compDiv.style.display="none";
    	}
    	
    	alert("Scrolling...");
    }	

	
	//function showCompDetails(msg) 
	//{ 
    //	var compDiv = document.getElementById('compyName');
    //    compDiv.innerText = msg;
    //}	
    
	
	function goToggle(toggleKey)
	{
			
		//alert("Applying Toggle: " + toggleKey);		
		if (toggleKey == 'components') {
		
			// Hide the DIV bo that holds the data
			var link = document.getElementById('componentsDiv');
			link.style.visibility = 'visible';
			link.style.display = 'block';
			link.style.left = "777px";
			
			// Hide the DIV bo that holds the data
			link = document.getElementById('actionsDiv');
			link.style.display = 'none';
			link.style.visibility = 'hidden';			
			link.style.left = "777px";
		 	
			//link = document.getElementById('buildDiv');
			//link.style.display = 'none';
			//link.style.visibility = 'hidden';
		}
		else if (toggleKey == 'actions') {
			var link = document.getElementById('actionsDiv');
			link.style.visibility = 'visible';
			link.style.display = 'block';
			
			link = document.getElementById('componentsDiv');
			link.style.display = 'none';
			link.style.visibility = 'hidden';

			//link = document.getElementById('buildDiv');
			//link.style.display = 'none';
			//link.style.visibility = 'hidden';
		}				
		else if (toggleKey == 'build') {
			//var link = document.getElementById('buildDiv');
			//link.style.visibility = 'visible';
			//link.style.display = 'block';
			
			link = document.getElementById('actionsDiv');
			link.style.visibility = 'none';
			link.style.display = 'hidden';
			
			link = document.getElementById('componentsDiv');
			link.style.display = 'none';
			link.style.visibility = 'hidden';
		}	
		
		
		return true;
	}
	

	
	var zoomed = false;

	function zoom(button) {		
		var bioWindow = document.getElementById('bioWindow');
	    var bioWindowBox = document.getElementById('bioWindowBox');
	    
	    var componentsBox = document.getElementById('componentsDiv');
	    var methodsBox = document.getElementById('actionsDiv');
	    //var buildBox = document.getElementById('buildDiv');
	    
		//title = document.getElementById('title')
        //body  = document.getElementById('body')
        
        
		if (zoomed) {
			bioWindowWidth = "750x";
			bioWindowHeight = "725px";

			bioFrameWidth = "775px";
			bioFrameHeight = "725px";

			componentBoxWidth = "790px";
			componentBoxHeight = "725px";
			
			componentBoxLeft  = "790px";
			componentBoxTop = "120px";	
			
			button.innerHTML = "Zoom";
			//title.style.display = "block"
			//body.style.padding = '10px'
		} else {
		
			bioWindowWidth = "998px";
			bioWindowHeight = "720px";
			
			bioFrameWidth = "1000px";
			bioFrameHeight = "725px";
	
			componentBoxWidth = "500px";
			componentBoxHeight = "725px";
			
			// Position it at 1000 pixes to the right
			componentBoxLeft = "1050px";
			componentBoxTop = "120px";
			
			button.innerHTML = "Unzoom";
			//title.style.display = "none"
			//body.style.padding = '0'
		}

		zoomed = !zoomed;

		bioWindow.style.width  = bioWindowWidth;
		bioWindow.style.height = bioWindowHeight;
		
		bioWindowBox.style.width  = bioFrameWidth;
		bioWindowBox.style.height = bioFrameHeight;

		componentsBox.style.width  = componentBoxWidth;
		componentsBox.style.height = componentBoxHeight;
		componentsBox.style.top    = componentBoxTop;
		componentsBox.style.left   = componentBoxLeft;
		
		methodsBox.style.width  = componentBoxWidth;
		methodsBox.style.height = componentBoxHeight;
		methodsBox.style.top    = componentBoxTop;
		//methodsBox.style.left   = innerLeftPos;

		//buildBox.style.width  = componentBoxWidth;
		//buildBox.style.height = componentBoxHeight;
		//buildBox.style.top    = componentBoxTop;
		//buildBox.style.left   = innerLeftPos;
	}
    

	function showComponent(message) {	
		document.getElementById("myDesc").innerHTML = message;
	}

//window.location.reload();
</SCRIPT>

<!-- Post to the Palette Page -->
<s:form id="bioMightPaletteForm" name="bioMightPaletteForm" action="BioMightPalette" method="post">
<s:hidden id="bioMightComponentID_p" name="bioMightComponent.bioMightComponentID"  value=""/>
<s:hidden id="bioMightComponentType_p" name="bioMightComponent.bioMightComponentType" value=""/>
<s:hidden id="bioMightComponentName_p" name="bioMightComponent.bioMightComponentName" value=""/>
<s:hidden id="bioMightComponentRef_p" name="bioMightComponent.bioMightComponentRef" value=""/>
<s:hidden id="bioMightComponentParentID_p" name="bioMightComponent.bioMightComponentParentID" value=""/>
<s:hidden id="bioMightCollection_p" name="bioMightComponent.bioMightCollection"  value=""/>
<s:hidden id="bioMightPropertyTitle_p" name="bioMightComponent.bioMightPropertyTitle" value=""/>
<s:hidden id="bioMightBuildComponentType_p" name="bioMightComponent.bioMightBuildComponentType" value=""/>
<s:hidden property="pageAction_p" name="pageAction"  value=""/>
</s:form>

<!-- Post to the View Page -->
<s:form id="bioMightForm" name="bioMightForm" action="BioMightView" method="post">
<s:hidden id="bioMightComponentID" name="bioMightComponent.bioMightComponentID"  value=""/>
<s:hidden id="bioMightComponentType" name="bioMightComponent.bioMightComponentType" value=""/>
<s:hidden id="bioMightComponentName" name="bioMightComponent.bioMightComponentName" value=""/>
<s:hidden id="bioMightComponentRef" name="bioMightComponent.bioMightComponentRef" value=""/>
<s:hidden id="bioMightComponentParentID" name="bioMightComponent.bioMightComponentParentID" value=""/>
<s:hidden id="bioMightCollection" name="bioMightComponent.bioMightCollection"  value=""/>
<s:hidden id="bioMightPropertyTitle" name="bioMightComponent.bioMightPropertyTitle" value=""/>
<s:hidden id="bioMightBuildComponentType" name="bioMightComponent.bioMightBuildComponentType" value=""/>
<s:hidden id="pageAction" name="pageAction"  value=""/>

<table class="tableTopAbs">
	
	<tr>		
		<td>
			<table>
				<tr>
				<td>
				<a href="javascript:bioExplore('Elements:0', '<%=biomight.Constants.ElementsRef%>','<%=biomight.Constants.ElementsRef%>','<%=biomight.Constants.Elements%>','0',true);"><IMG  height=35 border="0" src="images/Elements.jpg" title="Elements"></a>
				&nbsp;
				<a href="javascript:bioExplore('Molecules:0', '<%=biomight.Constants.MoleculesRef%>','<%=biomight.Constants.MoleculesRef%>','<%=biomight.Constants.Molecules%>','0',true);"><IMG  height=35 border="0" src="images/Molecules.jpg" title="Molecules"></a>
				&nbsp;
				<a href="javascript:bioExplore('BioAssemblies:0', '<%=biomight.Constants.BioAssembliesRef%>', '<%=biomight.Constants.BioAssembliesRef%>','<%=biomight.Constants.BioAssemblies%>','BioAssemblies:0', true);"><IMG  height=35 width=40px border="0" src="images/BioAssemblies.jpg" title="BioAssemblies"></a>
				&nbsp;
				<a href="javascript:bioExplore('Pathways:0', '<%=Constants.PathwaysRef%>', '<%=biomight.Constants.PathwaysRef%>','<%=biomight.Constants.Pathways%>','Body:0',true);"><IMG  height=35 border="0" src="images/Pathways.jpg" title="Pathways"></a>
				&nbsp;
				<a href="javascript:bioExplore('Viruses:0', '<%=biomight.Constants.VirusesRef%>', '<%=biomight.Constants.VirusesRef%>','<%=biomight.Constants.Viruses%>', 'Viruses:0',true);"><IMG  height=35 border="0" src="images/Viruses.jpg" title="Viruses"></a>
				&nbsp;
				<a href="javascript:bioExplore('Bacterias:0', '<%=biomight.Constants.BacteriasRef%>', '<%=biomight.Constants.BacteriasRef%>','<%=biomight.Constants.Bacterias%>', 'Bacterias:0',true);"><IMG  height=35 border="0" src="images/Bacteria.jpg" title="Bacterium"></a>
				&nbsp;
				<a href="javascript:bioExplore('Cells:0', '<%=biomight.Constants.CellsRef%>', '<%=biomight.Constants.CellsRef%>','<%=biomight.Constants.Cells%>','Cells:0', true);"><IMG  height=35 border="0" src="images/Cells.jpg" title="Cells"></a>
				&nbsp;
				<a href="javascript:bioExplore('Tissues:0', '<%=biomight.Constants.TissuesRef%>', '<%=biomight.Constants.TissuesRef%>','<%=biomight.Constants.Tissues%>','Tissues:0', true);"><IMG  height=35 border="0" src="images/Tissues.jpg" title="Tissues"></a>
				&nbsp;
				<a href="javascript:bioExplore('Organs:0', '<%=biomight.Constants.OrgansRef%>', '<%=biomight.Constants.OrgansRef%>','<%=biomight.Constants.Organs%>', 'Organs:0', true);"><IMG  height=35 border="0" src="images/Organs.jpg" title="Organs"></a>
				&nbsp;
				<a href="javascript:bioExplore('BioMightSystems:0', '<%=biomight.Constants.BioMightSystemsRef%>', '<%=biomight.Constants.BioMightSystemsRef%>', '<%=biomight.Constants.BioMightSystems%>', 'BioMightSystems:0', true);"><IMG  height=35 border="0" src="images/Systems.jpg" title="Systems"></a>
				&nbsp;
				<a href="javascript:bioExplore('Body:1', '<%=biomight.Constants.BodyRef%>', '<%=biomight.Constants.BodyRef%>', '<%=biomight.Constants.Body%>', 'Human:1', false);"><IMG  height=35 border="0" src="images/Body.jpg" title="Body"></a>
				&nbsp;
				<a href="javascript:bioExplore('BioSymbols:0', '<%=biomight.Constants.BioSymbolsRef%>', '<%=biomight.Constants.BioSymbolsRef%>', '<%=biomight.Constants.BioSymbols%>', 'BioSymbols:0', false);"><IMG  height=35 border="0" src="images/Text.gif" title="Text"></a>
				</td>
				</tr>
			</table>
		</td>

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
   					<td colSpan=3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
   				</TR>
   		     </TABLE>	
         </td>		
	</tr>

	<tr>
		<td class="footer2">
			View - ${bioMightComponent.bioMightComponentName} <div id='myDesc'>No Component Highlighted</div>
		</td>
		
		<td class="footer2">
			<table border=1>
				<tr class="footer2">
					<td><a href="javascript:goToggle('components');"><img border="0" src="images/components.gif"></A></td> 
					<td><a href="javascript:goToggle('actions');"><img border="0" src="images/actions.gif"></A></td>
					<td><a href="javascript:goToggle('build');"><img border="0" src="images/build.gif"></A></td>    
				</tr>
			</table>
		</td>
	</tr>

	<tr>
		<td>
		<div id="bioWindowBox" class="divContainer" style="overflow:auto; height:700px; width:775px;">
				<table class="table2">
				<% 
				String form = "BioMightForm";
				// If the X3D was generated, use it
				String X3D = "${bioMightComponent.x3D}";
				if (!X3D.equals(""))
				{
				%>
				<tr>
				<td>
				
				
				  <x3d id="bioWindow" showlog="false" showstat="false"> 
    				<scene>
    				
    				    <button id="launchAnimer"   onclick="launchAnim();return false;" >Start</button>
    				    <button id="zoomer"   onclick="zoom(this);return false;" >Zoom</button>
    					
	    		        <navigationInfo id="head" headlight='true' type='"EXAMINE"'></navigationInfo>
	        			<background  skyColor="0 0 0"></background>
	    				<inline url="x3d/${bioMightComponent.bioMightComponentName}.x3d"> </inline> 
	    			</scene> 
    			  </x3d>           
        			
				</td>
				</tr>
				<%
				}
				%>
			</table>	
			</div>
		</td>



		<!-- Show Properties  -->
		<td>
			<div id='componentsDiv' class="divPropertiesContainer"   style="overflow:auto; height:700px; width:775px;">
			<table>
	
			
		
			 <s:if test="%{bioMightComponent.bioMightProperties !=null}">
				<tr class="footer6">
					<td class="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>xPos</td>
					<td>yPos</td>
					<td>zPos</td>
					<td>&nbsp;</td>
					<td>xScale</td>
					<td>yScale</td>
					<td>zScale</td>
					<td>&nbsp;</td>
					<td>xRotate</td>
					<td>yRotate</td>
					<td>zRotate</td>
					<td>&nbsp;</td>
					<td>Shape</td>  
				</tr>
	
		
				<s:iterator value="bioMightComponent.bioMightProperties" status="propertyStatus">	
					<tr>
						<td>
							<a href="javascript:expandTree('<s:property value="%{propertyName}"/> ');"><IMG src="images/plus.gif" title='<s:property value="%{propertyDesc}"/>' border="0" width="10" height="10"></A>
						
							<a href="javascript:doBuild('<s:property value="%{propertyRef}"/>', '<s:property value="%{bioMightComponent.bioMightComponentID}"/>');"><IMG src="images/pencil.gif" title='<s:property value="%{propertyDesc}"/>' border="0" width="10" height="10"></A>
								
							<s:checkbox name="bioMightComponent.bioMightProperties[%{#propertyStatus.index}].ViewEnabled" theme="simple"/> 
								
							<a href="javascript:bioExplore('<s:property value="%{propertyID}"/>', '<s:property value="%{propertyRef}"/>', '<s:property value="%{propertyName}"/>', '<s:property value="%{canonicalName}"/>', '<s:property value="%{bioMightComponent.bioMightComponentID}"/>', '<s:property value="%{bioMightComponent.bioMightCollection}"/>');"  title='<s:property value="%{propertyDesc}"/>'>
						    <s:property value="%{propertyName}"/> </a>		     
						    
						    <s:hidden name="bioMightComponent.bioMightProperties[%{#propertyStatus.index}].propertyName" value="%{propertyName}"/>		
							<s:hidden name="bioMightComponent.bioMightProperties[%{#propertyStatus.index}].propertyID" value="%{propertyID}" />
							<s:hidden name="bioMightComponent.bioMightProperties[%{#propertyStatus.index}].propertyRef" value="%{propertyRef}" />
							<s:hidden name="bioMightComponent.bioMightProperties[%{#propertyStatus.index}].canonicalName" value="%{canonicalName}" />
	
	    				</td>
	    			
	    			
	    				<td>
							<s:textfield name="bioMightComponent.bioMightProperties[%{#propertyStatus.index}].PropertyPosition.XPos"  size="2"  theme="simple"></s:textfield> 
						</td>
	   	
		   				<td>
							<s:textfield name="bioMightComponent.bioMightProperties[%{#propertyStatus.index}].PropertyPosition.YPos" size="2"  theme="simple"></s:textfield>
						</td>
						
						<td>
							<s:textfield name="bioMightComponent.bioMightProperties[%{#propertyStatus.index}].PropertyPosition.ZPos" size="2"  theme="simple"></s:textfield>
						</td>
		   
		   				<td>&nbsp;</td>
		   
		   				<td>
							<s:textfield name="bioMightComponent.bioMightProperties[%{#propertyStatus.index}].PropertyScale.XScale" size="2"  theme="simple"></s:textfield>
						</td>
						
						<td>	
							<s:textfield name="bioMightComponent.bioMightProperties[%{#propertyStatus.index}].PropertyScale.YScale" size="2"  theme="simple"></s:textfield>
						</td>
						
						<td>
							<s:textfield name="bioMightComponent.bioMightProperties[%{#propertyStatus.index}].PropertyScale.ZScale" size="2"  theme="simple"></s:textfield>
						</td>
		   
		   				<td>&nbsp;</td>
		   
		   				<td>
							<s:textfield name="bioMightComponent.bioMightProperties[%{#propertyStatus.index}].PropertyOrientation.XAxis" size="2"  theme="simple"></s:textfield>
						</td>
						
						<td>
							<s:textfield name="bioMightComponent.bioMightProperties[%{#propertyStatus.index}].PropertyOrientation.YAxis" size="2"  theme="simple"></s:textfield>
						</td>
						
						<td>
								<s:textfield name="bioMightComponent.bioMightProperties[%{#propertyStatus.index}].PropertyOrientation.ZAxis" size="2"  theme="simple"></s:textfield>
						</td>
				  
					</tr>
				</s:iterator>
		
				<tr>				
					<td colspan=3>
					<a href="javascript:goPalette('add');"><img border="0" src="images/addObject.gif"></A>
					&nbsp;
					<a href="javascript:bioProcess();"><img border="0" src="images/submit.gif"></A>
					&nbsp;
					<a href="javascript:goPalette('noadd');"><img border="0" src="images/return.gif"></A>
					</td>
				
				 	<td>
						
					</td>
						
			   		<td>
					
					</td>		
				</tr>
				
				
			</s:if>
				
				
		</table>
		</div>
		</td>
	
	
		<!-- Show Methods  -->
		<td>
		
			<div id='actionsDiv' class="divMethodsContainer" style="overflow:scroll; height:700px; width:775px;">
			<table>
	
			<s:iterator value="bioMightComponent.bioMightMethods"  status="methodStatus">				
			<% 
			String htmlType =( String) request.getAttribute("htmlType");
			if (htmlType.equals(biomight.Constants.BIO_DROPDOWN))
			{
			%>
				<tr>			
					<td>		
					
					<s:select label="%{displayName}"
					headerKey="1" headerValue="Select Color"
					list="%{valueMap}"	 
					name="bioMightComponent.bioMightMethods[%{#methodStatus.index}].methodParameter" 
					value="0" />													
					</td>
				</tr>					
			<%} 
			else if (htmlType.equals(biomight.Constants.NOT_ACTIVATED)) 
			{ %> 
				<tr>
					<td>
						<s:property value="%{displayName}"/>
						<s:hidden id="bioMightMethodDisplay%{#methodStatus.index}" name="bioMightComponent.bioMightMethods[%{#methodStatus.index}].displayName" value="%{displayName}"/>
					</td>
					<td>
						
					</td>
				</tr>
			<% } 
			 else 
			{ %> 
				<tr>
					<td>
						<s:property value="%{displayName}"/> 
						<s:hidden id="bioMightMethodDisplay%{#methodStatus.index}" name="bioMightComponent.bioMightMethods[%{#methodStatus.index}].displayName" value="%{displayName}"/>
					</td>
					<td>
						<s:textfield  name="bioMightComponent.bioMightMethods[%{#methodStatus.index}].methodParameter" size="35" tooltip="enter value"  theme="simple"></s:textfield>
					</td>
				</tr>
			<%} %>	
			
			
				<tr>
					<td>
						<s:hidden id="bioMightMethodName%{#methodStatus.index}" name="bioMightComponent.bioMightMethods[%{#methodStatus.index}].methodName" value="%{methodName}"/>
						<s:hidden id="bioMightMethodCanonical%{#methodStatus.index}" name="bioMightComponent.bioMightMethods[%{#methodStatus.index}].canonicalName" value="%{canonicalName}"/>
						<s:hidden id="bioMightMethodHtmlType%{#methodStatus.index}" name="bioMightComponent.bioMightMethods[%{#methodStatus.index}].htmlType" value="%{htmlType}"/>
						<s:hidden id="bioMightMethodDataType%{#methodStatus.index}" name="bioMightComponent.bioMightMethods[%{#methodStatus.index}].dataType" value="%{dataType}"/>
					</td>
				</tr>
			
			</s:iterator>
		
			<tr>
				<td>
				<a href="javascript:bioProcess();"><img border="0" src="images/submit.gif"></A>			                                                              
    			</td>			
			</tr>
					
			</table>
			</div>	
			
		</td>


</s:form>

</body>

</html>