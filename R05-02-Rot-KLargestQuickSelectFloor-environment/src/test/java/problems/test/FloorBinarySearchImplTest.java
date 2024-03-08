package problems.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;

import problems.FloorBinarySearchImpl;

public class FloorBinarySearchImplTest {
    public FloorBinarySearchImpl implementation;

    private Integer[] vetorTamPar;
    private Integer[] vetorTamImpar;
    private Integer[] vetorVazio;
    private Integer[] vetorValoresRepetidos;
    private Integer[] vetorValoresIguais;
    private Integer[] vetorValoresNegativos;

    @Before
    public void setUp() {
        this.implementation = new FloorBinarySearchImpl();
        
        this.vetorTamPar = new Integer[] {30, 28, 7, 29, 11, 26, 4, 22, 23, 31};
        this.vetorTamImpar = new Integer[] {6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36};
        this.vetorVazio = new Integer[] {};
        this.vetorValoresRepetidos = new Integer[] {4, 9, -3, 4, 0, 5, 1, 4};
        this.vetorValoresIguais = new Integer[] {6, 6, 6, 6, 6, 6};
        this.vetorValoresNegativos = new Integer[] {-2, -4, -1, -8, -49};
    }

    @Test
    public void test01() {
        int out = this.implementation.floor(vetorTamPar, 27);
        assertEquals(26, out);
    }

    @Test
    public void test02() {
        int out = this.implementation.floor(vetorTamImpar, 49);
        assertEquals(49, out);
    }

    @Test
    public void test03() {
        Integer out = this.implementation.floor(vetorVazio, 2);
        assertEquals(null, out);
    }

    @Test
    public void test04() {
        int out = this.implementation.floor(vetorValoresRepetidos, 4);
        assertEquals(4, out);
    }

    @Test
    public void test05() {
        int out = this.implementation.floor(vetorValoresIguais, 8);
        assertEquals(6, out);
    }

    @Test
    public void test06() {
        Integer out = this.implementation.floor(vetorValoresIguais, 4);
        assertEquals(null, out);
    }

    @Test
    public void test07() {
        int out = this.implementation.floor(vetorValoresNegativos, 0);
        assertEquals(-1, out);
    }
}