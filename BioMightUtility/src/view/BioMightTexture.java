/*
 * Created on May 21, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package biomight.view;
import java.io.Serializable;

/**
 * @author SurferJim
 *
 * An object that represents a texture
 * 
 */

public class BioMightTexture implements Serializable {
	private int textureId;
	private String textureName;
	private String textureFile;
	private String textureData;
	

	public BioMightTexture() {

	}

	public BioMightTexture(int idIn, String nameIn) {
		textureId = idIn;
		textureName = nameIn;
		textureFile = textureName + ".png";
	}

	public BioMightTexture(int idIn, String nameIn, String fileIn) {
		textureId = idIn;
		textureName = nameIn;
		textureFile = fileIn;
	}

	public BioMightTexture(int idIn, String nameIn, String fileIn, String dataIn) {
		textureId = idIn;
		textureName = nameIn;
		textureFile = fileIn;
		textureData = dataIn;
	}
	
	
	public int getTextureId() {
		return textureId;
	}

	public void setTextureId(int textureId) {
		this.textureId = textureId;
	}

	public String getTextureName() {
		return textureName;
	}

	public void setTextureName(String textureName) {
		this.textureName = textureName;
	}

	public String getTextureFile() {
		return textureFile;
	}

	public void setTextureFile(String textureFile) {
		this.textureFile = textureFile;
	}

	public String getTextureData() {
		return textureData;
	}

	public void setTextureData(String textureData) {
		this.textureData = textureData;
	}
	
	
}
