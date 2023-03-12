package paser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.text.ParseException;

class ParserPlansTest {
    @Test
    public void ParserPTest() throws SyntaxError, EvalError, ParseException, LexicalError {
        TokenizerPlans w = new TokenizerPlans("done UP");
        ParserPlans ww = new ParserPlans(w);
        Assertions.assertEquals(8,ww.parse());
    }
}