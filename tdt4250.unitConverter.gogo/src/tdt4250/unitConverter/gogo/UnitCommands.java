package tdt4250.unitConverter.gogo;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Component;
import tdt4250.unitConverter.api.Unit;

@Component(
		service = UnitCommands.class,
		property = {
				"osgi.command.scope=unit",
				"osgi.command.function=add"
		}
	)
public class UnitCommands {
	
	public void add(String longUnitName, String equation) {
		String shortUnitName = equation.substring(2,3);
		BundleContext bc = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		boolean isExistingUnit = false;
		try {
			for (ServiceReference<Unit> serviceReference : bc.getServiceReferences(Unit.class, null)) {
				Unit existingUnit = bc.getService(serviceReference);
				try {
					if (existingUnit.getShortName().equals(shortUnitName)){
						existingUnit.addEquation(equation);
						System.out.println("Equation " + equation + " added to unit " + longUnitName);
						isExistingUnit = true;
					}
				} finally {
					bc.ungetService(serviceReference);
				}
			}
		} catch (InvalidSyntaxException e) {
		}
		if (! isExistingUnit) {
			System.out.println("Unit " + "'" + longUnitName + "' is not registered");
		}
	}
}
