package paser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.text.ParseException;

class ParserPlansTest {
    @Test
    public void ParserPTest() throws SyntaxError, EvalError, ParseException, LexicalError {
//        TokenizerPlans w = new TokenizerPlans("move UP");
//        ParserPlans ww = new ParserPlans(w);
//        Assertions.assertEquals(8,ww.parse());

        TokenizerPlans w1 = new TokenizerPlans("shoot DOWN");
        ParserPlans ww1 = new ParserPlans(w1);
        Assertions.assertEquals(8,ww1.parse());

    }
    @Test
    public void ParseExprtest() throws LexicalError, SyntaxError, ParseException, EvalError {
        TokenizerPlans e  =new TokenizerPlans("nearby UP");
        ParserPlans ee = new ParserPlans(e);
        Assertions.assertEquals(8,ee.parseExpr());
    }
}