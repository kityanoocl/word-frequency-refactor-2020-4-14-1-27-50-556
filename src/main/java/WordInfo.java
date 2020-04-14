public class WordInfo {
    public static final String SPACE_DELIMITER = " ";
    private String word;
    private int wordCount;

    public WordInfo(String word, int wordCount) {
        this.word = word;
        this.wordCount = wordCount;
    }

    public String getWord() {
        return this.word;
    }

    public int getWordCount() {
        return this.wordCount;
    }

    @Override
    public String toString() {
        return this.getWord() + SPACE_DELIMITER + this.getWordCount();
    }
}
