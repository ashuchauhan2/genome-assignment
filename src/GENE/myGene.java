package GENE;

public class myGene implements Genome, Alphabet {

    private String s;
    private String z;
    private double r;
    private Genome f;
    private char[] strChar;
    private char[] invStrChar;
    private char v;


    public myGene(String s) {
        this.s = s;
    }

    public String toString() {
        return s;
    }

    @Override
    public int Card() {
        return s.length();
    }

    @Override
    public Genome Clone() {
        Genome x = new myGene(s);
        return x;
    }

    @Override
    public Genome ConCat(Genome g) {
        g = new myGene(s + g.toString());
        return g;
    }

    @Override
    public boolean Equal(Genome g) {
        if (g.toString().equals(s)) {
            return true;
        }
        return false;
    }



    @Override
    public Genome Mutate(double p) {
        strChar = this.toString().toCharArray(); //importing char array
        for(int i=0; i<this.Card(); i++) {
            r = Math.random(); //generates random number
            if (r<p) { //only mutates if the char's value is less than the p value
                v = alphabet[(int)(4*Math.random())]; //chooses random char
                while (v==strChar[i]) { //loops until v does not equal the letter we are trying to replace
                    v = alphabet[(int)(4*Math.random())];
                }
                strChar[i] = v;
            }
        }
        s = new String(strChar);
        f = new myGene(s);
        return f; //returns a new Genome with our mutated string
    }

    @Override
    public Genome OnePointCrossOver(Genome g, int i) {
        strChar = this.toString().toCharArray();
        invStrChar = g.toString().toCharArray();
        try {
            if (this.Card() == g.Card()) {
                for (int d = i; d < this.Card(); d++) { //starts at int i, then loops through rest of array replacing chars
                    strChar[d] = invStrChar[d];
                }
            }
            else {
                throw new UsageException();
            }
        } catch (UsageException e) {
            System.out.println(e.getMessage());
        }
        s = new String(strChar);
        f = new myGene(s);
        return f;
    }

    /**Two Point Crossover
     * Takes in a genome, a start, and end index. Will replace the chars in current genome with input genome letters within the index provided.
     *
     * @param g Input Genome
     * @param i Starting Index
     * @param j End Index
     * @return Genome G with two point crossover string
     */

    @Override
    public Genome TwoPointCrossOver(Genome g, int i, int j) {
        strChar = this.toString().toCharArray();
        invStrChar = g.toString().toCharArray();
        try {
            if (this.Card() == g.Card()) {
                for (int d = i; d <= j; d++) { //will start at int i, and go until int j including j to replace chars
                    strChar[d] = invStrChar[d];
                }
            }
            else {
                throw new UsageException();
            }
        } catch(UsageException e) {
            System.out.println(e.getMessage());
        }
        s = new String(strChar);
        f = new myGene(s);
        return f;
    }

    @Override
    public Genome Inversion() {
        s = this.toString();
        for (int i=1; i<s.length(); i++) {
            if (z == null) { //z is null when it is first empty, so we use this to make z be a string of a single char
                v = s.charAt(i-1);
                z = String.valueOf(v);
            }
            v = s.charAt(i);
            z = v + z; //v is the new char which will be put in the front, and z is the string from before added to the end
        }
        f = new myGene(z);
        return f; //returns new Genome with inversed string z
    }
}