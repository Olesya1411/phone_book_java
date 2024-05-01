import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, List<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Саша", "7852");
        addContact(phoneBook, "Егор", "9632");
        addContact(phoneBook, "Алиса", "4523");
        addContact(phoneBook, "Максим", "1478");
        addContact(phoneBook, "Егор", "2544");
        addContact(phoneBook, "Алиса", "1133");

        printPhoneBook(phoneBook);
    }

    private static void addContact(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }

    private static void printPhoneBook(Map<String, List<String>> phoneBook) {

        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        entries.sort(Comparator.comparingInt(entry -> entry.getValue().size()));

        for (int i = entries.size() - 1; i >= 0; i--) {
            Map.Entry<String, List<String>> entry = entries.get(i);
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();

            System.out.println(name + ": " + phoneNumbers);
        }
    }
}