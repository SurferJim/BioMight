

<s:if test="%{bioMightComponents != null}">

	<s:iterator value="bioMightComponents" var="cps" status="cpStatus">
			
		<tr class='footer2'>
				<td>&nbsp;</td>
				<td>zPos</td>
				<td>yPos</td>
					<td>zPos</td>
				<td>&nbsp;</td>  
				<td>xScale</td>
				<td>yScale</td>  
				<td>zScale</td>	  
				<td>&nbsp;</td> 
				<td>Roll</td>
				<td>Pitch</td>  
				<td>Yaw</td>
				<td>Degrees</td>		        
		</tr>	 		
		
		<tr class='divvyBar'>				
			<td >
			<a href="javascript:deleteComponent(${bioComponentsStatus.index}, '${bioMightComponentName}', 'Head', 'Head', 'Head', 'Head');"><img border="0" src="images/delete.gif"></A>
			<a href="javascript:setProperty('${bioMightComponentName}', 'Head', 'Head', 'Head', 'Head', 'Head');"><IMG  height=30 border="0">${bioMightComponentName}</a>				
		</td>
						
								
		<td>
			<s:textfield id="cp_xPos" name="bioMightComponents[%{#cpStatus.index}].position.XPos" size="2" theme="simple"></s:textfield>
		</td>
			
		<td>
			<s:textfield id="cp_yPos" name="bioMightComponents[%{#cpStatus.index}].position.YPos" size="2" theme="simple"></s:textfield>
		</td>							
		
		<td>
			<s:textfield id="cp_zPos" name="bioMightComponents[%{#cpStatus.index}].position.ZPos" size="2" theme="simple"></s:textfield>
		</td>
		
		
		<td>&nbsp;</td>
		
		<td>
			<s:textfield id="cp_xScale" name="bioMightComponents[%{#cpStatus.index}].scale.ZScale" size="2" theme="simple"></s:textfield>
		</td>
			
		<td>
			<s:textfield id="cp_yScale" name="bioMightComponents[%{#cpStatus.index}].scale.ZScale" size="2" theme="simple"></s:textfield>
		</td>							
		
		<td>
			<s:textfield id="cp_zScale" name="bioMightComponents[%{#cpStatus.index}].scale.ZScale" size="2" theme="simple"></s:textfield>
		</td>		

		<td>&nbsp;</td>

		<td>
			<s:textfield id="cp_xAxis" name="bioMightComponents[%{#cpStatus.index}].orientation.XAxis}" size="2" theme="simple"></s:textfield>
		</td>
			
		<td>
			<s:textfield id="cp_yAxis" name="bioMightComponents[%{#cpStatus.index}].orientation.YAxis}" size="2" theme="simple"></s:textfield>
		</td>							
		
		<td>
			<s:textfield id="cp_zAxis" name="bioMightComponents[%{#cpStatus.index}].orientation.ZAxis}" size="2" theme="simple"></s:textfield>
		</td>		

		<td>
			<s:textfield id="cp_degrees" name="bioMightComponents[%{#cpStatus.index}].orientation.degree}" size="2" theme="simple"></s:textfield>
		</td>
			
		</tr>
			
		<tr class='footer6'>
				<td>&nbsp;</td>
				<td>Start</td>
				<td>End</td>  
				<td>&nbsp;</td>
				<td>zPos</td>
				<td>yPos</td>
				<td>zPos</td>
				<td>&nbsp;</td>
				<td>zPos</td>
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
				<td>Roll</td>
				<td>Pitch</td>  
				<td>Yaw</td>
				<td>Degrees</td>						 		  
				<td>&nbsp;</td> 
				<td>Roll</td>
				<td>Pitch</td>  
				<td>Yaw</td>
				<td>Degrees</td>					
				<td>&nbsp;</td>
				<td>POV</td> 		
				<td>POV</td> 	
			</tr>
	

			<s:iterator value="bioMightAnimations" var="cpAnims" status="cpAnimStatus">
			
				<tr>				
					<td>
						&nbsp;&nbsp;&nbsp;<a href="javascript:setProperty('${animationName}', 'Head', 'Head', 'Head', 'Head', 'Head');"><IMG src="images/anicon.jpg" height=30 border="0"></a>				
					</td>
					
							
					<td>
						<s:textfield 
						name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].startTime" size="2" theme="simple"></s:textfield>
					</td>
					
					<td>
						<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].endTime" size="2" theme="simple"></s:textfield>
					</td>
					
					<td>&nbsp;</td>
					
					<td>
						<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].startPosition.XPos" size="2" theme="simple"></s:textfield>
					</td>
		
					<td>
						<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].startPosition.YPos" size="2" theme="simple"></s:textfield>
					</td>			
					
					<td>
						<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].startPosition.ZPos" size="2" theme="simple"></s:textfield>
					</td>
					
					<td>&nbsp;</td>
					
					<td>
						<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].endPosition.XPos" size="2" theme="simple"></s:textfield>
					</td>
	
					<td>
						<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].endPosition.YPos" size="2"  theme="simple"></s:textfield>
					</td>
	
					<td>
						<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].endPosition.ZPos" size="2"  theme="simple"></s:textfield>
					</td>
					
							<td>&nbsp;</td>
							
							<td>
								<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].startScale.XScale" size="2" theme="simple"></s:textfield>
							</td>
				
							<td>
								<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].startScale.YScale" size="2" theme="simple"></s:textfield>
							</td>			
							
							<td>
								<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].startScale.ZScale" size="2" theme="simple"></s:textfield>
							</td>
							
							<td>&nbsp;</td>
							
							<td>
								<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].endScale.XScale" size="2" theme="simple"></s:textfield>
							</td>
			
							<td>
								<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].endScale.YScale" size="2"  theme="simple"></s:textfield>
							</td>
			
							<td>
								<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].endScale.ZScale" size="2"  theme="simple"></s:textfield>
							</td>
							
							<td>&nbsp;</td>
							<td>
								<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].startOrientation.XAxis" size="2"  theme="simple"></s:textfield>
							</td>
				
							<td>
								<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].startOrientation.YAxis" size="2"  theme="simple"></s:textfield>
							</td>			
							
							<td>
								<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].startOrientation.ZAxis" size="2"  theme="simple"></s:textfield>
							</td>	
					
							<td>
								<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].startOrientation.degrees" size="2"  theme="simple"></s:textfield>
							</td>
							
							<td>&nbsp;</td>
						
							<td>
								<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].endOrientation.XAxis" size="2"  theme="simple"></s:textfield>
							</td>
				
							<td>
								<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].endOrientation.YAxis" size="2"  theme="simple"></s:textfield>
							</td>			
							
							<td>
								<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].endOrientation.ZAxis" size="2" theme="simple"></s:textfield>
							</td>	
					
							<td>
								<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].EndOrientation.degrees" size="2"  theme="simple"></s:textfield>
							</td>
						
							<td>&nbsp;</td>
							
							<td>
								<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].fieldOfView" size="2"  theme="simple"></s:textfield>
							</td>
					
							<td>
								<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].fieldOfView" size="2"  theme="simple"></s:textfield>
							</td>
											
				</tr>		
			
		
			</s:iterator>
		
						
		</s:iterator>

		<tr>				
			<td>
				<a href="javascript:bioMethods();"><img border="0" src="images/submit.gif"></A>
			</td>		
		</tr>
					
	</s:if>

	
	
	
	
	
	
	
	
					<s:if test="%{bioMightViewPoints != null}">							
					
						<s:iterator value="bioMightViewPoints" var="vps" status="vpStatus">
							
							<tr class='footer2'>
								<td class="whiteSpace">&nbsp;</td>
								<td>xPos</td>
								<td>yPos</td>  
								<td>zPos</td>
								<td>&nbsp;</td>   
								<td>Roll</td>
								<td>Pitch</td>  
								<td>Yaw</td>
								<td>Degrees</td>	  
								<td>&nbsp;</td>
								<td>POV</td> 		
							</tr>
											
							<tr class='divvyBar'>				
								<td  class="whiteSpace">
									<a href="javascript:setProperty('${viewPointName}', 'Head', 'Head', 'Head', 'Head', 'Head');"><IMG src="images/camera.jpg" height=30 border="0"></a>					
								</td>				
								<td>
									<s:textfield id="vp_xPos" name="bioMightViewPoints[%{#vpStatus.index}].Position.XPos" size="2" tooltip="xPos"  theme="simple"></s:textfield>
								</td>	
								<td>
									<s:textfield id="vp_yPos" name="bioMightViewPoints[%{#vpStatus.index}].Position.YPos" size="2" theme="simple"></s:textfield>
								</td>
								<td>
									<s:textfield id="vp_zPos" name="bioMightViewPoints[%{#vpStatus.index}].Position.ZPos" size="2" theme="simple"></s:textfield>
								</td>						
								<td>&nbsp;</td>
								<td>
									<s:textfield id="vp_xAxis" name="bioMightViewPoints[%{#vpStatus.index}].Orientation.XAxis" size="2"  theme="simple"></s:textfield>
								</td>
								<td>
									<s:textfield id="vp_yAxis" name="bioMightViewPoints[%{#vpStatus.index}].Orientation.YAxis" size="2"  theme="simple"></s:textfield>
								</td>
								<td>
									<s:textfield id="vp_zAxis" name="bioMightViewPoints[%{#vpStatus.index}].Orientation.ZAxis" size="2"  theme="simple"></s:textfield>
								</td>
								<td>
									<s:textfield id="vp_degrees" name="bioMightViewPoints[%{#vpStatus.index}].orientation.degrees" size="2"  theme="simple"></s:textfield>
								</td>						 
								<td>&nbsp;</td>
									<td>
									<s:textfield id="vp_pov" name="bioMightViewPoints[%{#vpStatus.index}].FieldOfView" size="2" theme="simple"></s:textfield>
								</td>				
							</tr>
						
						
							<tr class='footer6'>
								<td class="whiteSpace">&nbsp;</td>
								<td>Start</td>
								<td>End</td>  
								<td>&nbsp;</td>
								<td>xPos</td>
								<td>yPos</td>
								<td>zPos</td>
								<td>&nbsp;</td>
								<td>zPos</td>
								<td>yPos</td>
								<td>zPos</td>  
								<td>&nbsp;</td> 
								<td>Roll</td>
								<td>Pitch</td>  
								<td>Yaw</td>	  
								<td>Degree</td>
								<td>&nbsp;</td> 
								<td>Roll</td>
								<td>Ptch</td>  
								<td>Yaw</td>
								<td>Degree</td>					
								<td>&nbsp;</td>
								<td>POV</td> 		
								<td>POV</td> 			        
							</tr>
					
							<s:iterator value="bioMightAnimations" var="vpAnims" status="vpAnimStatus">
								<tr>				
									<td>
										&nbsp;&nbsp;&nbsp;<a href="javascript:setProperty('${animationName}', 'Head', 'Head', 'Head', 'Head', 'Head');"><IMG src="images/anicon.jpg" height=30 border="0"></a>				
									</td>
										
									<td>
										<s:textfield id="vpAnim_startTime" 
										name="%{#var}.StartTime" size="2" theme="simple"></s:textfield>
									</td>
									
									<td>
										<s:textfield id="vpAnim_endTime" 
										name="%{#var}.EndTime" size="2" theme="simple"></s:textfield>
									</td>
									
									<td>&nbsp;</td>
									
									<td>
										<s:textfield id="vpAnim_startPosition_xPos" 
										name="%{#var}..XPos" size="2" theme="simple"></s:textfield>
									</td>
						
									<td>
										<s:textfield id="vpAnim_startPosition_yPos" 
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].StartPosition.YPos" size="2" theme="simple"></s:textfield>
									</td>			
									
									<td>
										<s:textfield id="vpAnim_startPosition_zPos" 
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].StartPosition.ZPos" size="2" theme="simple"></s:textfield>
									</td>
									
									<td>&nbsp;</td>
									
									<td>
										<s:textfield id="vpAnim_endPosition_xPos" 
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].EndPosition.XPos" 
										size="2" theme="simple"></s:textfield>
									</td>
					
									<td>
										<s:textfield id="vpAnim_endPosition_yPos" 
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].EndPosition.YPos" size="2"  theme="simple"></s:textfield>
									</td>
					
									<td>
										<s:textfield id="vpAnim_endPosition_zPos" 
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].EndPosition.ZPos" size="2"  theme="simple"></s:textfield>
									</td>
									
									<td>&nbsp;</td>
									
									<td>
										<s:textfield id="vpAnim_startOrientation_xAxis" 
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].StartOrientation.XAxis" size="2"  theme="simple"></s:textfield>
									</td>
						
									<td>
										<s:textfield id="vpAnim_startOrientation_yAxis" 
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].StartOrientation.YAxis" size="2"  theme="simple"></s:textfield>
									</td>			
									
									<td>
										<s:textfield id="vpAnim_startOrientation_zAxis" 
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].StartOrientation.ZAxis" size="2"  theme="simple"></s:textfield>
									</td>	
							
									<td>
										<s:textfield id="vpAnim_startOrientation_degrees" 
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].StartOrientation.degrees" size="2"  theme="simple"></s:textfield>
									</td>
									
									<td>&nbsp;</td>
								
									<td>
										<s:textfield id="vpAnim_endOrientation_xAxis" 
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].EndOrientation.XAxis" size="2"  theme="simple"></s:textfield>
									</td>
						
									<td>
										<s:textfield id="vpAnim_endOrientation_yAxis" 
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].EndOrientation.YAxis" size="2"  theme="simple"></s:textfield>
									</td>			
									
									<td>
										<s:textfield id="vpAnim_endOrientation_zAxis" 
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].EndOrientation.ZAxis" size="2" theme="simple"></s:textfield>
									</td>	
							
									<td>
										<s:textfield id="vpAnim_endOrientation_degrees" 
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].EndOrientation.degrees" size="2"  theme="simple"></s:textfield>
									</td>
								
									<td>&nbsp;</td>
									
									<td>
										<s:textfield id="vpAnim_fov1" 
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].FieldOfView" size="2"  theme="simple"></s:textfield>
									</td>
							
									<td>
										<s:textfield id="vpAnim_fov2" 
										name="bioMightViewPoints[%{#vpStatus.index}].bioMightAnimations[%{#vpAnimStatus.index}].FieldOfView" size="2"  theme="simple"></s:textfield>
									</td>
															
								</tr>				
							</s:iterator>
					
							
						</s:iterator>
					
						</s:if>
			
			
		
						<s:if test="%{bioMightComponents != null}">
						
							<s:iterator value="bioMightComponents" var="cps" status="cpStatus">
									
								<tr class='footer2'>
										<td>&nbsp;</td>
										<td>zPos</td>
										<td>yPos</td>
										<td>zPos</td>
										<td>&nbsp;</td>  
										<td>xScale</td>
										<td>yScale</td>  
										<td>zScale</td>	  
										<td>&nbsp;</td> 
										<td>Roll</td>
										<td>Pitch</td>  
										<td>Yaw</td>
										<td>Degrees</td>		        
								</tr>	 		
								
								<tr class='divvyBar'>				
									<td >
									<a href="javascript:deleteComponent('<s:property value="%{#cpStatus.index}"/>', '${bioMightComponentName}', 'Head', 'Head', 'Head', 'Head');"><img border="0" src="images/delete.gif"></A>
									<a href="javascript:setProperty('${bioMightComponentName}', 'Head', 'Head', 'Head', 'Head', 'Head');"><IMG  height=30 border="0">${bioMightComponentName}</a>				
								</td>
												
														
								<td>
									<s:textfield id="cp_xPos" name="bioMightComponents[%{#cpStatus.index}].position.XPos" size="2" theme="simple"></s:textfield>
								</td>
									
								<td>
									<s:textfield id="cp_yPos" name="bioMightComponents[%{#cpStatus.index}].position.YPos" size="2" theme="simple"></s:textfield>
								</td>							
								
								<td>
									<s:textfield id="cp_zPos" name="bioMightComponents[%{#cpStatus.index}].position.ZPos" size="2" theme="simple"></s:textfield>
								</td>
								
								
								<td>&nbsp;</td>
								
								<td>
									<s:textfield id="cp_xScale" name="bioMightComponents[%{#cpStatus.index}].scale.XScale" size="2" theme="simple"></s:textfield>
								</td>
									
								<td>
									<s:textfield id="cp_yScale" name="bioMightComponents[%{#cpStatus.index}].scale.YScale" size="2" theme="simple"></s:textfield>
								</td>							
								
								<td>
									<s:textfield id="cp_zScale" name="bioMightComponents[%{#cpStatus.index}].scale.ZScale" size="2" theme="simple"></s:textfield>
								</td>		
						
								<td>&nbsp;</td>
						
								<td>
									<s:textfield id="cp_xAxis" name="bioMightComponents[%{#cpStatus.index}].orientation.XAxis" size="2" theme="simple"></s:textfield>
								</td>
								
								<td>
									<s:textfield id="cp_xAxis" name="bioMightComponents[%{#cpStatus.index}].orientation.YAxis" size="2" theme="simple"></s:textfield>
								</td>
								
								<td>
									<s:textfield id="cp_xAxis" name="bioMightComponents[%{#cpStatus.index}].orientation.ZAxis" size="2" theme="simple"></s:textfield>
								</td>
		
								<td>
									<s:textfield id="cp_xAxis" name="bioMightComponents[%{#cpStatus.index}].orientation.degrees" size="2" theme="simple"></s:textfield>
								</td>
		
		
								<tr class='footer6'>
										<td>&nbsp;</td>
										<td>Start</td>
										<td>End</td>  
										<td>&nbsp;</td>
										<td>zPos</td>
										<td>yPos</td>
										<td>zPos</td>
										<td>&nbsp;</td>
										<td>zPos</td>
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
										<td>Roll</td>
										<td>Pitch</td>  
										<td>Yaw</td>
										<td>Degrees</td>						 		  
										<td>&nbsp;</td> 
										<td>Roll</td>
										<td>Pitch</td>  
										<td>Yaw</td>
										<td>Degrees</td>					
										<td>&nbsp;</td>
										<td>POV</td> 		
										<td>POV</td> 	
									</tr>
							
					
				
									<s:iterator value="bioMightAnimations" var="cpAnims" status="cpAnimStatus">
									
										<tr>				
											<td>
												&nbsp;&nbsp;&nbsp;<a href="javascript:setProperty('${animationName}', 'Head', 'Head', 'Head', 'Head', 'Head');"><IMG src="images/anicon.jpg" height=30 border="0"></a>				
											</td>
											
											<td>
												<s:textfield 
												name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].startTime" size="2" theme="simple"></s:textfield>
											</td>
			
											<td>
												<s:textfield 
												name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].endTime" size="2" theme="simple"></s:textfield>
											</td>
											
											<td>&nbsp;</td>
											
											<td>
												<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].startPosition.XPos" size="2" theme="simple"></s:textfield>
											</td>
								
											<td>
												<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].startPosition.YPos" size="2" theme="simple"></s:textfield>
											</td>			
											
											<td>
												<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].startPosition.ZPos" size="2" theme="simple"></s:textfield>
											</td>
					
											<td>&nbsp;</td>
											
											
											<td>
												<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].endPosition.XPos" size="2" theme="simple"></s:textfield>
											</td>
								
											<td>
												<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].endPosition.YPos" size="2" theme="simple"></s:textfield>
											</td>			
											
											<td>
												<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].endPosition.ZPos" size="2" theme="simple"></s:textfield>
											</td>
											
											<td>&nbsp;</td>
									
											<td>
												<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].startScale.XScale" size="2" theme="simple"></s:textfield>
											</td>
								
											<td>
												<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].startScale.YScale" size="2" theme="simple"></s:textfield>
											</td>			
											
											<td>
												<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].startScale.ZScale" size="2" theme="simple"></s:textfield>
											</td>
											
											<td>&nbsp;</td>
											
											<td>
												<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].endScale.XScale" size="2" theme="simple"></s:textfield>
											</td>
								
											<td>
												<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].endScale.YScale" size="2" theme="simple"></s:textfield>
											</td>			
											
											<td>
												<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].endScale.ZScale" size="2" theme="simple"></s:textfield>
											</td>
											
											<td>&nbsp;</td>
											
											<td>
												<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].startOrientation.XAxis" size="2" theme="simple"></s:textfield>
											</td>
								
											<td>
												<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].startOrientation.YAxis" size="2" theme="simple"></s:textfield>
											</td>			
											
											<td>
												<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].startOrientation.ZAxis" size="2" theme="simple"></s:textfield>
											</td>

											<td>
												<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].startOrientation.degrees" size="2" theme="simple"></s:textfield>
											</td>											
											
											<td>&nbsp;</td>
																															
				
											<td>
												<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].endOrientation.XAxis" size="2" theme="simple"></s:textfield>
											</td>
								
											<td>
												<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].endOrientation.YAxis" size="2" theme="simple"></s:textfield>
											</td>			
											
											<td>
												<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].endOrientation.ZAxis" size="2" theme="simple"></s:textfield>
											</td>

											<td>
												<s:textfield name="bioMightComponents[%{#cpStatus.index}].bioMightAnimations[%{#cpAnimStatus.index}].endOrientation.degrees" size="2" theme="simple"></s:textfield>
											</td>											
											
											<td>&nbsp;</td>
											
									</s:iterator>	
												
								</s:iterator>
											
											
							</s:if>
									
		
			
			
		<tr>				
			<td>
				<a href="javascript:bioMethods();"><img border="0" src="images/submit.gif"></A>
			</td>		
		</tr>