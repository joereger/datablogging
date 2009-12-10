package reger.Media;

import reger.mega.*;


public class MediaTypeFactory {
    /**
     * Accepts a fieldtype and returns a FieldType handler object.
     */
    public static MediaType getHandlerByFileExtension(String fileExtension){

        //This is essentially a registry of all MediaType handlers
        MediaType[] mediaTypes = new MediaType[22];
        mediaTypes[0]=new BitmapImage();
        mediaTypes[1]=new QuicktimeMov();
        mediaTypes[2]=new MpegVideo();
        mediaTypes[3]=new PolarHRM();
        mediaTypes[4]=new mp3Audio();
        mediaTypes[5]=new JpegImage();
        mediaTypes[6]=new GifImage();
        mediaTypes[7]=new PngImage();
        mediaTypes[8]=new AviVideo();
        mediaTypes[9]=new MsExcel();
        mediaTypes[10]=new MsPowerpoint();
        mediaTypes[11]=new MsProject();
        mediaTypes[12]=new MsWordDoc();
        mediaTypes[13]=new AdobePdf();
        mediaTypes[14]=new Html();
        mediaTypes[15]=new Visio();
        mediaTypes[16]=new Zip();
        mediaTypes[17]=new Photoshop();
        mediaTypes[18]=new Exe();
        mediaTypes[19]=new PureVoiceAudio();
        mediaTypes[20]=new ThreeGTwoMov();
        mediaTypes[20]=new WmvVideo();

        //Iterate the mediaType objects
        for (int i = 0; i < mediaTypes.length; i++) {
            //Get the array of acceptable file extensions for this mediaType
            String[] exts = mediaTypes[i].getAcceptableFileExtensions();
            //Iterate the acceptable extensions
            for (int j = 0; j < exts.length; j++) {
                if(exts[j].equalsIgnoreCase(fileExtension)){
                    //This one's a match
                    return mediaTypes[i];
                }
            }

        }

        //If you still haven't found the correct extension, send back a handler for unknown file types.
        return new UnknownFileType();
    }
}


