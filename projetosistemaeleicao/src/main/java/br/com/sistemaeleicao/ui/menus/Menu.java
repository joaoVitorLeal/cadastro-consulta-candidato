package br.com.sistemaeleicao.ui.menus;

import java.util.Scanner;

/**
 * @author joaoleal
 */

public abstract class Menu {
    protected abstract void exibirOpcoes();
    protected abstract void processarEntradas(Scanner sc);
}
