package org.launchcode.snapsnap.controllers;

import org.launchcode.snapsnap.models.Cart;
import org.launchcode.snapsnap.models.Payment;
import org.launchcode.snapsnap.models.data.PaymentRepository;
import org.launchcode.snapsnap.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    private CartService cartService;

    @Autowired
    private PaymentRepository paymentRepository;

//    TODO: GET CART COST

    @GetMapping("checkout")
    public String displayCheckoutForm(Model model, String sessionToken) {
        Cart cart = cartService.findBySessionToken(sessionToken);

        model.addAttribute(new Payment());
//        model.addAttribute("totalCost", cart.getTotalCost());
        return "payment/checkout";
    }

    @PostMapping("checkout")
    public String processCheckoutForm(@ModelAttribute Payment newPayment, Errors errors){
        if(errors.hasErrors()){
            return "redirect:";
        }

        paymentRepository.save(newPayment);
        return "payment/process";
    }

//    @RequestMapping(value = "add", method = RequestMethod.POST)
//    public String paymentProcessed(Model model) {
//        model.addAttribute("userPayment", paymentRepository.findAll());
//        return "something";
//    }

//    @PostMapping("add")
//    @ResponseBody
//    public String processUserPaymentForm(@ModelAttribute @Valid UserPayment newUserPayment, Errors errors) {
//        if (errors.hasErrors()) {
//            return "add";
//        }
//        paymentRepository.save(newUserPayment);
////        EmailController.sendEmail();
//
//        return "<html>" +
//                "<head>" +
//                "<body>" +
//                "<a href='/api/sendEmail'>Send Email</a>" +
//                "</body>" +
//                "</head>" +
//                "</html>";
//    }
}
