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
package br.com.davidbuzatto.msge.core;

import java.awt.Color;

/**
 * Interface para elementos desenháveis.
 * 
 * @author Prof. Dr. David Buzatto
 */
public interface Drawable {
    
    /**
     * Desenha o elemento corrente usando a engine.
     * 
     * @param engine engine utilizada.
     * @param color cor do desenho.
     */
    void draw( Engine engine, Color color );

    /**
     * Pinta o elemento corrente usando a engine.
     * 
     * @param engine engine utilizada.
     * @param color cor do desenho.
     */
    void fill( Engine engine, Color color );

}
