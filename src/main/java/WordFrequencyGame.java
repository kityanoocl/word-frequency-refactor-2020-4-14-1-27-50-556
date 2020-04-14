import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyGame {

    private static final String SPACE_PATTERN = "\\s+";
    private static final String CALCULATE_ERROR = "Calculate Error";
    private static final String NEWLINE_DELIMITER = "\n";

    private static int compare(WordInfo firstWord, WordInfo secondWord) {
        return secondWord.getWordCount() - firstWord.getWordCount();
    }

    public String getResult(String sentence) {
        try {
            List<WordInfo> wordInfoList = getWordInfoList(sentence);
            return formatWordFrequencyResult(wordInfoList);
        } catch (Exception exception) {
            return CALCULATE_ERROR;
        }
    }

    private String formatWordFrequencyResult(List<WordInfo> wordInfoList) {
        StringJoiner wordFrequencyResult = new StringJoiner(NEWLINE_DELIMITER);
        wordInfoList.forEach(wordInfo -> wordFrequencyResult.add(wordInfo.toString()));
        return wordFrequencyResult.toString();
    }

    private List<WordInfo> getWordInfoList(String sentence) {
        List<String> words = Arrays.asList(sentence.split(SPACE_PATTERN));

        return words.stream().distinct().map(word -> new WordInfo(word, Collections.frequency(words, word)))
                .sorted(WordFrequencyGame::compare).collect(Collectors.toList());
    }
}
