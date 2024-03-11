import javax.media.opengl.GL;

public class Backgrounds extends AnimGLEventListener3 {

    Backgrounds() {

    }

    public void DrawBack_button(GL gl, int[] textures) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[10]);    // Turn Blending On

        gl.glPushMatrix();
        gl.glTranslated(-0.9, 1.75 - 0.9, 0);
        gl.glScaled(0.1, 0.1, 1);
        gl.glBegin(GL.GL_QUADS);

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

    public static void DrawBackground(GL gl, int[] textures) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[0]);    // Turn Blending On

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

    public void DrawHome1(GL gl, int[] textures) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[6]);    // Turn Blending On

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

    public void DrawHome2(GL gl, int[] textures) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[7]);    // Turn Blending On

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

    public void DrawHome3(GL gl, int[] textures) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[8]);    // Turn Blending On

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

    public void DrawMenu(GL gl) {
        Levels levels = new Levels();
        if (!home2) {
            DrawHome1(gl, textures);
        }
        if ((xHome1 > 34 && xHome1 < 64) && (yHome1 > 66 && yHome1 < 83)) {
            home2 = true;
        }
        if (home2 && !home3) {
            DrawHome2(gl, textures);
            DrawBack_button(gl, textures);
        }
        if ((xHome2 > 34 && xHome2 < 64) && (yHome2 > 43 && yHome2 < 58)) {
            Multi = true;

        }
        if ((xHome2 > 34 && xHome2 < 64) && (yHome2 > 66 && yHome2 < 83)) {
            xHome2 = yHome2 = 0;
            home3 = true;
        }

        if ((xHome2 > 1 && xHome2 < 7) && (yHome2 > 91 && yHome2 < 96)) {
            backButton = true;
            xHome2 = yHome2 = 0;
        }
        if((xHome2>34&&xHome2<64)&&(yHome2>21&&yHome2<37)){
            PlayAi=true;
        }
        if (backButton) {
            home2 = false;
            backButton = false;
        }

        if ((xHome3 > 1 && xHome3 < 7) && (yHome3 > 91 && yHome3 < 96)) {
            backButton = true;
            xHome3 = yHome3 = 0;

        }
        if ((xHome1 >= 1 && xHome1 <= 7) && (yHome1 >= 91 && yHome1 <= 96)) {
            backButton = true;
            how=false;
            xHome1 = yHome1 = 0;

        }
        if (backButton) {
            home3 = false;
            backButton = false;
        }




        if (home3 && !easy) {
            DrawHome3(gl, textures);
            DrawBack_button(gl, textures);
        }
        if ((xHome3 > 31 && xHome3 < 67) && (yHome3 > 64 && yHome3 < 78)) {

            easy = true;

        }
        if ((xHome3 > 34 && xHome3 < 64) && (yHome3 > 43 && yHome3 < 58)) {

            medium = true;
        }
        if ((xHome3 > 34 && xHome3 < 64) && (yHome3 > 23 && yHome3 < 40)) {

            hard = true;
        }


        if (easy && (!hard && !medium)) {
            DrawBackground(gl, textures);
            levels.easy(gl, textures);

        }
        if (medium && (!easy && !hard)) {
            DrawBackground(gl, textures);
            levels.medium(gl, textures);
        }
        if (hard && (!easy && !medium)) {
            DrawBackground(gl, textures);
            levels.hard(gl, textures);
        }
        if ((xHome1 > 34 && xHome1 < 64) && (yHome1 > 45 && yHome1 < 60)&&!home2) {

           how=true;
            xHome1=yHome1=0;
        }
        if ((xHome1 > 34 && xHome1 < 64) && (yHome1 > 23 && yHome1 < 35)&&!home2){
            xHome1=yHome1=0;
            System.exit(0);
        }
    }
    public void DrawInstructions(GL gl, int[] textures) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[11]);    // Turn Blending On

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

