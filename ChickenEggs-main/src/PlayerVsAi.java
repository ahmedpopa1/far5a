//PlayerVsAi {
import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;
import java.util.Arrays;

public class PlayerVsAi extends AnimGLEventListener3 {
    static Eggs[] numOfEggs_multi1 = new Eggs[6];
    static boolean runMulti = true;
    static boolean[] flags_multi = new boolean[4];
    static int random0;
    static int random1;
    static int random2;
    static boolean flagRandom_multi2 = true;
    static boolean flagRandom_multi = true;
    static int[] xEggs_multi = {8, 20, 32, 58, 70, 83};
    static int[] yEggs_multi = {65, 65, 65, 65, 65, 65};
    static int animationBasket0 = 1;
    static int animationBasket1 = 1;
    static int z;
    static int m;
    static int lives1 = 6;
    static int lives0 = 6;
    static int score0 = 0;
    static int score1 = 0;
    static int counter = 0;

    PlayerVsAi() {
    }

    public void runMulti(GL gl) {
        DrawMultiBack(gl, textures);
        basketEgg basket1 = new basketEgg(gl, xBasket1, 7);
        basket1.drawBasket(1.2f, textures, animationBasket1);
        basketEgg basket0 = new basketEgg(gl, xBasket0, 7);
        basket0.drawBasket(1.2f, textures, animationBasket0);

        if (runMulti) {
            if (flagRandom_multi && flagRandom_multi2) {
                R = randomGet_multi();
                random0 = randomGet_multi2();
            }
            numOfEggs_multi1[0] = new Eggs(xEggs_multi[random0], yEggs_multi[0]);
            numOfEggs_multi1[3] = new Eggs(xEggs_multi[R], yEggs_multi[3]);
            numOfEggs_multi1[0].drawEgg(gl, 0.5f, textures);
            numOfEggs_multi1[3].drawEgg(gl, 0.5f, textures);

            moveAIBasket0TowardsEgg();  // Added AI logic for the first basket

            if (counter < 1000) {
                yEggs_multi[0]--;
                yEggs_multi[3]--;
            } else if (counter > 1000 && counter < 2000) {
                yEggs_multi[0] -= 2;
                yEggs_multi[3] -= 2;
            } else {
                yEggs_multi[0] -= 4;
                yEggs_multi[3] -= 4;
            }

            if (numOfEggs_multi1[3].yEgg < 20 && numOfEggs_multi1[0].yEgg < 20) {
                if (!flags_multi[2] && !flags_multi[0]) {
                    z = (int) (Math.random() * 3) + 3;
                    flags_multi[2] = true;
                    random1 = (int) (Math.random() * 3);
                    flags_multi[0] = true;
                }
                numOfEggs_multi1[1] = new Eggs(xEggs_multi[random1], yEggs_multi[1]);
                numOfEggs_multi1[4] = new Eggs(xEggs_multi[z], yEggs_multi[4]);
                numOfEggs_multi1[1].drawEgg(gl, 0.5f, textures);
                numOfEggs_multi1[4].drawEgg(gl, 0.5f, textures);

//                moveAIBasket0TowardsEgg();  // Added AI logic for the second basket

                if (counter < 1000) {
                    yEggs_multi[1]--;
                    yEggs_multi[4]--;
                } else if (counter > 1000 && counter < 2000) {
                    yEggs_multi[1] -= 2;
                    yEggs_multi[4] -= 2;
                } else {
                    yEggs_multi[1] -= 4;
                    yEggs_multi[4] -= 4;
                }

                if (numOfEggs_multi1[4].yEgg < 40 && numOfEggs_multi1[1].yEgg < 40) {
                    if (!flags_multi[3] && !flags_multi[1]) {
                        m = (int) (Math.random() * 3) + 3;
                        flags_multi[3] = true;
                        random2 = (int) (Math.random() * 3);
                        flags_multi[1] = true;
                    }
                    numOfEggs_multi1[2] = new Eggs(xEggs_multi[random2], yEggs_multi[5]);
                    numOfEggs_multi1[5] = new Eggs(xEggs_multi[m], yEggs_multi[5]);
                    numOfEggs_multi1[2].drawEgg(gl, 0.5f, textures);
                    numOfEggs_multi1[5].drawEgg(gl, 0.5f, textures);

//                    moveAIBasket0TowardsEgg();  // Added AI logic for the third basket

                    if (counter < 1000) {
                        yEggs_multi[5]--;
                        yEggs_multi[2]--;
                    } else if (counter > 1000 && counter < 2000) {
                        yEggs_multi[5] -= 2;
                        yEggs_multi[2] -= 2;
                    } else {
                        yEggs_multi[5] -= 4;
                        yEggs_multi[2] -= 4;
                    }

                    if (yEggs_multi[5] < 7 && yEggs_multi[2] < 7) {
                        runMulti = false;
                    }
                }
            }

            if (!runMulti) {
                Arrays.fill(numOfEggs_multi1, null);
                Arrays.fill(flags_multi, false);
                runMulti = true;
                Arrays.fill(yEggs_multi, 65);
                flagRandom_multi = true;
                flagRandom_multi2 = true;
            }

            collusionMulti();
            Collisions_multi();

            drawScore0(gl);
            drawScore1(gl);
            drawLives0(gl);
            drawLives1(gl);
            drawTime(gl);
            counter += 2;
            System.out.println(counter);
        }
    }

    private void moveAIBasket0TowardsEgg() {
        int closestEggIndex = findClosestEggIndex(0);  // Assuming basketIndex 0 corresponds to xBasket0
        if (closestEggIndex != -1) {
            int targetX = numOfEggs_multi1[closestEggIndex].xEgg;
            int currentX = xBasket0;
            int direction = (targetX > currentX) ? 1 : -1;  // Move towards the target egg
            if (Math.abs(targetX - currentX) >= 1) {
                xBasket0 += direction;
                xInitial0 +=direction;
                xEnd0 +=direction;
            }
        }
    }

    private int findClosestEggIndex(int basketIndex) {
        //  int basketX = (basketIndex == 0) ? xBasket0 : xBasket1;
        int closestIndex = -1;
        double minDistance = Double.MAX_VALUE;
        int ycollusionai = 10; // Adjust this threshold as needed

        for (int i = 0; i < numOfEggs_multi1.length; i++) {
            if (numOfEggs_multi1[i] != null && numOfEggs_multi1[i].yEgg > ycollusionai) {
                int eggX = numOfEggs_multi1[i].xEgg;
                double distance = calculateDistance(xBasket0, eggX);
                if (distance < minDistance) {
                    minDistance = distance;
                    closestIndex = i;
                }
            }
        }
        return closestIndex;
    }


    private double calculateDistance(int x1, int x2) {
        return Math.abs(x1 - x2);
    }

    public int randomGet_multi() {
        flagRandom_multi = false;
        return (int) (Math.random() * 3) + 3;
    }

    public void collusionMulti() {
        for (int i = 0; i < 3; i++) {
            if (yEggs_multi[i] == 13 && (numOfEggs_multi1[i].xEgg >= xInitial0 && numOfEggs_multi1[i].xEgg <= xEnd0)) {
                System.out.println("Abd 3obaida");
                yEggs_multi[i] = -10;
                score0++;
                if (animationBasket0 < 4) {
                    animationBasket0++;
                }
                isCollusion = true;
            }
        }
        for (int i = 3; i < numOfEggs_multi1.length; i++) {
            if (yEggs_multi[i] == 13 && (numOfEggs_multi1[i].xEgg >= xInitial1 && numOfEggs_multi1[i].xEgg <= xEnd1)) {
                yEggs_multi[i] = -10;
                score1++;
                if (animationBasket1 < 4) {
                    animationBasket1++;
                }
                isCollusion = true;
            }
        }
    }

    public void Collisions_multi() {
        for (int i = 0; i < numOfEggs_multi1.length - 3; i++) {
            if (yEggs_multi[i] == 9) {
                yEggs_multi[i] = -10;
                if (lives0 > 0) {
                    lives0--;
                }
            }
        }
        for (int i = 3; i < numOfEggs_multi1.length; i++) {
            if (yEggs_multi[i] == 9) {
                yEggs_multi[i] = -10;
                if (lives1 > 0) {
                    lives1--;
                }
            }
        }
    }

    private void drawScore0(GL gl) {
        gl.glRasterPos2f(-0.9f, 0.9f);
        String scoreString = "Score: " + score0;
        for (char c : scoreString.toCharArray()) {
            glut.glutBitmapCharacter(GLUT.BITMAP_HELVETICA_18, (char) c);
        }
    }

    private void drawScore1(GL gl) {
        gl.glRasterPos2f(0.1f, 0.9f);
        String scoreString = "Score: " + score1;
        for (char c : scoreString.toCharArray()) {
            glut.glutBitmapCharacter(GLUT.BITMAP_HELVETICA_18, (char) c);
        }
    }

    private void drawLives0(GL gl) {
        gl.glRasterPos2f(-0.65f, 0.9f);
        String livesString = "Lives: " + lives0;
        for (char c : livesString.toCharArray()) {
            glut.glutBitmapCharacter(GLUT.BITMAP_HELVETICA_18, (char) c);
        }
    }

    private void drawLives1(GL gl) {
        gl.glRasterPos2f(0.35f, 0.9f);
        String livesString = "Lives: " + lives1;
        for (char c : livesString.toCharArray()) {
            glut.glutBitmapCharacter(GLUT.BITMAP_HELVETICA_18, (char) c);
        }
    }

    public int randomGet_multi2() {
        flagRandom_multi2 = false;
        return (int) (Math.random() * 3);
    }

    public void DrawMultiBack(GL gl, int[] textures) {
        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures[9]);
        gl.glPushMatrix();
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
}