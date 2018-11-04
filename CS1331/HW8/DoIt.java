
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * This is DoIt class that all the methods to complete the analysis.
 * @author Davit
 * @version 1.0
 */

public class DoIt {

    private String sourceFileName;
    private String targetFileName;
    private File sourceFileReader;
    private File targetFileReader;
    private Scanner sourceFileScanner;
    private Scanner targetFileScanner;

    private String[] sentenceArray = new String[10000];

    /**
     * [receiveFileSource]
     * @throws IOException [In case the file is not found]
     */

    public void receiveFileSource() throws IOException { // what if a directoy?
        System.out.println("What is the name of source file to analyze?");

        Scanner scan = new Scanner(System.in);
        sourceFileName = scan.nextLine();
        sourceFileReader = new File(sourceFileName);
        sourceFileScanner = new Scanner(sourceFileReader);

    }

    /**
     * [receiveFileTarget]
     * @throws IOException [In case the file is not found]
     */

    public void receiveFileTarget() throws IOException {
        System.out.println("What is the name of the target words file?");

        Scanner scan = new Scanner(System.in);
        targetFileName = scan.nextLine();
        targetFileReader = new File(targetFileName);
        targetFileScanner = new Scanner(targetFileReader);

    }

    /**
     * [calcWords calcualtes the words]
     * @return [the number of words]
     */

    public int calcWords() {

        int c = 0; String s;

        while (sourceFileScanner.hasNext()) {
            c++;
            s = sourceFileScanner.next();
        }

        return c;

    }

    /**
     * [calcSentences calcualtes the number of sentences]
     * @return [the number of sentences]
     * @throws IOException   [In case the file is not found]
     */

    public int calcSentences() throws IOException {

        sourceFileScanner = new Scanner(sourceFileReader);
        int c = 0, i = 0, k = 0;
        String s; String[] abgar = new String[10000];

        while (sourceFileScanner.hasNext()) {
            s = sourceFileScanner.next();

            if ((s.indexOf('.') != -1
                || s.indexOf('!') != -1
                || s.indexOf('?') != -1) && !isAbbreviation(s)
                && (s.length() > 2)) {

                c++;
                abgar[i++] = s;
                sentenceArray[k] = "";
                for (int j = 0; j < i; j++) {
                    sentenceArray[k] += abgar[j];
                    sentenceArray[k] += " ";
                }
                k++;
                abgar = new String[10000];
                i = 0;
            } else {
                abgar[i++] = s;
            }
        }

        return c;
    }

    /**
     * [theLongestSentence finds the longest sentence]
     * @return [the longest sentence as a String]
     */

    public String theLongestSentence() {

        int l = 0;
        String sentence, longestSentence = "";

        for (String s : sentenceArray) {
            if (s == null) {
                break;
            }
            if (s.length() > l) {
                longestSentence = s;
                l = s.length();
            }
        }

        return longestSentence;
    }

    /**
     * [targetWordCount counts the words from the file in the source]
     * @throws IOException [In case the file is not found]
     */

    public void targetWordCount() throws IOException {

        sourceFileScanner = new Scanner(sourceFileReader);

        String[] abgar = new String[10000];

        int i = 0;
        String x;
        int[] babken = new int[10000];

        while (targetFileScanner.hasNextLine()) {
            abgar[i++] = targetFileScanner.nextLine();
        }

        while (sourceFileScanner.hasNext()) {
            x = sourceFileScanner.next();

            for (int j = 0;; j++) {
                if (abgar[j] == null) {
                    break;
                }
                String result = x.replaceAll("[^a-zA-Z0-9\\n\\r]", "");
                if (result.toLowerCase().startsWith(abgar[j].toLowerCase())) {
                    babken[j]++;
                }
            }
        }

        PrintWriter w = new PrintWriter(targetFileReader);
        for (int j = 0;; j++) {
            if (abgar[j] == null) {
                break;
            } else {
                w.println(abgar[j] + ": " + babken[j]);

            }
        }

        w.close();

    }

    /**
     * [sentimentAnlysis does the sentiment anlysis]
     * @param  xx          [the name of the goodwordfile]
     * @param  yy          [the name of the badwordfile]
     * @return             [the sentiment score]
     * @throws IOException [In case the file isn't found]
     */

    public int sentimentAnlysis(String xx, String yy) throws IOException {

        sourceFileScanner = new Scanner(sourceFileReader);

        String[] abgar = new String[100];
        String[] babken = new String[100];
        File a = new File(xx);
        File b = new File(yy);
        Scanner scan1 = new Scanner(a);
        Scanner scan2 = new Scanner(b);

        int i = 0, j = 0, c = 0;
        String x;

        while (scan1.hasNextLine()) {
            abgar[i++] = scan1.nextLine();
        }
        while (scan2.hasNextLine()) {
            babken[j++] = scan2.nextLine();
        }

        while (sourceFileScanner.hasNext()) {
            x = sourceFileScanner.next();

            for (int k = 0;; k++) {
                if (abgar[k] == null) {
                    break;
                }
                String result = x.replaceAll("[^a-zA-Z0-9\\n\\r]", "");
                if (result.toLowerCase().startsWith(abgar[k].toLowerCase())) {
                    c++;
                }
            }

            for (int k = 0;; k++) {
                if (babken[k] == null) {
                    break;
                }
                if (x.startsWith(babken[k])) {
                    c--;
                }
            }
        }
        return c;

    }






    private boolean isAbbreviation(String s) {
        return (s.toLowerCase().equals("mr.") || s.toLowerCase().equals("dr.")
            || s.toLowerCase().equals("mrs.") || s.toLowerCase().equals("etc.")
            || s.toLowerCase().equals("e.g.") || s.toLowerCase().equals("p.m.")
            || s.toLowerCase().equals("a.m.") || s.toLowerCase().equals("ms.")
            || s.toLowerCase().equals("st.") || s.toLowerCase().equals("a.d.")
            || s.toLowerCase().equals("b.c.") || s.toLowerCase().equals("prof.")
            || s.toLowerCase().equals("a.s.a.p.")
            || s.toLowerCase().equals("in.") || s.toLowerCase().equals("cm.")
            || s.toLowerCase().equals("u.s.") || s.toLowerCase().equals("p.s.")
            || s.toLowerCase().equals("ex.") || s.toLowerCase().equals("i.e.")
            || s.toLowerCase().equals("ft.") || s.toLowerCase().equals("mon.")
            || s.toLowerCase().equals("jan.") || s.toLowerCase().equals("mar.")
            || s.toLowerCase().equals("dec.") || s.toLowerCase().equals("nov.")
            || s.toLowerCase().equals("feb.") || s.toLowerCase().equals("oct.")
            || s.toLowerCase().equals("sun.") || s.toLowerCase().equals("sat.")
            || s.toLowerCase().equals("fri.") || s.toLowerCase().equals("thu.")
            || s.toLowerCase().equals("tue.") || s.toLowerCase().equals("wed.")
            || s.toLowerCase().equals("tu.") || s.toLowerCase().equals("th."));

    }

    /**
     * [getTargetFileName gets the name of the file]
     * @return [the name of the targetfile]
     */

    public String getTargetFileName() {
        return targetFileName;
    }


}