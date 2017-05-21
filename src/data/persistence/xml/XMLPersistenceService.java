/**
 * 
 */
package data.persistence.xml;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import business.Config;
import business.Constants;
import business.combat.CombatAction;
import business.creature.Ability;
import business.creature.AbilityScore;
import business.creature.Hitpoints;
import business.creature.Monster;
import business.creature.MonsterRoleEnum;
import business.creature.Race;
import business.items.Weapon;
import business.player.PlayerCharacter;
import business.player.classes.*;
import data.persistence.PersistenceService;
import presentation.UserInteractionService;
import presentation.factory.PresentationServiceFactory;

/**
 * @author Martin Dostál
 *
 */
public class XMLPersistenceService implements PersistenceService {

	protected Config config = null;
	protected Properties appProperties = null;
	protected Properties messages = null;
	protected UserInteractionService ui = null;
	
	/**
	 * Default constructor
	 */
	public XMLPersistenceService() {
		config = Config.getInstance();
		appProperties = config.getApplicationProperties();
		messages = config.getMessages();
		ui = PresentationServiceFactory.getInstance().createUIService();
	}

	// =======================================================================================
	// =======================================================================================
	@Override
	public boolean saveGame(Object game) {
		// TODO Auto-generated method stub
		return false;
	}

	// =======================================================================================
	// =======================================================================================
	@Override
	public Object loadGame(UUID uid) {
		// TODO Auto-generated method stub
		return null;
	}

	// =======================================================================================
	// =======================================================================================
	@Override
	public boolean saveCharacter(PlayerCharacter character) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm");
		Date date = new Date();
		String fileName = character.getName() + "[" + dateFormat.format(date) + "].xml";
		
		String filePath = System.getProperty("user.dir") + "/saves/" + fileName;
		File file = new File(filePath);
		
		try {
			if (!file.exists()) {
				file.createNewFile();
				ui.print("Created new file at: " + filePath);
			}
			
			Document doc = new CharacterXmlComposer().compose(character);
						
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(file);
			
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);
			
			ui.print(messages.getProperty("data.savecharacter.success"));
			return true;
			
		} catch (TransformerException   e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}		
		
		return false;
	}

	// =======================================================================================
	// =======================================================================================
	@Override
	public PlayerCharacter loadCharacter() {
		PlayerCharacter character = null;
		String name = "";
		Race race = null;
		int level = 0;
		UUID uid = null;
		ClassFeature cf = null;
		HashMap<Ability, AbilityScore> abilities = new HashMap<Ability, AbilityScore>();
		Hitpoints hp = null;
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder builder;
			builder = factory.newDocumentBuilder();
			
			// @TODO change - this is only example
			String path = "file:///C:/_workspace/Eclipse_projects/Noobland/saves/Bob[02-03-2017-14-00].xml";
			
			Document doc = builder.parse(path);
	    	doc.getDocumentElement().normalize(); // normalization

	    	/*
	    	String fileName = file.getName();
	    	String dateStr = fileName.split("\\[")[1].split("\\]")[0];

	    	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-HH-mm");
	    	Date date = sdf.parse(dateStr);
	    	sdf.applyPattern("yyyy-MM-dd 'T' HH:mm");
	    	String formatDateStr = sdf.format(date);
	    	System.out.println("Formated date: [" + formatDateStr + "]\n");
	    	*/
	    	
	    	// Get root element
	    	Element rootElem = (Element)doc.getElementsByTagName(Constants.CHARACTER_ROOT_NODE).item(0);
	    	
	    	// Read from character element
	    	Element characterNode = (Element) rootElem.getElementsByTagName(Constants.CHARACTER_NODE).item(0);
	    	name = characterNode.getAttribute(Constants.NAME_ATTRIBUTE);
	    	race = Race.getRaceByName(characterNode.getAttribute(Constants.RACE_ATTRIBUTE));
	    	level = Integer.parseInt(characterNode.getAttribute(Constants.LEVEL_ATTRIBUTE));
	    	uid = UUID.fromString(characterNode.getAttribute(Constants.UID_ATTRIBUTE));
	    	
	    	
	    	// Read from class element
	    	Element classElement = (Element) rootElem.getElementsByTagName(Constants.CLASS_NODE).item(0);
	    	switch (classElement.getAttribute(Constants.NAME_ATTRIBUTE)) {
			case "Fighter":
				cf = new Fighter();
				break;

			case "Rogue":
				cf = new Rogue();
				break;

			case "Wizard":
				cf = new Wizard();
				break;

			case "Cleric":
				cf = new Cleric();
				break;

			default:
				System.out.println(messages.getProperty("er.loadcharacter.er1"));
				return null;
			}
	    	
	    	
	    	// Read from abilities node
	    	Element abilitiesElement = (Element) rootElem.getElementsByTagName(Constants.ABILITIES_NODE).item(0).getChildNodes();
	    	NodeList abilitiesNodes = abilitiesElement.getElementsByTagName(Constants.ABILITY_NODE);
	    	for (int i = 0; i < abilitiesNodes.getLength(); i++) {
	    		Element abilityElem = (Element) abilitiesNodes.item(i);
	    		AbilityScore ability = new AbilityScore(Ability.getAbilityByName(abilityElem.getAttribute(Constants.NAME_ATTRIBUTE)),
														Integer.parseInt(abilityElem.getAttribute(Constants.BASE_ATTRIBUTE)));
				abilities.put(ability.getAbility(), ability);
			}
	    	abilities = Race.adjustAbilityScores(abilities, race);
	    	
	    	
	    	// Read from hitpoints element
	    	Element hpElem = (Element) rootElem.getElementsByTagName(Constants.HITPOINTS_NODE).item(0);
	    	int baseHP = Integer.parseInt(hpElem.getAttribute(Constants.BASE_ATTRIBUTE));
	    	int currentHP = Integer.parseInt(hpElem.getAttribute(Constants.CURRENT_ATTRIBUTE));
	    	hp = cf.calculateHitpoints(level, abilities.get(Ability.CONSTITUTION).getModifier(), baseHP, false);
			hp.setCurrentHP(currentHP);
	    	
	    	// Read from inventory element
	    	// @TODO
	    	//Element inventoryElem = (Element) rootElem.getElementsByTagName(INVENTORY_NODE).item(0);
	    	
	    	character = new PlayerCharacter(name, race, cf, level, abilities, hp, uid);
	    	
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return character;
	}

	// =======================================================================================
	// =======================================================================================
	@Override
	public List<Weapon> loadWeapons() {
		ArrayList<Weapon> weapons = new ArrayList<Weapon>();
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder builder;
			builder = factory.newDocumentBuilder();
			
			String path = System.getProperty("user.dir") + appProperties.getProperty("weaponsSchemaPath");		
			
			Document doc = builder.parse(path);
	    	doc.getDocumentElement().normalize(); // normalization
	    	
	    	// Get document root element
	    	Element rootElem = (Element)doc.getElementsByTagName(Constants.WEAPONS_ROOT_NODE).item(0);
	    	
	    	// Read from weapons node
	    	NodeList weaponsNodes = rootElem.getElementsByTagName(Constants.WEAPON_NODE);
	    	for (int i = 0; i < weaponsNodes.getLength(); i++) {
	    		Element weaponElem = (Element) weaponsNodes.item(i);
	    		Weapon weapon = new Weapon(weaponElem.getAttribute(Constants.NAME_ATTRIBUTE), null, 
	    				Integer.parseInt(weaponElem.getAttribute(Constants.WEIGHT_ATTRIBUTE)), 
	    				Integer.parseInt(weaponElem.getAttribute(Constants.PRICE_ATTRIBUTE)), 
	    				Integer.parseInt(weaponElem.getAttribute(Constants.PROFICIENCY_ATTRIBUTE)),
	    				weaponElem.getAttribute(Constants.DAMAGE_ATTRIBUTE));
				weapons.add(weapon);
			}
		} catch (ParserConfigurationException | SAXException | IOException ex) {
			ex.printStackTrace();
		}
	    	
		return weapons;
	}

	// =======================================================================================
	// =======================================================================================
	@Override
	public List<Monster> loadMonsters() {
		ArrayList<Monster> monsters = new ArrayList<Monster>();
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder builder;
			builder = factory.newDocumentBuilder();
			
			String path = System.getProperty("user.dir") + appProperties.getProperty("monstersSchemaPath");		
			
			Document doc = builder.parse(path);
	    	doc.getDocumentElement().normalize(); // normalization
	    	
	    	// Get document root element
	    	Element rootElem = (Element)doc.getElementsByTagName(Constants.MONSTERS_ROOT_NODE).item(0);
	    		
	    	// Read from weapons node
	    	NodeList monsterNodes = rootElem.getElementsByTagName(Constants.MONSTER_NODE);
	    	for (int i = 0; i < monsterNodes.getLength(); i++) {
	    		Element monsterElem = (Element) monsterNodes.item(i);
	    		
	    		// Create a collection of combatActions
	    		List<CombatAction> combatActions = new ArrayList<CombatAction>();
	    		NodeList attackNodes = monsterElem.getElementsByTagName(Constants.ATTACK_NODE);
	    		for (int j = 0; j < attackNodes.getLength(); j++) {
	    			Element attackElem = (Element) attackNodes.item(j);
	    			CombatAction combatAction = new CombatAction(attackElem.getAttribute(Constants.NAME_ATTRIBUTE),
	    									   attackElem.getAttribute(Constants.HIT_ATTRIBUTE),
	    									   attackElem.getAttribute(Constants.DAMAGE_ATTRIBUTE));
	    			combatActions.add(combatAction);
	    		}
	    		
	    		// Create a collection of abilities
	    		HashMap<Ability, AbilityScore> abilities = new HashMap<Ability, AbilityScore>();
	    		
	    		AbilityScore ability = new AbilityScore(Ability.STRENGTH, 
	    				Integer.parseInt(monsterElem.getAttribute(Constants.STRENGTH_ATTRIBUTE)));
	    		abilities.put(Ability.STRENGTH, ability);
	    		
	    		ability = new AbilityScore(Ability.DEXTERITY, 
	    				Integer.parseInt(monsterElem.getAttribute(Constants.DEXTERITY_ATTRIBUTE)));
	    		abilities.put(Ability.DEXTERITY, ability);
	    		
	    		ability = new AbilityScore(Ability.CONSTITUTION, 
	    				Integer.parseInt(monsterElem.getAttribute(Constants.CONSTITUTION_ATTRIBUTE)));
	    		abilities.put(Ability.CONSTITUTION, ability);
	    		
	    		ability = new AbilityScore(Ability.INTELLIGENCE, 
	    				Integer.parseInt(monsterElem.getAttribute(Constants.INTELLIGENCE_ATTRIBUTE)));
	    		abilities.put(Ability.INTELLIGENCE, ability);
	    		
	    		ability = new AbilityScore(Ability.WISDOM, 
	    				Integer.parseInt(monsterElem.getAttribute(Constants.WISDOM_ATTRIBUTE)));
	    		abilities.put(Ability.WISDOM, ability);
	    		
	    		ability = new AbilityScore(Ability.CHARISMA, 
	    				Integer.parseInt(monsterElem.getAttribute(Constants.CHARISMA_ATTRIBUTE)));
	    		abilities.put(Ability.CHARISMA, ability);
	    		
	    		
	    		// Create a new Monster instance
	    		Monster monster = new Monster(monsterElem.getAttribute(Constants.NAME_ATTRIBUTE), null, 
	    				Integer.parseInt(monsterElem.getAttribute(Constants.LEVEL_ATTRIBUTE)),
	    				MonsterRoleEnum.getRoleByName(monsterElem.getAttribute(Constants.ROLE_ATTRIBUTE)), 
	    				Integer.parseInt(monsterElem.getAttribute(Constants.XP_REWARD_ATTRIBUTE)),
	    				Integer.parseInt(monsterElem.getAttribute(Constants.INITIATIVE_ATTRIBUTE)), 
	    				new Hitpoints(Integer.parseInt(monsterElem.getAttribute(Constants.HITPOINTS_NODE)), 0, 0),
	    				Integer.parseInt(monsterElem.getAttribute(Constants.ARMOR_CLASS_ATTRIBUTE)),
	    				abilities, combatActions);
	    		
	    		monsters.add(monster);	    		
			}
			
		} catch (ParserConfigurationException | SAXException | IOException ex) {
			ex.printStackTrace();
		}
		
		return monsters;
	}

}

