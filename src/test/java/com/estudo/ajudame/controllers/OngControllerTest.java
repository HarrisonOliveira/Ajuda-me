package com.estudo.ajudame.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OngControllerTest {


    @Test
    public void testCadastroOng(){
     OngController controller = new OngController();
     controller.cadastroOng("World");

        Assertions.assertEquals("Hello World", controller.cadastroOng("World"));
    }
}
