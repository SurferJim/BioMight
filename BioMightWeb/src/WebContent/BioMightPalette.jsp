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
<%@page import="biomightweb.view.BioMightViewPoint"%>
<%@page import="biomight.view.BioMightAnimation"%>
						

<html manifest="cache.manifest">
<head>
	<title>BioMight</title>
	<link rel="stylesheet" href="theme/Master.css" type="text/css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
	<META HTTP-EQUIV="EXPIRES" CONTENT="Fri, 11 Nov 2013 11:b21:01 GMT">
	
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
        width:  660px;
        height: 720px;
        border: none;
        display: block;
        position:relative;
    }	    
    
    </style>

</head> 


        
<body >


<SCRIPT type="text/javascript">

 	function bioExplore(componentID, componentType, componentName, componentRef, componentParentID, collectionFlag)
	{
		var frm = document.forms['bioMightForm'];
		//alert("Posting the data: " + (typeof frm) );
		document.getElementById("bioMightComponentID_p").value = componentID;
		document.getElementById("bioMightComponentType_p").value = componentType;
		document.getElementById('bioMightComponentName_p').value = componentName;
		document.getElementById('bioMightComponentRef_p').value = componentRef;
		document.getElementById('bioMightComponentParentID_p').value = componentParentID;
		//document.getElementById("bioMightBuildComponentType_p").value = componentType;
		document.getElementById('bioMightCollection_p').value=collectionFlag;
		//alert("Posting the data");
		frm.pageAction.value = "bioExplore";
		frm.submit();
	}

    function bioMethods()
	{
		// We are only going to do XYZ right now
		var frm = document.forms["bioMightPaletteForm"];
		document.getElementById("bioMightComponentID").value = "${bioMightComponent.bioMightComponentID}";
		document.getElementById("bioMightComponentType").value = "${bioMightComponent.bioMightComponentType}";
		document.getElementById("bioMightComponentName").value = "${bioMightComponent.bioMightComponentName}";
		document.getElementById("bioMightComponentRef").value = "${bioMightComponent.bioMightComponentRef}";
		document.getElementById("bioMightComponentParentID").value = "${bioMightComponent.bioMightComponentParentID}";
		document.getElementById("bioMightBuildComponentType").value = "${bioMightComponent.bioMightBuildComponentType}";
		document.getElementById("bioMightCollection").value="true";
		frm.bioMightComponentPick.value = -1;
		frm.pageAction.value = "bioMethod";	
		frm.submit();
	}

    
    function bioExport()
	{
		// We are only going to do XYZ right now
		var frm = document.forms["bioMightPaletteForm"];
		document.getElementById("bioMightComponentID").value = "${bioMightComponent.bioMightComponentID}";
		document.getElementById("bioMightComponentType").value = "${bioMightComponent.bioMightComponentType}";
		document.getElementById("bioMightComponentName").value = "${bioMightComponent.bioMightComponentName}";
		document.getElementById("bioMightComponentRef").value = "${bioMightComponent.bioMightComponentRef}";
		document.getElementById("bioMightComponentParentID").value = "${bioMightComponent.bioMightComponentParentID}";
		document.getElementById("bioMightBuildComponentType").value = "${bioMightComponent.bioMightBuildComponentType}";
		document.getElementById("bioMightCollection").value="true";
		frm.bioMightComponentPick.value = -1;
		frm.pageAction.value = "bioExport";	
		frm.submit();
	}
    
    function deleteComponent(numElement, componentName, componentType, componentRef, componentID, componentParentID)
	{
		// We are only going to do XYZ right now
		var frm = document.forms["bioMightPaletteForm"];
		document.getElementById("bioMightComponentID").value = componentID;
		document.getElementById("bioMightComponentType").value = componentType;
		document.getElementById("bioMightComponentName").value = componentName;
		document.getElementById("bioMightComponentRef").value = componentRef;
		document.getElementById("bioMightComponentParentID").value = componentParentID;
		//alert("Posting the Delete data");		
		frm.bioMightComponentPick.value = numElement;
		frm.pageAction.value = "delete";	
		frm.submit();
	}	
	    	    

	// Sets the value of the Camera animation's start and end values 
	// based on the start and end set for the camera at statis
	function alignViewValues(fieldType, valueType, compNum)
	{
    	//alert("Aligning View Values: " + valueType + "   " + compNum); 
    	//alert("#Components: " + "${bioMightComponents.size()}" );
    	//for (j=0; j<${bioMightComponents.size()}; j++)
    	var i=0;
    	for (i=0; i<3; i++)
    	{	
    		
    		if (fieldType == "Pos") {
	    		// Run through all the component animation points
	    		//alert("Aligning Values: " + valueType + "  " + i); 
	     		if (valueType == "X") {
					document.getElementById("vp_StartXPos_" + compNum + "_" + i).value = document.getElementById("vp_xPos_" + compNum).value;
					document.getElementById("vp_EndXPos_" + compNum + "_" + i).value = document.getElementById("vp_xPos_" + compNum).value;
	    		}
	    		else if (valueType == "Y") {	
	    			document.getElementById("vp_StartYPos_" + compNum + "_" + i).value = document.getElementById("vp_yPos_" + compNum).value;
	    			document.getElementById("vp_EndYPos_" + compNum + "_" + i).value = document.getElementById("vp_yPos_" + compNum).value;
	    		}
	     		else if (valueType == "Z") {	
	     			document.getElementById("vp_StartZPos_" + compNum+ "_" + i).value = document.getElementById("vp_zPos_" + compNum).value;
	     			document.getElementById("vp_EndZPos_" + compNum + "_" + i).value = document.getElementById("vp_zPos_" + compNum).value;
	    		} 
    		}
    		else if (fieldType == "Pov") {
	    		// Run through all the component animation points
	    		//alert("Aligning Values: " + valueType + "  " + i); 
				//document.getElementById("vp_StartPov_" + compNum + "_" + i).value = document.getElementById("vp_pov_" + compNum).value;
				//document.getElementById("vp_EndPov_" + compNum + "_" + i).value = document.getElementById("vp_pov_" + compNum).value;
    		}    		
    		else if (fieldType == "Orientation") {
	    		// Run through all the component animation points
	    		//alert("Align Orientation Values: " + valueType + "  " + i); 
	     		if (valueType == "X") {	
					document.getElementById("vp_StartXOrient_" + compNum + "_" + i).value = document.getElementById("vp_xAxis_" + compNum).value;
					document.getElementById("vp_EndXOrient_" + compNum + "_" + i).value = document.getElementById("vp_xAxis_" + compNum).value;
	    		}
	    		else if (valueType == "Y") {	
					document.getElementById("vp_StartYOrient_" + compNum + "_" + i).value = document.getElementById("vp_yAxis_" + compNum).value;
					document.getElementById("vp_EndYOrient_" + compNum + "_" + i).value = document.getElementById("vp_yAxis_" + compNum).value;
	    		}
	     		else if (valueType == "Z") {	
					document.getElementById("vp_StartZOrient_" + compNum + "_" + i).value = document.getElementById("vp_zAxis_" + compNum).value;
					document.getElementById("vp_EndZOrient_" + compNum + "_" + i).value = document.getElementById("vp_zAxis_" + compNum).value;
	    		}
	     		else if (valueType == "DEGREES") {	
	     			//alert("Setting Degrees: " + valueType + "  " + i); 
					document.getElementById("vp_StartDegreesOrient_" + compNum + "_" + i).value = document.getElementById("vp_degrees_" + compNum).value;
					document.getElementById("vp_EndDegreesOrient_" + compNum + "_" + i).value = document.getElementById("vp_degrees_" + compNum).value;
	    		} 
    		}	
    	}
	}    
	

	// Sets the value of the Components animation's start and end values 
	// based on the start and end set for the component
    function alignCompValues(fieldType, valueType, compNum)
	{
    	//alert("Aligning Values: " + valueType + "   " + compNum); 
    	//myVal = document.getElementById("bioMightPaletteForm_bioMightComponents_0__bioMightAnimations_0__StartPosition_XPos").value;
    	//alert("Current Value: " + myVal); 
    	
    	//alert("#Components: " + "${bioMightComponents.size()}" );
    	//for (j=0; j<${bioMightComponents.size()}; j++)
    	var i=0;
    	for (i=0; i<3; i++)
    	{	
    		
    		if (fieldType == "Pos") {
	    		// Run through all the component animation points
	    		//alert("Aligning {Pos Values: " + valueType + "  " + i); 
	     		if (valueType == "X") {	
					document.getElementById("cp_StartXPos_" + compNum + "_" + i).value = document.getElementById("cp_xPos_" + compNum).value;
					document.getElementById("cp_EndXPos_" + compNum + "_" + i).value = document.getElementById("cp_xPos_" + compNum).value;
	    		}
	    		else if (valueType == "Y") {	
	    			document.getElementById("cp_StartYPos_" + compNum + "_" + i).value = document.getElementById("cp_yPos_" + compNum).value;
	    			document.getElementById("cp_EndYPos_" + compNum + "_" + i).value = document.getElementById("cp_yPos_" + compNum).value;
	    		}
	     		else if (valueType == "Z") {	
	     			document.getElementById("cp_StartZPos_" + compNum+ "_" + i).value = document.getElementById("cp_zPos_" + compNum).value;
	     			document.getElementById("cp_EndZPos_" + compNum + "_" + i).value = document.getElementById("cp_zPos_" + compNum).value;
	    		} 
    		}
    		else if (fieldType == "Scale") {
	    		// Run through all the component animation points
	    		//alert("Aligning Values: " + valueType + "  " + i); 
	     		if (valueType == "X") {	
					document.getElementById("cp_StartXScale_" + compNum + "_" + i).value = document.getElementById("cp_xScale_" + compNum).value;
					document.getElementById("cp_EndXScale_" + compNum + "_" + i).value = document.getElementById("cp_xScale_" + compNum).value;
	    		}
	    		else if (valueType == "Y") {	
					document.getElementById("cp_StartYScale_" + compNum + "_" + i).value = document.getElementById("cp_yScale_" + compNum).value;
					document.getElementById("cp_EndYScale_" + compNum + "_" + i).value = document.getElementById("cp_yScale_" + compNum).value;
	    		}
	     		else if (valueType == "Z") {	
					document.getElementById("cp_StartZScale_" + compNum + "_" + i).value = document.getElementById("cp_zScale_" + compNum).value;
					document.getElementById("cp_EndZScale_" + compNum + "_" + i).value = document.getElementById("cp_zScale_" + compNum).value;
	    		} 
    		}    		
    		else if (fieldType == "Orientation") {
	    		// Run through all the component animation points
	    		//alert("Align Orientation Values: " + valueType + "  " + i); 
	     		if (valueType == "X") {	
					document.getElementById("cp_StartXOrient_" + compNum + "_" + i).value = document.getElementById("cp_xAxis_" + compNum).value;
					document.getElementById("cp_EndXOrient_" + compNum + "_" + i).value = document.getElementById("cp_xAxis_" + compNum).value;
	    		}
	    		else if (valueType == "Y") {	
	    			curVal = document.getElementById("cp_StartYOrient_" + compNum + "_" + i).value = document.getElementById("cp_yAxis_" + compNum).value;
	    			//alert("CurVal is " + curVal);
	    			if ((!curVal == 1.0) && (!curVal == 0.0)) {
						userReply = confirm("Are you sure you do not want value set to 0, or 1?");
	    				if (userReply == true) {
							documendocument.getElementById("cp_StartYOrient_" + compNum + "_" + i).value = document.getElementById("cp_yAxis_" + compNum).value;
							getElementById("cp_EndYOrient_" + compNum + "_" + i).value = document.getElementById("cp_yAxis_" + compNum).value;
	    				}
	    			}
	    		}
	     		else if (valueType == "Z") {	
					document.getElementById("cp_StartZOrient_" + compNum + "_" + i).value = document.getElementById("cp_zAxis_" + compNum).value;
					document.getElementById("cp_EndZOrient_" + compNum + "_" + i).value = document.getElementById("cp_zAxis_" + compNum).value;
	    		}
	     		else if (valueType == "DEGREES") {	
	     			//alert("Setting Degrees: " + valueType + "  " + i); 
					document.getElementById("cp_StartDegreesOrient_" + compNum + "_" + i).value = document.getElementById("cp_Degrees_" + compNum).value;
					document.getElementById("cp_EndDegreesOrient_" + compNum + "_" + i).value = document.getElementById("cp_Degrees_" + compNum).value;
	    		} 
    		}	
    	}
	}
	

    function alignTimeValues(animType, fieldType, compNum, animNum)
	{
    	//alert("Aligning Time Values: " + fieldType + "   " + compNum + "   " + animNum);
    	animNum = parseInt(animNum);
    	
    	if (animType == "cp") {
    			maxAnims=2; }
    	else if (animType == "vp") {
			maxAnims=3; }
    	
   		if (fieldType == "Start") {    
		//	document.getElementById("bioMightPaletteForm_bioMightComponents_" + compNum + "__bioMightAnimations_" + animNum + "__EndTime").value 
		//	= document.getElementById("cp_StartTime_" + compNum + "_" + animNum).value;
   		}
   		else if (fieldType == "End") {
   	    	//alert("Setting the next StartTime: " + fieldType + "   " + compNum + "   " + animNum);
			
   	    	if (animNum < maxAnims) {
   	    		nextAnim = animNum + 1;
   	    		//alert("Looking for " + "cp_StartTime_" + compNum + "_" + nextAnim);
				
   	    		if (parseInt(document.getElementById(animType + "_EndTime_" + compNum + "_" + animNum).value) == 0)  {
   	    				document.getElementById(animType + "_StartTime_" + compNum + "_" + nextAnim).value = 0;
   	    		}		
   	    		else
   	    		{
				document.getElementById(animType + "_StartTime_" + compNum + "_" + nextAnim).value 
					= (parseInt(document.getElementById(animType + "_EndTime_" + compNum + "_" + animNum).value) + 1 );
   			
				document.getElementById(animType, "_EndTime_" + compNum + "_" + nextAnim).value 
					= ( parseInt(document.getElementById(animType + "_EndTime_" + compNum + "_" + animNum).value) + 1 );
   	    		}
   	    	}
     	}    				
	
	}

    
    function alignSEValues(animType, fieldType, valueType, compNum, animNum)
	{
    	//alert("Aligning SE Values: " + fieldType + "   " + valueType + "   " + compNum + "   " + animNum);
    	animNum = parseInt(animNum);

    	if (animType == "cp") {
			maxAnims=2; }
		else if (animType == "vp") {
			maxAnims=3; }
    	
    	if (fieldType == "StartPos") {    
	    	if (animNum < maxAnims) {
   	    		nextAnim = animNum + 1;
   	    		//alert("Looking for " + "cp_StartTime_" + compNum + "_" + nextAnim);
				
	    		// Run through all the component animation points
	     		if (valueType == "X") {				
	     			tempVal = document.document.getElementById(animType + "_StartXPos_" + compNum + "_" + animNum).value;
	     			checkCoord(tempVal);
	     			document.getElementById(animType + "_EndXPos_" + compNum + "_" + animNum).value = tempVal;
	     		}
	    		else if (valueType == "Y") {	
	    			tempVal = document.getElementById(animType + "_StartYPos_" + compNum + "_" + animNum).value;	
	    			checkCoord(tempVal);
	    			document.getElementById(animType + "_EndYPos_" + compNum + "_" + animNum).value = tempVal; 
     				
	    		}
	     		else if (valueType == "Z") {	
	     			tempVal == document.getElementById(animType + "_StartZPos_" + compNum + "_" + animNum).value;
	     			checkCoord(tempVal);
	     			document.getElementById(animType + "_EndZPos_" + compNum + "_" + animNum).value = tempVal; 
	    		} 
	    	}
   		}
   		else if (fieldType == "EndPos") {
   	    	//alert("Setting the next StartPosition: " + fieldType + "   " + compNum + "   " + animNum);
			
   	    	if (animNum < maxAnims) {
   	    		nextAnim = animNum + 1;
   	    		//alert("Looking for " + "cp_StartTime_" + compNum + "_" + nextAnim);
								
	    		// Run through all the component animation points
	     		if (valueType == "X") {				
	     			document.getElementById(animType + "_StartXPos_" + compNum + "_" + nextAnim).value 
	     				= document.getElementById(animType + "_EndXPos_" + compNum + "_" + animNum).value;				
	     		}
	    		else if (valueType == "Y") {	
	     			document.getElementById(animType + "_StartYPos_" + compNum + "_" + nextAnim).value 
     				= document.getElementById(animType + "_EndYPos_" + compNum + "_" + animNum).value;	
	    		}
	     		else if (valueType == "Z") {	
	     			document.getElementById(animType + "_StartZPos_" + compNum + "_" + nextAnim).value 
     				= document.getElementById(animType + "_EndZPos_" + compNum + "_" + animNum).value;
	    		} 			
   	    	}
     	} 
   		else if (fieldType == "StartScale") {
   	    	//alert("Setting the next StartPosition: " + fieldType + "   " + compNum + "   " + animNum);
			
   	    	if (animNum < maxAnims) {
   	    		nextAnim = animNum + 1;
   	    		//alert("Looking for " + "cp_StartTime_" + compNum + "_" + nextAnim);
								
	    		// Run through all the component animation points
	     		if (valueType == "X") {				
	     			document.getElementById(animType + "_EndXScale_" + compNum + "_" + animNum).value 
	     				= document.getElementById(animType + "_StartXScale_" + compNum + "_" + animNum).value;				
	     		}
	    		else if (valueType == "Y") {	
	     			document.getElementById(animType + "_EndYScale_" + compNum + "_" + animNum).value 
     				= document.getElementById(animType + "_StartYScale_" + compNum + "_" + animNum).value;	
	    		}
	     		else if (valueType == "Z") {	
	     			document.getElementById(animType + "_EndZScale_" + compNum + "_" + animNum).value 
     				= document.getElementById(animType + "_StartZScale_" + compNum + "_" + animNum).value;
	    		} 		
   	    	}
     	}
   		else if (fieldType == "EndScale") {
   	    	//alert("Setting the next StartPosition: " + fieldType + "   " + compNum + "   " + animNum);
			
   	    	if (animNum < maxAnims) {
   	    		nextAnim = animNum + 1;
   	    		//alert("Looking for " + "cp_StartTime_" + compNum + "_" + nextAnim);
								
	    		// Run through all the component animation points 
	     		if (valueType == "X") {				
	     			document.getElementById(animType + "_StartXScale_" + compNum + "_" + nextAnim).value 
	     				= document.getElementById(animType + "_EndXScale_" + compNum + "_" + animNum).value;				
	     		}
	    		else if (valueType == "Y") {	
	     			document.getElementById(animType + "_StartYScale_" + compNum + "_" + nextAnim).value 
     				= document.getElementById(animType + "_EndYScale_" + compNum + "_" + animNum).value;	
	    		}
	     		else if (valueType == "Z") {	
	     			document.getElementById(animType + "_StartZScale_" + compNum + "_" + nextAnim).value 
     				= document.getElementById(animType + "_EndZScale_" + compNum + "_" + animNum).value;
	    		} 		
   	    	}
     	}
  		else if (fieldType == "StartOrient") {
   	    	//alert("Setting the next StartPosition: " + fieldType + "   " + compNum + "   " + animNum);
			
   	    	if (animNum < maxAnims) {
   	    		nextAnim = animNum + 1;
   	    		//alert("Looking for " + "cp_StartTime_" + compNum + "_" + nextAnim);
								
	    		// Run through all the component animation points
	    		//alert("Aligning Orient Values: " + valueType); 
	     		if (valueType == "X") {				
	     			document.getElementById(animType + "_EndXOrient_" + compNum + "_" + animNum).value 
	     				= document.getElementById(animType + "_StartXOrient_" + compNum + "_" + animNum).value;				
	     		}
	    		else if (valueType == "Y") {	
	     			document.getElementById(animType + "_EndYOrient_" + compNum + "_" + animNum).value 
     				= document.getElementById(animType + "_StartYOrient_" + compNum + "_" + animNum).value;	
	    		}
	     		else if (valueType == "Z") {	
	     			document.getElementById(animType + "_EndZOrient_" + compNum + "_" + animNum).value 
     				= document.getElementById(animType + "_StartZOrient_" + compNum + "_" + animNum).value;
	    		} 		
	     		else if (valueType == "DEGREES") {	
	     			document.getElementById(animType + "_EndDegreesOrient_" + compNum + "_" + animNum).value 
     				= document.getElementById(animType + "_StartDegreesOrient_" + compNum + "_" + animNum).value;
	    		} 	
   	    	}
     	}
   		else if (fieldType == "EndOrient") {
   	    	//alert("Setting the next StartPosition: " + fieldType + "   " + compNum + "   " + animNum);
			
   	    	if (animNum < maxAnims) {
   	    		nextAnim = animNum + 1;
   	    		//alert("Looking for " + "cp_StartTime_" + compNum + "_" + nextAnim);
								
	    		// Run through all the component animation points
	     		if (valueType == "X") {				
	     			document.getElementById(animType + "_StartXOrient_" + compNum + "_" + nextAnim).value 
	     				= document.getElementById(animType + "_EndXOrient_" + compNum + "_" + animNum).value;				
	     		}
	    		else if (valueType == "Y") {	
	     			document.getElementById(animType + "_StartYOrient_" + compNum + "_" + nextAnim).value 
     				= document.getElementById(animType + "_EndYOrient_" + compNum + "_" + animNum).value;	
	    		}
	     		else if (valueType == "Z") {	
	     			document.getElementById(animType + "_StartZOrient_" + compNum + "_" + nextAnim).value 
     				= document.getElementById(animType + "_EndZOrient_" + compNum + "_" + animNum).value;
	    		} 		
	     		else if (valueType == "DEGREES") {	
	     			document.getElementById(animType + "_StartDegreesOrient_" + compNum + "_" + nextAnim).value 
     				= document.getElementById(animType + "_EndDegreesOrient_" + compNum + "_" + animNum).value;
	    		} 	
   	    	}
     	}

	}
	
 
    function checkCoord(coordinate)
	{
    	alert("Checkin Coordinate: " + coordinate); 
    	//alert("#Components: " + "${bioMightComponents.size()}" );
	}
    
  
    function initializeAnim()
	{
   		//var bioScriptTimeVar = new Date().getTime(); 
   		//alert("In Initialize: " + bioScriptTimeVar);	
      
        //var currentTime = document.getElementById('BioPalette__bioTimer').getAttribute('startTime');
        //alert('Current Timer Start: ' + currentTime);   
        //document.getElementById('BioPalette__bioTimer').setAttribute('startTime', (bioScriptTimeVar + 10));
 
        //var currentTimeNew = document.getElementById('BioPalette__bioTimer').getAttribute('startTime');
        document.getElementById('BioPalette__bioTimer').setAttribute('startTime',(new Date().getTime() / 1000).toString());
	}
    
   
	var zoomed = false;

	function zoom(button) {		
		var bioWindow = document.getElementById('bioWindow');
	    var bioWindowBox = document.getElementById('bioWindowBox');
	    var bioWindowLeft = document.getElementById('bioWindowLeft');
	    
		//title = document.getElementById('title')
        //body  = document.getElementById('body')
        
		if (zoomed) {
			innerWidth = "660px";
			innerHeight = "720px";

			outerWidth = "675px";
			outerHeight = "725px";

			innerWidthLeft = "925px";
			innerHeightLeft = "725px";
			
			button.innerHTML = "Zoom";
			//title.style.display = "block"
			//body.style.padding = '10px'
		} else {
		
			innerWidth = "1200px";
			innerHeight = "725px";
			
			outerWidth = "1200px";
			outerHeight = "730px";
	
			innerWidthLeft = "500px";
			innerHeightLeft = "730px";
			
			button.innerHTML = "Unzoom";
			//title.style.display = "none"
			//body.style.padding = '0'
		}

		zoomed = !zoomed;

		bioWindow.style.width = innerWidth;
		bioWindow.style.height = innerHeight;

		bioWindowBox.style.width = outerWidth;
		bioWindowBox.style.height = outerHeight;

		bioWindowLeft.style.width = innerWidthLeft;
		bioWindowLeft.style.height = innerHeightLeft;
	}
	
	function showComponent(message) {	
		document.getElementById("myDesc").innerHTML = message;
	}
    
    
    // This script is generated on thee server
    ${x3dScript}
   
    
//window.location.reload();
</SCRIPT>


<!-- Going to the BioMightView to get view components -->
<s:form id="bioMightForm" name="bioMightForm"  action="BioMightView"  method="post">
<s:hidden id="bioMightComponentID_p" name="bioMightComponent.bioMightComponentID"  value=""/>
<s:hidden id="bioMightComponentRef_p" name="bioMightComponent.bioMightComponentRef" value=""/>
<s:hidden id="bioMightComponentType_p" name="bioMightComponent.bioMightComponentType" value=""/>
<s:hidden id="bioMightComponentName_p" name="bioMightComponent.bioMightComponentName" value=""/>
<s:hidden id="bioMightComponentParentID_p" name="bioMightComponent.bioMightComponentParentID" value=""/>
<s:hidden id="bioMightBuildComponentType_p" name="bioMightComponent.bioMightBuildComponentType" value=""/>
<s:hidden id="bioMightCollection_p" name="bioMightComponent.bioMightCollection"  value=""/>
<s:hidden id="propertyTitle_p" name="bioMightComponent.bioMightPropertyTitle" value=""/>
<s:hidden id="paletteName_p" name="paletteName" value="paletteName"/>
<s:hidden id="pageAction_p" name="pageAction"  value=""/>
</s:form>

  	
<table class="tableTop">

					
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
   					<td><A href="http://localhost:8080/BioMightWeb/Welcome.html">Account</A></td>
   					<td>&nbsp;&nbsp;</td>
   					<td><A href="http://localhost:8080/BioMightWeb/Welcome.html">Help</A></td>
   					<td>&nbsp;&nbsp;</td>
   					<td><A href="http://localhost:8080/BioMightWeb/Login.jsp">Logout</A></td>
   				</TR>
   		     </TABLE>	
         </td>		
	</tr>
	
	
	 <s:if test="%{bioMightViewPoints == null}">
	

		<tr>
			<td height="12" class="footer2">
			No Components Selected
			</td>
			
			<td class="footer2">
			<table border=1>
			<tr class="footer2">
				<td>Components&nbsp;&nbsp;&nbsp;&nbsp;</td> 
			</tr>
			</table>
			</td>
		</tr>
	
	</s:if>
	
	<s:else>

	<tr>
		<td class="footer2">
			Project One 
		</td>
		
		<td class="footer2">
		<table border=1>
		<tr class="footer2">
			<td>Components&nbsp;&nbsp;&nbsp;&nbsp;</td>   
		</tr>
		</table>
		</td>
	</tr>

	</s:else>

	<tr>
	
		<td>
			<div class="divContainer" id="bioWindowBox" style="overflow:auto; height:725px; width:680px;">
				<table>		
				<tr>
				<td>		
					
				 <x3d id="bioWindow" showlog="false" showstat="false"> 
    				<scene>
    				    
    			        <button id="launchAnimer"   onclick="launchAnim();return false;" >Start</button>
    				    <button id="zoomer"   onclick="zoom(this);return false;" >Zoom</button>
    				 	
    				    <navigationInfo id="head" headlight='true' type='"EXAMINE"'></navigationInfo>
	        			<background  skyColor="0 0 0"></background>
	        			
						<inline nameSpaceName="BioPalette" mapDEFToID="true"  url="x3d/${paletteName}.x3d"> </inline> 
    				</scene> 
    			 </x3d>           
        			
				</td>
				</tr>
			
			</table>	
			</div>
		</td>
	
		<td>
			<div  class="divContainer" id="bioWindowLeft" style="overflow:auto; height:700px; width:945px;">
			 	<s:if test="%{bioMightViewPoints == null}">
				<table>
					<tr>				
						<td>
							No Components Selected 				
						</td>	
					</tr>
				</table>
				</s:if>			
	
				<s:form id="bioMightPaletteForm" name="bioMightPaletteForm" action="BioMightPalette" method="post" theme="simple">
				<s:hidden id="bioMightComponentID" name="bioMightComponent.bioMightComponentID"  value=""/>
				<s:hidden id="bioMightComponentRef" name="bioMightComponent.bioMightComponentRef" value=""/>
				<s:hidden id="bioMightComponentType" name="bioMightComponent.bioMightComponentType" value=""/>
				<s:hidden id="bioMightComponentName" name="bioMightComponent.bioMightComponentName" value=""/>
				<s:hidden id="bioMightComponentParentID" name="bioMightComponent.bioMightComponentParentID" value=""/>
				<s:hidden id="bioMightBuildComponentType" name="bioMightComponent.bioMightBuildComponentType" value=""/>
				<s:hidden id="bioMightCollection" name="bioMightComponent.bioMightCollection"  value=""/>
				<s:hidden id="propertyTitle" name="bioMightComponent.bioMightPropertyTitle" value=""/>
				<s:hidden id="bioMightComponentPick" name="bioMightComponentPick"  value=""/>
				<s:hidden id="pageAction" name="pageAction"  value=""/>
	
				<table>	
			
					<s:if test="%{bioMightViewPoints != null}">							
					
						<s:iterator value="bioMightViewPoints" var="vps" status="vpStatus">
							
						<tr class='footer2'>
							<td>&nbsp;</td>
							<td>xPos</td>
							<td>yPos</td>
							<td>zPos</td> 
							<td>&nbsp;</td> 
							<td>Roll <IMG src="images/UDArrow.jpg" height=15 width=10></td>
							<td>Pitch <IMG src="images/FBArrow.jpg" height=15 width=11></td>  
							<td>Yaw <IMG src="images/LRArrow.jpg" height=12 width=15></td>
							<td>Degrees</td>
							<td>&nbsp;</td> 
							<td>POV</td>		        
						</tr>	 		
		
											
							<tr class='divvyBar'>				
								<td  class="whiteSpace">
									<a href="javascript:setProperty('${viewPointName}', 'Head', 'Head', 'Head', 'Head', 'Head');"><IMG src="images/camera.jpg" height=30 border="0"></a>	
									<s:hidden name="bioMightViewPoints[%{#vpStatus.index}].viewPointName" value="%{viewPointName}"/>				
								</td>
												
								<td>
									<s:textfield id="vp_xPos_%{#vpStatus.index}" 
									name="bioMightViewPoints[%{#vpStatus.index}].Position.XPos" size="2" tooltip="xPos"  theme="simple" 
									onChange="javascript:alignViewValues('Pos', 'X', '%{#vpStatus.index}' );"></s:textfield>
								</td>	
								<td>
									<s:textfield id="vp_yPos_%{#vpStatus.index}" 
									name="bioMightViewPoints[%{#vpStatus.index}].Position.YPos" size="2" tooltip="yPos" theme="simple" 
									onChange="javascript:alignViewValues('Pos', 'Y', '%{#vpStatus.index}' );"></s:textfield>
								</td>
								<td>
									<s:textfield id="vp_zPos_%{#vpStatus.index}" 
									name="bioMightViewPoints[%{#vpStatus.index}].Position.ZPos" size="2" tooltip="zPos" theme="simple" 
									onChange="javascript:alignViewValues('Pos', 'Z', '%{#vpStatus.index}' );"></s:textfield>
								</td>						
								
								<td>&nbsp;</td>
																
								<td>
									<s:textfield id="vp_xAxis_%{#vpStatus.index}" 
									name="bioMightViewPoints[%{#vpStatus.index}].Orientation.XAxis" size="2"  theme="simple" 
									onChange="javascript:alignViewValues('Orientation', 'X', '%{#vpStatus.index}' );"></s:textfield>
								</td>
								<td>
									<s:textfield id="vp_yAxis_%{#vpStatus.index}" 
									name="bioMightViewPoints[%{#vpStatus.index}].Orientation.YAxis" size="2"  theme="simple" 
									onChange="javascript:alignViewValues('Orientation', 'Y', '%{#vpStatus.index}' );"></s:textfield>
								</td>
								<td>
									<s:textfield id="vp_zAxis_%{#vpStatus.index}" 
									name="bioMightViewPoints[%{#vpStatus.index}].Orientation.ZAxis" size="2"  theme="simple" 
									onChange="javascript:alignViewValues('Orientation', 'Z', '%{#vpStatus.index}' );"></s:textfield>
								</td>
								<td>
									<s:textfield id="vp_degrees_%{#vpStatus.index}" 
									name="bioMightViewPoints[%{#vpStatus.index}].orientation.degrees" size="2"  theme="simple" 
									onChange="javascript:alignViewValues('Orientation', 'DEGREES', '%{#vpStatus.index}' );"></s:textfield>
								</td>	
													 
								<td>&nbsp;</td>
								<td>
									<s:textfield id="vp_pov_%{#vpStatus.index}" 
									name="bioMightViewPoints[%{#vpStatus.index}].FieldOfView" size="2" theme="simple" 
									onChange="javascript:alignViewValues('Pov', '', '%{#vpStatus.index}' );"></s:textfield>
								</td>				
							</tr>
			
						
							<tr class='footer6'>
								<td>&nbsp;</td>
								<td>Start</td>
								<td>End</td>  
								<td>&nbsp;</td>
								<td>Start</td>
								<td>Start</td>
								<td>Start</td>
								<td>&nbsp;</td>
								<td>End</td>
								<td>End</td>
								<td>End</td>  								
								<td>&nbsp;</td> 
								<td>Start</td>
								<td>Start</td>  
								<td>Start</td>
								<td>Start</td>						 		  
								<td>&nbsp;</td> 
								<td>End</td>
								<td>End</td>  
								<td>End</td>
								<td>End</td>					
								<td>&nbsp;</td>
								<td>POV</td> 		
								<td>POV</td> 			
							</tr>			
						
							<tr class='footer6'>
								<td>&nbsp;</td>
								<td>Time</td>
								<td>Time</td>  
								<td>&nbsp;</td>
								<td>xPos</td>
								<td>yPos</td>
								<td>zPos</td>
								<td>&nbsp;</td>
								<td>xPos</td>
								<td>yPos</td>
								<td>zPos</td>  								
								<td>&nbsp;</td> 
								<td>Roll <IMG src="images/UDArrow.jpg" height=15 width=10></td>
								<td>Pitch <IMG src="images/FBArrow.jpg" height=15 width=11></td>  
								<td>Yaw <IMG src="images/LRArrow.jpg" height=12 width=15></td>
								<td>Degrees</td>						 		  
								<td>&nbsp;</td> 
								<td>Roll <IMG src="images/UDArrow.jpg" height=15 width=10></td>
								<td>Pitch <IMG src="images/FBArrow.jpg" height=15 width=11></td>  
								<td>Yaw <IMG src="images/LRArrow.jpg" height=12 width=15></td>
								<td>Degrees</td>					
								<td>&nbsp;</td>
								<td>POV</td> 		
								<td>POV</td> 			
							</tr>
					
							<s:iterator value="bioMightAnimations" var="vpAnims" status="vpAnimStatus">
								<tr>				
									<td>
										&nbsp;&nbsp;&nbsp;<a href="javascript:setProperty('${animationName}', 'Head', 'Head', 'Head', 'Head', 'Head');"><IMG src="images/anicon.jpg" height=30 border="0"></a>	
										<s:hidden name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].animationName" value="%{animationName}"/>				
									</td>
										
									<td>
										<s:textfield id="vp_StartTime_%{#vpStatus.index}_%{#vpAnimStatus.index}" tooltip="Start Time"
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].StartTime" size="2" theme="simple" 
										onChange="javascript:alignTimeValues('vp', 'Start', '%{#vpStatus.index}', '%{#vpAnimStatus.index}' );"></s:textfield>
									</td>
									
									<td>
										<s:textfield id="vp_EndTime_%{#vpStatus.index}_%{#vpAnimStatus.index}" 
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].EndTime" size="2" theme="simple" 
										onChange="javascript:alignTimeValues('vp', 'End', '%{#vpStatus.index}', '%{#vpAnimStatus.index}' );"></s:textfield>
									</td>
								
										<td>&nbsp;</td>
					
									<td>
										<s:textfield id="vp_StartXPos_%{#vpStatus.index}_%{#vpAnimStatus.index}"  
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].StartPosition.XPos" size="2" theme="simple" 
										onChange="javascript:alignSEValues('vp', 'StartPos', 'X', '%{#vpStatus.index}', '%{#vpAnimStatus.index}' );"></s:textfield>
									</td>
						
									<td>
										<s:textfield id="vp_StartYPos_%{#vpStatus.index}_%{#vpAnimStatus.index}" 
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].StartPosition.YPos" size="2" theme="simple" 
										onChange="javascript:alignSEValues('vp', 'StartPos', 'Y', '%{#vpStatus.index}', '%{#vpAnimStatus.index}' );"></s:textfield>
									</td>			
									
									<td>
										<s:textfield id="vp_StartZPos_%{#vpStatus.index}_%{#vpAnimStatus.index}"  
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].startPosition.ZPos" size="2" theme="simple" 
										onChange="javascript:alignSEValues('vp', 'StartPos', 'Z', '%{#vpStatus.index}', '%{#vpAnimStatus.index}' );"></s:textfield>
									</td>
									
									<td>&nbsp;</td>
									
									<td>
										<s:textfield id="vp_EndXPos_%{#vpStatus.index}_%{#vpAnimStatus.index}"   
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].EndPosition.XPos" size="2" theme="simple" 
										onChange="javascript:alignSEValues('vp', 'EndPos', 'X', '%{#vpStatus.index}', '%{#vpAnimStatus.index}' );"></s:textfield>
									</td>
					
									<td>
										<s:textfield id="vp_EndYPos_%{#vpStatus.index}_%{#vpAnimStatus.index}"   
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].EndPosition.YPos" size="2"  theme="simple" 
										onChange="javascript:alignSEValues('vp', 'EndPos', 'Y', '%{#vpStatus.index}', '%{#vpAnimStatus.index}' );"></s:textfield>
									</td>
					
									<td>
										<s:textfield id="vp_EndZPos_%{#vpStatus.index}_%{#vpAnimStatus.index}"   
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].EndPosition.ZPos" size="2"  theme="simple" 
										onChange="javascript:alignSEValues('vp', 'EndPos', 'Z', '%{#vpStatus.index}', '%{#vpAnimStatus.index}' );"></s:textfield>
										
										<s:hidden name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].StartScale.XScale" />		
										<s:hidden name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].StartScale.YScale" />
										<s:hidden name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].StartScale.ZScale" />
										<s:hidden name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].EndScale.XScale" />
										<s:hidden name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].EndScale.YScale" />
										<s:hidden name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].EndScale.ZScale" />
									</td>
									
											
									<td>&nbsp;</td>
									<td>
										<s:textfield id="vp_StartXOrient_%{#vpStatus.index}_%{#vpAnimStatus.index}"   
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].StartOrientation.XAxis" size="2"  theme="simple"></s:textfield>
									</td>
						
									<td>
										<s:textfield id="vp_StartYOrient_%{#vpStatus.index}_%{#vpAnimStatus.index}"  
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].StartOrientation.YAxis" size="2"  theme="simple"></s:textfield>
									</td>			
									
									<td>
										<s:textfield id="vp_StartZOrient_%{#vpStatus.index}_%{#vpAnimStatus.index}"  
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].StartOrientation.ZAxis" size="2"  theme="simple"></s:textfield>
									</td>	
							
									<td>
										<s:textfield id="vp_StartDegreesOrient_%{#vpStatus.index}_%{#vpAnimStatus.index}"  
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].StartOrientation.degrees" size="2"  theme="simple"></s:textfield>
									</td>
									
									<td>&nbsp;</td>
								
									<td>
										<s:textfield id="vp_EndXOrient_%{#vpStatus.index}_%{#vpAnimStatus.index}"   
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].EndOrientation.XAxis" size="2"  theme="simple"></s:textfield>
									</td>
						
									<td>
										<s:textfield id="vp_EndYOrient_%{#vpStatus.index}_%{#vpAnimStatus.index}"  
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].EndOrientation.YAxis" size="2"  theme="simple"></s:textfield>
									</td>			
									
									<td>
										<s:textfield id="vp_EndZOrient_%{#vpStatus.index}_%{#vpAnimStatus.index}"  
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].EndOrientation.ZAxis" size="2" theme="simple"></s:textfield>
									</td>	
							
									<td>
										<s:textfield id="vp_EndDegreesOrient_%{#vpStatus.index}_%{#vpAnimStatus.index}"  
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].EndOrientation.degrees" size="2"  theme="simple"></s:textfield>
									</td>
								
					
	
								</tr>				
							</s:iterator>
					
							
						</s:iterator>
					
						</s:if>
			
			
			
			
						<!-- COMPONENTS SECTION  -->
			
		
						<s:if test="%{bioMightComponents != null}">
						
							<s:iterator value="bioMightComponents" var="cps" status="cpStatus">
									
								<tr class='footer2'>
										<td>&nbsp;</td>
										<td>xPos</td>
										<td>yPos</td>
										<td>zPos</td>
										<td>&nbsp;</td>  
										<td>xScale</td>
										<td>yScale</td>  
										<td>zScale</td>	  
										<td>&nbsp;</td> 
										<td>Roll <IMG src="images/UDArrow.jpg" height=15 width=10></td>
										<td>Pitch <IMG src="images/FBArrow.jpg" height=15 width=11></td>  
										<td>Yaw <IMG src="images/LRArrow.jpg" height=12 width=15></td>
										<td>Degrees</td>		        
								</tr>	 		
								
								<tr class='divvyBar'>				
									<td >
									<a href="javascript:deleteComponent('<s:property value="%{#cpStatus.index}"/>', '${bioMightComponentName}', 'Head', 'Head', 'Head', 'Head');"><img border="0" src="images/delete.gif"></A>
									<a href="javascript:setProperty('${bioMightComponentName}', 'Head', 'Head', 'Head', 'Head', 'Head');"><IMG  height=30 border="0">${bioMightComponentName}</a>
									<s:hidden name="bioMightComponents[%{#cpStatus.index}].bioMightComponentID" value="%{bioMightComponentID}"/>	
									<s:hidden name="bioMightComponents[%{#cpStatus.index}].bioMightComponentRef" value="%{bioMightComponentRef}"/>
									<s:hidden name="bioMightComponents[%{#cpStatus.index}].bioMightComponentType" value="%{bioMightComponentType}"/>
									<s:hidden name="bioMightComponents[%{#cpStatus.index}].bioMightComponentName" value="%{bioMightComponentName}"/>
									<s:hidden name="bioMightComponents[%{#cpStatus.index}].bioMightComponentParentID" value="%{bioMightComponentParentID}"/>
									<s:hidden name="bioMightComponents[%{#cpStatus.index}].bioMightBuildComponentType" value="%{bioMightBuildComponentType}"/>
									<s:hidden name="bioMightComponents[%{#cpStatus.index}].bioMightCollection" value="%{bioMightCollection}"/>			
																
								</td>												
														
								<td>
									<s:textfield id="cp_xPos_%{#cpStatus.index}" 
									name="bioMightComponents[%{#cpStatus.index}].Position.XPos" size="2" theme="simple" 
									onChange="javascript:alignCompValues('Pos', 'X', '%{#cpStatus.index}' );"></s:textfield>
								</td>
									
								<td>
									<s:textfield id="cp_yPos_%{#cpStatus.index}" 
									name="bioMightComponents[%{#cpStatus.index}].Position.YPos" size="2" theme="simple" 
									onChange="javascript:alignCompValues('Pos', 'Y', '%{#cpStatus.index}' );"></s:textfield>
								</td>							
								
								<td>
									<s:textfield id="cp_zPos_%{#cpStatus.index}" 
									name="bioMightComponents[%{#cpStatus.index}].Position.ZPos" size="2" theme="simple" 
									onChange="javascript:alignCompValues('Pos', 'Z', '%{#cpStatus.index}' );"></s:textfield>
								</td>
								
								
								<td>&nbsp;</td>
								
								<td>
									<s:textfield id="cp_xScale_%{#cpStatus.index}" name="bioMightComponents[%{#cpStatus.index}].Scale.XScale" size="2" theme="simple" onChange="javascript:alignCompValues('Scale', 'X', '%{#cpStatus.index}' );"></s:textfield>
								</td>
									
								<td>
									<s:textfield id="cp_yScale_%{#cpStatus.index}" name="bioMightComponents[%{#cpStatus.index}].Scale.YScale" size="2" theme="simple" onChange="javascript:alignCompValues('Scale', 'Y', '%{#cpStatus.index}' );"></s:textfield>
								</td>							
								
								<td>
									<s:textfield id="cp_zScale_%{#cpStatus.index}" name="bioMightComponents[%{#cpStatus.index}].Scale.ZScale" size="2" theme="simple" onChange="javascript:alignCompValues('Scale', 'Z', '%{#cpStatus.index}' );"></s:textfield>
								</td>		
						
								<td>&nbsp;</td>
						
								<td>
									<s:textfield id="cp_xAxis_%{#cpStatus.index}" name="bioMightComponents[%{#cpStatus.index}].Orientation.XAxis" size="2" theme="simple" onChange="javascript:alignCompValues('Orientation', 'X', '%{#cpStatus.index}' );"></s:textfield>
								</td>
								
								<td>
									<s:textfield id="cp_yAxis_%{#cpStatus.index}" name="bioMightComponents[%{#cpStatus.index}].Orientation.YAxis" size="2" theme="simple" onChange="javascript:alignCompValues('Orientation', 'Y', '%{#cpStatus.index}' );"></s:textfield>
								</td>
								
								<td>
									<s:textfield id="cp_zAxis_%{#cpStatus.index}" name="bioMightComponents[%{#cpStatus.index}].Orientation.ZAxis" size="2" theme="simple" onChange="javascript:alignCompValues('Orientation', 'Z', '%{#cpStatus.index}' );"></s:textfield>
								</td>
		
								<td>
									<s:textfield id="cp_Degrees_%{#cpStatus.index}" name="bioMightComponents[%{#cpStatus.index}].Orientation.degrees" size="2" theme="simple" onChange="javascript:alignCompValues('Orientation', 'DEGREES', '%{#cpStatus.index}' );"></s:textfield>
								</td>
		
				
								<tr class='footer6'>
										<td>&nbsp;</td>
										<td>Start</td>
										<td>End</td>  
										<td>&nbsp;</td>
										<td>Start</td>
										<td>Start</td>
										<td>Start</td>
										<td>&nbsp;</td>
										<td>End</td>
										<td>End</td>
										<td>End</td>  								
										<td>&nbsp;</td>  
										<td>Start</td>
										<td>Start</td>  
										<td>Start</td>	  
										<td>&nbsp;</td>  
										<td>End</td>
										<td>End</td>  
										<td>End</td>	
										<td>&nbsp;</td> 
										<td>Start</td>
										<td>Start</td>  
										<td>Start</td>
										<td>Start</td>						 		  
										<td>&nbsp;</td> 
										<td>End</td>
										<td>End</td>  
										<td>End</td>
										<td>End</td>					
										<td>&nbsp;</td>
										<td>POV</td> 		
										<td>POV</td> 	
									</tr>
									
								<tr class='footer6'>
										<td>&nbsp;</td>
										<td>Time</td>
										<td>Time</td>  
										<td>&nbsp;</td>
										<td>xPos</td>
										<td>yPos</td>
										<td>zPos</td>
										<td>&nbsp;</td>
										<td>xPos</td>
										<td>yPos</td>
										<td>zPos</td>  								
										<td>&nbsp;</td>  
										<td>xScale</td>
										<td>yScale</td>  
										<td>zScale</td>	  
										<td>&nbsp;</td>  
										<td>xScale</td>
										<td>yScale</td>  
										<td>zScale</td>	
										<td>&nbsp;</td> 
										<td>Roll <IMG src="images/UDArrow.jpg" height=15 width=10></td>
										<td>Pitch <IMG src="images/FBArrow.jpg" height=15 width=11></td>  
										<td>Yaw <IMG src="images/LRArrow.jpg" height=12 width=15></td>
										<td>Degrees</td>						 		  
										<td>&nbsp;</td> 
										<td>Roll <IMG src="images/UDArrow.jpg" height=15 width=10></td>
										<td>Pitch <IMG src="images/FBArrow.jpg" height=15 width=11></td>   
										<td>Yaw <IMG src="images/LRArrow.jpg" height=12 width=15></td>
										<td>Degrees</td>					
										<td>&nbsp;</td>
										<td>POV</td> 		
										<td>POV</td> 	
									</tr>
							
							
									<s:iterator value="bioMightAnimations" var="cpAnims" status="cpAnimStatus">
							
									<tr>				
											<td>
												&nbsp;&nbsp;&nbsp;<a href="javascript:setProperty('${animationName}', 'Head', 'Head', 'Head', 'Head', 'Head');"><IMG src="images/anicon.jpg" height=30 border="0"></a>
												<s:hidden name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].animationName" value="%{animationName}"/>
																
											</td>
											
											<td>
												<s:textfield 
												 id="cp_StartTime_%{#cpStatus.index}_%{#cpAnimStatus.index}"  
												 name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].StartTime" size="2" theme="simple" 
												 onChange="javascript:alignTimeValues('cp', 'Start', '%{#cpStatus.index}', '%{#cpAnimStatus.index}' );"></s:textfield>
											</td>
			
											<td>
												<s:textfield 
												id="cp_EndTime_%{#cpStatus.index}_%{#cpAnimStatus.index}" 
												name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].EndTime" size="2" theme="simple"
												onChange="javascript:alignTimeValues('cp', 'End', '%{#cpStatus.index}', '%{#cpAnimStatus.index}' );" ></s:textfield>
											</td>
											
											<td>&nbsp;</td> 
											
											<td>
												<s:textfield
												id="cp_StartXPos_%{#cpStatus.index}_%{#cpAnimStatus.index}"  
												name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].StartPosition.XPos" size="2" theme="simple" 
												onChange="javascript:alignSEValues('cp', 'StartPos', 'X',  '%{#cpStatus.index}', '%{#cpAnimStatus.index}' );"></s:textfield>
											</td>
								
											<td>
												<s:textfield
												id="cp_StartYPos_%{#cpStatus.index}_%{#cpAnimStatus.index}"   
												name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].StartPosition.YPos" size="2" theme="simple" 
												onChange="javascript:alignSEValues('cp', 'StartPos', 'Y',  '%{#cpStatus.index}', '%{#cpAnimStatus.index}' );"></s:textfield>
											</td>			
											
											<td>
												<s:textfield 
												id="cp_StartZPos_%{#cpStatus.index}_%{#cpAnimStatus.index}"  
												name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].StartPosition.ZPos" size="2" theme="simple" 
												onChange="javascript:alignSEValues('cp', 'StartPos', 'Z',  '%{#cpStatus.index}', '%{#cpAnimStatus.index}' );"></s:textfield>
											</td>
					
											<td>&nbsp;</td>
											
											
											<td>
												<s:textfield
												id="cp_EndXPos_%{#cpStatus.index}_%{#cpAnimStatus.index}"  
												name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].EndPosition.XPos" size="2" theme="simple" 
												onChange="javascript:alignSEValues('cp', 'EndPos', 'X', '%{#cpStatus.index}', '%{#cpAnimStatus.index}' );"></s:textfield>
											</td>
								
											<td>
												<s:textfield
												id="cp_EndYPos_%{#cpStatus.index}_%{#cpAnimStatus.index}"  
												name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].EndPosition.YPos" size="2" theme="simple" 
												onChange="javascript:alignSEValues('cp', 'EndPos', 'Y', '%{#cpStatus.index}', '%{#cpAnimStatus.index}' );"></s:textfield>
											</td>			
											
											<td>
												<s:textfield
												id="cp_EndZPos_%{#cpStatus.index}_%{#cpAnimStatus.index}"  
												name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].EndPosition.ZPos" size="2" theme="simple" 
												onChange="javascript:alignSEValues('cp', 'EndPos', 'Z', '%{#cpStatus.index}', '%{#cpAnimStatus.index}' );"></s:textfield>
											</td>
											
											<td>&nbsp;</td>
									
											<td>
												<s:textfield
												id="cp_StartXScale_%{#cpStatus.index}_%{#cpAnimStatus.index}"  
												name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].StartScale.XScale" size="2" theme="simple" 
												onChange="javascript:alignSEValues('cp', 'StartScale', 'X', '%{#cpStatus.index}', '%{#cpAnimStatus.index}' );"></s:textfield>
											</td>
								
											<td>
												<s:textfield
												id="cp_StartYScale_%{#cpStatus.index}_%{#cpAnimStatus.index}"   
												name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].StartScale.YScale" size="2" theme="simple" 
												onChange="javascript:alignSEValues('cp', 'StartScale', 'Y', '%{#cpStatus.index}', '%{#cpAnimStatus.index}' );"></s:textfield>
											</td>			
											
											<td>
												<s:textfield
												id="cp_StartZScale_%{#cpStatus.index}_%{#cpAnimStatus.index}"   
												name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].StartScale.ZScale" size="2" theme="simple" 
												onChange="javascript:alignSEValues('cp', 'StartScale', 'Z', '%{#cpStatus.index}', '%{#cpAnimStatus.index}' );"></s:textfield>
											</td>
											
											<td>&nbsp;</td>
											
											<td>
												<s:textfield
												id="cp_EndXScale_%{#cpStatus.index}_%{#cpAnimStatus.index}"   
												name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].EndScale.XScale" size="2" theme="simple" 
												onChange="javascript:alignSEValues('cp', 'EndScale', 'X', '%{#cpStatus.index}', '%{#cpAnimStatus.index}' );"></s:textfield>
											</td>
								
											<td>
												<s:textfield
												id="cp_EndYScale_%{#cpStatus.index}_%{#cpAnimStatus.index}"   
												name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].EndScale.YScale" size="2" theme="simple"
												onChange="javascript:alignSEValues('cp', 'EndScale', 'Y', '%{#cpStatus.index}', '%{#cpAnimStatus.index}' );"></s:textfield>
											</td>			
											
											<td>
												<s:textfield
												id="cp_EndZScale_%{#cpStatus.index}_%{#cpAnimStatus.index}"   
												name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].EndScale.ZScale" size="2" theme="simple"
												onChange="javascript:alignSEValues('cp', 'EndScale', 'Z', '%{#cpStatus.index}', '%{#cpAnimStatus.index}' );"></s:textfield>
											</td>
											
											<td>&nbsp;</td>
											
											<td>
												<s:textfield 
												id="cp_StartXOrient_%{#cpStatus.index}_%{#cpAnimStatus.index}"  
												name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].StartOrientation.XAxis" size="2" theme="simple" 
												onChange="javascript:alignSEValues('cp', 'StartOrient', 'X', '%{#cpStatus.index}', '%{#cpAnimStatus.index}' );"></s:textfield>
											</td>
								
											<td>
												<s:textfield
												id="cp_StartYOrient_%{#cpStatus.index}_%{#cpAnimStatus.index}"   
												name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].StartOrientation.YAxis" size="2" theme="simple" 
												onChange="javascript:alignSEValues('cp', 'StartOrient', 'Y', '%{#cpStatus.index}', '%{#cpAnimStatus.index}' );"></s:textfield>
											</td>			
											
											<td>
												<s:textfield
												id="cp_StartZOrient_%{#cpStatus.index}_%{#cpAnimStatus.index}"   
												name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].StartOrientation.ZAxis" size="2" theme="simple" 
												onChange="javascript:alignSEValues('cp', 'StartOrient', 'Z', '%{#cpStatus.index}', '%{#cpAnimStatus.index}' );"></s:textfield>
											</td>

											<td>
												<s:textfield 
												id="cp_StartDegreesOrient_%{#cpStatus.index}_%{#cpAnimStatus.index}"  
												name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].StartOrientation.degrees" size="2" theme="simple"
												onChange="javascript:alignSEValues('cp', 'StartOrient', 'DEGREES', '%{#cpStatus.index}', '%{#cpAnimStatus.index}' );"></s:textfield>
											</td>											
											
											<td>&nbsp;</td>
																															
				
											<td>
												<s:textfield
												id="cp_EndXOrient_%{#cpStatus.index}_%{#cpAnimStatus.index}"  
												name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].EndOrientation.XAxis" size="2" theme="simple"
												onChange="javascript:alignSEValues('cp', 'EndOrient', 'X', '%{#cpStatus.index}', '%{#cpAnimStatus.index}' );"></s:textfield>
											</td>
								
											<td>
												<s:textfield
												id="cp_EndYOrient_%{#cpStatus.index}_%{#cpAnimStatus.index}"  
												name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].EndOrientation.YAxis" size="2" theme="simple"
												onChange="javascript:alignSEValues('cp', 'EndOrient', 'Y', '%{#cpStatus.index}', '%{#cpAnimStatus.index}' );"></s:textfield>
											</td>			
											
											<td>
												<s:textfield
												id="cp_EndZOrient_%{#cpStatus.index}_%{#cpAnimStatus.index}"  
												name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].EndOrientation.ZAxis" size="2" theme="simple" 
												onChange="javascript:alignSEValues('cp', 'EndOrient', 'Z', '%{#cpStatus.index}', '%{#cpAnimStatus.index}' );"></s:textfield>
											</td>
	
											<td>
												<s:textfield
												id="cp_EndDegreesOrient_%{#cpStatus.index}_%{#cpAnimStatus.index}"   
												name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].EndOrientation.degrees" size="2" theme="simple"
												onChange="javascript:alignSEValues('cp', 'EndOrient', 'DEGREES', '%{#cpStatus.index}', '%{#cpAnimStatus.index}' );"></s:textfield>
											</td>	
							
											
									</tr>				
																		
									</s:iterator>	
												
								</s:iterator>				
											
							</s:if>
			
					<tr>				
						<td>
							<a href="javascript:bioMethods();"><img border="0" src="images/submit.gif"></A>
						</td>		
						<td>
							<a href="javascript:bioExport();"><img border="0" src="images/export.gif"></A>
						</td>	
					</tr>
											
				</table>
			
			
					
				</s:form>
			</div>


</td>
</TR>
</table>

</body>

</html>