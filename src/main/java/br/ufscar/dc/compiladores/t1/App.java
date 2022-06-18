package br.ufscar.dc.compiladores.t1;

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class App {

    public static void main(String[] args) {

        String entrada = args[0];
        String saida = args[1];

        try (PrintWriter pw = new PrintWriter(new FileWriter(saida))){
            CharStream cs = CharStreams.fromFileName(entrada);
            t1Lexer lex = new t1Lexer(cs);
            Token t = null;
            while ((t = lex.nextToken()).getType() != Token.EOF) {
                pw.write("<" + "\'" + t.getText()  + "\'" + "," + t1Lexer.VOCABULARY.getDisplayName(t.getType()) + ">\n");
            }
            pw.close();
        } catch (IOException ex) {
        }
    }
}