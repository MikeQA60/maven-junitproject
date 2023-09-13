package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TransferSteps {

    @Given("User with account number {int} is registered")
    public void user_with_account_number_is_registered(int param) {
        System.out.println("My First Given step. What ride with wedevx!");
        System.out.println("Print out accoutNum: " + param);


    }

    @Given("User with account number {int} deposited ${double}")
    public void user_with_account_number_deposited_$(Integer accountNum, double depositAmount) {
        System.out.println("Print out accoutNum agin: " + accountNum);
        System.out.println("Print out deposit amount: " + depositAmount);

    }

    @When("User with account number {int} transfers ${double}")
    public void user_with_account_number_transfers_$(Integer accountNum, double transferAmount) {
        System.out.println("This is When");
        System.out.println("Print out accoutNum agin: " + accountNum);
        System.out.println("Print out deposit amount: " + transferAmount);
    }

    @Then("User with account number {int} should have ${double} in balance")
    public void user_with_account_number_should_have_$_in_balance(Integer accountNum, double balance) {
        System.out.println("This is Then ");
        System.out.println("Print out accoutNum agin: " + accountNum);
        System.out.println("Print out balance amount: " + balance);
    }

    @Then("User should see Insufficient Funds message")
    public void user_should_see_insufficient_funds_message() {
        System.out.println("This is error message checking");

    }
    @Given("User is on {string}")
    public void user_is_on(String envUrl) {
        System.out.println("going to " + envUrl);

    }

}

