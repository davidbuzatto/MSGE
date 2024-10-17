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
package br.com.davidbuzatto.msge.image;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Abstração para as BufferedImages.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Image {
    
    public BufferedImage buffImage;
    
    public Image( BufferedImage buffImage ) {
        this.buffImage = buffImage;
    }
    
    public Image( int width, int height ) {
        this( new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB ) );
    }
    
    public int getWidth() {
        return buffImage.getWidth();
    }
    
    public int getHeight() {
        return buffImage.getHeight();
    }
    
    public Graphics2D createGraphics() {
        return (Graphics2D) buffImage.createGraphics();
    }
    
    public int getRGB( int x, int y ) {
        return buffImage.getRGB( x, y );
    }
    
    public void setRGB( int x, int y, int rgb ) {
        buffImage.setRGB( x, y, rgb );
    }
    
    //void ImageDrawPixel(Image *dst, int posX, int posY, Color color);                                  // Draw pixel within an buffImage
    //void ImageDrawPixelV(Image *dst, Vector2 position, Color color);                                   // Draw pixel within an buffImage (Vector version)
    //void ImageDrawLine(Image *dst, int startPosX, int startPosY, int endPosX, int endPosY, Color color); // Draw line within an buffImage
    //void ImageDrawLineV(Image *dst, Vector2 start, Vector2 end, Color color);                          // Draw line within an buffImage (Vector version)
    //void ImageDrawCircle(Image *dst, int centerX, int centerY, int radius, Color color);               // Draw a filled circle within an buffImage
    //void ImageDrawCircleV(Image *dst, Vector2 center, int radius, Color color);                        // Draw a filled circle within an buffImage (Vector version)
    //void ImageDrawCircleLines(Image *dst, int centerX, int centerY, int radius, Color color);          // Draw circle outline within an buffImage
    //void ImageDrawCircleLinesV(Image *dst, Vector2 center, int radius, Color color);                   // Draw circle outline within an buffImage (Vector version)
    //void ImageDrawRectangle(Image *dst, int posX, int posY, int width, int height, Color color);       // Draw rectangle within an buffImage
    //void ImageDrawRectangleV(Image *dst, Vector2 position, Vector2 size, Color color);                 // Draw rectangle within an buffImage (Vector version)
    //void ImageDrawRectangleRec(Image *dst, Rectangle rec, Color color);                                // Draw rectangle within an buffImage
    //void ImageDrawRectangleLines(Image *dst, Rectangle rec, int thick, Color color);                   // Draw rectangle lines within an buffImage
    //void ImageDraw(Image *dst, Image src, Rectangle srcRec, Rectangle dstRec, Color tint);             // Draw a source buffImage within a destination buffImage (tint applied to source)
    //void ImageDrawText(Image *dst, const char *text, int posX, int posY, int fontSize, Color color);   // Draw text (using default font) within an buffImage (destination)
    //void ImageDrawTextEx(Image *dst, Font font, const char *text, Vector2 position, float fontSize, float spacing, Color tint); // Draw text (custom sprite font) within an buffImage (destination)

    
    
}
