import Texture.TextureReader;

import java.awt.event.*;
import java.io.IOException;
import javax.media.opengl.*;
import java.util.BitSet;
import javax.media.opengl.glu.GLU;
import javax.swing.*;
import java.util.Timer;

import com.sun.opengl.util.GLUT;

import java.awt.*;

public class AnimGLEventListener3 extends AnimListener implements MouseListener {
    private Timer timer;
    private static int relativeTime = 0;
    static boolean J=true;
    static boolean PlayAi=false;
    static boolean Ai=false;



    static int xBasket0 = 20, xInitial0 = 16, xEnd0 = 23, xBasket1 = 70, xInitial1 = 66, xEnd1 = 73;
    static int lives = 15;
    static int animationBasket0 = 1;
    static int animationBasket1 = 1;
    static int lives1 = 6;
    static int lives0 = 6;
    static int score0 = 0;
    static int score1 = 0;
    static double xHome1 = 0;
    static double yHome1 = 0;
    static double xHome2 = 0;
    static double yHome2 = 0;
    static double xHome3 = 0;
    static double yHome3 = 0;
    static int animationIndex = 1;
    static int maxWidth = 100;
    static int maxHeight = 100;
    static int xBasket = 50;
    static int yBasket = 10;
    static int xInitial = 41;
    static int xEnd = 61;
    static int score;
    static int R;
    static Eggs[] numOfEggs = new Eggs[3];
    static boolean run = true;
    boolean isCollusion = false;
    static boolean drawEgg = true;
    static boolean home2 = false;
    static boolean home3 = false;
    static boolean easy = false;
    static boolean how = false;
    static boolean medium = false;
    static boolean hard = false;
    static boolean backButton = false;
    static boolean Multi = false;
    static boolean flagRandom = true;
    static String[] textureNames = {"Back1.png", "Basket1.png", "Basket2.png", "Basket3.png", "Basket4.png", "Egg1.png", "Home1.png", "Home2.png", "Home3.png", "MULTI.png", "backButton.png","how.png","soundoff.png"};
    TextureReader.Texture[] texture = new TextureReader.Texture[textureNames.length];
    static int[] textures = new int[textureNames.length];
    static int[] yEggs = {65, 65, 65};
    static GLUT glut = new GLUT();

    String username ;

    public void init(GLAutoDrawable gld) {

        timer = new Timer();
        GL gl = gld.getGL();
        AudioPlayer audioPlayerMain = new AudioPlayer();
        audioPlayerMain.load("C:\\Mohamed\\ChickenEggs\\src\\Sound\\chicken dance song.wav");
        audioPlayerMain.play();

        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);    //This Will Clear The Background Color To Black

        gl.glEnable(GL.GL_TEXTURE_2D);  // Enable Texture Mapping
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
        gl.glGenTextures(textureNames.length, textures, 0);

        for (int i = 0; i < textureNames.length; i++) {
            try {
                texture[i] = TextureReader.readTexture(assetsFolderName + "//" + textureNames[i], true);
                gl.glBindTexture(GL.GL_TEXTURE_2D, textures[i]);

                new GLU().gluBuild2DMipmaps(
                        GL.GL_TEXTURE_2D,
                        GL.GL_RGBA, // Internal Texel Format,
                        texture[i].getWidth(), texture[i].getHeight(),
                        GL.GL_RGBA, // External format from image,
                        GL.GL_UNSIGNED_BYTE,
                        texture[i].getPixels() // Imagedata
                );
            } catch (IOException e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }
    }

    public void display(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);       //Clear The Screen And The Depth Buffer
        gl.glLoadIdentity();
        Backgrounds backgrounds = new Backgrounds();
        Multi_Player multi = new Multi_Player();
        backgrounds.DrawMenu(gl);
        if (Multi) {
            multi.runMulti(gl);
        }
        if(PlayAi){
            PlayerVsAi ai = new PlayerVsAi();
            Ai=true;
            ai.runMulti(gl);
        }
        if(how){
            backgrounds.DrawInstructions(gl,textures);
            backgrounds.DrawBack_button(gl,textures);

        }
        handleKeyPress();
        handleKeyPress1();
    }


    public void drawScore(GL gl) {
        // gl.glColor3f(0.0f, 0.0f, 0.0f); // Set color to black
        gl.glRasterPos2f(-0.9f, 0.9f); // Set position for drawing


        String scoreString = "Score: " + score;
        for (char c : scoreString.toCharArray()) {
            glut.glutBitmapCharacter(GLUT.BITMAP_HELVETICA_18,  c);
        }
    }

    public void drawLives(GL gl) {
        // Display the remaining lives on the screen
        gl.glRasterPos2f(-0.9f, 0.8f);

        String livesString = "Lives: " + lives;

        for (char c : livesString.toCharArray()) {
            glut.glutBitmapCharacter(GLUT.BITMAP_HELVETICA_18,  c);
        }
    }
    public static void drawTime(GL gl) {
        Time time = new Time();
        gl.glRasterPos2f(0.7f, 0.9f);
        String scoreString = "Time: " + time.getTime(relativeTime / 15);
        relativeTime++;
        for (char c : scoreString.toCharArray()) {
            glut.glutBitmapCharacter(GLUT.BITMAP_HELVETICA_18,  c);
        }
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }



    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void notCollision() {
        for (int i = 0; i < numOfEggs.length; i++) {
            if (yEggs[i] == 9) {
                if (lives > 0) {
                    lives--;
                }
                yEggs[i] = -10;

            }
        }
    }

    public void collision() {
        for (int i = 0; i < numOfEggs.length; i++) {
            if (yEggs[i] == 21 && (numOfEggs[i].xEgg > xInitial && numOfEggs[i].xEgg < xEnd)) {
                yEggs[i] = -10;
                score++;
                if (animationIndex < 4) {
                    animationIndex++;
                }
                isCollusion = true;
            }


        }
    }

    public void handleKeyPress() {

        if (isKeyPressed(KeyEvent.VK_LEFT)) {
            if (xBasket > 5) {
                xBasket -= 2;
                xInitial -= 2;
                xEnd -= 2;
            }

        }
        if (isKeyPressed(KeyEvent.VK_RIGHT)) {
            if (xBasket < maxWidth - 15) {
                xBasket += 2;
                xInitial += 2;
                xEnd += 2;
            }

        }


    }

    public void handleKeyPress1() {

        if(!Ai) {

            if (isKeyPressed(KeyEvent.VK_LEFT)) {
                if (xBasket0 > 5) {
                    xBasket0 -= 2;
                    xInitial0 -= 2;
                    xEnd0 -= 2;
                }
            }

            if (isKeyPressed(KeyEvent.VK_RIGHT)) {
                if (xBasket0 < maxWidth - 65) {
                    xBasket0 += 2;
                    xInitial0 += 2;
                    xEnd0 += 2;
                }
            }
        }

        if (isKeyPressed(KeyEvent.VK_D)) {
            if (xBasket1 < 87.5) {
                xBasket1 += 2;
                xInitial1 += 2;
                xEnd1 += 2;
            }
        }

        if (isKeyPressed(KeyEvent.VK_A)) {
            if (xBasket1 > 52) {
                xBasket1 -= 2;
                xInitial1 -= 2;
                xEnd1 -= 2;
            }
        }
    }


    public BitSet keyBits = new BitSet(256);

    @Override
    public void keyPressed(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.set(keyCode);
    }

    @Override
    public void keyReleased(final KeyEvent event) {
        int keyCode = event.getKeyCode();
        keyBits.clear(keyCode);
    }

    @Override
    public void keyTyped(final KeyEvent event) {
        // don't care
    }

    public boolean isKeyPressed(final int keyCode) {
        return keyBits.get(keyCode);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        double x = e.getX();
        double y = e.getY();
        Component c = e.getComponent();
        double width = c.getWidth();
        double height = c.getHeight();
        xHome1 = ((int) (((x / width) * 100)));
        yHome1 = ((int) (((-y / height) * 100)) + 100);
        if (home2&&!home3) {
            xHome2 = ((int) (((x / width) * 100)));
            yHome2 = ((int) (((-y / height) * 100)) + 100);
        }
        if (home3&&J) {

            xHome3 = ((int) (((x / width) * 100)));
            yHome3 = ((int) (((-y / height) * 100)) + 100);
        }
      //  System.out.println("x is " + xHome1 + "  y is  " + yHome1);
    }
    public static void winLose_single_easy(){
        if(lives==0){
            int choice = JOptionPane.showOptionDialog(null, "u lost " , "Game Over", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"New","End"}, "new");

            if(choice==0){
                lives=20;
              easy=true;
                J=false;
                animationIndex=1;
                score=0;
            }
            if(choice==1){
                System.exit(0);
            }

        }
        if(score==7){
            int a = JOptionPane.showOptionDialog(null, "u win " , "Good game", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"New","End"}, "new");
            if(a==0){
                lives=20;
                hard=true;
                J=false;
                animationIndex=1;
                score=0;
            }
            if(a==1){
                System.exit(0);
            }
        }
    }
    public static void winLose_single_medium(){
        if(lives==0){
            int choice = JOptionPane.showOptionDialog(null, "u lost " , "Game Over", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"New","End"}, "new");

            if(choice==0){
                lives=20;
                medium=true;
                J=false;
                animationIndex=1;
                score=0;
            }
            if(choice==1){
                System.exit(0);
            }

        }
        if(score==7){
            int a = JOptionPane.showOptionDialog(null, "u win " , "Good game", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"New","End"}, "new");
            if(a==0){
                lives=20;
                hard=true;
                J=false;
                animationIndex=1;
                score=0;
            }
            if(a==1){
                System.exit(0);
            }
        }
    }

    public static void winLose_single_hard(){

        if(lives==0) {
            int choice = JOptionPane.showOptionDialog(null, "u lost ", "Game Over", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"New", "End"}, "new");

            if (choice == 0) {
                lives = 20;
                hard = true;
                J = false;
                animationIndex = 1;
                score = 0;
            }
            if (choice == 1) {
                System.exit(0);
            }
        }
            if(score==7){
                int a = JOptionPane.showOptionDialog(null, "u win " , "Good game", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"New","End"}, "new");
                if(a==0){
                    lives=20;
                    hard=true;
                    J=false;
                    animationIndex=1;
                    score=0;
                }
                if(a==1){
                    System.exit(0);
                }
            }

        }
    public static void winLose_multi(){

        if(lives0==0&&lives1!=0) {
            int choice = JOptionPane.showOptionDialog(null, "Player 2 Win ", "The Winner", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"New", "End"}, "new");

            if (choice == 0) {
                lives0 = 20;
                lives1 = 20;
                Multi = true;

                J = false;
                animationBasket0 = 1;
                animationBasket1 = 1;
                score0 = 0;
                score1 = 0;
            }
            if (choice == 1) {
                System.exit(0);
            }
        }



        if(lives0!=0&&lives1==0){
            int a = JOptionPane.showOptionDialog(null, "Player 1 win " , "The winner", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"New","End"}, "new");
            if(a==0){
                lives0 = 20;
                lives1 = 20;
                Multi = true;

                J = false;
                animationBasket0 = 1;
                animationBasket1 = 1;
                score0 = 0;
                score1 = 0;
            }
            if(a==1){
                System.exit(0);
            }
        }
        if(score0==7&&score0>score1){
            int a = JOptionPane.showOptionDialog(null, "Player 2 win " , "The winner", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"New","End"}, "new");
            if(a==0){
                lives0 = 20;
                lives1 = 20;
                Multi = true;

                J = false;
                animationBasket0 = 1;
                animationBasket1 = 1;
                score0 = 0;
                score1 = 0;
            }
            if(a==1){
                System.exit(0);
            }
        }
        if(score1==7&&score1>score0){
            int a = JOptionPane.showOptionDialog(null, "Player 1 win " , "The winner", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"New","End"}, "new");
            if(a==0){
                lives0 = 20;
                lives1 = 20;
                Multi = true;

                J = false;
                animationBasket0 = 1;
                animationBasket1 = 1;
                score0 = 0;
                score1 = 0;
            }
            if(a==1){
                System.exit(0);
            }
        }

    }




    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
