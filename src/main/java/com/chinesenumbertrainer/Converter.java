/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chinesenumbertrainer;

/**
 *
 * @author TheDoctor
 */
public class Converter {
    private static Converter instance;
    private static ConsoleHandler console;
    
    private String[] measureUnits = new String[] {"十", "百", "千", "万", "亿", "兆", "京", "垓", "秭", "穰", "沟", "涧", "正", "载"};
    private String[] singleNumerals = new String[] {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    
    private Converter(ConsoleHandler console) {
	this.console = console;
    }
    
    public static Converter getInstance(ConsoleHandler console) {
	if(instance == null) {
	    instance = new Converter(console);
	}
	
	return instance;
    }
    
    public String convertFromChineseToGerman(String n) {
	String result = "";
	
	for(int i = (n.length() - 1); i >= 0; i--) {
	    
	}
	
	return result;
    }
    
    public String convertFromGermanToChinese(String n) {
	String result = "";
	int curSignificance;
	int sigIndex = 0;
	int secondary_sigIndex = 0;
	boolean isLeadingZero = false;
	boolean inCurrentZeroField = false;
	boolean isCurrentZeroSet = false;
	
	for(int i = (n.length() - 1); i >= 0; i--) {
	    int curNum = n.charAt(i) - 48;
	    curSignificance = (n.length()) - i;
	    
	    if(curSignificance == 1) {
		if(curNum == 0) {
		    isLeadingZero = true;
		} else {
		    result = singleNumerals[curNum];
		}
	    } else if (curSignificance == 2) {
		if(curNum == 0) {
		    if(isLeadingZero) {
			// Skip this significance
		    } else if(!isCurrentZeroSet) {
			result = singleNumerals[curNum] + result;
			isCurrentZeroSet = true;
			inCurrentZeroField = true;
		    }
		} else {
		    if(curNum == 1) {
			result = measureUnits[0] + result;
		    } else {
			result = singleNumerals[curNum] + measureUnits[0] + result;
		    }
		    isCurrentZeroSet = false;
		    inCurrentZeroField = false;
		}
	    } else if (curSignificance == 3) {
		if(curNum == 0) {
		    if(isLeadingZero) {
			// Skip this significance
		    } else if(!isCurrentZeroSet) {
			result = singleNumerals[curNum] + result;
			isCurrentZeroSet = true;
			inCurrentZeroField = true;
		    }
		} else {
		    result = singleNumerals[curNum] + measureUnits[1] + result;
		    isCurrentZeroSet = false;
		    inCurrentZeroField = false;
		}
	    } else if (curSignificance == 4) {
		if(curNum == 0) {
		    if(isLeadingZero) {
			// Skip this significance
		    } else if(!isCurrentZeroSet) {
			result = singleNumerals[curNum] + result;
			isCurrentZeroSet = true;
			inCurrentZeroField = true;
		    }
		} else {
		    result = singleNumerals[curNum] + measureUnits[2] + result;
		    isCurrentZeroSet = false;
		    inCurrentZeroField = false;
		}
	    } else if (curSignificance == 5) {
		if(curNum == 0) {
		    if(isLeadingZero) {
			// Skip this significance
		    } else if(!isCurrentZeroSet) {
			result = singleNumerals[curNum] + result;
			isCurrentZeroSet = true;
			inCurrentZeroField = true;
		    }
		} else {
		    result = singleNumerals[curNum] + measureUnits[3] + result;
		    isCurrentZeroSet = false;
		    inCurrentZeroField = false;
		}
	    } else if (curSignificance > 5 && curSignificance < 8) {
		result = singleNumerals[curNum] + measureUnits[secondary_sigIndex] + result;
		secondary_sigIndex++;
	    }
	    
	    // console.cprintln("n.length = " + n.length() + ", i = " + i + ", curSignificance = " + curSignificance + ", curNum = " + curNum);
	    // console.cprintln("  curResult: " + result);
	}
	
	return result;
    }
    
    private int pow_int(int n, int exp) {
	if(exp == 0) {
	    return 1;
	}
	
	int result = n;
	
	for(int i = 1; i < exp; i++) {
	    result *= n;
	}
	
	return result;
    }
}
