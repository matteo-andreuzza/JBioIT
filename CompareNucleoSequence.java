//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

//primo controllo: stessa lunghezza sequenze

public class CompareNucleoSequence {

    public static final int ACAPO = 50;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    // proprietà della classe
    String sequenceNucleo;

    String sequenceNucleo2;

    String sequenceNucleo3;

    String sequenceNucleo4;

    public String getSequenceNucleo() { //è public quindi anche le altre classi lo possono usare
        return sequenceNucleo;
    }

    public void setSequenceNucleo(String sequenceNucleo) { //scrive valore all'interno della stringa
        this.sequenceNucleo = sequenceNucleo;
    }

    public String getSequenceNucleo2() {
        return sequenceNucleo2;
    }

    public void setSequenceNucleo2(String sequenceNucleo2) {
        this.sequenceNucleo2 = sequenceNucleo2;
    }



    public String getSequenceNucleo3() {
        return sequenceNucleo3;
    }

    public void setSequenceNucleo3(String sequenceNucleo3) {
        this.sequenceNucleo3 = sequenceNucleo3;
    }

    public String getSequenceNucleo4() {
        return sequenceNucleo4;
    }

    public void setSequenceNucleo4(String sequenceNucleo4) {
        this.sequenceNucleo4 = sequenceNucleo4;
    }

    public String printIntervalSequence(String sequenceA, String sequenceB, int intervalSize, int indice){

        String row = "";
        for (int i  = indice; i<sequenceA.length() && i <sequenceB.length() && i<(indice+intervalSize); i++){
            if (sequenceA.charAt(i) == sequenceB.charAt(i)){
                row+= ANSI_RESET + sequenceA.charAt(i);
            }
            else {
                row += ANSI_RED+sequenceA.charAt(i);
            }
        }
        return row;
    }
}