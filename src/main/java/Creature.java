import org.apache.commons.lang3.RandomStringUtils;

public class Creature {
    String genom;

    public Creature() {
        genom = generateSpecies();
    }

    public String generateSpecies() {
        return RandomStringUtils.random(6, true, false);
    }
}
