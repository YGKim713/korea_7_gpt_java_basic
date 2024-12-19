package polymorphismPractice;

class Human {
    void Human () {
        System.out.println("나는 사람입니다.");
    }
}

class Male extends Human {
    void Male () {
        System.out.println("나는 남자입니다.");
    }
}

public class PolymorphismEx {
    public static void main(String[] args) {
        Human human = new Human();
        Human man = new Male();

        Male male = (Male) man;

        human.Human();
        man.Human();
        male.Male();
    }

}
