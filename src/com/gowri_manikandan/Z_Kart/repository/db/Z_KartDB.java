package com.gowri_manikandan.Z_Kart.repository.db;

import com.gowri_manikandan.Z_Kart.repository.dto.*;
import java.util.*;

public class Z_KartDB {
    private static Z_KartDB instance;

    // Data structures
    private Map<Long, Customer> customers = new HashMap<>();
    private List<Customer> customerList = new ArrayList<>();
    private Map<Long, Product> products = new HashMap<>();
    private List<Product> productList = new ArrayList<>();
    private Map<Long, Order> orders = new HashMap<>();
    private List<Order> orderList = new ArrayList<>();
    private Map<Long, CardItem> cartItems = new HashMap<>();
    private List<CardItem> cartItemList = new ArrayList<>();
    private Map<Long, PasswordHistory> passwordHistories = new HashMap<>();
    private List<PasswordHistory> passwordHistoryList = new ArrayList<>();
    private Map<Long, Card> cards = new HashMap<>();
    private List<Card> cardList = new ArrayList<>();

    // ID generators
    private static long customerIdCounter = 1;
    private static long productIdCounter = 1;
    private static long orderIdCounter = 1;
    private static long cartItemIdCounter = 1;
    private static long passwordHistoryIdCounter = 1;
    private static long cardIdCounter = 1;

    private Z_KartDB() {
        initializeSampleData();
    }

    public static Z_KartDB getInstance() {
        if (instance == null) {
            instance = new Z_KartDB();
        }
        return instance;
    }

    private void initializeSampleData() {
        // Default Admin
        Customer admin = new Customer(customerIdCounter++, "Admin", "admin@zkart.com", "Admin@123", 1234567890L, "Admin Address", Role.ADMIN, true, false, System.currentTimeMillis());
        customers.put(admin.getId(), admin);
        customerList.add(admin);

        // Sample Customers
        Customer user1 = new Customer(customerIdCounter++, "John Doe", "john@example.com", "Password@123", 9876543210L, "User Address 1", Role.USER, true, false, System.currentTimeMillis());
        customers.put(user1.getId(), user1);
        customerList.add(user1);

        Customer user2 = new Customer(customerIdCounter++, "Jane Smith", "jane@example.com", "Password@123", 8765432109L, "User Address 2", Role.USER, true, false, System.currentTimeMillis());
        customers.put(user2.getId(), user2);
        customerList.add(user2);

        // Sample Products
        Product p1 = new Product(productIdCounter++, "Laptop", 999.99, 10, "Model A", "Electronics", "Brand A", true, System.currentTimeMillis());
        products.put(p1.getId(), p1);
        productList.add(p1);

        Product p2 = new Product(productIdCounter++, "Phone", 499.99, 20, "Model B", "Electronics", "Brand B", true, System.currentTimeMillis());
        products.put(p2.getId(), p2);
        productList.add(p2);

        Product p3 = new Product(productIdCounter++, "Book", 19.99, 50, "Model C", "Books", "Brand C", true, System.currentTimeMillis());
        products.put(p3.getId(), p3);
        productList.add(p3);

        // Sample Orders
        List<OrderItem> items1 = Arrays.asList(
            new OrderItem(1, 1, p1.getId(), p1.getName(), p1.getPrice(), 1, p1.getModel(), p1.getCategory(), p1.getBrand())
        );
        Order o1 = new Order(orderIdCounter++, user1.getId(), items1, 999.99, OrderStatus.DELIVERED, user1.getAddress(), System.currentTimeMillis());
        orders.put(o1.getId(), o1);
        orderList.add(o1);

        // Password Histories
        PasswordHistory ph1 = new PasswordHistory(passwordHistoryIdCounter++, admin.getId(), "Admin@123", System.currentTimeMillis());
        passwordHistories.put(ph1.getId(), ph1);
        passwordHistoryList.add(ph1);
    }

    // Customer methods
    public void addCustomer(Customer customer) {
        customer.setId(customerIdCounter++);
        customers.put(customer.getId(), customer);
        customerList.add(customer);
    }

    public Customer getCustomerById(long id) {
        return customers.get(id);
    }

    public Customer getCustomerByEmail(String email) {
        return customerList.stream().filter(c -> c.getEmail().equals(email)).findFirst().orElse(null);
    }

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customerList);
    }

    public void updateCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
        int index = customerList.indexOf(customer);
        if (index != -1) {
            customerList.set(index, customer);
        }
    }

    // Product methods
    public void addProduct(Product product) {
        product.setId(productIdCounter++);
        products.put(product.getId(), product);
        productList.add(product);
    }

    public Product getProductById(long id) {
        return products.get(id);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(productList);
    }

    public void updateProduct(Product product) {
        products.put(product.getId(), product);
        int index = productList.indexOf(product);
        if (index != -1) {
            productList.set(index, product);
        }
    }

    public void deleteProduct(long id) {
        Product product = products.remove(id);
        if (product != null) {
            productList.remove(product);
        }
    }

    // Order methods
    public void addOrder(Order order) {
        order.setId(orderIdCounter++);
        orders.put(order.getId(), order);
        orderList.add(order);
    }

    public Order getOrderById(long id) {
        return orders.get(id);
    }

    public List<Order> getOrdersByCustomerId(long customerId) {
        return orderList.stream().filter(o -> o.getCustomerId() == customerId).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orderList);
    }

    // Cart methods
    public void addCartItem(CardItem item) {
        item.setId(cartItemIdCounter++);
        cartItems.put(item.getId(), item);
        cartItemList.add(item);
    }

    public List<CardItem> getCartItemsByCustomerId(long customerId) {
        return cartItemList.stream().filter(c -> c.getCustomerId() == customerId).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public void updateCartItem(CardItem item) {
        cartItems.put(item.getId(), item);
        int index = cartItemList.indexOf(item);
        if (index != -1) {
            cartItemList.set(index, item);
        }
    }

    public void removeCartItem(long id) {
        CardItem item = cartItems.remove(id);
        if (item != null) {
            cartItemList.remove(item);
        }
    }

    public void clearCart(long customerId) {
        cartItemList.removeIf(c -> c.getCustomerId() == customerId);
        cartItems.entrySet().removeIf(e -> e.getValue().getCustomerId() == customerId);
    }

    // Password History methods
    public void addPasswordHistory(PasswordHistory ph) {
        ph.setId(passwordHistoryIdCounter++);
        passwordHistories.put(ph.getId(), ph);
        passwordHistoryList.add(ph);
    }

    public List<PasswordHistory> getPasswordHistoryByCustomerId(long customerId) {
        return passwordHistoryList.stream().filter(p -> p.getCustomerId() == customerId).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    // Card methods
    public void addCard(Card card) {
        card.setId(cardIdCounter++);
        cards.put(card.getId(), card);
        cardList.add(card);
    }

    public List<Card> getCardsByCustomerId(long customerId) {
        return cardList.stream().filter(c -> c.getCustomerId() == customerId).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}
