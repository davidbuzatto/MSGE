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
 * Classe para representação de um setor circular.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class CircleSector implements Drawable {
    
    public double x;
    public double y;
    public double radius;
    public double startAngle;
    public double endAngle;

    /**
     * Cria um setor circular com valores padrão.
     */
    public CircleSector() {
    }

    /**
     * Cria um setor circular.
     * 
     * @param x coordenada x do centro.
     * @param y coordenada y do centro.
     * @param radius raio .
     * @param startAngle ângulo inicial em graus (sentido horário).
     * @param endAngle ângulo final em gradus (sentido horário).
     */
    public CircleSector( double x, double y, double radius, double startAngle, double endAngle ) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.startAngle = startAngle;
        this.endAngle = endAngle;
    }

    @Override
    public void draw( Engine engine, Color color ) {
        engine.drawCircleSector( this, color );
    }

    @Override
    public void fill( Engine engine, Color color ) {
        engine.fillCircleSector( this, color );
    }

    @Override
    public String toString() {
        return String.format( "CircleSector[%.2f, %.2f, %.2f, %.2f, %.2f]", x, y, radius, startAngle, endAngle );
    }

}
