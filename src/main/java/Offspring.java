public class Offspring {
    private String genom, preGenom;

    public Offspring(String nextGenom){
        setGenom(nextGenom);
    }

    public String getGenom() {
        return this.genom;
    }

    public void setGenom(String genom) {
        this.genom = genom;
    }

    public String getPreGenom() {
        return this.preGenom;
    }

    public void setPreGenom(String genom) {
        this.preGenom = genom;
    }
}
