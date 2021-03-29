import de.services.TranslationService;


module Tag1_03WeiteresJar {
	
	exports de.services;
	//opens de.bitmarck.amphibien;
	uses TranslationService;
	provides TranslationService with de.services.impl.TranslationServiceImpl;
}
