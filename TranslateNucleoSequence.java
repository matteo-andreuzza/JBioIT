import org.python.antlr.ast.Str;
import org.python.util.PythonInterpreter;

public class TranslateNucleoSequence {

    public static String trascrivi(String sequenza){
        String ret = "";
        for (int i = 0; i<sequenza.length(); i++){
            if (sequenza.charAt(i) == 'G'){
                ret += "C";
            }
            if (sequenza.charAt(i) == 'C'){
                ret += "G";
            }
            if (sequenza.charAt(i) == 'T'){
                ret += "A";
            }
            if (sequenza.charAt(i) == 'A'){
                ret += "U";
            }

        }

        return ret;
    }


    public static String getAmminoacido (String codone){
        char prima = codone.charAt(0);
        char seconda = codone.charAt(1);
        char terza = codone.charAt(2);
        try (PythonInterpreter pyInterp = new PythonInterpreter()) {
            pyInterp.set("prima", prima);
            pyInterp.set("seconda", seconda);
            pyInterp.set("terza", terza);
            pyInterp.exec(
                    "codice = {\n" +
                            "  \"U\": {\n" +
                            "    \"U\": {\"U\": \"Fenilalanina\", \"C\": \"Fenilalanina\", \"A\": \"Leucina\", \"G\": \"Leucina\"},\n" +
                            "    \"C\": {\"U\": \"Serina\", \"C\": \"Serina\", \"A\": \"Serina\", \"G\": \"Serina\"},\n" +
                            "    \"A\": {\"U\": \"Tirosina\", \"C\": \"Tirosina\", \"A\": \"Stop\", \"G\": \"Stop\"},\n" +
                            "    \"G\": {\"U\": \"Cisteina\", \"C\": \"Cisteina\", \"A\": \"Stop\", \"G\": \"Triptofano\"}\n" +
                            "  },\n" +
                            "  \"C\": {\n" +
                            "    \"U\": {\"U\": \"Leucina\", \"C\": \"Leucina\", \"A\": \"Leucina\", \"G\": \"Leucina\"},\n" +
                            "    \"C\": {\"U\": \"Prolina\", \"C\": \"Prolina\", \"A\": \"Prolina\", \"G\": \"Prolina\"},\n" +
                            "    \"A\": {\"U\": \"Istidina\", \"C\": \"Istidina\", \"A\": \"Glutammina\", \"G\": \"Glutammina\"},\n" +
                            "    \"G\": {\"U\": \"Arginina\", \"C\": \"Arginina\", \"A\": \"Arginina\", \"G\": \"Arginina\"}\n" +
                            "  },\n" +
                            "  \"A\": {\n" +
                            "    \"U\": {\"U\": \"Isoleucina\", \"C\": \"Isoleucina\", \"A\": \"Isoleucina\", \"G\": \"Metionina\"},\n" +
                            "    \"C\": {\"U\": \"Treonina\", \"C\": \"Treonina\", \"A\": \"Treonina\", \"G\": \"Treonina\"},\n" +
                            "    \"A\": {\"U\": \"Asparagina\", \"C\": \"Asparagina\", \"A\": \"Lisina\", \"G\": \"Lisina\"},\n" +
                            "    \"G\": {\"U\": \"Serina\", \"C\": \"Serina\", \"A\": \"Arginina\", \"G\": \"Arginina\"}\n" +
                            "  },\n" +
                            "  \"G\": {\n" +
                            "    \"U\": {\"U\": \"Valina\", \"C\": \"Valina\", \"A\": \"Valina\", \"G\": \"Valina\"},\n" +
                            "    \"C\": {\"U\": \"Alanina\", \"C\": \"Alanina\", \"A\": \"Alanina\", \"G\": \"Alanina\"},\n" +
                            "    \"A\": {\"U\": \"Acido aspartico\", \"C\": \"Acido aspartico\", \"A\": \"Acido glutammico\", \"G\": \"Acido glutammico\"},\n" +
                            "    \"G\": {\"U\": \"Glicina\", \"C\": \"Glicina\", \"A\": \"Glicina\", \"G\": \"Glicina\"}\n" +
                            "  }\n" +
                            "}"
            );

            pyInterp.exec("amminoacido = codice[prima][seconda][terza]");

            String amminoacido = String.valueOf(pyInterp.get("amminoacido"));
        return amminoacido;
        }
    }

    public static String getAmminoSequence(String mRNA) {
        StringBuilder amminoSequence = new StringBuilder();

        for (int i = 0; i + 2 < mRNA.length(); i += 3) {
            String codone = mRNA.substring(i, i + 3);
            amminoSequence.append(getAmminoacido(codone));
        }

        return amminoSequence.toString();
    }

    public static String traduci(String DNA){
        String mRna = trascrivi(DNA);
        return  "";
    }


    public static void main(String[] args) {
        System.out.println(trascrivi("ACTGACT"));
        System.out.println(getAmminoacido("UGG"));


        String mRNA = "UUUUUAUAC";   // 3 codoni: AUG UUU GGC
        String result = getAmminoSequence(mRNA);

        System.out.println("mRNA: " + mRNA);
        System.out.println("Sequenza amminoacidica: " + result);


    }
}
