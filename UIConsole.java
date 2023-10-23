

public class UIConsole {
    public static void showGreet() {
        System.out.println("\n============================================================");
        System.out.println("\tРозыгрыш игрушек в магазине детских товаров! ");
        System.out.println("\t   Получите шанс выиграть игрушку!!!");
        System.out.println("============================================================");
    }

    public static void showControlLevers() {
        System.out.println("\n\t\t1 - Учавствовать в розыгрыше");
        System.out.println("\t\t2 - Просмотреть призы");
        System.out.println("\n============================================================");
        System.out.print("Введите цифру для выбора сюда ==> ");
    }

    public static void showErrorEnteringIncorrectly() {
        System.out.println("\n\n\n\t\t   Неправильный ввод!\n");
    }
        
    public static void showAuthor() {
        System.out.println("\n\n\n\n\n\t\t(c)2023 Ирина Карсеко для GB\n\n\n");
    }
}