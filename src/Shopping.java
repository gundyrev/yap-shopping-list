import java.util.Scanner;

public class Shopping {

    public static void main(String[] args) {
        System.out.println("Вас приветствует список покупок!");

        int productCount = 0; // Текущее количество товаров в списке
        int maxProductCount = 8; // Размер массива для списка покупок
        String[] shoppingList = new String[maxProductCount]; // Массив для хранения списка покупок

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Добавить товар в список");
            System.out.println("2. Показать список");
            System.out.println("3. Очистить список");
            System.out.println("4. Завершить работу");
            System.out.print("Выберите одну из команд: ");

            int actionNumber = scanner.nextInt();

            if (actionNumber == 1) {
                // Добавление нового товара в список покупок

                // Если превышено максимальное количество товаров, расширяем массив
                if (productCount >= maxProductCount) {
                    // Увеличиваем размер массива в 1.5 раза
                    maxProductCount = (int) (maxProductCount * 1.5);

                    String[] temp = shoppingList; // Создаем временную копию массива
                    shoppingList = new String[maxProductCount]; // Создаем увеличенный массив

                    // Копируем уже добавленные товары в новый массив
                    for (int i = 0; i < productCount; i++) {
                        shoppingList[i] = temp[i];
                    }
                }

                System.out.print("Введите название товара: ");
                scanner.nextLine(); // Пропускаем перенос строки после scanner.nextInt()
                String productName = scanner.nextLine();

                // Проверяем, что товар не был добавлен в список ранее
                boolean notInList = true;
                for (int i = 0; i < productCount; i++) {
                    // Если null, значит дошли до конца списка
                    if (shoppingList[i] == null) {
                        break;
                    }
                    // Проверяем название без учета регистра
                    if (shoppingList[i].equalsIgnoreCase(productName)) {
                        notInList = false;
                        break;
                    }
                }

                if (notInList) {
                    // Если товар отсутсвует в списке, добавляем его
                    shoppingList[productCount] = productName;
                    productCount++;
                    System.out.println("\nТовар \"" + productName + "\" теперь в списке!");
                } else {
                    // Иначе выводим сообщение, что товар уже находится в списке
                    System.out.println(
                            "\nТовар \"" + productName + "\" уже находится в списке покупок.");
                }
            } else if (actionNumber == 2) {
                // Вывод списка покупок
                System.out.println("\nПродуктов в списке: " + productCount);
                for (int i = 0; i < productCount; i++) {
                    System.out.println((i + 1) + ". " + shoppingList[i]);
                }
            } else if (actionNumber == 3) {
                // Очистка списка покупок

                // Сбрасываем список покупок к начальному состоянию
                productCount = 0;
                maxProductCount = 8;
                shoppingList = new String[maxProductCount];

                System.out.println("\nСписок покупок очищен.");
            } else if (actionNumber == 4) {
                // Завершение работы
                System.out.println("\nЗавершение работы...");
                break;
            } else {
                // Обработка неизвестной команды
                System.out.println("\nНеизвестная команда!");
            }
        }
    }
}
