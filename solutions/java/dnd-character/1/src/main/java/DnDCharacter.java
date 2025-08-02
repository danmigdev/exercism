import java.util.*;
import java.util.stream.*;

class DnDCharacter {

    int ability(List<Integer> scores) {
        List<Integer> mutableScores = new ArrayList<>(scores);
        
        if (mutableScores.size() > 0 && mutableScores.getFirst() < mutableScores.getLast()) {
            Collections.sort(mutableScores, Comparator.reverseOrder());
        }
        
        return mutableScores.stream().limit(DICE_TO_SELECT)
            .mapToInt(Integer::intValue)
            .sum();
    }

    List<Integer> rollDice() {
        return IntStream.range(1, DICE_TO_ROLL + 1)
            .mapToObj(i -> new Random().nextInt(DICE_FACES) + 1)
            .collect(Collectors.toList());
    }

    int modifier(int input) {
        return (int) Math.floor((input - 10) / 2.0);
    }

    int getStrength() {
        if (strength == null) {
            strength = ability(rollDice());
        }

        return strength;
    }

    int getDexterity() {
        if (dexterity == null) {
            dexterity = ability(rollDice()); 
        }

        return dexterity;
    }

    int getConstitution() {
        if (constitution == null) {
            constitution = ability(rollDice()); 
        }

        return constitution;
    }

    int getIntelligence() {
        if (intelligence == null) {
            intelligence = ability(rollDice());
        }

        return intelligence;
    }

    int getWisdom() {
        if (wisdom == null) {
            wisdom = ability(rollDice()); 
        }

        return wisdom;
    }

    int getCharisma() {
        if (charisma == null) {
            charisma = ability(rollDice());
        }

        return charisma;
    }

    int getHitpoints() {
        return INITIAL_HIT_POINTS + modifier(getConstitution());
    }

    private Integer strength;
    private Integer dexterity;
    private Integer constitution;
    private Integer intelligence;
    private Integer wisdom;
    private Integer charisma; 
    private static final int DICE_TO_SELECT = 3;
    private static final int DICE_TO_ROLL = 4;
    private static final int DICE_FACES = 6;
    private static final int INITIAL_HIT_POINTS = 10;
    
}
