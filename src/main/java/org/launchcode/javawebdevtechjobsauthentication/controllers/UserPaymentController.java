package org.launchcode.javawebdevtechjobsauthentication.controllers;

import org.launchcode.javawebdevtechjobsauthentication.models.Cart;
import org.launchcode.javawebdevtechjobsauthentication.models.UserPayment;
import org.launchcode.javawebdevtechjobsauthentication.models.data.PaymentRepository;
import org.launchcode.javawebdevtechjobsauthentication.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("payment")
public class UserPaymentController {

    @Autowired
    private CartService cartService;

    @Autowired
    private PaymentRepository paymentRepository;

//    TODO: GET CART COST

    @GetMapping("checkout")
    public String displayCheckoutForm(Model model, String sessionToken) {
        Cart cart = cartService.findBySessionToken(sessionToken);
        model.addAttribute(new UserPayment());
//        model.addAttribute("totalCost", cart.getTotalCost());
        return "payment/checkout";
    }

    @PostMapping("payment")
    public String processCheckoutForm(@ModelAttribute @Valid UserPayment newUserPayment, Errors errors){
        if(errors.hasErrors()){
            return "redirect:/cart";
        }

        paymentRepository.save(newUserPayment);
        return "payment/paymentSuccess";
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
