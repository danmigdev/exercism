import java.util.*;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        return new HashSet<>(cards);
    }

    static boolean addCard(String card, Set<String> collection) {
        return collection.add(card);
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        return myCollection.isEmpty() ? false : 
            theirCollection.isEmpty() ? false : 
            theirCollection.containsAll(myCollection) ? false :
            myCollection.containsAll(theirCollection) ? false :
            !myCollection.equals(theirCollection);
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        Map<String, Integer> occurrencies = new HashMap<>();
        Set<String> cardsToReturn = new HashSet<>();
        
        for (Set<String> cardSet : collections) {
            for (String card : cardSet) {
                if (occurrencies.get(card) == null) {
                    occurrencies.put(card, 1);
                }
                else {
                    occurrencies.put(card, occurrencies.get(card) + 1);
                }
            }
        }

        for (String key : occurrencies.keySet()) {
            if (occurrencies.get(key) == collections.size()) {
                cardsToReturn.add(key);
            }
        }

        return cardsToReturn;
    }

    static Set<String> allCards(List<Set<String>> collections) {
    	Set<String> cardsToReturn = new HashSet<>();

    	collections.stream().forEach(cardsToReturn::addAll);
        
        return cardsToReturn;
    }
}
