// https://www.hackerrank.com/challenges/java-anagrams

static boolean isAnagram(String a, String b) {
    // Complete the function
    a = a.toLowerCase();
    b = b.toLowerCase();
    int[] ctA = new int[256], ctB = new int[256];
    for(char t : a.toCharArray()) ctA[(int)t]++;
    for(char t : b.toCharArray()) ctB[(int)t]++;
    for(int i = 0; i < ctA.length; i++){
        if(ctA[i] != ctB[i]) return false;
    }
    return true;
}