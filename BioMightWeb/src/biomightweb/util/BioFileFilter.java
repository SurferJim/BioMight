package biomightweb.util;

import java.io.File;
import java.io.FilenameFilter;

public class BioFileFilter implements FilenameFilter {
	private String filterClause = "";
	
	public BioFileFilter()
	{
	};

	public BioFileFilter(String filterStr)
	{
		filterClause = filterStr;
	};
	    
	public boolean accept(File dir, String name) {
		return name.startsWith(filterClause);
	}


	public String getFilterClause() {
		return filterClause;
	}


	public void setFilterClause(String filterClause) {
		this.filterClause = filterClause;
	}
	    
	    
}
