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
package br.com.davidbuzatto.msge.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Classe com métodos utilitários para tratamento de imagens.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class ImageUtils {
    
    /**
     * TODO
     * 
     * @param image
     * @param newWidth
     * @param newHeight
     * @return 
     */
    public static BufferedImage imageResize( BufferedImage image, int newWidth, int newHeight ) {
        
        BufferedImage newImage = new BufferedImage( newWidth, newHeight, BufferedImage.TYPE_INT_ARGB );
        
        Graphics2D g2d = (Graphics2D) newImage.createGraphics();
        g2d.drawImage( image, 0, 0, newWidth, newHeight, 0, 0, image.getWidth(), image.getHeight(), null );
        g2d.dispose();
        
        return newImage;
        
    }
    
    /**
     * TODO
     * 
     * @param image
     * @return 
     */
    public static BufferedImage imageRotateCW( BufferedImage image ) {
        
        BufferedImage newImage = new BufferedImage( image.getHeight(), image.getWidth(), BufferedImage.TYPE_INT_ARGB );
        
        Graphics2D g2d = (Graphics2D) newImage.createGraphics();
        g2d.translate( newImage.getWidth(), 0 );
        g2d.rotate( Math.toRadians( 90 ) );
        g2d.drawImage( image, 0, 0, null );
        g2d.dispose();
        
        return newImage;
        
    }
    
    /**
     * TODO
     * 
     * @param image
     * @return 
     */
    public static BufferedImage imageRotateCCW( BufferedImage image ) {
        
        BufferedImage newImage = new BufferedImage( image.getHeight(), image.getWidth(), BufferedImage.TYPE_INT_ARGB );
        
        Graphics2D g2d = (Graphics2D) newImage.createGraphics();
        g2d.translate( 0, newImage.getHeight() );
        g2d.rotate( Math.toRadians( -90 ) );
        g2d.drawImage( image, 0, 0, null );
        g2d.dispose();
        
        return newImage;
        
    }
    
    /**
     * TODO
     * 
     * @param image
     * @param color
     * @return 
     */
    public static BufferedImage imageColorTint( BufferedImage image, Color color ) {
        
        BufferedImage newImage = new BufferedImage( image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB );
        
        for ( int i = 0; i < image.getHeight(); i++ ) {
            for ( int j = 0; j < image.getWidth(); j++ ) {
                
                Color c = Utils.colorTint( new Color( image.getRGB( j, i ) ), color );
                int pixel = image.getRGB( j, i );
                int alpha = (pixel >> 24) & 0xff;
                c = new Color( c.getRed(), c.getGreen(), c.getBlue(), alpha );
                
                newImage.setRGB( j, i, c.getRGB() );
                
            }
        }
        
        return newImage;
        
    }
    
    /**
     * TODO
     * 
     * @param image
     * @return 
     */
    public static BufferedImage imageColorInvert( BufferedImage image ) {
        
        BufferedImage newImage = new BufferedImage( image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB );
        
        for ( int i = 0; i < image.getHeight(); i++ ) {
            for ( int j = 0; j < image.getWidth(); j++ ) {
                int pixel = image.getRGB( j, i );
                int alpha = (pixel >> 24) & 0xff;
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel >> 0) & 0xff;
                newImage.setRGB( j, i, new Color( 255 - red, 255 - green, 255 - blue, alpha ).getRGB() );
            }
        }
        
        return newImage;
        
    }
    
    /**
     * TODO
     * 
     * @param image
     * @return 
     */
    public static BufferedImage imageColorGrayscale( BufferedImage image ) {
        
        BufferedImage newImage = new BufferedImage( image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB );
        
        for ( int i = 0; i < image.getHeight(); i++ ) {
            for ( int j = 0; j < image.getWidth(); j++ ) {
                int pixel = image.getRGB( j, i );
                int alpha = (pixel >> 24) & 0xff;
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel >> 0) & 0xff;
                int gray = ( red + green + blue ) / 3;
                newImage.setRGB( j, i, new Color( gray, gray, gray, alpha ).getRGB() );
            }
        }
        
        return newImage;
        
    }
    
    /**
     * TODO
     * 
     * @param image
     * @param contrast
     * @return 
     */
    public static BufferedImage imageColorContrast( BufferedImage image, double contrast ) {
        
        BufferedImage newImage = new BufferedImage( image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB );
        
        for ( int i = 0; i < image.getHeight(); i++ ) {
            for ( int j = 0; j < image.getWidth(); j++ ) {
                
                Color c = Utils.colorContrast( new Color( image.getRGB( j, i ) ), contrast );
                int pixel = image.getRGB( j, i );
                int alpha = (pixel >> 24) & 0xff;
                c = new Color( c.getRed(), c.getGreen(), c.getBlue(), alpha );
                
                newImage.setRGB( j, i, c.getRGB() );
                
            }
        }
        
        return newImage;
    }
    
    /**
     * TODO
     * 
     * @param image
     * @param brightness
     * @return 
     */
    public static BufferedImage imageColorBrightness( BufferedImage image, double brightness ) {
        
        BufferedImage newImage = new BufferedImage( image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB );
        
        for ( int i = 0; i < image.getHeight(); i++ ) {
            for ( int j = 0; j < image.getWidth(); j++ ) {
                
                Color c = Utils.colorBrightness( new Color( image.getRGB( j, i ) ), brightness );
                int pixel = image.getRGB( j, i );
                int alpha = (pixel >> 24) & 0xff;
                c = new Color( c.getRed(), c.getGreen(), c.getBlue(), alpha );
                
                newImage.setRGB( j, i, c.getRGB() );
                
            }
        }
        
        return newImage;
        
    }
    
    /**
     * TODO
     * 
     * @param image
     * @param color
     * @param replace
     * @return 
     */
    public static BufferedImage imageColorReplace( BufferedImage image, Color color, Color replace ) {
        
        BufferedImage newImage = new BufferedImage( image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB );
        
        for ( int i = 0; i < image.getHeight(); i++ ) {
            for ( int j = 0; j < image.getWidth(); j++ ) {
                
                int pixel = image.getRGB( j, i );
                int alpha = (pixel >> 24) & 0xff;
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel >> 0) & 0xff;
                Color c = new Color( red, green, blue, alpha );
                
                if ( pixel == color.getRGB() ) {
                    newImage.setRGB( j, i, replace.getRGB() );
                } else {
                    newImage.setRGB( j, i, c.getRGB() );
                }
                
            }
        }
        
        return newImage;
        
    }
    
    /**
     * TODO
     * 
     * @param image
     * @param x
     * @param y
     * @return 
     */
    public static Color getImageColor( BufferedImage image, int x, int y ) {
        return new Color( image.getRGB( x, y ), true );
    }
    
    
    //void ImageDrawPixel(Image *dst, int posX, int posY, Color color);                                  // Draw pixel within an image
    //void ImageDrawPixelV(Image *dst, Vector2 position, Color color);                                   // Draw pixel within an image (Vector version)
    //void ImageDrawLine(Image *dst, int startPosX, int startPosY, int endPosX, int endPosY, Color color); // Draw line within an image
    //void ImageDrawLineV(Image *dst, Vector2 start, Vector2 end, Color color);                          // Draw line within an image (Vector version)
    //void ImageDrawCircle(Image *dst, int centerX, int centerY, int radius, Color color);               // Draw a filled circle within an image
    //void ImageDrawCircleV(Image *dst, Vector2 center, int radius, Color color);                        // Draw a filled circle within an image (Vector version)
    //void ImageDrawCircleLines(Image *dst, int centerX, int centerY, int radius, Color color);          // Draw circle outline within an image
    //void ImageDrawCircleLinesV(Image *dst, Vector2 center, int radius, Color color);                   // Draw circle outline within an image (Vector version)
    //void ImageDrawRectangle(Image *dst, int posX, int posY, int width, int height, Color color);       // Draw rectangle within an image
    //void ImageDrawRectangleV(Image *dst, Vector2 position, Vector2 size, Color color);                 // Draw rectangle within an image (Vector version)
    //void ImageDrawRectangleRec(Image *dst, Rectangle rec, Color color);                                // Draw rectangle within an image
    //void ImageDrawRectangleLines(Image *dst, Rectangle rec, int thick, Color color);                   // Draw rectangle lines within an image
    //void ImageDraw(Image *dst, Image src, Rectangle srcRec, Rectangle dstRec, Color tint);             // Draw a source image within a destination image (tint applied to source)
    //void ImageDrawText(Image *dst, const char *text, int posX, int posY, int fontSize, Color color);   // Draw text (using default font) within an image (destination)
    //void ImageDrawTextEx(Image *dst, Font font, const char *text, Vector2 position, float fontSize, float spacing, Color tint); // Draw text (custom sprite font) within an image (destination)
    
}
