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
 * Testes de entrada.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class InputTests extends Engine {

    private double value;

    public InputTests() {
        super( 800, 450, "Input tests", 60, true );
    }

    @Override
    public void create() {
    }

    @Override
    public void update() {
        
        if ( isMouseButtonPressed( MOUSE_BUTTON_LEFT ) ) {
            System.out.println( "esquerda" );
        }

        if ( isMouseButtonPressed( MOUSE_BUTTON_MIDDLE ) ) {
            System.out.println( "meio" );
        }

        if ( isMouseButtonPressed( MOUSE_BUTTON_RIGHT ) ) {
            System.out.println( "direita" );
        }

        if ( isKeyPressed( KEY_K ) ) {
            System.out.println( "aaa" );
        }

    }

    @Override
    public void draw() {

        /*if ( actionTest.isPressed() ) {
            drawLine( 0, 0, inputManager.getMouseX(), inputManager.getMouseY(), BLACK );
        }*/
        /*if ( isMouseButtonPressed( MouseEvent.BUTTON1 ) ) {
            System.out.println( "aaa" );
        }
        if ( isMouseButtonReleased( MouseEvent.BUTTON1 ) ) {
            System.out.println( "ccc" );
        }

        if ( isMouseButtonDown( MouseEvent.BUTTON1 ) ) {
            System.out.println( "bbb" );
        }

        if ( isMouseButtonUp( MouseEvent.BUTTON1 ) ) {
            System.out.println( "ddd" );
        }*/

        value += getMouseWheelMove();
        drawRectangle( 0, value, 100, 100, BLACK);

        /*if ( isKeyDown( KeyEvent.VK_LEFT ) ) {
            System.out.println( "press" );
        }*/

    }

    public static void main( String[] args ) {
        new InputTests();
    }

}