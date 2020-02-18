package biomight;
import java.io.Serializable;
import java.util.HashMap;



/**
 * @author SurferJim
 *
 * As we move from page to page, we need to determine what instances on the
 * objects in the database should be changed, and this is determined by the keys
 * that are contained here.
 */

public class BioMightKeys implements Serializable {
	private HashMap bioMightKeys;
	private int depth = 1;
	
	
	public BioMightKeys() {
		bioMightKeys = new HashMap();
	}
	
	public BioMightKey getKey(String componentRef) {
		BioMightKey key = (BioMightKey) bioMightKeys.get(componentRef);		
		return key;
	}
	
	public void setKey(BioMightKey key){
		String depthStr = depth+"";
		bioMightKeys.put(depthStr, key);
		depth++;
	}
	
}
