/**
 * 
 */
package data.persistence.xml;

import java.util.Map;	

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import business.Constants;
import business.creature.Ability;
import business.creature.AbilityScore;
import business.player.PlayerCharacter;

/**
 * @author Martin Dostál
 * Composer for transforming player character class into a xml document
 */
public class CharacterXmlComposer {

	/**
	 * 
	 */
	public CharacterXmlComposer() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Make a XML document from a PlayerCharacter object
	 * @param playerCharacter Character to transform
	 * @return XML document
	 */
	public Document compose (PlayerCharacter character) {
		Document doc = null;
		
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			// root elements
			doc = docBuilder.newDocument();
			Element rootElement = doc.createElement(Constants.CHARACTER_ROOT_NODE);
			doc.appendChild(rootElement);
			
			
			// general character element
			Element characterElem = doc.createElement(Constants.CHARACTER_NODE);
			rootElement.appendChild(characterElem);
			
			// set attributes to character element
			Attr attr = doc.createAttribute(Constants.NAME_ATTRIBUTE);
			attr.setValue(character.getName());
			characterElem.setAttributeNode(attr);
			
			attr = doc.createAttribute(Constants.UID_ATTRIBUTE);
			attr.setValue(String.valueOf(character.getUID()));
			characterElem.setAttributeNode(attr);
			
			attr = doc.createAttribute(Constants.RACE_ATTRIBUTE);
			attr.setValue(character.getRace().toString());
			characterElem.setAttributeNode(attr);
			
			attr = doc.createAttribute(Constants.LEVEL_ATTRIBUTE);
			attr.setValue(String.valueOf(character.getLevel()));
			characterElem.setAttributeNode(attr);
			
			
			// class element
			Element classElem = doc.createElement(Constants.CLASS_NODE);
			rootElement.appendChild(classElem);
			
			attr = doc.createAttribute(Constants.NAME_ATTRIBUTE);
			attr.setValue(character.getCharacterClass().getClassType().toString());
			classElem.setAttributeNode(attr);
			
			
			// abilities element
			Element abilitiesElem = doc.createElement(Constants.ABILITIES_NODE);
			rootElement.appendChild(abilitiesElem);
			
			// Iterate over all abilities and add rows for each with values as attributes
			for (Map.Entry<Ability, AbilityScore> ability : character.getAbilities().entrySet()) {
				String abilityName = ability.getKey().getName();
				AbilityScore value = ability.getValue();
				
				Element abilityElem = doc.createElement(Constants.ABILITY_NODE);
				abilitiesElem.appendChild(abilityElem);
				
				Attr nameAttr = doc.createAttribute(Constants.NAME_ATTRIBUTE);
				nameAttr.setValue(abilityName);
				abilityElem.setAttributeNode(nameAttr);
				
				Attr baseAttr = doc.createAttribute(Constants.BASE_ATTRIBUTE);
				baseAttr.setValue(String.valueOf(value.getBaseValue()));
				abilityElem.setAttributeNode(baseAttr);
			}
			
			
			// hitpoints element
			Element hpElem = doc.createElement(Constants.HITPOINTS_NODE);
			rootElement.appendChild(hpElem);
			
			Attr baseAttr = doc.createAttribute(Constants.BASE_ATTRIBUTE);
			baseAttr.setValue(String.valueOf(character.getHitpoints().getBasicHP()));
			hpElem.setAttributeNode(baseAttr);
			
			Attr currentAttr = doc.createAttribute(Constants.CURRENT_ATTRIBUTE);
			currentAttr.setValue(String.valueOf(character.getHitpoints().getCurrentHP()));
			hpElem.setAttributeNode(currentAttr);
			
			
			// inventory element
			Element inventoryElem = doc.createElement(Constants.INVENTORY_NODE);
			rootElement.appendChild(inventoryElem);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return doc;
	}
}
