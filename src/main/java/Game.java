import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private Hero hero;

    public Game() throws IOException {
        TerminalSize terminalSize = new TerminalSize(40, 20);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();

        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

        Position position = new Position(10, 10);
        this.hero = new Hero(position);
    }

    private void draw() throws IOException {
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }

    public void run() throws IOException {
        boolean test = true;
        while (test) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
            switch (key.getKeyType()) {
                case ArrowUp:
                    moveHero(hero.moveUp());
                    break;
                case ArrowDown:
                    moveHero(hero.moveDown());
                    break;
                case ArrowRight:
                    moveHero(hero.moveRight());
                    break;
                case ArrowLeft:
                    moveHero(hero.moveLeft());
                    break;
                case Character:
                    if (key.getCharacter() == 'q') {
                        screen.close();
                    }
                    break;
                case EOF:
                    test = false;
                    break;
            }
        }
    }


    private void moveHero(Position position) {
        hero.setPosition(position);
    }
    private void processKey(KeyStroke key) {
        System.out.println(key);
    }


}
