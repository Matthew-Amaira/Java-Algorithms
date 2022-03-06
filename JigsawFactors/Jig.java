import java.util.Scanner;

public class Jig{
    //final Variables
    public static final int awayFromPieceAmount = 10;

    //User Variables
    public static float imageWidth;
    public static float imageHeight;
    public static int piecesAmount;

    //Calculated Variables
    public static float picRatio;
    public static float gridRatio;
    public static float pieceRatio;

    public static int piecesWidth;
    public static int piecesHeight;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter imageWidth:");
        imageWidth = input.nextFloat();
        System.out.println("Enter imageHeight:");
        imageHeight = input.nextFloat();
        System.out.println("Enter how many pieces:");
        piecesAmount = input.nextInt();

        calcPictureRatio();
        calcGridRatio();

        System.out.println("Picture Ratio  : "+picRatio);
        System.out.println("Best Grid Ratio: "+gridRatio);
        System.out.println("Puzzles has: ["+piecesWidth+", "+piecesHeight+"].");

        calcBestPieceAmount();
    }

    public static int getSmallest(float[] array){
        int smallest = 0;
        for(int i=1;i<array.length-1;i++){
            if(array[i] < array[smallest]){
                smallest = i;
            }
        }
        return smallest;
    }

    public static void calcBestPieceAmount(){
        float gridRatios[]  = new float[(2*awayFromPieceAmount)+1];
        float pieceRatios[] = new float[(2*awayFromPieceAmount)+1];
        for(int i=-awayFromPieceAmount;i<=awayFromPieceAmount;i++){
            float temp = gridRatio;
            calcGridRatio(piecesAmount+i);
            gridRatios[i+awayFromPieceAmount] = gridRatio;
            pieceRatios[i+awayFromPieceAmount] = gridRatio/(float)picRatio;
            gridRatio = temp;

            if(pieceRatios[i+awayFromPieceAmount] < 1){
                pieceRatios[i+awayFromPieceAmount] *= -1;
                pieceRatios[i+awayFromPieceAmount]++;
            }else if(pieceRatios[i+awayFromPieceAmount] > 1){
                pieceRatios[i+awayFromPieceAmount]--;
            }
        }
        System.out.println("Best piece amout: "+(piecesAmount-awayFromPieceAmount+getSmallest(pieceRatios)));
        piecesAmount += getSmallest(pieceRatios)-awayFromPieceAmount;
        calcGridRatio();
        System.out.println("Grid Ratio: "+gridRatio);

    }

    public static void calcPictureRatio(){
        picRatio =  Math.max(imageHeight,imageWidth)/Math.min(imageHeight,imageWidth);
    }

    public static void calcPieceRatio(){
        pieceRatio = picRatio/gridRatio;
        //Math.max(picRatio,gridRatio) / (float)Math.min(picRatio,gridRatio);
    }

    public static void calcGridRatio(){
        calcGridRatio(piecesAmount);
    }

    public static void calcGridRatio(int newPiecesAmount){
        int xPieces; int yPieces;
        for(int i=2;i<newPiecesAmount/2;i++){
            if(newPiecesAmount%i == 0){
                yPieces = i;
                xPieces = newPiecesAmount/i;
                
                float tmpGridRatio  = gridRatio;
                float tmpPieceRatio = pieceRatio;
                gridRatio = Math.max(yPieces,xPieces)/(float)Math.min(yPieces,xPieces);
                calcPieceRatio();
                if(pieceRatio < tmpPieceRatio){
                    gridRatio = tmpGridRatio;
                }else if(pieceRatio > tmpPieceRatio){
                    piecesWidth = xPieces;
                    piecesHeight= yPieces;
                    continue;
                }
            }
        }
    }

}