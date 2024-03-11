import javax.media.opengl.GL;
public class Eggs extends AnimGLEventListener3 {
    int xEgg,yEgg;
    public Eggs(int x , int y) {
        this.xEgg =x;
        this.yEgg =y;

    }

    public void drawEgg(GL gl,float scale,int [] textures){
        if(!drawEgg) {
         return;
        }

            gl.glEnable(GL.GL_BLEND);
            gl.glBindTexture(GL.GL_TEXTURE_2D, textures[5]);    // Turn Blending On

            gl.glPushMatrix();
            gl.glTranslated( xEgg/(maxWidth/2.0) - 0.9, yEgg/(maxHeight/2.0) - 0.9, 0);
            gl.glScaled(0.1*scale, 0.1*scale, 1);
            //System.out.println(x +" " + y);
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
            yEgg--;
        }

    }

