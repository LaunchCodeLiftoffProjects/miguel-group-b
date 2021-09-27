//package org.launchcode.snapsnap.controllers;
//
//import com.stripe.exception.SignatureVerificationException;
//import com.stripe.model.*;
//import com.stripe.net.Webhook;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.logging.Logger;
//
//@RestController
//public class StripeWebHookController {
//
//    private Logger logger = (Logger) LoggerFactory.getLogger(StripeWebHookController.class);
//
//    @Value("${stripe.webhook.secret}")
//    private String endpointSecret;
//
//    @PostMapping("/stripe/events")
//    public String handleStripeEvent(@RequestBody String payload, @RequestHeader("Stripe-Signature") String sigHeader){
//
//        if(sigHeader==null){
//            return "";
//        }
//
//        Event event;
//
//// only verify the event if you have an endpoint secret defined
//// otherwise use the basic event deserialized with GSON
//        try {
//            event = Webhook.constructEvent(
//                    payload, sigHeader, endpointSecret
//            );
//        } catch (SignatureVerificationException e){
////  invalid signature
//            logger.info("Webhook error while validating signature.");
//            return "";
//        }
//
//            EventDataObjectDeserializer dataObjectDeserializer = event.getDataObjectDeserializer();
//            StripeObject stripeObject = null;
//            if (dataObjectDeserializer.getObject().isPresent()) {
//                stripeObject = dataObjectDeserializer.getObject().get();
//            } else {
//                // Deserialization failed, probably due to an API version mismatch.
//                // Refer to the Javadoc documentation on `EventDataObjectDeserializer` for
//                // instructions on how to handle this case, or return an error here.
//            }
//            // Handle the event
//            switch (event.getType()) {
//                case "payment_intent.succeeded":
//                    PaymentIntent paymentIntent = (PaymentIntent) stripeObject;
//                    logger.info("Payment for " + paymentIntent.getAmount() + " succeeded.");
//                    // Then define and call a method to handle the successful payment intent.
//                    // handlePaymentIntentSucceeded(paymentIntent);
//                    break;
//                default:
//                    logger.info("Unhandled event type: " + event.getType());
//                    break;
//            }
//            return "";
//
//    }
//}
