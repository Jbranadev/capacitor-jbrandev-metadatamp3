package com.jbrandev.capacitor.metadatamp3;

import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.util.Log;

import com.getcapacitor.JSObject;
import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.Base64;

public class metadatamp3 {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }

    /**
     * Removes the "file://" prefix from the given URI string, if applicable.
     * If the given URI string doesn't have a "file://" prefix, it is returned unchanged.
     *
     * @param uriString the URI string to operate on
     * @return a path without the "file://" prefix
     */
    public static String stripFileProtocol(String uriString) {
        if (uriString.startsWith("file://")) {
            return Uri.parse(uriString).getPath();
        }
        return uriString;
    }

    public JSObject getMetaData(String ruta)  {
        JSObject metadata = new JSObject();
        try {
            MediaMetadataRetriever fuente=new MediaMetadataRetriever();
            fuente.setDataSource(stripFileProtocol(ruta));
            File archivoMp3=new File(stripFileProtocol(ruta));
            Log.i("MetaDataMp3", "Creo la instancia File");
            if(archivoMp3.exists()){
                Log.i("MetaDataMp3", "Archivo MP3 Existe");
            }


            Log.i("MetaDataMp3", "Obtuvo las tags del archivo MP3 ");
            //ArrayList<JSObject> arrayMetaData=new ArrayList<>();
            ArrayList<MetaData> arrayMetaData=new ArrayList<>();
            ArrayList<JSObject> data=new ArrayList<>();
            String imagen= null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                imagen = Base64.getEncoder().encodeToString(fuente.getEmbeddedPicture());
            }
            arrayMetaData.add(new MetaData("Duracion", fuente.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)));
            //arrayMetaData.add(new MetaData("Imagen",  imagen));
            arrayMetaData.add(new MetaData("Album", fuente.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM)));
            arrayMetaData.add(new MetaData("Artist", fuente.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST)));
            arrayMetaData.add(new MetaData("Year", fuente.extractMetadata(MediaMetadataRetriever.METADATA_KEY_YEAR)));
            arrayMetaData.add(new MetaData("Track", fuente.extractMetadata(MediaMetadataRetriever.METADATA_KEY_CD_TRACK_NUMBER)));
            arrayMetaData.add(new MetaData("Disk", fuente.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DISC_NUMBER)));
            arrayMetaData.add(new MetaData("Composer", fuente.extractMetadata(MediaMetadataRetriever.METADATA_KEY_COMPOSER)));
            arrayMetaData.add(new MetaData("ArtistSort", fuente.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUMARTIST)));
            arrayMetaData.add(new MetaData("Title", fuente.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE)));

            Log.i("MetaDataMp3", "Tags del archivo MP3 ");
            for (MetaData meta:arrayMetaData) {
                Log.i("MetaDataMp3", "Nombre: "+ meta.getName());
                Log.i("MetaDataMp3", "Value: "+ meta.getValue());
                JSObject temp=new JSObject(new Gson().toJson(meta));
                data.add(temp);
            }
            Log.i("MetaDataMp3", "Data enviada a Capacitor desde Android: "+arrayMetaData.size());
            Log.i("MetaDataMp3", "Data enviada a Capacitor desde Android: "+data.size());
            metadata.put("data",data);

        }catch (Exception e){
            Log.e("MetaDataMp3", "Error capturado al leer el archivo MP3 ");
            this.printError(e);
        }
        return metadata;
    }


    private void printError(Exception e){
        Log.e("MetaDataMp3", "Error capturado al leer el archivo MP3 ");
        Log.e("MetaDataMp3", ""+e.getClass());
        Log.e("MetaDataMp3", e.getMessage());
        Log.e("MetaDataMp3", ""+e.getCause());
        Log.e("MetaDataMp3", e.getLocalizedMessage());
        Log.e("MetaDataMp3", ""+e.getStackTrace());
    }
}
