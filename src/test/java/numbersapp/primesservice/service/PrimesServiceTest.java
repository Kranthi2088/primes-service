package numbersapp.primesservice.service;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrimesServiceTest {
    PrimesService primesService = new PrimesService();

    @Test
    public void _539828945930573IsNotPrime() {
        long n = 539828945930573L;
        boolean expected = false;
        boolean actual = primesService.isPrime(n);
        assertEquals(expected, actual);
    }

    @Test
    public void _285191IsPrime() {
        long n = 285191;
        boolean expected = true;
        boolean actual = primesService.isPrime(n);
        assertEquals(expected, actual);
    }
    @Test
    public void _45IsNotPrime() {
        int n = 45;
        boolean expected = false;
        boolean actual = primesService.isPrime(n);
        assertEquals(expected, actual);
    }
}