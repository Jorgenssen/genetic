import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class Main {

    public static int getMutatedIndex(int genomLength) {
        return RandomUtils.nextInt(0, genomLength);
    }

    public static char doMutatedGen(char genToMutate) {
        return RandomStringUtils.random(1, true, false).charAt(0);
    }

    public static String doMutateGenom(String previousGenom, int mutatedIndex, char mutatedGen) {
        return previousGenom.substring(0, mutatedIndex) + mutatedGen + previousGenom.substring(mutatedIndex + 1);
    }

    public static String doMutation(String previousGenom, int genomLength) {
        int mutatedIndex = getMutatedIndex(genomLength);
        char genToMutate = previousGenom.charAt(mutatedIndex);
        char mutatedGen = doMutatedGen(genToMutate);

        System.out.println("Gen to mutate is \'" + genToMutate + "\' at " + mutatedIndex + " position");
        System.out.println("Mutated gen: \'" + mutatedGen + "\'");

        return doMutateGenom(previousGenom, mutatedIndex, mutatedGen);
    }

    public static void main(String[] args) {
        String preGenom, nextGenom = null;
        int offspringsCount = 10;
        Offspring[] offsprings = new Offspring[offspringsCount];

        Creature initPopulation = new Creature();
        int genomLength = initPopulation.getGenom().length();
        preGenom = initPopulation.getGenom();

        System.out.println("------------");
        System.out.println("Initial population: " + initPopulation.getGenom());
        System.out.println("Genom length: " + genomLength);
        System.out.println("Count of offsprings: " + offspringsCount);
        System.out.println("------------\n");
        System.out.println("Offsprings:");

        for (int i = 0; i < offspringsCount; i++) {
            System.out.println(i+1);
            nextGenom = doMutation(preGenom, genomLength);
            offsprings[i] = new Offspring(nextGenom);
            offsprings[i].setPreGenom(preGenom);
            System.out.println(offsprings[i] + " initial genom: " + initPopulation.getGenom());
            System.out.println(offsprings[i] + " previous genom: " + offsprings[i].getPreGenom());
            System.out.println(offsprings[i] + " actual genom: " + offsprings[i].getGenom() + "\n");
        }
    }
}
