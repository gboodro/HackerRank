// https://www.hackerrank.com/challenges/programming-language-detection

object Solution {

    def main(args: Array[String]) {
        var t = "";
        for( ln <- io.Source.stdin.getLines ){ 
            t = choose(ln);
            if(!t.isEmpty){
                print(t);
                System.exit(0);
            }
        }
        print("Python");
    }
    
    def choose(line:String):String = {
        if(line.startsWith("import") || line.contains("public static void main")) return "Java";
        else if(line.startsWith("#include") || line.contains("int main()")) return "C";
        else if(line.endsWith(":") && line.contains("def ")) return "Python";
        else "";
    }
}