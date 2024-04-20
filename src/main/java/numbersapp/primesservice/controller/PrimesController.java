package numbersapp.primesservice.controller;

import numbersapp.primesservice.rabbitmq.MQSender;
import numbersapp.primesservice.service.IPrimesService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;




@RestController
@CrossOrigin
@RequestMapping("/primes")
public class PrimesController {

    IPrimesService iPrimesService;

    private final MQSender mqSender;


    public PrimesController(IPrimesService iPrimesService, MQSender mqSender){
        this.iPrimesService = iPrimesService;
        this.mqSender = mqSender;
    }
    @GetMapping("/{n}")
    public boolean isPrime(@PathVariable int n){
        boolean result = iPrimesService.isPrime(n);
        Object principal = SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        String username = ((Jwt) principal).getSubject();
        System.out.println(username);
        mqSender.sendMessage(username, n,result);
        return result;
    }
}