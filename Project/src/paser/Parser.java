package paser;

import java.text.ParseException;

interface Parser {
    Plan parse() throws SyntaxError, LexicalError, ParseException, EvalError;
    Expression parseExpression() throws SyntaxError, LexicalError, ParseException;
    Expression parseTerm() throws SyntaxError, LexicalError, ParseException;
    Expression parseFactor() throws SyntaxError, LexicalError, ParseException;
    Expression parsePower() throws SyntaxError, LexicalError, ParseException;
}