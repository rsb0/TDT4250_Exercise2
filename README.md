# TDT4250 Exercise 2 Unit Converter

Exercise 2 in TDT4250 at Norwegian University of Science and Technology fall 2019

This project consists of 7 bundles

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
- Outside runtime: Add new component and set conversion equations for it by adding to the CONVERSION_EQUATION sting. E.g if adding 1 tonne = 1000kg write t=k*1000 in the Kilogram class' CONVERSION_EQUATION.
- In Runtime: interact with eclipse console when servlet is running to add conversion equations to a unit. E.g if adding conversion equation for converting between meters and cm type:
add "meter" "c=m*100".

## Query conversions:
open localhost:8080/conversion?q=<query> in browser. <query> is placeholder for query string. query string must be from_unit value to_unit. E.g to query converting for 10 meters to centimeters open localhost:8080/conversion?q=m10c
