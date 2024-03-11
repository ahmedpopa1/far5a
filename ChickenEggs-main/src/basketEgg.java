import javax.media.opengl.GL;
public class basketEgg extends AnimGLEventListener3{
    int  xBasket;
    int yBasket;
    GL gl;

    basketEgg(GL gl,int x,int y){
      this.xBasket=x;
      this.yBasket=y;
      this.gl=gl;
    }

    public void drawBasket(float scale,int [] textures,int a){
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[a]);	// Turn Blending On

        gl.glPushMatrix();
        gl.glTranslated( xBasket/(maxWidth/2.0) - 0.9, yBasket/(maxHeight/2.0) - 0.9, 0);
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
    }
}
