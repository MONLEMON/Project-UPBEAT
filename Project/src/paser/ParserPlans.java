package paser;

import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ParserPlans implements Parser {
    StringBuilder Stb = new StringBuilder();
    private Tokenizer tkz;
    private Map<String,Integer> Cal = new HashMap();
    public ParserPlans(Tokenizer tkz) {
        this.tkz = tkz;
    }

    @Override
    public Plan parse() throws LexicalError, SyntaxError, EvalError, ParseException {
        Plan plan = parser();
        if(tkz.hasNextToken()) throw new SyntaxError("Error");
        return plan;
    }

    public Plan parser() throws LexicalError, SyntaxError, ParseException, EvalError {
        LinkedList<Statement> statements = new LinkedList<>();
        while(tkz.hasNextToken()){
            parseStatement();
        }
        return new Plan(statements);
    }
    @Override
    public Statement parseStatement() throws LexicalError, SyntaxError, ParseException {
        while (tkz.peek("if")) {
            return parseIfStatement();
        }
        while (tkz.peek("while")) {
            return parseWhileStatement();
        }
        while ((tkz.peek("done")||tkz.peek("move")||tkz.peek("relocate")||tkz.peek("collect")||tkz.peek("invest")||tkz.peek("shoot"))){
            return parseActionCommand();
        }
        while (tkz.peek("{")) {
            return parseBlockStatement();
        }
        return parseActionCommand();
    }
    @Override
    public Statement parseIfStatement() throws LexicalError, SyntaxError, ParseException {
        tkz.consume("if");
        tkz.consume("(");
        Expression Expr = parseExpression();
        tkz.consume(")");
        Statement s1 = parseStatement();
        tkz.consume("else");
        Statement s2 = parseStatement();
        return new IfStatement(Expr,s1,s2);
    }
    @Override
    public Statement parseWhileStatement() throws LexicalError, SyntaxError, ParseException {
        tkz.consume("while");
        tkz.consume("(");
        Expression Expr = parseExpression();
        tkz.consume(")");
        Statement s1 = parseStatement();
        return new WhileStatement(Expr,s1);
    }
    @Override
    public Statement parseBlockStatement() throws LexicalError, SyntaxError, ParseException {
        tkz.consume("{");
        while (tkz.peek("}")) {
            tkz.consume();
            return parseIfStatement();
        }
        throw new SyntaxError("Error");
    }
    @Override
    public Statement parseAssignStatement() throws LexicalError, SyntaxError, ParseException {
        return null;
    }
    @Override
    public Statement parseActionCommand() throws LexicalError, SyntaxError, ParseException {
        while (tkz.peek("done")) {
            tkz.consume("done");
            return new Cmd(true);
        }
        while (tkz.peek("relocate")) {
            tkz.consume("relocate");
            return new RelocateCmd();
        }
        while (tkz.peek("move")) {
            return parseMoveCommand();
        }
        while (tkz.peek("collect")) {
            return parseRegionCommand();
        }
        while (tkz.peek("invest")) {
            return parseRegionCommand();
        }while (tkz.peek("shoot")) {
            return parseAttackCommand();
        }
        throw new SyntaxError("Error");

    }
    public Statement parseMoveCommand() throws LexicalError, SyntaxError, ParseException {
        tkz.consume("move");
        Direction direction =  parseDirection();
        return new MoveCmd(direction);
    }
    public Statement parseRegionCommand() throws LexicalError, SyntaxError, ParseException {
        while (tkz.peek("collect")) {
            tkz.consume("collect");
            Expression Expr = parseExpression();
            Regions command = Regions.collect;
            return new RegionCmd(command,Expr);
        }while (tkz.peek("invest")) {
            tkz.consume("invest");
            Expression Expr = parseExpression();
            Regions command = Regions.invest;
            return new RegionCmd(command,Expr);
        }throw new SyntaxError("Error");

    }
    public Statement parseAttackCommand() throws LexicalError, SyntaxError, ParseException {
        while (tkz.peek("shoot")) {
            tkz.consume("shoot");
            Direction direction = parseDirection();
            Expression Expr = parseExpression();
            return new ATKCmd(direction,Expr);
        }throw new SyntaxError("Error");
    }
    public Direction parseDirection() throws LexicalError, SyntaxError, ParseException {
        while (tkz.peek("UP")) {
            tkz.consume("UP");
            Direction direction = Direction.UP;
            return direction;
        }while (tkz.peek("UPLEFT")) {
            tkz.consume("UPLEFT");
            Direction direction = Direction.UPLEFT;
            return direction;
        }while (tkz.peek("UPRIGHT")) {
            tkz.consume("UPRIGHT");
            Direction direction = Direction.UPRIGHT;
            return direction;
        }while (tkz.peek("DOWN")) {
            tkz.consume("DOWN");
            Direction direction = Direction.DOWN;
            return direction;
        }while (tkz.peek("DOWNRIGHT")) {
            tkz.consume("DOWNRIGHT");
            Direction direction = Direction.DOWNRIGHT;
            return direction;
        }while (tkz.peek("DOWNLEFT")) {
            tkz.consume("DOWNLEFT");
            Direction direction = Direction.DOWNLEFT;
            return direction;
        }throw new SyntaxError("Error");
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
        Expression v = parseInfoExpression();
        if (isNumber((tkz.peek()))) {
            v = new IntLit(Integer.parseInt(tkz.consume()));
            Stb.setLength(0);
            v.prettyPrint(Stb);
            return v ;
        }if (tkz.peek().matches("[a-zA-Z]")) {
            v =  new Variable(tkz.consume());
            return v;
        }else if(tkz.peek("(")){
            tkz.consume("(");
            v = parseExpression();
            Stb.setLength(0);
            v.prettyPrint(Stb);
            tkz.consume(")");
            return v;
        }
        Stb.setLength(0);
        v.prettyPrint(Stb);
        return v;
    }
    @Override
    public  Expression parseInfoExpression() throws LexicalError, SyntaxError, ParseException {
        while (tkz.peek("nearby")) {
            tkz.consume("nearby");
            Direction direction = parseDirection();
            infocom command = infocom.nearby;
            return new InfoExpr(command,direction);
        }while (tkz.peek("opponent")) {
            tkz.consume("opponent");
            infocom command = infocom.opponent;
            Direction direction = parseDirection();
            return new InfoExpr(command,direction);
        }throw new SyntaxError("error");
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
