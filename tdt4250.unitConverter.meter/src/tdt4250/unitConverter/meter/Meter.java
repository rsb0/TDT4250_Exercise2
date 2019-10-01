package tdt4250.unitConverter.meter;

import org.osgi.service.component.annotations.Component;
import tdt4250.unitConverter.util.ConvertableUnit;
import tdt4250.unitConverter.api.Unit;

@Component(
		property = {
				ConvertableUnit.SHORT_UNIT_NAME + "=m",
				ConvertableUnit.CONVERSION_EQUATIONS + "=k=m*0.001 f=m*3.28 m=c*100",
				ConvertableUnit.LONG_UNIT_NAME + "=meter"
				}
		)
public class Meter extends ConvertableUnit implements Unit{
}
