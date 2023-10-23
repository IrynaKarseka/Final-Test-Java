// розыгрыша игрушек в магазине детских товаров.
// Стараемся применять ООП и работу с файлами.
// Если какой-то пункт не изучали и не знаете, как сделать, 
// то можете сделать своим способом. 
// Например, у кого в курсе не было ООП, то применяем списки\массивы\словари

// Желательный функционал программы:
// В программе должен быть минимум один класс со следующими свойствами:
// id игрушки,
// текстовое название,
// количество
// частота выпадения игрушки (вес в % от 100)

// Метод добавление новых игрушек и возможность изменения веса (частоты выпадения игрушки)
// Возможность организовать розыгрыш игрушек.

// Например, следующим образом:
// С помощью метода выбора призовой игрушки – мы получаем эту призовую игрушку и записываем в список\массив.
// Это список призовых игрушек, которые ожидают выдачи.
// Еще у нас должен быть метод – получения призовой игрушки.
// После его вызова – мы удаляем из списка\массива первую игрушку и сдвигаем массив. А эту игрушку записываем в текстовый файл.
// Не забываем уменьшить количество игрушек

// К написанию программы можно подойти более творчески и делать так, как Вы поняли задание. Немного менять и отходить от примера выше.
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Toy toy1 = new Toy(1, "Пупсик", 2);
        Toy toy2 = new Toy(2, "Уточка", 3);
        Toy toy3 = new Toy(3, "Робот", 5);
        Toy toy4 = new Toy(4, "Ждун", 8);
        Toy toy5 = new Toy(5, "Стикер", 1);
        Toy toy6 = new Toy(6, "Стикер", 4);
        Toy toy7 = new Toy(7, "Стикер", 1);

        PriorityQueue<Toy> toyQueue = new PriorityQueue<>((t1, t2) -> t2.getFrequency() - t1.getFrequency());
        toyQueue.add(toy1);
        toyQueue.add(toy2);
        toyQueue.add(toy3);
        toyQueue.add(toy4);
        toyQueue.add(toy5);
        toyQueue.add(toy6);
        toyQueue.add(toy7);

        Scanner scanner = new Scanner(System.in);
        String choice;

        UIConsole.showGreet();
        while (toyQueue.size() > 0) {
            UIConsole.showControlLevers();
            choice = scanner.next();

            switch (choice) {
                case "1":
                    Random rnd = new Random();
                    int num = rnd.nextInt(1, 4);
                    System.out.println("Введите число от 1 до 3");
                    int num2 = scanner.nextInt();
                    if (num == num2) {
                        Toy deliteToy = toyQueue.remove();
                        try (FileWriter writer = new FileWriter("my.txt")) {
                            String toyName = deliteToy.getName();
                            writer.write(String.valueOf(toyName));
                            writer.write("\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        System.out.println("\n============================================================");
                        System.out.println("============================================================");
                        System.out.println("\n\t\t\t Поздравляем!!\n\t\t\tВаш приз: " + deliteToy);
                        System.out.println("\n============================================================");
                        System.out.println("============================================================");

                    } else {
                        System.out.println("\n============================================================");
                        System.out.println("============================================================");
                        System.out.println("\n\t\tВам повезет в следующий раз");
                        System.out.println("\n============================================================");
                        System.out.println("============================================================");
                    }
                    break;

                case "2":
                    HashSet<Toy> toySet = new HashSet<>();
                    for (Toy el : toyQueue) {
                        toySet.add(el);
                    }
                    System.out.println("\n\n\t" + toySet + "\n");
                    break;

                case "000":
                    UIConsole.showAuthor();
                    break;

                default:
                    UIConsole.showErrorEnteringIncorrectly();
            }
        }
        System.out.println("Розыгрыш закончился!");
    }
}
