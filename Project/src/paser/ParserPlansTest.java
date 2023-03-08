package paser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class ParserPlansTest {
    @Test
    public void ParserPTest() throws SyntaxError, EvalError, ParseException, LexicalError {
        TokenizerPlans w = new TokenizerPlans("done");
        ParserPlans ww = new ParserPlans(w);
        Assertions.assertEquals(true,ww.parse());
    }
}