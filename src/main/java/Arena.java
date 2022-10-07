import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {

    private int width;
    private int height;
    private Hero hero;

    public Arena(int width, int height, Hero hero){
        this.width = width;
        this.height = height;
        this.hero = hero;
    }

    public void moveHero(Position position){
        if(canHeroMove(position)){
            hero.setPosition(position);
        }
    }
    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#E4E3A3"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        this.hero.draw(graphics);
    }

    private boolean canHeroMove(Position position){
        if(position.getX() < 0 || position.getX() > width -1){
            return false;
        }
        if(position.getY() < 0 || position.getY() > height- 1){
            return false;
        }
        return true;
    }
}

