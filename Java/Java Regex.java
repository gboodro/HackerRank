// https://www.hackerrank.com/challenges/java-regex

class myRegex{
    String range = "([0-9]|[0-9][0-9]|[0-1][0-9][0-9]|2([0-4][0-9]|5[0-5]))";
    String pattern = range+'.'+range+'.'+range+'.'+range;
    //String pattern = "[0-9]";
}