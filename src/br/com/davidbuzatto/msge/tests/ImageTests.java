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
import br.com.davidbuzatto.msge.geom.Rectangle;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Prof. Dr. David Buzatto
 */
public class ImageTests extends Engine {

    public ImageTests() {
        super( 800, 450, "Image tests", 60, true );
    }
    
    private BufferedImage img;
    
    @Override
    public void create() {
        img = loadImage( "resources/images/duke.png" );
    }

    @Override
    public void update() {
        
    }
    
    double r = 0;
    
    Color cr = new Color( 255, 0, 0, 100 );
    Color cg = new Color( 0, 255, 0, 100 );
    Color cb = new Color( 0, 0, 255, 100 );
    
    @Override
    public void draw() {
        
        drawImage( img, 10, 10, cg );
        drawImage( img, 10, 10, 45, cb );
        drawImage( img, 10, 10, 10, 10, 90, cr );
        
        drawImage( img, new Rectangle( 0, 0, 100, 100 ), 10, 10, cg );
        drawImage( img, new Rectangle( 0, 0, 100, 100 ), 10, 10, 45, cb );
        drawImage( img, new Rectangle( 0, 0, 100, 100 ), 10, 10, 10, 10, 90 );
        
        drawImage( img, new Rectangle( 0, 0, 100, 100 ), new Rectangle( 200, 100, 200, 200 ), cg );
        drawImage( img, new Rectangle( 0, 0, 100, 100 ), new Rectangle( 200, 100, 200, 200 ), 45, cb );
        drawImage( img, new Rectangle( 0, 0, 100, 100 ), new Rectangle( 200, 100, 200, 200 ), 10, 10, 90 );
        
        r += 5;
        
    }
    
    public static void main( String[] args ) {
        new ImageTests();
    }
    
}
