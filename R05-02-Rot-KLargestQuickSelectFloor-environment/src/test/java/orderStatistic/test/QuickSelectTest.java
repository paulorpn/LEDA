package orderStatistic.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import orderStatistic.QuickSelect;


public class QuickSelectTest {
    public QuickSelect<Integer> implementation;

    private Integer[] vetorTamPar;
    private Integer[] vetorTamImpar;
    private Integer[] vetorVazio;
    private Integer[] vetorValoresRepetidos;
    private Integer[] vetorValoresIguais;
    private Integer[] vetorValoresNegativos;

    @Before
    public void setUp() {
        this.implementation = new QuickSelect<>();
        
        this.vetorTamPar = new Integer[] {30, 28, 7, 29, 11, 26, 4, 22, 23, 31};
        this.vetorTamImpar = new Integer[] {6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36};
        this.vetorVazio = new Integer[] {};
        this.vetorValoresRepetidos = new Integer[] {4, 9, -3, 4, 0, 5, 1, 4};
        this.vetorValoresIguais = new Integer[] {6, 6, 6, 6, 6, 6};
        this.vetorValoresNegativos = new Integer[] {-2, -4, -1, -8, -49};
    }

    @Test
    public void test01() {
        int actual = this.implementation.quickSelect(vetorTamPar, 3);
        assertEquals(11, actual);
    }

    @Test
    public void test02() {
        int actual = this.implementation.quickSelect(vetorTamImpar, 10);
        assertEquals(41, actual);
    }

    @Test
    public void test03() {
        Integer actual = this.implementation.quickSelect(vetorVazio, 3);
        assertEquals(null, actual);
    }

    @Test
    public void test04() {
        int actual = this.implementation.quickSelect(vetorValoresRepetidos, 5);
        assertEquals(4, actual);
    }

    @Test
    public void test05() {
        int actual = this.implementation.quickSelect(vetorValoresIguais, 1);
        assertEquals(6, actual);
    }

    @Test
    public void test06() {
        int actual = this.implementation.quickSelect(vetorValoresNegativos, 2);
        assertEquals(-8, actual);
    }

    @Test
    public void test07() {
        Integer actual = this.implementation.quickSelect(vetorTamPar, 0);
        assertEquals(null, actual);
    }

    @Test
    public void test08() {
        Integer actual = this.implementation.quickSelect(vetorTamPar, 11);
        assertEquals(null, actual);
    }
}