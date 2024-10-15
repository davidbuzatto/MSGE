/*
 * Copyright (C) 2024 Prof. Dr. David Buzatto
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.davidbuzatto.msge;

import br.com.davidbuzatto.msge.core.Engine;
import br.com.davidbuzatto.msge.geom.Vector2;
import java.awt.Font;

/**
 * Classe básica de exemplo de utilização da engine.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Main extends Engine {

    // declaração de variáveis

    public Main() {

        // cria a janela do jogo ou simulação
        super( 
            800,                  // 800 pixels de largura
            450,                  // 600 pixels de largura
            "Título da Janela",   // título da janela
            60,                   // 60 quadros por segundo
            true,                 // ativa a suavização (antialiasing)
            false,                // redimensionável (resizable)
            false,                // tela cheia (fullscreen na resolução atual)
            false,                // sem decoração (undecorated)
            false                 // sempre acima (always on top)
        );

    }

    /**
     * Processa a entrada inicial fornecida pelo usuário e cria
     * e/ou inicializa os objetos/contextos/variáveis do jogo ou simulação.
     */
    @Override
    public void create() {
    }

    /**
     * Atualiza os objetos/contextos/variáveis do jogo ou simulação.
     */
    @Override
    public void update() {
    }

    /**
     * Desenha o estado dos objetos/contextos/variáveis do jogo ou simulação.
     */
    @Override
    public void draw() {

        clearBackground( WHITE );
        setFontStyle( Font.BOLD );
        
        String text = "Basic game template";
        Vector2 m = new Vector2( measureText( text, 40 ), 40 );
        double x = getScreenWidth() / 2 - m.x / 2;
        double y = getScreenHeight() / 2 - m.y / 2;
        fillRectangle( x, y, m.x, m.y, BLACK );
        drawText( text, x, y + 30, 40, WHITE );

        drawFPS( 10, 20 );

    }

    public static void main( String[] args ) {
        new Main();
    }

}