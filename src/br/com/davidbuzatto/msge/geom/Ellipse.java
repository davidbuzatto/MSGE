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
 * Classe para representação de uma elipse em duas dimensões.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Ellipse implements Drawable {
    
    public double x;
    public double y;
    public double radiusH;
    public double radiusV;

    /**
     * Cria uma nova elipse com valores padrão.
     */
    public Ellipse() {
    }

    /**
     * Cria uma nova elipse.
     * 
     * @param x coordenada x do centro.
     * @param y coordenada y do centro.
     * @param radiusH raio horizontal.
     * @param radiusV raio vertical.
     */
    public Ellipse( double x, double y, double radiusH, double radiusV ) {
        this.x = x;
        this.y = y;
        this.radiusH = radiusH;
        this.radiusV = radiusV;
    }

    @Override
    public void draw( Engine engine, Color color ) {
        engine.drawEllipse( this, color );
    }

    @Override
    public void fill( Engine engine, Color color ) {
        engine.fillEllipse( this, color );
    }

    @Override
    public String toString() {
        return String.format( "Ellipse[%.2f, %.2f, %.2f, %.2f]", x, y, radiusH, radiusV );
    }

}
