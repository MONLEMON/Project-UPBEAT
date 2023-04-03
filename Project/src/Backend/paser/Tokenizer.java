package Backend.paser;

public interface Tokenizer {
    boolean hasNextToken() ;
    String peek();
    String consume() throws LexicalError;
    boolean peek(String s);
    void consume(String s) throws SyntaxError, LexicalError;
    void computeNext() throws LexicalError;
}
