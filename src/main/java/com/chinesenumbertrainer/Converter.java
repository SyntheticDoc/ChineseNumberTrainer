/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chinesenumbertrainer;

import java.util.ArrayList;

/**
 *
 * @author TheDoctor
 */
public class Converter {
    private static Converter instance;
    private static ConsoleHandler console;
    
    private String[] measureUnits = new String[] {"十", "百", "千", "万", "亿", "兆", "京", "垓", "秭", "穰", "沟", "涧", "正", "载"};
    private String[] singleNumerals = new String[] {"零", "一", "两", "三", "四", "五", "六", "七", "八", "九"};
    
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
    
    public String convertFromGermanToChinese_test(String n) {
	String result = "";
	
	ArrayList<String> quadruples = new ArrayList<>();
	int counter = 0;
	String temp = "";
	
	for(int i = n.length() - 1; i >= 0; i--) {
	    counter ++;
	    
	    if(counter == 4) {
		quadruples.add(temp);
		temp = new String();
		counter = 0;
	    } else {
		temp = n.charAt(i) + temp;
	    }
	}
	
	return result;
    }
    
    public String convertQuadrupleFromGermanToChinese(String n) {
	String result = "";
	
	
	
	return result;
    }
    
    // 两  兆  两  千  两  百  二  十  二  亿  两  千  两  百  二  十  二  万  两  千  两  百  二  十  二
    // 25  24 23  22  21 20  19  18  17 16  15  14 13  12  11 10  9   8   7  6   5  4   3   2   1
    public String convertFromGermanToChinese(String n) {
	String result = "";
	int curSignificance;
	int sigIndex = 0;
	int secondary_sigIndex = 0;
	boolean isLeadingZero = false;
	boolean inCurrentZeroField = false;
	
	if(n.equals("2222222")) {
	    System.out.println("Beep!");
	}
	
	for(int i = (n.length() - 1); i >= 0; i--) {
	    int curNum = n.charAt(i) - 48;
	    curSignificance = (n.length()) - i;
	    
	    if(curSignificance == 1) {
		if(curNum == 0) {
		    isLeadingZero = true;
		} else {
		    result = getSingleNumeral(curNum, true);
		}
	    } else if (curSignificance == 2) {
		if(curNum == 0) {
		    if(isLeadingZero) {
			// Skip this significance
		    } else {
			inCurrentZeroField = true;
		    }
		} else {
		    if(curNum == 1) {
			if(n.length() == 2) {
			    result = measureUnits[0] + result;
			} else {
			    result = getSingleNumeral(curNum, true) + measureUnits[0] + result;
			}
		    } else {
			result = getSingleNumeral(curNum, true) + measureUnits[0] + result;
		    }
		    inCurrentZeroField = false;
		    isLeadingZero = false;
		}
	    } else if (curSignificance == 3) {
		if(curNum == 0) {
		    if(isLeadingZero) {
			// Skip this significance
		    } else if(!inCurrentZeroField) {
			inCurrentZeroField = true;
		    }
		} else {
		    if(inCurrentZeroField) {
			result = singleNumerals[0] + result;
			inCurrentZeroField = false;
			isLeadingZero = false;
		    }
		    result = getSingleNumeral(curNum) + measureUnits[1] + result;
		}
	    } else if (curSignificance == 4) {
		if(curNum == 0) {
		    if(isLeadingZero) {
			// Skip this significance
		    } else if(!inCurrentZeroField) {
			inCurrentZeroField = true;
		    }
		} else {
		    if(inCurrentZeroField) {
			result = singleNumerals[0] + result;
			inCurrentZeroField = false;
			isLeadingZero = false;
		    }
		    result = getSingleNumeral(curNum) + measureUnits[2] + result;
		}
	    } else if (curSignificance == 5) {
		if(curNum == 0) {
		    if(isLeadingZero) {
			// Skip this significance
		    } else if(!inCurrentZeroField) {
			inCurrentZeroField = true;
		    }
		} else {
		    if(inCurrentZeroField) {
			result = singleNumerals[0] + result;
			inCurrentZeroField = false;
			isLeadingZero = false;
		    }
		    
		    if(n.length() > 5) {
			result = getSingleNumeral(curNum, true) + measureUnits[3] + result;
		    } else {
			result = getSingleNumeral(curNum) + measureUnits[3] + result;
		    }
		    
		    sigIndex = 3;
		}
	    } else if (curSignificance > 5) {
		if(curNum == 0) {
		    if(isLeadingZero) {
			// Skip this significance
		    } else if(!inCurrentZeroField) {
			inCurrentZeroField = true;
		    }
		} else {
		    if(inCurrentZeroField) {
			result = singleNumerals[0] + result;
			inCurrentZeroField = false;
			isLeadingZero = false;
		    }
		    
		    if((curSignificance - 1) % 4 == 0) {
			boolean isOneOrTenSignificance = false;
		
			if(n.length() > curSignificance) {
			    isOneOrTenSignificance = true;
			}
		
			result = getSingleNumeral(curNum, isOneOrTenSignificance) + result;
		    } else if((curSignificance - 2) % 4 == 0) {
			result = getSingleNumeral(curNum, true) + measureUnits[0] + result;
		    } else if((curSignificance - 3) % 4 == 0) {
			result = getSingleNumeral(curNum) + measureUnits[1] + result;
		    } else if((curSignificance - 4) % 4 == 0) {
			result = getSingleNumeral(curNum) + measureUnits[2] + result;
		    } else {
			sigIndex++;
			result = getSingleNumeral(curNum) + measureUnits[sigIndex] + result;
		    }
		}
	    }
	    
	    // console.cprintln("n.length = " + n.length() + ", i = " + i + ", curSignificance = " + curSignificance + ", curNum = " + curNum);
	    // console.cprintln("  curResult: " + result);
	}
	
	return result;
    }
    
    private String getSingleNumeral(int index) {
	return getSingleNumeral(index, false);
    }
    
    private String getSingleNumeral(int index, boolean isOneOrTenSignificance) {
	if(index == 2 && isOneOrTenSignificance) {
	    return "二";
	} else {
	    return singleNumerals[index];
	}
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
