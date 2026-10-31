package ChatGpt;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

//import opennlp.tools.tokenize.Tokenizer;
//import opennlp.tools.tokenize.TokenizerME;
//import opennlp.tools.tokenize.TokenizerModel;
//import opennlp.tools.util.Span;

public class Chat_Bot {

//  private Tokenizer tokenizer;
//
//  public Chat_Bot() throws IOException {
//    InputStream modelIn = new FileInputStream("en-token.bin");
//    TokenizerModel model = new TokenizerModel(modelIn);
//    tokenizer = new TokenizerME(model);
//  }
//
//  public void processInput(String input) {
//    Span[] tokens = tokenizer.tokenizePos(input);
//    for (Span token : tokens) {
//      String word = token.getCoveredText(input).toString().toLowerCase();
//      if (word.equals("hello")) {
//        System.out.println("Hi there!");
//      } else if (word.equals("how")) {
//        System.out.println("I'm doing well, thank you.");
//      } else {
//        System.out.println("I'm not sure what you mean by that.");
//      }
//    }
//  }
}