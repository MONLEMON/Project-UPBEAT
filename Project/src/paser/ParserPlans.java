package paser;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class ParserPlans implements Parser {
    StringBuilder Stb = new StringBuilder();
    private Tokenizer tkz;
    private Map<String,Integer> Cal = new HashMap();
    public ParserPlans(Tokenizer tkz) {
        this.tkz = tkz;

    }
    @Override
    public Plan parse() throws LexicalError, SyntaxError, ParseException, EvalError {
        Plan s = new Plan();
        while(tkz.hasNextToken()){
            parseStatement();
            throw new SyntaxError("Can't do this");
        }
        return s;
    }
    public Statement parseStatement() throws LexicalError, SyntaxError, ParseException {
        while (tkz.peek("if")) {
            tkz.consume();
            return parseIfStatement();
        }
        while (tkz.peek("while")) {
            tkz.consume();
            return parseWhileStatement();
        }
        while ((tkz.peek("done")||tkz.peek("move")||tkz.peek("relocate")||tkz.peek("collect")||tkz.peek("invest")||tkz.peek("shoot"))){
            tkz.consume();
            return parseActionCommand();
        }
        while (tkz.peek("{")) {
            tkz.consume();
            return parseBlockStatement();
        }
        return parseActionCommand();
    }

    public Statement parseIfStatement() throws LexicalError, SyntaxError, ParseException {
        tkz.consume("if");
        tkz.consume("(");
        parseExpression();

        return null;
    }
    public Statement parseWhileStatement(){
        return null;
    }
    public Statement parseBlockStatement(){
        return null;
    }
    public Statement parseAssignStatement(){
        return null;
    }
    public Statement parseActionCommand(){

    }
    public Statement parseMoveCommand(){

    }
    public Statement parseRegionCommand(){

    }
    public Statement parseDirection(){

    }

    @Override

    public Expression parseExpression() throws SyntaxError, LexicalError, ParseException {
        Expression v = parseTerm();

        while (tkz.peek("+")) {
            tkz.consume();
            v = new
                    BinaryArithExpr(v, "+", parseFactor());
        }

        while (tkz.peek("-")) {
            tkz.consume();
            v = new
                    BinaryArithExpr(v, "-", parseFactor());
        }
        Stb.setLength(0);
        v.prettyPrint(Stb);
        return  v;
    }

    @Override

    public Expression parseTerm() throws SyntaxError, LexicalError, ParseException {
        Expression v = parseFactor();
        while (tkz.peek("%")) {
            tkz.consume();
            v = new
                    BinaryArithExpr(v, "%", parseFactor());
        }
        while (tkz.peek("*")) {
            tkz.consume();
            v = new
                    BinaryArithExpr(v, "*", parseFactor());
        }
        while (tkz.peek("/")) {
            tkz.consume();
            v = new
                    BinaryArithExpr(v, "/", parseFactor());
        }
        Stb.setLength(0);
        v.prettyPrint(Stb);
        return v;
    }
    @Override
    public  Expression parseFactor() throws LexicalError, SyntaxError, ParseException{
        Expression v = parsePower();
        while (tkz.peek("^")) {
            tkz.consume();
            v = new
                    BinaryArithExpr(v, "^", parseFactor());
        }
        Stb.setLength(0);
        v.prettyPrint(Stb);
        return v;
    }

    @Override
    public Expression parsePower() throws SyntaxError, LexicalError, ParseException {
        if (isNumber((tkz.peek()))) {
            Expression v = new IntLit(Integer.parseInt(tkz.consume()));
            Stb.setLength(0);
            v.prettyPrint(Stb);
            return v ;
        } else if (tkz.peek().matches("[a-zA-Z]")) {
            Expression v =  new Variable(tkz.consume());
            return v;
        } else {
            tkz.consume("(");
            Expression v = parseExpression();
            Stb.setLength(0);
            v.prettyPrint(Stb);
            tkz.consume(")");
            return v;
        }
    }

    public  Expression parseInfoExpression(){
    return null;

    }
    private boolean isNumber(String s) {
        char[] chars = s.toCharArray();
        boolean pointSeen = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '.') {
                if (pointSeen || i == chars.length - 1 || !Character.isDigit(chars[i + 1])) {
                    return false;
                }
                pointSeen = true;
            } else if (!Character.isDigit(chars[i]) && chars[i] != '-') {
                return false;
            }
        }
        return true;
    }
    public String prettyPrint(){
        String o = Stb.toString();
        return o;
    }
}
