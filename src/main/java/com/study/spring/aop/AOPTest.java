package com.study.spring.aop;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.study.spring.aop.service.AService;
import com.study.spring.aop.service.BServiceImpl;

public class AOPTest extends AbstractDependencyInjectionSpringContextTests {
	
	private AService aService;
	
	private BServiceImpl bService;
	
	protected String[] getConfigLocations() {
		String[] configs = new String[] { "applicationContext.xml"};
		return configs;
	}
	
	
	/**
	 * 测试正常调用
	 */
	public void testCall()
	{
		System.out.println("SpringTest JUnit test");
		aService.fooA("JUnit test fooA");
		aService.barA();
		bService.fooB();
		bService.barB("JUnit test barB",0);
	}
	
	/**
	 * 测试After-Throwing
	 */
	public void testThrow()
	{
		try {
			bService.barB("JUnit call barB",1);
		} catch (IllegalArgumentException e) {
			
		}
	}
	
	public void setAService(AService service) {
		aService = service;
	}
	
	public void setBService(BServiceImpl service) {
		bService = service;
	}
}