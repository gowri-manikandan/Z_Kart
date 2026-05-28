import com.gowri_manikandan.Z_Kart.features.card.CardView;
import com.gowri_manikandan.Z_Kart.features.customer.CustomerView;
import com.gowri_manikandan.Z_Kart.features.login.LogInView;
import com.gowri_manikandan.Z_Kart.features.order.OrderView;
import com.gowri_manikandan.Z_Kart.features.product.ProductView;
import com.gowri_manikandan.Z_Kart.features.signup.SignUpView;
import com.gowri_manikandan.Z_Kart.utils.ConsoleUtil;
import com.gowri_manikandan.Z_Kart.utils.SessionManager;

public class Z_KartMain {

    public static final String appVersion = "0.0.1";
    public static final String appName = "Z_Kart";

    private static final LogInView loginView = new LogInView();
    private static final SignUpView signUpView = new SignUpView();
    private static final ProductView productView = new ProductView();
    private static final CardView cartView = new CardView();
    private static final OrderView orderView = new OrderView();
    private static final CustomerView customerView = new CustomerView();
    private static final SessionManager session = SessionManager.getInstance();

    public static void main(String[] args)
    {
        System.out.println("Welcome to " + appName + " - Version: " + appVersion);
        showMainMenu();
    }

    private static void showMainMenu()
    {
        while (true) {
            ConsoleUtil.displayHeader("Z KART");
            System.out.println("1. Login");
            System.out.println("2. Sign Up");
            System.out.println("3. Exit");
            ConsoleUtil.displaySeparator();
            int choice = ConsoleUtil.readInt("Enter choice: ");
            switch (choice) {
                case 1:
                    loginView.displayLoginMenu();
                    int loginChoice = ConsoleUtil.readInt("Enter choice: ");
                    if (loginChoice == 1)
                    {
                        loginView.showLoginForm();
                        if (session.isLoggedIn())
                        {
                            showUserMenu();
                        }
                    }
                    break;
                case 2:
                    signUpView.displaySignUpMenu();
                    int signUpChoice = ConsoleUtil.readInt("Enter choice: ");
                    if (signUpChoice == 1) {
                        signUpView.showSignUpForm();
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    ConsoleUtil.displayError("Invalid choice.");
            }
        }
    }

    private static void showUserMenu()
    {
        while (session.isLoggedIn())
        {
            ConsoleUtil.displayHeader("Menu");
            System.out.println("1. View Products");
            System.out.println("2. Search Products");
            System.out.println("3. Cart Management");
            System.out.println("4. Order Management");
            System.out.println("5. Change Password");
            System.out.println("6. Logout");
            if (session.isAdmin()) {
                System.out.println("7. Admin Menu");
            }
            ConsoleUtil.displaySeparator();
            int choice = ConsoleUtil.readInt("Enter choice: ");
            switch (choice) {
                case 1:
                    productView.showAllProducts();
                    break;
                case 2:
                    productView.displayProductSearchMenu();
                    int searchChoice = ConsoleUtil.readInt("Enter choice: ");
                    switch (searchChoice) {
                        case 1:
                            productView.showSearchForm();
                            break;
                        case 2:
                            productView.showPriceRangeSearchForm();
                            break;
                        case 3:
                            productView.showAllProducts();
                            break;
                    }
                    break;
                case 3:
                    showCartMenu();
                    break;
                case 4:
                    showOrderMenu();
                    break;
                case 5:
                    loginView.showChangePassword();
                    break;
                case 6:
                    loginView.showLogout();
                    return;
                case 7:
                    if (session.isAdmin()) {
                        showAdminMenu();
                    } else {
                        ConsoleUtil.displayError("Invalid choice.");
                    }
                    break;
                default:
                    ConsoleUtil.displayError("Invalid choice.");
            }
            ConsoleUtil.pressEnterToContinue();
        }
    }

    private static void showCartMenu()
    {
        while (true) {
            cartView.displayCartMenu();
            int choice = ConsoleUtil.readInt("Enter choice: ");
            switch (choice) {
                case 1:
                    cartView.showAddToCartForm();
                    break;
                case 2:
                    cartView.showRemoveFromCartForm();
                    break;
                case 3:
                    cartView.showUpdateQuantityForm();
                    break;
                case 4:
                    cartView.showCart();
                    break;
                case 5:
                    cartView.showClearCart();
                    break;
                case 6:
                    return;
                default:
                    ConsoleUtil.displayError("Invalid choice.");
            }
        }
    }

    private static void showOrderMenu() {
        while (true) {
            orderView.displayOrderMenu();
            int choice = ConsoleUtil.readInt("Enter choice: ");
            switch (choice) {
                case 1:
                    orderView.showPlaceOrder(cartView.getCartItems());
                    break;
                case 2:
                    orderView.showMyOrders();
                    break;
                case 3:
                    return;
                default:
                    ConsoleUtil.displayError("Invalid choice.");
            }
        }
    }

    private static void showAdminMenu() {
        while (true) {
            ConsoleUtil.displayHeader("Admin Menu");
            System.out.println("1. Product Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Order Management");
            System.out.println("4. Back");
            ConsoleUtil.displaySeparator();
            int choice = ConsoleUtil.readInt("Enter choice: ");
            switch (choice) {
                case 1:
                    showProductAdminMenu();
                    break;
                case 2:
                    showCustomerAdminMenu();
                    break;
                case 3:
                    showOrderAdminMenu();
                    break;
                case 4:
                    return;
                default:
                    ConsoleUtil.displayError("Invalid choice.");
            }
        }
    }

    private static void showProductAdminMenu() {
        while (true) {
            productView.displayProductMenu();
            int choice = ConsoleUtil.readInt("Enter choice: ");
            switch (choice) {
                case 1:
                    productView.showAddProductForm();
                    break;
                case 2:
                    productView.showUpdateProductForm();
                    break;
                case 3:
                    productView.showDeleteProductForm();
                    break;
                case 4:
                    productView.showChangeStockForm();
                    break;
                case 5:
                    productView.showAllProducts();
                    break;
                case 6:
                    return;
                default:
                    ConsoleUtil.displayError("Invalid choice.");
            }
        }
    }

    private static void showCustomerAdminMenu() {
        while (true) {
            customerView.displayCustomerMenu();
            int choice = ConsoleUtil.readInt("Enter choice: ");
            switch (choice) {
                case 1:
                    customerView.showAllCustomers();
                    break;
                case 2:
                    customerView.showSearchCustomersForm();
                    break;
                case 3:
                    return;
                default:
                    ConsoleUtil.displayError("Invalid choice.");
            }
        }
    }

    private static void showOrderAdminMenu() {
        while (true) {
            orderView.displayAdminOrderMenu();
            int choice = ConsoleUtil.readInt("Enter choice: ");
            switch (choice) {
                case 1:
                    orderView.showAllOrders();
                    break;
                case 2:
                    orderView.showUpdateOrderStatusForm();
                    break;
                case 3:
                    return;
                default:
                    ConsoleUtil.displayError("Invalid choice.");
            }
        }
    }
}