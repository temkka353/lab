import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order(1, "Олег", LocalDate.of(2023, 10, 26), "PENDING", 120.50),
                new Order(2, "Андрей", LocalDate.of(2023, 10, 27), "SHIPPED", 300.00),
                new Order(3, "Алиса", LocalDate.of(2023, 10, 28), "DELIVERED", 75.20),
                new Order(4, "Егор", LocalDate.of(2023, 10, 25), "PENDING", 600.75),
                new Order(5, "Боб", LocalDate.of(2023, 10, 29), "SHIPPED", 150.00),
                new Order(6, "Давид", LocalDate.of(2023, 10, 30), "DELIVERED", 200.00),
                new Order(7, "Алиса", LocalDate.of(2023, 10, 31), "SHIPPED", 650.00)
        );

        LocalDate filterDate = LocalDate.of(2023, 10, 27);
        List<Order> ordersAfterDate = orders.stream()
                .filter(order -> order.getOrderDate().isAfter(filterDate))
                .collect(Collectors.toList());
        System.out.println("Заказы после " + filterDate + ":");
        ordersAfterDate.forEach(System.out::println);
        System.out.println();

        List<Order> shippedOrders = orders.stream()
                .filter(order -> "SHIPPED".equals(order.getStatus()))
                .collect(Collectors.toList());
        System.out.println("Заказы со статусом 'SHIPPED':");
        shippedOrders.forEach(System.out::println);
        System.out.println();

        Map<String, Long> statusCounts = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus, Collectors.counting()));
        System.out.println("Количество заказов по статусам:");
        statusCounts.forEach((status, count) -> System.out.println(status + ": " + count));
        System.out.println();

        List<Order> highAmountOrders = orders.stream()
                .filter(order -> order.getAmount() > 500)
                .collect(Collectors.toList());
        System.out.println("Заказы с суммой более 500:");
        highAmountOrders.forEach(System.out::println);
        System.out.println();

        Optional<Order> maxAmountOrder = orders.stream()
                .max(Comparator.comparingDouble(Order::getAmount));

        maxAmountOrder.ifPresent(order -> System.out.println("Клиент с наибольшим заказом: " + order.getCustomerName() +  " Заказ на сумму: " + order.getAmount()));
    }
}