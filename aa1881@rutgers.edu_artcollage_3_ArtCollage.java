/*************************************************************************
 *  Compilation:  javac ArtCollage.java
 *  Execution:    java ArtCollage
 *
 *  @author:Aswathy Aji, aa1881@scarletmail.rutgers.edu, aa1881
 *
 *************************************************************************/

import java.awt.Color;

public class ArtCollage {

    // The orginal picture
    private Picture original;

    // The collage picture
    private Picture collage;

    // The collage Picture consists of collageDimension X collageDimension tiles
    private int collageDimension;

    // A tile consists of tileDimension X tileDimension pixels
    private int tileDimension;
    
    /*
     * One-argument Constructor
     * 1. set default values of collageDimension to 4 and tileDimension to 100
     * 2. initializes original with the filename image
     * 3. initializes collage as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collage to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public ArtCollage (String filename) {

	// WRITE YOUR CODE HERE
        this(filename,100,4);

    }

    /*
     * Three-arguments Constructor
     * 1. set default values of collageDimension to cd and tileDimension to td
     * 2. initializes original with the filename image
     * 3. initializes collage as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collage to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public ArtCollage (String filename, int td, int cd) {

	// WRITE YOUR CODE HERE
        tileDimension = td;
        collageDimension = cd;
        
        collage = new Picture(td*cd, td*cd);
        original = new Picture(filename);
        

        int height = original.height();
        int width = original.width();
        for (int column = 0; column < collage.width(); column++){
            for(int row = 0; row < collage.height(); row++){
                int newColumn = (column*width)/collage.width();
                int newRow = (row*height)/collage.height();
                collage.set(column,row,original.get(newColumn, newRow));
            }
        }
    }

    /*
     * Returns the collageDimension instance variable
     *
     * @return collageDimension
     */
    public int getCollageDimension() {

	// WRITE YOUR CODE HERE
        return collageDimension;

    }

    /*
     * Returns the tileDimension instance variable
     *
     * @return tileDimension
     */
    public int getTileDimension() {

	// WRITE YOUR CODE HERE
        return tileDimension;
    }

    /*
     * Returns original instance variable
     *
     * @return original
     */
    public Picture getOriginalPicture() {

	// WRITE YOUR CODE HERE
        return original;

    }

    /*
     * Returns collage instance variable
     *
     * @return collage
     */
    public Picture getCollagePicture() {

	// WRITE YOUR CODE HERE
        return collage;
    }
    
    /*
     * Display the original image
     * Assumes that original has been initialized
     */
    public void showOriginalPicture() {

	// WRITE YOUR CODE HERE
        original.show();
    }

    /*
     * Display the collage image
     * Assumes that collage has been initialized
     */
    public void showCollagePicture() {

	// WRITE YOUR CODE HERE
        collage.show();
    }

    /*
     * Replaces the tile at collageCol,collageRow with the image from filename
     * Tile (0,0) is the upper leftmost tile
     *
     * @param filename image to replace tile
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void replaceTile (String filename,  int collageCol, int collageRow) {

	// WRITE YOUR CODE HERE
        Picture replace = new Picture(filename);

        for(int column = 0; column < collage.width(); column++){
            for(int row = 0; row < collage.height(); row++){
                if(column/tileDimension == collageCol && row/tileDimension == collageRow){
                    int newCol = (column % tileDimension) * collageDimension * replace.width()/ collage.width();
                    int newRow = (row % tileDimension) * collageDimension * replace.height()/ collage.height();
                    Color colorSet = replace.get(newCol,newRow);
                    collage.set(column,row,colorSet);
                }
            }
        }
    }
    
    /*
     * Makes a collage of tiles from original Picture
     * original will have collageDimension x collageDimension tiles, each tile
     * has tileDimension X tileDimension pixels
     */
    public void makeCollage () {

	// WRITE YOUR CODE HERE
        for(int column = 0; column < collage.width(); column++){
            for(int row = 0; row < collage.height(); row++){
                int newCol = (column%tileDimension)*collageDimension*original.width()/collage.width();
                int newRow = (row%tileDimension)*collageDimension*original.height()/collage.height();
                Color colorSet = original.get(newCol,newRow);
                collage.set(column,row,colorSet);
            }
        }
    }

    /*
     * Colorizes the tile at (collageCol, collageRow) with component 
     * (see Week 9 slides, the code for color separation is at the 
     *  book's website)
     *
     * @param component is either red, blue or green
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void colorizeTile (String component,  int collageCol, int collageRow) {

	// WRITE YOUR CODE HERE
         for(int column = 0; column < collage.width(); column++){
            for(int row = 0; row < collage.height(); row++){
                if(column/tileDimension == collageCol && row/tileDimension == collageRow){
                    Color color = collage.get(column,row);
                    if (component == "blue"){
                        getCollagePicture().set(column, row, new Color(0, 0, color.getBlue()));
                    }
                    else if (component == "green"){
                        getCollagePicture().set(column, row, new Color(0, color.getGreen(), 0));
                    }
                    else if (component == "red"){
                        getCollagePicture().set(column, row, new Color(color.getRed(), 0, 0));
                    }
                    
                }
            }
        }
    }

    /*
     * Greyscale tile at (collageCol, collageRow)
     * (see Week 9 slides, the code for luminance is at the book's website)
     *
     * @param collageCol tile column
     * @param collageRow tile row
     */

    public void greyscaleTile (int collageCol, int collageRow) {

	// WRITE YOUR CODE HERE
        for(int column = 0; column < collage.width(); column++){
            for (int row = 0; row< collage.height(); row++){
                Color color = collage.get(column, row);
                if(column/tileDimension == collageCol && row/tileDimension == collageRow){
                    Color gray = Luminance.toGray(color);
                    collage.set(column, row, gray);
                }
            }
        }
    }


    // Test client 
    public static void main (String[] args) {

        ArtCollage art = new ArtCollage(args[0], 200, 3);
        art.makeCollage();
        art.replaceTile(args[1],1,0);
        art.showCollagePicture();
    }
}
