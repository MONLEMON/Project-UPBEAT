package paser;

import java.text.ParseException;

interface Parser {
    Plan parse() throws SyntaxError, LexicalError, ParseException, EvalError;

    Statement parseStatement() throws LexicalError, SyntaxError, ParseException;

    Statement parseIfStatement() throws LexicalError, SyntaxError, ParseException;

    Statement parseWhileStatement();

    Statement parseBlockStatement();

    Statement parseAssignStatement() throws LexicalError, SyntaxError, ParseException;

    Statement parseActionCommand() throws LexicalError, SyntaxError;

    Expression parseExpression() throws SyntaxError, LexicalError, ParseException;
    Expression parseTerm() throws SyntaxError, LexicalError, ParseException;
    Expression parseFactor() throws SyntaxError, LexicalError, ParseException;
    Expression parsePower() throws SyntaxError, LexicalError, ParseException;

    Expression parseInfoExpression();
}