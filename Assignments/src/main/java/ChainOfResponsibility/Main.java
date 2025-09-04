package ChainOfResponsibility;

public class Main {
    public static void main(String[] args) {
        CustomerMessage msg1 = new CustomerMessage(CustomerMessageType.FEEDBACK, "Hello yuor site is very focnufsing", "Perna");
        CustomerMessage msg2 = new CustomerMessage(CustomerMessageType.BILLING, "I need help with billing help pls hedl", "Jurtsa");
        CustomerMessage msg3 = new CustomerMessage(CustomerMessageType.HELPDESK, "Hei netti (WLAN) ei toimi ja mun ravintola saa tästä nyt miljoonatappiot t.ravintoloitsija", "Perrti Foosberg");

        BillingHandler billingHandler = new BillingHandler();
        FeedbackHandler feedbackHandler = new FeedbackHandler();
        HelpdeskHandler helpdeskHandler = new HelpdeskHandler();

        // helpdesk handler is the primary handler/first in the chain
        helpdeskHandler.setNextMessageHandler(billingHandler);
        billingHandler.setNextMessageHandler(feedbackHandler);

        helpdeskHandler.handleMessage(msg1);
        //helpdeskHandler.handleMessage(msg2);
        //helpdeskHandler.handleMessage(msg3);



    }
}
