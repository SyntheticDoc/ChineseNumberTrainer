/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chinesenumbertrainer;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author TheDoctor
 */
public class TestRunner {
    ConsoleHandler console;
    Converter converter;
    
    ArrayList<TestCase> testCases = new ArrayList<>();
    
    public TestRunner(ConsoleHandler console) {
	this.console = console;
	converter = Converter.getInstance(console);
	buildTestCases();
    }
    
    public boolean runAllTestCases(boolean verbose) {
	boolean globalTestResult = true;
	
	for(TestCase t : testCases) {
	    if(!runTestCase(t, verbose)) {
		globalTestResult = false;
	    }
	}
	
	return globalTestResult;
    }
    
    private boolean runTestCase(TestCase testCase, boolean verbose) {
	String convertedChineseNumber = converter.convertFromGermanToChinese(testCase.getGermanNumber());
	// String convertedGermanNumber = converter.convertFromChineseToGerman(testCase.getChineseNumber());
	
	console.cprintln("TESTRUNNER: Testing " + testCase.getGermanNumber() + " / " + testCase.getChineseNumber() + "...");
	System.out.println("TESTRUNNER: Testing " + testCase.getGermanNumber() + " / " + testCase.getChineseNumber() + "...");
	
	if(!convertedChineseNumber.equals(testCase.getChineseNumber())) {
	    console.cerrprintln("TESTRUNNER: Conversion error for " + testCase.getGermanNumber() + ": Expected " +
		    testCase.getChineseNumber() + ", conversion result " + convertedChineseNumber);
	    System.out.println("TESTRUNNER: Conversion error for " + testCase.getGermanNumber() + ": Expected " +
		    testCase.getChineseNumber() + ", conversion result " + convertedChineseNumber);
	    return false;
	}
	
//	if(!convertedGermanNumber.equals(testCase.getGermanNumber())) {
//	    console.cerrprintln("TESTRUNNER: Conversion error for " + testCase.getChineseNumber() + ": Expected " +
//		    testCase.getGermanNumber() + ", conversion result " + convertedGermanNumber);
//	    System.out.println("TESTRUNNER: Conversion error for " + testCase.getChineseNumber() + ": Expected " +
//		    testCase.getGermanNumber() + ", conversion result " + convertedGermanNumber);
//	    return false
//	}

	return true;
    }
    
    private void buildTestCases() {
	testCases.add(new TestCase("1", "一"));
	testCases.add(new TestCase("2", "二"));
	testCases.add(new TestCase("3", "三"));
	testCases.add(new TestCase("4", "四"));
	testCases.add(new TestCase("5", "五"));
	testCases.add(new TestCase("6", "六"));
	testCases.add(new TestCase("7", "七"));
	testCases.add(new TestCase("8", "八"));
	testCases.add(new TestCase("9", "九"));
	testCases.add(new TestCase("10", "十"));
	testCases.add(new TestCase("11", "十一"));
	testCases.add(new TestCase("12", "十二"));
	testCases.add(new TestCase("13", "十三"));
	testCases.add(new TestCase("14", "十四"));
	testCases.add(new TestCase("15", "十五"));
	testCases.add(new TestCase("16", "十六"));
	testCases.add(new TestCase("17", "十七"));
	testCases.add(new TestCase("18", "十八"));
	testCases.add(new TestCase("19", "十九"));
	testCases.add(new TestCase("20", "二十"));
	testCases.add(new TestCase("23", "二十三"));
	testCases.add(new TestCase("30", "三十"));
	testCases.add(new TestCase("39", "三十九"));
	testCases.add(new TestCase("40", "四十"));
	testCases.add(new TestCase("44", "四十四"));
	testCases.add(new TestCase("50", "五十"));
	testCases.add(new TestCase("76", "七十六"));
	testCases.add(new TestCase("87", "八十七"));
	testCases.add(new TestCase("92", "九十二"));
	testCases.add(new TestCase("100", "一百"));
	testCases.add(new TestCase("101", "一百零一"));
	testCases.add(new TestCase("200", "两百"));
	testCases.add(new TestCase("202", "两百零二"));
	testCases.add(new TestCase("204", "两百零四"));
	testCases.add(new TestCase("305", "三百零五"));
	testCases.add(new TestCase("407", "四百零七"));
	testCases.add(new TestCase("506", "五百零六"));
	testCases.add(new TestCase("602", "六百零二"));
	testCases.add(new TestCase("701", "七百零一"));
	testCases.add(new TestCase("803", "八百零三"));
	testCases.add(new TestCase("909", "九百零九"));
	testCases.add(new TestCase("110", "一百一十"));
	testCases.add(new TestCase("111", "一百一十一"));
	testCases.add(new TestCase("210", "两百一十"));
	testCases.add(new TestCase("350", "三百五十"));
	testCases.add(new TestCase("480", "四百八十"));
	testCases.add(new TestCase("550", "五百五十"));
	testCases.add(new TestCase("632", "六百三十二"));
	testCases.add(new TestCase("777", "七百七十七"));
	testCases.add(new TestCase("853", "八百五十三"));
	testCases.add(new TestCase("999", "九百九十九"));
	testCases.add(new TestCase("1001", "一千零一"));
	testCases.add(new TestCase("1010", "一千零一十"));
	testCases.add(new TestCase("1019", "一千零二十"));
	testCases.add(new TestCase("1020", "一千零二十"));
	testCases.add(new TestCase("1100", "一千一百"));
	testCases.add(new TestCase("1101", "一千一百零一"));
	testCases.add(new TestCase("1234", "一千二百三十四"));
	testCases.add(new TestCase("2345", "两千三百四十五"));
	testCases.add(new TestCase("8765", "八千七百六十五"));
	testCases.add(new TestCase("9999", "九千九百九十九"));
	testCases.add(new TestCase("10000", "一万"));
	testCases.add(new TestCase("10001", "一万零一"));
	testCases.add(new TestCase("10010", "一万零一十"));
	testCases.add(new TestCase("10101", "一万零一百零一"));
	testCases.add(new TestCase("12000", "一万二"));
	testCases.add(new TestCase("13200", "一万三千两百"));
	testCases.add(new TestCase("56700", "五万六千七百"));
	testCases.add(new TestCase("234100", "二十三万四千一"));
	testCases.add(new TestCase("450000", "四十五万"));
	testCases.add(new TestCase("2", "二"));
	testCases.add(new TestCase("22", "二十二"));
	testCases.add(new TestCase("222", "两百二十二"));
	testCases.add(new TestCase("2222", "两千两百二十二"));
	testCases.add(new TestCase("22222", "两万两千两百二十二"));
	testCases.add(new TestCase("222222", "二十二万两千两百二十二"));
	testCases.add(new TestCase("2222222", "两百二十二万两千两百二十二"));
	testCases.add(new TestCase("22222222", "两千两百二十二万两千两百二十二"));
	testCases.add(new TestCase("222222222", "两亿两千两百二十二万两千两百二十二"));
	testCases.add(new TestCase("2222222222", "二十二亿两千两百二十二万两千两百二十二"));
	testCases.add(new TestCase("22222222222", "两百二十二亿两千两百二十二万两千两百二十二"));
	testCases.add(new TestCase("222222222222", "两千两百二十二亿两千两百二十二万两千两百二十二"));
	testCases.add(new TestCase("2222222222222", "两兆两千两百二十二亿两千两百二十二万两千两百二十二"));
    }
    
    @Setter
    @Getter
    private class TestCase {
	private String germanNumber;
	private String chineseNumber;
	
	public TestCase(String germanNumber, String chineseNumber) {
	    this.germanNumber = germanNumber;
	    this.chineseNumber = chineseNumber;
	}
    }
}
