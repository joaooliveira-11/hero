import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    protected Position position;
    public Element(){
        this.position = new Position(5,5);
    }

    public Element(Position position){
        this.position = position;
    }

    public abstract void draw(TextGraphics graphics);

    public void setPosition(Position position){
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
    public int getHeroX(){
        return this.position.getX();
    }

    public int getHeroY(){
        return this.position.getY();
    }


}
