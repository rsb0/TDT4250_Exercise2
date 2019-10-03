# TDT4250 Exercise 2 Unit Converter

Exercise 2 in TDT4250 at The Norwegian University of Science and Technology, fall 2019

This project consists of 7 Bdn OSGi projects but, can be expanded by adding more unit components:

## TDT4250.unitConverter.api
Classes:
- Converter: Contains a list of Unit classes and a method for converting from one unit to another.
- ConversionResult: Makes all conversion come return in the same format.
- Unit: Interface for units

## TDT4250.unitConverter.util
Classes: 
- ConvertableUnit: Concrete method of the Unit interface. Every instance of this class contains a List<String> with equations to convert from this unit to another. When searching for a conversion result it will  look up these lists to find appropriate conversion equations Used for creating new conversion equations for Unit components in runtime through the gogo shell.

## TDT4250.unitConverter.servlet
Classes:
- ConversionServlet: Servlet component. Entrance point for the application. Also handles input from the user and outputing results. 

## TDT4250.unitConverter.gogo
Classes:
- UnitCommands: Defines method for adding new conversion equations to existing units

## TDT4250.unitConverter.celsius TDT4250.unitConverter.kilogram TDT4250.unitConverter.meter
Concrete units that extends ConvertableUnit and implements the Unit interface. 


# Instructions for operating:

## Launch application: 
Open the launch.bndrun file in TDT4250.unitConverter.servlet, make sure celsius, kilogram and meter is added to Run Requirements, resolve and Run OSGi.

## Add unit components:
create new Bnd OSGi Project, and create a class for your unit. Make it extend ConvertableUnit and implement Unit. Annotate with @Comonent over class declarization and set properties SHORT_UNIT_NAME, LONG_UNIT_NAME and add conversion equations by listing them  separated by space in CONVERSION_EQUATIONS.

## Add conversions in runtime/designtime:
- Outside runtime: Create a new unit-component. A unit class must be annotated with @Component directly before access modifier and class name at the top of the file. The @Component annotation must have properties:
property = {
				ConvertableUnit.SHORT_UNIT_NAME + "",
				ConvertableUnit.CONVERSION_EQUATIONS + "=",
				ConvertableUnit.LONG_UNIT_NAME + "="
				}
		).
When creating a new unit all these properties must be set. SHORT NAME is a unit abriviation such as "m" for meter. SHORT NAME must be one charracter. CONVERSION_EQUATION must be one or more conversion equations separated by space. 
E.g if addingt the conversion 1 tonne = 1000kg write t=k*1000 in the Kilogram class' CONVERSION_EQUATION.
LONG_UNIT_NAME is a unit's proper name such as "meter" etc.

- In Runtime: interact with eclipse console when servlet is running to add conversion equations to an excisting unit by writing the unit's LONG_UNIT_NAME followed by a conversion equation separated with a spcae. The conversion equation should have the unit you want to convert to on the left hand side, and the unit you're converting from as the first thing on the right hand side. Both units in the equation must be one charracter.

E.g if adding conversion equation for converting between meters and cm type:
g! add "meter" "c=m*100".
This only works for units that exists as a component.

## Query conversions:
open localhost:8080/conversion?q=<query> in browser. <query> is placeholder for query string. Format of the query string must be 

<from_unit><value><to_unit>. 

E.g to convert 10 meters to centimeters open localhost:8080/conversion?q=m10c
  
