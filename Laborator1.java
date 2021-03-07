import java.util.HashMap;
import java.util.ArrayList;
import java.util.*;


    public class Main {
        public static Map<String, List<String>> Rules = new HashMap<String, List<String>>();
Scanner scan = new Scanner(System.in);
        String compar = "S";
        String input = "bbaaaB";
//System.out.println("Enter your string imput: " + imput);


        public static void main(String[] args) {
            Rules.put("S", new ArrayList<String>(Arrays.asList("aB", "bB")));
            Rules.put("B", new ArrayList<String>(Arrays.asList("cD")));
            Rules.put("D", new ArrayList<String>(Arrays.asList("dQ")));
            Rules.put("Q", new ArrayList<String>(Arrays.asList("bB")));
            Rules.put("D", new ArrayList<String>(Arrays.asList("bB")));
            Rules.put("Q" ,new ArrayList<String>(Arrays.asList("dQ")));

            System.out.println(Arrays.asList(Rules));

            Main main = new Main();
            main.cycle();

        }


        public void cycle() {
            for (int i = 0; i < input.length(); i++) {
                while (i < input.length()) {

                    if (!input.matches("[ab]+")) {       /*Looks for non terminal symbols*/
                        System.out.println("Incorrect string");
                        return;
                    }

                    if (Arrays.toString(Rules.keySet().toArray()).contains("S")&& compar.contains("S") && input.charAt(i) == 'a') {//0
                        compar = compar.replace("S", "aB");
                        i++;
                      System.out.println("\t" + compar);

                    }
                    if (Arrays.toString(Rules.keySet().toArray()).contains("S") && compar.contains("S") && input.charAt(i) == 'b') { //1
                        compar = compar.replace("S", "bB");
                        i++;
                        System.out.println("\t" + compar);
                    } else if(Arrays.toString(Rules.keySet().toArray()).contains("B") && compar.contains("B") && input.charAt(i) == 'c'){
                        compar = compar.replace("B", "cD");
                    i++;
                    }
                    System.out.println("\t" + compar);
                    if (Arrays.toString(Rules.keySet().toArray()).contains("D") && compar.contains("D") && input.charAt(i) == 'd') {//2
                        compar = compar.replace("D", "dQ");
                        i++;
                        System.out.println("\t" + compar);
                    } else if(Arrays.toString(Rules.keySet().toArray()).contains("Q") && compar.contains("Q") && input.charAt(i) == 'b'){
                        compar = compar.replace("Q", "bB");
                        i++;
                        System.out.println("\t" + compar);
                    }
                    if (Arrays.toString(Rules.keySet().toArray()).contains("D") && compar.contains("D") && input.charAt(i) == 'a') { //3
                        compar = compar.replace("D", "a");
                        i++;
                        System.out.println("\t" + compar);
                    } else if(Arrays.toString(Rules.keySet().toArray()).contains("Q") && compar.contains("Q") && input.charAt(i) == 'd'){
                        compar = compar.replace("Q", "dQ");
                        i++;
                        System.out.println("\t" + compar);
                    }
                    if (compar.endsWith("S") || compar.endsWith("B") || compar.endsWith("D") || compar.endsWith("Q")) {
                        System.out.println("Nonterminal at the final.");
                    }
                    if (compar.equals(input)) {
                        System.out.println("String conforms to the rules.");
                        return;
                    }else if(i==compar.length()) {
                        System.out.printf("String unbuildable.");
                        return;
                    }
                }
            }
        }
    }
  