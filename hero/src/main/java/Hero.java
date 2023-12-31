import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import java.io.IOException;

public class Hero extends Element{
    public Hero(int x, int y) {
        super(x, y);
    }

    public Position moveUp() {
        //y--;
        return new Position(getPosition().getX(), getPosition().getY() - 1);
    }

    public Position moveDown() {
        //y++;
        return new Position(getPosition().getX(), getPosition().getY() + 1);
    }

    public Position moveRight() {
        //x++;
        return new Position(getPosition().getX() + 1, getPosition().getY());
    }

    public Position moveLeft() {
        //x--;
        return new Position(getPosition().getX() - 1, getPosition().getY());
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "X");
    }

}
