package Frontend.paser;

public class RegionCmd extends Cmd {
    private Expression Expr;
    private Regions command;

    RegionCmd(Regions command, Expression Expr) {
        super(false);
        this.Expr = Expr;
        this.command = command;
    }

}
