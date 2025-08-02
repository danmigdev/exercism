public class GameMaster {

    // TODO: define a 'describe' method that returns a description of a Character
    public String describe(Character character) {
        String templateDescription = "You're a level <LEVEL> <CLASS> with <HIT_POINTS> hit points.";

        return templateDescription
            .replaceFirst("<LEVEL>", String.valueOf(character.getLevel()))
            .replaceFirst("<CLASS>", character.getCharacterClass())
            .replaceFirst("<HIT_POINTS>", String.valueOf(character.getHitPoints()));
    }

    // TODO: define a 'describe' method that returns a description of a Destination
    public String describe(Destination destination) {
        String templateDescription = "You've arrived at <NAME>, which has <INHABITANTS> inhabitants.";
        
        return templateDescription
            .replace("<NAME>", destination.getName())
            .replace("<INHABITANTS>", String.valueOf(destination.getInhabitants()));
    }

    // TODO: define a 'describe' method that returns a description of a TravelMethod
    public String describe(TravelMethod travelMethod) {
        String templateDescription = "You're traveling to your destination <TRAVEL_METHOD>.";
        String prefix = "";
        
        switch (travelMethod) {
            case TravelMethod.WALKING:
                prefix = "by ";
                break;

            case TravelMethod.HORSEBACK:
                prefix = "on ";
                break;

            default:
        }

        return templateDescription.replace("<TRAVEL_METHOD>", prefix + travelMethod.toString().toLowerCase());
    }
    
    // TODO: define a 'describe' method that returns a description of a Character, Destination and TravelMethod
    public String describe(Character character, Destination destination, TravelMethod travelMethod) {
        return describe(character) + " " + describe(travelMethod) + " " + describe(destination);
    }
    
    // TODO: define a 'describe' method that returns a description of a Character and Destination
    public String describe(Character character, Destination destination) {
        return describe(character) + " " + describe(TravelMethod.WALKING) + " " + describe(destination);
    }
    
}
