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

import java.awt.Color;
import br.com.davidbuzatto.msge.core.Drawable;
import br.com.davidbuzatto.msge.core.Engine;

/**
 * Classe para representação de um polígono regular em duas dimensões.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Polygon implements Drawable {

    public double x;
    public double y;
    public int sides;
    public double radius;
    public double rotation;

    public Polygon() {
    }

    public Polygon( double x, double y, int sides, double radius, double rotation ) {
        this.x = x;
        this.y = y;
        this.sides = sides;
        this.radius = radius;
        this.rotation = rotation;
    }

    public Polygon( double x, double y, int sides, double radius ) {
        this( x, y, sides, radius, 0.0 );
    }

    @Override
    public void draw( Engine engine, Color color ) {
        engine.drawPolygon( this, color );
    }

    @Override
    public void fill( Engine engine, Color color ) {
        engine.fillPolygon( this, color );
    }

    @Override
    public String toString() {
        return String.format( "Polygon[%.2f, %.2f, %d, %.2f, %.2f]", x, y, sides, radius, rotation );
    }

}
