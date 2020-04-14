import java.util.*;

public class WordFrequencyGame {

    public static final String SPACE_PATTERN = "\\s+";
    public static final String CALCULATE_ERROR = "Calculate Error";
    public static final String SPACE_DELIMITER = " ";
    public static final String NEWLINE_DELIMITER = "\n";

    public String getResult(String sentence) {
        try {
            List<WordInfo> wordInfoList = getWordInfoList(sentence);

            return formatWordFrequencyResult(wordInfoList);
        } catch (Exception e) {
            return CALCULATE_ERROR;
        }
    }

    private String formatWordFrequencyResult(List<WordInfo> wordInfoList) {
        StringJoiner joiner = new StringJoiner(NEWLINE_DELIMITER);
        for (WordInfo wordInfo : wordInfoList) {
            String formatWordFrequencyResult = wordInfo.getWord() + SPACE_DELIMITER + wordInfo.getWordCount();
            joiner.add(formatWordFrequencyResult);
        }
        return joiner.toString();
    }

    private List<WordInfo> getWordInfoList(String sentence) {
        List<String> words = Arrays.asList(sentence.split(SPACE_PATTERN));

        List<WordInfo> wordInfoList = new ArrayList<>();
        for (String word : new HashSet<>(words)) {
            WordInfo wordInfo = new WordInfo(word, Collections.frequency(words, word));
            wordInfoList.add(wordInfo);
        }

        wordInfoList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());
        return wordInfoList;
    }

    private Map<String, List<WordInfo>> getListMap(List<WordInfo> wordInfoList) {
        Map<String, List<WordInfo>> map = new HashMap<>();
        for (WordInfo wordInfo : wordInfoList) {
//       map.computeIfAbsent(input.getValue(), k -> new ArrayList<>()).add(input);
            if (!map.containsKey(wordInfo.getWord())) {
                ArrayList arr = new ArrayList<>();
                arr.add(wordInfo);
                map.put(wordInfo.getWord(), arr);
            } else {
                map.get(wordInfo.getWord()).add(wordInfo);
            }
        }
        return map;
    }
}
