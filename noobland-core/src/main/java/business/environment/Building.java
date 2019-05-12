/**
 * 
 */
package business.environment;

/**
 * @author Martin Dostal
 * Building location
 */
public class Building extends Location {

	protected final BuildingEnum buildingType;
	
	/**
	 * 
	 */
	public Building(String code, String name, BuildingEnum buildingType) {
		super(code, name, PlaceEnum.BUILDING);
		this.buildingType = buildingType;
	}

}
