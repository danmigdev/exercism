public class Twofer {

    private static final String SENTENCE_TEMPLATE = "One for <NAME>, one for me.";
    
    public String twofer(String name) {
        return SENTENCE_TEMPLATE.replace("<NAME>", coalesce(name, "you"));
    }

    private String coalesce(String source, String replacement) {
        return source == null ? replacement : source;
    }
    
}
