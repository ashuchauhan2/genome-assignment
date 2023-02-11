package GENE;

/** testGene:
 *
 * This is the test harness for the myGene class
 * This class will test each method implemented from the Genome interface and determine whether
 * they have been implemented successfully or not.
 *
 * */

public class testGene {

    Genome a = new myGene("aaagada");
    Genome v = new myGene("ddddddd");
    Genome b = new myGene("bbbbbbb");
    Genome g = new myGene("agda");
    Genome x = new myGene("aaagada");
    String d = a.toString();
    String f = g.toString();

public testGene () {
    System.out.println("---------------------------------------------------");
    testCard(); //Cardinality Test
    testClone(); //Clone Test
    testConcat(); //Concatenation Test
    testEquals(); //Equals Test
    testMutate(); //Mutate Test
    testInverse(); //Inverse Test
    testOnePointCrossover(); //One Point Crossover Test
    testTwoPointCrossover(); //Two Point Crossover Test
    testErrors();
        }

    private void testErrors() {
        System.out.println("Testing Errors. This should return two errors that say Genones must be equal length");
        a.Clone().TwoPointCrossOver(g,1,2);
        g.Clone().TwoPointCrossOver(v,1,2);
        System.out.println("---------------------------------------------------");

    }

    private void testTwoPointCrossover() {
        System.out.println("Testing the TwoPointCrossover method. Results should be: 'bbdddbb' and 'addgada'.");
        System.out.println(b.Clone().TwoPointCrossOver(v,2,4));
        System.out.println(x.Clone().TwoPointCrossOver(v,1,2));
        System.out.println("---------------------------------------------------");
    }

    private void testOnePointCrossover() {
        System.out.println("Testing the OnePointCrossover method. Results should be: 'aaddddd' and 'bbbbddd'.");
        System.out.println(a.Clone().OnePointCrossOver(v,2));
        System.out.println(b.Clone().OnePointCrossOver(v,4));
        System.out.println("---------------------------------------------------");
    }

    private void testInverse() {
        System.out.println("Tesing the Inversion method. Results should be 'adagaaa' and 'adga'");
        System.out.println("Results are: '" + a.Clone().Inversion() + "' and '" + g.Clone().Inversion() + "'.");
        System.out.println("---------------------------------------------------");
    }

    private void testMutate() {
        System.out.println("Testing the Mutate method. Results will vary.");
        System.out.println("Current Genomes being used are: '"+a+"' '"+v+"' '"+b+"'.");
        System.out.println(a.Clone().Mutate(Math.random()));
        System.out.println(v.Clone().Mutate(Math.random()));
        System.out.println(b.Clone().Mutate(Math.random()));
        System.out.println("---------------------------------------------------");
    }

    private void testEquals() {
        System.out.println("Testing the Equals method. Results should be True, False, False.");
        if (a.Equal(x) == true) {
            System.out.print("True, ");
        }
        else {
            System.out.print("False, ");
        }
        if (a.Equal(g) == true) {
            System.out.print("True, ");
        }
        else {
            System.out.print("False, ");
        }
        if (g.Equal(x) == true) {
            System.out.print("True ");
        }
        else {
            System.out.print("False ");
        }
        System.out.println("");
        System.out.println("---------------------------------------------------");

    }

    private void testConcat() {
        System.out.println("Testing the Concat method. Expected result is '" + d + f + "'.");
        System.out.println("Actual result is: " + a.Clone().ConCat(g.Clone()).toString());
        System.out.println("---------------------------------------------------");
    }

    private void testClone() {
        System.out.println("Testing the Clone method. Expected result is '" + d + "'.");
        System.out.println("Actual result is: " + a.Clone().toString());
        if (d.equals(a.Clone().toString())) {
            System.out.println("---------------------------------------------------");
        }
        else {
            System.out.println("Test failed.");
            System.out.println("---------------------------------------------------");
        }
    }

    private void testCard() {
        System.out.println("Testing the Cardinality. Expected result is 7.");
        a.Card();
        System.out.println("Actual result is: " + a.Card());
        if (a.Card() == 7) {
            System.out.println("---------------------------------------------------");
        }
        else {
            System.out.println("Test failed.");
            System.out.println("---------------------------------------------------");
        }
    }



public static void main ( String[] args ) { testGene c = new testGene(); };


        } // testGene
