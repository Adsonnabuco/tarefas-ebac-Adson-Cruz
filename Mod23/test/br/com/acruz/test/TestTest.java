package br.com.acruz.test;

import br.com.acruz.prog.ExercicioMod22;
import br.com.acruz.prog.Pessoa;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TestTest {
    @Test
    public void VerificarFeminino() {
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Joao", "M"),
                new Pessoa("Levi", "M"),
                new Pessoa("Maria", "Feminino"),
                new Pessoa("Cleber", "M"),
                new Pessoa("Jandira", "F"),
                new Pessoa("Saynarah", "F")
        );

        List<Pessoa> mulheres = ExercicioMod22.filtrarMulheres(pessoas);

        assertEquals(3, mulheres.size());  // Espera-se 3 mulheres no resultado
        assertTrue(mulheres.stream().allMatch(p -> p.getSexo().equalsIgnoreCase("F") || p.getSexo().equalsIgnoreCase("Feminino")));
        assertTrue(mulheres.stream().anyMatch(p -> p.getNome().equals("Maria")));
        assertTrue(mulheres.stream().anyMatch(p -> p.getNome().equals("Jandira")));
        assertTrue(mulheres.stream().anyMatch(p -> p.getNome().equals("Saynarah")));

    }
}