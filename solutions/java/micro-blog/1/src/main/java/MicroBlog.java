class MicroBlog {
    
    public String truncate(String input) {
        StringBuffer buffer = new StringBuffer();
        int counter = 5;
        int codePoint = 0;
        
        for (int i = 0; i < input.length(); i++) {
            codePoint = Character.codePointAt(input, i);
            
            if (Character.charCount(codePoint) == 2) {
                buffer.append(Character.toChars(codePoint));
                i++;
            }
            else {
                buffer.append(Character.toChars(codePoint));
            }

            counter--;
            
            if (counter == 0) {
                break;
            }
        }

        return buffer.toString();
    }
    
}
