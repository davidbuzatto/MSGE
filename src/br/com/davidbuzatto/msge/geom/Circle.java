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
package br.com.davidbuzatto.msge.geom;

import br.com.davidbuzatto.msge.core.Engine;
import java.awt.Color;

/**
 * Classe para representação de um círculo em duas dimensões.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Circle implements Drawable {

    public double x;
    public double y;
    public double radius;

    public Circle() {
    }

    public Circle( double x, double y, double radius ) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw( Engine engine, Color color ) {
        engine.drawCircle( this, color );
    }

    @Override
    public void fill( Engine engine, Color color ) {
        engine.fillCircle( this, color );
    }

    @Override
    public String toString() {
        return String.format( "Circle[%.2f, %.2f, %.2f]", x, y, radius );
    }

}
