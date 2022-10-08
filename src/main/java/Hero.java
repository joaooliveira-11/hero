import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class Hero extends Element {
    private Position position;

    public Hero(Position position){
        super(position);
    }
    public Position moveUp(){
        return new Position(getPosition().getX(), getPosition().getY() - 1);
    }
    public Position moveDown(){
        return new Position(getPosition().getX(), getPosition().getY() + 1);
    }
    public Position moveLeft(){
        return new Position(getPosition().getX() -1, getPosition().getY());
    }
    public Position moveRight(){
        return new Position(getPosition().getX() + 1, getPosition().getY());
    }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#BE99CC"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(this.getHeroX(), this.getHeroY()), "x");
    }
}