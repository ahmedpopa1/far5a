import javax.media.opengl.GL;
import java.io.IOException;


public class Levels extends RandomStructure {

    public Levels() {

        super();
    }

    public  void easy(GL gl, int[] textures)  {

        basketEgg basket1 = new basketEgg(gl, xBasket, yBasket);
        basket1.drawBasket(2.0f, textures, animationIndex);
        RandomStructure_Single_Easy(gl);
        Collusion collusion=new Collusion();
        collusion.collision();
        drawScore(gl);
        drawLives(gl);
        drawTime(gl);
        collusion.notCollision();
        winLose_single_easy();

    }

    public void medium(GL gl, int[] textures) {


        basketEgg basket1 = new basketEgg(gl, xBasket, yBasket);
        basket1.drawBasket(2.0f, textures, animationIndex);
        RandomStructure_Single_Medium(gl);
        Collusion collusion=new Collusion();
        collusion.collision();
        drawScore(gl);
        drawLives(gl);
        drawTime(gl);
        collusion.notCollision();
        winLose_single_medium();


        handleKeyPress();
    }

    public void hard(GL gl, int[] textures) {


        basketEgg basket1 = new basketEgg(gl, xBasket, yBasket);
        basket1.drawBasket(2.0f, textures, animationIndex);
        RandomStructure_Single_Hard(gl);
        Collusion collusion = new Collusion();
        collusion.collision();
        drawScore(gl);
        drawLives(gl);
        drawTime(gl);

        collusion.notCollision();
        handleKeyPress();
        winLose_single_hard();

    }
}