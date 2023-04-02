package Frontend.paser;

public class MoveCmd extends Cmd {
    private Direction direction;

    MoveCmd(Direction direction) {
        super(false);
        this.direction = direction;
    }
}
