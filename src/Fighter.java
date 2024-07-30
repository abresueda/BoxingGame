public class Fighter {
    String name;
    int damage;
    int health;
    int weight;
    int dodge;

    Fighter(String name, int damage, int health, int weight, int dodge) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.weight = weight;
        if(dodge >= 0 && dodge <= 100) {
            this.dodge = dodge;
        } else {
            this.dodge = 0;
        }
    }

    int hit(Fighter foe){
        System.out.println(this.name + " => " + foe.name + " " + this.damage + " caused damage.");
        if (foe.isDodge()){
            System.out.println(foe.name + " blocked the damage.");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");
            return foe.health;
        }

        //When the foe's health is 0, it will return 0.
        if (foe.health - this.damage < 0) {
            return 0;
        }

        return foe.health - this.damage;
    }

    boolean isDodge(){
        //If the randomNumber is smaller than the dodgeNumber, the foe will block.
        double randomNumber = Math.random() * 100;
        return randomNumber <= this.dodge;
    }
}
