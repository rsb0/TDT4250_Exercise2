package tdt4250.unitConverter.celsius;

import org.osgi.service.component.annotations.Component;
import tdt4250.unitConverter.util.ConvertableUnit;
import tdt4250.unitConverter.api.Unit;

@Component(
		property = {
				ConvertableUnit.SHORT_UNIT_NAME + "=c",
				ConvertableUnit.CONVERSION_EQUATIONS + "=f=c*1.8+32 k=c+273.15",
				ConvertableUnit.LONG_UNIT_NAME + "=celsius"
				}
		)
public class Celsius extends ConvertableUnit implements Unit{
}
