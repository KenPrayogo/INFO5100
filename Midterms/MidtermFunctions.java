import java.util.*;

public class MidtermFunctions {

    // Find longest palindromes that can be built with the letters in String s
    public int longestPalindrome(String s) {
        int resultLength = 0;
        HashMap<Character,Integer> charCount = new HashMap<>(); // letter -> appearance count
        char[] chars = s.toCharArray();
        // Map the values in the String with their counts
        for (char c: chars) {
            if (charCount.containsKey(c)) {
                // Increment the number on the index
                charCount.put(c, charCount.get(c) + 1);
            } else {
                charCount.put(c, 1);
            }
        }
        System.out.println(charCount.toString());

        // Build palindromes with pairs of even numbers and one of any character
        Iterator it = charCount.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            int count = (Integer)pair.getValue();
            if (count > 1) {
                while (count >= 2) {
                    count -= 2;
                    resultLength += 2;
                }
                // Remove if the letter is depleted
                if (count == 0) {
                    it.remove();
                }
            }
        }
        // If there's still something in the map, use one character
        if (resultLength > 0 && !charCount.isEmpty()) {
            resultLength++;
        }
        return resultLength;
    }

    // index = day, value = stock price
    // Find max profit by buying/selling them.
    // e.g. [5,7,9,4,6,10] buy 5, sell 9, buy 4, sell 10
    public int maxProfit(int[] prices) {
        List<Integer> daysToSell = new ArrayList<>();
        List<Integer> daysToBuy = new ArrayList<>();
        int profit = 0;

        // First loop to Scan
        // Strategy: Find local-max, buy before that point and sell
        for (int i = 0; i < prices.length; i++) {
            /* IF Condition Explanation - Sell if:
                - Not Day 0
                - Price is higher than previous or next day
                - Unless it IS the last day given, where we only check if it's
                  higher than the previous day
            */
            if (i > 0 && prices[i] > prices[i - 1] &&
                    ( (i + 1) == prices.length && prices[i] > prices[i - 1]
                    || ((i + 1) < prices.length && prices[i] > prices[i + 1]) )
                ) {
                daysToSell.add(i);
                profit += prices[i];
            }
        }
        // Buy at the lowest point before the selling days - No duplicate transactions
        for (int sellDay: daysToSell) {
            int lowestBuy = sellDay;
            for (int i = sellDay; i >= 0; i--) {
                if (!daysToBuy.contains(i) && !daysToSell.contains(i) && prices[i] < prices[sellDay]
                        && prices[i] < prices[lowestBuy]) {
                    lowestBuy = i;
                }
            }
            if (prices[lowestBuy] < prices[sellDay]) {
                daysToBuy.add(lowestBuy);
                profit -= prices[lowestBuy];
            }
        }
        return profit;
    }

    public int titleToNumber(String title) {
        // Create Map
        HashMap<Character, Integer> letterMap = new HashMap<>();
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] chars  = str.toCharArray();
        int i = 1;
        for (char c: chars) {
            letterMap.put(c, i);
            i++;
        }
        // Return Excel col to number -- e.g. A -> 1, Z -> 26, AA -> 27
        char[] titleChars = title.toCharArray();
        int result = 0;
        for (char c: titleChars) {
            result *= 26;
            result += letterMap.get(c);
        }
        return result;
    }

    // BONUS
    public int twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> usedIndices = new HashMap<>();
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    int total = nums[i] + nums[j];
                    // Sum matches Target, combination has not been used
                    if (total == target && (!usedIndices.containsKey(i) || !usedIndices.get(i).equals(j))) {
                        result++;
                        usedIndices.put(i, j);
                        usedIndices.put(j, i);
                    }
                }
            }
        }
        return result;
    }
}

// For Testing
class Main {
    public static void main(String[] args) {
        MidtermFunctions fn = new MidtermFunctions();

//        System.out.println(fn.longestPalindrome("steponnopets"));
//        System.out.println(fn.longestPalindrome("Anna"));
//        System.out.println(fn.longestPalindrome("abcdef"));
//        System.out.println(fn.longestPalindrome("annaaff"));

        int[] stocks = {5,7,9,4,6,10};
//        int[] stocks = {1,2,3,4,5};
//        int[] stocks = {5,4,3,2,1};
//        int[] stocks = {1,3,5,4,2};
//        int[] stocks = {5,3,1,4,6};
        System.out.println(fn.maxProfit(stocks));

        int[] prob = {2,3,4,5,6,8,0};
        System.out.println(fn.twoSum(prob, 8));

        System.out.println(fn.titleToNumber("BA"));
    }
}
