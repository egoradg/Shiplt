import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);

    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> allTrackableParcels = new ArrayList<>();

    private static ParcelBox<StandardParcel> standardBox = new ParcelBox<>(15);
    private static ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(5);
    private static ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(10);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportStatuses();
                    break;
                case 5:
                    System.out.println("Какой тип посылки вы хотите отправить?");
                    System.out.println("1 — Стандартную посылку");
                    System.out.println("2 — Хрупкую посылку");
                    System.out.println("3 — Скоропортящуюся посылку");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice){
                        case 1:standardBox.getAllParcels(); break;
                        case 2:fragileBox.getAllParcels(); break;
                        case 3:perishableBox.getAllParcels(); break;
                        default:
                            System.out.println("Такой коробки нет");
                    break;
                }
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Показать состояние доставок");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Какой тип посылки вы хотите отправить?");
        System.out.println("1 — Стандартную посылку");
        System.out.println("2 — Хрупкую посылку");
        System.out.println("3 — Скоропортящуюся посылку");
        int parcelCode = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Опишите вашу посылку");
        String description = scanner.nextLine();
        System.out.println("Сколько весит посылка?");
        double weight = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Введите адрес получателя");
        String address = scanner.nextLine();
        System.out.println("Введите дату отправления");
        int date = scanner.nextInt();
        scanner.nextLine();
        Parcel parcel;

        switch (parcelCode) {
            case 1: {
                parcel = new StandardParcel(description, weight, address, date);
                allParcels.add(parcel);
                standardBox.addParcel((StandardParcel) parcel);
                break;
            }
            case 2: {
                parcel = new FragileParcel(description, weight, address, date);
                allParcels.add(parcel);
                allTrackableParcels.add((FragileParcel) parcel);
                fragileBox.addParcel((FragileParcel) parcel);
                break;
            }
            case 3: {
                System.out.println("Введите срок годности посылки");
                int MaxDate = scanner.nextInt();
                scanner.nextLine();

                parcel = new PerishableParcel(description, weight, address, date, MaxDate);
                allParcels.add(parcel);
                perishableBox.addParcel((PerishableParcel) parcel);
                break;
            }

            default:
                System.out.println("Неверный выбор");
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        double summeryCost = 0.0;
        for (Parcel parcel : allParcels) {
            summeryCost += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость за все посылки составила: " + summeryCost);
    }

    private static void reportStatuses() {
        for (Trackable parcel : allTrackableParcels) {
            System.out.println("Введите текущий адрес для посылки"); // нужно ли здесь писать название посылки или нет?
            String newAddress = scanner.nextLine();
            parcel.reportStatus(newAddress);
        }
    }

}
