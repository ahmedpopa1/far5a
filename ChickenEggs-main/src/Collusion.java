public class Collusion extends RandomStructure {
    public void notCollision() {
        for (int i = 0; i < numOfEggs.length; i++) {
            if (yEggs[i] == 9) {
                if (lives > 0) {
                    lives--;
                }
//                winLose_single();
                yEggs[i] = -10;

            }
        }
    }

    public void collision() {
        for (int i = 0; i < numOfEggs.length; i++) {
            if (yEggs[i] == 21 && (numOfEggs[i].xEgg >= xInitial && numOfEggs[i].xEgg <= xEnd)) {
                yEggs[i] = -10;
                score++;
                if (animationIndex < 4) {
                    animationIndex++;
                }
                isCollusion = true;
            }
        }
    }

    public void collisionMulti(){
        for(int i=0;i<3;i++){
            if (yEggs_multi[i] == 13 && (numOfEggs_multi[i].xEgg >= xInitial0 && numOfEggs_multi[i].xEgg <= xEnd0) ) {
                System.out.println("Abd 3obaida");
                //  System.out.println(yEggs_multi[i]);
                yEggs_multi[i]=-10;
                // System.out.println(yEggs_multi[i]);
                score0++;
                if(animationBasket0<4){ animationBasket0++;}
                isCollusion=true;
            }
        }
        for(int i=3;i<numOfEggs_multi.length;i++){
            if (yEggs_multi[i] == 13 && (numOfEggs_multi[i].xEgg >= xInitial1 && numOfEggs_multi[i].xEgg <= xEnd1) ) {
                yEggs_multi[i]=-10;
                score1++;

                if(animationBasket1<4){ animationBasket1++;}
                isCollusion=true;


            }
        }

    }
    public void notCollision_Multi() {
        for (int i = 0; i < numOfEggs_multi.length-3; i++) {
            if (yEggs_multi[i]== 9) {
                yEggs_multi[i] = -10;
                if(lives0>0){lives0--;}


            }
        }
        for (int i = 3; i < numOfEggs_multi.length; i++) {
            if (yEggs_multi[i]== 9) {
                yEggs_multi[i] = -10;
                if(lives1>0){lives1--;}


            }
        }
    }
}
