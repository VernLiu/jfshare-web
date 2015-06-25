package com.jfshare.common;

public class Env {

	public static final String JS_PATH = Config.getAppStringValue("js.path", "");
	public static final String JS_VERSION = Config.getAppStringValue("js.version", "");
	public static final String CSS_PATH = Config.getAppStringValue("css.path", "");
	public static final String CSS_VERSION = Config.getAppStringValue("css.version", "");
	public static final String SYSTEM_VERSION = Config.getAppStringValue("system.version", "");
	
}
