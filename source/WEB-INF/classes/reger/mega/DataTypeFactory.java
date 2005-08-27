package reger.mega;

/**
 * Returns a DataType
 */
public class DataTypeFactory {

    public static DataType get(int DATATYPEID){

        if (DATATYPEID==reger.mega.DataTypeDatetime.DATATYPEID){
            return new reger.mega.DataTypeDatetime();
        } else if (DATATYPEID==reger.mega.DataTypeString.DATATYPEID){
            return new reger.mega.DataTypeString();
        } else if (DATATYPEID==reger.mega.DataTypeDecimal.DATATYPEID){
            return new reger.mega.DataTypeDecimal();
        } else if (DATATYPEID==reger.mega.DataTypeInteger.DATATYPEID){
            return new reger.mega.DataTypeInteger();
        }

        return null;
    }


}
