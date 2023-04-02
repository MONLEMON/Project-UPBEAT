package Frontend.paser;

import java.util.Map;

public interface Expression extends Node {
    double eval(Map<String, Integer> bindings) throws EvalError;

    void prettyPrint(StringBuilder s);
}
