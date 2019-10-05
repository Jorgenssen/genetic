import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class Main {

    public static int getMutatedIndex(int genomLength){
        return RandomUtils.nextInt(0, genomLength);
    }

    public static char doMutatedGen(char genToMutate){
        return RandomStringUtils.random(1, true, false).charAt(0);
    }

    public static String doMutateGenom(String previousGenom, int mutatedIndex, char mutatedGen){
        return previousGenom.substring(0, mutatedIndex) + mutatedGen + previousGenom.substring(mutatedIndex+1);
    }

    public static String doMutation(String previousGenom, int genomLength){
        int mutatedIndex = getMutatedIndex(genomLength);
        char genToMutate = previousGenom.charAt(mutatedIndex);
        char mutatedGen = doMutatedGen(genToMutate);

        System.out.println("Gen to mutate is \'" + genToMutate + "\' at " + mutatedIndex + " position");
        System.out.println("Mutated gen: \'" + mutatedGen + "\'");

        return doMutateGenom(previousGenom, mutatedIndex, mutatedGen);
    }

    public static void main(String[] args){
        String previousGenom, nextGenom = null;

        Creature initPopulation = new Creature();
        int genomLength = initPopulation.genom.length();

        System.out.println("------------");
        System.out.println("Initial population: " + initPopulation.genom);
        System.out.println("Genom length: " + genomLength);
        System.out.println("------------\n");

        previousGenom = initPopulation.genom;
        for (int i = 0; i < 10; i++){
            System.out.println("------------");
            System.out.println("Previous genom: " + previousGenom);

            nextGenom = doMutation(previousGenom, genomLength);

            System.out.println("Next genom: " + nextGenom);
            System.out.println("------------\n");

            if (nextGenom != null) {
                previousGenom = nextGenom;
            }
        }

        System.out.println("Initial genom: " + initPopulation.genom + "\n" + "Final genom: " + nextGenom);
    }
}
