import javax.media.opengl.GL;
import java.util.Arrays;

public class RandomStructure extends AnimGLEventListener3 {
    static int[] xEggs_multi = {8, 20, 32, 58, 70, 83};
    static int[] yEggs_multi = {65, 65, 65, 65, 65, 65};
    static boolean runMulti = true;
    static boolean[] flags_multi = new boolean[4];
    static boolean flagRandom_multi = true;
    static boolean flagRandom_multi2 = true;
    static Eggs[] numOfEggs = new Eggs[3];
    static Eggs[] numOfEggs_multi = new Eggs[6];
    static boolean[] flags = new boolean[2];
    static int[] xEggs = {20, 45, 70};
    static int[] yEggs = {65, 65, 65};
    static int counter ;
    static int randomSingle0, randomSingle1, randomSingle2, randomMulti0, randomMulti1, randomMulti2, randomMulti3, randomMulti4, randomMulti5;

    public void RandomStructure_Single_Easy(GL gl) {
        if (run) {
            if (flagRandom) {
                randomSingle0 = randomGet_Single();
            }
            numOfEggs[0] = new Eggs(xEggs[randomSingle0], yEggs[0]);
            numOfEggs[0].drawEgg(gl, 0.8f, textures);
            yEggs[0]--;
            if (numOfEggs[0].yEgg < 20) {
                if (!flags[0]) {
                    randomSingle1 = (int) (Math.random() * 3);
                    System.out.println(randomSingle1);
                    flags[0] = true;
                }
                numOfEggs[1] = new Eggs(xEggs[randomSingle1], yEggs[1]);

                numOfEggs[1].drawEgg(gl, 0.8f, textures);
                yEggs[1]--;

                if (numOfEggs[1].yEgg < 40) {
                    if (!flags[1]) {
                        randomSingle2 = (int) (Math.random() * 3);
                        System.out.println(randomSingle2);
                        flags[1] = true;

                    }

                    numOfEggs[2] = new Eggs(xEggs[randomSingle2], yEggs[2]);
                    numOfEggs[2].drawEgg(gl, 0.8f, textures);
                    yEggs[2]--;


                }
                if (yEggs[2] < 8) {
                    run = false;
                }
            }
        }
        if (!run) {
            Arrays.fill(numOfEggs, null);
            Arrays.fill(flags, false);
            run = true;
            Arrays.fill(yEggs, 65);
            flagRandom = true;


        }

    }


    public void RandomStructure_Single_Medium(GL gl) {
        if (run) {
            if (flagRandom) {
                randomSingle0 = randomGet_Single();
                System.out.println(randomSingle0);
            }
            numOfEggs[0] = new Eggs(xEggs[randomSingle0], yEggs[0]);
            numOfEggs[0].drawEgg(gl, 0.8f, textures);
            yEggs[0] -= 2;
            if (numOfEggs[0].yEgg < 20) {
                if (!flags[0]) {
                    randomSingle1 = (int) (Math.random() * 3);
                    System.out.println(randomSingle1);
                    flags[0] = true;
                }
                numOfEggs[1] = new Eggs(xEggs[randomSingle1], yEggs[1]);

                numOfEggs[1].drawEgg(gl, 0.8f, textures);
                yEggs[1] -= 2;

                if (numOfEggs[1].yEgg < 40) {
                    if (!flags[1]) {
                        randomSingle2 = (int) (Math.random() * 3);
                        System.out.println(randomSingle2);
                        flags[1] = true;

                    }

                    numOfEggs[2] = new Eggs(xEggs[randomSingle2], yEggs[2]);
                    numOfEggs[2].drawEgg(gl, 0.8f, textures);
                    yEggs[2] -= 2;


                }
                if (yEggs[2] < 8) {
                    run = false;
                }
            }
        }
        if (!run) {
            Arrays.fill(numOfEggs, null);
            Arrays.fill(flags, false);
            run = true;
            Arrays.fill(yEggs, 65);
            flagRandom = true;

        }
    }

    public void RandomStructure_Single_Hard(GL gl) {
        if (run) {
            if (flagRandom) {
                randomSingle0 = randomGet_Single();
                System.out.println(randomSingle0);
            }
            numOfEggs[0] = new Eggs(xEggs[randomSingle0], yEggs[0]);
            numOfEggs[0].drawEgg(gl, 0.8f, textures);
            yEggs[0] -= 4;
            if (numOfEggs[0].yEgg < 20) {
                if (!flags[0]) {
                    randomSingle1 = (int) (Math.random() * 3);
                    System.out.println(randomSingle1);
                    flags[0] = true;
                }
                numOfEggs[1] = new Eggs(xEggs[randomSingle1], yEggs[1]);

                numOfEggs[1].drawEgg(gl, 0.8f, textures);
                yEggs[1] -= 4;

                if (numOfEggs[1].yEgg < 40) {
                    if (!flags[1]) {
                        randomSingle2 = (int) (Math.random() * 3);
                        System.out.println(randomSingle2);
                        flags[1] = true;

                    }

                    numOfEggs[2] = new Eggs(xEggs[randomSingle2], yEggs[2]);
                    numOfEggs[2].drawEgg(gl, 0.8f, textures);
                    yEggs[2] -= 4;


                }
                if (yEggs[2] < 8) {
                    run = false;
                }
            }
        }
        if (!run) {
            Arrays.fill(numOfEggs, null);
            Arrays.fill(flags, false);
            run = true;
            Arrays.fill(yEggs, 65);
            flagRandom = true;

        }
    }

    public void RandomStructure_MultiPlayer(GL gl) {
        if (runMulti) {
            if (flagRandom_multi && flagRandom_multi2) {
                randomMulti0 = randomGet_multi2();
                randomMulti3 = randomGet_multi();
            }
            numOfEggs_multi[0] = new Eggs(xEggs_multi[randomMulti0], yEggs_multi[0]);
            numOfEggs_multi[3] = new Eggs(xEggs_multi[randomMulti3], yEggs_multi[3]);
            //   System.out.println(numOfEggs_multi[3].yEgg+" "+numOfEggs_multi[3].xEgg);
            numOfEggs_multi[0].drawEgg(gl, 0.5f, textures);
            numOfEggs_multi[3].drawEgg(gl, 0.5f, textures);
            if(counter<1000){
            yEggs_multi[0]--;
            yEggs_multi[3]--; }
            if(counter>1000&&counter<2000){
                yEggs_multi[0]-=2;
                yEggs_multi[3]-=2; }
            if(counter>2000){
                yEggs_multi[0]-=4;
                yEggs_multi[3]-=4; }


            if (numOfEggs_multi[0].yEgg < 20 && numOfEggs_multi[3].yEgg < 20) {
                if (!flags_multi[2] && !flags_multi[0]) {

                    randomMulti4 = (int) (Math.random() * 3) + 3;
                    randomMulti1 = (int) (Math.random() * 3);
                    flags_multi[0] = true;
                    flags_multi[2] = true;
                }
                numOfEggs_multi[1] = new Eggs(xEggs_multi[randomMulti1], yEggs_multi[1]);
                numOfEggs_multi[4] = new Eggs(xEggs_multi[randomMulti4], yEggs_multi[4]);
                numOfEggs_multi[1].drawEgg(gl, 0.5f, textures);
                numOfEggs_multi[4].drawEgg(gl, 0.5f, textures);
                if(counter<1000){
                    yEggs_multi[1]--;
                    yEggs_multi[4]--; }
                if(counter>1000&&counter<2000){
                    yEggs_multi[1]-=2;
                    yEggs_multi[4]-=2; }
                if(counter>2000){
                    yEggs_multi[1]-=4;
                    yEggs_multi[4]-=4; }
                if (numOfEggs_multi[1].yEgg < 40 && numOfEggs_multi[4].yEgg < 40) {
                    if (!flags_multi[3] && !flags_multi[1]) {
                        randomMulti5 = (int) (Math.random() * 3) + 3;
                        randomMulti2 = (int) (Math.random() * 3);
                        flags_multi[1] = true;

                        flags_multi[3] = true;

                    }
                    numOfEggs_multi[2] = new Eggs(xEggs_multi[randomMulti2], yEggs_multi[5]);
                    numOfEggs_multi[2].drawEgg(gl, 0.5f, textures);
                    numOfEggs_multi[5] = new Eggs(xEggs_multi[randomMulti5], yEggs_multi[5]);
                    numOfEggs_multi[5].drawEgg(gl, 0.5f, textures);
                    if(counter<1000){
                        yEggs_multi[2]--;
                        yEggs_multi[5]--; }
                    if(counter>1000&&counter<2000){
                        yEggs_multi[2]-=2;
                        yEggs_multi[5]-=2; }
                    if(counter>2000){
                        yEggs_multi[2]-=4;
                        yEggs_multi[5]-=4; }

                }
                if (yEggs_multi[5] < 7 && yEggs_multi[2] < 7) {
                    runMulti = false;
                }

            }
            counter+=2;

        }
        if (!runMulti) {
            Arrays.fill(numOfEggs_multi, null);

            Arrays.fill(flags_multi, false);
            runMulti = true;
            Arrays.fill(yEggs_multi, 65);
            flagRandom_multi = true;
            flagRandom_multi2 = true;

        }
        //  collusionMulti();


    }


    public int randomGet_Single() {
        flagRandom = false;
        return (int) (Math.random() * 3);

    }

    public int randomGet_multi() {
        flagRandom_multi = false;
        return (int) (Math.random() * 3) + 3;

    }


    public int randomGet_multi2() {
        flagRandom_multi2 = false;
        return (int) (Math.random() * 3);

    }
}