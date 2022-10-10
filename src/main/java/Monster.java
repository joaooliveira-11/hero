import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element {
    public Monster(Position position) {
        super(position);
    }

    public Position move() {
        int number = new Random().nextInt(4);
        switch (number) {
            case 0:
                return new Position(getPosition().getX(), getPosition().getY() - 1);
            case 1:
                return new Position(getPosition().getX(), getPosition().getY() + 1);
            case 2:
                return new Position(getPosition().getX() - 1, getPosition().getY());
            case 3:
                return new Position(getPosition().getX() + 1, getPosition().getY());
            default:
                break;
        }
        return null;
    }
    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#000bb0"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "X");
    }
}
