package tdt4250.unitConverter.kilogram;

import org.osgi.service.component.annotations.*;
import tdt4250.unitConverter.api.Unit;
import tdt4250.unitConverter.util.ConvertableUnit;

@Component(
		property = {
				ConvertableUnit.SHORT_UNIT_NAME + "=k",
				ConvertableUnit.CONVERSION_EQUATIONS + "=p=k*2.2 t=k*1000",
				ConvertableUnit.LONG_UNIT_NAME + "=kilogram"				
		}
		)
public class Kilogram extends ConvertableUnit implements Unit{

	// TODO: class provided by template

}
