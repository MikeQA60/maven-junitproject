package services;

import models.BankAccount;
import models.Transaction;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import models.Customer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BankingServiceTest {
    static BankingService bankingService;
    BankAccount bankAccount1;
    Customer customer1;

    //when you see lines of code that are repeating in every single
    //test within one test class
    //those lines are good candidates to be moved to
    //@beforeEach, @beforeALL, @afterAll, @afterEach ----> these all called hooks

    @BeforeAll
    public static void beforeAll() {
        bankingService = new BankingService();
    }
    @BeforeEach
    public void setupEachTest() {
       // bankingService = new BankingService();
        bankAccount1 = new BankAccount("12346", 1000.0);
        customer1 = new Customer("Elon Musk", "x1", bankAccount1);
    }

    @AfterEach
    public void cleanUp() {

        //start every test from empty cache.
        //so that it ensures each tests are starting from of app's default state
        //and each test is independent from each other
        bankingService.clearCache();
    }
    @Test
    public void addNewCustomerTest() {

        //are pre condtional steps
//        BankingService bankingService = new BankingService();
//
//        BankAccount bankAccount1 = new BankAccount("12346", 1000.0);
//
//        Customer customer1 = new Customer("Elon Musk", "x1", bankAccount1);

        //this is a action test
        bankingService.addCustomer(customer1);

        List<Customer> expectedListOfCustomers = new ArrayList<>();
        expectedListOfCustomers.add(customer1);

        assertEquals(expectedListOfCustomers, bankingService.getCustomerList(), "two customer lists are not equal");
    }

    @Test
    public void findingCustomerWithin1CustomerListTest() {


        //this is action test
        bankingService.addCustomer(customer1);

        Customer actualResultCustomerObj = bankingService.findCustomer("x1");
        assertEquals(actualResultCustomerObj.getName(), "Elon Musk");
        assertEquals(actualResultCustomerObj.getName(), "Elon Musk");
    }

    @Test
    public void findingCustomerThatDoesntExist() {

        //this is action test
        bankingService.addCustomer(customer1);
        Customer actualResultCustomerObj = bankingService.findCustomer("beta123");

        assertNull(actualResultCustomerObj, "finding a customer that doesn't exist should return null");


    }

    @Test
    public void performTransactionWithNullCustomer() {


        Transaction transaction = new Transaction("TXN001", "Deposit", 500, "12345", "x1");

        try {
            assertThrows(Exception.class, () -> bankingService.performTransaction(transaction));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testPerformDepositTransaction() {


        Transaction transaction = new Transaction("TXN0001", "Deposit", 500.0, "12345", "x1");

        bankingService.addCustomer(customer1);

        try {
            bankingService.performTransaction(transaction);

            assertEquals(1500.00, bankAccount1.getBalance(), "Deposit is not completed");
        } catch (Exception e) {
           // fail("Perform transaction with a valid transaction failed");

        }
    }

    @Test
    public void testPerformWithdrawWithSufficientFunds() {

        Transaction transaction = new Transaction("TXN0001", "Withdraw", 300.0, "12345", "x1");

        bankingService.addCustomer(customer1);
        try {
            bankingService.performTransaction(transaction);
            assertEquals(700.00, bankAccount1.getBalance(), "withdraw balance mismatch");
        } catch (Exception e) {
           // fail("withdraw with sufficient fund is not completed" + e.getMessage());
        }
    }

    @Test
    public void testPerformWithdrawWithInsufficientFunds() {

        Transaction transaction = new Transaction("TXN0001", "Withdraw", 1500.0, "12345", "x1");

        bankingService.addCustomer(customer1);

        try {
            bankingService.performTransaction(transaction);
            assertEquals(1000.00, bankAccount1.getBalance(), "withdraw balance mismatch");
        } catch (Exception e) {
            // fail("withdraw with insufficient fund error" + e.getMessage());
        }

    }
}