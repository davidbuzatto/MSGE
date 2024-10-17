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
import br.com.davidbuzatto.msge.image.Image;
import br.com.davidbuzatto.msge.utils.ImageUtils;
import java.awt.Color;

/**
 *
 * @author Prof. Dr. David Buzatto
 */
public class ImageTests extends Engine {

    public ImageTests() {
        super( 800, 450, "Image tests", 60, true );
    }
    
    private Image img;
    private Image tImg;
    
    @Override
    public void create() {
        img = loadImage( "resources/images/dukeCont.png" );
        //tImg = ImageUtils.imageResize( img, 100, 400 );
        tImg = ImageUtils.imageRotate( img, r );
        //tImg = ImageUtils.imageFlipVertical( img );
        //tImg = ImageUtils.imageFlipHorizontal( img );
        /*tImg = ImageUtils.imageRotateCCW( img );
        tImg = ImageUtils.imageRotateCCW( tImg );
        tImg = ImageUtils.imageRotateCCW( tImg );
        tImg = ImageUtils.imageRotateCCW( tImg );*/
        //tImg = ImageUtils.imageColorTint( img, WHITE );
        //tImg = ImageUtils.imageColorInvert( img );
        //tImg = ImageUtils.imageColorGrayscale( img );
        //tImg = ImageUtils.imageColorContrast( img, -0.5 );
        //tImg = ImageUtils.imageColorBrightness( img, -0.5 );
        //tImg = ImageUtils.imageColorReplace( img, Color.WHITE, Color.RED );
    }

    @Override
    public void update() {
        
        int x = getMouseX();
        int y = getMouseY();
        
        if ( x >= 0 && x < img.getWidth() && y >= 0 && y < img.getHeight() ) {
            cColor = ImageUtils.getImageColor( img, x, y );
        } else {
            cColor = null;
        }
        
        r -= 1;
        tImg = ImageUtils.imageRotate( img, r );
        if ( isKeyPressed( KEY_RIGHT ) ) {
            r += 10;
            tImg = ImageUtils.imageRotate( img, r );
        } else if ( isKeyPressed( KEY_LEFT ) ) {
            r -= 10;
            tImg = ImageUtils.imageRotate( img, r );
        }
        
    }
    
    double r = 0;
    
    Color cColor = null;
    Color cr = new Color( 255, 0, 0, 100 );
    Color cg = new Color( 0, 255, 0, 100 );
    Color cb = new Color( 0, 0, 255, 100 );
    
    @Override
    public void draw() {
        
        //drawImage( img, 0, 0, cg );
        /*if ( cColor != null ) {
            fillRectangle( getMouseX(), getMouseY(), 20, 20, cColor );
        }*/
        
        drawImage( tImg, 10, 10, cg );
        drawText( "r: " + r, 300, 300, 20, BLACK );
        
        
        /*drawImage( img, 10, 10, cg );
        drawImage( img, 10, 10, 45, cb );
        drawImage( img, 10, 10, 10, 10, 90, cr );
        
        drawImage( img, new Rectangle( 0, 0, 100, 100 ), 10, 10, cg );
        drawImage( img, new Rectangle( 0, 0, 100, 100 ), 10, 10, 45, cb );
        drawImage( img, new Rectangle( 0, 0, 100, 100 ), 10, 10, 10, 10, 90 );
        
        drawImage( img, new Rectangle( 0, 0, 100, 100 ), new Rectangle( 200, 100, 200, 200 ), cg );
        drawImage( img, new Rectangle( 0, 0, 100, 100 ), new Rectangle( 200, 100, 200, 200 ), 45, cb );
        drawImage( img, new Rectangle( 0, 0, 100, 100 ), new Rectangle( 200, 100, 200, 200 ), 10, 10, 90 );*/
        
    }
    
    public static void main( String[] args ) {
        new ImageTests();
    }
    
}
