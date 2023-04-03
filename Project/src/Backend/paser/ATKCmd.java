package Backend.paser;


public class ATKCmd extends Cmd {
    private Direction direction;
    private Expression Expr;

    ATKCmd(Direction direction, Expression Expr) {
        super(false);
        this.Expr = Expr;
        this.direction = direction;
    }
}
