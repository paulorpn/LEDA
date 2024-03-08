package orderStatistic.test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

import orderStatistic.KLargestOrderStatisticsImpl;

public class KLargestOrderStatisticsImplTest {
    public KLargestOrderStatisticsImpl<Integer> implementation;

    private Integer[] vetorTamPar;
    private Integer[] vetorTamImpar;
    private Integer[] vetorVazio;
    private Integer[] vetorValoresRepetidos;
    private Integer[] vetorValoresIguais;
    private Integer[] vetorValoresNegativos;

    @Before
    public void setUp() {
        this.implementation = new KLargestOrderStatisticsImpl<>();
        
        this.vetorTamPar = new Integer[] {30, 28, 7, 29, 11, 26, 4, 22, 23, 31};
        this.vetorTamImpar = new Integer[] {6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36};
        this.vetorVazio = new Integer[] {};
        this.vetorValoresRepetidos = new Integer[] {4, 9, -3, 4, 0, 5, 1, 4};
        this.vetorValoresIguais = new Integer[] {6, 6, 6, 6, 6, 6};
        this.vetorValoresNegativos = new Integer[] {-2, -4, -1, -8, -49};
    }

    @Test
    public void test01() {
        Integer[] expected = {30, 31};
        assertArrayEquals(expected, this.implementation.getKLargest(vetorTamPar, 8));
    }

    @Test
    public void test02() {
        Integer[] expected = {37, 41, 49};
        assertArrayEquals(expected, this.implementation.getKLargest(vetorTamImpar, 8));
    }

    @Test
    public void test03() {
        Integer[] expected = {};
        assertArrayEquals(expected, this.implementation.getKLargest(vetorVazio, 5));
    }

    @Test
    public void test04() {
        Integer[] expected = {4, 4, 5, 9};
        assertArrayEquals(expected, this.implementation.getKLargest(vetorValoresRepetidos, 4));
    }

    @Test
    public void test05() {
        Integer[] expected = {6, 6, 6, 6, 6};
        assertArrayEquals(expected, this.implementation.getKLargest(vetorValoresIguais, 1));
    }

    @Test
    public void test06() {
        Integer[] expected = {-2, -1};
        assertArrayEquals(expected, this.implementation.getKLargest(vetorValoresNegativos, 3));
    }

    @Test
    public void test07() {
        Integer[] expected = {};
        assertArrayEquals(expected, this.implementation.getKLargest(vetorValoresRepetidos, 0));
    }
}