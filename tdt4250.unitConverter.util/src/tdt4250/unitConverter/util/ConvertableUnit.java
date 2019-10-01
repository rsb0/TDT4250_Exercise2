package tdt4250.unitConverter.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tdt4250.unitConverter.api.Unit;
import org.osgi.service.component.annotations.*;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

@Component(
		configurationPid = ConvertableUnit.FACTORY_PID,
		configurationPolicy = ConfigurationPolicy.REQUIRE
		)
public class ConvertableUnit implements Unit {
	
	public static final String FACTORY_PID = "tdt4250.unitConverter.util.ConvertableUnit";
	
	public static final String SHORT_UNIT_NAME = "shortUnitName";
	public static final String CONVERSION_EQUATIONS = "conversionEquations";
	public static final String LONG_UNIT_NAME = "longUnitName";
	
	private String shortUnitName;
	private String longUnitName;
	private List<String> conversionEquations = new ArrayList<>();
	
	public @interface ConvertableUnitConfig {
		String shortUnitName();
		String conversionEquations() default "";
		String longUnitName();
	}
	
	@Activate
	public void activate(BundleContext bc, ConvertableUnitConfig config) {
		shortUnitName = config.shortUnitName();
		conversionEquations.addAll(Arrays.asList(config.conversionEquations().split(" ")));
		longUnitName = config.longUnitName();
		
	}
	@Override
	public String getShortName() {
		return shortUnitName;
	}
	@Override
	public String getLongName() {
		return longUnitName;
	}
	@Override
	public List<String> getEquations() {
		return conversionEquations;
	}
	@Override
	public void addEquation(String equation) {
		conversionEquations.add(equation);
	}
}
