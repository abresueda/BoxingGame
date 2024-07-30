import java.util.Random;

public class Ring {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;
    boolean randomStart;


    Ring(Fighter f1, Fighter f2, int minWeight, int maxWeight){
        this.f1 = f1;
        this.f2 = f2;
        this.maxWeight = maxWeight;
        this.minWeight = minWeight;
    }

    public void run(){
            if (isCheck()) {
                Random r= new Random();
                randomStart = r.nextBoolean(); //Who's starting?
                //When the fighters' health is greater than 0, the round is still continuing.
                while (this.f1.health > 0 && this.f2.health > 0) {
                    System.out.println("                     ");
                    System.out.println("xxxxx NEW ROUND xxxxx");
                    if (randomStart) {
                        this.f2.health = this.f1.hit(this.f2);
                        if (isWin()) {
                            break;
                        }
                        this.f1.health = this.f2.hit(this.f1);
                    } else {
                        this.f1.health = this.f2.hit(this.f1);
                        if (isWin()) {
                            break;
                        }
                        this.f2.health = this.f1.hit(this.f2);
                    }

                    //Checking if there is a winner.
                    if (isWin()) {
                        break;
                    }

                    //In every round, change the starter.
                    randomStart = !randomStart;
                    System.out.println(this.f1.name + "'s Health: " + this.f1.health);
                    System.out.println(this.f2.name + "'s Health: " + this.f2.health);
                }
            } else {
                System.out.println("The boxers' weight classes don't match.");
            }
    }

    boolean isCheck(){
        return (this.f1.weight >= minWeight && this.f1.weight <= maxWeight) && (this.f2.weight >= minWeight && this.f2.weight <= maxWeight);
    }

    boolean isWin(){
        if (this.f1.health == 0){
            System.out.println(this.f2.name + " won!");
            return true;
        }

        if (this.f2.health == 0){
            System.out.println(this.f1.name + " won!");
            return true;
        }
        return false;
    }
}
