import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final int OFFSPRINGS_COUNT = 10;

    private static int getMutatedIndex(int genomLength) {
        return RandomUtils.nextInt(0, genomLength);
    }

    private static char doMutatedGen() {
        return RandomStringUtils.random(1, true, false).charAt(0);
    }

    private static String doMutateGenom(String previousGenom, int mutatedIndex, char mutatedGen) {
        return previousGenom.substring(0, mutatedIndex) + mutatedGen + previousGenom.substring(mutatedIndex + 1);
    }

    private static String doMutation(String previousGenom, int genomLength) {
        int mutatedIndex = getMutatedIndex(genomLength);
        char genToMutate = previousGenom.charAt(mutatedIndex);
        char mutatedGen = doMutatedGen();

        log.info("Gen to mutate is '{}' at {} position", genToMutate,  mutatedIndex);
        log.info("Mutated gen: '{}'", mutatedGen);

        return doMutateGenom(previousGenom, mutatedIndex, mutatedGen);
    }

    public static void main(String[] args) {
        String preGenom, nextGenom;
        Offspring[] offsprings = new Offspring[OFFSPRINGS_COUNT];

        Creature initPopulation = new Creature();
        int genomLength = initPopulation.getGenom().length();
        preGenom = initPopulation.getGenom();

        log.info("------------");
        log.info("Initial population: {}", initPopulation.getGenom());
        log.info("Genom length: {}", genomLength);
        log.info("Count of offsprings: {}", OFFSPRINGS_COUNT);
        log.info("------------");
        log.info("Offsprings:");
        log.info("------------");

        for (int i = 0; i < OFFSPRINGS_COUNT; i++) {
            log.info("Population {}", i+1);
            nextGenom = doMutation(preGenom, genomLength);
            offsprings[i] = new Offspring(nextGenom);
            offsprings[i].setPreGenom(preGenom);
            log.info("{} ancestor genom: {}", offsprings[i], initPopulation.getGenom());
            log.info("{} previous genom: {}", offsprings[i], offsprings[i].getPreGenom());
            log.info("{} actual genom: {}", offsprings[i], offsprings[i].getGenom());
            log.info("------------");
            preGenom = offsprings[i].getGenom();
        }
    }
}
