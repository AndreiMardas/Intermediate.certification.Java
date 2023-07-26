import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        // Добавляем контакты в телефонную книгу
        addContact(phoneBook, "Иванов", "1234567890");
        addContact(phoneBook, "Петров", "9876543210");
        addContact(phoneBook, "Сидоров", "5555555555");
        addContact(phoneBook, "Иванов", "1111111111"); // повторяющееся имя

        // Выводим отсортированный список контактов
        printSortedContacts(phoneBook);
    }

    // Метод для добавления контакта в телефонную книгу
    private static void addContact(HashMap<String, List<String>> phoneBook, String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            List<String> phoneNumbers = phoneBook.get(name);
            phoneNumbers.add(phoneNumber);
        } else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    // Метод для вывода отсортированного списка контактов
    private static void printSortedContacts(HashMap<String, List<String>> phoneBook) {
        // Создаем список пар (имя, список телефонов)
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        // Сортируем список контактов по убыванию числа телефонов
        Collections.sort(entries, (a, b) -> b.getValue().size() - a.getValue().size());

        // Выводим отсортированный список контактов
        for (Map.Entry<String, List<String>> entry : entries) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers.toString());
        }
    }
}