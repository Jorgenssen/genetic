import org.apache.commons.lang3.RandomStringUtils;

public class Creature {
    private String genom;

    public Creature() {
        genom = generateSpecies();
    }
    public String getGenom() {
        return this.genom;
    }

    public String generateSpecies() {
        return RandomStringUtils.random(6, true, false);
    }
}
