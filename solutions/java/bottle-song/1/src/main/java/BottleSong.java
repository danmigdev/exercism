class BottleSong {

    private static final String[] words = {
        "No", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten"
    };
    
    String recite(int startBottles, int takeDown) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = startBottles; i > startBottles - takeDown; i--) {
            sb.append(String.format("%s green bottle%s hanging on the wall,\n", words[i], i == 1 ? "" : "s"));
            sb.append(String.format("%s green bottle%s hanging on the wall,\n", words[i], i == 1 ? "" : "s"));
            sb.append(String.format("And if %s green bottle should accidentally fall,\n", words[1].toLowerCase()));
            sb.append(String.format("There'll be %s green bottle%s hanging on the wall.\n\n", words[i - 1].toLowerCase(), i == 2 ? "" : "s"));
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

}