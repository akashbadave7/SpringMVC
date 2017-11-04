package com.bridgeit;

import java.beans.PropertyEditorSupport;

public class NameEditor extends PropertyEditorSupport{
	
	@Override
	public void setAsText(String fname)
	{
		if(fname.contains("Mr.") || fname.contains("Ms.")){
			setValue(fname);
		} else {
			fname = "Ms."+fname;
			setValue(fname);
		}
	}

}
