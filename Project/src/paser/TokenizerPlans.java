package paser;

import java.util.NoSuchElementException;

import static java.lang.Character.isDigit;

class TokenizerPlans implements Tokenizer {
    private String src, next;  private int pos;
    public TokenizerPlans(String src) throws LexicalError {
        this.src = src;  pos = 0;
        computeNext();
    }
    @Override
    public boolean hasNextToken()
    { return next != null; }
    @Override
    public String peek() {
        if (!hasNextToken()){ throw new NoSuchElementException("No more tokens");}
        return next;
    }
    @Override
    public String consume() throws LexicalError {
        if (!hasNextToken()) throw new NoSuchElementException("No more tokens");
        String result = next;
        computeNext();
        return result;
    }
    @Override
    public boolean peek(String s){
        if (!hasNextToken()) return false;
        return peek().equals(s);
    }
    @Override
    public void consume(String s) throws SyntaxError, LexicalError {
        if (peek(s))
            consume();
        else
            throw new SyntaxError(s + " expected");
    }
    @Override
    public void computeNext() throws LexicalError {
        StringBuilder s = new StringBuilder();
        while (pos < src.length() && isSpace(src.charAt(pos)))
            pos++;  // ignore whitespace
        if (pos == src.length())
        { next = null;  return; }  // no more tokens
        char c = src.charAt(pos);
        if (isDigit(c)) {  // start of number
            s.append(c);
            for (pos++; pos < src.length() && isDigit(src.charAt(pos)); pos++)
                s.append(src.charAt(pos));
        }
        else if (c == '+' || c == '(' || c == ')' ||c == '-' ||c == '/' ||c == '*' ||c == '%'||c == '^') {
            s.append(c);
            pos++;
        }
        else throw new LexicalError("unknown character: " + c);
        next = s.toString();
    }
    private boolean isSpace(char c) {
        return Character.isWhitespace(c);
    }
}
