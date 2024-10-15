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
import br.com.davidbuzatto.msge.geom.Circle;
import br.com.davidbuzatto.msge.geom.CubicCurve;
import br.com.davidbuzatto.msge.geom.Line;
import br.com.davidbuzatto.msge.geom.Point;
import br.com.davidbuzatto.msge.geom.Polygon;
import br.com.davidbuzatto.msge.geom.QuadCurve;
import br.com.davidbuzatto.msge.geom.Rectangle;
import br.com.davidbuzatto.msge.geom.Triangle;
import br.com.davidbuzatto.msge.utils.Utils;
import java.awt.Color;
import java.awt.Font;

/**
 * Testes de colisão.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class CollisionTests extends Engine {

    private Line line;
    private Rectangle rectangle;
    private Circle circle;
    private Triangle triangle;
    private Polygon polygon;

    private Line moveableLine;
    private Color moveableLineColor;
    private boolean mlDragging;

    private Rectangle moveableRect;
    private Color moveableRectColor;
    private boolean mrDragging;

    private Circle moveableCircle;
    private Color moveableCircleColor;
    private boolean mcDragging;

    private Color noOverlapColor = RAYWHITE;
    private Color overlapColor = GOLD;
    private Rectangle overlapRec;
    private Point lineCollisionPoint;

    private Line lineForPoint;
    private QuadCurve quadForPoint;
    private CubicCurve cubicForPoint;
    private Point pointForLine;
    private Point pointForQuad;
    private Point pointForCubic;

    private double amount;
    private double amountVel;

    private double xOffset;
    private double yOffset;

    private String textPointGeom;
    private String textLineGeom;
    private String textRectGeom;
    private String textCircleGeom;

    public CollisionTests() {
        super( 800, 450, "Collisions Tests", 60, true );
    }

    @Override
    public void create() {

        amountVel = 1;

        line = new Line( 240, 40, 310, 110 );
        rectangle = new Rectangle( 250, 120, 50, 100 );
        circle = new Circle( 275, 260, 30 );
        triangle = new Triangle( 275, 300, 315, 370, 235, 370 );
        polygon = new Polygon( 275, 430, 5, 45, 0 );

        moveableLine = new Line( 410, 110, 480, 40 );
        moveableRect = new Rectangle( 400, 145, 100, 50 );
        moveableCircle = new Circle( 450, 260, 30 );

        lineForPoint = new Line( 600, 100, 700, 200 ) ;
        quadForPoint = new QuadCurve( 600, 250, 700, 250, 700, 350 ) ;
        cubicForPoint = new CubicCurve( 600, 400, 600, 430, 700, 460, 700, 500 );

        textPointGeom = "none";
        textLineGeom = "none";
        textRectGeom = "none";
        textCircleGeom = "none";

    }

    @Override
    public void update() {

        double delta = getFrameTime();
        Point mousePos = getMousePositionPoint();
        
        if ( isMouseButtonPressed( MOUSE_BUTTON_LEFT ) ) {

            if ( Utils.checkCollisionPointLine( mousePos, line, 5 ) ) {
                textPointGeom = "line!";
            } else if ( Utils.checkCollisionPointRectangle( mousePos, rectangle ) ) {
                textPointGeom = "rectangle!";
            } else if ( Utils.checkCollisionPointCircle( mousePos, circle ) ) {
                textPointGeom = "circle!";
            } else if ( Utils.checkCollisionPointTriangle( mousePos, triangle ) ) {
                textPointGeom = "triangle!";
            } else if ( Utils.checkCollisionPointPolygon( mousePos, polygon ) ) {
                textPointGeom = "polygon!";
            } else {
                textPointGeom = "none";
            }

            if ( Utils.checkCollisionPointLine( mousePos, moveableLine, 10 ) ) {
                mlDragging = true;
                xOffset = moveableLine.x1 - mousePos.x;
                yOffset = moveableLine.y1 - mousePos.y;
            }

            if ( Utils.checkCollisionPointRectangle( mousePos, moveableRect ) ) {
                mrDragging = true;
                xOffset = moveableRect.x - mousePos.x;
                yOffset = moveableRect.y - mousePos.y;
            }

            if ( Utils.checkCollisionPointCircle( mousePos, moveableCircle ) ) {
                mcDragging = true;
                xOffset = moveableCircle.x - mousePos.x;
                yOffset = moveableCircle.y - mousePos.y;
            }

        }

        if ( isMouseButtonReleased( MOUSE_BUTTON_LEFT ) ) {
            mlDragging = false;
            mrDragging = false;
            mcDragging = false;
        }

        amount += amountVel * delta;
        if ( amount < 0.0 ) {
            amountVel = -amountVel;
            amount = 0.0;
        } else if ( amount > 1.0 ) {
            amountVel = -amountVel;
            amount = 1.0;
        }

        pointForLine = Utils.getPointAtLine( lineForPoint, amount );
        pointForQuad = Utils.getPointAtQuadCurve( quadForPoint, amount );
        pointForCubic = Utils.getPointAtCubicCurve( cubicForPoint, amount );

        if ( mlDragging && mousePos != null ) {
            double difX = moveableLine.x2 - moveableLine.x1;
            double difY = moveableLine.y2 - moveableLine.y1;
            moveableLine.x1 = mousePos.x + xOffset;
            moveableLine.y1 = mousePos.y + yOffset;
            moveableLine.x2 = mousePos.x + difX + xOffset;
            moveableLine.y2 = mousePos.y + difY + yOffset;
        } else if ( mrDragging && mousePos != null ) {
            moveableRect.x = mousePos.x + xOffset;
            moveableRect.y = mousePos.y + yOffset;
        } else if ( mcDragging && mousePos != null ) {
            moveableCircle.x = mousePos.x + xOffset;
            moveableCircle.y = mousePos.y + yOffset;
        }

        lineCollisionPoint = Utils.checkCollisionLines( moveableLine, line );

        if ( lineCollisionPoint != null ) {
            textLineGeom = "line!";
            moveableLineColor = overlapColor;
        } else {
            moveableLineColor = BLACK;
            textLineGeom = "none";
        }

        if ( Utils.checkCollisionRectangles( moveableRect, rectangle ) ) {
            textRectGeom = "rectangle!";
            moveableRectColor = overlapColor;
            overlapRec = Utils.getCollisionRectangle( moveableRect, rectangle );
        } else {
            moveableRectColor = noOverlapColor;
            overlapRec = null;
            textRectGeom = "none";
        }

        if ( Utils.checkCollisionCircleLine( moveableCircle, line ) ) {
            textCircleGeom = "line!";
            moveableCircleColor = overlapColor;
        } else if ( Utils.checkCollisionCircleRectangle( moveableCircle, rectangle ) ) {
            textCircleGeom = "rectangle!";
            moveableCircleColor = overlapColor;
        } else if ( Utils.checkCollisionCircles( moveableCircle, circle ) ) {
            textCircleGeom = "circle!";
            moveableCircleColor = overlapColor;
        } else {
            textCircleGeom = "none";
            moveableCircleColor = noOverlapColor;
        }

    }

    @Override
    public void draw() {

        setFontStyle( Font.BOLD );

        line.draw( this, BLACK );
        
        rectangle.fill( this, BLUE );
        rectangle.draw( this, BLACK );
        
        circle.fill( this, MAROON );
        circle.draw( this, BLACK );
        
        triangle.fill( this, ORANGE );
        triangle.draw( this, BLACK );
        
        polygon.fill( this, LIME );
        polygon.draw( this, BLACK );

        moveableLine.draw( this, moveableLineColor );

        moveableRect.fill( this, moveableRectColor );
        moveableRect.draw( this, BLACK );

        moveableCircle.fill( this, moveableCircleColor );
        moveableCircle.draw( this, BLACK );

        if ( overlapRec != null ) {
            overlapRec.fill( this, PINK );
            overlapRec.draw( this, BLACK );
        }

        if ( lineCollisionPoint != null ) {
            fillCircle( lineCollisionPoint, 10, VIOLET );
            drawCircle( lineCollisionPoint, 10, BLACK );
        }

        lineForPoint.draw( this, BLACK );
        quadForPoint.draw( this, BLACK );
        cubicForPoint.draw( this, BLACK );

        fillCircle( pointForLine, 10, RED );
        fillCircle( pointForQuad, 10, GREEN );
        fillCircle( pointForCubic, 10, BLUE );

        drawFPS( 10, 30 );
        drawText( " Point x Geom: " + textPointGeom, 10, 60, 20, BLACK );
        drawText( "  Line x Geom: " + textLineGeom, 10, 90, 20, BLACK );
        drawText( "  Rect x Geom: " + textRectGeom, 10, 120, 20, BLACK );
        drawText( "Circle x Geom: " + textCircleGeom, 10, 150, 20, BLACK );

    }

    public static void main( String[] args ) {
        new CollisionTests();
    }

}