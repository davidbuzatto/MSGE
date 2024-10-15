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
import br.com.davidbuzatto.msge.utils.Utils;
import java.awt.Color;

/**
 * Testes de algumas funções.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class FunctionTests extends Engine {

    public FunctionTests() {
        super( 800, 500, "Utilitary Functions Test", 60, true );
    }

    @Override
    public void create() {
    }

    @Override
    public void update() {
    }
    
    @Override
    public void draw() {

        for ( int i = 0; i <= 360; i++ ) {
            drawRectangle( 100 + i, 100 + i, 2, 2, Utils.colorFromHSV( i, 1, 1 ) );
        }

        Color c = LIME;
        fillRectangle( 0, 0, 100, 100, c );
        fillRectangle( 0, 100, 100, 100, Utils.colorAlpha( c, 0.5 ) );
        fillRectangle( 0, 200, 100, 100, Utils.colorTint( c, WHITE ) );
        fillRectangle( 0, 300, 100, 100, Utils.colorBrightness( c, -0.5 ) );
        fillRectangle( 0, 400, 100, 100, Utils.colorContrast( c, -0.5 ) );

    }

    public static void main( String[] args ) {
        new FunctionTests();
    }

}