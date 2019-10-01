package tdt4250.unitConverter.api;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class Converter {
	
	private List<Unit> units = new ArrayList<>();
	
	public void addUnit(Unit unit) {
		units.add(unit);
	}
	
	public void removeUnit(Unit unit) {
		units.remove(unit);
	}
	
	//TODO: Implementer ferdig!
	public ConversionResult convert(String query) {	
		String longUnitName = "";
		String fromUnit = query.substring(0,1);
		String toUnit = query.substring(query.length() - 1);
		String value = query.substring(1, query.length() - 1);
		List<String> equations = null;	
		
		for (Unit unit : units) {
			if (unit.getShortName().equals(fromUnit)) {
				equations = unit.getEquations();
				longUnitName = unit.getLongName();
				break;
			}
		}
		
		if (equations == null) {
			return new ConversionResult(false, "incorrect left hand side argument");
		}
		
		for (String equation : equations) {
			if (equation.substring(0, 1).equals(toUnit)) {
				String math = value + equation.substring(3, equation.length());
				//perform calculation with javaSctipt engine from ScriptEngineManager
				ScriptEngineManager mgr = new ScriptEngineManager();
				ScriptEngine engine = mgr.getEngineByName("JavaScript");
				try {
					return new ConversionResult(true, "(" + longUnitName + ") " + value + fromUnit + "=" + engine.eval(math).toString() + toUnit);
				} catch(ScriptException e) {
					System.out.println("Error occured in ConversionSearchResults convert method trying to"
							+ "evaluate equation string with ScriptEngineManager" + e.getMessage());
				}
				
			}
		}
		return new ConversionResult(false, "The unit " + fromUnit + " does not have a converter for " + toUnit);
	}

}
