package classes;


import java.util.Objects;

public class Dialog {
    public static void AskaboutSomething(Personage ch1, Personage ch2, boolean lasttime) {
        if (lasttime) {
            System.out.println(ch2.getName() + " спросила." + ch1.getName() + " ответил Нет,нет,никогда");
        } else {
            System.out.println(ch2.getName() + " спросила." + ch1.getName() + " сказал да,да!");
        }
    }

}
