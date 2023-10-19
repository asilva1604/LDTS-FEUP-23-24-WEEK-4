import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.googlecode.lanterna.input.*;

class ArenaTest {
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);
    }

    @Test
    void processKey_MonsterMove() {
        Monster monster = mock(Monster.class);
        when(monster.nextMove()).thenReturn(new Position(9, 10));
        arena.monsters = List.of(monster);

        arena.processKey(new KeyStroke(KeyType.ArrowLeft));

        verify(monster).move(new Position(9, 10));
    }

    @Test
    void processKey_HeroMove() {
        KeyStroke keyStroke = new KeyStroke(KeyType.ArrowLeft);

        arena.processKey(keyStroke);

        assertEquals(new Position(9, 10), arena.hero.getPosition());
    }

    @Test
    void draw() {
        TextGraphics graphics = mock(TextGraphics.class);

        assertDoesNotThrow(() -> arena.draw(graphics));
    }

    @Test
    void verifyMonsterCollisions_NoCollision() {
        arena.hero.setPosition(new Position(5, 5));
        Monster monster = new Monster(10, 10);
        arena.monsters = List.of(monster);

        assertFalse(arena.verifyMonsterCollisions());
    }

    @Test
    void verifyMonsterCollisions_Collision() {
        arena.hero.setPosition(new Position(10, 10));
        Monster monster = new Monster(10, 10);
        arena.monsters = List.of(monster);

        assertTrue(arena.verifyMonsterCollisions());
    }

    @Test
    void canHeroMove_ValidPosition() {
        assertTrue(arena.canHeroMove(new Position(5, 5)));
    }

    @Test
    void canHeroMove_WallBlock() {
        Wall wall = new Wall(5, 5);
        arena.walls.add(wall);

        assertFalse(arena.canHeroMove(new Position(5, 5)));
    }

}
