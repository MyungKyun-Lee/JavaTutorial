package _04_2For;

import java.util.HashMap;
import java.util.Map;

public class _99_sentent_test {
	// 두 문자열의 코사인 유사도를 계산하는 메서드
    public static double calculateCosineSimilarity(String text1, String text2) {
        // 첫 번째 문자열과 두 번째 문자열의 단어 빈도 수를 저장할 맵을 각각 생성
        Map<String, Integer> vector1 = getTermFrequencyMap(text1);
        Map<String, Integer> vector2 = getTermFrequencyMap(text2);

        // 벡터의 내적 계산
        double dotProduct = 0.0;
        for (String key : vector1.keySet()) {
            if (vector2.containsKey(key)) {
                dotProduct += vector1.get(key) * vector2.get(key);
            }
        }

        // 벡터의 크기 계산
        double magnitude1 = 0.0;
        for (int value : vector1.values()) {
            magnitude1 += Math.pow(value, 2);
        }
        magnitude1 = Math.sqrt(magnitude1);

        double magnitude2 = 0.0;
        for (int value : vector2.values()) {
            magnitude2 += Math.pow(value, 2);
        }
        magnitude2 = Math.sqrt(magnitude2);

        // 코사인 유사도 계산
        if (magnitude1 != 0.0 && magnitude2 != 0.0) {
            return dotProduct / (magnitude1 * magnitude2);
        } else {
            return 0.0;
        }
    }

    // 문자열에서 각 단어의 빈도를 계산하여 맵으로 반환하는 메서드
    private static Map<String, Integer> getTermFrequencyMap(String text) {
        Map<String, Integer> termFrequencyMap = new HashMap<>();
        String[] words = text.split("\\s+"); // 공백을 기준으로 문자열을 단어로 나눔

        for (String word : words) {
            word = word.toLowerCase(); // 소문자로 변환하여 대소문자 무시
            termFrequencyMap.put(word, termFrequencyMap.getOrDefault(word, 0) + 1);
        }
        return termFrequencyMap;
    }

	public static void main(String[] args) {
		String sentence1 = "I love programming in Java";
        String sentence2 = "Java programming is fun";

        double similarity = calculateCosineSimilarity(sentence1, sentence2);
        System.out.println("Cosine Similarity: " + similarity);

	}

}
