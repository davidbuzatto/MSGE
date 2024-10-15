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
 * Classe para representação de uma linha em duas dimensões.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Line implements Drawable {

    public double x1;
    public double y1;
    public double x2;
    public double y2;

    public Line() {
    }

    public Line( double x1, double y1, double x2, double y2 ) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void draw( Engine engine, Color color ) {
        engine.drawLine( this, color );
    }

    @Override
    public void fill( Engine engine, Color color ) {
        engine.drawLine( this, color );
    }

    @Override
    public String toString() {
        return String.format( "Line[%.2f, %.2f, %.2f, %.2f]", x1, y1, x2, y2 );
    }

}
