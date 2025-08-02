import java.util.*;
import java.util.stream.*;

class Tournament {

    private Map<String, TeamResults> teamsMap = new HashMap<>();
    
    private static final int TEAM_WIDTH = 31;
    private static final int RESULT_WIDTH = 4;
    private static final String ROW_TEMPLATE = "%-31s|%3s |%3s |%3s |%3s |%3s\n";
    
    String printTable() {
        String header = String.format(ROW_TEMPLATE, "Team", "MP", "W", "D", "L", "P");
        String body = teamsMap.values().stream()
            .sorted(Comparator.comparing(TeamResults::getPoints).reversed().thenComparing(TeamResults::getName))
            .map(Object::toString).collect(Collectors.joining());

        return header + body;
    }

    void applyResults(String resultString) {
        Stream<String> stream = Arrays.stream(resultString.split("\n"));
        
        stream.forEach(line -> {
            String[] match = Arrays.stream(line.split(";")).toArray(String[]::new);

            TeamResults team = teamsMap.get(match[0]);
            TeamResults opponent = teamsMap.get(match[1]);
            String result = match[2];
            
            if (team == null) {
                team = new TeamResults(match[0]);
                teamsMap.put(match[0], team);
            }

            if (opponent == null) {
                opponent = new TeamResults(match[1]);
                teamsMap.put(match[1], opponent);
            }

            switch (result.toLowerCase()) {
                case "win":
                    team.addWon();
                    opponent.addLost();
                    break;
                    
                case "draw":
                    team.addDrawn();
                    opponent.addDrawn();
                    break;

                case "loss":
                    team.addLost();
                    opponent.addWon();
                    break;

                default:
            }
        });
    }

    private static class TeamResults {
        private static final int POINTS_WIN = 3;
        private static final int POINTS_DRAW = 1;
        private static final int POINTS_LOSS = 0;
        
        private String name;
        private int played;
        private int won;
        private int drawn;
        private int lost;

        public TeamResults(String name) {
            this.name = name;
        }

        public void addWon() {
            played++;
            won++;
        }

        public void addDrawn() {
            played++;
            drawn++;
        }

        public void addLost() {
            played++;
            lost++;
        }

        public int getPoints() {
            return (won * POINTS_WIN) + (drawn * POINTS_DRAW) + (lost * POINTS_LOSS);
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return String.format(ROW_TEMPLATE, name, played, won, drawn, lost, getPoints());
        }
    }
    
}
