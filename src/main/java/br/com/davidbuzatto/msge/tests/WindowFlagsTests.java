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
package br.com.davidbuzatto.msge.tests;

import br.com.davidbuzatto.msge.core.Engine;

/**
 * Testes das flags para criação da janela.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class WindowFlagsTests extends Engine {

    public WindowFlagsTests() {

        // cria a janela do jogo ou simulação
        super( 
            800,
            450,
            "Título da Janela",
            60,
            true,
            false,
            false,
            false,
            false
        );

    }

    @Override
    public void create() {
    }

    @Override
    public void update() {
    }

    @Override
    public void draw() {
        drawLine( 0, 0, getScreenWidth(), getScreenHeight(), BLACK );
        drawText( getTime() + "", 20, 20, 20, BLACK );
        drawText( getFrameTime() + "", 20, 40, 20, BLACK );
        drawText( getFPS() + "", 20, 60, 20, BLACK );
        drawFPS( 10, 100 );
    }

    public static void main( String[] args ) {
        new WindowFlagsTests();
    }

}