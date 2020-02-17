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
   					<td class="tableDataWelcome">
						<H2>BioMight Libraries - Dec 2015</H2>	
						<H3>Elements</H3>	
						The basic elements, such as Carbon, Hydrogen, Nitrogen, Oxygen, etc. found in the human body are available.
						Each element has electrons in an orbital configuration.  BioMight provides a nice set of models that can be
						used to teach your audience about atoms and how they are theorectically assembled.  Using BioMight's Pallete, you
						can assemble the elements into molecules and demonstrate molecular bonding.  In a future release, the 
						electrons will actively orbit the atomic core.
						
						<H3>Molecules</H3>	
						3D models of the twenty essential Amino Acids found in the human body are available for view on your
						standard browser or a device that supports X3D. BioMight provides a different perspective for recognizing
						the molecule's shape versus a textbook image, or ball and stick model.  Doing a presentation on the amino acids
						for a nutrition or biology web site? Use the might of BioMight to power your ideas and add interactive models to
						compliment your work. 
						
						<H3>BioAssemblies</H3>	
						Unfortunately an RNA molecule is not available at this time, but BioMight's DNA model is.  
						Drill down to the Nucleotides view and then use the 'actions' button to customize the
						chain by specifying a sequence of Nucleotides, for instance ACTGTTATAGCGCTAA. Add it to the
						palette and rotate it about the Y-axis to get a spinning DNA helix for your presentation, website,
						or classroom lesson.
						
						<H3>Viruses</H3>	
						Adenovirus, Bacteriophage, and Influenza viruses are currenntly available. Use the models in
						presentations on virology or immunology, or use to animate your life science website. 
						
						<H3>Bacteria</H3>	
						Strepococcus, Staphylcoccus, Meningococcus, and several other types of bacterial models are available.
						Present the 3D models to your audience as you describe differences between the different bacterial archetypes.
						
						<H3>Cells</H3>	
						BioMight makes available a standard Animal Cell model that contains ribsomes, golgi apparatus, peroxisomes, etc. 
						Cells from the immune system, red blood cells, and a neuron model are presented.  Drill down to the Cell Membrane
						and make use of BioMight's 'actions' feature to set its color.
						
						<H3>Tissues</H3>	
						No real components are available at this time.
						
						<H3>Organs</H3>	
						Most all organs are available easily recognizable.  BioMight needs a heart model.  
						
						<H3>Systems</H3>	
						The Digestive System is available for instructional use.  Most of the components of the Repiratory system as also
						accessible.  One can view a portion of the vasular system. Sorry, this library needs some work. 
						
						<H3>Body</H3>	
						This library provides a composite view of bones, muscles, and organs.  Bones and muscle models need to be made more appealing.
						
						<BR><BR><BR>  
						<B>If you need a particular model set up, contact me at BioMightOrg@gmail.com and I will try to make it my top
						priority.</B> 
					</td>
				</TR>	
													
				<TR>		
   					<td class="tableDataWelcome">
					
					  
						<BR><BR>
			      </td>
			   </TR>
							

 				   
					   
					    					   
					   
				<TR>
	      		 	<td class="tableDataCW">
			 			Copyright 2017 BioMight Inc.   Long Beach   New York 11561	 
	      			</td>   
   				</TR>
   					
			</TABLE>
 	</td>
 	</TR>
 </TABLE>
</div>
</body>
</html>
