import java.util.*;

public class KelimeIsleyici {

    public static boolean hasRepeatingChar(String word) {
        if (word == null) return false;
        String w = word.toLowerCase(Locale.ROOT);
        Set<Character> seen = new HashSet<>();
        for (char c : w.toCharArray()) {
            if (!seen.add(c)) return true;
        }
        return false;
    }


    public static List<String> findFirstTwoWithRepeats(String[] words) {
        List<String> result = new ArrayList<>(2);
        for (String w : words) {
            if (hasRepeatingChar(w)) {
                result.add(w);
                if (result.size() == 2) break;
            }
        }
        return result;
    }

    public static List<Character> uniqueLetters(String a, String b) {
        String merged = (a == null ? "" : a) + (b == null ? "" : b);
        merged = merged.toLowerCase(Locale.ROOT);
        Set<Character> set = new LinkedHashSet<>();
        for (char c : merged.toCharArray()) set.add(c);
        return new ArrayList<>(set);
    }

    public static String randomTextFromLetters(List<Character> letters, Random rng) {
        List<Character> copy = new ArrayList<>(letters);
        Collections.shuffle(copy, rng);
        StringBuilder sb = new StringBuilder();
        for (char c : copy) sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] kelimeler = {"masa", "kitap", "anne", "okul", "perde", "battaniye"};

        List<String> bulunan = findFirstTwoWithRepeats(kelimeler);
        if (bulunan.size() < 2) {
            System.out.println("Tekrarlı harf içeren en az iki kelime bulunamadı.");
            return;
        }

        String k1 = bulunan.get(0);
        String k2 = bulunan.get(1);
        List<Character> harfler = uniqueLetters(k1, k2);
        
        Random rng = new Random(42);
        String yeniMetin = randomTextFromLetters(harfler, rng);

        System.out.println("Kelime Dizisi: " + Arrays.toString(kelimeler));
        System.out.println("Tekrar eden harf içeren 2 kelime: " + k1 + ", " + k2);
        System.out.println("Oluşturulan metin: " + yeniMetin);
    }
}