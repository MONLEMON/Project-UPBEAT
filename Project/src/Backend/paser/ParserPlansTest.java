package Backend.paser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.text.ParseException;

class ParserPlansTest {
    @Test
    public void ParserPTest() throws SyntaxError, EvalError, ParseException, LexicalError {
        TokenizerPlans w = new TokenizerPlans("move UP");
        ParserPlans ww = new ParserPlans(w);
        Assertions.assertEquals(8,ww.parse());

    }
    @Test
    public void ParseExprtest() throws LexicalError, SyntaxError, ParseException, EvalError {
        TokenizerPlans e  =new TokenizerPlans("nearby DOWNRIGHT % 100 + 1");
        ParserPlans ee = new ParserPlans(e);
        Assertions.assertEquals(8,ee.parseExpr());
    }
}