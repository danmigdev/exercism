import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class HighScores {

    private List<Integer> highScores;

    public HighScores(List<Integer> highScores) {
        this.highScores = highScores;
    }

    List<Integer> scores() {
        return highScores;
    }

    Integer latest() {
        List<Integer> scores = new ArrayList<>(highScores);
        
		return scores.stream().reduce((a, b) -> b).get();
    }

    Integer personalBest() {
        return highScores.stream().max(Comparator.naturalOrder()).get();
    }

    List<Integer> personalTopThree() {
        List<Integer> scores = new ArrayList<>(highScores);
        scores.sort((a, b) -> b.compareTo(a));
        
        return scores.stream().limit(3).toList();
    }

}
