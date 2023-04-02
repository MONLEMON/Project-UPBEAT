package Frontend.paser;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//        Plan → Statement+
//        Statement → Command | BlockStatement | IfStatement | WhileStatement
//        Command → AssignmentStatement | ActionCommand
//        AssignmentStatement → <identifier> = Expression
//        ActionCommand → done | relocate | MoveCommand | RegionCommand | AttackCommand
//        MoveCommand → move Direction
//        RegionCommand → invest Expression | collect Expression
//        AttackCommand → shoot Direction Expression
//        Direction → up | down | upleft | upright | downleft | downright
//        BlockStatement → { Statement* }
//        IfStatement → if ( Expression ) then Statement else Statement
//        WhileStatement → while ( Expression ) Statement
//        Expression → Expression + Term | Expression - Term | Term
//        Term → Term * Factor | Term / Factor | Term % Factor | Factor
//        Factor → Power ^ Factor | Power
//        Power → <number> | <identifier> | ( Expression ) | InfoExpression
//        InfoExpression → opponent | nearby Direction
public class ParserPlans implements Parser {
    StringBuilder Stb = new StringBuilder();
    private Tokenizer tkz;
    private Map<String,Integer> Cal = new HashMap();
    public ParserPlans(Tokenizer tkz) {
        this.tkz = tkz;
    }

    @Override
    public Plan parse() throws LexicalError, SyntaxError, EvalError, ParseException {
        Plan S = parsePlan();
        if(tkz.hasNextToken()) throw new SyntaxError("Error");
        return S;
    }
    public Plan parsePlan() throws LexicalError, SyntaxError, ParseException {
        ArrayList<Statement> statements = new ArrayList<>();
        while(tkz.hasNextToken()){
            statements.add(parseStatement());
        }
        return new Plan(statements);
    }

    @Override
    public Statement parseStatement() throws LexicalError, SyntaxError, ParseException {
        if (tkz.peek("if")) {
            return parseIfStatement();
        }
        if (tkz.peek("while")) {
            return parseWhileStatement();
        }
        if ((tkz.peek("done")||tkz.peek("move")||tkz.peek("relocate")||tkz.peek("collect")||tkz.peek("invest")||tkz.peek("shoot"))){
            return parseActionCommand();
        }
        if (tkz.peek("{")) {
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
        if (tkz.peek("}")) {
            tkz.consume();
            return parseIfStatement();
        }else throw new SyntaxError("Error");
    }
    @Override
    public Statement parseAssignStatement() throws LexicalError, SyntaxError, ParseException {
        throw new SyntaxError("Error");
    }
    @Override
    public Statement parseActionCommand() throws LexicalError, SyntaxError, ParseException {
        if (tkz.peek("done")) {
            tkz.consume();
            return new Cmd(true);
        }
        if  (tkz.peek("relocate")) {
            tkz.consume();
            return new RelocateCmd();
        }
        if  (tkz.peek("move")) {
            return parseMoveCommand();
        }
        if  (tkz.peek("collect")) {
            return parseRegionCommand();
        }
        if  (tkz.peek("invest")) {
            return parseRegionCommand();
        }if  (tkz.peek("shoot")) {
            return parseAttackCommand();
        }else{
        throw new SyntaxError("Error");
    }
    }
    public Statement parseMoveCommand() throws LexicalError, SyntaxError, ParseException {
        tkz.consume("move");
        Direction direction =  parseDirection();
        return new MoveCmd(direction);
    }
    public Statement parseRegionCommand() throws LexicalError, SyntaxError, ParseException {
        if (tkz.peek("collect")) {
            tkz.consume();
            Expression Expr = parseExpression();
            Regions command = Regions.collect;
            return new RegionCmd(command,Expr);
        }if (tkz.peek("invest")) {
            tkz.consume();
            Expression Expr = parseExpression();
            Regions command = Regions.invest;
            return new RegionCmd(command,Expr);
        }else throw new SyntaxError("Error");

    }
    public Statement parseAttackCommand() throws LexicalError, SyntaxError, ParseException {
        if (tkz.peek("shoot")) {
            tkz.consume();
            Direction direction = parseDirection();
            Expression Expr = parseExpression();
            return new ATKCmd(direction,Expr);
        }else throw new SyntaxError("Error");
    }
    public Direction parseDirection() throws LexicalError, SyntaxError, ParseException {
        if (tkz.peek("UP")) {
            tkz.consume();
            Direction direction = Direction.up;
            return direction;
        }
        if (tkz.peek("UPLEFT")) {
            tkz.consume();
            Direction direction = Direction.upleft;
            return direction;
        }
        if (tkz.peek("UPRIGHT")) {
            tkz.consume();
            Direction direction = Direction.upright;
            return direction;
        }
        if (tkz.peek("DOWN")) {
            tkz.consume();
            Direction direction = Direction.down;
            return direction;
        }
        if (tkz.peek("DOWNRIGHT")) {
            tkz.consume();
            Direction direction = Direction.downright;
            return direction;
        }
        if (tkz.peek("DOWNLEFT")) {
            tkz.consume();
            Direction direction = Direction.downleft;
            return direction;
        } else {
            throw new SyntaxError("Error");
        }
    }
    public double parseExpr() throws LexicalError, SyntaxError, ParseException, EvalError {
        Expression v = parseExpression();
        if(tkz.hasNextToken()) throw new SyntaxError("Can't do this");
        return v.eval(Cal);
    }
    @Override
    public Expression parseExpression() throws SyntaxError, LexicalError, ParseException {
        Expression v = parseTerm();

        while (tkz.peek("+")) {
            tkz.consume();
            v = new
                    BinaryArithExpr(v, "+", parseTerm());
        }

        while (tkz.peek("-")) {
            tkz.consume();
            v = new
                    BinaryArithExpr(v, "-", parseTerm());
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
            return v;
        } else if (tkz.peek().matches("[a-zA-Z]")) {
            Expression v = new Variable(tkz.consume());
            return v;
        }if (tkz.peek("nearby")) {
            tkz.consume();
            Direction direction = parseDirection();
            infocom command = infocom.nearby;
            return new InfoExpr(command,direction);
        }if (tkz.peek("opponent")) {
            tkz.consume();
            infocom command = infocom.opponent;
            Direction direction = parseDirection();
            return new InfoExpr(command,direction);
        }else{
            tkz.consume("(");
            Expression v = parseExpression();
            Stb.setLength(0);
            v.prettyPrint(Stb);
            tkz.consume(")");
            return v;
    }
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
