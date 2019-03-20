package com.nt.config;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.nt.exceptionMapper.CustomExceptionMapper;

@ApplicationPath("/rest/*")
public class AppConfig extends Application {
	public AppConfig() {
	    System.out.println("AppConfig::0-param constructor");
	}
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> setClass=new HashSet<Class<?>>();
		setClass.add(CustomExceptionMapper.class);
		return setClass;
	}
	@Override
	public Map<String, Object> getProperties() {
		System.out.println("AppConfig::getProperties()");
		Map<String, Object> map = new HashMap<String, Object>();
		// set init-param name as key and value as package name
		map.put("jersey.config.server.provider.packages", "com.nt.resources");
		return map;
	}
}
