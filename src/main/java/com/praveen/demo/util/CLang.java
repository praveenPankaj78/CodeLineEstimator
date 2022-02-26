package com.praveen.demo.util;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class CLang {
	
	private final String LANGUAGE = "C";
	private final String IMPORT = "#include";
	private final ArrayList<String> VARSYMBOLS = new ArrayList<String>(Arrays.asList("int", "char", "String", "byte", "float", "double", "long", "short", "bool"));
	private final String SINGLE_LINE_COMMENT_SYMBOL = "//";
	private final String MULTI_LINE_COMMENT_START = "/*";
	private final String MULTI_LINE_COMMENT_END	= "*/";
	
	public String getLANGUAGE() {
		return LANGUAGE;
	}
	public String getIMPORT() {
		return IMPORT;
	}
	public ArrayList<String> getVARSYMBOLS() {
		return VARSYMBOLS;
	}
	public String getSINGLE_LINE_COMMENT_SYMBOL() {
		return SINGLE_LINE_COMMENT_SYMBOL;
	}
	public String getMULTI_LINE_COMMENT_START() {
		return MULTI_LINE_COMMENT_START;
	}
	public String getMULTI_LINE_COMMENT_END() {
		return MULTI_LINE_COMMENT_END;
	}
	
	
	



}
