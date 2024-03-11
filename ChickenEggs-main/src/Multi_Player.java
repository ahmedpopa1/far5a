import com.sun.opengl.util.GLUT;

import javax.media.opengl.GL;
public class Multi_Player extends RandomStructure {

    Multi_Player() {

    }
    public void runMulti(GL gl) {


        DrawMultiBack(gl, textures);
        basketEgg basket1 = new basketEgg(gl, xBasket1, 7);
        basket1.drawBasket(1.2f, textures, animationBasket1);
        basketEgg basket0 = new basketEgg(gl, xBasket0, 7);
        basket0.drawBasket(1.2f, textures, animationBasket0);
        RandomStructure_MultiPlayer(gl);
        Collusion collusion=new Collusion();
        collusion.collisionMulti();
        collusion.notCollision_Multi();
        winLose_multi();

        drawScore0(gl);
        drawScore1(gl);
        drawLives0(gl);
        drawLives1(gl);
        drawTime(gl);

//                counter += 2;
//                System.out.println(counter);
        }
    private void drawScore0(GL gl) {
        // gl.glColor3f(0.0f, 0.0f, 0.0f); // Set color to black
        gl.glRasterPos2f(-0.9f, 0.9f); // Set position for drawing


        String scoreString = "Score: " + score0;
        for (char c : scoreString.toCharArray()) {
            glut.glutBitmapCharacter(GLUT.BITMAP_HELVETICA_18, c);
        }
    }
    private void drawScore1(GL gl) {
        // gl.glColor3f(0.0f, 0.0f, 0.0f); // Set color to black
        gl.glRasterPos2f(0.1f, 0.9f); // Set position for drawing


        String scoreString = "Score: " + score1;
        for (char c : scoreString.toCharArray()) {
            glut.glutBitmapCharacter(GLUT.BITMAP_HELVETICA_18,  c);
        }
    }
    private void drawLives0(GL gl) {
        // Display the remaining lives on the screen
        gl.glRasterPos2f(-0.65f, 0.9f);

        String livesString = "Lives: " + lives0;

        for (char c : livesString.toCharArray()) {
            glut.glutBitmapCharacter(GLUT.BITMAP_HELVETICA_18,  c);
        }
    }
    private void drawLives1(GL gl) {
        // Display the remaining lives on the screen
        gl.glRasterPos2f(0.35f, 0.9f);

        String livesString = "Lives: " + lives1;

        for (char c : livesString.toCharArray()) {
            glut.glutBitmapCharacter(GLUT.BITMAP_HELVETICA_18, c);
        }
    }

    public int randomGet_multi2(){
        flagRandom_multi2 =false;
        return (int) (Math.random()*3);

    }
    public void DrawMultiBack(GL gl, int[] textures) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[9]);    // Turn Blending On

        gl.glPushMatrix();
        gl.glBegin(GL.GL_QUADS);
        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glEnd();
        gl.glPopMatrix();

        gl.glDisable(GL.GL_BLEND);
    }


}

