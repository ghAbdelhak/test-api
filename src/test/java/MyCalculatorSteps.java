import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MyCalculatorSteps {
    int result;
    @Given("I have A calculator")
    public void iHaveACalculator() {

    }

    @When("I add {int} and {int}")
    public void iAddAnd(int arg0, int arg1) {
        result = arg0 + arg1;
    }

    @Then("The result should be {int}")
    public void theResultShouldBe(int arg0) {
        Assert.assertEquals(result,arg0);
    }
}
