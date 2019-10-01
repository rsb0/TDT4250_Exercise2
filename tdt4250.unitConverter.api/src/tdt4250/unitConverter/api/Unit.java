package tdt4250.unitConverter.api;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface Unit {
	String getShortName();
	String getLongName();
	List<String> getEquations();
	void addEquation(String equation);
}