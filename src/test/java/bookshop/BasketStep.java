package bookshop;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BasketStep extends SpringIntegrationTest {

    @Given("an empty basket")
    public void anEmptyBasket() {
        System.out.println("hello world");
    }

    @When("i add a book to the basket")
    public void iAddABookToTheBasket() {
        System.out.println("hello world");

    }

    @Then("the basket has one book")
    public void theBasketHasOneBook() {
        System.out.println("hello world");
    }
}
